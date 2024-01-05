<template>
  <div class="app-container">
    <div
      class="header"
      style="height: 50px;background-color: white;"
    >
      <div style="height: 50px; line-height: 20px;">
        <div style="float: left;">
          <img
            src="@/assets/logo/Inbound_list.png"
            alt="donate"
            width="40px"
            style="margin: 6px 10px -11px 30px;"
          />
          <span>投标单</span>
        </div>
        <div style="float: left;padding: 9px 0px 0px 1291px;">
          <el-button
            type="primary"
            @click="submitForm"
          >确 定</el-button>
        </div>
      </div>

    </div>
    <div>
      <div class="boxs">
        <div class="top">
          <h1>投标单</h1>
        </div>
        <div
          class="section_bos"
          style="border-radius: 3px;"
        >
          <div style="
              height: 50px;
              background-color: white;
              border-left: 7px rgb(45, 183, 245) solid;
            ">
            <h3 style="padding: 15px; font-weight: 600">基本信息</h3>
          </div>
          <el-form
            :model="formDates"
            ref="vForm"
            label-position="left"
            label-width="150px"
            size="medium"
            @submit.native.prevent
            style="background-color: white;border-radius: 9px"
          >
            <el-row>
              <el-col
                :span="8"
                class="grid-cell"
                style="padding: 10px 0px 0px 23px;"
              >
                <el-form-item
                  label="供应商姓名"
                  prop="abbreviated"
                  class="required"
                >
                  <el-input
                    type="text"
                    v-model="formDates.abbreviated"
                    clearable
                    style="width: 250px;"
                    :readonly="true"
                  ></el-input>
                </el-form-item>
                <el-form-item
                  label="总价"
                  class="required"
                  prop="lumpSum"
                >
                  <template slot-scope="scope">
                    <el-input
                      v-model="lumpSum"
                      :readonly="true"
                    > </el-input>
                  </template>
                </el-form-item>
                <el-form-item
                  label="投标附件上传"
                  prop="fileupload39631"
                >
                  <el-upload
                    ref="upload"
                    class="upload-demo"
                    :limit="2"
                    accept=".doc, .docx,.rar,.txt"
                    multiple
                    :action="upload.url"
                    :headers="upload.headers"
                    :file-list="upload.fileList"
                    :before-remove="beforeRemove"
                    :on-progress="handleFileUploadProgress"
                    :on-success="handleFileSuccess"
                    :auto-upload="false"
                  >
                    <el-button
                      slot="trigger"
                      size="small"
                      type="primary"
                    >选取文件</el-button>
                    <el-button
                      style="margin-left: 10px;"
                      size="small"
                      type="success"
                      :loading="upload.isUploading"
                      @click="submitUpload"
                    >上传到服务器</el-button>
                    <div
                      slot="tip"
                      class="el-upload__tip"
                    >只能上传.doc, .docx,.rar,.txt文件，且不超过5MB</div>
                  </el-upload>
                </el-form-item>
              </el-col>
              <el-col
                :span="8"
                class="grid-cell"
                style="padding: 10px 0px 0px 23px;"
              >
                <el-form-item
                  label="投标人名称"
                  prop="delegates"
                  class="required"
                >
                  <el-input
                    type="text"
                    v-model="formDates.delegates"
                    clearable
                    style="width: 250px;"
                  >
                  </el-input>
                </el-form-item>

                <el-form-item
                  label="联系电话"
                  prop="responsiblePhone"
                  class="required"
                >
                  <el-input
                    v-model="formDates.responsiblePhone"
                    type="text"
                    clearable
                    style="width: 250px;"
                  ></el-input>
                </el-form-item>

              </el-col>
              <el-col
                :span="8"
                class="grid-cell"
                style="padding: 10px 0px 0px 23px;"
              >
                <el-form-item
                  label="联系人"
                  prop="responsible"
                  class="required"
                >
                  <el-input
                    type="text"
                    v-model="formDates.responsible"
                    clearable
                    style="width: 250px;"
                  >
                  </el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-form>
        </div>
        <div
          class="footer"
          style="background-color: white;height: 200px;border-radius: 12px;"
        >
          <div style="
              height: 50px;
              background-color: white;
              border-left: 7px rgb(45, 183, 245) solid;
              margin-bottom: 15px;
            ">
            <h3 style="padding: 15px; font-weight: 600">收货明细信息</h3>
          </div>
          <el-table
            ref="tb"
            :data="manifestList"
            style="width: 100%;padding: 1px 30px;"
            :row-class-name="rowClassName"
          >

            <el-table-column
              type="selection"
              width="30"
              align="center"
            />
            <el-table-column
              label="序号"
              align="center"
              prop="xh"
              width="50"
            />
            <el-table-column
              label="物料编号"
              align="center"
              prop="goodsCode"
              width="200"
            >
              <template slot-scope="scope">
                <el-input
                  v-model="scope.row.publicGoods.goodsCode"
                  :readonly="true"
                > </el-input>
              </template>
            </el-table-column>

            <el-table-column
              label="物料名称"
              align="center"
              prop="goodsName"
              width="200"
            >
              <template slot-scope="scope">
                <el-input
                  v-model="scope.row.publicGoods.goodsName"
                  :readonly="true"
                ></el-input>
              </template>
            </el-table-column>

            <el-table-column
              label="物料分类"
              align="center"
              prop="categoryName"
              width="200"
            >
              <template slot-scope="scope">
                <el-input
                  v-model="scope.row.publicCategory.categoryName"
                  :readonly="true"
                ></el-input>
              </template>
            </el-table-column>

            <el-table-column
              label="计量单位"
              align="center"
              prop="grade"
              width="200"
            >
              <template slot-scope="scope">
                <el-select
                  v-model="scope.row.publicGoods.goodsType"
                  placeholder="请选择单位"
                >
                  <el-option
                    :disabled="true"
                    v-for="dict in dict.type.goods_unit"
                    :key="dict.value"
                    :label="dict.label"
                    :value="parseInt(dict.value)"
                  ></el-option>
                </el-select>
              </template>
            </el-table-column>

            <el-table-column
              label="需求数量"
              align="center"
              prop="exempt"
              width="130"
            >
              <template slot-scope="scope">
                <el-input-number
                  :disabled="true"
                  v-model="scope.row.bidTenderManifest.explains"
                  class="full-width-input"
                  controls-position="right"
                  :min="1"
                  :max="100000000000"
                  :precision="0"
                  :step="1"
                >
                </el-input-number>
              </template>
            </el-table-column>
            <el-table-column
              label="可供数量"
              prop="exempt"
              align="center"
              width="130"
            >
              <template slot-scope="scope">
                <el-input-number
                  :disabled="true"
                  v-model="scope.row.bidTenderManifest.explains"
                  class="full-width-input"
                  controls-position="right"
                  :min="1"
                  :max="100000000000"
                  :precision="0"
                  :step="1"
                >
                </el-input-number>
              </template>
            </el-table-column>
            <el-table-column
              label="单价"
              prop="price"
              align="center"
              width="130"
            >
              <template slot-scope="scope">
                <el-input-number
                  @input="jishuan(scope.row)"
                  v-model="scope.row.price"
                  class="full-width-input"
                  controls-position="right"
                  :min="1"
                  :max="100000000000"
                  :precision="0"
                  :step="1"
                >
                </el-input-number>
              </template>
            </el-table-column>
            <el-table-column
              label="总金额"
              align="center"
              prop="zj"
              width="100"
            >
              <!-- <el-input
                v-model="hangSum"
                :readonly="true"
              ></el-input> -->
              <template slot-scope="scope">
                <!-- <el-input v-model="scope.row.zj"> -->
                {{((scope.row.bidTenderManifest.explains == null || scope.row.price == null) ? 0 : ((scope.row.bidTenderManifest.explains * scope.row.price))) | formattedAmount}}
                <!-- </el-input> -->
              </template>
            </el-table-column>
          </el-table>

        </div>

      </div>
    </div>
  </div>
</template>
<script>
import { getToken } from "@/utils/auth";
import { getVendor } from "@/api/public/vendor";
import { deskShows } from "@/api/bidding/tender_projects";
import { selBidCount } from "@/api/bidding/tender";

export default {
  dicts: ["goods_unit"],
  data() {
    return {
      // 基本信息
      formDates: [],
      //供应商公告ID
      id: null,
      //项目ID
      projects_id: null,
      //供应商ID
      vendor_id: null,
      //物料信息
      manifestList: [],
      zj: null,
      //单价
      price: 1,
      //总金额
      lumpSum: null,
      //文件
      formData: [],
      // 上传参数
      upload: {
        // 上传的文件列表
        fileList: [],
        // 是否禁用上传
        isUploading: false,
        // 设置上传的请求头部
        headers: {
          Authorization: "Bearer " + getToken(),
        },
        // 上传的地址
        url: "/dev-api/bidding/annex/articleImg",
      },
      // ht: false,
      // xx: null,
    };
  },
  created() {
    this.id = this.$route.query.tenderNoticeId;
    this.projects_id = this.$route.query.ProjectsId;
    this.vendor_id = 2;
    this.getDates();
    this.getDeskShow();
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
    jishuan(row) {
      let x = 0;
      this.manifestList.forEach((e, i) => {
        if (e.price != null && e.price != "" && e.price != undefined)
          x += e.price * e.bidTenderManifest.explains;
      });
      this.lumpSum = x;
    },
    getDates() {
      let vendor_Id = 2;
      getVendor(vendor_Id).then((response) => {
        this.formDates = response.data;
      });
    },
    submitForm() {
      let tenderNoticeId = this.id;
      let tenderSupplierId = this.vendor_id;
      let tenderSupplierName = this.formDates.abbreviated;
      let tenderName = this.formDates.delegates;
      let contact = this.formDates.responsible;
      let phone = this.formDates.responsiblePhone;
      let prices = this.lumpSum;
      let json5 = JSON.stringify(this.formData);
      let fd = new FormData();
      fd.append("tenderNoticeId", tenderNoticeId);
      fd.append("tenderSupplierId", tenderSupplierId);
      fd.append("tenderSupplierName", tenderSupplierName);
      fd.append("tenderName", tenderName);
      fd.append("contact", contact);
      fd.append("phone", phone);
      fd.append("prices", prices);
      fd.append("json5", json5);
      console.log(json5);
      axios
        .post("/dev-api/bidding/tender/addTenders", fd, {
          headers: {
            Authorization: `Bearer ${getToken()}`,
            "Content-Type": "multipart/form-data", // 设置请求头为 multipart/form-data
          },
        })
        .then((response) => {
          if (response.data === 1) {
            selBidCount(this.id,this.vendor_id).then((response) =>{
              console.log(response);
            });
            this.$modal.msgSuccess("投标成功");
            this.$router.push({
              path: "/index",
              name: "index_desk",
            });
          }
        })
        .catch((error) => {
          // 处理错误
        });
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
      console.log(file);
      let thet = this;
      this.formData.push({
        annexTitle: file.name,
        annexUrl: file.response.data.url,
        annexTypeId: 14,
      });
      console.log(this.formData);
      this.upload.isUploading = false;
    },
    beforeRemove(file, fileList) {
      return this.$confirm(`确定移除 ${file.name}？`);
    },
    //物料信息
    getDeskShow() {
      let vendor_Id = 2;
      deskShows(this.id, this.projects_id, vendor_Id).then((response) => {
        this.manifestList = response.rows;
      });
    },
    // row是行对象，rowindex是行号，从0开始。所以这样就能实现了序号(xh属性)递增并且取值为行号加1。
    rowClassName({ row, rowIndex }) {
      row.xh = rowIndex + 1;
    },
  },
};
</script>

<style scoped lang="scss">
.app-container {
  background-color: rgb(241, 244, 248);
  height: 100%;

  .boxs {
    margin: 1px 144px 0px 144px;
    height: 100%;

    .top {
      background-color: white;
      height: 100px;
      text-align: center;
      border-radius: 12px;

      h1 {
        padding: 32px 0px;
        color: rgb(95, 157, 236);
      }
    }
  }
}
</style>

