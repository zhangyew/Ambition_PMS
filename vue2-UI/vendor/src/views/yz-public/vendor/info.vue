<template>
  <div style="padding: 30px;" class="gyshz">
    <div class="top">
      <div id="top_img" style="width: 100px; float: left">
        <img src="@/assets/logo/logo2.jpg" alt="donate" height="100px" width="230px" />
      </div>
      <h1>基本信息</h1>
      <div style="float: right;margin-top: 15px;height: 70px;">
        <el-button type="success" plain size="medium" @click="$router.back()">返回</el-button>
      </div>
    </div>

    <div style="margin-top: 20px;">
      <el-tabs>
        <el-tab-pane>
          <span slot="label"><i class="el-icon-paperclip"></i> 基本信息</span>
          <el-form :model="vendorList" label-position="left" label-width="80px" size="medium" @submit.native.prevent>
            <div class="table-container">
              <table class="table-layout">
                <tbody>
                  <tr>
                    <td class="table-cell label-center-align">
                      <div class="static-content-item">
                        <div class="jz">供应商名称</div>
                      </div>
                    </td>
                    <td class="table-cell">
                      <div class="static-content-item">
                        <div class="bgwz">{{vendorList.abbreviated}}</div>
                      </div>
                    </td>
                    <td class="table-cell label-center-align">
                      <div class="static-content-item">
                        <div class="jz">供应商编号</div>
                      </div>
                    </td>
                    <td class="table-cell">
                      <div class="static-content-item">
                        <div class="bgwz">{{vendorList.vendorNumber}}</div>
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td class="table-cell label-center-align">
                      <div class="static-content-item">
                        <div class="jz">服务范围</div>
                      </div>
                    </td>
                    <td class="table-cell">
                      <div class="static-content-item">
                        <div class="bgwz">{{vendorList.ranges}}</div>
                      </div>
                    </td>
                    <td class="table-cell label-center-align">
                      <div class="static-content-item">
                        <div class="jz">注册时间</div>
                      </div>
                    </td>
                    <td class="table-cell">
                      <div class="static-content-item">
                        <div class="bgwz">{{vendorList.addTime}}</div>
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td class="table-cell label-center-align">
                      <div class="static-content-item">
                        <div class="jz">负责人</div>
                      </div>
                    </td>
                    <td class="table-cell">
                      <div class="static-content-item">
                        <div class="bgwz">{{vendorList.responsible}}</div>
                      </div>
                    </td>
                    <td class="table-cell label-center-align">
                      <div class="static-content-item">
                        <div class="jz">负责人手机号</div>
                      </div>
                    </td>
                    <td class="table-cell">
                      <div class="static-content-item">
                        <div class="bgwz">{{vendorList.responsiblePhone}}</div>
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td class="table-cell label-center-align">
                      <div class="static-content-item">
                        <div class="jz">合同类型</div>
                      </div>
                    </td>
                    <td class="table-cell">
                      <div class="static-content-item">
                        <div class="bgwz"><dict-tag :options="dict.type.contract_type"
                            :value="vendorList.contractTypeTypeId" /></div>
                      </div>
                    </td>
                    <td class="table-cell label-center-align">
                      <div class="static-content-item">
                        <div class="jz">仓库地址</div>
                      </div>
                    </td>
                    <td class="table-cell">
                      <div class="static-content-item">
                        <div class="bgwz">{{vendorList.warehouseAddress}}
                        </div>
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td class="table-cell label-center-align">
                      <div class="static-content-item">
                        <div class="jz">注册方式</div>
                      </div>
                    </td>
                    <td class="table-cell">
                      <div class="static-content-item">
                        <div class="bgwz" style="color: #1d77ff;">{{vendorList.isExist?"供应商PC注册":"管理员现场注册"}}</div>
                      </div>
                    </td>
                    <td class="table-cell label-center-align">
                      <div class="static-content-item">
                        <div class="jz">状态</div>
                      </div>
                    </td>
                    <td class="table-cell">
                      <div class="static-content-item">
                        <div class="bgwz"><dict-tag :options="dict.type.vendor_state"
                            :value="vendorList.vendorTypeStateId" /></div>
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td class="table-cell" colspan="4">
                      <div class="static-content-item">
                        <div class="bt">账户信息</div>
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td class="table-cell label-center-align">
                      <div class="static-content-item">
                        <div class="jz">法定代表</div>
                      </div>
                    </td>
                    <td class="table-cell" colspan="3">
                      <div class="static-content-item">
                        <div class="bgwz">{{vendorList.delegates}}</div>
                      </div>
                    </td>
                  </tr>

                  <tr>
                    <td class="table-cell label-center-align">
                      <div class="static-content-item">
                        <div class="jz">银行名称</div>
                      </div>
                    </td>
                    <td class="table-cell">
                      <div class="static-content-item">
                        <div class="bgwz">{{vendorList.bankingName}}</div>
                      </div>
                    </td>
                    <td class="table-cell label-center-align">
                      <div class="static-content-item">
                        <div class="jz">银行卡号</div>
                      </div>
                    </td>
                    <td class="table-cell">
                      <div class="static-content-item">
                        <div class="bgwz">{{vendorList.industrialCommercial}}</div>
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td class="table-cell label-center-align">
                      <div class="static-content-item">
                        <div class="jz">邮箱</div>
                      </div>
                    </td>
                    <td class="table-cell">
                      <div class="static-content-item">
                        <div class="bgwz">{{vendorList.email}}</div>
                      </div>
                    </td>
                    <td class="table-cell label-center-align">
                      <div class="static-content-item">
                        <div class="jz">传真</div>
                      </div>
                    </td>
                    <td class="table-cell">
                      <div class="static-content-item">
                        <div class="bgwz">{{vendorList.fax}}</div>
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td class="table-cell label-center-align">
                      <div class="static-content-item">
                        <div class="jz">公司简介</div>
                      </div>
                    </td>
                    <td class="table-cell">
                      <div class="static-content-item">
                        <div class="bgwz">{{vendorList.profile}}</div>
                      </div>
                    </td>
                    <td class="table-cell label-center-align">
                      <div class="static-content-item">
                        <div class="jz">注册原因</div>
                      </div>
                    </td>
                    <td class="table-cell">
                      <div class="static-content-item">
                        <div class="bgwz">{{vendorList.causes}}</div>
                      </div>
                    </td>
                  </tr>
                </tbody>
              </table>
            </div>
          </el-form>
        </el-tab-pane>
        <el-tab-pane>
          <span slot="label"><i class="el-icon-position"></i> 投标信息</span>
          <div>
            <el-table style="width: 100%; overflow-x: scroll;" v-loading="loading" :data="tendorList" @row-click="dj"
              :row-class-name="tableRowClassName">
              <el-table-column fixed label="序号" type="index" />
              <el-table-column fixed label="投标状态" align="center" prop="state" width="150px">
                <template slot-scope="scope">
                  <dict-tag :options="dict.type.tender_state" :value="scope.row.state" />
                </template>
              </el-table-column>
              <el-table-column fixed label="招标项目名称" align="center" prop="tenderProjects" width="150px">
                <template slot-scope="scope">
                  {{scope.row.tenderProjects.tenderProjectsName}}
                </template>
              </el-table-column>
              <el-table-column label="招标编号" align="center" prop="tenderProjectsNumber" width="200px">
                <template slot-scope="scope">
                  {{scope.row.tenderProjects.tenderProjectsNumber}}
                </template>
              </el-table-column>
              <el-table-column label="开标地址" align="center" prop="tenderProjectsAddress" width="270px">
                <template slot-scope="scope">
                  {{scope.row.tenderProjects.tenderProjectsAddress}}
                </template>
              </el-table-column>
              <el-table-column label="招标负责人电话" align="center" prop="tenderProjectsPhone" width="130px">
                <template slot-scope="scope">
                  {{scope.row.tenderProjects.tenderProjectsPhone}}
                </template>
              </el-table-column>
              <el-table-column label="投标人名称" align="center" prop="tenderName" width="130px" />
              <el-table-column label="联系人" align="center" prop="contact" width="130px" />
              <el-table-column label="联系方式" align="center" prop="phone" width="130px" />
              <el-table-column label="成功投标时间" align="center" prop="tenderTime" width="200px">
                <template slot-scope="scope">
                  <span>{{ parseTime(scope.row.tenderTime, '{y}-{m}-{d} {h}:{mi}:{ss}') }}</span>
                  <!-- <span>{{scope.row.downloadTime}}</span> -->
                </template>
              </el-table-column>

              <el-table-column label="操作" align="center" prop="state" class-name="small-padding fixed-width"
                width="200px">
                <template slot-scope="scope">
                  /
                  <!-- <el-button v-if="scope.row.state == 1 || scope.row.state == 2" size="mini" type="text"
                    icon="el-icon-edit" @click="xzbs(scope.row)">下载标书 </el-button>
                  <el-button v-if="scope.row.state == 2" slot="reference" @click="opens=true" size="mini" type="text"
                    icon="el-icon-s-check">信息审核</el-button>
                  <el-button v-if="scope.row.state == 3" size="mini" type="text" icon="el-icon-check"></el-button>
                  <el-button v-if="scope.row.state == 4" size="mini" type="text" icon="el-icon-delete"
                    @click="scbs(scope.row)">删除标书</el-button> -->
                </template>
              </el-table-column>
            </el-table>
            <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNum"
              :limit.sync="queryParams.pageSize" @pagination="findTendorList" />
          </div>
        </el-tab-pane>
        <el-tab-pane>
          <span slot="label"><i class="el-icon-document-checked"></i> 企业资质</span>
          <div>
            <el-table style="width: 100%;overflow-x: scroll;" v-loading="loading" :data="annexList" @row-click="dj"
              :row-class-name="tableRowClassName">
              <el-table-column label="序号" type="index" />
              <el-table-column label="资质名称" align="center" prop="qualification_name" width="175px" />
              <el-table-column label="有效期起" align="center" prop="start_time" width="150px">
                <template slot-scope="scope">
                  <span>{{ parseTime(scope.row.start_time, '{y}-{m}-{d} {h}:{mi}') }}</span>
                </template>
              </el-table-column>
              <el-table-column label="有效期终" align="center" prop="stop_time" width="150px">
                <template slot-scope="scope">
                  <span>{{ parseTime(scope.row.stop_time, '{y}-{m}-{d} {h}:{mi}') }}</span>
                </template>
              </el-table-column>
              <el-table-column label="文件标题" align="center" prop="annex_title" width="250px" />
              <el-table-column label="上传时间" align="center" prop="up_time" width="150px">
                <template slot-scope="scope">
                  <span>{{ parseTime(scope.row.up_time, '{y}-{m}-{d} {h}:{mi}') }}</span>
                </template>
              </el-table-column>
              <el-table-column label="资质备注" align="center" prop="remark" width="200px" />
              <el-table-column label="操作" align="center" prop="state" class-name="small-padding fixed-width">
                <template slot-scope="scope">
                  <el-button size="mini" type="text" icon="el-icon-search"
                    @click="filePreview(scope.row)">预览</el-button>
                  <el-button size="mini" type="text" icon="el-icon-delete"
                    @click="handleDelete(scope.row)">删除</el-button>
                  <el-button size="mini" type="text" icon="el-icon-download"
                    @click="xiazai(scope.row.annex_url)">下载</el-button>
                </template>
              </el-table-column>
            </el-table>
          </div>
        </el-tab-pane>
        <el-tab-pane>
          <span slot="label"><i class="el-icon-mobile-phone"></i> 联系人信息</span>
          <div>
            <el-table v-loading="loading" :data="contactList" @row-click="dj" :row-class-name="tableRowClassName">
              <el-table-column label="序号" type="index" />
              <el-table-column label="联系人名称" align="center" prop="calls" />
              <el-table-column label="联系电话" align="center" prop="phone" />
              <el-table-column label="邮箱" align="center" prop="mailbox" />
              <el-table-column label="操作" align="center" prop="state" class-name="small-padding fixed-width">
                <template slot-scope="scope">
                  <el-button size="mini" type="text" icon="el-icon-delete"
                    @click="handleDelete(scope.row)">删除</el-button>
                  <el-button size="mini" type="text" icon="el-icon-download"
                    @click="xiazai(scope.row.annex_url)">下载</el-button>
                </template>
              </el-table-column>
            </el-table>
          </div>
        </el-tab-pane>
        <el-tab-pane>
          <span slot="label"><i class="el-icon-chat-dot-square"></i> 中标通知</span>
          <el-table v-loading="loading" :data="noticeList" @row-click="dj" :row-class-name="tableRowClassName">
            <el-table-column label="序号" type="index" />
            <el-table-column label="发送方" align="center" prop="buyer" />
            <el-table-column label="招标项目名称" align="center" prop="tender_projects_name" />
            <el-table-column label="通知编号" align="center" prop="notice_clod" />
            <el-table-column label="发送日期" align="center" prop="notice_date">
              <template slot-scope="scope">
                <span>{{ parseTime(scope.row.notice_date, '{y}-{m}-{d} {h}:{mi}:{ss}') }}</span>
              </template>
            </el-table-column>
            <el-table-column label="中标金额" align="center" prop="prices" />
            <el-table-column label="操作" align="center" prop="state" class-name="small-padding fixed-width">
              <template slot-scope="scope">
                <el-button size="mini" type="text" icon="el-icon-view" @click="nr(scope.row)">查看</el-button>
              </template>
            </el-table-column>
          </el-table>
        </el-tab-pane>
        <el-tab-pane>
          <span slot="label"><i class="el-icon-shopping-bag-2"></i> 供货信息</span>
          <el-table v-loading="loading" :data="supplyList" @selection-change="handleSelectionChange">
            <el-table-column type="selection" width="55" align="center" />
            <!-- <el-table-column label="供货ID" align="center" prop="supplyId" /> -->
            <el-table-column label="供应编码" align="center" prop="supplierCode">
              <template slot-scope="scope">
                <el-link style="color: #308aff !important;" type="primary"
                  @click="ckxx(scope.row.supplyId)">{{scope.row.supplierCode}}</el-link>
              </template>
            </el-table-column>
            <el-table-column label="供应商名称" align="center" prop="supplierName" />
            <el-table-column label="备注" align="center" prop="remark" />
            <el-table-column label="创建人" align="center" prop="createBy" />
            <el-table-column label="创建时间" align="center" prop="createTime" width="135">
              <template slot-scope="scope">
                <span>{{ parseTime(scope.row.createTime, '{y}-{m}-{d} {h}:{mi}') }}</span>
              </template>
            </el-table-column>
            <el-table-column label="修改人" align="center" prop="updateBy" />
            <el-table-column label="修改时间" align="center" prop="updateTime" width="135">
              <template slot-scope="scope">
                <span>{{ parseTime(scope.row.updateTime, '{y}-{m}-{d} {h}:{mi}') }}</span>
              </template>
            </el-table-column>
            <!-- <el-table-column label="启用" align="center" prop="isDelete" /> -->
            <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
              <template slot-scope="scope">
                <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                  v-hasPermi="['pms.public:supply:edit']">修改</el-button>
                <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                  v-hasPermi="['pms.public:supply:remove']">删除</el-button>
              </template>
            </el-table-column>
          </el-table>

          <pagination v-show="total2>0" :total="total2" :page.sync="queryParams2.pageNum"
            :limit.sync="queryParams2.pageSize" @pagination="getList" />
        </el-tab-pane>
      </el-tabs>
    </div>

    <!-- 通知内容富文本组件 -->
    <el-dialog title="中标通知正文" :visible.sync="open" width="900px" append-to-body>
      <editor v-model="tznr" :min-height="390" />
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="yesNR">确 定</el-button>
        <el-button @click="open=false">取 消</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
  import {
    getToken
  } from '../../../utils/auth';
  import {
    listSupply,
  } from "@/api/public/supply";
import axios from 'axios';
  export default {
    dicts: ['contract_type', 'vendor_state', 'tender_state'],
    data() {
      return {
        vid: 0,
        vendorList: {},
        tendorList: [],
        annexList: [],
        contactList: [],
        noticeList: [],
        supplyList: [],
        total: 0,
        total2: 0,
        queryParams: {
          pageNum: 1,
          pageSize: 10,
        },
        // 查询参数
        queryParams2: {
          pageNum: 1,
          pageSize: 10,
          supplyVendorId: null,
        },
        tznr: null,
        open: false,
        loading: false,
      }
    },
    created() {



      this.vid = this.$route.params.vid;

      if (this.vid != null) {
        console.log("----------")
        console.log(this.vid)
        this.findCendorList();
        this.findTendorList();
        this.findQualificationAnnex();
        this.findVendorContact();
        this.findNotice();
        this.findSupply();
      }
    },
    methods: {
      ckxx(id) {
        this.$router.push({
          path: '/vendor-system/supply/insert',
          query: {
            vid: id,
            ty: true
          }
        })
      },
      handleUpdate(row) {
        this.$router.push({
          path: '/vendor-system/supply/insert',
          query: {
            vid: row.supplyId
          }
        })
      },
      findSupply() {
        this.loading = true;
        this.queryParams2.supplyVendorId = this.vid;
        listSupply(this.queryParams2).then(response => {
          this.supplyList = response.rows;
          this.total2 = response.total;
          this.loading = false;
        });
      },
      nr(row) {
        this.tznr = row.notice_context;
        this.open = true;
      },
      findNotice() {
        axios.post('/dev-api/bidding/notice/findNotice?vid=' + this.vid, this.vid, {
            headers: {
              'Authorization': `Bearer ${getToken()}`,
              //'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
            },
          })
          .then(response => {
            // 处理响应
            this.noticeList = response.data
          })
      },
      findVendorContact() {
        axios.post('/dev-api/bidding/contacts/findVendorContactById?vid=' + this.vid, this.vid, {
            headers: {
              'Authorization': `Bearer ${getToken()}`,
              //'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
            },
          })
          .then(response => {
            // 处理响应
            this.contactList = response.data
          })
      },
      findQualificationAnnex() {
        axios.post('/dev-api/bidding/qualification/findQualificationAnnexByVendorId?vid=' + this.vid, this.vid, {
            headers: {
              'Authorization': `Bearer ${getToken()}`,
              //'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
            },
          })
          .then(response => {
            // 处理响应
            this.annexList = response.data
          })
      },
      findCendorList() {
        axios.post('/dev-api/bidding/vendor/findVendorDetailed?vid=' + this.vid, this.vid, {
            headers: {
              'Authorization': `Bearer ${getToken()}`,
              //'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
            },
          })
          .then(response => {
            this.$modal.msgSuccess("数据加载成功");
            // 处理响应
            this.vendorList = response.data.data
            console.log(this.vendorList)
          })
      },
      findTendorList() {
        let fd = new FormData();
        fd.append("sid", this.vid)
        axios.post('/dev-api/bidding/tender/findTendersByProjectsId', fd, {
            headers: {
              'Authorization': `Bearer ${getToken()}`,
              'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
            },
          })
          .then(response => {
            this.total = response.data.total
            this.tendorList = response.data.rows
          })
      },
      xiazai(url) {
        window.location.href = url
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
    }
  }
</script>

<style>
  .gyshz {

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

    .success-row {
      background-color: #ffffff !important;
    }

    .el-input--medium .el-input__inner {
      border: 0px;
    }

    .el-table td.el-table__cell,
    .el-table th.el-table__cell.is-leaf {
      border-bottom: 0px;
    }

    .el-table::before {
      width: 0px;
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
        height: 38px;
        border: 1px solid #f0f0f0;
      }
    }
  }

  .bgwz {
    padding: 10px;
    font-size: 14px;
  }

  .jz {
    margin: 0 auto;
    font-size: 14px;
  }

  .bt {
    font-size: 15px;
    color: #ff292c;
    padding: 12px;
  }

  div.tab-container {}

  .label-left-align ::v-deep .el-form-item__label {
    text-align: left;
  }

  .label-left-align ::v-deep .el-form-item__label {
    text-align: left;
  }

  .label-center-align ::v-deep .el-form-item__label {
    text-align: center;

  }

  .label-center-align {
    background-color: #f0f0f0;
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
