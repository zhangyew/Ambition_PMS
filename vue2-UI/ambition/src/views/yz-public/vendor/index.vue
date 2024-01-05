<template>
  <!-- 搜索 -->
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="编号" prop="vendorNumber">
        <el-input v-model="queryParams.vendorNumber" placeholder="请输入供应商编号" clearable
          @keyup.enter.native="handleQuery" />
      </el-form-item>

      <el-form-item label="服务范围" prop="range">
        <el-input v-model="queryParams.range" placeholder="请输入服务范围" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>

      <el-form-item label="银行卡号" prop="industrialCommercial">
        <el-input v-model="queryParams.industrialCommercial" placeholder="请输入银行卡号" clearable
          @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>



    <!-- tabs标签 -->
    <template>
      <el-tabs v-model="activeName" @tab-click="handleClick">
        <el-tab-pane label="全部" name="second"></el-tab-pane>
        <el-tab-pane label="未注册" name="firsts"></el-tab-pane>
        <el-tab-pane label="已注册" name="fourth"></el-tab-pane>
        <el-tab-pane label="已审批" name="first"></el-tab-pane>
        <el-tab-pane label="已拒绝" name="third"></el-tab-pane>

      </el-tabs>
      <!-- 增删改按钮 -->
      <el-row :gutter="10" class="mb8" style="float: right;">
        <!-- <el-col :span="1.5">
          <el-button type="primary" plain size="mini" @click="handleAdd"
            v-hasPermi="['bidding/public:vendor:add']">注册供应商</el-button>
        </el-col> -->
        <el-col :span="1.5">
          <el-button type="primary" plain size="mini" @click="enroll">
            注册供应商
            <!--  <template>
              <router-link :to="{name:'/enroll'}">添加</router-link>
            </template> -->
          </el-button>
        </el-col>
        <el-col :span="1.5">
          <el-button type="success" plain size="mini" :disabled="single" @click="handleUpdate"
            v-hasPermi="['bidding/public:vendor:edit']">修改</el-button>
        </el-col>

        <el-col :span="1.5">
          <el-button type="info" plain size="mini" v-model="showSearch" @click="ss">高级搜索</el-button>
        </el-col>
      </el-row>
    </template>

    <!-- 默认查询 -->
    <div>
      <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" label-width="68px">
        <el-form-item label="简称" prop="abbreviated">
          <el-input v-model="queryParams.abbreviated" @blur="selects" style="width: 120px;" placeholder="请输入简称"
            clearable @keyup.enter.native="handleQuery" />
        </el-form-item>
        <el-form-item label="合同类型" prop="contractTypeTypeId">
          <el-select v-model="queryParams.contractTypeTypeId" style="width: 140px;" placeholder="请选择合同类型" clearable>
            <el-option v-for="dict in dict.type.contract_type" @click.native="selects" :key="dict.value"
              :label="dict.label" :value="dict.value" />
          </el-select>
        </el-form-item>
        <el-form-item label="状态" prop="vendorTypeStateId">
          <el-select v-model="queryParams.vendorTypeStateId" style="width: 140px;" placeholder="请选择状态" clearable>
            <el-option v-for="dict in dict.type.vendor_state" @click.native="selects" :key="dict.value"
              :label="dict.label" :value="dict.value" />
          </el-select>
        </el-form-item>
        <el-form-item label="注册时间">
          <el-date-picker v-model="daterangeAddTime" @blur="selects" style="width: 240px" value-format="yyyy-MM-dd"
            type="daterange" range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期"></el-date-picker>
        </el-form-item>
      </el-form>
    </div>

    <!-- 数据显示 -->
    <el-table v-loading="loading" @row-click="dj" :data="vendorList" @selection-change="handleSelectionChange"
      :row-class-name="tableRowClassName">
      <el-table-column type="selection" width="55" align="center" />
      <!-- <el-table-column label="供应商ID" align="center" prop="vendorId" /> -->
      <el-table-column label="邀请时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime, '{y}-{m}-{d} {h}:{mi}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="供应商名称" align="center" prop="abbreviated">
        <template slot-scope="scope">
          <el-link @click="findInfo(scope.row.vendorId)" type="primary">{{scope.row.abbreviated}}</el-link>
        </template>
      </el-table-column>
      <el-table-column label="银行卡号" align="center" prop="industrialCommercial" />
      <el-table-column label="供应商编号" align="center" prop="vendorNumber" />
      <el-table-column label="服务范围" align="center" prop="ranges" />
      <el-table-column label="注册时间" align="center" prop="addTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.addTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="注册状态" align="center" prop="vendorTypeStateId">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.vendor_state" :value="scope.row.vendorTypeStateId" />
        </template>
      </el-table-column>
      <el-table-column label="负责人" align="center" prop="responsible" />
      <el-table-column label="操作" align="center" prop="vendorTypeStateId" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button v-if="scope.row.vendorTypeStateId==3" size="mini" type="text"
            @click="findInfo(scope.row.vendorId)">查看详情</el-button>
          <el-button v-if="scope.row.vendorTypeStateId!=4" size="mini" type="text" icon="el-icon-edit"
            @click="handleUpdate(scope.row)" v-hasPermi="['bidding/public:vendor:edit']">修改</el-button>
          <el-button v-if="scope.row.vendorTypeStateId==4" size="mini" type="text" icon="el-icon-delete"
            @click="handleDelete(scope.row)" v-hasPermi="['bidding/public:vendor:remove']">删除</el-button>
          <span v-if="scope.row.vendorTypeStateId!=3">
            <el-button size="mini" type="text" icon="el-icon-s-check" v-hasPermi="['bidding/public:vendor:zhuce']"
              @click="opens=true">注册</el-button>
          </span>
        </template>
      </el-table-column>
    </el-table>

    <!-- 审批--修改状态弹窗 -->
    <el-dialog :title="title" :visible.sync="opens" width="500px" append-to-body>
      <el-form label-width="150px">
        <el-form-item label="供应商注册" prop="requireState" style="width: 400px;">
          <el-select v-model="jg" placeholder="请确定结果">
            <el-option v-for="dict in dict.type.vendor_state" :key="dict.value" :label="dict.label"
              :value="parseInt(dict.value)"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="xgzt">确 定</el-button>
        <el-button @click="opens=false">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 分页组件 -->
    <pagination v-show="total>0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
      @pagination="getList" />

    <!-- 添加或修改供应商对话框 -->
    <el-drawer :title="title" :visible.sync="open" width="500px" append-to-body :before-close="handleClose">
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="供应商编号" prop="vendorNumber">
          <el-input v-model="form.vendorNumber" placeholder="请输入供应商编号" />
        </el-form-item>
        <el-form-item label="简称" prop="abbreviated">
          <el-input v-model="form.abbreviated" placeholder="请输入简称" />
        </el-form-item>
        <el-form-item label="字典类型" prop="contractTypeTypeId">
          <el-select v-model="form.contractTypeTypeId" placeholder="请选择字典类型">
            <el-option v-for="dict in dict.type.contract_type" :key="dict.value" :label="dict.label"
              :value="parseInt(dict.value)"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="状态" prop="vendorTypeStateId">
          <el-select v-model="form.vendorTypeStateId" placeholder="请选择状态">
            <el-option v-for="dict in dict.type.vendor_state" :key="dict.value" :label="dict.label"
              :value="parseInt(dict.value)"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="服务范围" prop="range">
          <el-input v-model="form.range" placeholder="请输入服务范围" />
        </el-form-item>
        <el-form-item label="原因" prop="cause">
          <el-input v-model="form.cause" placeholder="请输入原因" />
        </el-form-item>
        <el-form-item label="仓库地址" prop="warehouseAddress">
          <el-input v-model="form.warehouseAddress" placeholder="请输入仓库地址" />
        </el-form-item>
        <el-form-item label="简介" prop="profile">
          <el-input v-model="form.profile" placeholder="请输入简介" />
        </el-form-item>
        <el-form-item label="法定代表人" prop="delegates">
          <el-input v-model="form.delegates" placeholder="请输入法定代表人" />
        </el-form-item>
        <el-form-item label="注册时间" prop="addTime">
          <el-date-picker clearable v-model="form.addTime" type="date" value-format="yyyy-MM-dd" placeholder="请选择注册时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input v-model="form.email" placeholder="请输入邮箱" />
        </el-form-item>
        <el-form-item label="传真" prop="fax">
          <el-input v-model="form.fax" placeholder="请输入传真" />
        </el-form-item>
        <el-form-item label="负责人" prop="responsible">
          <el-input v-model="form.responsible" placeholder="请输入负责人" />
        </el-form-item>
        <el-form-item label="负责人手机" prop="responsiblePhone">
          <el-input v-model="form.responsiblePhone" placeholder="请输入负责人手机" />
        </el-form-item>
        <el-form-item label="工商注册号" prop="industrialCommercial">
          <el-input v-model="form.industrialCommercial" placeholder="请输入工商注册号" />
        </el-form-item>
        <el-form-item label="供应商信息是否存在" prop="isExist">
          <el-input v-model="form.isExist" placeholder="请输入供应商信息是否存在" />
        </el-form-item>
      </el-form>
      <div style="margin-left: 35%;">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-drawer>
  </div>
</template>

<script>
  import {
    listVendor,
    getVendor,
    delVendor,
    addVendor,
    updateVendor
  } from "@/api/public/vendor";
  import {
    getToken
  } from '../../../utils/auth';
  export default {
    name: "Vendor",
    dicts: ['contract_type', 'vendor_state'],
    data() {
      return {
        opens: false,
        // 修改控制
        drawer: false,
        // 遮罩层
        loading: true,
        // 选中数组
        ids: [],
        // 非单个禁用
        single: true,
        // 非多个禁用
        multiple: true,
        // 显示搜索条件
        showSearch: false,
        // 总条数
        total: 0,
        // 供应商表格数据
        vendorList: [],
        // 弹出层标题
        title: "",
        // 是否显示弹出层
        open: false,
        // 删除时间范围
        daterangeAddTime: [],
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          vendorNumber: null,
          abbreviated: null,
          contractTypeTypeId: null,
          vendorTypeStateId: null,
          isBlacklist: null,
          range: null,
          addTime: null,
          industrialCommercial: null,
          isDelete: null
        },
        // 表单参数
        form: {},
        // 表单校验
        rules: {},
        jg: null,
        rowid: null,
        activeName: 'second'
      };
    },
    created() {
      this.getList();
    },
    methods: {
      findInfo(id) {
        this.$router.push({
          path: '/vendor-system/vendor/info',
          query: {
            vid: id
          }
        })
      },
      enroll(row) {
        // this.reset();
        this.$router.push({
          path: '/vendor-system/vendor/enroll',
          query: {
            vid: null
          }
        })
      },
      xgzt() {

        this.opens = false;
        console.log("ID：" + this.rowid)
        let thet = this;
        let fd = new FormData();
        fd.append("id", this.rowid)
        fd.append("zt", this.jg)
        axios.post('/dev-api/bidding/vendor/updateStates', fd, {
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
        this.rowid = row.vendorId
      },
      tableRowClassName({
        row,
        rowIndex
      }) {
        if (rowIndex % 2 === 0) {
          return '' //这是类名
        } else {
          return 'success-row'
        }
      },
      handleClose(done) {
        this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {});
      },
      /** 查询供应商列表 */
      getList() {
        this.loading = true;
        this.queryParams.params = {};
        if (null != this.daterangeAddTime && '' != this.daterangeAddTime) {
          this.queryParams.params["beginAddTime"] = this.daterangeAddTime[0];
          this.queryParams.params["endAddTime"] = this.daterangeAddTime[1];
        }
        listVendor(this.queryParams).then(response => {
          this.vendorList = response.rows;
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
          vendorId: null,
          vendorNumber: null,
          abbreviated: null,
          contractTypeTypeId: null,
          vendorTypeStateId: null,
          isBlacklist: null,
          range: null,
          cause: null,
          warehouseAddress: null,
          profile: null,
          delegates: null,
          addTime: null,
          email: null,
          fax: null,
          responsible: null,
          responsiblePhone: null,
          industrialCommercial: null,
          createBy: null,
          createTime: null,
          updateBy: null,
          updateTime: null,
          isExist: null,
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
        this.daterangeAddTime = [];
        this.resetForm("queryForm");
        this.handleQuery();
      },
      // 多选框选中数据
      handleSelectionChange(selection) {
        this.ids = selection.map(item => item.vendorId)
        this.single = selection.length !== 1
        this.multiple = !selection.length
      },
      /** 新增按钮操作 */
      handleAdd() {
        this.reset();
        this.open = true;
        this.title = "添加供应商";
      },
      /** 修改按钮操作 */
      handleUpdate(row) {

        this.$router.push({
          path: '/vendor-system/vendor/enroll',
          query: {
            vid: row.vendorId
          }
        })

      },
      /** 提交按钮 */
      submitForm() {
        this.$refs["form"].validate(valid => {
          if (valid) {
            if (this.form.vendorId != null) {
              updateVendor(this.form).then(response => {
                this.$modal.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              });
            } else {
              addVendor(this.form).then(response => {
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
        const vendorIds = row.vendorId || this.ids;
        this.$modal.confirm('是否确认删除供应商编号为"' + vendorIds + '"的数据项？').then(function() {
          return delVendor(vendorIds);
        }).then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        }).catch(() => {});
      },
      /** 导出按钮操作 */
      handleExport() {
        this.download('bidding/public/vendor/export', {
          ...this.queryParams
        }, `vendor_${new Date().getTime()}.xlsx`)
      },
      ss() {
        if (this.showSearch == true) {
          this.showSearch = false
        } else {
          this.showSearch = true;
        }
      },
      selects() {
        this.queryParams.pageNum = 1;
        this.getList();
      },
      handleClick(tab, event) {
        this.queryParams.vendorTypeStateId = tab.index;
        if (tab.index === '0') {
          this.queryParams.vendorTypeStateId = null;
          this.queryParams.pageNum = 1;
        }
        this.getList();
      }
    }
  };
</script>
<style>
  .success-row {
    background-color: #f4f4f4 !important;

  }
</style>
