<template>
  <div style="padding: 30px;background-color: #f3f3f3;">
    <div class="top3">
      <div id="top_img" style="width: 100px; float: left">
        <img src="@/assets/logo/logo2.jpg" alt="donate" height="100px" width="230px" />
      </div>
      <h1>{{gys}}</h1>
      <div style="float: right;margin-top: 30px;margin-right: 30px;">
        <el-button @click="submitForm">提交</el-button>
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
      <div class="table-container myclss" style="background: #ffffff;">
        <table class="table-layout">
          <tbody>
            <tr>
              <td class="table-cell" colspan="6">
                <div class="static-content-item">
                  <div class="bt">项目信息</div>
                </div>
              </td>
            </tr>
            <tr>
              <td class="table-cell label-center-align">
                <div class="static-content-item">
                  <div class="jz">项目编号</div>
                </div>
              </td>
              <td class="table-cell" colspan="2">
                <div class="static-content-item">
                  <div class="jz">自动生成</div>
                </div>
              </td>
              <td class="table-cell label-center-align">
                <div class="static-content-item">
                  <div class="jz">项目名称</div>
                </div>
              </td>
              <td class="table-cell" colspan="2">
                <el-form-item label="" label-width="1px" prop="tenderProjectsName" class="required">
                  <el-input v-model="formData.tenderProjectsName" type="text" clearable></el-input>
                </el-form-item>
              </td>
            </tr>
            <tr>
              <td class="table-cell label-center-align">
                <div class="static-content-item">
                  <div class="jz">招标方式</div>
                </div>
              </td>
              <td class="table-cell" colspan="2">
                <el-form-item label="" prop="manner">
                  <el-radio-group v-model="formData.manner">
                    <el-radio v-for="(item, index) in mannerOptions" :key="index" :label="item.value"
                      :disabled="item.disabled" style="{display: inline}">{{item.label}}</el-radio>
                  </el-radio-group>
                </el-form-item>
              </td>
              <td class="table-cell label-center-align">
                <div class="static-content-item">
                  <div class="jz">项目预算</div>
                </div>
              </td>
              <td class="table-cell" colspan="2">
                <el-form-item label="" label-width="1px" prop="tenderProjectsMoney" class="required">
                  <el-input v-model="formData.tenderProjectsMoney" type="text" clearable></el-input>
                </el-form-item>
              </td>
            </tr>
            <tr>
              <td class="table-cell label-center-align">
                <div class="static-content-item">
                  <div class="jz">资质审查方式</div>
                </div>
              </td>
              <td class="table-cell" colspan="2">
                <el-form-item label="" prop="must">
                  <el-radio-group v-model="formData.must">
                    <el-radio v-for="(item, index) in mustOptions" :key="index" :label="item.value"
                      :disabled="item.disabled" style="{display: inline}">{{item.label}}</el-radio>
                  </el-radio-group>
                </el-form-item>
              </td>
              <td class="table-cell label-center-align">
                <div class="static-content-item">
                  <div class="jz">业务类型</div>
                </div>
              </td>
              <td class="table-cell" colspan="2">
                <el-form-item label="" prop="projectsType">
                  <el-select v-model="formData.projectsType" class="full-width-input" clearable>
                    <el-option v-for="dict in dict.type.projects_type" :key="dict.value" :label="dict.label"
                      :value="parseInt(dict.value)"></el-option>
                  </el-select>
                </el-form-item>
              </td>
            </tr>
            <tr>
              <td class="table-cell" colspan="6">
                <div class="static-content-item">
                  <div class="bt">招标人信息</div>
                </div>
              </td>
            </tr>
            <tr>
              <td class="table-cell label-center-align">
                <div class="static-content-item">
                  <div class="jz">联系人</div>
                </div>
              </td>
              <td class="table-cell" colspan="2">
                <el-form-item label="" label-width="1px" prop="tenderProjectsContact" class="required">
                  <el-input v-model="formData.tenderProjectsContact" type="text" clearable></el-input>
                </el-form-item>
              </td>
              <td class="table-cell label-center-align">
                <div class="static-content-item">
                  <div class="jz">地址</div>
                </div>
              </td>
              <td class="table-cell" colspan="2">
                <el-form-item label="" label-width="1px" prop="tenderProjectsAddress" class="required">
                  <el-input v-model="formData.tenderProjectsAddress" type="text" clearable></el-input>
                </el-form-item>
              </td>
            </tr>
            <tr>
              <td class="table-cell label-center-align">
                <div class="static-content-item">
                  <div class="jz">电话</div>
                </div>
              </td>
              <td class="table-cell" colspan="2">
                <el-form-item label="" label-width="1px" prop="tenderProjectsPhone" class="required">
                  <el-input v-model="formData.tenderProjectsPhone" type="text" clearable></el-input>
                </el-form-item>
              </td>
              <td class="table-cell label-center-align">
                <div class="static-content-item">
                  <div class="jz">备注</div>
                </div>
              </td>
              <td class="table-cell" colspan="2">
                <el-form-item label="" label-width="1px" prop="remark">
                  <el-input v-model="formData.remark" type="text" clearable></el-input>
                </el-form-item>
              </td>
            </tr>
            <tr>
              <td class="table-cell label-center-align">
                <div class="static-content-item">
                  <div class="jz">邮箱</div>
                </div>
              </td>
              <td class="table-cell" colspan="2">
                <el-form-item label="" label-width="1px" prop="tenderProjectsEmail" class="required">
                  <el-input v-model="formData.tenderProjectsEmail" type="text" clearable></el-input>
                </el-form-item>
              </td>
              <td class="table-cell">
              </td>
              <td class="table-cell" colspan="2">
              </td>
            </tr>
            <tr>
              <td class="table-cell" colspan="6">
                <div class="static-content-item">
                  <div class="bt">招标清单</div>
                </div>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </el-form>
    <div class="static-content-item">
      <el-alert title="" type=info :closable="false" :center="true" :show-icon="false" effect="light">
      </el-alert>
    </div>
    <el-row v-show="isGoods">
      <!-- style="float: right;"> -->
      <el-button type="primary" icon="el-icon-plus" size="mini" @click="handleAddDetails">添加物品</el-button>
      <el-button type="success" icon="el-icon-delete" size="mini" @click="handleDeleteDetails">删除</el-button>
      <el-button type="danger" icon="el-icon-delete" size="mini" @click="handleDeleteAllDetails">清空</el-button>
    </el-row>
    <el-row>
      <el-table :data="manifestList" :row-class-name="rowClassName" @selection-change="chandleDetailSelectionChange"
        ref="tb" style="width: 100%;" @row-click="dj">

        <el-table-column type="selection" width="30" align="center" />

        <el-table-column label="物品编码" align="center" prop="goodsCode" width="300">
          <template slot-scope="scope">
            <el-input v-model="scope.row.goodsCode" :readonly="true">
              <i v-show="isGoods" slot="suffix" class="el-input__icon el-icon-search"
                @click="addOrUpdateVisible=true"></i>
            </el-input>
          </template>
        </el-table-column>
        <el-table-column label="物品名称" align="center" prop="goodsName" width="300">
          <template slot-scope="scope">
            <el-input v-model="scope.row.goodsName" :readonly="true">
              <i v-show="isGoods" slot="suffix" class="el-input__icon el-icon-search"
                @click="addOrUpdateVisible=true"></i>
            </el-input>
          </template>
        </el-table-column>
        <el-table-column label="单价" align="center" prop="available" width="200">
          <template slot-scope="scope">
            <el-input v-model="scope.row.price" @input="jsprice"></el-input>
          </template>
        </el-table-column>

        <el-table-column label="数量" align="center" prop="exempt" width="200">
          <template slot-scope="scope">
            <el-input-number v-model="scope.row.explains" @input="jsprice" class="full-width-input"
              controls-position="right" :min="1" :max="100000000000" :precision="0" :step="1">
            </el-input-number>
          </template>
        </el-table-column>

        <el-table-column label="总价" align="center" prop="exempt" width="200">
          <template slot-scope="scope">
            <el-input v-model="scope.row.prices"></el-input>
          </template>
        </el-table-column>

        <el-table-column label="计量单位" align="center" prop="grade" width="200">
          <template slot-scope="scope">
            <el-select v-model="scope.row.manifestTypeId" placeholder="请选择单位">
              <el-option v-for="dict in dict.type.goods_unit" :key="dict.value" :label="dict.label"
                :value="parseInt(dict.value)"></el-option>
            </el-select>
          </template>
        </el-table-column>

        <el-table-column label="备注" align="center" prop="exempt" width="200">
          <template slot-scope="scope">
            <el-input v-model="scope.row.remark"></el-input>
          </template>
        </el-table-column>

      </el-table>

    </el-row>
    <GoodsView @Goods="getGoods" :addOrUpdateVisible="addOrUpdateVisible" ref="addOrUpdateRef"></GoodsView>
  </div>
</template>

<script>
  import GoodsView from '@/components/Goods'
  import {
    getToken
  } from '../../../utils/auth';
  import {
    getPro_require,
  } from "@/api/shopping/pro_require";
  export default {
    components: {},
    props: {},
    dicts: ['projects_type', 'goods_unit'],
    data() {
      return {
        addOrUpdateVisible: false,
        formData: {
          tenderProjectsName: "",
          manner: 0,
          tenderProjectsMoney: "",
          must: 0,
          projectsType: "",
          tenderProjectsContact: "",
          tenderProjectsAddress: "",
          tenderProjectsPhone: "",
          remark: "",
          tenderProjectsEmail: "",
        },
        manifestList: [{
          manifestGoodsId: null,
          goodsCode: "",
          goodsName: "",
          price: null,
          prices: null,
          explains: null,
          manifestTypeId: null,
          remark: "",
        }],
        // 非单个禁用
        single: true,
        // 非多个禁用
        multiple: true,
        // 选中数组
        ids: [],
        rowid: null,
        //选中的从表数据
        checkedDetail: [],
        rules: {
          tenderProjectsName: [{
            required: true,
            message: '字段值不可为空',
          }],
          tenderProjectsMoney: [{
            required: true,
            message: '字段值不可为空',
          }],
          tenderProjectsContact: [{
            required: true,
            message: '字段值不可为空',
          }],
          tenderProjectsAddress: [{
            required: true,
            message: '字段值不可为空',
          }],
          tenderProjectsPhone: [{
            required: true,
            message: '字段值不可为空',
          }],
          tenderProjectsEmail: [{
            required: true,
            message: '字段值不可为空',
          }],
        },
        mannerOptions: [{
          "label": "公开招标",
          "value": 0
        }, {
          "label": "邀请招标",
          "value": 1
        }],
        mustOptions: [{
          "label": "资格预审",
          "value": 0
        }, {
          "label": "资格后审",
          "value": 1
        }],
        vid: null,
        pid: null,
        isGoods: true,
      }
    },
    components: {
      GoodsView
    },
    computed: {},
    watch: {},
    created() {
      this.vid = this.$route.query.vid;

      this.pid = this.$route.params.pid;
      if (this.pid != null && this.pid != '') {
        this.gys = "采购需求转招标项目"
        this.findGoodsList()
        this.isGoods = false;
        return
      }
      let fd = new FormData();
      if (this.vid == null) {
        this.gys = "新增招标项目"
      } else {
        this.gys = "修改招标项目";
        fd.append("id", this.vid)
        this.manifestList = []
        axios.post('/dev-api/bidding/tender_projects/findProjectById', fd, {
            headers: {
              'Authorization': `Bearer ${getToken()}`,
              'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
            },
          })
          .then(response => {
            this.$modal.msgSuccess("数据加载成功");
            // 处理响应
            this.formData = response.data.data

            console.log(this.formData)
            response.data.data.list.forEach((e, i) => {
              this.manifestList.push({
                manifestGoodsId: e.manifestGoodsId,
                goodsCode: e.goodsCode,
                goodsName: e.goodsName,
                price: e.price,
                prices: e.prices,
                explains: e.explains,
                manifestTypeId: e.manifestTypeId,
                remark: e.bz,
              })
            })
          })
          .catch(error => {
            // 处理错误
          });


      }
    },
    mounted() {},
    methods: {
      findGoodsList() {
        this.manifestList = []
        getPro_require(this.pid).then(response => {
          console.log(response.data.shoppingDemands);
          response.data.shoppingDemands.forEach((e, i) => {
            this.manifestList.push({
              manifestGoodsId: e.publicGoods.goodsId,
              goodsCode: e.publicGoods.goodsCode,
              goodsName: e.publicGoods.goodsName,
              price: e.budgetAmount,
              prices: e.budgetAmount *  e.demandCount,
              explains: e.demandCount,
              manifestTypeId: e.publicGoods.goodsType,
              remark: e.remark,
            })
          })
        });
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
          let json2 = JSON.stringify(this.manifestList)
          fd.append("projects", json)
          fd.append("manifest", json2)
          axios.post('/dev-api/bidding/tender_projects/insertProjects', fd, {
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
      resetForm() {
        this.$refs['vForm'].resetFields()
      },
      getGoods(val, x) {
        let thet = this;
        if (x === 'false') this.addOrUpdateVisible = false
        else this.addOrUpdateVisible = true
        //this.goodsFrom = val;
        if (val.length > 1) {
          console.log(val)
          val.forEach((e, i) => {
            this.manifestList.push({
              manifestGoodsId: e.goodsId,
              goodsName: e.goodsName,
              goodsCode: e.goodsCode,
              explains: 1,
            })
          })
        } else {
          // this.goodsFrom = val;
          this.manifestList.forEach((e, i) => {
            if (e.xh === thet.rowid) {
              e.goodsName = val.goodsName
              e.manifestGoodsId = val.goodsId
              e.goodsCode = val.goodsCode
            }
          })
        }

      },
      dj(row) {
        this.rowid = row.xh
      },
      jsprice() {
        let thet = this;
        this.manifestList.forEach((e, i) => {
          if (e.xh === thet.rowid) {
            e.prices = e.price * e.explains
          }
        })
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
        if (this.manifestList === undefined) {
          this.manifestList = new Array();
        }

        this.manifestList.push({
          manifestGoodsId: null,
          goodsCode: "",
          goodsName: "",
          price: null,
          prices: null,
          explains: null,
          manifestTypeId: null,
          remark: "",
        });
      },
      // 删除
      handleDeleteDetails() {
        if (this.checkedDetail.length > 0) {
          this.manifestList.splice(this.checkedDetail[0].xh - 1, 1);
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
        this.manifestList = undefined;
      }
    }
  }
</script>

<style lang="scss">
  .top3 {
    width: 100%;
    height: 100px;
    background-color: white;

    h1 {
      float: left;
      font-size: 30px;
      margin: 37px;
      margin-left: 450px;
    }

    .el-form-item__error {
      top: 25%;
    }
  }

  .el-input-number.full-width-input,
  .el-cascader.full-width-input {
    width: 100% !important;
  }

  .el-table tr {
    background-color: #fbfbfb;
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
        border: 1px solid #f1f1f1;
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

  .label-center-align {
    background-color: #f0f0f0;
  }

  .jz {
    margin: 0 auto;
    font-size: 14px;
  }

  .bt {
    font-size: 17px;
    padding: 15px;
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
<style>
  .myclss .el-form-item {
    margin-bottom: 0px;
  }

  .myclss .el-input--medium .el-input__inner {
    border: 0px;
  }
</style>
