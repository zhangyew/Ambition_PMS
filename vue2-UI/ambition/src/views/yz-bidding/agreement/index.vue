<template>
  <div class="app-container">
    <div class="boxs">
      <div class="top">
        <div
          id="top_img"
          style="width: 100px; float: left"
        >
          <img
            src="@/assets/logo/logo2.jpg"
            alt="donate"
            height="100px"
            width="230px"
          />
        </div><!-- formDetails.contractdetailsType -->
        <h1> {{ ht }}合同申请表</h1>
      </div>
      <div class="section_bos">
        <div style="
            height: 50px;
            background-color: rgb(250, 250, 253);
            border-left: 3px rgb(45, 183, 245) solid;
          ">
          <h3 style="padding: 15px; font-weight: 600">合同申请信息</h3>
        </div>
        <el-form
          :model="formAgreement"
          ref="vForm"
          label-position="left"
          label-width="150px"
          size="medium"
          @submit.native.prevent
        >
          <el-row style="margin-top: 15px">
            <el-col
              :span="12"
              class="grid-cell"
              style="padding: 0px 0px 0px 95px;"
            >
              <el-form-item
                label="申请人"
                prop="applicant"
                class="required"
              >
                <el-input
                  v-model="formAgreement.applicant"
                  type="text"
                  clearable
                  style="width: 300px;"
                ></el-input>
              </el-form-item>
              <el-form-item
                label="申请部门"
                prop="contractSector"
                class="required"
              >
                <el-input
                  v-model="formAgreement.contractSector"
                  type="text"
                  clearable
                  style="width: 300px;"
                  :readonly="true"
                ></el-input>
              </el-form-item>
              <el-form-item
                label="项目相关合同"
                prop="contractProjectRelated"
              >
                <el-select
                  v-model="formAgreement.contractProjectRelated"
                  class="full-width-input"
                  clearable
                  style="width: 300px;"
                @change="xuanzhe(value)"
                >
                  <el-option
                  
                    v-for="(item, index) in option_projets"
                    :key="index"
                    :label="item.label"
                    :value="item.value"
                    :disabled="item.disabled"
                  ></el-option>
                </el-select>
              </el-form-item>
              <el-form-item
                label="是否主子合同"
                prop="contractMaster"
              >
                <el-radio-group v-model="formAgreement.contractMaster">
                  <el-radio :label="1">否</el-radio>
                  <el-radio :label="2">是</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item
                label="项目总预算"
                prop="contractTotalBudget"
                class="required"
              >
                <el-input
                  v-model="formAgreement.contractTotalBudget"
                  type="text"
                  clearable
                  style="width: 300px;"
                  :readonly="true"
                ></el-input>
              </el-form-item>
            </el-col>
            <el-col
              :span="12"
              class="grid-cell"
            >
              <el-form-item
                label="申请时间"
                prop="applicantTime"
              >
                <el-date-picker
                  v-model="formAgreement.applicantTime"
                  type="date"
                  class="full-width-input"
                  format="yyyy-MM-dd"
                  value-format="yyyy-MM-dd"
                  clearable
                  style="width: 300px;"
                ></el-date-picker>
              </el-form-item>
              <el-form-item
                label="申请公司"
                prop="firm"
                class="required"
              >
                <el-input
                  v-model="formAgreement.firm"
                  type="text"
                  clearable
                  style="width: 300px;"
                  :readonly="true"
                ></el-input>
              </el-form-item>

              <el-form-item
                label="相关项目"
                prop="contractProjectsId"
              >
                <el-autocomplete
                  popper-class="my-autocomplete"
                  v-model="formAgreement.contractProjectsId"
                  :fetch-suggestions="querySearch"
                  placeholder="请输入内容"
                  @select="handleSelect"
                  style="width: 300px;"
                  :disabled="formAgreement.contractProjectRelated === 1"
                >
                  <i
                    class="el-icon-search el-input__icon"
                    slot="suffix"
                  ></i>
                  <template slot-scope="{ item }">
                    <div
                      class="name"
                      style="display: none;"
                    >{{ item.value }}</div>
                    <label class="name">{{ item.number }}</label>&nbsp; &nbsp;&nbsp;
                    <span class="addr">{{ item.name }}</span>
                  </template>
                </el-autocomplete>
              </el-form-item>

              <el-form-item
                label="关联主合同"
                prop="contractPrimeId"
              >
                <el-autocomplete
                  popper-class="my-autocomplete"
                  v-model="formAgreement.contractPrimeId"
                  :fetch-suggestions="querySearchs"
                  placeholder="请输入内容"
                  @select="handleSelects"
                  style="width: 300px;"
                  :disabled="formAgreement.contractMaster === 1"
                >
                  <i
                    class="el-icon-search el-input__icon"
                    slot="suffix"
                    @click="handleIconClicks"
                  ></i>
                  <template slot-scope="{ item }">
                    <div
                      class="name"
                      style="display: none;"
                    >{{ item.value }}</div>
                    <label class="name">{{ item.number }}</label>&nbsp; &nbsp;&nbsp;
                    <span class="addr">{{ item.name }}</span>
                  </template>
                </el-autocomplete>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
        <div style="
              height: 50px;
              background-color: rgb(250, 250, 253);
              border-left: 3px rgb(45, 183, 245) solid;
            ">
          <h3 style="padding: 15px; font-weight: 600">合同基本信息</h3>
        </div>
        <el-form
          :model="formDetails"
          ref="vForm"
          label-position="left"
          label-width="150px"
          size="medium"
          @submit.native.prevent
        >
          <el-row style="margin-top: 15px">
            <el-col
              :span="12"
              class="grid-cell"
              style="padding: 0px 0px 0px 95px;"
            >
              <el-form-item
                label="合同名称"
                prop="contractdetailsName"
              >
                <el-input
                  v-model="formDetails.contractdetailsName"
                  type="text"
                  clearable
                  style="width: 300px;"
                ></el-input>
              </el-form-item>
              <el-form-item
                label="合同类型"
                prop="contractdetailsType"
              >
                <el-select
                  v-model="formDetails.contractdetailsType"
                  class="full-width-input"
                  clearable
                  style="width: 300px;"
                  disabled="disabled"
                >
                  <el-option
                    v-for="(item, index) in htState"
                    :key="index"
                    :label="item.label"
                    :value="item.value"
                    :disabled="item.disabled"
                  ></el-option>
                </el-select>
              </el-form-item>
              <el-form-item
                label="开启时间"
                prop="openTime"
              >
                <el-date-picker
                  v-model="formDetails.openTime"
                  type="date"
                  class="full-width-input"
                  format="yyyy-MM-dd"
                  value-format="yyyy-MM-dd"
                  clearable
                  style="width: 300px;"
                  :picker-options="pickerOptions0"
                ></el-date-picker>
              </el-form-item>
              <el-form-item
                label="合同金额"
                prop="contractdetailsAmount"
              >
                <el-input
                  v-model="formDetails.contractdetailsAmount"
                  :readonly="true"
                  type="text"
                  style="width: 300px;"
                ></el-input>
              </el-form-item>
            </el-col>
            <el-col
              :span="12"
              class="grid-cell"
            >
              <el-form-item
                label="合同编号"
                prop="contractdetailsNumber"
              >
                <el-input
                  v-model="formDetails.contractdetailsNumber"
                  :readonly="true"
                  type="text"
                  clearable
                  style="width: 300px;"
                  placeholder="系统自动为您生成"
                ></el-input>
              </el-form-item>
              <el-form-item
                label="密级"
                prop="contractdetailsLevel"
              >
                <el-radio-group v-model="formDetails.contractdetailsLevel">
                  <el-radio :label="0">密级</el-radio>
                  <el-radio :label="1">非密</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item
                label="结束时间"
                prop="bidEnd"
              >
                <el-date-picker
                  v-model="formDetails.bidEnd"
                  type="date"
                  class="full-width-input"
                  format="yyyy-MM-dd"
                  value-format="yyyy-MM-dd"
                  clearable
                  style="width: 300px;"
                  :picker-options="pickerOptions1"
                ></el-date-picker>
              </el-form-item>
            </el-col>
            <el-col
              :span="24"
              class="grid-cell"
              style="padding: 0px 0px 0px 95px;"
            >
              <el-form-item
                label="合同情况说明"
                prop="illustrate"
              >
                <el-input
                  type="textarea"
                  v-model="formDetails.illustrate"
                  style="width: 1000px;"
                ></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <div style="
              height: 50px;
              background-color: rgb(250, 250, 253);
              border-left: 3px rgb(45, 183, 245) solid;
            ">
            <h3 style="padding: 15px; font-weight: 600">采购方式</h3>
          </div>
          <el-row style="margin-top: 15px">
            <el-col
              :span="12"
              class="grid-cell"
              style="padding: 0px 0px 0px 95px;"
            >
              <el-form-item
                label="采购方式"
                prop="procurementMethod"
              >
                <el-select
                  v-model="formDetails.procurementMethod"
                  clearable
                  style="width: 300px;"
                >
                  <el-option
                    v-for="(item, index) in procurementMethodptions"
                    :key="index"
                    :label="item.label"
                    :value="item.value"
                    :disabled="item.disabled"
                  ></el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col
              :span="12"
              class="grid-cell"
            >
              <el-form-item
                label="采购清单"
                prop="purchaseListId"
              >
                <el-autocomplete
                  popper-class="my-autocomplete"
                  v-model="formDetails.purchaseListId"
                  :fetch-suggestions="querySearch_3"
                  placeholder="请输入内容"
                  @select="handleSelect_3"
                  style="width: 300px;"
                >
                  <i
                    class="el-icon-search el-input__icon"
                    slot="suffix"
                    @click="handleIconClick_3"
                  ></i>
                  <template slot-scope="{ item }">
                    <div
                      class="name"
                      style="display: none;"
                    >{{ item.value }}</div>
                    <label class="name">{{ item.number }}</label>&nbsp; &nbsp;&nbsp;
                    <span class="addr">{{ item.name }}</span>
                  </template>
                </el-autocomplete>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
        <div style="
              height: 50px;
              background-color: rgb(250, 250, 253);
              border-left: 3px rgb(45, 183, 245) solid;
            ">
          <h3 style="padding: 15px; font-weight: 600">合同标的物料信息</h3>
        </div>
        <!-- <el-row style="margin: 15px 0px 15px 70px">
          <el-button
            type="primary"
            icon="el-icon-plus"
            size="mini"
            @click="handleAddDetails"
          >添加</el-button>
          <el-button
            type="success"
            icon="el-icon-delete"
            size="mini"
            @click="handleDeleteDetails"
          >删除</el-button>
          <el-button
            type="danger"
            icon="el-icon-delete"
            size="mini"
            @click="handleDeleteAllDetails"
          >清空</el-button>
        </el-row> -->
        <el-row style="margin: 0px 69px">
          <el-table
            :data="manifestList"
            :row-class-name="rowClassName"
            @selection-change="chandleDetailSelectionChange"
            ref="tb"
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
              align="center"
              label="物料编码"
              width="220"
            >
              <template slot-scope="scope">
                <el-input
                  type="text"
                  :value="scope.row.publicGoods.goodsCode"
                  :readonly="true"
                >
                  <i
                    slot="suffix"
                    class="el-input__icon el-icon-search"
                  ></i>
                </el-input>
                <!-- <GoodsView
                                      @click="addOrUpdateVisible=true"
                  :gysId="formData.vendorName"
                  :addOrUpdateVisible="addOrUpdateVisible"
                  ref="addOrUpdateVisible"
                >
                </GoodsView> -->
              </template>
            </el-table-column>
            <el-table-column
              label="物料名称"
              align="center"
              prop="goodsName"
              width="160"
            >
              <template slot-scope="scope">
                <el-input
                  type="text"
                  :value="scope.row.publicGoods.goodsName"
                  :readonly="true"
                >
                </el-input>
              </template>

            </el-table-column>
            <el-table-column
              label="物料品类"
              align="center"
              prop="categoryName"
              width="170"
            >
              <template slot-scope="scope">
                <el-input
                  type="text"
                  :value="scope.row.publicCategory.categoryName"
                  :readonly="true"
                >
                </el-input>
              </template>
            </el-table-column>
            <el-table-column
              label="物料单位"
              align="center"
              width="120"
            >
              <template slot-scope="scope">
                <dict-tag
                  :disabled="true"
                  :options="dict.type.goods_unit"
                  :value="scope.row.bidTenderManifest.manifestTypeId"
                />
              </template>
            </el-table-column>
            <el-table-column
              label="需求数量"
              align="center"
              width="120"
              prop="demand_count"
            >
              <template slot-scope="scope">
                <el-input
                  v-model="scope.row.bidTenderManifest.explains"
                  :readonly="true"
                />
              </template>
            </el-table-column>
            <!-- <el-table-column
              label="需求日期"
              align="center"
              width="240"
              prop="demand_time"
            >
              <template slot-scope="scope">
                <el-date-picker
                  v-model="scope.row.date"
                  type="date"
                  placeholder="选择需求日期"
                  :picker-options="pickerOptions"
                >
                </el-date-picker>
              </template>
            </el-table-column> -->
            <el-table-column
              label="预算单价"
              align="center"
              width="120"
              prop="budget_amount"
            >
              <template slot-scope="scope">
                <el-input
                  v-model="scope.row.bidTenderManifest.price"
                  :readonly="true"
                />
              </template>
            </el-table-column>
            <el-table-column
              label="行预算金额"
              align="center"
              width="120"
            >
              <!-- 计算出来 -->
              <template
                slot-scope="scope"
                v-model="scope.row.bidTenderManifest.prices"
              >
                <!-- <el-input  /> -->
                {{scope.row.bidTenderManifest.prices | formattedAmount }}
              </template>
            </el-table-column>
            <el-table-column
              label="备注"
              align="center"
              prop="remark"
              width="150"
            >
              <template slot-scope="scope">
                <el-input
                  v-model="scope.row.bidTenderManifest.remark"
                  :readonly="true"
                />
              </template>
            </el-table-column>
          </el-table>
        </el-row>

        <div style="
              height: 50px;
              background-color: rgb(250, 250, 253);
              border-left: 3px rgb(45, 183, 245) solid;
            ">
          <h3 style="padding: 15px; font-weight: 600">合同付款约定</h3>
        </div>
        <el-row style="margin: 15px 0px 15px 70px">
          <el-button
            type="primary"
            icon="el-icon-plus"
            size="mini"
            @click="handleAddDetail"
          >添加</el-button>
          <el-button
            type="success"
            icon="el-icon-delete"
            size="mini"
            @click="handleDeleteDetail"
          >删除</el-button>
          <el-button
            type="danger"
            icon="el-icon-delete"
            size="mini"
            @click="handleDeleteAllDetail"
          >清空</el-button>
        </el-row>
        <el-row style="margin: 0px 65px">
          <el-table
            :data="payMentList"
            :row-class-name="rowClassName"
            @selection-change="chandleDetailSelectionChange"
            ref="tb"
          >
            <el-table-column
              type="selection"
              width="50"
              align="center"
            />
            <el-table-column
              label="序号"
              align="center"
              prop="xh"
              width="80"
            ></el-table-column>
            <el-table-column
              label="款项内容"
              align="center"
              width="180"
              prop="content"
            >
              <template slot-scope="scope">
                <el-select
                  v-model="scope.row.content"
                  placeholder="请选择款项内容"
                >
                  <el-option
                    v-for="dict in dict.type.content"
                    :key="dict.value"
                    :label="dict.label"
                    :value="parseInt(dict.value)"
                  ></el-option>
                </el-select>
              </template>
            </el-table-column>
            <el-table-column
              label="付款日期"
              align="center"
              prop="payTime"
              width="200"
            >
              <template slot-scope="scope">
                <el-date-picker
                  v-model="scope.row.payTime"
                  type="date"
                  placeholder="选择付款日期"
                  :picker-options="pickerOptions"
                >
                </el-date-picker>
              </template>
            </el-table-column>
            <el-table-column
              label="付款单位"
              align="center"
              prop="unit"
              width="170"
            >
              <template slot-scope="scope">
                <el-input v-model="scope.row.unit" :readonly="true"/>
              </template>

            </el-table-column>
            <el-table-column
              label="收款合同方"
              align="center"
              prop="paymentVendorId"
              width="150"
            >
              <template slot-scope="scope">
                <el-input v-model="scope.row.paymentVendorId" />
              </template>
            </el-table-column>
            <el-table-column
              label="付款条件"
              align="center"
              prop="terms"
              width="140"
            >
              <template slot-scope="scope">
                <el-input v-model="scope.row.terms" />
              </template>
            </el-table-column>
            <el-table-column
              label="付款金额"
              align="center"
              prop="sum"
              width="160"
            >
              <template slot-scope="scope">
                <el-input
                  v-model="scope.row.sum"
                  type="text"
                  oninput="value=value.replace(/[^\d.]/g,'')"
                  placeholder="请输入付款金额"
                />
              </template>
            </el-table-column>
            <el-table-column
              label="违约责任"
              align="center"
              prop="duty"
              width="150"
            >
              <template slot-scope="scope">
                <el-input v-model="scope.row.duty" />
              </template>
            </el-table-column>
          </el-table>

        </el-row>
        <div style="
              height: 50px;
              background-color: rgb(250, 250, 253);
              border-left: 3px rgb(45, 183, 245) solid;
            ">
          <h3 style="padding: 15px; font-weight: 600">签署执行状态</h3>
        </div>
        <el-form
          :model="formSigning"
          ref="vForm"
          label-position="left"
          label-width="150px"
          size="medium"
          @submit.native.prevent
        >
          <el-row style="margin-top: 15px">
            <el-col
              :span="12"
              class="grid-cell"
              style="padding: 0px 0px 0px 95px;"
            >
              <el-form-item
                label="签署方数"
                prop="signatoriesNumber"
                class="required"
              >
                <el-select
                  v-model="formSigning.signatoriesNumber"
                  class="full-width-input"
                  clearable
                  style="width: 300px;"
                >
                  <el-option
                    v-for="(item, index) in option_signatories"
                    :key="index"
                    :label="item.label"
                    :value="item.value"
                    :disabled="item.disabled"
                  ></el-option>
                </el-select>
              </el-form-item>
              <el-form-item
                label="乙方供应商"
                prop="signingVendorId"
                class="required"
              >
                <el-autocomplete
                  popper-class="my-autocomplete"
                  v-model="formSigning.signingVendorId"
                  :fetch-suggestions="querySearch_4"
                  placeholder="请输入内容"
                  @select="handleSelect_4"
                  style="width: 300px;"
                >
                  <i
                    class="el-icon-search el-input__icon"
                    slot="suffix"
                    @click="handleIconClick_4"
                  ></i>
                  <template slot-scope="{ item }">
                    <div
                      class="name"
                      style="display: none;"
                    >{{ item.value }}</div>
                    <label class="name">{{ item.number }}</label>&nbsp; &nbsp;&nbsp;
                    <span class="addr">{{ item.name }}</span>
                  </template>
                </el-autocomplete>
                <img
                  src="@/assets/images/qxbicon.png"
                  title="查看资信"
                  style="cursor:pointer;margin-left:10px;"
                >
              </el-form-item>

              <el-form-item
                label="乙方联系人"
                prop="signingContact"
                class="required"
              >
                <el-input
                  v-model="formSigning.signingContact"
                  type="text"
                  clearable
                  style="width: 300px;"
                ></el-input>
              </el-form-item>
              <el-form-item
                label="乙方开户行"
                prop="signingBank"
                class="required"
              >
                <el-input
                  v-model="formSigning.signingBank"
                  type="text"
                  clearable
                  style="width: 300px;"
                ></el-input>
              </el-form-item>
              <el-form-item
                label="合同方金额"
                prop="sigingAmount"
                class="required"
              >
                <el-input
                  v-model="formSigning.sigingAmount"
                  type="text"
                  clearable
                  style="width: 300px;"
                  :readonly="true"
                ></el-input>
              </el-form-item>
            </el-col>
            <el-col
              :span="12"
              class="grid-cell"
            >
              <el-form-item
                label="我方主体"
                prop="signingSubject"
              >
                <el-input
                  v-model="formSigning.signingSubject"
                  type="text"
                  clearable
                  style="width: 300px;"
                ></el-input>
              </el-form-item>
              <el-form-item
                label="乙方供应商公司地址"
                prop="signingAddress"
              >
                <el-input
                  v-model="formSigning.signingAddress"
                  type="text"
                  clearable
                  style="width: 300px;"
                ></el-input>
              </el-form-item>
              <el-form-item
                label="乙方联系方式"
                prop="signingContactMode"
              >
                <el-input
                  v-model="formSigning.signingContactMode"
                  type="text"
                  clearable
                  style="width: 300px;"
                ></el-input>
              </el-form-item>
              <el-form-item
                label="乙方开户行账号"
                prop="signingBankAccount"
              >
                <el-input
                  v-model="formSigning.signingBankAccount"
                  type="text"
                  clearable
                  style="width: 300px;"
                ></el-input>
              </el-form-item>
              <el-form-item
                label="币别"
                prop="currency"
              >
                <el-input
                  v-model="formSigning.currency"
                  type="text"
                  clearable
                  style="width: 300px;"
                ></el-input>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
        <div style="
              height: 50px;
              background-color: rgb(250, 250, 253);
              border-left: 3px rgb(45, 183, 245) solid;
            ">
          <h3 style="padding: 15px; font-weight: 600">合同签署文件</h3>
        </div>
        <el-row style="margin-top: 15px">
          <el-col
            :span="12"
            class="grid-cell"
            style="padding: 0px 0px 0px 95px;"
          >
            <el-form
              :model="formData"
              label-position="left"
              label-width="150px"
              size="medium"
              @submit.native.prevent
            >
              <el-form-item
                label-width="80px"
                label="合同影像上传"
              >
                <div>
                  <!--elementui的form组件-->
                  <el-upload
                    action="#"
                    :show-file-list="false"
                    :auto-upload="false"
                    :multiple="false"
                    :on-change="uploadFile"
                    drag
                    accept="image/jpg,image/jpeg,image/png"
                  >
                    <i
                      v-if="imageUrl"
                      class="el-icon-circle-close deleteImg"
                      @click.stop="handleRemove"
                    ></i>
                    <img
                      v-if="imageUrl"
                      :src="imageUrl"
                      class="el-upload--picture-car"
                    />
                    <div v-else>
                      <i
                        class="el-icon-picture"
                        style="margin-top: 40px; font-size: 40px; color: #999a9c"
                      ></i>
                      <div>上传图片</div>
                      <div>格式为png、jpeg或jpg</div>
                    </div>
                  </el-upload>
                </div>
                <!-- <el-button
                  style="margin-left: 10px;"
                  size="small"
                  type="success"
                  :loading="upload.isUploading"
                  @click="submitUpload"
                >上传到服务器</el-button> -->
              </el-form-item>
              <!-- <el-form-item
                label="合同影像上传"
                prop="fileList"
                class="required"
              >
                <el-upload
                  ref="upload"
                  :limit="1"
                  accept=".doc, .docx"
                  :action="upload.url"
                  :headers="upload.headers"
                  :file-list="upload.fileList"
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
                  >只能上传doc/docx文件，且不超过10MB</div>
                </el-upload> -->
              <!-- <el-upload ref="upload" class="upload-demo" :limit="4" accept=".doc,.docx,.xsl,.xlsx" multiple
              :action="upload.url" :headers="upload.headers" :file-list="upload.fileList" :before-remove="beforeRemove"
              :on-progress="handleFileUploadProgress" :on-success="handleFileSuccess" :auto-upload="false">
              <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
              <el-button style="margin-left: 10px;" size="small" type="success" @click="submitUpload">上传到服务器</el-button>
              <div slot="tip" class="el-upload__tip">最多只能上传4个文件，支持 doc/xls/docx/xlsx 类型文件，且不超过10MB</div>
            </el-upload> -->
              <!-- </el-form-item> -->
              <!-- <el-form-item
                label="合同影像上传"
                prop="fileupload39631"
              >
                <el-upload
                  class="upload-demo"
                  ref="upload"
                  action="https://jsonplaceholder.typicode.com/posts/"
                  :on-preview="handlePreview"
                  :on-remove="handleRemove"
                  :file-list="fileLists"
                  :auto-upload="false"
                >
                  <el-button
                    slot="trigger"
                    size="small"
                    type="primary"
                    icon="el-icon-picture"
                  >选取图片</el-button>
                  <div
                    slot="tip"
                    class="el-upload__tip"
                  >只能上传jpg/png文件，且不超过500kb</div>
                </el-upload>
              </el-form-item> -->
            </el-form>

            <!-- <el-form
              :model="formData"
              ref="vForm"
              label-position="left"
              label-width="150px"
              size="medium"
              @submit.native.prevent
            >
              <el-form-item
                label="合同范本"
                prop="fileupload39631"
              >
                <el-upload
                  :action="fileUrl"
                  :headers="headers"
                  :before-upload="beforeUpload"
                  :on-preview="handlePreview"
                  :on-remove="handleRemove"
                  :on-success="handleSuccess"
                  :before-remove="beforeRemove"
                  multiple
                  :limit="5"
                  :on-exceed="handleExceed"
                  :file-list="fileLists"
                >
                  <el-button
                    size="small"
                    type="primary"
                    icon="el-icon-upload"
                  >上传文件</el-button>
                  <div
                    slot="tip"
                    class="el-upload__tip"
                  >可上传图片、Excel、Word、pdf格式文件</div>
                </el-upload>
              </el-form-item>
            </el-form> -->
          </el-col>
          <!-- <el-col
            :span="12"
            class="grid-cell"
          >
            <el-form
              :model="formData"
              ref="vForm"
              label-position="left"
              label-width="150px"
              size="medium"
              @submit.native.prevent
            >
              <el-form-item
                label="附件上传"
                prop="fileupload39631"
              >
                <el-upload
                  :action="fileUrl"
                  :headers="headers"
                  :before-upload="beforeUpload"
                  :on-preview="handlePreview"
                  :on-remove="handleRemove"
                  :on-success="handleSuccess"
                  :before-remove="beforeRemove"
                  multiple
                  :limit="5"
                  :on-exceed="handleExceed"
                  :file-list="fileLists"
                >
                  <el-button
                    size="small"
                    type="primary"
                    icon="el-icon-upload"
                  >上传文件</el-button>
                  <div
                    slot="tip"
                    class="el-upload__tip"
                  >可上传图片、Excel、Word、pdf格式文件</div>
                </el-upload>
              </el-form-item>
            </el-form>
            <el-form
              :model="formData"
              ref="vForm"
              label-position="left"
              label-width="150px"
              size="medium"
              @submit.native.prevent
            >
              <el-form-item
                label="合同文件"
                prop="fileupload39631"
              >
                <el-upload
                  :action="fileUrl"
                  :headers="headers"
                  :before-upload="beforeUpload"
                  :on-preview="handlePreview"
                  :on-remove="handleRemove"
                  :on-success="handleSuccess"
                  :before-remove="beforeRemove"
                  multiple
                  :limit="5"
                  :on-exceed="handleExceed"
                  :file-list="fileLists"
                >
                  <el-button
                    size="small"
                    type="primary"
                    icon="el-icon-upload"
                  >上传文件</el-button>
                  <div
                    slot="tip"
                    class="el-upload__tip"
                  >可上传图片、Excel、Word、pdf格式文件</div>
                </el-upload>
              </el-form-item>
            </el-form>
          </el-col> -->
        </el-row>
      </div>
    </div>
    <hr />
    <div
      id="qiand"
      style="height: 40px; background-color: rgb(250, 250, 253);border: 1px rgb(207, 205, 205) solid; margin-top: 20px;"
      @click="xianshi_box"
    >
      <i
        class="el-icon-edit-outline"
        style=" margin-left: 23px;"
      ></i> <span style="padding-left: 4px;font-size: 14px;line-height: 39px; ">签字意见</span>
    </div>
    <div
      id="xians"
      style="display: none;background-color: white;"
    >
      <v-form-render
        :form-json="formJson"
        :form-data="formDatas"
        :option-data="optionData"
        ref="vFormRef"
      ></v-form-render>
      <el-button
        type="primary"
        @click="submitForm"
      >提交</el-button>
    </div>
    <div>
      <p style="padding: 0 auto;text-align: center;">
        <el-button
          type="primary"
          @click="submit_fromOverData"
        >提交</el-button>
        <el-button
          type="primary"
          @click="clean_fromOverData"
        >清空</el-button>
      </p>
    </div>
  </div>

</template>

<script>
import {
  listTenderProjects,
  listContractParent,
} from "@/api/bidding/agreement";
import { listVendor } from "@/api/bidding/contractdetails";
import { getVendor } from "@/api/public/vendor";
import { getToken } from "../../../utils/auth";
// import GoodsView from "@/components/Goods";
import {
  SHowsProjectRelatedItems,
  getTender_projects,
  htShowVendorId,
} from "@/api/bidding/tender_projects";
import ImageUploadView from "@/components/ImageUpload"; 
// import { listBuyPlan } from "@/api/shopping/buy_plan";

export default {
  components: {},
  dicts: ["content", "goods_unit"],
  props: {},
  data() {
    return {
      addOrUpdateVisible: false,
      //开始时间
      pickerOptions0: {
        disabledDate: (time) => {
          if (this.formDetails.bidEnd) {
            //如果结束时间不为空，则小于结束时间
            return new Date(this.ActiveRow.EndTime).getTime() < time.getTime();
          } else {
            return time.getTime() < Date.now(); //开始时间不选时，结束时间最大值小于等于当天
          }
        },
      },
      //结束时间
      pickerOptions1: {
        disabledDate: (time) => {
          if (this.formDetails.openTime) {
            //如果开始时间不为空，则结束时间大于开始时间
            return (
              new Date(this.formDetails.openTime).getTime() > time.getTime()
            );
          } else {
            return time.getTime() > Date.now(); //开始时间不选时，结束时间最大值小于等于当天
          }
        },
      },
      //付款日期
      pickerOptions: {
        disabledDate(v) {
          return v.getTime() < new Date().getTime() - 86400000; //  - 86400000是否包括当天
        },
      },
      dkdd: "",
      dialogVisible: false,
      dialogVisible1: false,
      fileUrl: "文件上传的接口",
      headers: { 自定义名称: "请求头" }, // 例如: headers: { Authorization: "adsda" },
      pathFile: "",
      fileUrlLoad: "文件回显的接口",
      fileLists: [],
      //formData: {
      //  enclosureFiles: [],
      //},
      formData: [],
      restaurantts: [],
      restaurants: [],
      restaurants_3: [],
      restaurants_4: [],
      // addOrUpdateVisible:false,
      formAgreement: {
        applicant: "",
        applicantTime: new Date(),
        contractSector: "远志-产品技术部",
        firm: "远志集团",
        contractProjectRelated: 1,
        contractProjectsId: "",
        contractMaster: 1,
        contractPrimeId: "",
        contractTotalBudget: "",
      },
      formDetails: {
        contractdetailsName: "",
        contractdetailsNumber: "",
        contractdetailsType: "",
        openTime: null,
        contractdetailsAmount: "",
        contractdetailsLevel: 0,
        bidEnd: null,
        illustrate: "",
        procurementMethod: "",
        purchaseListId: "",
        vendorContractId: "",
      },
      formSigning: {
        signatoriesNumber: "",
        signingSubject: "远志集团",
        signingVendorId: "",
        signingAddress: "",
        signingContact: "",
        signingContactMode: "",
        signingBank: "",
        signingBankAccount: "",
        sigingAmount: "",
        currency: "人民币",
      },
      option_projets: [
        {
          value: 1,
          label: "项目无关合同",
        },
        {
          value: 2,
          label: "项目相关合同",
        },
      ],
      procurementMethodptions: [
        {
          value: "1",
          label: "招标",
        },
      ],
      option_signatories: [
        {
          value: "1",
          label: "双方签署",
        },
      ],
      
      formJson: {
        widgetList: [
          {
            type: "rich-editor",
            icon: "rich-editor-field",
            formItemFlag: true,
            options: {
              name: "richeditor76634",
              keyNameEnabled: false,
              keyName: "",
              labelAlign: "",
              placeholder: "",
              labelWidth: null,
              labelHidden: false,
              columnWidth: "200px",
              disabled: false,
              hidden: false,
              required: false,
              requiredHint: "",
              customRule: "",
              customRuleHint: "",
              customClass: [],
              labelIconClass: null,
              labelIconPosition: "rear",
              labelTooltip: null,
              minLength: null,
              maxLength: null,
              onCreated: "",
              onMounted: "",
              onValidate: "",
            },
            id: "richeditor76634",
          },
        ],
        formConfig: {
          modelName: "formData",
          refName: "vForm",
          rulesName: "rules",
          labelWidth: 80,
          labelPosition: "left",
          size: "",
          labelAlign: "label-left-align",
          cssCode: "",
          customClass: [],
          functions: "",
          layoutType: "PC",
          jsonVersion: 2,
          dataSources: [],
          onFormCreated: "",
          onFormMounted: "",
          onFormDataChange: "",
          onFormValidate: "",
        },
      },
      formDatas: {},
      optionData: {},
      manifestList: [],
      payMentList: [],
      checkedDetail: [],
      ht: "",
      htState: [
        {
          value: "0",
          label: "长期",
        },
        {
          value: "1",
          label: "短期",
        },
        {
          value: "2",
          label: "补充",
        },
      ],
      // 上传参数
      upload: {
        // 是否禁用上传
        isUploading: false,
        // 设置上传的请求头部
        headers: { Authorization: "Bearer " + getToken() },
        // 上传的地址
        url: "/dev-api/bidding/annex/articleImg",
        // 上传的文件列表
        fileList: [],
      },
      // // 上传图片
      // formData: "",
      imageUrl: "",
      // uploadList: [],
      // dialogImageUrl: "",
      // dialogVisible: false,
      // hideUpload: false,
      // baseUrl: process.env.VUE_APP_BASE_API,
      // uploadImgUrl: process.env.VUE_APP_BASE_API + "/competition/image/multiPicturesUpload", // 上传的图片服务器地址
      // headers: {
      //   Authorization: "Bearer " + getToken(),
      //   awardId: -1,
      // },
      // fileList: [],
    };
  },
  computed: {},
  components: {
    // GoodsView,
    // ImageUploadView,
  },
  created() {
    let value = this.$route.params.ht;
    if (value === "0") {
      this.ht = "长期";
    } else if (value === "1") {
      this.ht = "短期";
    } else if (value === "2") {
      this.ht = "补充";
    }
    this.formDetails.contractdetailsType = this.$route.params.ht;
  },
  filters: {
    formattedAmount(value) {
      return new Intl.NumberFormat("en-US", {
        style: "currency",
        currency: "USD",
      }).format(value);
    },
  },
  mounted() {
    if (this.$route.query.id) {
      this.info(this.$route.query.id);
    }
    this.headers = {
      Authorization: cookieStorage.get("token"),
    };
  },
  watch: {
    manifestList: {
      handler(val) {
        console.log("val:", val);
        let price = 0;
        val.forEach((item) => {
          console.log(item)
          price +=
            isNaN(item.bidTenderManifest.price) && isNaN(item.bidTenderManifest.explains)
              ? 0
              : (item.bidTenderManifest.price * item.bidTenderManifest.explains * 10) / 10;
        });
        this.formDetails.contractdetailsAmount = isNaN(price) ? 0 : price;
        this.formSigning.sigingAmount = isNaN(price) ? 0 :price;
      },
      deep: true,
    },
  },
  methods: {
    submit_fromOverData() {
      alert("提交合同申请");
      let json = JSON.stringify(this.formAgreement);
      let json2 = JSON.stringify(this.formDetails);
      let json3 = JSON.stringify(this.formSigning);
      let json4 = JSON.stringify(this.payMentList);
      let json5 = JSON.stringify(this.formData);
      let fd = new FormData();
      fd.append("json", json);
      fd.append("json2", json2);
      fd.append("json3", json3);
      fd.append("json4", json4);
      fd.append("json5", json5);
      console.log("json4", json4);
      console.log("json5：" + json5);
      console.log("json3：" + json3);
      axios
        .post("/dev-api/bidding/agreement/addAgreements", fd, {
          headers: {
            Authorization: `Bearer ${getToken()}`,
            "Content-Type": "multipart/form-data", // 设置请求头为 multipart/form-data
          },
        })
        .then((response) => {
          if (response.data === 1) {
            this.$modal.msgSuccess("操作成功");
            this.$router.push({ path: "/index", name: "index_contractDetails" });
          }
        })
        .catch((error) => {
          // 处理错误
        });
    },
    //选中的商品
    // getGoods(val, x) {
    //   this.goods = val;
    //   if (x === "false") {
    //     this.addOrUpdateVisible = false;
    //   } else {
    //     this.addOrUpdateVisible = true;
    //   }
    //   if (this.manifestList.length == 1) {
    //     this.manifestList = this.goods;
    //   } else {
    //     this.manifestList = [...this.manifestList, ...this.goods];
    //   }
    //   this.manifestList.forEach((item) => {
    //     item = {
    //       price: 0,
    //       total: 0,
    //       totalPrice: 0,
    //       date: "",
    //     };
    //   });
    // },
    //清空按钮
    clean_fromOverData() {
      this.formAgreement = {
        applicant: "",
        applicantTime: null,
        contractSector: "远志-产品技术部",
        firm: "远志集团",
        contractProjectRelated: "",
        contractProjectsId: "",
        contractMaster: 0,
        contractPrimeId: "",
        contractTotalBudget: "",
      };
      this.formDetails = {
        contractdetailsName: "",
        contractdetailsNumber: "",
        openTime: null,
        contractdetailsAmount: "",
        contractdetailsLevel: 0,
        bidEnd: null,
        illustrate: "",
        procurementMethod: "",
        purchaseListId: "",
      };
      (this.formSigning = {
        signatoriesNumber: "",
        signingSubject: "远志集团",
        signingVendorId: "",
        signingAddress: "",
        signingContact: "",
        signingContactMode: "",
        signingBank: "",
        signingBankAccount: "",
        sigingAmount: "",
        currency: "人民币",
      }),
      this.resetForm("formAgreement");
      this.resetForm("formDetails");
      this.resetForm("formSigning");
      this.$modal.msgSuccess("清空成功！请重新填写^* ~ *^");
    },
    submitForm() {
      this.$refs.vFormRef
        .getFormData()
        .then((formData) => {
          // Form Validation OK
          alert(JSON.stringify(formData));
        })
        .catch((error) => {
          // Form Validation failed
          this.$message.error(error);
        });
    },
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePreview(file) {
      console.log(file);
    },
    // row是行对象，rowindex是行号，从0开始。所以这样就能实现了序号(xh属性)递增并且取值为行号加1。
    rowClassName({ row, rowIndex }) {
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
      if (this.manifestList == undefined) {
        this.manifestList = new Array();
      }
      let obj = {};
      this.manifestList.push({ obj });
    },
    // 删除
    handleDeleteDetails() {
      if (this.checkedDetail.length == 0) {
        this.$alert("请先选择要删除的数据", "提示", {
          confirmButtonText: "确定",
        });
      } else {
        this.manifestList.splice(this.checkedDetail[0].xh - 1, 1);
      }
    },
    //清空
    handleDeleteAllDetails() {
      this.manifestList = undefined;
    },
    // 添加一行
    handleAddDetail() {
      if (this.payMentList == undefined) {
        this.payMentList = new Array();
      }
      // let obj = {};
      this.payMentList.push({
        content: null,
        payTime: null,
        unit: "远志集团股份有限公司",
        paymentVendorId: null,
        terms: null,
        sum: null,
        duty: null,
      });
    },
    // 删除
    handleDeleteDetail() {
      if (this.checkedDetail.length == 0) {
        this.$alert("请先选择要删除的数据", "提示", {
          confirmButtonText: "确定",
        });
      } else {
        this.payMentList.splice(this.checkedDetail[0].xh - 1, 1);
      }
    },
    //清空
    handleDeleteAllDetail() {
      this.payMentList = undefined;
    },
    //相关的项目
    querySearch(queryString, cb) {
      var restaurants = this.restaurants;
      var results = queryString
        ? restaurants.filter(this.createFilter(queryString))
        : restaurants;
      // 调用 callback 返回建议列表的数据
      cb(results);
    },
    createFilter(queryString) {
      return (restaurant) => {
        return (
          restaurant.value.toLowerCase().indexOf(queryString.toLowerCase()) ===
          0
        );
      };
    },
    loadAll() {
      var blogtitle = [];
      var projectsId = this.formAgreement.contractProjectsId;
      listTenderProjects(projectsId).then((response) => {
        for (let item of response.rows) {
          blogtitle.push({
            value: item.tenderProjectsId,
            number: item.tenderProjectsNumber,
            name: item.tenderProjectsName,
          });
        }
        this.restaurants = blogtitle;
        // console.log(blogtitle);
      });
    },

    xuanzhe(){
        if(this.formAgreement.contractProjectRelated===2){
          this.restaurants_4=[]
        }else{
          this.loadAll_4()
        }
    },
    handleSelect(item) {
      let thet =this;
      this.restaurants_4=[]
      const selectedItemId = item.value;
      getTender_projects(selectedItemId).then((response) => {
        this.formAgreement.contractTotalBudget = response.data.tenderProjectsMoney;
      });
      console.log(this.formAgreement.contractTotalBudget);

      htShowVendorId(selectedItemId).then((response) => {

        for (let item of response.rows) {
          thet.restaurants_4.push({
              value: item.vendor_id,
              number: item.vendor_number,
              name: item.abbreviated,
            });
          }

      });
console.log(thet.restaurants_4)

    },
    handleIconClick(ev) {
      // console.log(ev);
    },
    //相关合同
    querySearchs(queryString, cb) {
      var restaurantts = this.restaurantts;
      var results = queryString
        ? restaurantts.filter(this.createFilters(queryString))
        : restaurantts;
      // 调用 callback 返回建议列表的数据
      cb(results);
    },
    createFilters(queryString) {
      return (restaurant) => {
        return (
          restaurant.value.toLowerCase().indexOf(queryString.toLowerCase()) ===
          0
        );
      };
    },
    loadAlls() {
      var blogtitle = [];
      listContractParent(this.formAgreement.contractPrimeId).then(
        (response) => {
          // console.log(response);
          for (let item of response.rows) {
            blogtitle.push({
              value: item.contractId,
              number: item.contractdetailsNumber,
              name: item.contractdetailsName,
            });
          }
          this.restaurantts = blogtitle;
          // console.log(blogtitle);
        }
      );
    },
    handleSelects(item) {
      // console.log(item);
    },
    handleIconClicks(ev) {
      // console.log(ev);
    },
    //相关采购计划
    querySearch_3(queryString, cb) {
      var restaurants_3 = this.restaurants_3;
      var results = queryString
        ? restaurants_3.filter(this.createFilter_3(queryString))
        : restaurants_3;
      // 调用 callback 返回建议列表的数据
      cb(results);
    },
    createFilter_3(queryString) {
      return (restaurants_3) => {
        return (
          restaurants_3.value
            .toLowerCase()
            .indexOf(queryString.toLowerCase()) === 0
        );
      };
    },
    loadAll_3() {
      var blogtitle = [];
      // listBuyPlan(this.formDetails.purchaseListId).then((response) => {
      //   for (let item of response.rows) {
      //     blogtitle.push({
      //       value: item.buyPlanId,
      //       number: item.planClod,
      //       name: item.planName,
      //     });
      //   }
      //   this.restaurants_3 = blogtitle;
      //   console.log(blogtitle);
      // });
    },
    handleSelect_3(item) {
      // console.log(item);
    },
    handleIconClick_3(ev) {
      // console.log(ev);
    },
    //相关供应商
    querySearch_4(queryString, cb) {
      var restaurants_4 = this.restaurants_4;
      var results = queryString
        ? restaurants_4.filter(this.createFilter_4(queryString))
        : restaurants_4;
      // 调用 callback 返回建议列表的数据
      cb(results);
    },
    createFilter_4(queryString) {
      return (restaurants_4) => {
        return (
          restaurants_4.value
            .toLowerCase()
            .indexOf(queryString.toLowerCase()) === 0
        );
      };
    },
    loadAll_4() {
      var blogtitle = [];
      if (this.formAgreement.contractProjectsId === "") {
        listVendor(this.formSigning.signingVendorId).then((response) => {
          for (let item of response.rows) {
            blogtitle.push({
              value: item.vendorId,
              number: item.vendorNumber,
              name: item.abbreviated,
            });
          }
          this.restaurants_4 = blogtitle;
        });
      } else if (this.formAgreement.contractProjectsId !== "") {
        alert("选择项目的");
      }
    },
    handleSelect_4(item) {
      const selectedItemId = item.value;
      this.SHows(this.formAgreement.contractProjectsId, selectedItemId);

      getVendor(selectedItemId).then((response) => {
        console.log(response.data);
        this.formSigning.signingAddress = response.data.warehouseAddress;
        this.formSigning.signingContact = response.data.responsible;
        this.formSigning.signingContactMode = response.data.responsiblePhone;
        this.formSigning.signingBank = response.data.bankingName;
        this.formSigning.signingBankAccount =
          response.data.industrialCommercial;
      });
      this.formDetails.vendorContractId = item.value;
    },
    handleIconClick_4(ev) {
      console.log("显示:" + ev);
    },
    //显示物料信息
    SHows(tenderProjectsId, noticeSupplierId) {
      SHowsProjectRelatedItems(tenderProjectsId, noticeSupplierId).then(
        (response) => {
          console.log("显示有关物料信息：" + response.rows);
          this.manifestList = response.rows;
        }
      );
    },
    xianshi_box() {
      var div = document.getElementById("xians");
      if (div.style.display === "none") {
        div.style.display = "block";
      } else {
        div.style.display = "none";
      }
    },
    // 上传图片
    uploadFile(item) {
      this.upload.isUploading = true;
      this.imageUrl = URL.createObjectURL(item.raw);// 图片上传浏览器回显地址
      // this.imageUrl = this.imageUrl.replace('blob:', '');
      console.log(this.imageUrl, "imageUrl");
      console.log(this.formData, "formData");
      // let formData = new FormData();
      // 将图片信息加入到formData中
      this.formData.push({
        annexTitle: item.name,
        annexUrl: this.imageUrl,
        //采购计划id= sid
        // supplyId: sid,
        annexTypeId: 2,
      });
      console.log(this.formData);
      this.upload.isUploading = false;
      // formData.append("file", item.raw, item.name);
      // this.formData=formData;
    },
    handleRemove() {
      this.imageUrl = "";
    },
    //文件提交处理
    // submitUpload() {
    //   this.$refs.upload.submit();
    // },
    // // 文件上传中处理
    // handleFileUploadProgress(event, file, fileList) {
    //   this.upload.isUploading = true;
    // },
    // // 文件上传成功处理
    // handleFileSuccess(response, file, fileList) {
    //   let thet = this;

    // },
    // beforeRemove(file, fileList) {
    //   return this.$confirm(`确定移除 ${ file.name }？`);
    // },
    /* 文件上传 */
    // beforeUpload(file) {},
    // handlePreview(file) {
    //   console.log(file);
    //   this.dialogVisible1 = true;
    //   if (file.url) {
    //     this.pathFile = this.fileUrlLoad + file.url;
    //   }
    //   if (file.path) {
    //     this.pathFile = this.fileUrlLoad + file.path;
    //   } else {
    //     this.pathFile = this.fileUrlLoad + file.response.data.path;
    //   }
    // }, // 关键是这一步，把回显的地址给pathFile不同的后端返回的也不同，需自行修改
    // handleRemove(file, fileList) {
    //   const that = this;
    //   this.formData.enclosureFiles.forEach((item, index) => {
    //     if (file.response) {
    //       if (item.id === file.response.data.id) {
    //         this.formData.enclosureFiles.splice(index, 1);
    //       }
    //     } else {
    //       if (item.id === file.id) {
    //         this.formData.enclosureFiles.splice(index, 1);
    //       }
    //     }
    //   });
    // },
    // handleSuccess(response, file, fileList) {
    //   // console.log(response);
    //   this.formData.enclosureFiles.push({
    //     uid: file.uid,
    //     id: response.data.id,
    //   });
    // },
    // beforeRemove(file, fileList) {
    //   return this.$confirm(`确定移除 ${file.name}？`);
    // },
    // handleExceed(files, fileList) {
    //   this.$message.warning(
    //     `当前限制选择 5 个文件，本次选择了 ${files.length} 个文件，共选择了 ${
    //       files.length + fileList.length
    //     } 个文件`
    //   );
    // },
    // 文件提交处理
    //submitUpload() {
    //   this.$refs.upload.submit();
    // },
    // // 文件上传中处理
    // handleFileUploadProgress(event, file, fileList) {
    //   this.upload.isUploading = true;
    // },
    // // 文件上传成功处理
    // handleFileSuccess(response, file, fileList) {
    //   this.upload.isUploading = false;
    //   this.form.filePath = response.url;
    //   this.msgSuccess(response.msg);
    // },
  },
  mounted() {
    this.restaurants = this.loadAll();
    this.restaurantts = this.loadAlls();
    this.restaurants_3 = this.loadAll_3();
    this.restaurants_4 = this.loadAll_4();
  },
};
</script>
<style scoped lang="scss">
.app-container {
  background-color: rgb(237, 240, 245);

  .top {
    width: 100%;
    height: 100px;
    background-color: white;

    h1 {
      float: left;
      margin: 37px;
      margin-left: 550px;
    }
  }
  .section_bos {
    margin-top: 17px;
    width: 100%;
    height: 100%;
    background-color: white;
  }

  .my-autocomplete {
    width: auto;
    li {
      line-height: normal;
      padding: 7px;

      .name {
        text-overflow: ellipsis;
        overflow: hidden;
      }
      .addr {
        font-size: 12px;
        color: #b4b4b4;
      }

      .highlighted .addr {
        color: #ddd;
      }
    }
  }
}
</style>