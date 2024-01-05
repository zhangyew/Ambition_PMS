<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="需求编码" prop="requireNumber">
        <el-input v-model="queryParams.requireNumber" placeholder="请输入采购需求编码" clearable
          @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="需求类型" prop="requireType">
        <el-select v-model="queryParams.requireType" placeholder="请选择需求类型" clearable>
          <el-option v-for="dict in dict.type.require_type" :key="dict.value" :label="dict.label" :value="dict.value" />
        </el-select>
      </el-form-item>
      <el-form-item label="需求状态" prop="requireState">
        <el-select v-model="queryParams.requireState" placeholder="请选择需求状态" clearable>
          <el-option v-for="dict in dict.type.require_state" :key="dict.value" :label="dict.label"
            :value="dict.value" />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>
    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <router-link class="link-type" :to="{name:'insInfo'}">
          <el-button type="primary" plain icon="el-icon-plus" size="mini">新增</el-button>
        </router-link>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport"
          v-hasPermi="['shopping/pro_require:pro_require:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="pro_requireList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="100%" align="center" />
      <el-table-column label="需求编号" align="center" prop="requireNumber" width="160px">
        <template slot-scope="scope">
          <router-link class="link-type" :to="{name:'reInfo',params:{ rids: ''+scope.row.requireId }}">
            {{scope.row.requireNumber}}
          </router-link>
        </template>
      </el-table-column>
      <el-table-column label="是否需要招标" align="center" prop="isTender" width="100px">
        <template slot-scope="scope">
          <span>{{ scope.row.isTender | parseZB }}</span>
        </template>
      </el-table-column>
      <el-table-column label="需求人" align="center" prop="requirePerson" width="100%"/>
      <el-table-column label="需求部门" align="center" prop="requireDept" width="100%"/>
      <el-table-column label="需求类型" align="center" prop="requireType" width="170px">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.require_type" :value="scope.row.requireType" />
        </template>
      </el-table-column>
      <el-table-column label="供货供应商" align="center" prop="vendorName" width="170px">
        <template slot-scope="scope">
          <span>{{ scope.row.vendorName |parseVe}}</span>
        </template>
      </el-table-column>
      <el-table-column label="总金额" align="center" prop="totalMoney" width="100%"/>
      <el-table-column label="状态" align="center" prop="requireState" width="100%">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.require_state" :value="scope.row.requireState" />
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width" width="180px">
        <template slot-scope="scope">
          <router-link class="link-type" :to="{name:'info1',params:{ resource: '0',rid:''+scope.row.requireId }}">
            <el-button v-if="scope.row.requireState == 1&& scope.row.isTender==0" size="mini" type="text"
              icon="el-icon-printer" class="btn btn-default">生成采购订单</el-button>
          </router-link>
          <router-link class="link-type" :to="{name:'/bidding-system/tender_projects/insert',params:{ pid: ''+scope.row.requireId }}">
            <el-button v-if="scope.row.requireState == 1&& scope.row.isTender==1" size="mini" type="text"
              icon="el-icon-s-promotion" class="btn btn-default">去招标</el-button>
          </router-link>
          <router-link class="link-type" :to="{name:'insInfo',params:{ reId: ''+scope.row.requireId }}">
            <el-button v-if="[0,2].includes(scope.row.requireState)" size="mini" type="text"
              icon="el-icon-edit">修改</el-button>
          </router-link>
          <el-button v-if="[0,2].includes(scope.row.requireState)" size="mini" type="text" icon="el-icon-s-check"
            @click="handleExamine(scope.row)" v-hasPermi="['shopping/pro_require:pro_require:examine']">审批</el-button>
          <el-button v-if="scope.row.requireState == 3" size="mini" type="text" icon="el-icon-lock">无可行操作</el-button>
        </template>
      </el-table-column>
    </el-table>
    <pagination v-show="total>0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
      @pagination="getList" />

    <!-- 审批对话框 -->
    <el-dialog :title="title" :visible.sync="opens" width="800px" append-to-body>
      <el-form ref="forms" :model="forms" label-width="150px">
        <el-form-item label="审批状态" prop="requireState" style="width: 400px;">
          <el-select v-model="forms.requireState" placeholder="请确定审批结果!">
            <el-option v-for="dict in dict.type.require_state" :key="dict.value" :label="dict.label"
              :value="parseInt(dict.value)"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="examine">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  import {
    listPro_require,
    getPro_require,
    delPro_require,
    addPro_require,
    updatePro_require,
    updateExamine
  } from "@/api/shopping/pro_require";

  export default {
    name: "Pro_require",
    dicts: ['require_state', 'require_type', 'sys_normal_disable'],
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
        // 采购需求表表格数据
        pro_requireList: [],
        // 弹出层标题
        title: "",
        // 是否显示弹出层
        open: false,
        opens: false,
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          requireType: null,
          requireState: null,
          requireNumber: null,
        },
        //详细list
        bcglXiangXiList: [],
        //选中的从表数据
        checkedDetail: [],

        // 表单参数
        form: {},
        // 审批表单参数
        forms: {},
        // 表单校验
        rules: {
          requirePerson: [{
            required: true,
            message: "需求人不能为空",
            trigger: "blur"
          }],
          requireDept: [{
            required: true,
            message: "需求部门不能为空",
            trigger: "blur"
          }],
          requireType: [{
            required: true,
            message: "需求类型不能为空",
            trigger: "change"
          }],
          totalMoney: [{
            required: true,
            message: "总金额不能为空",
            trigger: "blur"
          }],
          requireContact: [{
            required: true,
            message: "收货联系人不能为空",
            trigger: "blur"
          }],
          requireState: [{
            required: true,
            message: "状态不能为空",
            trigger: "change"
          }],
        }
      };
    },
    created() {
      this.getList();
    },
    filters: {
      parseZB(value) {
        if (value == 0) {
          return '/';
        } else if (value == 1) {
          return '需要';
        }
      },
      parseVe(value) {
        // console.log(value);
        if (value === "" || value === null || value === "null") {
          return '/';
        } else {
          return value;
        }
      }
    },
    methods: {
      /** 查询采购需求表列表 */
      getList() {
        this.loading = true;
        listPro_require(this.queryParams).then(response => {
          // console.log("listPro_require:", response.rows)
          this.pro_requireList = response.rows;
          // console.log("111:" + JSON.stringify(response.rows));
          this.total = response.total;
          this.loading = false;
        });
      },
      // 取消按钮
      cancel() {
        this.open = false;
        this.opens = false;
        this.reset();
      },
      // 表单重置
      reset() {
        this.form = {
          requireId: null,
          requireDemandId: null,
          requireNumber: null,
          requirePerson: null,
          requireDept: null,
          requireType: null,
          totalMoney: null,
          requireVendor: null,
          requireContact: null,
          mainPurpose: null,
          requireAddress: null,
          requirePhone: null,
          requireState: null,
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
        this.ids = selection.map(item => item.requireId)
        this.single = selection.length !== 1
        this.multiple = !selection.length
      },
      // /** 新增按钮操作 */
      // handleAdd() {
      //   this.$router.push("/yz-shopping/pro_require/insert");
      // },
      /** 修改按钮操作 */
      handleUpdate(row) {
        this.reset();
        const requireId = row.requireId || this.ids
        getPro_require(requireId).then(response => {
          this.form = response.data;
          this.open = true;
          this.title = "修改采购需求表";
        });
      },
      /** 审批按钮操作 */
      handleExamine(row) {
        this.reset();
        const requireId = row.requireId || this.ids
        getPro_require(requireId).then(response => {
          this.forms = response.data;
          this.open = false;
          this.opens = true;
          this.title = "进行审批";
        });
      },
      /**
       * 审批修改审批状态
       */
      examine() {
        console.log("状态!!:" + JSON.stringify(this.forms));
        updateExamine(this.forms).then(response => {
          this.$modal.msgSuccess("成功");
          this.opens = false;
          this.getList();
        });
      },
      /** 导出按钮操作 */
      handleExport() {
        this.download('shopping/pro_require/export', {
          ...this.queryParams
        }, `pro_require_${new Date().getTime()}.xlsx`)
      },
      // row是行对象，rowindex是行号，从0开始。所以这样就能实现了序号(xh属性)递增并且取值为行号加1。
      rowClassName({
        row,
        rowIndex
      }) {
        row.xh = rowIndex + 1;
      },
      //单选框选中数据
      chandleDetailSelectionChange(selection) {
        if (selection.length > 1) {
          this.$refs.tb.clearSelection();
          this.$refs.tb.toggleRowSelection(selection.pop());
        } else {
          this.checkedDetail = selection;
        }
      },

      // 添加一行
      handleAddDetails() {
        if (this.bcglXiangXiList == undefined) {
          this.bcglXiangXiList = new Array();
        }
        let obj = {};
        this.bcglXiangXiList.push(obj);
      },
      // 删除
      handleDeleteDetails() {
        if (this.checkedDetail.length == 0) {
          this.$alert("请先选择要删除的数据", "提示", {
            confirmButtonText: "确定",
          });
        } else {
          this.bcglXiangXiList.splice(this.checkedDetail[0].xh - 1, 1);
        }
      },
      //清空
      handleDeleteAllDetails() {
        this.bcglXiangXiList = undefined;
      },

    }
  };
</script>
