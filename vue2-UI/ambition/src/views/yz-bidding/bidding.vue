<template>
  <div class="hz">
    <!-- <div class="bt"> -->
    <el-tabs v-model="activeName" class="btl" style=" ">
      <el-tab-pane>
        <span class="wenz" slot="label"><i class="el-icon-discover dx"></i> 招标</span>
        <!-- 招标组件 -->
        <Tender :tid='id' :state='state'></Tender>
      </el-tab-pane>
      <el-tab-pane>
        <span class="wenz" slot="label"><i class="el-icon-message dx"></i> 投标</span>
        <Biddings :tid='id'></Biddings>
      </el-tab-pane>
      <el-tab-pane>
        <span class="wenz" slot="label"><i class="el-icon-open dx"></i> 开标</span>
        <Bids :tid='id'></Bids>
      </el-tab-pane>
      <el-tab-pane>
        <span class="wenz" slot="label"><i class="el-icon-chat-line-round dx"></i> 评标</span>
        <BidEvaluation :tid='id'></BidEvaluation>
      </el-tab-pane>
      <el-tab-pane>
        <span class="wenz" slot="label"><i class="el-icon-data-line dx"></i> 定标</span>
        <Calibration :tid='id'></Calibration>
      </el-tab-pane>
    </el-tabs>
    <!-- </div> -->
  </div>
</template>

<script>
  import Tender from '@/components/Bidding/tender'
  import Biddings from '@/components/Bidding/biddings'
  import Bids from '@/components/Bidding/bids'
  import BidEvaluation from '@/components/Bidding/bidEvaluation'
  import Calibration from '@/components/Bidding/calibration'

  export default {
    data() {
      return {
        id: null,
        state:null,
      }
    },
    components: {
      Tender,
      Biddings,
      Bids,
      BidEvaluation,
      Calibration
    },
    created() {
      this.id = this.$route.params.id
      this.state = this.$route.params.state
      // alert(this.$route.params.state)
    },
    methods: {

    }

  }
</script>

<style>
  .hz {
    margin: 0 auto;
    width: 1100px;
    height: 100%;

    /* .btl {
    height: 80px;
    line-height: 80px;
    background-color: #f2f2f2;
  } */

    .el-input--medium .el-input__inner {
      border: 0px;
    }

    .el-table td.el-table__cell,
    .el-table th.el-table__cell.is-leaf {
      border-bottom: 0px;
    }

    .el-table::before {
      width: 0px;
    }
  }

  #tab-0,
  #tab-1,
  #tab-2,
  #tab-3,
  #tab-4 {
    height: 70px;
    line-height: 70px;
    background-color: #f0f0f0;
    padding-right: 23px !important;
  }

  .hz .dx {
    font-size: 18px;
  }

  .hz .wenz {
    padding: 0px 60px 0px 62px !important;
    font-size: 18px;
    font-weight: 700;
  }

  .success-row {
    background-color: #ffffff !important;
  }
</style>
