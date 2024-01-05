<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">

      <el-form-item label="专家姓名" prop="name">
        <el-input v-model="queryParams.name" placeholder="请输入专家姓名" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="身份证" prop="idCard">
        <el-input v-model="queryParams.idCard" placeholder="请输入专家身份证" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="区域" prop="address">
        <el-input v-model="queryParams.address" placeholder="请输入区域" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="移动电话" prop="phone">
        <el-input v-model="queryParams.phone" placeholder="请输入移动电话" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd"
          v-hasPermi="['pms.public:expert:add']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="success" plain icon="el-icon-edit" size="mini" :disabled="single" @click="handleUpdate"
          v-hasPermi="['pms.public:expert:edit']">修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="danger" plain icon="el-icon-delete" size="mini" :disabled="multiple" @click="handleDelete"
          v-hasPermi="['pms.public:expert:remove']">删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport"
          v-hasPermi="['pms.public:expert:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="expertList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <!-- <el-table-column label="主键" align="center" prop="expertId" /> -->
      <el-table-column label="专家库主键" align="center" prop="poolId" />
      <el-table-column label="专家姓名" align="center" prop="name" />
      <el-table-column label="专家身份证" align="center" prop="idCard" />
      <el-table-column label="区域" align="center" prop="address" />
      <el-table-column label="移动电话" align="center" prop="phone" />
      <el-table-column label="修改时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime, '{y}-{m}-{d} {h}:{mi}:{s}') }}</span>
        </template>
      </el-table-column>
      <!-- <el-table-column label="删除" align="center" prop="isDelete" /> -->
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
            v-hasPermi="['pms.public:expert:edit']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
            v-hasPermi="['pms.public:expert:remove']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
      @pagination="getList" />

    <!-- 添加或修改专家对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="库主键" prop="poolId">
          <el-input v-model="form.poolId" placeholder="请输入专家库主键" />
        </el-form-item>
        <el-form-item label="专家姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入专家姓名" />
        </el-form-item>
        <el-form-item label="身份证" prop="idCard">
          <el-input v-model="form.idCard" placeholder="请输入专家身份证" />
        </el-form-item>
        <el-form-item label="区域" prop="address">
          <el-input v-model="form.address" placeholder="请输入区域" />
        </el-form-item>
        <el-form-item label="移动电话" prop="phone">
          <el-input v-model="form.phone" placeholder="请输入移动电话" />
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
    listExpert,
    getExpert,
    delExpert,
    addExpert,
    updateExpert
  } from "@/api/public/expert";

  export default {
    name: "Expert",
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
        // 专家表格数据
        expertList: [],
        // 弹出层标题
        title: "",
        // 是否显示弹出层
        open: false,
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          poolId: null,
          name: null,
          idCard: null,
          address: null,
          phone: null,
          isDelete: null
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
      /** 查询专家列表 */
      getList() {
        this.loading = true;
        listExpert(this.queryParams).then(response => {
          this.expertList = response.rows;
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
          expertId: null,
          poolId: null,
          name: null,
          idCard: null,
          address: null,
          phone: null,
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
        this.ids = selection.map(item => item.expertId)
        this.single = selection.length !== 1
        this.multiple = !selection.length
      },
      /** 新增按钮操作 */
      handleAdd() {
        this.reset();
        this.open = true;
        this.title = "添加专家";
      },
      /** 修改按钮操作 */
      handleUpdate(row) {
        this.reset();
        const expertId = row.expertId || this.ids
        getExpert(expertId).then(response => {
          this.form = response.data;
          this.open = true;
          this.title = "修改专家";
        });
      },
      /** 提交按钮 */
      submitForm() {
        this.$refs["form"].validate(valid => {
          if (valid) {
            if (this.form.expertId != null) {
              updateExpert(this.form).then(response => {
                this.$modal.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              });
            } else {
              addExpert(this.form).then(response => {
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
        const expertIds = row.expertId || this.ids;
        this.$modal.confirm('是否确认删除专家编号为"' + expertIds + '"的数据项？').then(function() {
          return delExpert(expertIds);
        }).then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        }).catch(() => {});
      },
      /** 导出按钮操作 */
      handleExport() {
        this.download('pms.public/expert/export', {
          ...this.queryParams
        }, `expert_${new Date().getTime()}.xlsx`)
      }
    }
  };
</script>