<template>
  <div>
    <!-- <div class="static-content-item">
        <el-alert title="" type=info :closable="false" :center="true" :show-icon="false" effect="light">
        </el-alert>
      </div> -->
    <el-tabs @tab-click="findNotice" value="first">

      <el-tab-pane label="招标项目" name="first">
        <div>
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
                        <el-input v-model="formData.tenderProjectsName" type="text" :readonly="true"></el-input>
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
                        <el-radio-group :readonly="true" v-model="formData.manner">
                          <el-radio :disabled="true" v-for="(item, index) in mannerOptions" :key="index"
                            :label="item.value" style="{display: inline}">{{ item.label }}</el-radio>
                        </el-radio-group>
                      </el-form-item>
                    </td>
                    <td class="table-cell label-center-align">
                      <div class="static-content-item">
                        <div class="jz">项目预算</div>
                      </div>
                    </td>
                    <td class="table-cell" colspan="2">
                      <el-form-item style="text-align: center;" label="" label-width="1px" prop="tenderProjectsMoney" class="required">
                      {{formData.tenderProjectsMoney|formattedAmount}}
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
                          <el-radio :disabled="true" v-for="(item, index) in mustOptions" :key="index"
                            :label="item.value" style="{display: inline}">{{ item.label }}</el-radio>
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
                        <el-select v-model="formData.projectsType" class="full-width-input" :readonly="true">
                          <el-option :disabled="true" v-for="dict in dict.type.projects_type" :key="dict.value"
                            :label="dict.label" :value="parseInt(dict.value)"></el-option>
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
                        <el-input v-model="formData.tenderProjectsContact" type="text" :readonly="true"></el-input>
                      </el-form-item>
                    </td>
                    <td class="table-cell label-center-align">
                      <div class="static-content-item">
                        <div class="jz">地址</div>
                      </div>
                    </td>
                    <td class="table-cell" colspan="2">
                      <el-form-item label="" label-width="1px" prop="tenderProjectsAddress" class="required">
                        <el-input v-model="formData.tenderProjectsAddress" type="text" :readonly="true"></el-input>
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
                        <el-input v-model="formData.tenderProjectsPhone" type="text" :readonly="true"></el-input>
                      </el-form-item>
                    </td>
                    <td class="table-cell label-center-align">
                      <div class="static-content-item">
                        <div class="jz">备注</div>
                      </div>
                    </td>
                    <td class="table-cell" colspan="2">
                      <el-form-item label="" label-width="1px" prop="remark">
                        <el-input v-model="formData.remark" type="text" :readonly="true"></el-input>
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
                        <el-input v-model="formData.tenderProjectsEmail" type="text"></el-input>
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
          <!-- -->
          <el-row>
          </el-row>
          <el-row>
            <el-table :row-class-name="tableRowClassName" :data="manifestList"
              @selection-change="chandleDetailSelectionChange" ref="tb" style="width: 100%;" @row-click="dj">

              <el-table-column type="selection" width="30" align="center" />

              <el-table-column label="物品编码" align="center" prop="goodsCode" width="300">
                <template slot-scope="scope">
                  <el-input v-model="scope.row.goodsCode" :readonly="true">
                    <i slot="suffix" class="el-input__icon el-icon-search" @click="addOrUpdateVisible = true"></i>
                  </el-input>
                </template>
              </el-table-column>
              <el-table-column label="物品名称" align="center" prop="goodsName" width="300">
                <template slot-scope="scope">
                  <el-input v-model="scope.row.goodsName" :readonly="true">
                    <i slot="suffix" class="el-input__icon el-icon-search" @click="addOrUpdateVisible = true"></i>
                  </el-input>
                </template>
              </el-table-column>
              <el-table-column label="单价" align="center" prop="available" width="200">
                <template slot-scope="scope">
                  <!-- <el-input v-model="scope.row.price" :readonly="true"></el-input> -->
                  {{scope.row.price|formattedAmount}}
                </template>
              </el-table-column>

              <el-table-column label="数量" align="center" prop="exempt" width="200">
                <template slot-scope="scope">
                  <el-input-number :disabled="true" v-model="scope.row.explains" class="full-width-input"
                    controls-position="right" :min="1" :max="100000000000" :precision="0" :step="1">
                  </el-input-number>
                </template>
              </el-table-column>

              <el-table-column label="总价" align="center" prop="exempt" width="200">
                <template slot-scope="scope">
                  <!-- <el-input v-model="scope.row.prices" :readonly="true"></el-input> -->
                  {{scope.row.prices|formattedAmount}}
                </template>
              </el-table-column>

              <el-table-column label="计量单位" align="center" prop="grade" width="200">
                <template slot-scope="scope">
                  <el-select v-model="scope.row.manifestTypeId" placeholder="请选择单位">
                    <el-option :disabled="true" v-for="dict in dict.type.goods_unit" :key="dict.value"
                      :label="dict.label" :value="parseInt(dict.value)"></el-option>
                  </el-select>
                </template>
              </el-table-column>

              <el-table-column label="备注" align="center" prop="exempt" width="200">
                <template slot-scope="scope">
                  <el-input v-model="scope.row.remark" :readonly="true"></el-input>
                </template>
              </el-table-column>

            </el-table>

          </el-row>
        </div>
      </el-tab-pane>
      <el-tab-pane label="招标公告" name="second">
        <div>
          <el-row :gutter="10" class="mb8">
            <el-col :span="1.5" v-if="state!=4">
              <router-link :to="'/insertNotice/id=' + id">
                <el-button type="success" plain icon="el-icon-plus" size="small">新增</el-button>
              </router-link>
            </el-col>
          </el-row>
          <el-table v-loading="loading" :data="tenderNoticeList" @row-click="dj" :row-class-name="tableRowClassName">
            <el-table-column label="项目编号" align="center">
              <template>
                {{ tenderProjectsNumber }}
              </template>
            </el-table-column>
            <el-table-column label="公告标题" align="center" prop="tenderTitle" />
            <el-table-column label="关联项目" align="center" prop="tenderProjectsName">
              <template>
                {{ tenderProjectsName }}
              </template>
            </el-table-column>

            <el-table-column label="审批状态" align="center" prop="state">
              <template slot-scope="scope">
                <dict-tag :options="dict.type.notice_state" :value="scope.row.state" />
              </template>
            </el-table-column>

            <el-table-column label="操作" align="center" prop="state" class-name="small-padding fixed-width">
              <template slot-scope="scope">
                <router-link :to="'/insertNotice/id=' + id + '&nid=' + scope.row.tenderNoticeId">
                  <el-button v-if="scope.row.state == 0" size="mini" type="text" icon="el-icon-edit"
                    @click="handleUpdate(scope.row)" v-hasPermi="['pms/bidding:tender_projects:edit']">修改</el-button>
                </router-link>

                <el-button v-if="scope.row.state == 2" size="mini" type="text" icon="el-icon-delete"
                  @click="handleDelete(scope.row)" v-hasPermi="['pms/bidding:tender_projects:remove']">删除</el-button>
                <!-- <el-button v-if="scope.row.auditState==1" size="mini" type="text" @click="handleDelete(scope.row)"
            >进入项目</el-button> -->

                <router-link :to="'/insertNotice/id=' + id + '&nid=' + scope.row.tenderNoticeId + '&xg=' + 'xg'">
                  <el-button v-if="scope.row.state == 1" size="mini" type="text" icon="el-icon-search">查看详情</el-button>
                </router-link>

                <el-button v-if="scope.row.state == 0 || scope.row.state == 2" size="mini" type="text"
                  icon="el-icon-s-check" @click="opens = true">审批</el-button>
              </template>
            </el-table-column>
          </el-table>
        </div>
      </el-tab-pane>
      <el-tab-pane label="招标文件" name="third">
        <div>
          <el-table v-loading="loading" :data="annexList" @row-click="dj" :row-class-name="tableRowClassName">
            <el-table-column label="序号" type="index"/>
            <el-table-column label="文件标题" align="center" prop="annex_title" />

            <el-table-column label="关联公告" align="center" prop="tender_title" />
            <el-table-column label="上传时间" align="center" prop="up_time">
              <template slot-scope="scope">
                <span>{{ parseTime(scope.row.up_time, '{y}-{m}-{d} {h}:{mi}') }}</span>
              </template>
            </el-table-column>
            <el-table-column label="操作" align="center" prop="state" class-name="small-padding fixed-width">
              <template slot-scope="scope">
                <el-button size="mini" type="text" icon="el-icon-search" @click="filePreview(scope.row)">预览</el-button>
                <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)">删除</el-button>
                <el-button size="mini" type="text" icon="el-icon-download"
                  @click="xiazai(scope.row.annex_url)">下载</el-button>
              </template>
            </el-table-column>
          </el-table>
          <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNum"
            :limit.sync="queryParams.pageSize" @pagination="findAnnexList" />
        </div>
      </el-tab-pane>
    </el-tabs>
    <!-- 审批--修改状态弹窗 -->
    <el-dialog :title="title" :visible.sync="opens" width="500px" append-to-body>
      <el-form label-width="150px">
        <el-form-item label="审批状态" style="width: 400px;">
          <el-select v-model="jg" placeholder="请确定审批结果">
            <el-option v-for="dict in dict.type.notice_state" :key="dict.value" :label="dict.label"
              :value="parseInt(dict.value)"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="xgzt">确 定</el-button>
        <el-button @click="opens = false">取 消</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
  import {
    getToken
  } from '../../utils/auth';
  import {
    delAnnex
  } from "@/api/bidding/tender_notice";
  // import MyFilePreview from '@/components/FilePreview';

  export default {
    components: {},
    props: {},
    dicts: ['projects_type', 'goods_unit', 'notice_state'],
    data() {
      return {
        id: this.tid,
        state:this.state,
        rowid: null,
        jg: null,
        opens: false,
        tenderNoticeList: [],
        tenderProjectsName: null,
        tenderProjectsNumber: null,
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
        // 总条数
        total: 0,
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
        },
        annexList: [],
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
      }
    },
    props: ['tid','state'],
    mounted() {

    },
    filters: {
      formattedAmount(value) {
        return new Intl.NumberFormat("zh-CN", {
          style: "currency",
          currency: "CNY",
        }).format(value);
      },
    },
    created() {
      let str = this.id;
      let parts = str.split("&"); // 使用 & 分割字符串
      let firstPart = parts[0]; // 获取第一个部分
      let secondPart = parts[1]; // 获取第二个部分
      console.log(firstPart); // 输出 "11"
      console.log(secondPart); // 输出 "1"
      this.id = firstPart;
      this.state = secondPart;


      this.findNotice2();
      this.findObject();
      this.findAnnexList();
    },
    methods: {
      findAnnexList() {
        let fd = new FormData();
        fd.append("pid", this.id)
        this.manifestList = []
        axios.post('/dev-api/bidding/annex/findAnnexByTenderProjectsId', fd, {
            headers: {
              'Authorization': `Bearer ${getToken()}`,
              'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
            },
          })
          .then(response => {
            // this.$modal.msgSuccess("数据加载成功");
            // 处理响应
            console.log(response)
            this.total = response.data.total
            this.annexList = response.data.rows

          })
      },
      tableRowClassName({
        row,
        rowIndex
      }) {
        if (rowIndex % 2 === 0) {
          return 'success-row' //这是类名
        } else {
          return ''
        }
      },
      xiazai(url) {
        window.location.href = url
      },
      findObject() {
        let fd = new FormData();
        fd.append("id", this.id)
        this.manifestList = []
        axios.post('/dev-api/bidding/tender_projects/findProjectById', fd, {
            headers: {
              'Authorization': `Bearer ${getToken()}`,
              'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
            },
          })
          .then(response => {
            // this.$modal.msgSuccess("数据加载成功");
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
      },
      findNotice2() {
        let fd = new FormData();
        fd.append("pid", this.id)
        fd.append("tid", null);
        axios.post('/dev-api/bidding/tender_notice/findNoticeById', fd, {
            headers: {
              'Authorization': `Bearer ${getToken()}`,
              'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
            },
          })
          .then(response => {
            this.$modal.msgSuccess("数据加载成功");
            // 处理响应
            this.tenderNoticeList = response.data.data.list
            this.tenderProjectsNumber = response.data.data.tenderProjectsNumber;
            this.tenderProjectsName = response.data.data.tenderProjectsName;
            console.log(this.tenderNoticeList);
          })
      },
      handleAdd() {
        this.$router.push({
          path: 'insertNotice',
          params: {
            vid: null
          }
        });
      },
      xgzt() {
        this.opens = false;
        console.log("ID：" + this.rowid)
        let thet = this;
        let fd = new FormData();
        fd.append("id", this.rowid)
        fd.append("zt", this.jg)
        axios.post('/dev-api/bidding/tender_notice/updateStates', fd, {
            headers: {
              'Authorization': `Bearer ${getToken()}`,
              'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
            },
          })
          .then(response => {
            if (response.data == 1) {
              thet.findNotice2()
            }
          })

      },
      dj(row) {
        this.rowid = row.tenderNoticeId
      },
      findNotice(tab, event) { // 查询项目公告列表
        // //console.log(tab.index)
        // if (tab.index === "0") {
        //   //this.findObject();
        // } else if (tab.index === '1') {

        // } else if (tab.index === "2") {
        //   console.log("招标文件")
        // }

      },
      /** 删除按钮操作 */
      handleDelete(row) {
        const annexIds = row.annex_id;
        this.$modal.confirm('是否确认删除' + row.annex_title).then(function() {
          return delAnnex(annexIds);
        }).then(() => {
          this.findAnnexList();
          this.$modal.msgSuccess("删除成功");
        }).catch(() => {});
      },
      // 文件预览
      filePreview(row) {

      },
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


</style>
