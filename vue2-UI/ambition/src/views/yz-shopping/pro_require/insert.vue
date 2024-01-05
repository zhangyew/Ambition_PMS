<template>
  <div class="app-container">
    <div class="boxs">
      <div class="top">
        <div id="top_img" style="width: 100px; float: left">
          <img src="@/assets/logo/logo2.jpg" alt="donate" height="100px" width="230px" />
        </div>
        <h1>采购需求申请表</h1>
      </div>
      <div class="section_bos">
        <el-form :model="formData" ref="vForm" :rules="rules" label-position="left" label-width="150px" size="medium"
          @submit.native.prevent>
          <div class="card-container">
            <el-card style="{width: 100% !important}" shadow="hover">
              <div slot="header" class="clear-fix">
                <span>基本信息</span>
              </div>
              <el-row>
                <el-col :span="12" class="grid-cell">
                  <el-form-item label="需求编号" prop="requireNumber" class="required label-right-align">
                    <el-input type="text" clearable :readonly="true" v-model="formData.requireNumber"
                      placeholder="系统自动为您生成"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="12" class="grid-cell">
                  <el-form-item label="需求人" prop="requirePerson" class="required label-right-align">
                    <el-input v-model="formData.requirePerson" type="text" clearable></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="12" class="grid-cell">
                  <el-form-item label="需求部门" prop="requireDept" class="required label-right-align">
                    <el-input v-model="formData.requireDept" type="text" clearable></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="12" class="grid-cell">
                  <el-form-item label="需求类型" prop="requireType" class="required label-right-align">
                    <el-select v-model="formData.requireType" placeholder="请选择需求类型">
                      <el-option v-for="dict in dict.type.require_type" :key="dict.value" :label="dict.label"
                        :value="parseInt(dict.value)"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="12" class="grid-cell">
                  <el-form-item label="总金额" class="required label-right-align">
                    <el-input v-model="formData.totalMoney" :disabled="true" type="text" clearable></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="12" class="grid-cell">
                  <el-form-item label="收货联系人" prop="requireContact" class="label-right-align">
                    <el-input v-model="formData.requireContact" type="text" clearable></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="12" class="grid-cell">
                  <el-form-item label="收货地址" prop="requireAddress" class="label-right-align">
                    <el-input v-model="formData.requireAddress" type="text" clearable></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="12" class="grid-cell">
                  <el-form-item label="收货号码" prop="requirePhone" class="label-right-align">
                    <el-input v-model="formData.requirePhone" type="text" clearable></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="12" class="grid-cell">
                  <el-form-item label="主要用途及说明" prop="mainPurpose" class="label-right-align">
                    <el-input v-model="formData.mainPurpose" type="text" clearable></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="12" class="grid-cell">
                  <el-form-item label="是否需要招标" prop="isTender" class="required label-right-align">
                    <el-radio-group @change="changTender()" v-model="formData.isTender">
                      <el-radio :label="0">不需要</el-radio>
                      <el-radio :label="1">需要</el-radio>
                    </el-radio-group>
                  </el-form-item>
                </el-col>
                <el-col :span="12" class="grid-cell">
                  <el-form-item label="供货供应商" prop="requireVendor" class="required label-right-align">
                    <el-select v-model="formData.vendorName" @change="changVendor()" placeholder="请选择供应商"
                      :disabled="formData.isTender === 1">
                      <el-option v-for="vendor in listVendor" :key="vendor.vendorId" :label="vendor.abbreviated"
                        :value="parseInt(vendor.vendorId)"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
              </el-row>
              <hr />
              <div class="clear-fix" style="margin-bottom: 20px;">
                <span>物料信息</span>
              </div>
              <el-row>
                <el-button type="primary" icon="el-icon-plus" size="mini" @click="handleAddDetails">添加</el-button>
                <el-button type="success" icon="el-icon-delete" size="mini" @click="handleDeleteDetails">删除</el-button>
                <el-button type="danger" icon="el-icon-delete" size="mini"
                  @click="handleDeleteAllDetails">清空</el-button>
              </el-row>
              <el-row>
                <el-table :data="bcglXiangXiList" :row-class-name="rowClassName"
                  @selection-change="chandleDetailSelectionChange" ref="tb">
                  <el-table-column type="selection" width="30" align="center" />
                  <el-table-column label="序号" align="center" prop="xh" width="50" />
                  <el-table-column label="物料编码" width="150">
                    <template slot-scope="scope">
                      <el-input type="text" :value="scope.row.goodsCode">
                        <i slot="suffix" class="el-input__icon el-icon-search" @click="addOrUpdateVisible=true"></i>
                      </el-input>
                      <GoodsView @Goods="getGoods" :gysId="formData.vendorName"
                        :addOrUpdateVisible="addOrUpdateVisible" ref="addOrUpdateVisible">
                      </GoodsView>
                    </template>
                  </el-table-column>
                  <el-table-column label="物料名称" align="center" prop="goodsName" width="150">
                  </el-table-column>
                  <el-table-column label="物料品类" align="center" prop="categoryName" width="150">
                  </el-table-column>
                  <el-table-column label="物料单位" align="center" width="100">
                    <template slot-scope="scope">
                      <dict-tag :options="dict.type.goods_unit" :value="scope.row.goodsType" />
                    </template>
                  </el-table-column>
                  <el-table-column label="需求数量" align="center" width="100" prop="demand_count">
                    <template slot-scope="scope">
                      <el-input v-model="scope.row.total" />
                    </template>
                  </el-table-column>
                  <el-table-column label="需求日期" width="250" prop="demand_time">
                    <template slot-scope="scope">
                      <el-date-picker :style="{width: '100%'}" clearable v-model="scope.row.date"></el-date-picker>
                    </template>
                  </el-table-column>
                  <el-table-column label="预算单价" align="center" width="100" prop="budget_amount">
                    <template slot-scope="scope">
                      <el-input v-model="scope.row.price" />
                    </template>
                  </el-table-column>
                  <el-table-column label="行预算金额" align="center" width="100">
                    <!-- 计算出来 -->
                    <template slot-scope="scope" v-model="scope.row.totalPrice">
                      {{(scope.row.total == null || scope.row.price == null) ? 0 : ((scope.row.total * scope.row.price) * 10)/10}}
                    </template>
                  </el-table-column>
                  <el-table-column label="备注" align="center" prop="remark" width="150">
                    <template slot-scope="scope">
                      <el-input v-model="scope.row.bz" />
                    </template>
                  </el-table-column>
                </el-table>
              </el-row>
              <el-row>
                <el-col :span="12" :offset="1" :push="8" class="grid-cell">
                  <div class="static-content-item">
                    <el-button plain icon="el-icon-refresh-left" style="margin-left: 70px;">重置</el-button>
                  </div>
                  <div class="static-content-item">
                    <el-button @click="sure" plain icon="el-icon-circle-check "
                      style="margin-left: 240px;margin-top: -56px;">提交
                    </el-button>
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
  import {
    listVendor
  } from "@/api/public/vendor";
  export default {
    dicts: ['require_type', 'goods_unit'],
    components: {},
    props: {},
    data() {
      return {
        addOrUpdateVisible: false,
        goods: {},
        listVendor: {},
        formData: {
          requireNumber: "",
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
          isTender: 0,
          shoppingDemands: []
        },
        //详细list
        bcglXiangXiList: [],
        //选中的从表数据
        checkedDetail: [],
        requireVendor: "",
        isTender: 0,
        isAddOrUp:0,//0新增 1修改
        rules: {
          requirePerson: [{
            required: true,
            message: '字段值不可为空',
          }],
          requireDept: [{
            required: true,
            message: '字段值不可为空',
          }],
          requireContact: [{
            required: true,
            message: '字段值不可为空',
          }],
          requireType: [{
            required: true,
            message: '字段值不可为空',
          }],
          isTender: [{
            required: true,
            message: '字段值不可为空',
          }]
        },
      }
    },
    components: {
      GoodsView
    },
    computed: {},
    watch: {
      bcglXiangXiList: {
        handler(val) {
          console.log("val:", val)
          let price = 0;
          val.forEach(item => {
            price += isNaN(item.price) && isNaN(item.total) ? 0 : ((item.price * item.total) * 10) / 10
          })
          this.formData.totalMoney = isNaN(price) ? 0 : price
        },
        deep: true
      },
    },
    created() {
      let reId = this.$route.params.reId;
      console.log("reId:", reId)
      if (reId != null) {
        this.getInfo(reId);
        this.isAddOrUp = 1
      }
      listVendor(null).then(response => {
        this.listVendor = response.rows;
        // console.log("供应商列表:" + JSON.stringify(response.rows));
      });

    },
    mounted() {},
    methods: {
      changTender() {
        if (this.formData.vendorName != null) {
          this.requireVendor = isNaN(this.formData.vendorName) ? this.formData.requireVendor : this.formData.vendorName
        }
        if (this.formData.isTender == 1) {
          this.formData.vendorName = null
          this.bcglXiangXiList = []
        } else {
          if (this.requireVendor == this.formData.requireVendor) {
            this.bcglXiangXiList = this.formData.shoppingDemands
            this.formData.vendorName = this.requireVendor
          }else{
            this.formData.vendorName = this.requireVendor
          }
        }
      },
      changVendor() {
        this.bcglXiangXiList = []
        if (this.formData.vendorName == this.formData.requireVendor) {
          this.bcglXiangXiList = this.formData.shoppingDemands
        }
      },
      getInfo(reId) {
        getPro_require(reId).then(response => {
          console.log(response.data);
          this.formData = response.data;
          if(response.data.shoppingDemands != null){
            this.formData.shoppingDemands.forEach(item => {
              let bcglXiangXiList = {
                xh: item.xh,
                goodsId: item.publicGoods.goodsId,
                goodsCode: item.publicGoods.goodsCode,
                goodsName: item.publicGoods.goodsName,
                goodsType: item.publicGoods.goodsType,
                categoryName: item.publicGoods.categoryName,
                total: item.demandCount,
                date: item.demandTime,
                price: item.budgetAmount,
                bz: item.remark
              }
              this.bcglXiangXiList.push(bcglXiangXiList)
              this.formData.shoppingDemands = this.bcglXiangXiList
            })
          }
        });
      },
      //新增方法
      sure() {
        const _this = this
        _this.formData.shoppingDemands = []
        if(_this.bcglXiangXiList != null && _this.bcglXiangXiList.length > 0){
          _this.bcglXiangXiList.forEach(item => {
            let shoppingDemands = {
              demandMaId: item.goodsId,
              demandCount: item.total,
              demandTime: item.date,
              budgetAmount: item.price * item.total,
              remark: item.bz
            }
            _this.formData.shoppingDemands.push(shoppingDemands)
          })
        }
        if(this.isAddOrUp == 0){
          console.log("1:"+_this.formData.vendorName);
          _this.formData.requireVendor=_this.formData.vendorName;
          console.log("2:"+ _this.formData.requireVendor);
          addPro_require(_this.formData).then(res => {
            console.log(res);
            if (res.code == 200) {
              _this.$modal.msgSuccess("新增成功");
              this.$router.replace("/yz-shopping/pro_require/index")
            } else {
              _this.$modal.msgSuccess("新增失败");
            }
          })
        }else{
          updatePro_require(_this.formData).then(res => {
            console.log(res)
            if (res.code == 200) {
              _this.$modal.msgSuccess("修改成功");
              this.$router.replace("/yz-shopping/pro_require/index")
            } else {
              _this.$modal.msgSuccess("修改失败");
            }
          })
        }
      },
      submitForm() {
        this.$refs['vForm'].validate(valid => {
          if (!valid) return
          //TODO: 提交表单
        })
      },
      resetForm() {
        this.$refs['vForm'].resetFields()
      },
      //选中的商品
      getGoods(val, x) {
        this.goods = val;
        if (x === 'false') {
          this.addOrUpdateVisible = false
        } else {
          this.addOrUpdateVisible = true
        }
        if (this.bcglXiangXiList.length == 1) {
          this.bcglXiangXiList = this.goods
        } else {
          this.bcglXiangXiList = [...this.bcglXiangXiList, ...this.goods]
        }
        this.bcglXiangXiList.forEach(item => {
          item = {
            price: 0,
            total: 0,
            totalPrice: 0,
            date: ''
          }
        })
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
