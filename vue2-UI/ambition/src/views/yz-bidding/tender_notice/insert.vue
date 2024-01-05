<template>
  <div class="xhz">
    <div class="top2">
      <div id="top_img" style="width: 100px; float: left">
        <img src="@/assets/logo/logo2.jpg" alt="donate" height="100px" width="230px" />
      </div>
      <h1>{{bt}}</h1>
    </div>
    <el-form :model="formData" ref="vForm" :rules="rules" label-position="left" label-width="80px" size="medium"
      @submit.native.prevent>
      <el-row>
        <el-col :span="12" class="grid-cell">
          <el-form-item label="公告标题" prop="tenderTitle" class="required">
            <el-input style="width: 400px !important;" v-model="formData.tenderTitle" type="text" placeholder="请输入公告标题"
              clearable></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12" class="grid-cell">
          <el-form-item label="关联项目" prop="tenderNoticeProjectsId" class="required">

            <el-input placeholder="请选择关联项目" style="width: 400px !important;" v-model="formData.tenderProjectsName"
              @focus="xzxm"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12" class="grid-cell">
          <el-form-item label="项目资金" prop="tenderNoticeMonery" class="required">
            <el-input style="width: 400px !important;" v-model="formData.tenderNoticeMonery" :disabled="true"
              type="text" placeholder="根据关联显目列出金额" clearable></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12" class="grid-cell">
          <el-form-item label="流程时间" prop="lcdata" class="required">
            <el-date-picker is-range v-model="formData.lcdata" type="datetimerange" class="full-width-input"
              start-placeholder="流程开始时间" end-placeholder="流程结束时间" clearable></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12" class="grid-cell">
          <el-form-item label="备注" prop="remark">
            <el-input style="width: 400px !important;" v-model="formData.remark" type="text" clearable></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12" class="grid-cell">
          <el-form-item label="投标时间" prop="tbdata" class="required">
            <el-date-picker is-range v-model="formData.tbdata" type="datetimerange" class="full-width-input"
              start-placeholder="投标开始时间" end-placeholder="投标结束时间" clearable></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12" class="grid-cell">
          <el-form-item label="开标时间" prop="kbtata" class="required">
            <el-date-picker is-range v-model="formData.kbtata" type="datetimerange" class="full-width-input"
              start-placeholder="开标开始时间" end-placeholder="开标结束时间" clearable></el-date-picker>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12">
          <el-form-item label="附件" prop="fileList" class="required">
            <el-upload ref="upload" class="upload-demo" :limit="4" accept=".doc,.docx,.xsl,.xlsx" multiple
              :action="upload.url" :headers="upload.headers" :file-list="upload.fileList" :before-remove="beforeRemove"
              :on-progress="handleFileUploadProgress" :on-success="handleFileSuccess" :auto-upload="false">
              <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
              <el-button style="margin-left: 10px;" size="small" type="success" @click="submitUpload">上传到服务器</el-button>
              <div slot="tip" class="el-upload__tip">最多只能上传4个文件，支持 doc/xls/docx/xlsx 类型文件，且不超过10MB</div>
            </el-upload>
          </el-form-item>
        </el-col>
      </el-row>
      <div style="height: 20px;"></div>
      <el-row>
        <el-col :span="22">
          <el-form-item class="required" prop="context" label="正文">
            <editor v-model="formData.context" :min-height="192" />
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
    <div style="float: right;margin-top: 15px;height: 70px;">
      <el-button v-if="xg==null" type="primary" plain size="medium" @click="submitForm">提交</el-button>
      <el-button type="success" plain size="medium" @click="$router.back()">返回</el-button>
    </div>
    <!-- 添加招标项目组件 -->

    <el-dialog title="选择招标项目" :visible.sync="dialogFormVisible">
      <el-form :model="queryParams" ref="vForm" :rules="rules" label-position="left" label-width="80px" size="medium"
        @submit.native.prevent>
        <el-row>
          <el-col :span="10" class="grid-cell">
            <el-form-item label="招标项目名称" label-width="150px" prop="tenderProjectsName" class="label-right-align">
              <el-input v-model="queryParams.tenderProjectsName" type="text" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="6" class="grid-cell">
            <div class="static-content-item">
              <el-button icon="el-icon-search" @click="getList">搜索</el-button>
            </div>
          </el-col>
        </el-row>
      </el-form>
      <el-table v-loading="loading" height="325" @row-dblclick="db" :data="tender_projectsList" ref="multipleTable"
        @row-click="handleSelectionChanges(scope.row)">
        <!-- <el-table-column label="项目ID" align="center" prop="tenderProjectsId" /> -->
        <el-table-column label="项目编号" align="center" prop="tenderProjectsNumber" />
        <el-table-column label="项目名称" align="center" prop="tenderProjectsName" />
        <el-table-column label="项目预算" align="center" prop="tenderProjectsMoney" />
      </el-table>
      <pagination v-show="total>0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
        @pagination="getList" />
      <!-- <el-button @click="qd">确定</el-button> -->
    </el-dialog>

  </div>
</template>

<script>
  import {
    getToken
  } from '../../../utils/auth'
  import {
    listTender_projects,
    getTender_projects,
    delTender_projects,
    addTender_projects,
    updateTender_projects
  } from "@/api/bidding/tender_projects";
  export default {
    components: {},
    props: {},
    data() {
      return {
        bt: "新建招标公告",
        id: null,
        nid: null,
        formData: {
          tenderTitle: "",
          tenderNoticeProjectsId: "",
          tenderNoticeMonery: "",
          bidStart: null,
          bidEnd: null,
          kaibiaoStart: null,
          kaibiaoEnd: null,
          processStart: null,
          processEnd: null,
          context: null,
          lcdata: [],
          tbdata: [],
          kbtata: [],
        },

        dialogFormVisible: false,
        tender_projectsList: [],
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          tenderProjectsName: null,
          auditState: 1,
        },
        rules: {
          tenderTitle: [{
            required: true,
            message: '公告标题不可为空',
          }],
          tenderNoticeProjectsId: [{
            required: true,
            message: '请选择关联项目',
          }],
          tenderNoticeMonery: [{
            required: true,
            message: ' ',
          }],
          lcdata: [{
            required: true,
            message: '请选择正确的时间范围',
          }],
          tbdata: [{
            required: true,
            message: '请选择正确的时间范围',
          }],
          kbtata: [{
            required: true,
            message: '请选择正确的时间范围',
          }],
          context: [{
            required: true,
            message: '请输入公告正文',
          }],
          // upfileList: [{
          //   required: true,
          //   message: '请选择至少一个文件',
          // }]
        },
        tenderNoticeProjectsIdOptions: [{
          "label": "select 1",
          "value": 1
        }, {
          "label": "select 2",
          "value": 2
        }, {
          "label": "select 3",
          "value": 3
        }],
        // 上传参数
        upload: {
          // 上传的文件列表
          fileList: [],

          // 是否禁用上传
          isUploading: false,
          // 设置上传的请求头部
          headers: {
            Authorization: "Bearer " + getToken()
          },
          // 上传的地址
          url: "/dev-api/bidding/tender_notice/uploadFiles",
        },
        // 总条数
        total: 0,
        ids: [],
        returnFile: [],
        xg: null,
      }
    },
    computed: {},
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
      if (this.nid != null && this.nid != "") {
        if (this.xg === "xg") {
          this.bt = "公告详情"
        } else this.bt = "修改招标公告"

        let fd = new FormData();
        fd.append("pid", this.id)
        fd.append("tid", this.nid)
        axios.post('/dev-api/bidding/tender_notice/findNoticeById', fd, {
            headers: {
              'Authorization': `Bearer ${getToken()}`,
              'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
            },
          })
          .then(response => {
            this.$modal.msgSuccess("数据加载成功");
            // 处理响应
            thet.formData = response.data.data.list[0]
            let lc = [];
            let tb = [];
            let kb = [];
            tb.push(response.data.data.list[0].bidStart);
            tb.push(response.data.data.list[0].bidEnd);
            lc.push(response.data.data.list[0].processStart);
            lc.push(response.data.data.list[0].processEnd);
            kb.push(response.data.data.list[0].kaibiaoStart);
            kb.push(response.data.data.list[0].kaibiaoEnd);
            thet.formData.tenderProjectsName = response.data.data.tenderProjectsName
            thet.formData.lcdata = [];
            thet.formData.kbtata = [];
            thet.formData.tbdata = [];
            thet.formData.lcdata = lc;
            thet.formData.kbtata = kb;
            thet.formData.tbdata = tb;
            console.log(response.data.data.list2)
            thet.returnFile = response.data.data.list2
            response.data.data.list2.forEach((e, i) => {
              thet.upload.fileList.push({
                name: e.annexTitle,
                url: e.annexUrl
              })
            })
          })
        // this.getList()
      }
    },
    mounted() {},
    methods: {
      submitForm() {
        this.$refs['vForm'].validate(valid => {
          if (!valid) {
            this.$modal.msgWarning("请检查数据是否全部填写");
            return
          }
          if (this.formData.tbdata[0] < this.formData.lcdata[0] ||
            this.formData.kbtata[0] < this.formData.lcdata[0] ||
            this.formData.tbdata[1] > this.formData.lcdata[1] ||
            this.formData.kbtata[1] > this.formData.lcdata[1]) {
            this.$modal.msgError("投标时间/开标时间不能早于或晚于流程时间区间");
            return;
          } else if (this.formData.tbdata[1] > this.formData.kbtata[0]) {
            this.$modal.msgError("开标时间不能早于投标结束时间");
            return;
          }
          //TODO: 提交表单
          this.formData.bidStart = this.formData.lcdata[0]
          this.formData.bidEnd = this.formData.lcdata[1]
          this.formData.kaibiaoStart = this.formData.tbdata[0]
          this.formData.kaibiaoEnd = this.formData.tbdata[1]
          this.formData.processStart = this.formData.kbtata[0]
          this.formData.processEnd = this.formData.kbtata[1]
          let fd = new FormData();
          console.log("----------------------------")
          console.log(this.returnFile)
          fd.append("tenderNotice", JSON.stringify(this.formData))
          fd.append("fileUrl", JSON.stringify(this.returnFile))
          axios.post('/dev-api/bidding/tender_notice/addTenderNotice', fd, {
              headers: {
                'Authorization': `Bearer ${getToken()}`,
                'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
              },
            })
            .then(response => {
              if (response.data > 0)
                this.$modal.msgSuccess("操作成功");
                this.$router.go(-1)
              // 处理响应
            })

        })
      },
      resetForm() {
        this.$refs['vForm'].resetFields()
      },
      // 文件提交处理
      submitUpload() {
        this.$refs.upload.submit();
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
          supplyId: thet.formData.tenderNoticeProjectsId,
          annexTypeId: 4,
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
      getList() {
        listTender_projects(this.queryParams).then(response => {
          this.tender_projectsList = response.rows;
          this.total = response.total;
          this.loading = false;
        });
      },
      handleclo() {
        this.$refs.multipleTable.clearSelection()
      },
      db(row) {
        this.ids = row;
        this.handleclo()
        this.formData.tenderNoticeProjectsId = this.ids.tenderProjectsId;
        this.formData.tenderNoticeMonery = this.ids.tenderProjectsMoney;
        this.formData.tenderProjectsName = this.ids.tenderProjectsName;
        this.dialogFormVisible = false;
      },
      xzxm() {
        this.dialogFormVisible = true;
        // this.getList()
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
<style>
  .xhz {
    margin: 0 auto;
    width: 1100px;
    height: 100%;
    padding: 0px 10px 10px 10px;

    /* background-color: #f6f6f6; */
    /* .el-input--medium .el-input__inner {
      width: 350px;
    } */
  }
</style>
