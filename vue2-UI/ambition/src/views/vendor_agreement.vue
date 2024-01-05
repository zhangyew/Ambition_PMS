<template>
  <div class="app-container">
    <div style="background-color: white;width: 303px;height: 77px; box-shadow: 10px 10px 6px 1px rgba(79, 78, 78, 0.12);float: left;margin: 4px 20px 20px 32px;">
      <h3 style="line-height: 0px;padding: 8px 0px 0px 29px;font-weight: 300;">合同总数</h3>
      <span style="padding: 0px 0px 0px 29px;font-size: 20px;color: rgb(102, 102, 102);">{{ ContractCount }}</span>
    </div>
    <div style="background-color: white;width: 303px;height: 77px; box-shadow: 10px 10px 6px 1px rgba(79, 78, 78, 0.12);float: left;margin: 4px 20px 20px 32px;">
      <h3 style="line-height: 0px;padding: 8px 0px 0px 29px;font-weight: 300;">合同金额</h3>
      <span style="padding: 0px 0px 0px 29px;font-size: 20px;color: rgb(102, 102, 102);">{{ ContractSum }}</span>
    </div>
    <el-table
      v-loading="loading"
      :data="contractdetailsList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column
        type="selection"
        width="55"
        align="center"
      />
      <el-table-column
        label="合同名称"
        align="center"
        prop="contractdetailsName"
      >
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            v-hasPermi="['bidding/contractdetails:list']"
            @click="handleShow(scope.row.contractdetailsId,scope.row.contractdetailsPaymentId,scope.row.tenderProjectsId,scope.row.vendorId)"
          >
            {{ scope.row.contractdetailsName }}
          </el-button>
        </template>
      </el-table-column>
      <el-table-column
        label="合同编号"
        align="center"
        prop="contractdetailsNumber"
        width="200"
      />
      <el-table-column
        prop="firm"
        label="公司"
        align="center"
        width="180"
      >
        <template>
          <span>远志集团股份有限公司</span>
        </template>
      </el-table-column>
      <el-table-column
        label="供应商"
        align="center"
        prop="abbreviated"
      />
      <el-table-column
        label="签订日期"
        align="center"
        prop="openTime"
      >
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.openTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="合同总价"
        align="center"
        prop="contractdetailsAmount"
      />
      <el-table-column
        label="合同类型"
        align="center"
        prop="contractdetailsType"
      >
        <template slot-scope="scope">
          {{scope.row.contractdetailsType | stateHT}}
        </template>
      </el-table-column>
      <el-table-column
        label="状态"
        align="center"
        prop="contractdetailsState"
      >
        <template slot-scope="scope">
          <span :class="getContractStateColor(scope.row.contractdetailsState)">{{ scope.row.contractdetailsState | con_state}}</span>
        </template>
      </el-table-column>
    </el-table>
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 合同详情对话框 -->
    <el-dialog
      :title="title"
      :visible.sync="open"
      width="90%"
      append-to-body
      style="height: auto;"
    >
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
          </div>
          <div style="float: left;display: block;">
            <h1> {{formDatas.contractdetailsType}}合同申请表</h1>
          </div>
        </div>
        <div class="section_bos">
          <div style="height: 50px; background-color: rgb(250, 250, 253);border-left: 3px rgb(45, 183, 245) solid;">
            <h3 style="padding: 15px; font-weight: 600">合同申请信息</h3>
          </div>
          <el-form
            :model="formDatas"
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
                    v-model="formDatas.applicant"
                    type="text"
                    clearable
                    style="width: 300px;"
                    :readonly="true"
                  ></el-input>
                </el-form-item>
                <el-form-item
                  label="申请部门"
                  prop="contractSector"
                  class="required"
                >
                  <el-input
                    v-model="formDatas.contractSector"
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
                    v-model="formDatas.contractProjectRelated"
                    class="full-width-input"
                    clearable
                    style="width: 300px;"
                    disabled="disabled"
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
                  <el-radio-group
                    v-model="formDatas.contractMaster"
                    :disabled="true"
                  >
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
                    v-model="formDatas.contractTotalBudget"
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
                    v-model="formDatas.applicantTime"
                    type="date"
                    class="full-width-input"
                    format="yyyy-MM-dd"
                    value-format="yyyy-MM-dd"
                    clearable
                    style="width: 300px;"
                    :readonly="true"
                  ></el-date-picker>
                </el-form-item>
                <el-form-item
                  label="申请公司"
                  prop="firm"
                  class="required"
                >
                  <el-input
                    v-model="formDatas.firm"
                    type="text"
                    clearable
                    style="width: 300px;"
                    :readonly="true"
                  ></el-input>
                </el-form-item>
                <el-form-item
                  label="相关项目"
                  prop="tenderProjectsName"
                >
                  <el-input
                    v-model="formDatas.tenderProjectsName"
                    type="text"
                    clearable
                    style="width: 300px;"
                    :readonly="true"
                    :disabled="formDatas.contractProjectRelated === 1"
                  ></el-input>
                </el-form-item>
                <el-form-item
                  label="关联主合同"
                  prop="contractPrimeId"
                >
                  <el-input
                    v-model="formDatas.contractPrimeId"
                    type="text"
                    clearable
                    style="width: 300px;"
                    :readonly="true"
                    :disabled="formDatas.contractMaster === 1"
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <div style="
              height: 50px;
              background-color: rgb(250, 250, 253);
              border-left: 3px rgb(45, 183, 245) solid;
            ">
              <h3 style="padding: 15px; font-weight: 600">合同基本信息</h3>
            </div>
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
                    v-model="formDatas.contractdetailsName"
                    type="text"
                    clearable
                    :readonly="true"
                    style="width: 300px;"
                  ></el-input>
                </el-form-item>
                <el-form-item
                  label="合同类型"
                  prop="contractdetailsType"
                >
                  <el-input
                    id="cd_type"
                    v-model="formDatas.contractdetailsType"
                    type="text"
                    clearable
                    :readonly="true"
                    style="width: 300px;"
                  ></el-input>
                </el-form-item>
                <el-form-item
                  label="开启时间"
                  prop="openTime"
                >
                  <el-date-picker
                    :editable="false"
                    v-model="formDatas.openTime"
                    type="date"
                    class="full-width-input"
                    format="yyyy-MM-dd"
                    value-format="yyyy-MM-dd"
                    clearable
                    style="width: 300px;"
                    :readonly="true"
                  ></el-date-picker>
                </el-form-item>
                <el-form-item
                  label="合同金额"
                  prop="contractdetailsAmount"
                >
                  <el-input
                    v-model="formDatas.contractdetailsAmount"
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
                    v-model="formDatas.contractdetailsNumber"
                    :readonly="true"
                    type="text"
                    clearable
                    style="width: 300px;"
                  ></el-input>
                </el-form-item>
                <el-form-item
                  label="密级"
                  prop="contractdetailsLevel"
                >
                  <el-radio-group
                    v-model="formDatas.contractdetailsLevel"
                    :disabled="true"
                  >
                    <el-radio :label="0">密级</el-radio>
                    <el-radio :label="1">非密</el-radio>
                  </el-radio-group>
                </el-form-item>
                <el-form-item
                  label="结束时间"
                  prop="bidEnd"
                >
                  <el-date-picker
                    :editable="false"
                    v-model="formDatas.bidEnd"
                    type="date"
                    class="full-width-input"
                    format="yyyy-MM-dd"
                    value-format="yyyy-MM-dd"
                    clearable
                    style="width: 300px;"
                    :readonly="true"
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
                    v-model="formDatas.illustrate"
                    style="width: 1000px;"
                    :readonly="true"
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
                    v-model="formDatas.procurementMethod"
                    clearable
                    style="width: 300px;"
                    disabled="disabled"
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
            </el-row>
            <div style="
              height: 50px;
              background-color: rgb(250, 250, 253);
              border-left: 3px rgb(45, 183, 245) solid;
            ">
              <h3 style="padding: 15px; font-weight: 600">合同物料信息</h3>
            </div>
            <el-row style="margin:20px 10px">
              <el-table
                :data="DemandList"
                :row-class-name="rowClassName"
                ref="tb"
              >
                <el-table-column
                  type="selection"
                  width="100"
                  align="center"
                />
                <el-table-column
                  label="序号"
                  align="center"
                  prop="xh"
                  width="100"
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
            <el-row style="margin: 20px 10px">
              <el-table
                :data="payMentList"
                :row-class-name="rowClassName"
                ref="tb"
              >
                <el-table-column
                  type="selection"
                  width="100"
                  align="center"
                />
                <el-table-column
                  label="序号"
                  align="center"
                  prop="xh"
                  width="100"
                ></el-table-column>
                <el-table-column
                  label="款项内容"
                  align="center"
                  width="200"
                  prop="sjfw"
                >
                  <template slot-scope="scope">
                    <el-select
                      v-model="scope.row.content"
                      placeholder="请选择款项内容"
                      :disabled="true"
                    >
                      <el-option
                        :disabled="true"
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
                ></el-table-column>
                <el-table-column
                  label="付款单位"
                  align="center"
                  prop="unit"
                  width="160"
                >
                </el-table-column>
                <el-table-column
                  label="收款合同方"
                  align="center"
                  prop="paymentVendorId"
                  width="160"
                >
                  <template slot-scope="scope">
                    <el-input
                      v-model="scope.row.publicVendor.abbreviated"
                      :readonly="true"
                    ></el-input>
                  </template>
                </el-table-column>
                <el-table-column
                  label="付款条件"
                  align="center"
                  prop="terms"
                  width="170"
                >
                </el-table-column>
                <el-table-column
                  label="付款金额"
                  align="center"
                  prop="sum"
                  width="160"
                >
                </el-table-column>
                <el-table-column
                  label="违约责任"
                  align="center"
                  prop="duty"
                  width="170"
                >
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
                    v-model="formDatas.signatoriesNumber"
                    class="full-width-input"
                    clearable
                    style="width: 300px;"
                    disabled="disabled"
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
                  prop="abbreviated"
                  class="required"
                >
                  <el-input
                    v-model="formDatas.abbreviated"
                    type="text"
                    clearable
                    style="width: 300px;"
                    :readonly="true"
                  ></el-input>
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
                    v-model="formDatas.signingContact"
                    type="text"
                    clearable
                    style="width: 300px;"
                    :readonly="true"
                  ></el-input>
                </el-form-item>
                <el-form-item
                  label="乙方开户行"
                  prop="signingBank"
                  class="required"
                >
                  <el-input
                    v-model="formDatas.signingBank"
                    type="text"
                    clearable
                    style="width: 300px;"
                    :readonly="true"
                  ></el-input>
                </el-form-item>
                <el-form-item
                  label="合同方金额"
                  prop="sigingAmount"
                  class="required"
                >
                  <el-input
                    v-model="formDatas.sigingAmount"
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
                    v-model="formDatas.signingSubject"
                    type="text"
                    clearable
                    style="width: 300px;"
                    :readonly="true"
                  ></el-input>
                </el-form-item>
                <el-form-item
                  label="乙方供应商公司地址"
                  prop="signingAddress"
                >
                  <el-input
                    v-model="formDatas.signingAddress"
                    type="text"
                    clearable
                    style="width: 300px;"
                    :readonly="true"
                  ></el-input>
                </el-form-item>
                <el-form-item
                  label="乙方联系方式"
                  prop="signingContactMode"
                >
                  <el-input
                    v-model="formDatas.signingContactMode"
                    type="text"
                    clearable
                    style="width: 300px;"
                    :readonly="true"
                  ></el-input>
                </el-form-item>
                <el-form-item
                  label="乙方开户行账号"
                  prop="signingBankAccount"
                >
                  <el-input
                    v-model="formDatas.signingBankAccount"
                    type="text"
                    clearable
                    style="width: 300px;"
                    :readonly="true"
                  ></el-input>
                </el-form-item>
                <el-form-item
                  label="币别"
                  prop="currency"
                >
                  <el-input
                    v-model="formDatas.currency"
                    type="text"
                    clearable
                    style="width: 300px;"
                    :readonly="true"
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>

          </el-form>

        </div>
      </div>
      <div
        slot="footer"
        class="dialog-footer"
      >
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {
  selectVendorList,
  ContractSumLists,
  ContractCountLists,
  getContractdetails,
} from "@/api/bidding/contractdetails";
import { getPayment } from "@/api/public/payment";
import { SHowsProjectRelatedItems } from "@/api/bidding/tender_projects";

export default {
  name: "vendorAgreement",
  dicts: ["contractdetails_state", "content", "goods_unit"],
  data() {
    return {
      restaurants: [],
      state: "",
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 合同明细表格数据
      contractdetailsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      ContractSum: "",
      ContractCount: "",
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        contractdetailsNumber: null,
        contractdetailsName: null,
        abbreviated: null,
        contractdetailsState: null,
      },
      // vendorId:2,
      // 表单参数
      formDatas: {},
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
      options_master: [
        {
          label: "否",
          value: 1,
        },
        {
          label: "是",
          value: 2,
        },
      ],
      procurementMethodptions: [
        {
          value: 1,
          label: "招标",
        },
        {
          value: 2,
          label: "采购计划",
        },
      ],
      option_signatories: [
        {
          value: 1,
          label: "双方签署",
        },
        {
          value: 2,
          label: "三方签署",
        },
      ],
      //合同付款约定
      payMentList: [],
      //合同物料
      DemandList: [],
    };
  },
  created() {
    this.getList();
    this.getContractSum();
    this.getContractCount();
  },
  filters: {
    con_state(value) {
      if (value === 0) {
        return "解除";
      } else if (value === 1) {
        return "终止";
      } else if (value === 2) {
        return "暂定";
      } else if (value === 3) {
        return "未激活";
      } else if (value === 4) {
        return "履行中";
      } else if (value === 5) {
        return "已完成";
      } else if (value === 6) {
        return "已生成订单";
      }
    },
    stateHT(value) {
      if (value === 0) {
        return "长期";
      } else if (value === 1) {
        return "短期";
      } else if (value === 2) {
        return "补充";
      }
    },
  },
  methods: {
    /** 查询合同明细列表 */
    getList() {
      this.loading = true;
      let veid = 2;
      selectVendorList(veid).then((response) => {
        this.contractdetailsList = response.rows;
        this.total = response.total;
        this.loading = false;
        console.log(response);
      });
    },
    // /** 搜索按钮操作 */
    // handleQuery() {
    //   this.queryParams.pageNum = 1;
    //   this.getList();
    // },
    // /** 重置按钮操作 */
    // resetQuery() {
    //   this.resetForm("queryForm");
    //   this.handleQuery();
    // },
    // // 多选框选中数据
    // handleSelectionChange(selection) {
    //   this.ids = selection.map((item) => item.contractdetailsId);
    //   this.single = selection.length !== 1;
    //   this.multiple = !selection.length;
    // },
    //合同总金额
    getContractSum() {
      ContractSumLists(vendorId).then((response) => {
        this.ContractSum = response;
        if (this.ContractSum === "") {
          this.ContractSum = "暂无";
        }
      });
    },
    //合同总数量
    getContractCount() {
      ContractCountLists(vendorId).then((response) => {
        this.ContractCount = response;
      });
    },
    //详情
    handleShow(id, paymentId, tenderProjectsId, vendorId) {
      console.log("查看采购合同的ID：" + id + "\t" + paymentId);
      this.open = true;
      this.title = "采购合同详情";
      getContractdetails(id).then((response) => {
        // console.log(response.data);
        this.formDatas = response.data[0];
        let stateContract = this.formDatas.contractdetailsType;
        if (stateContract === 0) {
          this.formDatas.contractdetailsType = "长期";
        } else if (stateContract === 1) {
          this.formDatas.contractdetailsType = "短期";
        } else if (stateContract === 2) {
          this.formDatas.contractdetailsType = "补充";
        }
      });
      //显示合同付款约定
      let paymentIdArray = paymentId.split(",");
      paymentIdArray.forEach((element) => {
        getPayment(element).then((response) => {
          this.payMentList.push(response.data);
        });
      });
      //显示合同物料信息
      SHowsProjectRelatedItems(tenderProjectsId, vendorId).then((response) => {
        this.DemandList = response.rows;
      });
    },
    //详情取消按钮
    cancel() {
      this.open = false;
      console.log("open显示：" + this.open);
    },
    //合同状态框颜色变化
    getContractStateColor(state) {
      if (state === 4) {
        return "blue-span";
      } else if (state === 2) {
        return "orange-span";
      } else if (state === 0) {
        return "red-span";
      } else if (state === 5) {
        return "wc-span";
      }
    },
    //显示所有供应商
    // querySearch(queryString, cb) {
    //   var restaurants = this.restaurants;
    //   var results = queryString
    //     ? restaurants.filter(this.createFilter(queryString))
    //     : restaurants;
    //   // 调用 callback 返回建议列表的数据
    //   cb(results);
    // },
    // createFilter(queryString) {
    //   return (restaurant) => {
    //     return (
    //       restaurant.value.toLowerCase().indexOf(queryString.toLowerCase()) ===
    //       0
    //     );
    //   };
    // },
    // loadAll() {
    //   var blogtitle = [];
    //   listVendor(this.queryParams.abbreviated).then((response) => {
    //     for (let item of response.rows) {
    //       blogtitle.push({
    //         value: item.abbreviated,
    //         number: item.vendorNumber,
    //       });
    //     }
    //     this.restaurants = blogtitle;
    //   });
    // },
    // handleSelect(item) {
    //   console.log(item);
    // },
    // handleIconClick(ev) {
    //   console.log(ev);
    // },
    rowClassName({ row, rowIndex }) {
      row.xh = rowIndex + 1;
    },
  },
  // mounted() {
  //   this.restaurants = this.loadAll();
  // },
};
</script>
<style lang="scss" scoped>
@page {
  size: auto;
  margin: 0mm;
}
.procedure {
  word-wrap: break-word;
}
@media print {
  //样式写在这里面
  html,
  body {
    height: inherit;
    .qd {
      padding: 0px 0px 0px 0px;
    }
  }
}
.title {
  word-wrap: break-word; //内容不自动换行问题
}
.blue-span {
  color: #09f;
  background: #d8edfc;
  border-color: #91cef7;
  padding: 6px 6px 6px 6px;
}

.orange-span {
  color: #ff9000;
  background: #fdedd7;
  border-color: #facb8d;
  padding: 6px 6px 6px 6px;
}

.red-span {
  color: #ea4335;
  background: #f8d1cd;
  border-color: #f5978e;
  padding: 6px 6px 6px 6px;
}

.wc-span {
  color: #f50;
  background: #ffefe8;
  border-color: #fabd9f;
  padding: 6px 6px 6px 6px;
}

.my-autocomplete {
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
</style>
