<template>
  <div class="app-container">
    <div class="boxs">
      <div class="top">
        <div id="top_img" style="width: 100px; float: left">
          <img src="@/assets/logo/logo2.jpg" alt="donate" height="100px" width="230px" />
        </div>
        <h1>采购需求登记</h1>
      </div>
      <div class="section_bos">
        <el-form :model="formData" ref="vForm" label-position="left" label-width="150px" size="medium"
          @submit.native.prevent>
          <div class="card-container">
            <el-card style="{width: 100% !important}" shadow="hover">
              <div slot="header" class="clear-fix">
                <span>基本信息</span>
              </div>
              <el-row>
                <el-col :span="12" class="grid-cell">
                  <el-form-item label="需求编号" prop="requireNumber" class="required label-right-align">
                    <el-input v-model="formData.requireNumber" type="text" clearable :readonly="true"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="12" class="grid-cell">
                  <el-form-item label="需求人" prop="requirePerson" class="required label-right-align">
                    <el-input v-model="formData.requirePerson" type="text" clearable :readonly="true"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="12" class="grid-cell">
                  <el-form-item label="需求部门" prop="requireDept" class="required label-right-align">
                    <el-input v-model="formData.requireDept" type="text" clearable :readonly="true"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="12" class="grid-cell">
                  <el-form-item label="需求类型" prop="requireType" class="required label-right-align">
                    <el-select v-model="formData.requireType" placeholder="请选择需求类型" :disabled="true">
                      <el-option v-for="dict in dict.type.require_type" :key="dict.value" :label="dict.label"
                        :value="parseInt(dict.value)"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="12" class="grid-cell">
                  <el-form-item label="总金额" prop="totalMoney" class="required label-right-align">
                    <el-input v-model="formData.totalMoney" type="text" clearable :readonly="true"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="12" class="grid-cell">
                  <el-form-item label="收货联系人" prop="requireContact" class="label-right-align">
                    <el-input v-model="formData.requireContact" type="text" clearable :readonly="true"> </el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="12" class="grid-cell">
                  <el-form-item label="收货地址" prop="requirAaddress" class="label-right-align">
                    <el-input v-model="formData.requireAddress" type="text" clearable :readonly="true"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="12" class="grid-cell">
                  <el-form-item label="收货号码" prop="requirePhone" class="label-right-align">
                    <el-input v-model="formData.requirePhone" type="text" clearable :readonly="true"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="12" class="grid-cell">
                  <el-form-item label="主要用途及说明" prop="mainPurpose" class="label-right-align">
                    <el-input v-model="formData.mainPurpose" type="text" clearable :readonly="true"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="12" class="grid-cell">
                  <el-form-item label="是否需要招标" prop="isTender" class="required label-right-align">
                    <el-radio-group v-model="formData.isTender" :disabled="true">
                      <el-radio :label="0">不需要</el-radio>
                      <el-radio :label="1">需要</el-radio>
                    </el-radio-group>
                  </el-form-item>
                </el-col>
                <el-col :span="12" class="grid-cell">
                  <el-form-item label="供货供应商" prop="vendorName" class="required label-right-align">
                    <el-input v-model="formData.vendorName" type="text" clearable readonly=""
                      :disabled="formData.isTender === 1"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="12" class="grid-cell">
                  <el-form-item label="创建人" prop="createBy" class="label-right-align">
                    <el-input v-model="formData.createBy" type="text" clearable readonly=""></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="12" class="grid-cell">
                  <el-form-item label="创建时间" prop="createTime" class="label-right-align">
                    <el-input v-model="formData.createTime" type="text" clearable readonly=""></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <hr />
              <div class="clear-fix" style="margin-bottom: 20px;">
                <span>物料信息</span>
              </div>
              <el-row>
                <el-table :data="formData.shoppingDemands" :row-class-name="rowClassName" ref="tb">
                  <el-table-column label="序号" align="center" prop="xh" width="50"></el-table-column>
                  <el-table-column label="物料编码" width="170">
                    <template slot-scope="scope" v-if="btn ==null" >
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
                      {{scope.row.demandCount}}
                    </template>
                  </el-table-column>
                  <el-table-column label="需求日期" width="150" prop="demand_time">
                    <template slot-scope="scope">
                      <!-- <el-date-picker :style="{width: '100%'}" clearable
                        v-model="scope.row.demandTime"></el-date-picker> -->
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
                      <!-- <el-input v-model="scope.row.remark" /> -->
                      {{scope.row.remark}}
                    </template>
                  </el-table-column>
                </el-table>
              </el-row>
              <el-row>
                <el-col :span="12" :offset="1" :push="8" class="grid-cell">
                  <div class="static-content-item">
                    <el-button plain icon="el-icon-switch-button" style="margin-left: 145px;"
                      @click="goOff()">关闭</el-button>
                  </div>
                </el-col>
              </el-row>
            </el-card>
          </div>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
  import GoodsView from '@/components/Goods';
  import {
    getPro_require,
    addPro_require,
    updatePro_require
  } from "@/api/shopping/pro_require";

  export default {
    dicts: ['require_type', 'goods_unit'],
    components: {},
    props: {},
    data() {
      return {
        addOrUpdateVisible: false,
        goods: {},
        rids: null,
        require_id: null,
        formData: {
          vendorName: "",
          requirenumber: "",
          requirePerson: "",
          requireDept: "",
          requireType: "",
          requireVendor: "",
          totalMoney: "",
          requireContact: "",
          mainPurpose: "",
          requireAddress: "",
          requirePhone: "",
          requireDemandId: "",
          isTender: "",
          createBy: "",
          createTime: "",
          shoppingDemands: []
        },
        //详细list
        bcglXiangXiList: [],
        //选中的从表数据
        checkedDetail: [],
      }
    },
    components: {
      GoodsView
    },
    computed: {},
    watch: {
      "formData.shoppingDemands": {
        handler(val) {
          console.log("val:", val)
          let price = 0;
          val.forEach(item => {
            price += isNaN(item.budgetAmount) && isNaN(item.demandCount) ? 0 : ((item.budgetAmount * item
              .demandCount) * 10) / 10
          })
          this.formData.totalMoney = isNaN(price) ? 0 : price
        },
        deep: true
      }
    },
    created() {
      let rids = this.$route.params.rids;
      if (rids != null) {
        this.getInfo(rids);
      }
    },
    mounted() {}
    ,
    methods: {
      getInfo(rids) {
        getPro_require(rids).then(response => {
          // console.log(response.data);
          this.formData = response.data;
        });
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
        console.log("goods:", this.goods)
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
        })

        this.formData.shoppingDemands.forEach(item => {
          item = {
            budgetAmount: 0,
            demandCount: 0,
            totalPrice: 0,
            demandTime: ''
          }
        })
      },
      goOff() {
        // 返回上一页面
        this.$router.go(-1)
      }
    }
  }
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

      table {
        td:nth-child(even) {
          padding-left: 450px;
        }
      }

      .el-form-item__label {
        text-align: left;

      }

    }
  }
</style>
<style lang="scss">
  .el-input-number.full-width-input,
  .el-cascader.full-width-input {
    width: 100% !important;
  }

  .el-form-item--medium {
    .el-radio {
      line-height: 36px !important;
    }

    .el-rate {
      margin-top: 8px;
    }
  }

  .el-form-item--small {
    .el-radio {
      line-height: 32px !important;
    }

    .el-rate {
      margin-top: 6px;
    }
  }

  .el-form-item--mini {
    .el-radio {
      line-height: 28px !important;
    }

    .el-rate {
      margin-top: 4px;
    }
  }

  .clear-fix:before,
  .clear-fix:after {
    display: table;
    content: "";
  }

  .clear-fix:after {
    clear: both;
  }

  .float-right {
    float: right;
  }
</style>
<style lang="scss" scoped>
  div.table-container {
    table.table-layout {
      width: 100%;
      table-layout: fixed;
      border-collapse: collapse;

      td.table-cell {
        display: table-cell;
        height: 36px;
        border: 1px solid #e1e2e3;
      }
    }
  }

  div.tab-container {}

  .label-left-align ::v-deep .el-form-item__label {
    text-align: left;
  }

  .label-center-align ::v-deep .el-form-item__label {
    text-align: center;
  }

  .label-right-align ::v-deep .el-form-item__label {
    text-align: right;
  }

  .custom-label {}

  .static-content-item {
    min-height: 20px;
    display: flex;
    align-items: center;

    ::v-deep .el-divider--horizontal {
      margin: 0;
    }
  }
</style>
