<template>
  <div class="app-container home">
    <el-row :gutter="20">
      <el-col :sm="24" :lg="24">
        <div class="infor">
          <div> <el-button icon="el-icon-search" id="st" @click="drawer=true">系统模块一览</el-button></div>
          <el-dialog title="远志采购系统模块" :visible.sync="drawer" width="50%" :before-close="handleClose">
            <div id="main" style="width: 500px;height: 500px;"></div>
          </el-dialog>
          <img
            src="https://enterprise.e-cology.com.cn/cloudstore/release/3d14457595ef4785a1ee406c5650c01d/resources/icon_cg.png">
          <div style="margin-top: -14px;">
            <h3 style="color: black;">采购部</h3><span>The purchasing department</span>
          </div>
        </div>
        <ul class="cont">
          <li><a target="_blank" class="cursor-pointer">
              <h3>{{ddsl|formatM}}</h3><span style="color: #888;font-size: 12px;">总采购金额</span>
            </a></li>
          <li><a target="_blank" class="cursor-pointer">
              <h3>{{gys}}</h3><span>入驻供应商数量</span>
            </a></li>
          <li><a target="_blank" class="cursor-pointer">
              <h3>{{xmsl}}</h3><span>招标项目数量</span>
            </a></li>
          <li><a target="_blank" class="cursor-pointer">
              <h3>{{ht}}</h3><span>合同签订数</span>
            </a></li>
          <li><a target="_blank" class="cursor-pointer">
              <h3>{{tbsl}}</h3><span>收到投标数量</span>
            </a></li>
          <li><a target="_blank" class="cursor-pointer">
              <h3>同仁堂</h3><span>综合能力S级供应商</span>
            </a></li>
        </ul>
        <hr style="color: #dcdfe6;">
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :xs="24" :sm="24" :md="12" :lg="12">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span class="kb" style="font-size: 16px;">供应商信息</span>
          </div>
          <el-table :data="vendorInfo" style="width: 100%">
            <el-table-column prop="vendorNumber" label="供应商编码" width="150">
            </el-table-column>
            <el-table-column prop="abbreviated" label="名称" width="180" :show-overflow-tooltip="true">
            </el-table-column>
            <el-table-column prop="ranges" label="服务范围" width="150" :show-overflow-tooltip="true">
            </el-table-column>
            <el-table-column prop="delegates" label="法定代表人" width="100">
            </el-table-column>
          </el-table>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="24" :md="12" :lg="12">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span class="kb" style="font-size: 16px;">采购订单</span>
          </div>
          <el-table :data="orderList" style="width: 100%">
            <el-table-column prop="orderNumber" label="订单编码" width="190">
            </el-table-column>
            <el-table-column prop="orderTitle" label="订单标题" width="180" :show-overflow-tooltip="true">
            </el-table-column>
            <el-table-column prop="orderPurchaser" label="采购人员" width="100">
            </el-table-column>
            <el-table-column prop="typeOrderState" label="订单状态" width="130">
              <template slot-scope="scope">
                <dict-tag :options="dict.type.type_order_state" :value="scope.row.typeOrderState" />
              </template>
            </el-table-column>
          </el-table>
        </el-card>
      </el-col>
    </el-row>
    <el-divider />
    <el-row :gutter="20">
      <el-col :xs="24" :sm="24" :md="12" :lg="12">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span class="kb" style="font-size: 16px;">招标公告</span>
          </div>
          <el-table :data="tenderNotice" style="width: 100%">
            <el-table-column prop="tenderTitle" label="招标公告标题" width="200" :show-overflow-tooltip="true">
            </el-table-column>
            <el-table-column prop="processStart" label="流程开始时间" width="200">
            </el-table-column>
            <el-table-column prop="processEnd" label="流程结束时间" width="200">
            </el-table-column>
          </el-table>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="24" :md="12" :lg="12">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span class="kb" style="font-size: 16px;">中标公告</span>
          </div>
          <el-table :data="bidNotice" style="width: 100%">
            <el-table-column prop="noticeTitle" label="中标公告标题" width="200" :show-overflow-tooltip="true">
            </el-table-column>
            <el-table-column prop="vendorName" label="中标供应商" width="200">
            </el-table-column>
            <el-table-column prop="noticeDate" label="发布日期" width="200">
            </el-table-column>
          </el-table>
        </el-card>
      </el-col>
    </el-row>

  </div>

</template>

<script>
  import {
    showAll,
    VendorSum
  } from "@/api/public/vendor";
  import {
    selAll
  } from "@/api/bidding/notice";
  import {
    TenderSum
  } from "@/api/bidding/tender";
  import {
    ContractCountList,
  } from "@/api/bidding/contractdetails";
  import {
    showsNoticeList
  } from "@/api/bidding/tender_notice";
  import {
    ProSum
  } from "@/api/bidding/tender_projects";
  import {
    showOO,
    OrderSum
  } from "@/api/shopping/orders";
  import * as echarts from 'echarts';

  export default {
    name: "Index",
    dicts: ['type_order_state'],
    data() {
      return {
        vendorInfo: [],
        orderList: [],
        tenderNotice: [],
        bidNotice: [],
        drawer: false,
        gys: 0,
        ddsl: 0,
        ht: 0,
        tbsl: 0,
        xmsl: 0,
      };
    },
    updated() {
      this.$nextTick(() => {
        this.mm();
      })
    },
    created() {
      this.getVendorList();
      this.getOrderList();
      this.getTenderNotice();
      this.getBidNotice();
      VendorSum().then((response) => {
        // console.log("数量1:"+response);
        this.gys = response;
      });
      OrderSum().then((response) => {

        this.ddsl = response;
      });
      ContractCountList().then((response) => {
        this.ht = response;
      });
      TenderSum().then((response) => {
        this.tbsl = response;
      });
      ProSum().then((response) => {
        this.xmsl = response;
      });
    },
    methods: {
      mm() {
        var chartDom = document.getElementById('main');
        var myChart = echarts.init(chartDom);
        var option;
        const data = {
          name: '远志采购系统',
          children: [{
              name: '供应商模块',
              children: [{
                name: '供应商操作',
                children: [{
                    name: '信息注册',
                  },
                  {
                    name: '供货能力登记',
                  }
                ]
              }]
            },
            {
              name: '采购模块',
              children: [{
                  name: '采购需求',
                  children: [{
                      name: '需要招标',
                    },
                    {
                      name: '不需要招标',
                    }
                  ]
                },
                {
                  name: '采购计划',
                },
                {
                  name: '采购订单',
                },
                {
                  name: '订单收货',
                }
              ]
            },
            {
              name: '合同模块',
              children: [{
                  name: '合同签订',
                },
                {
                  name: '合同管理',
                }
              ]
            },
            {
              name: '招标模块',
              children: [{
                  name: '招标',
                  children: [{
                      name: '招标公告',
                    },
                    {
                      name: '招标项目',
                    }
                  ]
                },
                {
                  name: '投标',

                },
                {
                  name: '开标',
                  children: [{
                    name: '选取专家',

                  }]
                },
                {
                  name: '评标',

                },
                {
                  name: '定标',
                  children: [{
                    name: '中标公告',

                  }]
                }
              ]
            },
            {
              name: '主数据模块',
              children: [{
                  name: '编码规则',

                },
                {
                  name: '仓库管理',

                },
                {
                  name: '物料管理',

                },
                {
                  name: '物料类别管理',

                },
                {
                  name: '专家库/专家管理',

                }
              ]
            }
          ]
        };
        option = {
          tooltip: {
            trigger: 'item',
            triggerOn: 'mousemove'
          },
          series: [{
            type: 'tree',
            id: 0,
            name: 'tree1',
            data: [data],
            top: '10%',
            left: '8%',
            bottom: '22%',
            right: '20%',
            symbolSize: 7,
            edgeShape: 'polyline',
            edgeForkPosition: '63%',
            initialTreeDepth: 3,
            // nodeClick:false,
            lineStyle: {
              width: 2
            },
            label: {
              backgroundColor: '#fff',
              position: 'left',
              verticalAlign: 'middle',
              align: 'right'
            },
            leaves: {
              label: {
                position: 'right',
                verticalAlign: 'middle',
                align: 'left'
              }
            },
            emphasis: {
              focus: 'descendant'
            },
            expandAndCollapse: true,
            animationDuration: 550,
            animationDurationUpdate: 750
          }]
        };

        option && myChart.setOption(option);
      },
      handleClose(done) {
        this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {});
      },
      goTarget(href) {
        window.open(href, "_blank");
      },
      //获取供应商列表
      getVendorList() {
        showAll().then((response) => {
          this.vendorInfo = response.rows;
          // console.log("供应商信息:" + JSON.stringify(response.rows));
        });
      },
      //显示招标公告
      getTenderNotice() {
        showsNoticeList().then((response) => {
          this.tenderNotice = response.rows;
          // console.log("显示招标公告:" + JSON.stringify(response.rows));
        });
      },
      //中标公告
      getBidNotice() {
        selAll().then((response) => {
          this.bidNotice = response.rows;
          // console.log("显示中标公告:" + JSON.stringify(response.rows));
        });
      },
      // 采购订单
      getOrderList() {
        showOO().then((response) => {
          this.orderList = response.rows;
          console.log("采购订单:" + JSON.stringify(response.rows));
        });
      },
    },
    filters: {
      formatM(value) {
        return new Intl.NumberFormat("zh-CN", {
          style: "currency",
          currency: "CNY",
        }).format(value);
      },
    },
  };
</script>

<style scoped lang="scss">
  .home {
    blockquote {
      padding: 10px 20px;
      margin: 0 0 20px;
      font-size: 17.5px;
      border-left: 5px solid #eee;
    }

    .infor {
      width: 25%;
      display: inline-block;
      border-right: 1px solid #eee;
      position: relative;
      vertical-align: middle;
    }

    .infor img {
      width: 50px;
      height: 50px;
      position: absolute;
      top: -3px;
      left: 10px;
      border: 1px solid #eee;
      border-radius: 50px;
      overflow: hidden;
    }

    .infor div {
      padding-left: 80px;
    }

    h3 {
      color: rgb(64, 158, 255);
    }

    .cont {
      position: relative;
      display: inline-block;
      width: 75%;
      overflow: hidden;
      vertical-align: middle;
      top: -10px
    }

    .cont li {
      width: 16.6%;
      text-align: center;
      float: left;
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

    .Element_ProcurementReport>li {
      position: relative;
      width: 17%;
      display: inline-block;
      margin-right: 2%;
      vertical-align: top;
    }

    .kb {
      color: #2b4bab;
    }

    .pt-3 {
      padding-top: 0.5rem;
      color: white;
      width: 100px;
      height: 35px;
      text-align: center;
      font-size: 15px;
      line-height: 40px;
      padding-left: 25px;
    }

    .pt-4 {
      padding-left: 10px;
    }
  }

  #st {
    position: fixed;
    left: 1415px;
    top: 50px;
    z-index: 100;
    font-size: 12px;
    color: white;
    background-color: #409effa1;
  }
</style>
