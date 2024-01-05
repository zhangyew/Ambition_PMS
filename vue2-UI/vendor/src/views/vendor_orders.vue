<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="订单标题" prop="orderTitle">
        <el-input v-model="queryParams.orderTitle" placeholder="请输入订单标题" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="订单编号" prop="orderNumber">
        <el-input v-model="queryParams.orderNumber" placeholder="请输入订单编号" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="订单状态" prop="vendorState">
        <el-select v-model="queryParams.vendorState" placeholder="请选择订单状态" clearable>
          <el-option v-for="dict in dict.type.vendor_order_state" :key="dict.value" :label="dict.label"
            :value="dict.value" />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="ordersList">
      <!-- <el-table-column type="selection" width="55" align="center" /> -->
      <el-table-column label="订单编号" align="center" prop="orderNumber" />
      <el-table-column label="订单标题" align="center" prop="orderTitle" :show-overflow-tooltip="true" />
      <el-table-column label="采购人" align="center" prop="orderPurchaser" />
      <el-table-column label="合同总金额" align="center" prop="contractdetailsAmount" />
      <el-table-column label="订单说明" align="center" prop="orderContext" :show-overflow-tooltip="true" />
      <el-table-column label="订单状态" align="center" prop="vendorState">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.vendor_order_state" :value="scope.row.vendorState" />
        </template>
      </el-table-column>
      <!-- <el-table-column label="创建人" align="center" prop="createBy" /> -->
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button type="text" icon="el-icon-view" @click="seeInfo(scope.row.orderId)">查看</el-button>
          <el-button v-if="scope.row.vendorState== 0" type="text" icon="el-icon-s-check"
            @click="checkState(scope.row.orderId)">验收</el-button>
        </template>
      </el-table-column>
    </el-table>
    <pagination v-show="total>0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
      @pagination="getList" />
    <!-- 详细页面 -->
    <el-dialog :title="title" :visible.sync="open" width="1200px" append-to-body>
      <el-form ref="formData" :model="formData" label-position="left" label-width="150px" size="medium"
        @submit.native.prevent :readonly="true">
        <el-row style="margin-top: 15px">
          <el-col :span="12" class="grid-cell" style="padding: 0px 0px 0px 95px;">
            <el-form-item label="订单标题" prop="orderTitle" class="required">
              <el-input v-model="formData.orderTitle" type="text" clearable style="width: 300px;" :readonly="true" />
            </el-form-item>
            <el-form-item label="订单编号" prop="orderNumber">
              <el-input v-model="formData.orderNumber" type="text" clearable style="width: 300px;"
                :readonly="true"></el-input>
            </el-form-item>
            <el-form-item label="合同编号" prop="ordeContractId">
              <el-input v-model="htBh" type="text" clearable style="width: 300px;" :readonly="true"></el-input>
            </el-form-item>
            <el-form-item label="合同名称">
              <el-input v-model="htMc" type="text" clearable style="width: 300px;" :readonly="true"></el-input>
            </el-form-item>
            <el-form-item label="合同总金额" prop="contractdetailsAmount">
              <el-input v-model="formData.contractdetailsAmount" type="text" clearable style="width: 300px;"
                :readonly="true"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12" class="grid-cell">
            <el-form-item label="客户">
              <el-input type="text" clearable style="width: 300px;" :readonly="true" value="远志集团有限公司"></el-input>
            </el-form-item>
            <el-form-item label="是否自提" prop="isZt">
              <el-radio-group v-model="formData.isZt" :disabled="true">
                <el-radio :label="0">否</el-radio>
                <el-radio :label="1">是</el-radio>
              </el-radio-group>
            </el-form-item>
            <el-form-item label="自提车牌号" prop="carNumber" class="required">
              <el-input v-model="formData.carNumber" type="text" clearable style="width: 300px;"
                :disabled="formData.isZt === 0" :readonly="true"></el-input>
            </el-form-item>
            <el-form-item label="自提司机联系方式" prop="driverPhone" class="required">
              <el-input v-model="formData.driverPhone" type="text" clearable style="width: 300px;"
                :disabled="formData.isZt === 0" :readonly="true"></el-input>
            </el-form-item>
            <el-form-item label="配送地址" class="required">
              <el-input type="text" clearable style="width: 300px;" value="远志集团公司一楼签收处" :disabled="formData.isZt === 1"
                :readonly="true"></el-input>
            </el-form-item>
            <el-form-item label="订单说明" prop="orderContext" class="required">
              <el-input v-model="formData.orderContext" type="text" clearable style="width: 300px;"
                :readonly="true"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <div style="
         height: 50px;
         background-color: rgb(250, 250, 253);
         border-left: 3px rgb(45, 183, 245) solid;
       ">
          <h3 style="padding: 15px; font-weight: 600">订单物料信息</h3>
        </div>
        <el-row style="margin: 0px 69px">
          <el-table :data="DemandList" ref="tb">
            <el-table-column type="selection" width="100" align="center" />
            <!-- <el-table-column label="序号" align="center" prop="xh" width="100" /> -->
            <el-table-column align="center" label="物料编码" width="220">
              <template slot-scope="scope">
                <el-input type="text" :value="scope.row.publicGoods.goodsCode" :readonly="true">
                  <i slot="suffix" class="el-input__icon el-icon-search"></i>
                </el-input>
              </template>
            </el-table-column>
            <el-table-column label="物料名称" align="center" prop="goodsName" width="160">
              <template slot-scope="scope">
                <el-input type="text" :value="scope.row.publicGoods.goodsName" :readonly="true">
                </el-input>
              </template>
            </el-table-column>
            <el-table-column label="物料品类" align="center" prop="categoryName" width="170">
              <template slot-scope="scope">
                <el-input type="text" :value="scope.row.publicCategory.categoryName" :readonly="true">
                </el-input>
              </template>
            </el-table-column>
            <el-table-column label="物料单位" align="center" width="120">
              <template slot-scope="scope">
                <dict-tag :disabled="true" :options="dict.type.goods_unit"
                  :value="scope.row.bidTenderManifest.manifestTypeId" />
              </template>
            </el-table-column>
            <el-table-column label="需求数量" align="center" width="120" prop="demand_count">
              <template slot-scope="scope">
                <el-input v-model="scope.row.bidTenderManifest.explains" :readonly="true" />
              </template>
            </el-table-column>
            <el-table-column label="预算单价" align="center" width="120" prop="budget_amount">
              <template slot-scope="scope">
                <el-input v-model="scope.row.bidTenderManifest.price" :readonly="true" />
              </template>
            </el-table-column>
            <el-table-column label="行预算金额" align="center" width="120">
              <!-- 计算出来 -->
              <template slot-scope="scope" v-model="scope.row.bidTenderManifest.prices">
                <!-- <el-input  /> -->
                {{scope.row.bidTenderManifest.prices}}
              </template>
            </el-table-column>
            <el-table-column label="备注" align="center" prop="remark" width="150">
              <template slot-scope="scope">
                <el-input v-model="scope.row.bidTenderManifest.remark" :readonly="true" />
              </template>
            </el-table-column>
          </el-table>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <!-- <el-button type="primary" @click="submitForm">确 定</el-button> -->
        <el-button type="primary" @click="$router.back()">返回</el-button>
      </div>
    </el-dialog>
    <!-- 验收状态改变 -->
    <el-dialog :title="title" :visible.sync="opens" width="400px" append-to-body>
      <el-form ref="forms" :model="forms" label-width="150px">
        <el-form-item label="验收结果" prop="vendorState" style="width: 600px;">
          <el-select v-model="forms.vendorState" placeholder="请确定验收结果!">
            <el-option v-for="dict in dict.type.vendor_order_state" :key="dict.value" :label="dict.label"
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
    showSupplierId,updateExamine1
  } from "@/api/shopping/orders";
  import GoodsView from '@/components/Goods'
  import {
    getOrders,
  } from "@/api/shopping/orders";
  import {
    getContractdetails,
  } from "@/api/bidding/contractdetails";
  import {
    SHowsProjectRelatedItems
  } from "@/api/bidding/tender_projects";
  import { showUid } from "@/api/public/vendor";
  export default {
    name: "Orders",
    dicts: ['vendor_order_state', 'goods_unit'],
    data() {
      return {
        // 遮罩层
        loading: true,
        // 显示搜索条件
        showSearch: true,
        // 总条数
        total: 0,
        // 采购订单表表格数据
        ordersList: [],
        // 弹出层标题
        title: "",
        // 是否显示弹出层
        open: false,
        opens: false,
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          orderTitle: null,
          orderNumber: null,
          vendorState: null,
        },
        addOrUpdateVisible: false,
        goods: {},
        //合同编号
        htBh: "",
        //合同名称
        htMc: "",
        forms: {
          orderId:0,
          vendorState: 0
        },
        formData: {
          orderId: "",
          requireId: "",
          buyPlanId: "",
          orderTitle: "",
          orderSource: "",
          orderNumber: "",
          orderPurchaser: "",
          totalMoney: "",
          isZt: "",
          carNumber: "",
          driverPhone: "",
          ordeContractId: "",
          orderContext: "",
          contractdetailsAmount: "",
          orderSupplierId: "",
          vendorName: "",
          vendorContacts: "",
          orderMaterialId: "",
          typeOrderState: "",
          shoppingDemands: []
        },
        DemandList: [],
        userId: "",
      };
    },
    created() {
      let userId = localStorage.getItem("userId");
      showUid(userId).then((response) => {
      console.log("显示我uid：" + userId);
      console.log(response);
      this.userId = response.data.vendorId;
      this.getList();
    });
      // this.getList();
    },
    filters: {},
    methods: {
      /** 查询采购订单表列表 */
      getList() {
        this.loading = true;
        let oSupplierId = this.userId;
        showSupplierId(oSupplierId).then((response) => {
          // console.log("显示我的订单：" + JSON.stringify(response.rows));
          this.ordersList = response.rows;
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
          vendorState: null,
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
      /** 查看操作 */
      seeInfo(id) {
        this.reset();
        // const orderId = row.orderId || this.ids
        // console.log(id);
        getOrders(id).then(response => {
          this.formData = response.data;
          this.open = true;
          this.title = "查看订单";
          let vv = null;
          let ci = 0;
          getContractdetails(response.data.ordeContractId).then(response => {
            let res = response.data;
            //合同编号
            this.htBh = res[0].contractdetailsNumber;
            // console.log(htBh);
            //合同名称
            this.htMc = res[0].contractdetailsName;
            vv = res[0].vendorId;
            ci = res[0].tenderProjectsId;
            //显示合同物料信息
            SHowsProjectRelatedItems(ci, vv).then((response) => {
              // console.log("物料:" + JSON.stringify(response));
              this.DemandList = response.rows;
              this.ht = true;
            });
          });
        });
      },
      // 验收
      checkState(id) {
        this.reset();
        // const orderId = row.orderId || this.ids
        console.log(id);
        getOrders(id).then(response => {
          this.forms.orderId=response.data.orderId;
          this.forms = response.data;
          this.opens = true;
          this.title = "验收";
        });
      },
      /**
       * 审批修改审批状态
       */
      examine() {
        this.$refs["forms"].validate(valid => {
          // console.log("valid:" + valid);
          updateExamine1(this.forms).then(response => {
            this.$modal.msgSuccess("成功");
            this.opens = false;
            this.getList();
          });
        });
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
