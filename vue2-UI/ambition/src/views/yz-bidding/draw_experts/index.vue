<template>
  <div class="xhz">
    <div class="top2">
      <div id="top_img" style="width: 100px; float: left">
        <img src="@/assets/logo/logo2.jpg" alt="donate" height="100px" width="230px" />
      </div>
      <h1>{{bt}}</h1>

    </div>

    <el-form :model="formData" ref="vForm" label-position="left" label-width="80px" size="medium"
      @submit.native.prevent>
      <div class="table-container myclss" style="background: #ffffff;">
        <table class="table-layout">
          <tbody>
            <tr>
              <td class="table-cell" colspan="6">
                <div class="static-content-item">
                  <div class="bt">抽取申请</div>
                </div>
              </td>
            </tr>
            <tr>
              <td class="table-cell label-center-align">
                <div class="static-content-item">
                  <div class="jz">抽取申请编号</div>
                </div>
              </td>
              <td class="table-cell" colspan="2">
                <el-form-item label="" prop="number">
                  <div class="jz"> <el-input readonly="" v-model="formData.number" type="text"></el-input></div>
                </el-form-item>
              </td>
              <td class="table-cell label-center-align">
                <div class="static-content-item">
                  <div class="jz">招标项目名称</div>
                </div>
              </td>
              <td class="table-cell" colspan="2">
                <el-form-item label="" label-width="1px" prop="tenderProjectsName" class="required">
                  <el-input style="width: 280px;" v-model="formData.tenderProjectsName" type="text" :readonly="true">
                    <!-- <i style="color: #0e97ff; font-weight: 800; font-size: 16px;" slot="suffix"
                      class="el-input__icon el-icon-search" @click="ss"></i> -->
                  </el-input>
                </el-form-item>
              </td>
            </tr>
            <tr>
              <td class="table-cell label-center-align">
                <div class="static-content-item">
                  <div class="jz">资格审查方式</div>
                </div>
              </td>
              <td class="table-cell" colspan="2">
                <el-form-item label="" prop="must" style="text-align: center;">
                  <el-radio-group :readonly="true" v-model="formData.must">
                    <el-radio disabled :label="0">资格预审</el-radio>
                    <el-radio disabled :label="1">资格后审</el-radio>
                  </el-radio-group>
                </el-form-item>
              </td>
              <td class="table-cell label-center-align">
                <div class="static-content-item">
                  <div class="jz">专家确定方式</div>
                </div>
              </td>
              <td class="table-cell" colspan="2">
                <el-form-item label="" label-width="1px" prop="manner" style="text-align: center;">
                  <el-radio-group v-model="formData.manner" @change="handleRadioChange">
                    <el-radio :label="0">随机抽取</el-radio>
                    <el-radio :label="1">直接指定</el-radio>
                  </el-radio-group>
                </el-form-item>
              </td>
            </tr>
            <tr>
              <td class="table-cell label-center-align">
                <div class="static-content-item">
                  <div class="jz">专家人数</div>
                </div>
              </td>
              <td class="table-cell" colspan="2">
                <el-form-item label="" prop="expertsNumber">
                  <el-input v-model="formData.expertsNumber" type="text"></el-input>
                </el-form-item>
              </td>
              <td class="table-cell label-center-align">
                <div class="static-content-item">
                  <div class="jz">采购方代表人数</div>
                </div>
              </td>
              <td class="table-cell" colspan="2">
                <el-form-item label="" prop="buyNumber">
                  <el-input v-model="formData.buyNumber" type="text"></el-input>
                </el-form-item>
              </td>
            </tr>
            <tr>
              <td class="table-cell label-center-align">
                <div class="static-content-item">
                  <div class="jz">评标地点</div>
                </div>
              </td>
              <td class="table-cell" colspan="2">
                <el-form-item label="" prop="address">
                  <el-input v-model="formData.address" type="text"></el-input>
                </el-form-item>
              </td>
              <td class="table-cell label-center-align">
                <div class="static-content-item">
                  <div class="jz"></div>
                </div>
              </td>
              <td class="table-cell" colspan="2">
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </el-form>

    <!-- 随机抽取专家设置 -->
    <div>


      <!-- 设置回避专家 -->
      <div class="card-container">
        <div slot="header" class="clear-fix">
          <span>{{zjbt}}</span>
        </div>
        <el-row>
          <el-button type="primary" icon="el-icon-plus" size="mini" @click="handleAddDetails2">添加</el-button>
          <el-button type="success" icon="el-icon-delete" size="mini" @click="handleDeleteDetails2">删除</el-button>
          <el-button type="danger" icon="el-icon-delete" size="mini" @click="handleDeleteAllDetails2">清空</el-button>
        </el-row>
        <el-row>
          <el-table :data="zhuanjiaList" :row-class-name="tableRowClassName" @row-click="dj" @selection-change="cc"
            ref="tb" style="width: 100%;">
            <el-table-column type="selection" width="80" align="center" />
            <el-table-column label="序号" type="index" />
            <el-table-column label="专家姓名" align="center" prop="name">
              <template slot-scope="scope">
                <el-input v-model="scope.row.name">
                  <i style="color: #0e97ff; font-weight: 800; font-size: 16px;" slot="suffix"
                    class="el-input__icon el-icon-search" @click="xszj=true"></i>
                </el-input>
              </template>
            </el-table-column>
            <el-table-column label="身份证号" align="center" prop="idCard" />
            <el-table-column label="联系方式" align="center" prop="phone" />
            <el-table-column label="评标专业" align="center" prop="poolId">
              <template slot-scope="scope">
                <dict-tag :options="dict.type.pool_type" :value="scope.row.poolId" />
              </template>
            </el-table-column>
          </el-table>
        </el-row>
      </div>


      <!-- 抽取条件 -->
      <div class="card-container" v-show="isShoy">
        <div slot="header" class="clear-fix">
          <span>抽取条件设置</span>
        </div>
        <el-row>
          <el-button type="primary" icon="el-icon-plus" size="mini" @click="handleAddDetails">添加</el-button>
          <el-button type="success" icon="el-icon-delete" size="mini" @click="handleDeleteDetails">删除</el-button>
          <el-button type="danger" icon="el-icon-delete" size="mini" @click="handleDeleteAllDetails">清空</el-button>
        </el-row>
        <el-row>
          <el-table :data="tiaojianList" :row-class-name="tableRowClassName"
            @selection-change="chandleDetailSelectionChange" ref="tb" style="width: 100%;">
            <el-table-column type="selection" width="80" align="center" />
            <el-table-column label="序号" type="index" />
            <el-table-column label="评标专业" align="center" prop="specialized">
              <template slot-scope="scope">
                <el-select v-model="scope.row.specialized" placeholder="请选择评标专业">
                  <el-option v-for="dict in dict.type.pool_type" :key="dict.value" :label="dict.label"
                    :value="parseInt(dict.value)"></el-option>
                </el-select>
              </template>
            </el-table-column>
            <el-table-column label="抽取人数" align="center" prop="number">
              <template slot-scope="scope">
                <el-input-number v-model="scope.row.number" class="full-width-input" controls-position="right" :min="1"
                  :max="formData.expertsNumber" :precision="0" :step="1">
                </el-input-number>
              </template>
            </el-table-column>
          </el-table>
        </el-row>
      </div>


    </div>


    <div style="float: right;margin-top: 15px;height: 70px;">
      <el-button v-if="xg==null" type="primary" plain size="medium" @click="submitForm">提交</el-button>
      <el-button type="success" plain size="medium" @click="$router.back()">返回</el-button>
    </div>

    <!-- 选择专家组件 -->
    <el-dialog :title="zjbt" :visible.sync="xszj" :before-close="handleClose">
      <el-form :model="queryParams2" ref="vForm" label-position="left" label-width="70px" size="medium"
        @submit.native.prevent>
        <el-row>
          <el-col :span="8" class="grid-cell">
            <el-form-item label="专家名称" label-width="100px" prop="name" class="label-right-align">
              <el-input v-model="queryParams2.name" type="text" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="10" class="grid-cell">
            <el-form-item label="评标专业" label-width="100px" class="label-right-align" align="center" prop="poolId">
              <el-select v-model="queryParams2.poolId" clearable>
                <el-option v-for="dict in dict.type.pool_type" :key="dict.value" :label="dict.label"
                  :value="parseInt(dict.value)"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="6" class="grid-cell">
            <div class="static-content-item">
              <el-button icon="el-icon-search" @click="findExpertList">搜索</el-button>
            </div>
          </el-col>
        </el-row>
      </el-form>

      <el-table v-loading="loading" height="325" @row-dblclick="doubleclik" :data="expertList" ref="multipleTable"
        @row-click="handleSelectionChange(scope.row)" @selection-change="hs">
        <el-table-column type="selection" width="70" align="center" />
        <el-table-column label="专家姓名" align="center" prop="name" />
        <el-table-column label="身份证号" align="center" prop="idCard" />
        <el-table-column label="联系方式" align="center" prop="phone" />
        <el-table-column label="评标专业" align="center" prop="poolId">
          <template slot-scope="scope">
            <dict-tag :options="dict.type.pool_type" :value="scope.row.poolId" />
          </template>
        </el-table-column>
      </el-table>
      <pagination v-show="total2>0" :total="total2" :page.sync="queryParams2.pageNum"
        :limit.sync="queryParams2.pageSize" @pagination="findExpertList" />
      <el-button type="primary" style="margin-left: 20px;" @click="qd">确 定</el-button>
      <el-button @click="handleClose">取 消</el-button>
    </el-dialog>

    <!-- 添加招标项目组件 -->
    <el-dialog title="选择招标项目" :visible.sync="dialogFormVisible">
      <el-form :model="queryParams" ref="vForm" label-position="left" label-width="80px" size="medium"
        @submit.native.prevent>
        <el-row>
          <el-col :span="10" class="grid-cell">
            <el-form-item label="招标项目名称" label-width="150px" prop="name" class="label-right-align">
              <el-input v-model="queryParams.name" type="text" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="6" class="grid-cell">
            <div class="static-content-item">
              <el-button icon="el-icon-search" @click="getList">搜索</el-button>
            </div>
          </el-col>
        </el-row>
      </el-form>

      <el-table v-loading="loading" height="325" @row-dblclick="db" :data="tenderNoticeList" ref="multipleTable"
        @row-click="handleSelectionChanges(scope.row)">
        <!-- <el-table-column label="项目ID" align="center" prop="tenderProjectsId" /> -->
        <el-table-column label="项目编号" align="center" prop="tender_projects_number" />
        <el-table-column label="项目名称" align="center" prop="tender_title" />
        <el-table-column label="资格审查方式" align="center" prop="must">
          <template>
            {{must?'资格预审':'资格后审'}}
          </template>
        </el-table-column>
      </el-table>
      <pagination v-show="total>0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
        @pagination="getList" />
      <!-- <el-button @click="qd">确定</el-button> -->
    </el-dialog>

    <!-- 抽取动画 -->

  </div>
</template>

<script>
  import {
    getTender_projects,
  } from "@/api/bidding/tender_projects";
  import {
    getToken
  } from '../../../utils/auth'

  export default {
    components: {},
    props: {},
    dicts: ['pool_type'],
    data() {
      return {
        id: null,
        ids: [],
        dialogFormVisible: false,
        xszj: false,
        maxindex: 1,
        bt: "抽取专家",
        zjbt: "设置回避专家",
        total: 0,
        total2: 0,
        queryParams: {
          name: null,
          pageNum: 1,
          pageSize: 10,
        },
        queryParams2: {
          name: null,
          poolId: null,
          pageNum: 1,
          pageSize: 10,
        },
        formData: {
          number: "自动生成",
          // drawExpertId: [],
          drawProjectsId: null,
          must: 0,
          manner: 0,
          conditions: null,
          // evadeExperts: [],
          expertsNumber: 1,
          buyNumber: null,
          address: null,
          state: 0,
        },
        // 项目数据集合
        tenderNoticeList: [],
        // 抽取条件
        tiaojianList: [{
          specialized: null,
          number: 0,
        }],
        //选中的从表数据
        checkedDetail: [],
        // 专家数据集合
        expertList: [],
        // 选择专家集合
        zhuanjiaList: [{
          name: null,
          idCard: null,
          phone: null,
          poolId: null,
          expertId: null,
        }],
        ids: [],
        rowid: null,
        isShoy: true,
        dxzj: [],
        showPersent: false,
        percentNum: 0,
        timer: null,
      }
    },
    watch: {},
    created() {
      let bh = this.$route.params.id + "";
      // 使用split方法拆分字符串
      const params = bh.split("&");
      let thet = this;
      // 遍历拆分后的参数数组，并将参数拆分成键值对
      params.forEach(param => {
        const [key, value] = param.split("=");
        if (key === "id") {
          thet.id = value;
        } else if (key === "nid") {
          thet.nid = value;
        } else if (key === "xg") {
          thet.xg = value;
        }
      });
      console.log(this.nid)
      // this.findTenderNoticeList();
      this.findExpertList();
      getTender_projects(this.id).then(response => {
        this.formData.tenderProjectsName = response.data.tenderProjectsName;

        this.formData.must = response.data.must;
      });



    },
    mounted() {},

    computed: {

    },
    methods: {
      submitForm() {
        if (this.formData.manner === null || this.formData.address === null) {
          this.$modal.msgWarning("请填写完整信息");
          return;
        }
        const fd = new FormData();
        console.log("数据")
        console.log(this.formData)
        console.log("条件")
        console.log(this.tiaojianList)
        console.log("专家")
        console.log(this.zhuanjiaList)
        this.formData.createBy = this.$store.state.user.name;
        this.formData.drawProjectsId = this.id;
        fd.append("data", JSON.stringify(this.formData))
        fd.append("tj", JSON.stringify(this.tiaojianList))
        fd.append("zj", JSON.stringify(this.zhuanjiaList))
        var loading = null;
        if (this.isShoy) {
          loading = this.$loading({
            lock: true,
            text: '正在抽取... ',
            spinner: 'el-icon-loading',
            background: 'rgba(0, 0, 0, 0.7)'
          });
          // return
        }

        axios.post('/dev-api/bidding/draw_experts/addDrawExperts', fd, {
            headers: {
              'Authorization': `Bearer ${getToken()}`,
              'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
            },
          })
          .then(response => {
            if (response.data === 1) {
                if (!this.isShoy) {
                  this.$modal.msgSuccess("抽取成功");
                  this.$router.go(-1)
                  return
                }
              setTimeout(() => {
                loading.close();
                this.$modal.msgSuccess("抽取成功");
                this.$router.go(-1)
              }, 1250);
            }
          })
      },
      findExpertList() {

        let fd = new FormData()
        fd.append("name", this.queryParams2.name)
        console.log(this.queryParams2.poolId)
        fd.append("poolId", this.queryParams2.poolId)

        axios.post('/dev-api/bidding/expert/findExpertList', fd, {
            headers: {
              'Authorization': `Bearer ${getToken()}`,
              'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
            },
          })
          .then(response => {
            console.log(response)
            this.expertList = response.data.rows
            this.total2 = response.data.total
          })
      },
      handleSelectionChange(row) {
        this.dxzj = row;
        this.$refs.multipleTable.clearSelection();
      },
      hs(selection) {
        this.dxzj = selection;
        this.single = selection.length !== 1
        this.multiple = !selection.length
      },
      dj(row) {
        console.log(row)
        this.rowid = row.xh
        this.single = selection.length !== 1
        this.multiple = !selection.length
      },
      qd() {
        // this.$refs.multipleTable.clearSelection();
        console.log(this.dxzj)
        this.zhuanjiaList.forEach((x, y) => {
          this.dxzj.forEach((e, i) => {
            if (e.expertId != this.zhuanjiaList[y].expertId) {
              this.zhuanjiaList.push({
                name: e.name,
                idCard: e.idCard,
                phone: e.phone,
                poolId: e.poolId,
                expertId: e.expertId,
              })
            }
          })
        })
        this.handleClose()
      },
      handleClose() {
        this.dxzj = null
        console.log(this.dxzj)
        this.xszj = false;
      },
      doubleclik(row) {
        let thet = this;
        console.log(this.rowid)
        this.zhuanjiaList.forEach((e, i) => {
          if (e.xh === thet.rowid) {
            e.name = row.name;
            e.idCard = row.idCard;
            e.phone = row.phone;
            e.poolId = row.poolId;
            e.expertId = row.expertId;
          }
        })
        this.handleClose()
      },
      // 专家确定方式
      handleRadioChange(value) {
        this.zjbt = value ? "选择专家" : "设置回避专家"
        this.isShoy = value ? false : true;
        this.zhuanjiaList = [];
        this.zhuanjiaList.push({
          name: null,
          idCard: null,
          phone: null,
          poolId: null,
          expertId: null,
        })
        // console.log('选择了：', value);
      },

      jsprice() {
        // let num = this.formData.expertsNumber;
        // let em = 0;
        // for (var i = 0; i < this.tiaojianList.length; i++) {
        //   em += this.tiaojianList[i].number;
        // }
        // this.maxindex = em / this.tiaojianList.length
      },
      findTenderNoticeList() {
        let fd = new FormData();
        fd.append("id", this.id)
        fd.append("name", this.queryParams.name)
        axios.post('/dev-api/bidding/tender_notice/findTenderNoticeList', fd, {
            headers: {
              'Authorization': `Bearer ${getToken()}`,
              'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
            },
          })
          .then(response => {
            console.log(response)
            this.tenderNoticeList = response.data.rows
            this.total = response.data.total
          })
      },
      handleclo() {
        this.$refs.multipleTable.clearSelection()
      },
      db(row) {
        this.ids = row;
        this.handleclo()
        console.log(this.ids)
        this.formData.drawProjectsId = this.ids.tender_notice_id;
        this.formData.must = this.ids.must;
        this.formData.tenderProjectsName = this.ids.tender_title;
        this.dialogFormVisible = false;
      },
      ss() {
        this.dialogFormVisible = true,
          this.findTenderNoticeList()
      },

      tableRowClassName({
        row,
        rowIndex
      }) {
        row.xh = rowIndex + 1;
        if (rowIndex % 2 === 0) {
          return 'success-row' //这是类名
        } else {
          return ''
        }
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
      //单选框选中数据
      cc(selection) {
        // this.dxzj = selection
        if (selection.length > 1) {
          this.$refs.tb.clearSelection();
          this.$refs.tb.toggleRowSelection(selection.pop());
        } else {
          this.checkedDetail = selection;
        }
      },

      handleAddDetails() {
        if (this.tiaojianList === undefined) {
          this.tiaojianList = new Array();
        }
        this.tiaojianList.push({
          specialized: null,
          number: 0,
        });
      },
      // 删除
      handleDeleteDetails() {
        if (this.checkedDetail.length > 0) {
          this.tiaojianList.splice(this.checkedDetail[0].xh - 1, 1);
        } else {
          this.$alert("请先选择要删除的数据", "提示", {
            confirmButtonText: "确定",
          });
        }
      },
      //清空
      handleDeleteAllDetails() {
        this.tiaojianList = undefined;
      },
      handleAddDetails2() {

        if (this.zhuanjiaList === undefined) {
          this.zhuanjiaList = new Array();
        }
        if (!this.isShoy) {
          if (this.zhuanjiaList.length === this.formData.expertsNumber) {
            this.$modal.msgWarning("选着专家总数量不能大于专家人数");
            return
          }
        }
        this.zhuanjiaList.push({
          name: null,
          idCard: null,
          phone: null,
          poolId: null,
          expertId: null,
        });
      },
      // 删除
      handleDeleteDetails2() {
        if (this.checkedDetail.length > 0) {
          this.zhuanjiaList.splice(this.checkedDetail[0].xh - 1, 1);
        } else {
          this.$alert("请先选择要删除的数据", "提示", {
            confirmButtonText: "确定",
          });
        }
      },
      //清空
      handleDeleteAllDetails2() {
        this.zhuanjiaList = undefined;
      }
    }
  }
</script>

<style lang="scss">
  .top2 {
    width: 100%;
    height: 140px;
    background-color: white;

    h1 {
      float: left;
      font-size: 30px;
      margin: 37px;
      font-weight: 600;
      margin-left: 330px;
      color: #269fff;
    }
  }
</style>
<style>
  .xhz {
    margin: 0 auto;
    width: 1100px;
    height: 100%;
    padding: 0px 10px 10px 10px;



    .clear-fix {
      margin: 16px;
    }

    .el-input--medium .el-input__inner {
      border: 0;
    }

    .el-input__inner {
      text-align: center;
    }

    .el-table td.el-table__cell,
    .el-table th.el-table__cell.is-leaf {
      border-bottom: 0px;
    }

    .success-row {
      background-color: #FFF;
    }

    .el-table::before {
      width: 0px !important;
    }


  }
</style>

<style>
  .el-loading-spinner i {
    font-size: 60px !important;
  }

  .el-loading-spinner .el-loading-text {
    font-size: 20px !important;
  }
</style>

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

  .myclss .el-form-item__content {
    margin-left: 1px !important;
  }
</style>
