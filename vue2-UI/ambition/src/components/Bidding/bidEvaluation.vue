<template>
  <div>
    <el-tabs value="first" @tab-click="handleClick">
      <el-tab-pane label="评标" name="first">
        <!-- 候选人 -->
        <div>
          <el-row>
            <div style="    display: inline-block;margin-right: 25px;font-size: 14px;font-weight: 600;">
              <span>中标候选人</span>
            </div>
            <el-button v-show="isxs" type="primary" icon="el-icon-plus" size="mini"
              @click="handleAddDetails">添加</el-button>
            <!-- <el-button type="success" icon="el-icon-delete" size="mini" @click="handleDeleteDetails">删除</el-button> -->
          </el-row>

          <el-row>
            <el-table :data="tenderList" :row-class-name="tableRowClassName" @row-click="dj"
              @selection-change="chandleDetailSelectionChange" ref="tb" style="width: 100%;">

              <!-- <el-table-column v-if="isxs" label="排名" align="center" prop="ranking" type="index" />
              <el-table-column v-else label="排名" align="center" prop="ranking"  /> -->
              <el-table-column label="排名" align="center" prop="ranking" type="index" />

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
                  <el-input v-model="scope.row.prices" :readonly="!isxs" />
                </template>
              </el-table-column>
              <el-table-column label="最终得分" align="center" prop="score">
                <template slot-scope="scope">
                  <el-input v-model="scope.row.score" :readonly="!isxs" />
                </template>
              </el-table-column>
              <el-table-column label="是否推荐" align="center" prop="recommend">
                <template slot-scope="scope">
                  <el-switch style="display: block" v-model="scope.row.recommend" active-color="#13ce66"
                    inactive-color="#c2c2c2" active-text="推荐" inactive-text="不推荐">
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
        </div>

        <!-- 文件 -->
        <div style="margin-top: 20px;">
          <div class="table-container">
            <table class="table-layout">
              <tbody>
                <tr>
                  <td class="table-cell" colspan="3">
                    <div style="height: 50px;padding: 15px;   ">
                      <div style=" font-size: 15px;font-weight: 600;">附件 </div>
                    </div>
                  </td>
                </tr>
                <tr>
                  <td class="table-cell wz">
                    <div>
                      <div>专家签到表</div>
                    </div>
                  </td>
                  <td class="table-cell" colspan="2">
                    <el-upload ref="upload" class="upload-demo" :limit="1" accept=".doc,.docx,.xsl,.xlsx" v-if="isxs"
                      :action="upload.url" :headers="upload.headers" :file-list="fileList" :before-remove="beforeRemove"
                      :on-progress="handleFileUploadProgress" :on-success="handleFileSuccess" :auto-upload="false">
                      <el-button slot="trigger" plain size="mini" type="primary">选取文件</el-button>
                      <el-button style="margin-left: 10px;" plain size="small" type="success" icon="el-icon-upload2"
                        @click="submitUpload(9)">上传</el-button>
                    </el-upload>
                    <div v-else>
                      <span
                        style="font-size: 13px;margin-right: 20px;margin-left: 20px;">{{annexList[0].annexTitle}}</span>
                      <el-button size="mini" plain type="success" icon="el-icon-download"
                        style="float: right;margin-right: 80px;" @click="xzwj(annexList[0].annexUrl)">下载</el-button>
                    </div>

                  </td>
                </tr>
                <tr>
                  <td class="table-cell wz">
                    <div>
                      <div>审查表</div>
                    </div>
                  </td>
                  <td class="table-cell" colspan="2">
                    <el-upload ref="upload2" class="upload-demo" :limit="1" accept=".doc,.docx,.xsl,.xlsx" v-if="isxs"
                      :action="upload.url" :headers="upload.headers" :file-list="fileList" :before-remove="beforeRemove"
                      :on-progress="handleFileUploadProgress" :on-success="handleFileSuccess" :auto-upload="false">
                      <el-button slot="trigger" plain size="mini" type="primary">选取文件</el-button>
                      <el-button style="margin-left: 10px;" plain size="small" type="success" icon="el-icon-upload2"
                        @click="submitUpload2(10)">上传</el-button>
                    </el-upload>
                    <div v-else>
                      <span
                        style="font-size: 13px;margin-right: 20px;margin-left: 20px;">{{annexList[1].annexTitle}}</span>
                      <el-button size="mini" plain type="success" icon="el-icon-download"
                        style="float: right;margin-right: 80px;" @click="xzwj(annexList[1].annexUrl)">下载</el-button>
                    </div>
                  </td>
                </tr>
                <tr>
                  <td class="table-cell wz">
                    <div>
                      <div>评审表</div>
                    </div>
                  </td>
                  <td class="table-cell" colspan="2">
                    <el-upload ref="upload3" class="upload-demo" :limit="1" accept=".doc,.docx,.xsl,.xlsx" v-if="isxs"
                      :action="upload.url" :headers="upload.headers" :file-list="fileList" :before-remove="beforeRemove"
                      :on-progress="handleFileUploadProgress" :on-success="handleFileSuccess" :auto-upload="false">
                      <el-button slot="trigger" plain size="mini" type="primary">选取文件</el-button>
                      <el-button style="margin-left: 10px;" plain size="small" type="success" icon="el-icon-upload2"
                        @click="submitUpload3(11)">上传</el-button>
                    </el-upload>
                    <div v-else>
                      <span
                        style="font-size: 13px;margin-right: 20px;margin-left: 20px;">{{annexList[2].annexTitle}}</span>
                      <el-button size="mini" plain type="success" icon="el-icon-download"
                        style="float: right;margin-right: 80px;" @click="xzwj(annexList[2].annexUrl)">下载</el-button>
                    </div>
                  </td>
                </tr>
                <tr>
                  <td class="table-cell wz">
                    <div>
                      <div>最终汇总评分表</div>
                    </div>
                  </td>
                  <td class="table-cell" colspan="2">
                    <el-upload ref="upload4" class="upload-demo" :limit="1" accept=".doc,.docx,.xsl,.xlsx" v-if="isxs"
                      :action="upload.url" :headers="upload.headers" :file-list="fileList" :before-remove="beforeRemove"
                      :on-progress="handleFileUploadProgress" :on-success="handleFileSuccess" :auto-upload="false">
                      <el-button slot="trigger" plain size="mini" type="primary">选取文件</el-button>
                      <el-button style="margin-left: 10px;" plain size="small" type="success" icon="el-icon-upload2"
                        @click="submitUpload4()">上传</el-button>
                    </el-upload>
                    <div v-else>
                      <span
                        style="font-size: 13px;margin-right: 20px;margin-left: 20px;">{{annexList[3].annexTitle}}</span>
                      <el-button size="mini" plain type="success" icon="el-icon-download"
                        style="float: right;margin-right: 80px;" @click="xzwj(annexList[3].annexUrl)">下载</el-button>
                    </div>
                  </td>
                </tr>
                <tr>
                  <td class="table-cell wz">
                    <div>
                      <div>其他</div>
                    </div>
                  </td>
                  <td class="table-cell" colspan="2">
                    <el-upload ref="upload5" class="upload-demo" :limit="1" accept=".doc,.docx,.xsl,.xlsx" v-if="isxs"
                      :action="upload.url" :headers="upload.headers" :file-list="fileList" :before-remove="beforeRemove"
                      :on-progress="handleFileUploadProgress" :on-success="handleFileSuccess" :auto-upload="false">
                      <el-button slot="trigger" plain size="mini" type="primary">选取文件</el-button>
                      <el-button style="margin-left: 10px;" plain size="small" type="success" icon="el-icon-upload2"
                        @click="submitUpload5()">上传</el-button>
                    </el-upload>
                    <div v-else>
                      <span
                        style="font-size: 13px;margin-right: 20px;margin-left: 20px;">{{annexList[4].annexTitle}}</span>
                      <el-button size="mini" plain type="success" icon="el-icon-download"
                        style="float: right;margin-right: 80px;" @click="xzwj(annexList[4].annexUrl)">下载</el-button>
                    </div>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
        <div style="margin: 30px auto !important;width: 0px;">
          <el-row :gutter="10" class="mb8" v-show="isxs">
            <el-col :span="1.5">
              <el-button type="primary " icon="el-icon-check" size="medium" @click="submitForm">提交</el-button>
            </el-col>
          </el-row>
        </div>


        <!-- 添加候选人组件 -->
        <div>

          <el-dialog title="添加候选人" :visible.sync="xszj">
            <el-table v-loading="loading" height="325" @row-dblclick="db" :data="tenderNoticeList" ref="multipleTable"
              @row-click="handleSelectionChanges(scope.row)">
              <!-- <el-table-column label="项目ID" align="center" prop="tenderProjectsId" /> -->
              <el-table-column label="供应商名称" align="center" prop="tenderSupplierName" />
              <el-table-column label="联系人" align="center" prop="contact" />
              <el-table-column label="移动电话" align="center" prop="phone" />
              <el-table-column label="投标状态" align="center" prop="state">
                <template slot-scope="scope">
                  <dict-tag :options="dict.type.tender_state" :value="scope.row.state" />
                </template>
              </el-table-column>
            </el-table>
            <pagination v-show="total>0" :total="total" :page.sync="queryParams.pageNum"
              :limit.sync="queryParams.pageSize" @pagination="findTender" />
            <!-- <el-button @click="qd">确定</el-button> -->
          </el-dialog>
        </div>


      </el-tab-pane>
    </el-tabs>
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
        xszj: false,
        total: 0,
        queryParams: {
          pageNum: 1,
          pageSize: 10,
        },
        // 上传的文件列表
        fileList: null,
        // 上传参数
        upload: {

          // 是否禁用上传
          isUploading: false,
          // 设置上传的请求头部
          headers: {
            Authorization: "Bearer " + getToken()
          },
          // 上传的地址
          url: "/dev-api/bidding/tender_notice/uploadFiles",
        },
        returnFile: [],
        tenderList: [{
          tenderSupplierName: null,
          prices: null,
          score: null,
          recommend: null,
          ranking: null,
          state: 5,
        }],
        tenderNoticeList: [],
        ids: [],
        rowid: null,
        wjType: null,
        isxs: false,
        annexList: [],
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
      this.findTender()
      this.getList()
      this.findAnnex()
    },
    methods: {
      findAnnex() {
        let fd = new FormData();
        fd.append("id", this.id)
        axios.post('/dev-api/bidding/annex/findAnnexByPbId', fd, {
            headers: {
              'Authorization': `Bearer ${getToken()}`,
              'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
            },
          })
          .then(response => {
            console.log(response)
            if (response.data != null) {
              this.annexList = response.data
            }
          })
      },
      getList() {
        let fd = new FormData();
        fd.append("pid", this.id)
        fd.append("zt", 'pb')
        axios.post('/dev-api/bidding/tender/findTendersByProjectsId', fd, {
            headers: {
              'Authorization': `Bearer ${getToken()}`,
              'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
            },
          })
          .then(response => {
            console.log(response)
            if (response.data.total === 0) {
              this.isxs = true;
            } else {
              this.tenderList = []
              response.data.rows.forEach((e, i) => {
                this.tenderList.push({
                  tenderSupplierName: e.tenderSupplierName,
                  prices: e.prices,
                  score: e.score,
                  recommend: e.recommend ? true : false,
                  ranking: e.ranking,
                  state: 5,
                });
              })
            }
          })
      },
      xzwj(url) {
        window.location.href = url
      },
      submitForm() {
        // this.$refs.upload.submit();
        if (this.returnFile.length < 4 || this.tenderList[0].tenderSupplierName === null) {
          this.$modal.msgWarning("请输入完整信息");
          return;
        }

        this.tenderList.forEach((e, i) => {
          e.recommend = e.recommend ? 0 : 1
          e.ranking = e.xh
        })

        console.log(this.tenderList)
        console.log(this.returnFile)
        let fd = new FormData();
        fd.append("tender", JSON.stringify(this.tenderList))
        fd.append("ax", JSON.stringify(this.returnFile))
        axios.post('/dev-api/bidding/tender/bidEvaluation', fd, {
            headers: {
              'Authorization': `Bearer ${getToken()}`,
              'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
            },
          })
          .then(response => {
            if (response.data === 1) {
              this.$modal.msgSuccess("评标信息设置成功");
            }
          })
      },
      findTender() {
        const fd = new FormData();
        fd.append("id", this.id)
        axios.post('/dev-api/bidding/tender/findTendersStateByProjectsId', fd, {
            headers: {
              'Authorization': `Bearer ${getToken()}`,
              'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
            },
          })
          .then(response => {
            this.tenderNoticeList = response.data.rows
            this.total = response.data.total
          })
      },
      dj(row) {
        this.rowid = row.xh
      },
      db(row) {
        this.ids = row;
        let thet = this;
        console.log(this.rowid)
        this.tenderList.forEach((e, i) => {
          if (e.xh === thet.rowid) {
            e.tenderSupplierName = row.tenderSupplierName;
            e.tenderId = row.tenderId;
          }
        })
        this.xszj = false;
      },
      handleAddDetails() {
        if (this.tenderList === undefined) {
          this.tenderList = new Array();
        }
        this.tenderList.push({
          tenderSupplierName: null,
          prices: null,
          score: null,
          recommend: null,
          ranking: null,
          state: 5,
        });
      },
      // 删除
      handleDeleteDetails(index) {
        this.$confirm(`确定移除该数据？`).then(() => {
          this.tenderList.splice(index.xh - 1, 1);
        })
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
      // 文件提交处理
      submitUpload() {
        this.wjType = 9;
        this.$refs.upload.submit();
      },
      submitUpload2() {
        this.wjType = 10;
        this.$refs.upload2.submit();
      },
      submitUpload3() {
        this.wjType = 11;
        this.$refs.upload3.submit();
      },
      submitUpload4() {
        this.wjType = 12;
        this.$refs.upload4.submit();
      },
      submitUpload5() {
        this.wjType = 13;
        this.$refs.upload5.submit();
      },
      // 文件上传中处理
      handleFileUploadProgress(event, file, fileList) {
        this.upload.isUploading = true;
      },
      // 文件上传成功处理
      handleFileSuccess(response, file, fileList) {
        let thet = this;
        console.log(file)

        this.returnFile.push({
          annexTitle: file.name,
          annexUrl: file.response.data.url,
          supplyId: thet.id,
          annexText: thet.id,
          annexTypeId: thet.wjType,
        })
        console.log(this.returnFile)
        this.upload.isUploading = false;
        //this.form.filePath = response.url;
        this.$modal.msgSuccess("上传成功");
      },
      beforeRemove(file, fileList) {
        let thet = this;
        return this.$confirm(`确定移除 ${ file.name }？`).then(() => {
          for (var i = 0; i < thet.returnFile.length; i++) {
            if (thet.returnFile[i].annexTitle === file.name) {
              console.log("=========")
              console.log(thet.returnFile)
              thet.returnFile.splice(i, 1);
              console.log(thet.returnFile)
            }
          }
        })
      },
    }
  }
</script>
<style lang="scss">
  .hz {
    .el-input__inner {
      text-align: center;
    }
  }

  .wz {
    background-color: #f8f8f9;
    text-align: center;
    height: 40px !important;
    border: 0px !important;
  }

  .el-input-number.full-width-input,
  .el-cascader.full-width-input {
    width: 100% !important;
  }

  .div.table-container table.table-layout td.table-cell[data-v-66adee05] {
    border: 1px solid #e2e2e2 !important;
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
