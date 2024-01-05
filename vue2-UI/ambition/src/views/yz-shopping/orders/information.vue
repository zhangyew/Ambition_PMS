<template>
  <div class="app-container">
    <div class="boxs">
      <div class="top">
        <div id="top_img" style="width: 100px; float: left">
          <img src="@/assets/logo/logo2.jpg" alt="donate" height="100px" width="230px" />
        </div>
        <h1>采购订单登记</h1>
        <div style="float: right;margin-top: 30px;margin-right: 30px;">
          <el-button type="primary" @click="$router.back()">返回</el-button>
        </div>
      </div>
      <div class="section_bos">
        <div style="
            height: 50px;
            background-color: rgb(250, 250, 253);
            border-left: 3px rgb(45, 183, 245) solid;
          ">
          <h3 style="padding: 15px; font-weight: 600">基本信息</h3>
        </div>
        <el-form ref="formData" :model="formData" label-position="left" label-width="150px" size="medium"
          @submit.native.prevent :readonly="true">
          <el-row style="margin-top: 15px">
            <el-col :span="12" class="grid-cell" style="padding: 0px 0px 0px 95px;">
              <el-form-item label="订单标题" prop="orderTitle" class="required">
                <el-input v-model="formData.orderTitle" type="text" clearable style="width: 300px;" :readonly="true" />
              </el-form-item>
              <el-form-item label="订单状态" prop="sector" class="typeOrderState">
                <el-select v-model="formData.typeOrderState" placeholder="请选择订单状态" :disabled="true">
                  <el-option v-for="dict in dict.type.type_order_state" :key="dict.value" :label="dict.label"
                    :value="parseInt(dict.value)"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="订单编号" prop="orderNumber">
                <el-input v-model="formData.orderNumber" type="text" clearable style="width: 300px;"
                  :readonly="true"></el-input>
              </el-form-item>
              <el-form-item label="订单来源" prop="orderSource">
                <el-radio-group v-model="formData.orderSource" :disabled="true">
                  <el-radio :label="0">采购需求</el-radio>
                  <el-radio :label="1">采购计划</el-radio>
                  <el-radio :label="2">合同</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="需求编号(需求表id)" prop="requireId">
                <el-input v-model="rqNumber" type="text" clearable style="width: 300px;"
                  :disabled="formData.orderSource !== 0" :readonly="true" />
              </el-form-item>
              <el-form-item label="计划编号(计划表id)" prop="buyPlanId">
                <el-input v-model="planNumber" type="text" clearable style="width: 300px;"
                  :disabled="formData.orderSource !== 1" :readonly="true" />
              </el-form-item>
              <el-form-item label="关联合同编号" prop="ordeContractId">
                <el-input v-model="htBh" type="text" clearable style="width: 300px;"
                  :disabled="formData.orderSource !== 2" :readonly="true"></el-input>
              </el-form-item>
              <el-form-item label="关联合同名称">
                <el-input v-model="htMc" type="text" clearable style="width: 300px;"
                  :disabled="formData.orderSource !== 2" :readonly="true"></el-input>
              </el-form-item>
              <el-form-item label="合同总金额" prop="contractdetailsAmount">
                <el-input v-model="formData.contractdetailsAmount" type="text" clearable style="width: 300px;"
                  :disabled="formData.orderSource !== 2" :readonly="true"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12" class="grid-cell">
              <el-form-item label="公司">
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
              <el-form-item label="采购员" prop="orderPurchaser">
                <el-input v-model="formData.orderPurchaser" type="text" clearable style="width: 300px;"
                  :readonly="true"></el-input>
              </el-form-item>
              <el-form-item label="计划/需求总金额" prop="totalMoney" class="required">
                <el-input v-model="formData.totalMoney" type="text" clearable style="width: 300px;":disabled="formData.orderSource == 2"
                  :readonly="true"></el-input>
              </el-form-item>
              <el-form-item label="订单说明" prop="orderContext" class="required">
                <el-input v-model="formData.orderContext" type="text" clearable style="width: 300px;"
                  :readonly="true"></el-input>
              </el-form-item>
              <el-form-item label="附件上传" prop="fileList">
                <el-upload ref="upload" class="upload-demo" :limit="2" accept=".doc, .docx,.rar,.txt" multiple
                  :action="upload.url" :headers="upload.headers" :file-list="upload.fileList" :auto-upload="false">
                  <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
                  <el-button style="margin-left: 10px;" size="small" type="success"
                    :loading="upload.isUploading">上传到服务器</el-button>
                  <div slot="tip" class="el-upload__tip">只能上传.doc, .docx,.rar,.txt文件，且不超过5MB</div>
                </el-upload>
              </el-form-item>
            </el-col>
          </el-row>
          <div style="height: 50px;background-color: rgb(250, 250, 253);border-left: 3px rgb(45, 183, 245) solid;">
            <h3 style="padding: 15px; font-weight: 600">供货方</h3>
          </div>
          <el-row style="margin-top: 15px">
            <el-col :span="12" class="grid-cell" style="padding: 0px 0px 0px 95px;">
              <el-form-item label="供应商名称" prop="orderSupplierId" class="required">
                <el-input v-model="formData.vendorName" type="text" clearable style="width: 300px;" :readonly="true" />
              </el-form-item>
            </el-col>
            <el-col :span="12" class="grid-cell" style="padding: 0px 0px 0px 95px;">
              <el-form-item label="联系人" prop="vendorContacts" class="required">
                <el-select v-model="formData.vendorContacts" placeholder="请选择联系人" style="width: 300px;"
                  :disabled="true">
                  <el-option v-for="con in contacts" :key="con.contactsId" :label="con.call"
                    :value="parseInt(con.contactsId)"></el-option>
                </el-select>
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
            <el-table :data="formData.shoppingDemands" ref="tb" :row-class-name="rowClassName" v-if="!ht">
              <!-- <el-table-column type="selection" width="30" align="center" /> -->
              <el-table-column label="序号" align="center" prop="xh" width="50"></el-table-column>
              <el-table-column label="物料编码" width="170">
                <template slot-scope="scope">
                  {{scope.row.publicGoods.goodsCode}}
                </template>
              </el-table-column>
              <el-table-column label="物料名称" align="center" prop="publicGoods.goodsName" width="150">
              </el-table-column>
              <el-table-column label="物料品类" align="center" prop="publicGoods.categoryName" width="150">
              </el-table-column>
              <el-table-column label="物料单位" align="center" width="100">
                <template slot-scope="scope">
                  <dict-tag :options="dict.type.goods_unit" :value="scope.row.publicGoods.goodsType" />
                </template>
              </el-table-column>
              <el-table-column label="需求数量" align="center" prop="demandCount" width="100">
                <template slot-scope="scope">
                  <!-- <el-input v-model="scope.row.demandCount" /> -->
                  {{scope.row.demandCount}}
                </template>
              </el-table-column>
              <el-table-column label="需求日期" width="170" prop="demand_time">
                <template slot-scope="scope">
                  {{scope.row.demandTime}}
                </template>
              </el-table-column>
              <el-table-column label="预算单价" align="center" prop="budgetAmount" width="100">
                <template slot-scope="scope">
                  <!-- <el-input v-model="scope.row.budgetAmount" /> -->
                  {{scope.row.budgetAmount}}
                </template>
              </el-table-column>
              <el-table-column label="行预算金额" align="center" width="100">
                <!-- 计算出来 -->
                <template slot-scope="scope" v-model="scope.row.totalPrice">
                  {{(scope.row.demandCount == null || scope.row.budgetAmount == null) ? 0 : ((scope.row.demandCount * scope.row.budgetAmount) * 10)/10}}
                </template>
              </el-table-column>
              <el-table-column label="备注" align="center" prop="remark" width="200">
                <template slot-scope="scope">
                  {{scope.row.remark}}
                </template>
              </el-table-column>
            </el-table>
            <el-table v-if="ht" :data="DemandList" :row-class-name="rowClassName" ref="tb">
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
      </div>
    </div>
  </div>
</template>

<script>
  import GoodsView from '@/components/Goods'
  import {
    getOrders,
  } from "@/api/shopping/orders";
  import {
    getToken
  } from "@/utils/auth";
  import {
    getBuy_plan
  } from "@/api/shopping/buy_plan";
  import {
    getVendor,
    showContactsList
  } from "@/api/public/vendor";
  import {
    getPro_require
  } from "@/api/shopping/pro_require";
  import {
    getContractdetails,
  } from "@/api/bidding/contractdetails";
  import {
    SHowsProjectRelatedItems
  } from "@/api/bidding/tender_projects";
  export default {
    dicts: ['type_order_state', 'goods_unit'],
    components: {},
    props: {},

    data() {
      return {
        //联系人
        contacts: {},
        addOrUpdateVisible: false,
        goods: {},
        //采购计划id
        planId: 0,
        planNumber: "",
        //采购需求id
        rqId: 0,
        //需求编号
        rqNumber: "",
        //合同编号
        htBh: "",
        //合同名称
        htMc: "",
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
        // 上传参数
        upload: {
          // 上传的文件列表
          fileList: [],
          // 是否禁用上传
          isUploading: false,
          // 设置上传的请求头部
          headers: {
            Authorization: "Bearer " + getToken()
          },
          // 上传的地址
          url: "/dev-api/shopping/orders/uploadFiles",
        },
        returnFile: [],
        bcglXiangXiList: [],
        //选中的从表数据
        checkedDetail: [],
        DemandList: [],
        ht: false,
      };
    },
    computed: {},
    components: {},
    watch: {},
    created() {
      let resource = this.$route.params.resource;
      let oid = this.$route.params.oid;
      // console.log("aaaa:" + JSON.stringify(oid));
      let vendorId = null;
      getOrders(oid).then(response => {
        // console.log("aaaa:" + JSON.stringify(response.data));
        vendorId = response.data.orderSupplierId;
        this.formData = response.data;
        this.formData.shoppingDemands = response.data.shoppingDemands;
        //文件回显
        response.data.publicAnnexs.forEach(i => {
          console.log(i);
          let file = {
            name: i.annexTitle,
            url: i.annexUrl
          }
          this.upload.fileList.push(file);
        })
        // console.log(this.upload.fileList);
        //查询计划编号
        if (response.data.buyPlanId != null) {
          getBuy_plan(response.data.buyPlanId).then(response => {
            this.planNumber = response.data.planClod;
          });
        }
        //查询需求编号
        if (response.data.requireId != null) {
          getPro_require(response.data.requireId).then(response => {
            this.rqNumber = response.data.requireNumber;
          });
        }
        //查询订单编号
        if (response.data.ordeContractId != null) {
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
        }
        let fd = new FormData();
        //查询联系人
        fd.append("vendorId", vendorId)
        axios.post('/dev-api/bidding/vendor/showContactsList', fd, {
            headers: {
              'Authorization': `Bearer ${getToken()}`,
              'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
            },
          })
          .then(response => {
            this.contacts = response.data.rows[0].publicContactsList;
          })
      });
    },
    mounted() {},
    methods: {
      // row是行对象，rowindex是行号，从0开始。所以这样就能实现了序号(xh属性)递增并且取值为行号加1。
      rowClassName({
        row,
        rowIndex
      }) {
        row.xh = rowIndex + 1;
      },
      getGoods(val, x) {
        this.goods = val;
        // console.log("goods:", this.goods)
        if (x === 'false') {
          this.addOrUpdateVisible = false
        } else {
          this.addOrUpdateVisible = true
        }
        this.goods.forEach(item => {
          let good = {
            xh: item.xh,
            demandMaId: item.goodsId,
            publicGoods: {
              goodsCode: item.goodsCode,
              goodsName: item.goodsName,
              categoryName: item.categoryName,
              goodsType: item.goodsType
            }
          }
          this.formData.shoppingDemands = [...this.formData.shoppingDemands, good]
        });
        this.formData.shoppingDemands.forEach(item => {
          item = {
            budgetAmount: 0,
            demandCount: 0,
            totalPrice: 0,
            demandTime: ''
          }
        });
      },
    },
  };
</script>
<style scoped lang="scss">
  .app-container {
    background-color: rgb(237, 240, 245);

    .top {
      width: 100%;
      height: 100px;
      background-color: white;

      h1 {
        float: left;
        margin: 37px;
        margin-left: 550px;
      }
    }

    .section_bos {
      margin-top: 17px;
      width: 100%;
      height: 100%;
      background-color: white;

    }

  }
</style>
