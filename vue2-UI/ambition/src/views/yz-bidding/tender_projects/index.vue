<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="项目名称" prop="tenderProjectsName">
        <el-input v-model="queryParams.tenderProjectsName" placeholder="请输入项目名称" clearable
          @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="审核状态" prop="auditState">
        <el-select v-model="queryParams.auditState" placeholder="请输入审核状态" clearable>
          <el-option v-for="dict in dict.type.require_state" :key="dict.value" :label="dict.label"
            :value="parseInt(dict.value)"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="创建时间">
        <el-date-picker v-model="daterangeCreatTime" style="width: 240px" value-format="yyyy-MM-dd" type="daterange"
          range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期"></el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">

        <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd">新增</el-button>
      </el-col>

      <el-col :span="1.5">
        <el-button type="danger" plain icon="el-icon-delete" size="mini" :disabled="multiple" @click="handleDelete"
          v-hasPermi="['pms/bidding:tender_projects:remove']">删除</el-button>
      </el-col>

      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="tender_projectsList" @row-click="dj" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="项目编号" align="center" prop="tenderProjectsNumber" width="200" />
      <el-table-column label="项目名称" align="center" prop="tenderProjectsName" />
      <el-table-column label="业务类型" align="center" prop="projectsType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.projects_type" :value="scope.row.projectsType" />
        </template>
      </el-table-column>
      <el-table-column label="项目预算" align="center" prop="tenderProjectsMoney">
        <template slot-scope="scope">
          {{scope.row.tenderProjectsMoney|formattedAmount}}
        </template>
      </el-table-column>
      <el-table-column label="项目负责人" align="center" prop="tenderProjectsContact" />
      <el-table-column label="电话" align="center" prop="tenderProjectsPhone" />

      <el-table-column label="招标方式" align="center" prop="manner">
        <template slot-scope="scope">
          {{scope.row.auditState?'公开招标':'邀请招标'}}
        </template>
      </el-table-column>
      <el-table-column label="审核状态" align="center" prop="auditState">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.require_state" :value="scope.row.auditState" />
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" prop="auditState" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button v-if="scope.row.auditState==0" size="mini" type="text" icon="el-icon-edit"
            @click="handleUpdate(scope.row)" v-hasPermi="['pms/bidding:tender_projects:edit']">修改</el-button>
          <el-button v-if="scope.row.auditState==2" size="mini" type="text" icon="el-icon-delete"
            @click="handleDelete(scope.row)" v-hasPermi="['pms/bidding:tender_projects:remove']">删除</el-button>
          <!-- <el-button v-if="scope.row.auditState==1" size="mini" type="text" @click="handleDelete(scope.row)"
            >进入项目</el-button> -->

          <router-link style="font-size: 14px;color: #1ca8ff;"
            v-if="scope.row.auditState===1 || scope.row.auditState===4" target="_blank"
            :to="'/bidding/'+scope.row.tenderProjectsId+'&'+scope.row.auditState">进入项目</router-link>


          <div v-if="scope.row.auditState==0 || scope.row.auditState==2">
     <!--       <el-button v-hasPermi="['bidding/tender_projects:shenhe']" size="mini" type="text" icon="el-icon-s-check"
              @click="opens=true">审批</el-button> -->
              <el-button  size="mini" type="text" icon="el-icon-s-check"
                @click="opens=true">审批</el-button>
          </div>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
      @pagination="getList" />

    <!-- 审批--修改状态弹窗 -->
    <el-dialog :title="title" :visible.sync="opens" width="500px" append-to-body>
      <el-form label-width="150px">
        <el-form-item label="审批状态" prop="requireState" style="width: 400px;">
          <el-select v-model="jg" placeholder="请确定审批结果">
            <el-option v-for="dict in dict.type.require_state" :key="dict.value" :label="dict.label"
              :value="parseInt(dict.value)"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="xgzt">确 定</el-button>
        <el-button @click="opens=false">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  import {
    listTender_projects,
    getTender_projects,
    delTender_projects,
    addTender_projects,
    updateTender_projects
  } from "@/api/bidding/tender_projects";
  import {
    getToken
  } from '../../../utils/auth';
  export default {
    name: "Tender_projects",
    dicts: ['projects_type', 'require_state'],
    data() {
      return {
        // 遮罩层
        loading: true,
        // 选中数组
        ids: [],
        jg: null,
        rowid: null,
        opens: false,
        // 非单个禁用
        single: true,
        // 非多个禁用
        multiple: true,
        // 显示搜索条件
        showSearch: true,
        // 总条数
        total: 0,
        // 招标项目表格数据
        tender_projectsList: [],
        // 弹出层标题
        title: "",
        // 是否显示弹出层
        open: false,
        // 删除时间范围
        daterangeCreatTime: [],
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          tenderProjectsName: null,
          auditState: null,
          creatTime: null,
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
    filters: {
      formattedAmount(value) {
        return new Intl.NumberFormat("zh-CN", {
          style: "currency",
          currency: "CNY",
        }).format(value);
      },
    },
    methods: {
      xgzt() {
        this.opens = false;
        console.log("ID：" + this.rowid)
        let thet = this;
        let fd = new FormData();
        fd.append("id", this.rowid)
        fd.append("zt", this.jg)
        axios.post('/dev-api/bidding/tender_projects/updateStates', fd, {
            headers: {
              'Authorization': `Bearer ${getToken()}`,
              'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
            },
          })
          .then(response => {
            if (response.data == 1) {
              this.$modal.msgSuccess("操作成功");
            }
            thet.getList();
          })
          .catch(error => {
            // 处理错误
          });

      },
      dj(row) {
        this.rowid = row.tenderProjectsId
      },
      /** 查询招标项目列表 */
      getList() {
        this.loading = true;
        this.queryParams.params = {};
        if (null != this.daterangeCreatTime && '' != this.daterangeCreatTime) {
          this.queryParams.params["beginCreatTime"] = this.daterangeCreatTime[0];
          this.queryParams.params["endCreatTime"] = this.daterangeCreatTime[1];
        }
        listTender_projects(this.queryParams).then(response => {
          this.tender_projectsList = response.rows;
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
          tenderProjectsId: null,
          tenderProjectsNumber: null,
          tenderProjectsName: null,
          projectsType: null,
          tenderProjectsMoney: null,
          tenderProjectsContact: null,
          tenderProjectsPhone: null,
          tenderProjectsAddress: null,
          tenderProjectsEmail: null,
          remark: null,
          manner: null,
          censor: null,
          must: null,
          auditState: null,
          creatBy: null,
          creatTime: null,
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
        this.daterangeCreatTime = [];
        this.resetForm("queryForm");
        this.handleQuery();
      },
      // 多选框选中数据
      handleSelectionChange(selection) {
        this.ids = selection.map(item => item.tenderProjectsId)
        this.single = selection.length !== 1
        this.multiple = !selection.length
      },
      /** 新增按钮操作 */
      handleAdd() {
        this.$router.push({
          path: '/bidding-system/tender_projects/insert',
          query: {
            vid: null
          }
        })
      },
      /** 修改按钮操作 */
      handleUpdate(row) {
        this.$router.push({
          path: '/bidding-system/tender_projects/insert',
          query: {
            vid: row.tenderProjectsId
          }
        })
      },
      /** 提交按钮 */
      submitForm() {
        this.$refs["form"].validate(valid => {
          if (valid) {
            if (this.form.tenderProjectsId != null) {
              updateTender_projects(this.form).then(response => {
                this.$modal.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              });
            } else {
              addTender_projects(this.form).then(response => {
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
        const tenderProjectsIds = row.tenderProjectsId || this.ids;
        this.$modal.confirm('是否确认删除招标项目编号为"' + tenderProjectsIds + '"的数据项？').then(function() {
          return delTender_projects(tenderProjectsIds);
        }).then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        }).catch(() => {});
      },
      /** 导出按钮操作 */
      handleExport() {
        this.download('pms/bidding/tender_projects/export', {
          ...this.queryParams
        }, `tender_projects_${new Date().getTime()}.xlsx`)
      }
    }
  };
</script>
<style>
  /*  h1{
    background-color: #e7e7e7;
    display: block;
  } */
</style>
