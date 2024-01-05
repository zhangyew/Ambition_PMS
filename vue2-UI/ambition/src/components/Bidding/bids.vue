<template>
  <div>
    <el-tabs value="first" @tab-click="handleClick" >
      <el-tab-pane label="组建评标委员会" name="first">
        <div>
          <el-row :gutter="10" class="mb8" v-if="isButtn">
            <el-col :span="1.5">
              <router-link :to="'/draw_experts/id=' + id">
                <el-button type="success" plain icon="el-icon-plus" size="small">抽取专家</el-button>
              </router-link>
            </el-col>
          </el-row>
          <div v-if="!isButtn">
            <span class="el-icon-receiving" style="font-size: 24px;color: rgb(24 144 255);"></span>
            <span
              style="    font-weight: 550;margin-bottom: 10px;display: inline-block;font-size: 15px;margin-left: 30px;color: #515151;">以下专家为{{zj}}结果
            </span>
          </div>
          <el-table v-loading="loading" :data="poolList" :row-class-name="tableRowClassName"
            @selection-change="handleSelectionChange">
            <el-table-column label="序号" type="index" width="50" />
            <!-- <el-table-column label="专家库主键" align="center" prop="poolId" /> -->
            <el-table-column label="姓名" align="center" prop="name" />
            <el-table-column label="身份证号" align="center" prop="id_card" />
            <el-table-column label="联系方式" align="center" prop="phone" />
            <el-table-column label="来源库" align="center" prop="expert_pool_name" />
            <el-table-column label="专业类型" align="center" prop="category" width="110">
              <template slot-scope="scope">
                <dict-tag :options="dict.type.pool_type" :value="scope.row.category" />
              </template>
            </el-table-column>
            <el-table-column label="专家级别" align="center" prop="category" width="110">
              <template slot-scope="scope">
                <dict-tag :options="dict.type.expert_pool_level" :value="scope.row.level" />
              </template>
            </el-table-column>
            <!-- <el-table-column label="删除" align="center" prop="isDelete" /> -->
            <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
              <template slot-scope="scope">
                <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                  v-hasPermi="['bidding:extract:remove']">删除</el-button>
              </template>
            </el-table-column>
          </el-table>
        </div>
      </el-tab-pane>
      <!-- <el-tab-pane label="开标" name="second"></el-tab-pane> -->

    </el-tabs>
  </div>
</template>

<script>
  import {
    getToken
  } from '../../utils/auth';
  import {
    delExtract
  } from "@/api/bidding/tender_projects";
  export default {
    dicts: ['pool_type', 'expert_pool_level'],
    data() {
      return {
        id: this.tid,
        poolList: [],
        isButtn: false,
        zj: "随机抽取",
      }
    },
    props: ['tid'],
    mounted() {

    },
    created() {
      let str = this.id;
      let parts = str.split("&"); // 使用 & 分割字符串
      let firstPart = parts[0]; // 获取第一个部分
      let secondPart = parts[1]; // 获取第二个部分
      console.log(firstPart); // 输出 "11"
      console.log(secondPart); // 输出 "1"
      this.id = firstPart;
      this.state = secondPart;
      this.getList()
    },
    methods: {
      getList() {
        let fd = new FormData()
        fd.append("pid", this.id)
        axios.post('/dev-api/bidding/draw_experts/findExpertsByProjectsId', fd, {
            headers: {
              'Authorization': `Bearer ${getToken()}`,
              'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
            },
          })
          .then(response => {
            console.log(response)

            this.poolList = response.data
            if (this.poolList.length === 0) {
              this.isButtn = true;
            }
            if (response.data.manner === 1 || response.data.manner === '1')
              this.zj = "直接指定"
          })
      },
      tableRowClassName({
        row,
        rowIndex
      }) {
        row.xh = rowIndex + 1;
        if (rowIndex % 2 === 0) {
          return 'success-row' //这是类名
        } else {
          return ''
        }
      },
      /** 删除按钮操作 */
      handleDelete(row) {
        const getExpertExtractIds = row.get_expert_extract_id || this.ids;
        const id = row.expert_id;
        this.$modal.confirm('是否取消  "' + row.name + '"  专家的后续开标流程？').then(function() {
          return delExtract(getExpertExtractIds);
        }).then(() => {
          let fd = new FormData()
          fd.append("id", id)
          console.log(id)
          axios.post('/dev-api/bidding/expert/updateIsExtract', fd, {
              headers: {
                'Authorization': `Bearer ${getToken()}`,
                'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
              },
            })
            .then(response => {
              this.getList();
              this.$modal.msgSuccess("删除成功");
            })
        }).catch(() => {});
      },
    }
  }
</script>

<style>
</style>
