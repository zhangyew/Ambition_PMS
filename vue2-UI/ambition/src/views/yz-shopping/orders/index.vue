<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="订单标题" prop="orderTitle">
        <el-input v-model="queryParams.orderTitle" placeholder="请输入订单标题" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="订单编号" prop="orderNumber">
        <el-input v-model="queryParams.orderNumber" placeholder="请输入订单编号" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="订单来源" prop="orderSource">
        <el-select v-model="queryParams.orderSource" placeholder="请选择订单来源" clearable>
          <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value" />
        </el-select>
      </el-form-item>
      <el-form-item label="订单状态" prop="typeOrderState">
        <el-select v-model="queryParams.typeOrderState" placeholder="请选择订单状态" clearable>
          <el-option v-for="dict in dict.type.type_order_state" :key="dict.value" :label="dict.label"
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
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport"
          v-hasPermi="['shopping/orders:orders:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="ordersList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <!-- <el-table-column label="订单号" align="center" prop="orderId" /> -->
      <el-table-column label="订单编号" align="center" prop="orderNumber" width="180px">
        <template slot-scope="scope">
          <router-link :to="{name:'information',params:{resource: '1',oid:''+scope.row.orderId}}" class="link-type">
            {{scope.row.orderNumber}}
          </router-link>
        </template>
      </el-table-column>
      <el-table-column label="订单标题" align="center" prop="orderTitle" :show-overflow-tooltip="true" width="180px"/>
      <el-table-column label="订单来源" align="center" prop="orderSource"width="100%">
        <template slot-scope="scope">
          <span>{{ scope.row.orderSource | parseSource }}</span>
        </template>
      </el-table-column>
      <el-table-column label="采购人" align="center" prop="orderPurchaser" width="180px"/>
      <!-- <el-table-column label="总金额" align="center" prop="totalMoney" /> -->
      <el-table-column label="是否自提" align="center" prop="isZt"width="100%">
        <template slot-scope="scope">
          <span>{{ scope.row.isZt | parseZT }}</span>
        </template>
      </el-table-column>
      <el-table-column label="供应商" align="center" prop="vendorName" width="120px"/>
      <el-table-column label="创建时间" align="center" prop="createTime" :show-overflow-tooltip="true" />
      <el-table-column label="订单状态" align="center" prop="typeOrderState">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.type_order_state" :value="scope.row.typeOrderState" />
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button size="mini" type="text" icon="el-icon-s-check" @click="handleExamine(scope.row)" v-hasPermi="['shopping/orders:orders:examine']"
            v-if="[0,1,2,4].includes(scope.row.typeOrderState)">审批</el-button>
          <el-button size="mini" type="text" icon="el-icon-s-order" v-if="scope.row.typeOrderState==6" @click="jump">
            收货
          </el-button>
          <el-button v-if="scope.row.typeOrderState== 3" size="mini" type="text" icon="el-icon-lock">无可行操作</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
      @pagination="getList" />

    <!-- 审批对话框 -->
    <el-dialog :title="title" :visible.sync="opens" width="800px" append-to-body>
      <el-form ref="form" :model="form" label-width="150px">
        <el-form-item label="订单状态" prop="typeOrderState" style="width: 400px;">
          <el-select v-model="form.typeOrderState" placeholder="请选择订单状态">
            <el-option v-for="dict in dict.type.type_order_state" :key="dict.value" :label="dict.label"
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
    listOrders,
    getOrders,
    updateExamine
  } from "@/api/shopping/orders";

  export default {
    name: "Orders",
    dicts: ['type_order_state'],
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
        // 采购订单表表格数据
        ordersList: [],
        // 弹出层标题
        title: "",
        // 是否显示弹出层
        opens: false,
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          orderTitle: null,
          orderNumber: null,
          orderSource: null,
          typeOrderState: null,
        },
        // 表单参数
        form: {},
        //采购来源下拉框
        options: [{
          value: '0',
          label: '采购需求'
        }, {
          value: '1',
          label: '采购计划'
        }, {
          value: '2',
          label: '合同'
        }, ],

      };
    },
    created() {
      this.getList();
    },
    filters: {
      parseZT(value) {
        if (value == 0) {
          return '自提';
        } else if (value == 1) {
          return '配送';
        }
      },
      parseSource(value) {
        if (value == 0) {
          return '采购需求';
        } else if (value == 1) {
          return '采购计划';
        } else {
          return '合同';
        }
      },
    },
    methods: {
      /** 查询采购订单表列表 */
      getList() {
        this.loading = true;
        listOrders(this.queryParams).then(response => {
          this.ordersList = response.rows;
          this.total = response.total;
          this.loading = false;
        });
      },
      // 取消按钮
      cancel() {
        this.opens = false;
        this.reset();
      },
      // 表单重置
      reset() {
        this.form = {
          orderId: null,
          requireId: null,
          buyPlanId: null,
          orderTitle: null,
          orderSource: null,
          orderNumber: null,
          orderPurchaser: null,
          totalMoney: null,
          isZt: null,
          carNumber: null,
          driverPhone: null,
          ordeContractId: null,
          orderContext: null,
          contractdetailsAmount: null,
          orderSupplierId: null,
          orderMaterialId: null,
          typeOrderState: null,
          createBy: null,
          createTime: null,
          updateBy: null,
          updateTime: null,
          isDelete: null
        };
        this.resetForm("form");
      },
      /** 审批按钮操作 */
      handleExamine(row) {
        this.reset();
        const orderId = row.orderId || this.ids;
        console.log(orderId);
        getOrders(orderId).then(response => {
          // console.log("aaaa:" + JSON.stringify(response.data));
          this.form = response.data;
          this.opens = true;
          this.title = "审核状态";
        });
      },
      /**
       * 审批修改审批状态
       */
      examine() {
        this.$refs["form"].validate(valid => {
          // console.log("valid:" + valid);
          updateExamine(this.form).then(response => {
            this.$modal.msgSuccess("成功");
            this.opens = false;
            this.getList();
          });
        });
      },
      jump() {
        this.$router.push({
          path: "/index",
          name: "index_receipt"
        });
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
        this.ids = selection.map(item => item.orderId)
        this.single = selection.length !== 1
        this.multiple = !selection.length
      },
      /** 导出按钮操作 */
      handleExport() {
        this.download('shopping/orders/export', {
          ...this.queryParams
        }, `orders_${new Date().getTime()}.xlsx`)
      }
    }
  };
</script>
