<template>
  <div class="app-container home">
    <el-row :gutter="20" style="margin:20px -10px">
      <el-col :xs="24" :sm="24" :md="14" :lg="14" style="margin-left: 10px;background-color: white;height: 350px;">
        <h3 class="kb">招投标中心</h3>
        <div>
          <el-table :data="tableData" stripe style="width: 100%;text-align: center;" v-loading="loading">
            <el-table-column prop="tenderProjectsNumber" label="招标单号" width="200">
            </el-table-column>
            <el-table-column prop="client" label="客户" width="180">
              <template>
                <span>远志集团股份有限公司</span>
              </template>
            </el-table-column>
            <el-table-column prop="bidStart" label="投标开始时间">
              <template slot-scope="scope">
                {{scope.row.bidStart}}
              </template>
            </el-table-column>
            <el-table-column prop="bidEnd" label="投标截止时间">
              <template slot-scope="scope">
                {{scope.row.bidEnd}}
              </template>
            </el-table-column>
            <el-table-column prop="state" label="状态">
              <template slot-scope="scope">
                <span
                  :class="gettenderProjectsStateColor(scope.row.auditState)">{{scope.row.auditState | ShowState }}</span>
              </template>
            </el-table-column>
          </el-table>
        </div>
      </el-col>

      <el-col
        :xs="24"
        :sm="24"
        :md="9"
        :lg="9"
        style="margin-left: 10px;background-color: white;"
      >
        <div
          data-ebaseid="FormModeCustomSearch"
          data-needrefresh="true"
          data-cornertop="Right"
          data-cornertopradian="8px"
          data-cornerbottom="Right"
          data-cornerbottomradian="5px"
          style="position: relative;height: 340px;"
        >
          <div style="height: 340px;background-color: white;">
            <p style="background-color: white;">
              <i class="el-icon-discount"></i> <span style="font-size: 14px; color: #333;">我的资料</span>
            </p>
            <div style="margin-top: 20px;">
              <div style="width: 80px; height: 60px; margin: 0px 0px 0px 40px ;float: left">
                <img src="@/assets/images/weisenLogo_01.png" alt="donate" width="60" />
              </div>
              <div style="float: right;width: 390px;">
                <div>

                  <h2
                    style="font-size: 16px; font-weight: 600;display: inline-block;vertical-align: middle;padding-right: 70px;height: 3px;">
                    腾讯科技（深圳）有限公司</h2>
                  <!-- <template slot-scope="scope"> -->
                  <el-button size="mini" type="text" @click="xq"
                    style="border: #333 1px solid;background-color: white;width:55px ;height:30px; color: #333;font-size: 15px;">
                    <router-link class="link-type" target="_blank" > 详情</router-link>
                  </el-button>
                  <!-- </template> -->
                  <!-- <button style="border: #333 1px solid;background-color: white;width:55px ;height:30px;display: inline-block;vertical-align: middle;">详情</button> -->

                </div>
                <p style="color: rgb(160,174,192);">联系人：<label>李晨</label> &nbsp;&nbsp; 联系电话：<label>15026579654</label>
                </p>
              </div>
              <hr width="90%" />
              <div>
                <div style="width: 150px;height: 72px;float: left;text-align: center;">
                  <p>2019-04-15</p>
                  <h4>准入日期</h4>
                </div>
                <div style="width: 150px;height: 72px;float: left;text-align: center;">
                  <p>12</p>
                  <h4>订单数量</h4>
                </div>
                <div style="width: 150px;height: 72px;float: left;text-align: center;">
                  <p>0</p>
                  <h4>整改通知</h4>
                </div>
              </div>
              <div>
                <div style="width: 150px;height: 72px;float: left;text-align: center;">
                  <p style="font-weight: bold;">认证通过</p>
                  <h4>认证状态</h4>
                </div>
                <div style="width: 150px;height: 72px;float: left;text-align: center;">
                  <p>30</p>
                  <h4>电子签文件</h4>
                </div>
                <div style="width: 150px;height: 72px;float: left;text-align: center;">
                  <p>10</p>
                  <h4>合同数量</h4>
                </div>
              </div>
            </div>
          </div>
        </div>
      </el-col>
    </el-row>
    <el-row :gutter="20" style="margin:20px -10px">
      <el-col :xs="24" :sm="24" :md="14" :lg="14"
        style="margin-left: 10px;margin-top: 20px;background-color: white;height: 350px;">
        <h3 class="kb">我的采购执行</h3>
        <el-tabs v-model="activeName" @tab-click="handleClick">
          <el-tab-pane label="我的订单" name="first">
            <el-table :data="orders_Data" stripe style="width: 100%">
              <el-table-column prop="orderNumber" label="订单编号" width="200">
              </el-table-column>
              <el-table-column prop="firm" label="公司" width="180">
                <template>
                  <span>远志集团股份有限公司</span>

                </template> </el-table-column>
              <el-table-column prop="orderPurchaser" label="采购员" width="120">
              </el-table-column>
              <el-table-column prop="totalMoney" label="总金额" width="120">
              </el-table-column>
              <el-table-column prop="createTime" label="发布时间" width="150">
                <template slot-scope="scope">
                  {{ parseTime(scope.row.createTime, '{y}-{m}-{d}') }}
                </template>
              </el-table-column>
              <el-table-column prop="typeOrderState" label="状态" width="130">
                <template slot-scope="scope">
                  <dict-tag :options="dict.type.type_order_state" :value="scope.row.typeOrderState" />


                </template>
              </el-table-column>
            </el-table>
          </el-tab-pane>
          <el-tab-pane label="我的合同" name="second">
            <el-table :data="contract_Date" stripe style="width: 100%">
              <el-table-column prop="contractdetailsNumber" label="合同编号" width="180">
              </el-table-column>
              <el-table-column prop="contractdetailsName" label="合同名称" width="180">
              </el-table-column>
              <el-table-column prop="contrac_firm" label="公司" width="180">
                <template>
                  <span>远志集团股份有限公司</span>
                </template>
              </el-table-column>
              <el-table-column prop="contractdetailsAmount" label="总价">
              </el-table-column>
              <el-table-column prop="openTime" label="签订时间">
              </el-table-column>
              <el-table-column prop="contractdetailsState" label="状态">
                <template slot-scope="scope">
                  <span
                    :class="getContractStateColor(scope.row.contractdetailsState)">{{scope.row.contractdetailsState | ContractState }}</span>
                </template>
              </el-table-column>
            </el-table>

          </el-tab-pane>
        </el-tabs>
      </el-col>
      <el-col :xs="24" :sm="24" :md="9" :lg="9" style="margin-left: 10px;margin-top: 20px;background-color: white;">
        <div data-ebaseid="FormModeCustomSearch" data-needrefresh="true" data-cornertop="Right"
          data-cornertopradian="8px" data-cornerbottom="Right" data-cornerbottomradian="5px"
          style="position: relative;width: 100%">
          <div style="height: 340px;background-color: white;">
            <p style="background-color: white;">
              <i class="el-icon-discount"></i> <span style="font-size: 14px; color: #333;">（招标）通知公告</span>
            </p>
            <div style="margin-top: 20px;">
              <div style="margin: 27px 15px 6px 15px;">

                <el-table :data="notice_Date" stripe style="width: 100%;">
                  <el-table-column prop="tenderTitle" label="标题" width="320">
                  </el-table-column>
                  <el-table-column prop="bidStart" label="创建日期" width="220">
                  </el-table-column>
                </el-table>
              </div>
            </div>
          </div>
        </div>
      </el-col>
    </el-row>
  </div>
</template>


<script>
  import {
    ShowsList,
    ShowsTenderNoticeList,
    displayTenderNoticeList,
  } from "@/api/bidding/tender_notice";
  import {
    showSupplierId
  } from "@/api/shopping/orders";
  import {
    listVendorContract
  } from "@/api/bidding/contractdetails";

  export default {
    name: "Vendor_Index",
    dicts: ['vendor_order_state'],
    data() {
      return {
        activeName: "first",
        // 版本号
        version: "3.6.3",
        // 遮罩层
        loading: true,
        // client:"",
        tableData: [],
        contract_Date: [],
        orders_Data: [],
        notice_Date: [],
      };
    },
    created() {
      this.getTableData();
      this.getNoticeData();
      this.getOrdersData();
      this.getContractData();
    },
    filters: {
      xq() {
        this.$router.push({
          path: '/vendor-system/vendor/info',
          query: {
            vid: 7
          }
        })
      },
      ShowState(value) {
        if (value === 1) {
          return "待定标";
        } else if (value === 2) {
          return "已中标";
        } else if (value === 3) {
          return "未中标";
        }
      },
      ContractState(value) {
        if (value === 1 || value === 2 || value === 3 || value === 4 || value === 6) {
          return "待确认";
        } else if (value === 5) {
          return "已完成";
        }
      }
    },
    methods: {
      goTarget(href) {
        window.open(href, "_blank");
      },
      //显示招投标中心
      getTableData() {
        this.loading = true;
        ShowsTenderNoticeList().then((response) => {
          this.tableData = response.rows;
          this.loading = false;
          console.log(response);
        })
      },
      //显示（招标）通知公告
      getNoticeData() {
        this.loading = true;
        displayTenderNoticeList().then((response) => {
          this.notice_Date = response.rows;
          this.loading = false;
        })
      },
      //显示我的订单
      getOrdersData() {
        this.loading = true;
        let oSupplierId = 2;
        showSupplierId(oSupplierId).then((response) => {
          console.log("显示我的订单：" + oSupplierId);
          this.orders_Data = response.rows;
          this.loading = false;
        });
      },
      //显示我的合同
      getContractData() {
        this.loading = true;
        let vendorId = 2;
        listVendorContract(vendorId).then((response) => {
          console.log("显示我的合同：" + vendorId);
          this.contract_Date = response.rows;
          this.loading = false;
        });
      },
      //招投标状态框颜色变化
      gettenderProjectsStateColor(state) {
        // console.log("sdvcx:" + state);
        if (state === 1) {
          return "pink-span";
        } else if (state === 2) {
          return "blue-span";
        } else if (state === 3) {
          return "red-span";
        }
      },
      //我的合同标状态框颜色变化
      getContractStateColor(state) {
        if (state === 1 || state === 2 || state === 3 || state === 4 || state === 6) {
          return "orange-span";
        } else if (state === 5) {
          return "blue-span";
        }
      },
      handleClick(tab, event) {
        console.log(tab, event);
      },
    },

  };
</script>

<style scoped lang="scss">
  .home {
    background-color: rgb(237, 240, 245);
    height: 858px;

    blockquote {
      padding: 10px 20px;
      margin: 0 0 20px;
      font-size: 17.5px;
      border-left: 5px solid #eee;
    }

    hr {
      margin-top: 20px;
      margin-bottom: 20px;
      border: 0;
      border-top: 1px solid #eee;
    }

    .col-item {
      margin-bottom: 20px;
    }

    ul {
      padding: 0;
      margin: 0;
    }

    font-family: "open sans",
    "Helvetica Neue",
    Helvetica,
    Arial,
    sans-serif;
    font-size: 13px;
    color: #676a6c;
    overflow-x: hidden;

    ul {
      list-style-type: none;
    }

    h4 {
      margin-top: 0px;
    }

    h2 {
      margin-top: 10px;
      font-size: 26px;
      font-weight: 100;
    }

    p {
      margin-top: 10px;

      b {
        font-weight: 700;
      }
    }

    .update-log {
      ol {
        display: block;
        list-style-type: decimal;
        margin-block-start: 1em;
        margin-block-end: 1em;
        margin-inline-start: 0;
        margin-inline-end: 0;
        padding-inline-start: 40px;
      }
    }

    .pink-span {
      color: #f3c;
      background: #fadff3;
      border-color: #fa90df;
      padding: 5px 5px 5px 5px;
      font-size: 12px;
      border-radius: 4px;
    }

    .blue-span {
      color: #036;
      background: #cee1f7;
      border-color: #afd1f3;
      padding: 5px 5px 5px 5px;
      font-size: 12px;
      border-radius: 4px;
    }

    .red-span {
      color: #ea4335;
      background: #f8d1cd;
      border-color: #f5978e;
      padding: 5px 5px 5px 5px;
      font-size: 12px;
      border-radius: 4px;
    }

    .orange-span {
      color: #ff9000;
      background: #fdedd7;
      border-color: #facb8d;
      padding: 6px 6px 6px 6px;
      border-radius: 4px;
      font-size: 12px;
    }
  }
</style>
