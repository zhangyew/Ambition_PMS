<template>
  <div class="app-container">
    <div class="top">
      <div id="top_img" style="width: 100px;">
        <img src="@/assets/logo/logo2.jpg" alt="donate" height="100px" width="230px" />
      </div>
      <h1
        style="text-align: center; margin-top: -75px; margin-bottom: 75px;text-shadow: #008fff 2px 3px 8px; font-size: 40px;">
        远志投标台</h1>
    </div>
    <el-table :data="noticeBid" border style="width: 100%;text-align: center;">
      <!--      依据当前时间-投标截止时间来定,如果截止天数>0,状态为:已结束(-1),对应操作:无操作
                                              天数>0,状态  :进行中(0),        :查看,下载标书,可投标
                               时间未到,如果已投标,状态为:待定标(1),对应操作:无操作
                               时间到了,如果中标        :已中标(2),
                                          未中标       :未中标(3) -->
      <el-table-column prop="" label="状态" width="100" fixed="left" style="background: #008fff;">
        <template slot-scope="scope">
          {{dayCom(scope.row.bidEnd,scope.row.tenderNoticeId)}}
        </template>
      </el-table-column>
      <el-table-column prop="tenderNoticeId" label="公告id" width="200" v-if="hidd" />
      <el-table-column prop="tenderTitle" label="公告标题" width="200" :show-overflow-tooltip="true">
      </el-table-column>
      <el-table-column prop="tenderProjectsNumber" label="关联项目编号" width="200">
      </el-table-column>
      <el-table-column prop="tenderProjectsName" label="关联项目名称" width="200">
      </el-table-column>
      <el-table-column prop="tenderNoticeMonery" label="项目总金额(人民币¥)" width="150">
        <template slot-scope="scope">
        {{ scope.row.tenderNoticeMonery | formattedAmount }}
        </template>
      </el-table-column>
      <el-table-column prop="bidStart" label="开始招标时间" width="200">
      </el-table-column>
      <el-table-column prop="bidEnd" label="截止招标时间" width="200">
      </el-table-column>
      <el-table-column prop="processStart" label="流程开始时间" width="200">
      </el-table-column>
      <el-table-column prop="processEnd" label="流程结束时间" width="200">
      </el-table-column>

      <el-table-column fixed="right" label="操作" width="200">
        <template slot-scope="scope">
          <router-link
            :to="{name:'info',params:{ tenderNoticeProjectsId:''+scope.row.tenderNoticeProjectsId,tenderNoticeId:''+scope.row.tenderNoticeId,context:''+scope.row.context}}">
            <el-button type="text" size="mini " v-if="zt!=-1">查看</el-button>
          </router-link>
          <!-- <el-button @click="handleClick(scope.row)" type="text" size="mini"v-if="zt!=-1">查看</el-button> -->
          <!-- 标书可自由下载,下载后新增一条下载记录数据 -->
          <!-- <el-button type="text" size="mini" v-if="zt!=-1">下载标书</el-button> -->
        <!--  <el-button type="text" size="medium " v-if="zt!=-1"><router-link class="link-type" target="_blank"
              :to="{ path: '/info', query: { tenderNoticeId: scope.row.tenderNoticeId,context:scope.row.context, tenderNoticeProjectsId: scope.row.tenderNoticeProjectsId }}">
              查看</router-link>
          </el-button> -->
          <!-- <el-button v-if="zt===1" size="mini" type="text">投标成功</el-button> -->
          <!-- 投标后状态变成待定标,如果中标变成已中标 -->
          <!--          <el-button type="text" size="mini " v-if="zt!=-1">可投标</el-button> -->
          <!-- <el-button v-if="zt==-1" size="mini" type="text" icon="el-icon-lock">无可行操作</el-button> -->
        </template>
      </el-table-column>
    </el-table>

  </div>
</template>

<script>
  import {
    bidNeed
  } from "@/api/bidding/tender_notice";
  import {
    selBidCount
  } from "@/api/bidding/tender";
  export default {
    data() {
      return {
        noticeBid: [],
        isTB: 0,
        hidd: false,
        zt: 0,
        // tb:0
      }
    },
    filters: {
      formattedAmount(value) {
        return new Intl.NumberFormat("zh-CN", {
          style: "currency",
          currency: "CNY",
        }).format(value);
      },
    },
    created() {
      this.getList();
      const paramValue = this.$route.query.zt;
      console.log(paramValue); // 输出参数的值
      if (paramValue != null) {
        this.zt = paramValue;
      }

    },
    methods: {
      handleClick(row) {
        console.log(row);
      },
      getList() {
        bidNeed().then(response => {
          this.noticeBid = response.rows;
          // console.log("数据:" + JSON.stringify(response.rows));
          // tenderNoticeProjectsId
        });
      },
      //计算时间差
      dayCom(tt, cc) {
        // console.log("id:" + cc);
        //date1结束时间
        let date1 = new Date(tt);
        //date2当前时间
        let date2 = new Date();
        date1 = new Date(date1.getFullYear(), date1.getMonth(), date1.getDate());
        date2 = new Date(date2.getFullYear(), date2.getMonth(), date2.getDate());
        const diff = date1.getTime() - date2.getTime(); //目标时间减去当前时间
        const diffDate = diff / (24 * 60 * 60 * 1000); //计算当前时间与结束时间之间相差天数
        // console.log("计算的天数:" + diffDate);
        let sl = 0;
        // selBidCount(cc,).then(response => {
        //   // console.log("数据:" + response);
        //   this.isTB=response;
        //   sl=this.isTB;
        // });
        if (diffDate > 0) {
          this.zt = 0;
          return "进行中";
        } else {
          this.zt = -1;
          return "已结束";
        }
      },
    }

  }
</script>
