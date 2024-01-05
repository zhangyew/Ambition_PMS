<template>
  <div>
    <el-tabs value="first" @tab-click="handleClick">
      <el-tab-pane label="确定中标人" name="first">
        <el-row>
          <el-button v-if="isShow" type="primary" icon="el-icon-finished" size="mini"
            @click="handleAddDetails">确定</el-button>
        </el-row>

        <el-row>
          <el-table :data="tenderList" :row-class-name="tableRowClassName" @row-click="dj"
            @selection-change="chandleDetailSelectionChange" ref="tb" style="width: 100%;">

            <el-table-column label="排名" align="center" prop="ranking" />

            <el-table-column label="供应商名称" align="center" prop="tenderSupplierName">
              <template slot-scope="scope">
                <el-input v-model="scope.row.tenderSupplierName" :readonly="!isxs">
                  <i v-if="isxs" style="color: #0e97ff; font-weight: 800; font-size: 16px;" slot="suffix"
                    class="el-input__icon el-icon-search" @click="xszj=true"></i>
                </el-input>
              </template>
            </el-table-column>
            <el-table-column label="最终报价 (万元)" align="center" prop="prices">
              <template slot-scope="scope">
                <!-- <el-input v-model="scope.row.prices" :readonly="!isxs" /> -->
                {{scope.row.prices|formattedAmount}}
              </template>
            </el-table-column>
            <el-table-column label="最终得分" align="center" prop="score">
              <template slot-scope="scope">
                <el-input v-model="scope.row.score" :readonly="!isxs" />
              </template>
            </el-table-column>
            <el-table-column label="是否推荐" align="center" prop="recommend" />
            <el-table-column label="是否中标" align="center" prop="zb">
              <template slot-scope="scope">
                <el-switch style="display: block" v-model="scope.row.zb" active-color="#13ce66"
                  inactive-color="#c2c2c2">
                </el-switch>
              </template>
            </el-table-column>
            <el-table-column v-if="isxs" label="操作" align="center" class-name="small-padding fixed-width">
              <template slot-scope="scope">
                <el-button size="mini" type="text" icon="el-icon-delete"
                  @click="handleDeleteDetails(scope.row)">删除</el-button>
              </template>
            </el-table-column>
          </el-table>
        </el-row>

      </el-tab-pane>
      <el-tab-pane label="中标结果公示" name="second">
        <el-row>
          <el-button type="primary" icon="el-icon-monitor" size="mini" @click="gs">公示</el-button>
        </el-row>

        <el-row>
          <el-table :data="publicityList" :row-class-name="tableRowClassName" @row-click="dj"
            @selection-change="chandleDetailSelectionChange" ref="tb" style="width: 100%;">
            <el-table-column label="序号" type="index" />
            <el-table-column label="中标结果公示名称" align="center" prop="noticeTitle" />
            <el-table-column label="公示编号" align="center" prop="noticeClod" />
            <el-table-column label="公告发布时间" align="center" prop="noticeDate">
              <template slot-scope="scope">
                <span>{{ parseTime(scope.row.noticeDate, '{y}-{m}-{d} {h}:{mi}:{ss}') }}</span>
                <!-- <span>{{scope.row.downloadTime}}</span> -->
              </template>
            </el-table-column>
          </el-table>
        </el-row>
      </el-tab-pane>
      <el-tab-pane label="发送中标通知书" name="third">
        <el-row>
          <el-button type="primary" icon="el-icon-s-promotion" size="mini" @click="fs">发送</el-button>
        </el-row>

        <el-row>
          <el-table :data="sendList" :row-class-name="tableRowClassName" @row-click="dj"
            @selection-change="chandleDetailSelectionChange" ref="tb" style="width: 100%;">
            <el-table-column label="序号" type="index" />
            <el-table-column label="供应商" align="center" prop="tender_supplier_name" />
            <el-table-column label="联系人" align="center" prop="contact" />
            <el-table-column label="联系方式" align="center" prop="phone" />
            <el-table-column label="是否中标" align="center" prop="zb">
              是
            </el-table-column>
            <el-table-column label="发送方" align="center" prop="buyer">
              远志集团有限公司
            </el-table-column>
            <el-table-column v-if="zbShow" label="通知内容" align="center" prop="notice_context">
              <template slot-scope="scope">
                <el-button size="mini" type="text" icon="el-icon-edit-outline" @click="nr(scope.row,1)">编辑</el-button>
              </template>
            </el-table-column>
            <el-table-column label="操作" align="center" prop="state" class-name="small-padding fixed-width">
              <template slot-scope="scope">
                <el-button size="mini" type="text" icon="el-icon-view" @click="nr(scope.row,0)">查看</el-button>
              </template>
            </el-table-column>
          </el-table>
        </el-row>
      </el-tab-pane>
    </el-tabs>

    <!-- 通知内容富文本组件 -->
    <el-dialog :title="title" :visible.sync="open" width="900px" append-to-body>
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
  } from '../../utils/auth'

  export default {
    components: {},
    props: {},
    dicts: ['tender_state'],
    data() {
      return {
        id: this.tid,
        open: false,
        title: "",
        tenderList: [{
          tenderSupplierName: null,
          prices: null,
          score: null,
          recommend: null,
          ranking: null,
          state: null,
        }],
        publicityList: [],
        sendList: [],
        isShow: true,
        tznr: `<p class="ql-align-center"><strong>中标通知</strong></p><p class="ql-align-center">财办库〔2020〕50号</p><p>各中央预算单位办公厅（室），各省、自治区、直辖市、计划单列市财政厅（局），新疆生产建设兵团财政局：</p><p>	为规范政府采购公告和公示信息发布行为，提高政府采购活动透明度，财政部研究制定了《政府采购公告和公示信息格式规范（2020年版）》，现印发给你们，请遵照执行。</p><p>	各部门、各地区要高度重视政府采购信息公开工作，督促指导采购单位和采购代理机构自2020年7月1日起按照本格式规范编制发布政府采购信息。执行中如遇政策问题，请及时向财政部国库司反馈。</p><p>	附件：政府采购公告和公示信息格式规范（2020年版）</p><p class="ql-align-right">远志办公室</p><p class="ql-align-right">	2020年3月18日</p><p><br></p>`,
        nrid: null,
        zbShow: true,
      }
    },
    props: ['tid'],
    created() {
      let str = this.id;
      let parts = str.split("&"); // 使用 & 分割字符串
      let firstPart = parts[0]; // 获取第一个部分
      let secondPart = parts[1]; // 获取第二个部分
      console.log(firstPart); // 输出 "11"
      console.log(secondPart); // 输出 "1"
      this.id = firstPart;
      this.state = secondPart;
      this.getList('pb')
      this.findPublicityList()
      this.findSendList()
    },
    filters: {
      formattedAmount(value) {
        return new Intl.NumberFormat("zh-CN", {
          style: "currency",
          currency: "CNY",
        }).format(value);
      },
    },
    methods: {
      yesNR() {
        this.sendList.forEach((e, i) => {
          if (e.notice_id === this.nrid) {
            e.notice_context = this.tznr
          }
        })
        this.open = false;
      },
      nr(row, index) {
        if (index === 0) {
          this.title = "查看通知内容"
        } else {
          this.title = "编辑通知内容"
        }
        if (row.notice_context != null && row.notice_context != '')
          this.tznr = row.notice_context;
        this.nrid = row.notice_id;
        this.open = true;
      },
      findSendList() {

        let fd = new FormData();
        fd.append("id", this.id)
        axios.post('/dev-api/bidding/notice/findNoticeTenderById', fd, {
            headers: {
              'Authorization': `Bearer ${getToken()}`,
              'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
            },
          })
          .then(response => {
            this.sendList = response.data
            if (this.sendList[0].notice_context === null || this.sendList[0].notice_context === '') {
              this.zbShow = true;
            } else {
              this.zbShow = false;
            }
          })
      },
      findPublicityList() {
        let fd = new FormData();
        fd.append("id", this.id)
        axios.post('/dev-api/bidding/notice/findNoticeAllById', fd, {
            headers: {
              'Authorization': `Bearer ${getToken()}`,
              'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
            },
          })
          .then(response => {
            this.publicityList = response.data
          })
      },
      fs() {
        if (this.sendList[0].notice_context === null || this.sendList[0].notice_context === '') {
          this.$modal.msgWarning("中标通知书已发送，切勿重复操作");
          this.zbShow = true;
          return
        }
        let fd = new FormData();
        let x = [];
        this.sendList.forEach((e, i) => {
          x.push({
            noticeId: e.notice_id,
            noticeContext: e.notice_context,
            bidMoney: e.prices,
            buyer: "远志集团有限公司"
          })
        })
        fd.append("notice", JSON.stringify(x))
        axios.post('/dev-api/bidding/notice/updateNotice', fd, {
            headers: {
              'Authorization': `Bearer ${getToken()}`,
              'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
            },
          })
          .then(response => {
            if (response.data === 1) {
              this.$modal.msgSuccess("中标通知书发送成功");
              this.findSendList()
              this.zbShow = false;
            }
          })
      },
      gs() {
        if (this.publicityList.length != 0) {
          this.$modal.msgWarning("中标结果已公示，切勿重复操作");
          return
        }
        let fd = new FormData();
        fd.append("notice", JSON.stringify(this.tenderList))
        axios.post('/dev-api/bidding/notice/addNotice', fd, {
            headers: {
              'Authorization': `Bearer ${getToken()}`,
              'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
            },
          })
          .then(response => {
            if (response.data === 1) {
              fd.append("id", this.id)
              fd.append("zt", "4")
              axios.post('/dev-api/bidding/tender_projects/updateStates', fd, {
                  headers: {
                    'Authorization': `Bearer ${getToken()}`,
                    'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
                  },
                })
                .then(response => {
                  if (response.data === 1) {
                    this.$modal.msgSuccess("中标人确定成功");
                    this.findPublicityList()
                    this.getList('qd')
                  }
                })
            }
          })
      },
      handleAddDetails() {
        this.tenderList.forEach((e, i) => {
          if (e.zb) {
            e.state = 6;
          } else {
            e.state = 7;
          }
          console.log(e.state)
        })
        console.log(this.tenderList)
        let fd = new FormData();
        fd.append("tender", JSON.stringify(this.tenderList))
        axios.post('/dev-api/bidding/tender/bidEvaluation', fd, {
            headers: {
              'Authorization': `Bearer ${getToken()}`,
              'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
            },
          })
          .then(response => {
            if (response.data === 1) {
              this.$modal.msgSuccess("中标人确定成功");
              this.isShow = false;
              this.getList('qd')
            }
          })
      },
      getList(type) {
        let fd = new FormData();
        fd.append("pid", this.id)
        fd.append("zt", type)
        axios.post('/dev-api/bidding/tender/findTendersByProjectsId', fd, {
            headers: {
              'Authorization': `Bearer ${getToken()}`,
              'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
            },
          })
          .then(response => {
            console.log(response)
            this.tenderList = []
            response.data.rows.forEach((e, i) => {
              if (e.state === 5) { // 中标候选人
                this.tenderList.push({
                  tenderId: e.tenderId,
                  tenderSupplierName: e.tenderSupplierName,
                  prices: e.prices,
                  score: e.score,
                  recommend: e.recommend ? '推荐' : '不推荐',
                  ranking: e.ranking,
                  state: null,
                });
              } else if (e.state === 6) { // 是否中标
                this.tenderList.push({
                  tenderId: e.tenderId,
                  tenderSupplierName: e.tenderSupplierName,
                  prices: e.prices,
                  tenderSupplierId: e.tenderSupplierId,
                  score: e.score,
                  recommend: e.recommend ? '推荐' : '不推荐',
                  zb: true,
                  ranking: e.ranking,
                  tenderAnnexId: this.id,
                  state: null,
                });
                this.isShow = false;
              }
            })
          })
      },
    }
  }
</script>

<style>
</style>
