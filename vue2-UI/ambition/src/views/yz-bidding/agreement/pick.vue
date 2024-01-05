<template>
    <div class="app-container" style="background-color: rgb(237,240,245); height: 100%;">
        <div class="bost">
            <el-row :gutter="20">
                <el-col :xs="24" :sm="24" :md="12" :lg="12" style="margin-left: 348px;margin-top: 40px;height: 200px;">
                    <div class="bost_oo">
                        <p class="oo_p">
                            <router-link class="link-type"  :to="{name:'index',params:{ ht: '0' }}">长期合同</router-link>
                        </p>
                        <p>
                            <span>
                                长期合同采购是指采购商和供应商通过合同，以稳定双方的交易关系，合同期一般在一年以上。在合同期内、采购方承诺在供应方采购其所需产品，
                                供应方承诺满足采购方在数量、品种、规格、型号等方面的需要。
                            </span>
                        </p>
                    </div>
                </el-col>
            </el-row>
            <el-row :gutter="20">
                <el-col :xs="24" :sm="24" :md="12" :lg="12" style="margin-left: 348px;margin-top: 40px;height: 200px;">
                    <div class="bost_oo">
                        <p class="oo_p">
                            <router-link class="link-type" :to="{name:'index',params:{ ht: '1' }}">短期合同</router-link>
                        </p>
                        <p>
                            <span>
                                短期合同采购是指采购商和供应商通过合同，实现一次交易，以满足生产经营活动需要。
                            </span>
                        </p>
                    </div>
                </el-col>
            </el-row>
            <el-row :gutter="20">
                <el-col :xs="24" :sm="24" :md="12" :lg="12" style="margin-left: 348px;margin-top: 40px;height: 200px;">
                    <div class="bost_oo">
                        <p class="oo_p">
                            <router-link class="link-type" :to="{name:'index',params:{ ht: '2'}}">补充合同</router-link>
                        </p>
                        <p>
                            <span>
                                采购合同履行中，采购人需追加与合同标的相同的货物、工程或者服务的，在不改变合同其他条款的前提下，可以与供应商协商签订补充合同。
                            </span>
                        </p>
                    </div>
                </el-col>
            </el-row>
        </div>
    </div>
  </template>
  
  <script>
  export default {
    name: "Agreement",
    data() {
      return {
        // 遮罩层
        loading: true,
        title: "合同签订",
        // 是否显示弹出层
        open: false
      };
    },
    created() {
    },
    methods: {

    }
  };
  </script>
 <style scoped lang="scss">
    .bost{
        width: 1400px;
        height: 770px;
        margin: 0px auto ;
        margin-top: 20px;
        background-color: white;
        text-align: center;
        box-shadow: 0px 2px 4px 0px rgba(100, 98, 98, 0.12);

        .bost_oo{
            border:  1px  rgb(160,174,192) solid;
            text-align: center; 
            height: 200px;
            padding: 47px 25px 7px 25px;
            box-shadow: 10px 10px 6px 1px rgba(79, 78, 78, 0.12);

            .oo_p{
                font-size: 20px;
                font-weight: bold;
            }

            span{
                color: rgb(160,174,192);
                font-size: 14px;
            }
            span:hover{
                    color: #5fa6ed;
                }
        }
    }

 </style>