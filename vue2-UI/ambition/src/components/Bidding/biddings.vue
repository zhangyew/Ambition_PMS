<template>
  <div>
    <el-tabs @tab-click="handleClick" value="first">
      <el-tab-pane label="获取标书" name="first">
        <div style="padding: 20px;height: 150px;width: 100%;">
          <el-table v-loading="loading" :data="tenderNoticeList" @row-click="dj" :row-class-name="tableRowClassName">
            <el-table-column label="项目编号" align="center" prop="tenderProjectsNumber">
              <template slot-scope="scope">
                {{tenderProjectsNumber}}
              </template>
            </el-table-column>
            <el-table-column label="招标名称" align="center" prop="tenderTitle" />
            <el-table-column label="标书获取截至时间" align="center" prop="bidEnd">
              <template slot-scope="scope">
                <span>{{ parseTime(scope.row.bidEnd, '{y}-{m}-{d} {h}:{mi}') }}</span>
              </template>
            </el-table-column>

          </el-table>
        </div>

        <div style="margin-top: 20px;">
          <span class="el-icon-s-unfold" style="font-size: 24px;color: rgb(24 144 255);"></span>
          <span
            style="    font-weight: 550;margin-bottom: 10px;display: inline-block;font-size: 15px;margin-left: 30px;color: #515151;">标书下载详细信息
          </span>
          <el-table :height="300" v-loading="loading" :data="downLoadLogsList" @row-click="dj"
            :row-class-name="tableRowClassName">
            <el-table-column label="序号" type="index" />
            <el-table-column label="投标人名称" align="center" prop="tenderName" />
            <el-table-column label="联系人" align="center" prop="contact" />
            <el-table-column label="联系方式" align="center" prop="phone" />
            <el-table-column label="邮箱" align="center" prop="email" />
            <el-table-column label="下载时间" align="center" prop="downloadTime">
              <template slot-scope="scope">
                <span>{{ parseTime(scope.row.downloadTime, '{y}-{m}-{d} {h}:{mi}:{ss}') }}</span>
                <!-- <span>{{scope.row.downloadTime}}</span> -->
              </template>
            </el-table-column>

          </el-table>
          <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNum"
            :limit.sync="queryParams.pageSize" @pagination="downLoadLogsList" />
        </div>

      </el-tab-pane>
      <el-tab-pane label="投递标书" name="second">
        <div>
          <el-table v-loading="loading" :data="findTendersList" @row-click="dj"
            :row-class-name="tableRowClassName">
            <el-table-column label="序号" type="index" />
            <el-table-column label="投标人名称" align="center" prop="tenderName" />
            <el-table-column label="联系人" align="center" prop="contact" />
            <el-table-column label="联系方式" align="center" prop="phone" />
            <el-table-column label="成功投标时间" align="center" prop="tenderTime">
              <template slot-scope="scope">
                <!-- <span>{{ parseTime(scope.row.tenderTime, '{y}-{m}-{d} {h}:{mi}:{ss}') }}</span> -->
                <span>{{scope.row.tenderTime}}</span>
              </template>
            </el-table-column>
            <el-table-column label="IP地址" align="center" prop="ipAddress" />
            <el-table-column label="投标状态" align="center" prop="state">
              <template slot-scope="scope">
                <dict-tag :options="dict.type.tender_state" :value="scope.row.state" />
              </template>
            </el-table-column>
            <el-table-column label="操作" align="center" prop="state" class-name="small-padding fixed-width">
              <template slot-scope="scope">
                <!-- <router-link :to="'/insertNotice/id=' + id + '&nid=' + scope.row.tenderNoticeId"> -->
                <el-button v-if="scope.row.state == 1 || scope.row.state == 2" size="mini" type="text"
                  icon="el-icon-download" @click="xzbs(scope.row)">下载标书 </el-button>
                <!-- </router-link> -->
                <!-- <el-popover v-if="scope.row.state == 2" placement="top" width="200" v-model="visible">
                  <p>注：请仔细核对标书信息对其进行操作</p>
                  <div style="text-align: right; margin: 0">
                    <el-button size="mini" type="danger" @click="ztsh(scope.row,4)">审核拒绝</el-button>
                    <el-button type="success" size="mini" @click="ztsh(scope.row,3)">审核通过</el-button>
                  </div> -->
                <el-button v-if="scope.row.state == 2" slot="reference" @click="opens=true" size="mini" type="text"
                  icon="el-icon-s-check">信息审核</el-button>
                <!-- </el-popover> -->

                <el-button v-if="scope.row.state == 3" size="mini" type="text" icon="el-icon-check"></el-button>
                <el-button v-if="scope.row.state == 4" size="mini" type="text" icon="el-icon-delete"
                  @click="scbs(scope.row)">删除标书</el-button>
              </template>
            </el-table-column>
          </el-table>
          <pagination v-show="total2 > 0" :total="total2" :page.sync="queryParams.pageNum"
            :limit.sync="queryParams.pageSize" @pagination="findTendersList" />
        </div>
      </el-tab-pane>
    </el-tabs>

    <!-- 审批--修改状态弹窗 -->
    <el-dialog :title="title" :visible.sync="opens" width="500px" append-to-body>
      <el-form label-width="150px">
        <el-form-item label="审批状态" prop="requireState" style="width: 400px;">
          <el-select v-model="jg" placeholder="请确定审批结果">
            <el-option label="审核通过" value="3"></el-option>
            <el-option label="审核拒绝" value="4"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="ztsh">确 定</el-button>
        <el-button @click="opens=false">取 消</el-button>
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
  export default {
    dicts: ['tender_state'],

    data() {
      return {
        opens: false,
        jg: null,
        title: "审核操作",
        id: this.tid,
        visible: false,
        tenderProjectsNumber: null,
        tenderNoticeList: [],
        downLoadLogsList: [],
        findTendersList: [],
        // 总条数
        total: 0,
        total2: 0,
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
        },
        nid: null,
      }
    },
    props: ['tid'],
    mounted() {

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
      this.findNotice2()
      this.findDownLoadLog()
      this.findTenders()
    },
    methods: {
      dj(row) {
        this.nid = row.tenderId
      },
      handleClick(tab, event) {
        // console.log(tab, event);
      },
      findTenders() {
        let fd = new FormData();
        fd.append("pid", this.id)
        fd.append("zt", 'bs')
        axios.post('/dev-api/bidding/tender/findTendersByProjectsId', fd, {
            headers: {
              'Authorization': `Bearer ${getToken()}`,
              'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
            },
          })
          .then(response => {
            this.total2 = response.data.total
            this.findTendersList = response.data.rows
          })
      },
      findDownLoadLog() {
        // downLoadLogsList
        let fd = new FormData();
        fd.append("nid", this.id)
        axios.post('/dev-api/bidding/download_logs/findDownloadLogsByTenderId', fd, {
            headers: {
              'Authorization': `Bearer ${getToken()}`,
              'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
            },
          })
          .then(response => {
            this.total = response.data.total
            this.downLoadLogsList = response.data.rows
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
            // this.$modal.msgSuccess("数据加载成功");
            // 处理响应
            this.tenderNoticeList = response.data.data.list
            this.tenderProjectsNumber = response.data.data.tenderProjectsNumber;
            console.log(this.tenderNoticeList);
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
      xzbs(row) {
        let thet = this
        if (row.publicAnnex.annexUrl != null && row.publicAnnex.annexUrl != '')
          window.location.href = row.publicAnnex.annexUrl
        if (row.state === 1) {
          let fd = new FormData();
          fd.append("tenderId", row.tenderId)
          fd.append("state", 2)
          axios.post('/dev-api/bidding/tender/updateStateByTenderId', fd, {
              headers: {
                'Authorization': `Bearer ${getToken()}`,
                'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
              },
            })
            .then(response => {
              thet.findTenders()
            })
        }
      },
      scbs(row) {
        let thet = this
        const annexIds = row.tenderAnnexId;
        if (row.tenderAnnexId != 0) {
          this.$modal.confirm('是否确认删除标书文件').then(function() {
            return delAnnex(annexIds);
          }).then(() => {
            let fd = new FormData();
            fd.append("tenderId", row.tenderId)
            fd.append("tenderAnnexId", 0)
            axios.post('/dev-api/bidding/tender/updateStateByTenderId', fd, {
                headers: {
                  'Authorization': `Bearer ${getToken()}`,
                  'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
                },
              })
              .then(response => {
                thet.findTenders();
                this.$modal.msgSuccess("删除成功");
              })
          }).catch(() => {});
        } else {
          this.$modal.msgSuccess("文件不存在或已删除");
        }
      },
      ztsh() {
        let fd = new FormData();
        fd.append("tenderId", this.nid)
        fd.append("state", this.jg)
        axios.post('/dev-api/bidding/tender/updateStateByTenderId', fd, {
            headers: {
              'Authorization': `Bearer ${getToken()}`,
              'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
            },
          })
          .then(response => {
            this.findTenders();
            this.$modal.msgSuccess("操作成功");
            this.opens = false;
          })

      },
    }
  }
</script>

<style>
</style>
