<template>
  <div>

    <div style="padding: 30px;background-color: #f3f3f3;">
      <div class="top">
        <div id="top_img" style="width: 100px; float: left">
          <img src="@/assets/logo/logo2.jpg" alt="donate" height="100px" width="230px" />
        </div>
        <h1>{{gys}}</h1>
        <div style="float: right;margin-top: 30px;margin-right: 30px;">
          <el-button v-show="tjshow" @click="submitForm">提交</el-button>
          <el-button v-show="!tjshow" @click="bj">编辑</el-button>
          <el-button @click="$router.back()">返回</el-button>
        </div>
      </div>
      <div>

      </div>
      <div class="static-content-item">
        <el-alert title="" type=info :closable="false" :center="true" :show-icon="false" effect="light">
        </el-alert>
      </div>
      <el-form :model="formData" ref="vForm" :rules="rules" label-position="left" label-width="80px" size="medium"
        @submit.native.prevent>
        <div class="card-container">
          <el-card style="{width: 100% !important}" shadow="never">
            <div slot="header" class="clear-fix">
              <span>基本信息</span>
            </div>
            <el-row>
              <el-col :span="12" class="grid-cell">
                <el-form-item label="供应商编码" label-width="180px" prop="supplierCode" class="required label-right-align">
                  <el-input @focus="dialogFormVisible=true" :readonly="true" v-model="formData.supplierCode" type="text"
                    clearable suffix-icon="el-icon-search"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12" class="grid-cell">
                <el-form-item label="供应商名称" label-width="180px" prop="supplierName" class="required label-right-align">
                  <el-input @focus="dialogFormVisible=true" :readonly="true" v-model="formData.supplierName" type="text"
                    suffix-icon="el-icon-search" clearable></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12" class="grid-cell">
                <el-form-item label="创建人" label-width="180px" prop="createBy" class="label-right-align">
                  <el-input v-model="formData.createBy" :readonly="true" :disabled="true" type="text" clearable>
                  </el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12" class="grid-cell">
                <el-form-item label="创建时间" label-width="180px" prop="createTime" class="label-right-align">
                  <el-date-picker v-model="formData.createTime" type="date" class="full-width-input" :disabled="true"
                    format="yyyy-MM-dd HH:mm:ss" clearable>
                  </el-date-picker>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12" class="grid-cell">
                <el-form-item label="修改人" label-width="180px" prop="updateBy" class="label-right-align">
                  <el-input v-model="formData.updateBy" :disabled="true" type="text" clearable></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12" class="grid-cell">
                <el-form-item label="最后修改时间" label-width="180px" prop="updateTime" class="label-right-align">
                  <el-date-picker v-model="formData.updateTime" type="date" class="full-width-input" :disabled="true"
                    format="yyyy-MM-dd HH:mm:ss" clearable>
                  </el-date-picker>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12" class="grid-cell">
                <el-form-item label="备注" label-width="180px" prop="remark" class="label-right-align">
                  <el-input v-model="formData.remark" type="text" clearable></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12" class="grid-cell">
              </el-col>
            </el-row>
          </el-card>
        </div>
        <div class="static-content-item">
          <el-alert title="" type=info :closable="false" :center="true" :show-icon="false" effect="light">
          </el-alert>
        </div>
        <div class="card-container">
          <el-card style="{width: 100% !important}" shadow="never">
            <div slot="header" class="clear-fix">
              <span>设置物料</span>
            </div>

            <el-row>
              <el-button type="primary" icon="el-icon-plus" size="mini" @click="handleAddDetails">添加</el-button>
              <el-button type="success" icon="el-icon-delete" size="mini" @click="handleDeleteDetails">删除</el-button>
              <el-button type="danger" icon="el-icon-delete" size="mini" @click="handleDeleteAllDetails">清空</el-button>
            </el-row>
            <el-row>
              <el-table :data="suppliedMaterials" :row-class-name="rowClassName"
                @selection-change="chandleDetailSelectionChange" ref="tb" style="width: 100%;" @row-click="dj">

                <el-table-column type="selection" width="30" align="center" />

                <el-table-column label="物品编码" align="center" prop="goodsCode" width="300">
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.goodsCode" :readonly="true">
                      <i slot="suffix" class="el-input__icon el-icon-search" @click="addOrUpdateVisible=true"></i>
                    </el-input>
                  </template>
                </el-table-column>
                <el-table-column label="物品名称" align="center" prop="goodsName" width="300">
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.goodsName" :readonly="true">
                      <i slot="suffix" class="el-input__icon el-icon-search" @click="addOrUpdateVisible=true"></i>
                    </el-input>
                  </template>
                </el-table-column>
                <el-table-column label="是否可供" align="center" prop="available" width="200">
                  <template slot-scope="scope">
                    <el-select v-model="scope.row.available" placeholder="请选择">
                      <el-option label="是" :value="0"></el-option>
                      <el-option label="否" :value="1"></el-option>
                    </el-select>
                  </template>
                </el-table-column>
                <el-table-column label="是否免检" align="center" prop="exempt" width="200">
                  <template slot-scope="scope">
                    <el-select v-model="scope.row.exempt" placeholder="请选择">
                      <el-option label="是" :value="0"></el-option>
                      <el-option label="否" :value="1"></el-option>
                    </el-select>
                  </template>
                </el-table-column>
                <el-table-column label="供货等级" align="center" prop="grade" width="200">
                  <template slot-scope="scope">
                    <el-select v-model="scope.row.grade" placeholder="请选择状态">
                      <el-option v-for="dict in dict.type.vendor_supply_nengli" :key="dict.value" :label="dict.label"
                        :value="parseInt(dict.value)"></el-option>
                    </el-select>
                  </template>
                </el-table-column>
              </el-table>

            </el-row>

          </el-card>


        </div>
      </el-form>
    </div>
    <!-- 添加供应商组件 -->

    <el-dialog title="选着供应商" :visible.sync="dialogFormVisible">
      <el-form :model="queryParams" ref="vForm" :rules="rules" label-position="left" label-width="80px" size="medium"
        @submit.native.prevent>
        <el-row>
          <el-col :span="9" class="grid-cell">
            <el-form-item label="供应商名称" label-width="150px" prop="abbreviated" class="label-right-align">
              <el-input v-model="queryParams.abbreviated" type="text" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="9" class="grid-cell">
            <el-form-item label="供应商编码" label-width="150px" prop="vendorNumber" class="label-right-align">
              <el-input v-model="queryParams.vendorNumber" type="text" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="6" class="grid-cell">
            <div class="static-content-item">
              <el-button icon="el-icon-search" @click="getList">搜索</el-button>
            </div>
          </el-col>
        </el-row>
      </el-form>
      <el-table v-loading="loading" height="325" @row-dblclick="db" :data="vendorList" ref="multipleTable"
        @selection-change="handleSelectionChange" @row-click="handleSelectionChanges(scope.row)">
        <el-table-column label="供应商ID" align="center" prop="vendorId" />
        <el-table-column label="供应商名称" align="center" prop="abbreviated" />
        <el-table-column label="供应商编码" align="center" prop="vendorNumber" />
        <el-table-column label="仓库地址" align="center" prop="warehouseAddress" />
      </el-table>
      <pagination v-show="total>0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
        @pagination="getList" />
      <!-- <el-button @click="qd">确定</el-button> -->
    </el-dialog>
    <GoodsView @Goods="getGoods" :addOrUpdateVisible="addOrUpdateVisible" ref="addOrUpdateRef"></GoodsView>

  </div>
</template>

<script>
  import {
    listVendor,
    insertVendor,
    getVendor,
    delVendor,
    addVendor,
    findVendorDetailed,
    updateVendor
  } from "@/api/public/vendor";

  import GoodsView from '@/components/Goods'
  import {
    getToken
  } from '../../../utils/auth';
  // import {
  //   forEach
  // } from "core-js/es6/array";

  export default {
    components: {},
    props: {},
    dicts: ['vendor_supply_nengli'],
    data() {
      return {
        dialogFormVisible: false,
        addOrUpdateVisible: false,
        goodsFrom: {},
        tjshow: true,
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          abbreviated: "",
          vendorNumber: "",
        },
        // 总条数
        total: 0,
        formData: {
          supplyVendorId: null,
          supplierCode: "",
          supplierName: "",
          createBy: null,
          createTime: null,
          updateBy: null,
          updateTime: null,
          remark: "",
        },
        vendorSupplyList: [],
        vendorList: [],
        // 非单个禁用
        single: true,
        // 非多个禁用
        multiple: true,
        // 选中数组
        ids: [],
        suppliedMaterials: [{
          available: null,
          exempt: null,
          grade: null,
          demandMaId: "",
          goodsName: "",
          goodsCode: null
        }],
        //选中的从表数据
        checkedDetail: [],
        rules: {
          supplierCode: [{
            required: true,
            message: '字段值不可为空',
          }],
          supplierName: [{
            required: true,
            message: '字段值不可为空',
          }],
        },
        rowid: null,
        gys: null,
      }
    },
    components: {
      GoodsView
    },
    computed: {},
    watch: {},
    created() {
      let thet = this;
      this.getList()
      this.vid = this.$route.query.vid;
      if (this.vid == null) {
        this.gys = "供货设置"
        this.formData.createBy = this.$store.state.user.name;
        var time = new Date;
        this.formData.createTime = time;
      } else {

        let fd = new FormData();
        fd.append("id", this.vid)
        this.gys = "供货修改"
        if (thet.$route.query.ty == 'true') {
          thet.gys = "供货详情"
          thet.tjshow = false;
        }
        axios.post('/dev-api/bidding/supply/findSupplyById', fd, {
            headers: {
              'Authorization': `Bearer ${getToken()}`,
              'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
            },
          })
          .then(response => {
              this.$modal.msgSuccess("数据加载成功");
            // 处理响应
            console.log(response)
            this.formData = response.data.data
            thet.suppliedMaterials = [];
            response.data.data.suppliedMaterialsList.forEach((e, i) => {
              thet.suppliedMaterials.push({
                demandMaId: e.demandMaId,
                goodsName: e.goodsName,
                goodsCode: e.goodsCode,
                available: e.available,
                exempt: e.exempt,
                grade: e.grade
              })
            })
          })


      }
    },
    mounted() {},
    methods: {
      bj(){
        this.getList()
        this.tjshow=true;
        this.gys="供货修改"
      },
      submitForm() {
        let fd = new FormData();
        this.$refs['vForm'].validate(valid => {
          if (!valid) return
          //TODO: 提交表单

          if (this.formData.supplyId != null) {
            this.formData.updateBy = this.$store.state.user.name;
            var time = new Date;
            this.formData.updateTime = time;
          }

          let json = JSON.stringify(this.formData)
          let json2 = JSON.stringify(this.suppliedMaterials)
          fd.append("publicSupply", json)
          console.log(this.suppliedMaterials)
          fd.append("publicSuppliedMaterials", json2)
          axios.post('/dev-api/bidding/supply/insertSupping', fd, {
              headers: {
                'Authorization': `Bearer ${getToken()}`,
                'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
              },
            })
            .then(response => {
              // 处理响应
              console.log(response)
              if (response.data == 1) {
                 this.$modal.msgSuccess("操作成功");
                 this.$router.go(-1)
              }
            })
            .catch(error => {
              // 处理错误
            });
        })
      },
      getGoods(val, x) {
        let thet = this;
        if (x === 'false') this.addOrUpdateVisible = false
        else this.addOrUpdateVisible = true
        //this.goodsFrom = val;
        if (val.length > 1) {
          console.log(val)
          val.forEach((e, i) => {
            this.suppliedMaterials.push({
              demandMaId: e.goodsId,
              goodsName: e.goodsName,
              goodsCode: e.goodsCode,
              available: null,
              exempt: null,
              grade: null
            })
          })
        } else {
          // this.goodsFrom = val;
          this.suppliedMaterials.forEach((e, i) => {
            if (e.xh === thet.rowid) {
              e.goodsName = val.goodsName
              e.demandMaId = val.goodsId
              e.goodsCode = val.goodsCode
            }
          })
        }

      },
      dj(row) {
        this.rowid = row.xh
      },
      getList() {
        listVendor(this.queryParams).then(response => {
          this.vendorList = response.rows;
          this.total = response.total;
        });
      },
      handleclo() {
        this.$refs.multipleTable.clearSelection()
      },

      resetForm() {
        this.$refs['vForm'].resetFields()
      },
      rowClassName({
        row,
        rowIndex
      }) {
        row.xh = rowIndex + 1;
      },
      handleSelectionChanges(row) {
        console.log("row:", row)
        this.ids = row
        this.single = selection.length !== 1
        this.multiple = !selection.length
      },
      handleSelectionChange(selection) {
        this.ids = selection
        this.single = selection.length !== 1
        this.multiple = !selection.length
        // console.log(this.ids)
      },
      db(row) {
        this.ids = row;
        this.handleclo()
        this.formData.supplyVendorId = this.ids.vendorId;
        this.formData.supplierName = this.ids.abbreviated;
        this.formData.supplierCode = this.ids.vendorNumber;
        this.dialogFormVisible = false;
      },
      qd() {
        this.handleclo()
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
        if (this.suppliedMaterials === undefined) {
          this.suppliedMaterials = new Array();
        }
        var time = new Date;
        this.suppliedMaterials.push({
          available: null,
          exempt: null,
          grade: null,
          demandMaid: "",
          goodsName: "",
          goodsCode: null
        });
      },
      // 删除
      handleDeleteDetails() {
        if (this.checkedDetail.length > 0) {
          this.suppliedMaterials.splice(this.checkedDetail[0].xh - 1, 1);
          this.listFile = [];
        } else {
          this.$alert("请先选择要删除的数据", "提示", {
            confirmButtonText: "确定",
          });
        }
      },
      //清空
      handleDeleteAllDetails() {
        this.listFile = [];
        this.suppliedMaterials = undefined;
      }
    }
  }
</script>

<style lang="scss">
  .top {
    width: 100%;
    height: 100px;
    background-color: white;

    h1 {
      float: left;
      font-size: 30px;
      margin: 37px;
      margin-left: 450px;
    }
  }

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
