<template>
  <div class="app-container">
    <div class="boxs">
      <div class="top">
        <div id="top_img" style="width: 100px; float: left">
          <img src="@/assets/logo/logo2.jpg" alt="donate" height="100px" width="230px" />
        </div>
        <h1>采购订单管理</h1>
        <div style="float: right;margin-top: 30px;margin-right: 30px;">
          <el-button type="primary" @click="sure()">提交</el-button>
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
          @submit.native.prevent>
          <el-row style="margin-top: 15px">
            <el-col :span="12" class="grid-cell" style="padding: 0px 0px 0px 95px;">
              <el-form-item label="订单标题" prop="orderTitle" class="required">
                <el-input v-model="formData.orderTitle" type="text" clearable style="width: 300px;" />
              </el-form-item>
              <el-form-item label="订单状态" prop="sector" class="typeOrderState">
                <el-select v-model="formData.typeOrderState" placeholder="请选择订单状态" :disabled="true">
                  <el-option v-for="dict in dict.type.type_order_state" :key="dict.value" :label="dict.label"
                    :value="parseInt(dict.value)"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="订单编号" prop="orderNumber">
                <el-input v-model="formData.orderNumber" type="text" clearable style="width: 300px;" readonly="readonly"
                  placeholder="系统为您自动生成"></el-input>
              </el-form-item>
              <el-form-item label="订单来源" prop="orderSource">
                <el-radio-group v-model="formData.orderSource" :disabled="true">
                  <el-radio :label="0">采购需求</el-radio>
                  <el-radio :label="1">采购计划</el-radio>
                  <el-radio :label="2">合同</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="需求编号" prop="requireId">
                <el-input v-model="rqNumber" type="text" clearable style="width: 300px;"
                  :disabled="formData.orderSource !== 0" :readonly="true" />
              </el-form-item>
              <el-form-item label="计划编号" prop="buyPlanId">
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
                <el-input type="text" clearable style="width: 300px;" readonly="readonly" value="远志集团有限公司"></el-input>
              </el-form-item>
              <el-form-item label="是否自提" prop="isZt">
                <el-radio-group v-model="formData.isZt">
                  <el-radio :label="0">否</el-radio>
                  <el-radio :label="1">是</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="自提车牌号" prop="carNumber" class="required">
                <el-input v-model="formData.carNumber" type="text" clearable style="width: 300px;"
                  :disabled="formData.isZt === 0"></el-input>
              </el-form-item>
              <el-form-item label="自提司机联系方式" prop="driverPhone" class="required">
                <el-input v-model="formData.driverPhone" type="text" clearable style="width: 300px;"
                  :disabled="formData.isZt === 0"></el-input>
              </el-form-item>
              <el-form-item label="采购员" prop="orderPurchaser">
                <el-input v-model="formData.orderPurchaser" type="text" clearable style="width: 300px;"></el-input>
              </el-form-item>
              <el-form-item label="需求/计划总金额" prop="totalMoney" class="required">
                <el-input v-model="formData.totalMoney" type="text" disabled clearable style="width: 300px;"
                  :readonly="true"></el-input>
              </el-form-item>
              <el-form-item label="订单说明" prop="orderContext" class="required">
                <el-input v-model="formData.orderContext" type="text" clearable style="width: 300px;"></el-input>
              </el-form-item>
              <el-form-item label="附件上传" prop="fileupload39631">
                <el-upload ref="upload" class="upload-demo" :limit="2" accept=".doc, .docx,.rar,.txt" multiple
                  :action="upload.url" :headers="upload.headers" :file-list="upload.fileList"
                  :before-remove="beforeRemove" :on-progress="handleFileUploadProgress" :on-success="handleFileSuccess"
                  :auto-upload="false">
                  <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
                  <el-button style="margin-left: 10px;" size="small" type="success" :loading="upload.isUploading"
                    @click="submitUpload">上传到服务器</el-button>
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
                <el-select v-model="formData.vendorContacts" placeholder="请选择联系人" style="width: 300px;">
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
    addOrders,
    addOrders1
  } from "@/api/shopping/orders";
  import {
    getToken
  } from "@/utils/auth";
  import {
    getBuy_plan,
    upState
  } from "@/api/shopping/buy_plan";
  import {
    getPro_require,
    upReState
  } from "@/api/shopping/pro_require";
  import {
    getVendor,
    showContactsList
  } from "@/api/public/vendor";
  import {
    getContractdetails,
    upConState
  } from "@/api/bidding/contractdetails";
  import {
    SHowsProjectRelatedItems
  } from "@/api/bidding/tender_projects";
  import {
    logger
  } from 'runjs/lib/common';

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
        fileupload39631: null,
        htBh: "",
        htMc: "",
        formData: {
          orderId: "",
          requireId: "",
          buyPlanId: "",
          orderTitle: "",
          orderSource: 1,
          orderNumber: "",
          orderPurchaser: "",
          publicAnnex: [],
          totalMoney: "",
          isZt: 0,
          carNumber: "",
          driverPhone: "",
          ordeContractId: "",
          orderContext: "",
          contractdetailsAmount: "",
          orderSupplierId: "",
          vendorContacts: "",
          vendorName: "",
          orderMaterialId: "",
          typeOrderState: 0,
          shoppingDemands: [],
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
      //接收采购计划id
      let sid = this.$route.params.sid;
      //接收采购需求id
      let rid = this.$route.params.rid;
      //接收合同id
      let cid = this.$route.params.cid;
      /**
       * 判断订单来源,根据id查询信息
       */
      if (resource === '0') {
        this.formData.orderSource = 0;
        let vendorId = null;
        getPro_require(rid).then(response => {
          // console.log("aaaa:" + JSON.stringify(response.data));
          this.formData.shoppingDemands = response.data.shoppingDemands;
          let price = 0;
          this.formData.shoppingDemands.forEach(item => {
            price += ((item.demandCount * item.budgetAmount) * 10) / 10;
          })
          // console.log("-----",price)
          this.formData.totalMoney = price;
          //供应商id
          this.formData.orderSupplierId = response.data.requireVendor;
          //供应商名字
          this.formData.vendorName = response.data.vendorName;
          //需求编号
          this.rqNumber = response.data.requireNumber;
          this.formData.requireId = response.data.requireId;
          //需求总金额(物料总金额)
          //物料id
          this.formData.orderMaterialId = response.data.requireDemandId;
          vendorId = response.data.requireVendor;
          let fd = new FormData();
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
      } else if (resource === '1') {
        this.formData.orderSource = 1;
        let vendorId = null;
        getBuy_plan(sid).then(response => {
          // console.log("bbbb:" + JSON.stringify(response.data));
          //采购计划id
          this.formData.buyPlanId = response.data.buyPlanId;
          //采购计划编码
          this.planNumber = response.data.planClod;
          //物料id
          this.formData.orderMaterialId = response.data.buyPlanDemandId;
          this.formData.shoppingDemands = response.data.shoppingDemands;
          let price = 0;
          this.formData.shoppingDemands.forEach(item => {
            price += ((item.demandCount * item.budgetAmount) * 10) / 10;
          })
          // console.log("-----",price)
          this.formData.totalMoney = price;
          vendorId = response.data.buyPlanVendorId;
          let fd = new FormData();
          // console.log("vendorId:" + vendorId);
          fd.append("vendorId", vendorId)
          axios.post('/dev-api/bidding/vendor/showContactsList', fd, {
              headers: {
                'Authorization': `Bearer ${getToken()}`,
                'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
              },
            })
            .then(response => {
              // console.log(response.data);
              this.formData.orderSupplierId = response.data.rows[0].vendorId;
              this.formData.vendorName = response.data.rows[0].abbreviated;
              this.contacts = response.data.rows[0].publicContactsList;
            })
        });
      } else {
        //合同
        this.formData.orderSource = 2;
        let vendorId = null;
        let ci = 0;
        getContractdetails(cid).then(response => {
          let res = response.data
          // console.log("cccc:" + JSON.stringify(response.data));
          //合同id
          this.formData.ordeContractId = res[0].contractdetailsId;
          //合同编号
          this.htBh = res[0].contractdetailsNumber;
          // console.log(htBh);
          //合同名称
          this.htMc = res[0].contractdetailsName;
          //合同总金额
          this.formData.contractdetailsAmount = res[0].contractdetailsAmount;
          //供应商名称
          this.formData.vendorName = res[0].abbreviated;
          //供应商id
          this.formData.orderSupplierId = res[0].vendorId;
          //查询联系人
          vendorId = res[0].vendorId;
          ci = res[0].tenderProjectsId;
          // console.log("ci:" + ci);
          let fd = new FormData();
          // console.log("vendorId:" + vendorId);
          fd.append("vendorId", vendorId);
          axios.post('/dev-api/bidding/vendor/showContactsList', fd, {
            headers: {
              'Authorization': `Bearer ${getToken()}`,
              'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
            },
          }).then(response => {
            // console.log(response.data);
            this.formData.orderSupplierId = response.data.rows[0].vendorId;
            this.formData.vendorName = response.data.rows[0].abbreviated;
            this.contacts = response.data.rows[0].publicContactsList;
          })
          //显示合同物料信息
          SHowsProjectRelatedItems(ci, vendorId).then((response) => {
            // console.log("物料:" + JSON.stringify(response));
            this.DemandList = response.rows;
            this.ht = true;
            // response.rows.forEach(i => {
            //   console.log("物料111" + JSON.stringify(i));
            //   // this.formData.shoppingDemands.publicGoods.categoryName = i.publicCategory.categoryName;
            // })
          });
        });

      }
    },
    mounted() {},
    methods: {
      // 文件提交处理
      submitUpload() {
        this.$refs.upload.submit();
      },
      // 文件上传中处理
      handleFileUploadProgress(event, file, fileList) {
        this.upload.isUploading = true;
      },
      // 文件上传成功处理
      handleFileSuccess(response, file, fileList) {
        // console.log(file);
        let thet = this;
        this.formData.publicAnnex.push({
          annexTitle: file.name,
          annexUrl: file.response.data.url,
          supplyId: this.formData.orderId,
          annexTypeId: 5,
        })
        // console.log(this.formData.publicAnnex);
        this.upload.isUploading = false;

      },
      beforeRemove(file, fileList) {
        return this.$confirm(`确定移除 ${ file.name }？`);
      },
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
      /**
       * 提交
       */
      sure() {
        if (this.DemandList.length > 0) {
          this.formData.shoppingDemands = this.DemandList;
        }
        const _this = this;
        let fireUrl = JSON.stringify(this.formData.publicAnnex);
        // console.log("formData:" + JSON.stringify(_this.formData));
        //新增后改变采购计划/需求状态为已生成订单
        addOrders1(_this.formData).then(res => {
          console.log(_this.formData);
          if (res.code == 200) {
            _this.$modal.msgSuccess("新增成功");
            //修改采购计划状态
            if (_this.formData.buyPlanId !== null && _this.formData.buyPlanId !== '') {
              let bid = _this.formData.buyPlanId;
              console.log("这是修改计划状态!:" + bid);
              upState(bid).then(res => {
                if (res.code != 200) {
                  console.log("采购计划修改状态失败!");
                }
              });
              //修改需求状态
            } else if (_this.formData.requireId !== null && _this.formData.requireId !== '') {
              let rid = _this.formData.requireId;
              console.log("这是修改需求状态!:" + rid);
              upReState(rid).then(res => {
                if (res.code != 200) {
                  console.log("采购需求修改状态失败!");
                }
              });
            } else {
              console.log("进入到新增合同订单!");
              //合同id
              let c = _this.formData.ordeContractId;
              upConState(c).then(res => {
                if (res.code != 200) {
                  console.log("合同修改状态失败!");
                }
              });
            }
            this.$router.replace("/yz-shopping/orders/index");
          } else {
            _this.$modal.msgSuccess("新增失败");
          }
        });
      }
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
