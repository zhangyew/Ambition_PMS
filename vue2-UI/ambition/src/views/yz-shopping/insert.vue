<template>
  <div class="app-container">
    <div
      class="header"
      style="height: 50px;background-color: white;"
    >
      <div style="height: 50px; line-height: 20px;">
        <div style="float: left;">
          <img
            src="@/assets/logo/Inbound_list.png"
            alt="donate"
            width="40px"
            style="margin: 6px 10px -11px 30px;"
          />
          <span>收货单</span>
        </div>
        <div style="float: left;padding: 9px 0px 0px 1291px;">
          <el-button
            type="primary"
            @click="submitForm"
          >确 定</el-button>
        </div>
      </div>

    </div>
    <div>
      <div class="boxs">
        <div class="top">
          <h1>收货单新建</h1>
        </div>
        <div
          class="section_bos"
          style="border-radius: 3px;"
        >
          <div style="
            height: 50px;
            background-color: white;
            border-left: 7px rgb(45, 183, 245) solid;
          ">
            <h3 style="padding: 15px; font-weight: 600">收货基本信息</h3>
          </div>
          <el-form
            :model="formDates"
            ref="vForm"
            label-position="left"
            label-width="150px"
            size="medium"
            @submit.native.prevent
            style="background-color: white;border-radius: 9px"
          >
            <el-row>
              <el-col
                :span="8"
                class="grid-cell"
                style="padding: 10px 0px 0px 23px;"
              >
                <el-form-item
                  label="收货单号"
                  prop="receiptClod"
                  class="required"
                >
                  <el-input
                    type="text"
                    v-model="formDates.receiptClod"
                    clearable
                    style="width: 250px;"
                    :readonly="true"
                  ></el-input>
                  <el-input
                    v-model="formDates.orderMaterialId"
                    type="text"
                    clearable
                    style="width: 250px; display: none;"
                  ></el-input>
                </el-form-item>
                <el-form-item
                  label="收货总数量"
                  prop="receiptNumber"
                  class="required"
                >
                  <el-input
                    type="text"
                    v-model="formDates.receiptNumber"
                    clearable
                    style="width: 250px;"
                    :readonly="true"
                  >
                  {{formDates.receiptNumber}}
                  </el-input>

                </el-form-item>
              </el-col>
              <el-col
                :span="8"
                class="grid-cell"
                style="padding: 10px 0px 0px 23px;"
              >
                <el-form-item
                  label="收货日期"
                  prop="receiptTime"
                  class="required"
                >
                  <el-input
                    type="text"
                    v-model="formDates.datePlusThreeDays"
                    clearable
                    style="width: 250px;"
                    :readonly="true"
                  >

                  </el-input>
                </el-form-item>
                <el-form-item
                  label="收货金额"
                  prop="receiptMoney"
                  class="required"
                >
                  <el-input
                    v-model="formDates.totalMoney"
                    type="text"
                    clearable
                    style="width: 250px;"
                    :readonly="true"
                  ></el-input>
                </el-form-item>

                <el-form-item
                  label="质检人"
                  prop="orderPurchaser"
                >
                  <el-input
                    v-model="formDates.orderPurchaser"
                    type="text"
                    clearable
                    style="width: 250px;"
                    :readonly="true"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col
                :span="8"
                class="grid-cell"
                style="padding: 10px 0px 0px 23px;"
              >
                <el-form-item
                  label="收货人"
                  class="required"
                  prop="receiptBy"
                >
                  <el-input
                    v-model="formDates.receiptBy"
                    type="text"
                    clearable
                    style="width: 250px;"
                  ></el-input>
                </el-form-item>
                <el-form-item
                  label="收货备注"
                  class="required"
                  prop="remark"
                >
                  <el-input
                    v-model="formDates.remark"
                    type="text"
                    clearable
                    style="width: 250px;"
                  ></el-input>
                </el-form-item>
                <el-form-item
                  label="收货仓库"
                  class="receiptWarehouseId"
                  prop="receiptWarehouseId"
                >
                  <el-select
                    v-model="formDates.receiptWarehouseId"
                    placeholder="请选择"
                  >
                    <el-option
                      v-for="item in listWarehouse"
                      :key="item.warehouseId"
                      :value="item.warehouseId"
                      :label="item.warehouseName"
                    >
                      {{item.warehouseName}}
                    </el-option>
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>
          </el-form>
        </div>
        <div class="section_bos2">
          <div style="
            height: 50px;
            background-color: white;
            border-left: 7px rgb(45, 183, 245) solid;
          ">
            <h3 style="padding: 15px; font-weight: 600">供货方</h3>
          </div>
          <el-form
            ref="vForm"
            label-position="left"
            label-width="150px"
            size="medium"
            @submit.native.prevent
            style="background-color: white;border-radius: 9px"
          >
            <el-row>
              <el-col
                :span="8"
                class="grid-cell"
                style="padding: 10px 0px 0px 23px;"
              >
                <el-form-item
                  label="供应商"
                  prop="receiptVendorId"
                  class="required"
                >
                  <el-input
                    v-model="formDates.orderSupplierId"
                    type="text"
                    clearable
                    style="width: 250px; display: none;"
                  ></el-input>
                  <el-input
                    v-model="formDates.publicVendor.abbreviated"
                    type="text"
                    clearable
                    style="width: 250px;"
                    :readonly="true"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col
                :span="8"
                class="grid-cell"
                style="padding: 10px 0px 0px 23px;"
              >
                <el-form-item
                  label="联系人"
                  prop="responsible"
                >
                  <el-input
                    v-model="formDates.publicVendor.responsible"
                    type="text"
                    clearable
                    style="width: 250px;"
                    :readonly="true"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col
                :span="8"
                class="grid-cell"
                style="padding: 10px 0px 0px 23px;"
              >
                <el-form-item
                  label="联系电话"
                  prop="responsiblePhone"
                  class="required"
                >
                  <el-input
                    v-model="formDates.publicVendor.responsiblePhone"
                    type="text"
                    clearable
                    style="width: 250px;"
                    :readonly="true"
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-form>

        </div>
        <div
          class="footer"
          style="background-color: white;height: 200px;border-radius: 12px;"
        >
          <div style="
            height: 50px;
            background-color: white;
            border-left: 7px rgb(45, 183, 245) solid;
            margin-bottom: 15px;
          ">
            <h3 style="padding: 15px; font-weight: 600">收货明细信息</h3>
          </div>
          <el-table
            ref="tb"
            :data="manifestList"
            style="width: 100%;padding: 1px 0px 1px 13px;"
            :row-class-name="rowClassName"
          >

            <el-table-column
              type="selection"
              width="30"
              align="center"
            />
            <el-table-column
              label="序号"
              align="center"
              prop="xh"
              width="50"
            />
            <el-table-column
              label="物料编号"
              align="center"
              prop="goodsCode"
              width="200"
            >
              <template slot-scope="scope">
                <el-input
                  v-model="scope.row.publicGoods.goodsCode"
                  :readonly="true"
                > </el-input>
              </template>
            </el-table-column>

            <el-table-column
              label="物料名称"
              align="center"
              prop="goodsName"
              width="200"
            >
              <template slot-scope="scope">
                <el-input
                  v-model="scope.row.publicGoods.goodsName"
                  :readonly="true"
                ></el-input>
              </template>
            </el-table-column>

            <el-table-column
              label="物料分类"
              align="center"
              prop="categoryName"
              width="200"
            >
              <template slot-scope="scope">
                <el-input
                  v-model="scope.row.publicCategory.categoryName"
                  :readonly="true"
                ></el-input>
              </template>
            </el-table-column>

            <el-table-column
              label="计量单位"
              align="center"
              prop="grade"
              width="200"
            >
              <template slot-scope="scope">
                <el-select
                  v-model="scope.row.publicGoods.goodsType"
                  placeholder="请选择单位"
                >
                  <el-option
                    :disabled="true"
                    v-for="dict in dict.type.goods_unit"
                    :key="dict.value"
                    :label="dict.label"
                    :value="parseInt(dict.value)"
                  ></el-option>
                </el-select>
              </template>
            </el-table-column>

            <el-table-column
              label="需求数量"
              align="center"
              prop="exempt"
              width="110"
            >
              <template slot-scope="scope">
                <el-input-number
                  :disabled="true"
                  v-model="scope.row.demandCount"
                  class="full-width-input"
                  controls-position="right"
                  :min="1"
                  :max="100000000000"
                  :precision="0"
                  :step="1"
                >
                </el-input-number>
              </template>
            </el-table-column>
            <el-table-column
              label="发货数量"
              prop="exempt"
              width="110"
            >
              <template slot-scope="scope">
              <el-input-number
                :disabled="true"
                v-model="scope.row.demandCount"
                class="full-width-input"
                controls-position="right"
                :min="1"
                :max="100000000000"
                :precision="0"
                :step="1"
              >
              </el-input-number>
              </template>
            </el-table-column>
            <el-table-column
              label="收货数量"
              align="center"
              prop="receipt_Count"
              width="110"
            >
              <el-input-number
                v-model="receipt_Count"
                class="full-width-input"
                controls-position="right"
                :min="1"
                :max="100000000000"
                :precision="0"
                :step="1"

              >
              </el-input-number>
            </el-table-column>
            <el-table-column
              label="总金额"
              align="center"
              prop="price"
              width="100"
            >
              <el-input
                v-model="price"
                :readonly="true"
              ></el-input>
            </el-table-column>
          </el-table>

        </div>

      </div>
    </div>
  </div>
</template>

<script>
import { showsDetailsReceipt, updateOrderState , updateExamine} from "@/api/shopping/orders";
import { listWarehouse } from "@/api/public/warehouse";
import { addReceipt } from "@/api/shopping/receipt";
import { showDemand } from "@/api/shopping/demand";
import { upConState , upCon } from "../../api/bidding/contractdetails";

export default {
  dicts: ["goods_unit"],
  data() {
    return {
      // 收货基本信息
      formDates: [],
      id: null,
      Num_count: 0,
      MaterialId: null,
      //物料信息
      manifestList: [],
      //仓库下拉框
      listWarehouse: [],
      //单价
      price: 0,
      //收货数量
      receipt_Count: 0,
      //发货数量
      // faReceipt_Count: 0,
      contractId:0
    };
  },
  created() {
    this.id = this.$route.query.orderId;
    this.Num_count = this.$route.query.count;
    this.MaterialId = this.$route.query.MaterialId;
    this.contractId =this.$route.query.contractId;
    this.getDates();
    this.getDepots();
    this.getShowDemand();
  },
  watch: {
    manifestList: {
      handler(val) {
        console.log("val:", val);
        let coun = 0;
        val.forEach((item) => {
          coun += item.demandCount;
        });
        this.formDates.receiptNumber= coun;
      }
    },
  },
  methods: {
    getDates() {
      let orderId = this.id;
      showsDetailsReceipt(orderId).then((response) => {
        this.formDates = response.data;
        this.formDates.receiptNumber = this.Num_count;
      });
    },
    getDepots() {
      listWarehouse(null).then((response) => {
        this.listWarehouse = response.rows;
      });
    },
    submitForm() {
      let receiptTime = this.formDates.datePlusThreeDays;
      let receiptMoney = this.formDates.totalMoney;
      let receiptVendorId = this.formDates.orderSupplierId;
      let contact = this.formDates.publicVendor.responsible;
      let receiptPhone = this.formDates.publicVendor.responsiblePhone;
      let receiptOrdersId = this.id;
      let receiptBy = this.formDates.receiptBy;
      let remark = this.formDates.remark;
      let receiptWarehouseId = this.formDates.receiptWarehouseId;
      let fd = new FormData();
      fd.append("receiptTime", receiptTime);
      fd.append("receiptNumber", this.formDates.receiptNumber);
      fd.append("receiptMoney", receiptMoney);
      fd.append("receiptVendorId", receiptVendorId);
      fd.append("contact", contact);
      fd.append("receiptPhone", receiptPhone);
      fd.append("receiptOrdersId", receiptOrdersId);
      fd.append("receiptBy", receiptBy);
      fd.append("remark", remark);
      fd.append("receiptWarehouseId", receiptWarehouseId);
      addReceipt(fd).then((response) => {
        this.$modal.msgSuccess("收货单成功");
        updateOrderState(receiptOrdersId).then((response) => {
        });
        upCon(this.contractId).then((response) =>{});
        this.$router.push({ path: "/index", name: "index_receipt" });
      });
    },
    getShowDemand() {
      let MaterialIdArray = this.MaterialId.split(",");
      MaterialIdArray.forEach((element) => {
        showDemand(element).then((response) => {
          console.log(response);
          this.manifestList.push(response.data);
          let money = response.data.budgetAmount * response.data.demandCount;
          this.price = money;
          let rc=response.data.demandCount;
          this.receipt_Count= rc;
          // let fC = response.data.demandCount;
          // this.faReceipt_Count = fC;
          // console.log("显示：" + this.receipt_Count );
        });
      });
    },
    // handInputCount(receipt_Count) {
    //   // alert(receipt_Count);
    //   alert("发货数量：" + this.faReceipt_Count);
    //   if (this.faReceipt_Count < receipt_Count) {
    //     alert("收货数量不能大于发货数量！！！");
    //     this.receipt_Count = 0;
    //   }
    // },
    // row是行对象，rowindex是行号，从0开始。所以这样就能实现了序号(xh属性)递增并且取值为行号加1。
    rowClassName({ row, rowIndex }) {
      row.xh = rowIndex + 1;
    },
  },
};
</script>

<style scoped lang="scss">
.app-container {
  background-color: rgb(241, 244, 248);
  height: 100%;

  .boxs {
    // background-color: rgb(250, 250, 253);
    margin: 1px 144px 0px 144px;
    height: 100%;

    .top {
      background-color: white;
      height: 100px;
      text-align: center;
      border-radius: 12px;

      h1 {
        padding: 32px 0px;
        color: rgb(95, 157, 236);
      }
    }
  }
}

// .hz {
//   margin: 0 auto;
//   width: 1100px;
//   height: 100%;
// }

// .hz .dx {
//   font-size: 18px;
// }
// .hz .wenz {
//   padding: 0px 60px 0px 62px !important;
//   font-size: 18px;
//   font-weight: 700;
// }
</style>
