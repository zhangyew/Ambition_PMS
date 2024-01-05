<template>
  <div>
    <div style="padding: 30px;background-color: #f3f3f3;">
      <div class="top">
        <div id="top_img" style="width: 100px; float: left">
          <img src="@/assets/logo/logo2.jpg" alt="donate" height="100px" width="230px" />
        </div>
        <h1>{{gys}}</h1>
      </div>
      <div>

      </div>
      <el-form :model="formData" ref="vForm" :rules="rules" label-position="left" label-width="150px" size="medium"
        @submit.native.prevent>
        <div class="static-content-item">
          <el-divider direction="horizontal" content-position="left"></el-divider>
        </div>
        <div class="card-container">
          <el-card style="{width: 100% !important}" shadow="hover">
            <div slot="header" class="clear-fix">
              <span>基本信息</span>
              <i class="float-right el-icon-arrow-down"></i>
            </div>
            <el-row>
              <el-col :span="12" class="grid-cell">
                <el-form-item label="供应商名称" prop="abbreviated" class="required label-right-align">
                  <el-input v-model="formData.abbreviated" type="text" clearable></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12" class="grid-cell">
                <el-form-item label="服务范围" prop="ranges" class="required label-right-align">
                  <el-input v-model="formData.ranges" type="text" clearable></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12" class="grid-cell">
                <el-form-item label="供应商编号" prop="vendorNumber" class="label-right-align">
                  <el-input v-model="formData.vendorNumber" :readonly="true" :disabled="true" type="text"
                    clearable></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12" class="grid-cell">
                <el-form-item label="注册原因" prop="causes" class="required label-right-align">
                  <el-input v-model="formData.causes" type="text" clearable></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12" class="grid-cell">
                <el-form-item label="仓库地址" prop="warehouseAddress" class="required label-right-align">
                  <el-input v-model="formData.warehouseAddress" type="text" clearable></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12" class="grid-cell">
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12" class="grid-cell">
                <el-form-item label="合同类型" prop="contractTypeTypeId" class="required label-right-align">
                  <el-select v-model="formData.contractTypeTypeId" placeholder="请选择合同类型">
                    <el-option v-for="dict in dict.type.contract_type" :key="dict.value" :label="dict.label"
                      :value="parseInt(dict.value)"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="12" class="grid-cell">
              </el-col>
            </el-row>
            <el-row>
         <!--     <el-col :span="12" class="grid-cell">
                <el-form-item label="状态" prop="vendorTypeStateId" class="required label-right-align">
                  <el-select v-model="formData.vendorTypeStateId" placeholder="请选择状态">
                    <el-option v-for="dict in dict.type.vendor_state" :key="dict.value" :label="dict.label"
                      :value="parseInt(dict.value)"></el-option>
                  </el-select>
                </el-form-item>
              </el-col> -->
              <el-col :span="12" class="grid-cell">
              </el-col>
            </el-row>
          </el-card>
        </div>
        <div class="static-content-item">
          <el-alert title="" type=info :closable="false" :center="false" :show-icon="false" effect="light">
          </el-alert>
        </div>
        <div class="card-container">
          <el-card style="{width: 100% !important}" shadow="hover">
            <div slot="header" class="clear-fix">
              <span>联系人</span>
              <i class="float-right el-icon-arrow-down"></i>
            </div>
            <el-row>
              <el-col :span="24" class="grid-cell">
                <el-row>
                  <el-col :span="12" class="grid-cell">
                    <el-form-item label="姓名" prop="call" class="required label-right-align">
                      <el-input v-model="formData.call" type="text" clearable></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="12" class="grid-cell">
                    <el-form-item label="部门" prop="division" class="label-right-align">
                      <el-input v-model="formData.division" :disabled="true" type="text" clearable></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row>
                  <el-col :span="12" class="grid-cell">
                    <el-form-item label="邮箱" prop="mailbox" class="label-right-align">
                      <el-input v-model="formData.mailbox" type="text" clearable></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="12" class="grid-cell">
                    <el-form-item label="岗位" prop="job" class="label-right-align">
                      <el-input v-model="formData.job" :disabled="true" type="text" clearable></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row>
                  <el-col :span="12" class="grid-cell">
                    <el-form-item label="电话" prop="phone" class="required label-right-align">
                      <el-input v-model="formData.phone" type="text" clearable></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="12" class="grid-cell">
                  </el-col>
                </el-row>
              </el-col>
            </el-row>
          </el-card>
        </div>
        <div class="static-content-item">
          <el-alert title="" type=info :closable="false" :center="true" :show-icon="false" effect="light">
          </el-alert>
        </div>
        <div class="card-container">
          <el-card style="{width: 100% !important}" shadow="hover">
            <div slot="header" class="clear-fix">
              <span>工商信息</span>
              <i class="float-right el-icon-arrow-down"></i>
            </div>
            <el-row>
              <el-col :span="12" class="grid-cell">
                <el-form-item label="法定代表" prop="delegates" class="required label-right-align">
                  <el-input v-model="formData.delegates" type="text" clearable></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12" class="grid-cell">

                <el-form-item label="邮箱" prop="email" class="label-right-align">
                  <el-input v-model="formData.email" type="text" clearable></el-input>

                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12" class="grid-cell">
                <el-form-item label="负责人" prop="responsible" class="required label-right-align">
                  <el-input v-model="formData.responsible" type="text" clearable></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12" class="grid-cell">
                <el-form-item label="负责人手机号" prop="responsiblePhone" class="required label-right-align">
                  <el-input v-model="formData.responsiblePhone" type="text" clearable></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12" class="grid-cell">
                <el-form-item label="传真" prop="fax" class="label-right-align">
                  <el-input v-model="formData.fax" type="text" clearable></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12" class="grid-cell">
                <el-form-item label="注册时间" prop="addTime" class="label-right-align">

                  <el-date-picker v-model="formData.addTime" class="full-width-input" clearable></el-date-picker>

                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12" class="grid-cell">
                <el-form-item label="银行卡号" prop="industrialCommercial" class="required label-right-align">
                  <el-input v-model="formData.industrialCommercial" type="text" clearable></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12" class="grid-cell">
                <el-form-item label="简介" prop="profile" class="label-right-align">
                  <el-input v-model="formData.profile" type="text" clearable></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12" class="grid-cell">
                <el-form-item label="银行名称" prop="bankingName" class="required label-right-align">
                  <el-input v-model="formData.bankingName" type="text" clearable></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12" class="grid-cell">
              </el-col>
              <el-col :span="12" class="grid-cell">
              </el-col>
            </el-row>
          </el-card>
        </div>
        <div class="static-content-item">
          <el-alert title="" type=info :closable="false" :center="false" :show-icon="false" effect="light">
          </el-alert>
        </div>
        <div class="card-container">

          <el-card style="{width: 100% !important}" shadow="hover">
            <div slot="header" class="clear-fix">
              <span>资质信息</span>
            </div>
            <el-row>
              <el-button type="primary" icon="el-icon-plus" size="mini" @click="handleAddDetails">添加</el-button>
              <el-button type="success" icon="el-icon-delete" size="mini" @click="handleDeleteDetails">删除</el-button>
              <el-button type="danger" icon="el-icon-delete" size="mini" @click="handleDeleteAllDetails">清空</el-button>
            </el-row>
            <el-row>
              <el-table :data="qualificationList" :row-class-name="rowClassName"
                @selection-change="chandleDetailSelectionChange" ref="tb" style="width: 100%;">

                <el-table-column type="selection" width="30" align="center" />

                <el-table-column label="资质名称" align="center" prop="qualificationName" width="200">
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.qualificationName" />
                  </template>
                </el-table-column>
                <el-table-column label="有效期起" align="center" prop="startTime" width="250">
                  <template slot-scope="scope">
                    <el-date-picker v-model="scope.row.startTime" :style="{width: '100%'}"></el-date-picker>
                  </template>
                </el-table-column>
                <el-table-column label="有效期终" align="center" prop="stopTime" width="250">
                  <template slot-scope="scope">
                    <el-date-picker v-model="scope.row.stopTime" :style="{width: '100%'}"></el-date-picker>
                  </template>
                </el-table-column>
                <el-table-column label="资质证件" width="250" prop="documents">
                  <template slot-scope="scope">
                    <el-upload :ref="'upload'+scope.$index" class="upload-demo" :limit="1"
                      accept=".doc,.docx,.xsl,.xlsx,.png,.jpg" :action="upload.url" :headers="upload.headers"
                      :file-list="fileList" :before-remove="beforeRemove" :on-progress="handleFileUploadProgress"
                      :on-success="handleFileSuccess" :auto-upload="false">
                      <el-button slot="trigger" plain size="mini" type="primary">选取文件</el-button>
                      <el-button style="margin-left: 10px;" plain size="small" type="success" icon="el-icon-upload2"
                        @click="submitUpload(scope.$index)">上传</el-button>
                    </el-upload>
                  </template>
                </el-table-column>
                <el-table-column label="备注" align="center" prop="remark" width="250">
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.remark" />
                  </template>
                </el-table-column>
              </el-table>

            </el-row>

          </el-card>
        </div>
        <el-row>
          <el-col :span="18" class="grid-cell">

            <el-button @click="submitForm">提交</el-button>

            <el-button @click="fh">返回</el-button>
          </el-col>
        </el-row>
      </el-form>

    </div>

    <!-- <el-button @click="addOrUpdateVisible=true">商品</el-button> -->
    <GoodsView @Goods="getGoods" :addOrUpdateVisible="addOrUpdateVisible" ref="addOrUpdateRef"></GoodsView>
  </div>
</template>

<script>
  import GoodsView from '@/components/Goods'
  import {
    listVendor,
    insertVendor,
    getVendor,
    delVendor,
    addVendor,
    findVendorDetailed,
    updateVendor
  } from "@/api/public/vendor";
  import {
    getToken
  } from '../../../utils/auth';

  export default {
    dicts: ['contract_type', 'vendor_state'],
    data() {
      return {
        vid: 0,
        gys: '供应商注册',
        addOrUpdateVisible: false,
        goodsfrom: {},

        indexs: 0,
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
        formData: {
          vendorId: null,
          contactsId: null,
          abbreviated: "",
          ranges: "",
          vendorNumber: "",
          causes: "",
          warehouseAddress: "",
          call: "",
          division: "",
          phone: "",
          job: "",
          contractTypeTypeId: null,
          vendorTypeStateId: null,
          createBy: "",
          updateBy: "",
          mailbox: "",
          delegates: "",
          email: "",
          responsible: "",
          responsiblePhone: "",
          fax: "",
          addTime: "",
          industrialCommercial: "",
          bankingName: "",
          profile: "",
          mailbox: "",
          delegates: "",
          input42837: "",
          responsible: "",
          responsiblePhone: "",
          fax: "",
          addTime: null,
          industrialCommercial: "",
          profile: "",
          qualificationName: "",
          startTime: null,
          stopTime: null,
          documents: null
        },
        rules: {
          abbreviated: [{
            required: true,
            message: '字段值不可为空',
          }],
          contractTypeTypeId: [{
            required: true,
            message: '请选择合同类型',
          }],
          vendorTypeStateId: [{
            required: true,
            message: '请选择状态',
          }],
          ranges: [{
            required: true,
            message: '字段值不可为空',
          }],
          causes: [{
            required: true,
            message: '字段值不可为空',
          }],
          warehouseAddress: [{
            required: true,
            message: '字段值不可为空',
          }],
          call: [{
            required: true,
            message: '字段值不可为空',
          }],
          phone: [{
            required: true,
            message: '字段值不可为空',
          }, {
            pattern: /^[1][3-9][0-9]{9}$/,
            trigger: ['blur', 'change'],
            message: '请输入11位手机号'
          }],
          mailbox: [{
            pattern: /^([-_A-Za-z0-9.]+)@([_A-Za-z0-9]+\.)+[A-Za-z0-9]{2,3}$/,
            trigger: ['blur', 'change'],
            message: ''
          }],
          delegates: [{
            required: true,
            message: '字段值不可为空',
          }],
          input42837: [{
            pattern: /^([-_A-Za-z0-9.]+)@([_A-Za-z0-9]+\.)+[A-Za-z0-9]{2,3}$/,
            trigger: ['blur', 'change'],
            message: ''
          }],
          responsible: [{
            required: true,
            message: '字段值不可为空',
          }],
          responsiblePhone: [{
            required: true,
            message: '字段值不可为空',
          }, {
            pattern: /^[1][3-9][0-9]{9}$/,
            trigger: ['blur', 'change'],
            message: ''
          }],
          industrialCommercial: [{
            required: true,
            message: '字段值不可为空',
          }],
          bankingName: [{
            required: true,
            message: '字段值不可为空',
          }],
          qualificationName: [{
            required: true,
            message: '字段值不可为空',
          }],
          startTime: [{
            required: true,
            message: '字段值不可为空',
          }],
          stopTime: [{
            required: true,
            message: '字段值不可为空',
          }],
          documents: [{
            required: true,
            message: '字段值不可为空',
          }],
        },
        documentsFileList: [],
        documentsUploadHeaders: {},
        documentsUploadData: {},
        //选中的从表数据
        checkedDetail: [],
        qualificationList: [{
          qualificationName: "",
          startTime: "2021-12-02",
          stopTime: "2022-02-22",
          documents: ""
        }],
        listFile: [],
        returnFile: [],
        scname: null,
      }
    },
    components: {
      GoodsView
    },
    created() {
      this.vid = this.$route.query.vid;
      if (this.vid != null) {
        this.gys = "供应商修改"
        // findVendorDetailed(this.vid).then(response => {
        //   this.formData = response.rows;
        //   console.log(response.rows)
        // });
        axios.post('/dev-api/bidding/vendor/findVendorDetailed?vid=' + this.vid, this.vid, {
            headers: {
              'Authorization': `Bearer ${getToken()}`,
              //'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
            },
          })
          .then(response => {
            this.$modal.msgSuccess("数据加载成功");
            // 处理响应
            this.formData = response.data.data
            this.formData.call = response.data.data.publicContacts.call;
            this.formData.mailbox = response.data.data.publicContacts.mailbox;
            this.formData.phone = response.data.data.publicContacts.phone;
            this.formData.contactsId = response.data.data.publicContacts.contactsId;
            this.qualificationList = [];
            response.data.data.publicQualificationList.forEach((e, i) => {
              this.qualificationList.push({
                qualificationId: e.qualificationId,
                qualificationName: e.qualificationName,
                startTime: e.startTime,
                stopTime: e.stopTime,
                documents: e.documents,
                remark: e.remark
              });
            })
          })
      }
    },
    methods: {
      fh() {
        this.$router.back()
      },
      getGoods(val, x) {
        this.goodsfrom = val;
        if (x === 'false') {
          this.addOrUpdateVisible = false
        } else {
          this.addOrUpdateVisible = true
        }
        console.log(this.goodsfrom)
      },
      submitForm() {
        var thet = this;
        const file = new FormData();
        this.formData.createBy = this.$store.state.user.name;
        this.formData.updateBy = this.$store.state.user.name;

        this.$refs['vForm'].validate(valid => {
          if (!valid) return
          //TODO: 提交表单
          if (thet.qualificationList.length != thet.returnFile.length) {
            // alert("至少添加一条资质信息!")
            this.$modal.msgWarning("请上传所有资质证件后进行操作");
            return
          }
          for (var i = 0; i < thet.qualificationList.length; i++) {
                    var startDate = new Date(thet.qualificationList[i].startTime);
            var stopDate = new Date(thet.qualificationList[i].stopTime);
            if (startDate >= stopDate) {
              // alert("终止时间不能小于起始时间")
              this.$modal.msgWarning("终止时间不能小于起始时间");
              return false;
            }
          }

          let zz = JSON.stringify(this.qualificationList);
          this.$set(this.formData, "returnFile", JSON.stringify(this.returnFile));
          if (this.vid != null) {
            this.formData.publicQualificationList = null
            this.formData.publicContacts = null
          }
          this.$set(this.formData, "qualificationList", zz);
          let json = JSON.stringify(this.formData)
          const blob = new Blob([json], {
            type: 'application/json'
          })
          file.append("map", blob)
          console.log(json)
          axios.post('/dev-api/bidding/vendor/insertVendor', file, {
              headers: {
                'Authorization': `Bearer ${getToken()}`,
                'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
              },
            })
            .then(response => {
              // 处理响应
              console.log(response)
              if (response.data == 1) {
                this.$modal.msgSuccess("注册成功");
                this.$router.go(-1)
              }
            })
            .catch(error => {
              // 处理错误
            });

        })
        this.listFile = [];
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
        if (this.qualificationList === undefined) {
          this.qualificationList = new Array();
        }

        var time = new Date;
        this.qualificationList.push({
          qualificationName: "",
          startTime: time,
          stopTime: time,
          documents: ""
        });
      },
      submitUpload(index) {
        let x = 'upload' + index
        this.$refs[x].submit();
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
          annexTypeId: 0,
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
      // 删除
      handleDeleteDetails() {
        if (this.checkedDetail.length > 0) {
          this.qualificationList.splice(this.checkedDetail[0].xh - 1, 1);
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
        this.qualificationList = undefined;
        this.$refs['vForm'].validate(valid => {
          if (!valid) return
          //TODO: 提交表单
        })
      },
      resetForm() {
        this.$refs['vForm'].resetFields()
      }
    }
  }
</script>

`
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
