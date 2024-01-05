<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="库名" prop="expertPoolName">
        <el-input v-model="queryParams.expertPoolName" placeholder="请输入库名" clearable
          @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="级别" prop="level">
        <el-input v-model="queryParams.level" placeholder="请输入级别" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="类别" prop="category">
        <el-input v-model="queryParams.category" placeholder="请输入类别" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd"
          v-hasPermi="['pms.public:expert_pool:add']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="success" plain icon="el-icon-edit" size="mini" :disabled="single" @click="handleUpdate"
          v-hasPermi="['pms.public:expert_pool:edit']">修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="danger" plain icon="el-icon-delete" size="mini" :disabled="multiple" @click="handleDelete"
          v-hasPermi="['pms.public:expert_pool:remove']">删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport"
          v-hasPermi="['pms.public:expert_pool:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="expert_poolList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键" align="center" prop="expertPoolId" />
      <el-table-column label="库名" align="center" prop="expertPoolName" />
    <el-table-column label="级别" align="center" prop="level">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.expert_pool_level" :value="scope.row.level" />
        </template>
      </el-table-column>
      <el-table-column label="类别" align="center" prop="category">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.pool_type" :value="scope.row.category" />
        </template>
      </el-table-column>
      <!-- <el-table-column label="修改人" align="center" prop="updateBy" /> -->
      <el-table-column label="修改时间" align="center" prop="updateTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.updateTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <!-- <el-table-column label="删除" align="center" prop="isDelete" /> -->
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
            v-hasPermi="['pms.public:expert_pool:edit']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
            v-hasPermi="['pms.public:expert_pool:remove']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
      @pagination="getList" />

    <!-- 添加或修改专家库对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="库名" prop="expertPoolName">
          <el-input v-model="form.expertPoolName" placeholder="请输入库名" />
        </el-form-item>
        <el-form-item label="级别" prop="level">
          <el-input v-model="form.level" placeholder="请输入级别" />
        </el-form-item>
        <el-form-item label="类别" prop="category">
          <el-input v-model="form.category" placeholder="请输入类别" />
        </el-form-item>
        <el-form-item label="删除" prop="isDelete">
          <el-input v-model="form.isDelete" placeholder="请输入删除" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  import {
    listExpert_pool,
    getExpert_pool,
    delExpert_pool,
    addExpert_pool,
    updateExpert_pool
  } from "@/api/public/expert_pool";

  export default {
     dicts: ['pool_type','expert_pool_level'],
    data() {
      return {
        // 遮罩层
        loading: true,
        // 选中数组
        ids: [],
        // 非单个禁用
        single: true,
        // 非多个禁用
        multiple: true,
        // 显示搜索条件
        showSearch: true,
        // 总条数
        total: 0,
        // 专家库表格数据
        expert_poolList: [],
        // 弹出层标题
        title: "",
        // 是否显示弹出层
        open: false,
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          expertPoolName: null,
          level: null,
          category: null,
        },
        // 表单参数
        form: {},
        // 表单校验
        rules: {}
      };
    },
    created() {
      this.getList();
    },
    methods: {
      /** 查询专家库列表 */
      getList() {
        this.loading = true;
        listExpert_pool(this.queryParams).then(response => {
          this.expert_poolList = response.rows;
          console.log(this.expert_poolList)
          this.total = response.total;
          this.loading = false;
        });
      },
      // 取消按钮
      cancel() {
        this.open = false;
        this.reset();
      },
      // 表单重置
      reset() {
        this.form = {
          expertPoolId: null,
          expertPoolName: null,
          level: null,
          category: null,
          createBy: null,
          createTime: null,
          updateBy: null,
          updateTime: null,
          isDelete: null
        };
        this.resetForm("form");
      },
      /** 搜索按钮操作 */
      handleQuery() {
        this.queryParams.pageNum = 1;
        this.getList();
      },
      /** 重置按钮操作 */
      resetQuery() {
        this.resetForm("queryForm");
        this.handleQuery();
      },
      // 多选框选中数据
      handleSelectionChange(selection) {
        this.ids = selection.map(item => item.expertPoolId)
        this.single = selection.length !== 1
        this.multiple = !selection.length
      },
      /** 新增按钮操作 */
      handleAdd() {
        this.reset();
        this.open = true;
        this.title = "添加专家库";
      },
      /** 修改按钮操作 */
      handleUpdate(row) {
        this.reset();
        const expertPoolId = row.expertPoolId || this.ids
        getExpert_pool(expertPoolId).then(response => {
          this.form = response.data;
          this.open = true;
          this.title = "修改专家库";
        });
      },
      /** 提交按钮 */
      submitForm() {
        this.$refs["form"].validate(valid => {
          if (valid) {
            if (this.form.expertPoolId != null) {
              updateExpert_pool(this.form).then(response => {
                this.$modal.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              });
            } else {
              addExpert_pool(this.form).then(response => {
                this.$modal.msgSuccess("新增成功");
                this.open = false;
                this.getList();
              });
            }
          }
        });
      },
      /** 删除按钮操作 */
      handleDelete(row) {
        const expertPoolIds = row.expertPoolId || this.ids;
        this.$modal.confirm('是否确认删除专家库编号为"' + expertPoolIds + '"的数据项？').then(function() {
          return delExpert_pool(expertPoolIds);
        }).then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        }).catch(() => {});
      },
      /** 导出按钮操作 */
      handleExport() {
        this.download('pms.public/expert_pool/export', {
          ...this.queryParams
        }, `expert_pool_${new Date().getTime()}.xlsx`)
      }
    }
  };
</script>
