<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="计划编码" prop="planClod">
        <el-input v-model="queryParams.planClod" placeholder="请输入采购计划编码" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="供应商" prop="buyPlanVendorId">
        <el-autocomplete popper-class="my-autocomplete" v-model="queryParams.buyPlanVendorName"
          :fetch-suggestions="querySearch" placeholder="请输入内容" @select="handleSelect">
          <i class="el-icon-search el-input__icon" slot="suffix" @click="handleIconClick"></i>
          <template slot-scope="{ item }">
            <label style="display: none;">{{ item.value }}</label>
            <label>{{ item.number }}</label>&nbsp; &nbsp;&nbsp;
            <label>{{ item.name }}</label>
          </template>
        </el-autocomplete>
      </el-form-item>
      <el-form-item label="采购类型" prop="buyTypeId">
        <el-select v-model="queryParams.buyTypeId" placeholder="请选择采购类型" clearable style="width: 140px;">
          <el-option v-for="dict in dict.type.require_type" :key="dict.value" :label="dict.label" :value="dict.value" />
        </el-select>
      </el-form-item>
      <el-form-item label="状态" prop="planState">
        <el-select v-model="queryParams.planState" placeholder="请选择状态" clearable style="width: 150px;">
          <el-option v-for="dict in dict.type.require_state" :key="dict.value" :label="dict.label"
            :value="dict.value" />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd">新增</el-button>
      </el-col>
      <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport"
        v-hasPermi="['shopping/buy_plan:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="buy_planList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="采购计划编码" align="center" prop="planClod">
        <template slot-scope="scope">
          <router-link :to="'/yz-shopping/buy_plan/info/'+scope.row.buyPlanId" class="link-type">
            {{scope.row.planClod}}
          </router-link>
        </template>
      </el-table-column>
      <el-table-column label="计划名称" align="center" prop="planName" :show-overflow-tooltip="true"/>
      <el-table-column label="供应商" align="center" prop="vendorName" :show-overflow-tooltip="true"/>
      <el-table-column label="仓库" align="center" prop="warehouseName" :show-overflow-tooltip="true"/>
      <el-table-column label="采购类型" align="center" prop="buyTypeId">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.require_type" :value="scope.row.buyTypeId" />
        </template>
      </el-table-column>
      <el-table-column label="状态" align="center" prop="planState">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.require_state" :value="scope.row.planState" />
        </template>
      </el-table-column>
      <el-table-column label="创建人" align="center" prop="createBy" />
      <el-table-column label="创建时间" align="center" prop="createTime" width="200px" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <router-link :to="{name:'info1',params:{ resource: '1',sid:''+scope.row.buyPlanId}}">
            <el-button v-if="scope.row.planState == 1" size="mini" type="text" icon="el-icon-printer"
              class="btn btn-default">生成采购订单</el-button>
          </router-link>
          <router-link :to="{name:'planUpdate',params:{ bid:''+scope.row.buyPlanId}}">
            <el-button v-if="[0,2].includes(scope.row.planState)" size="mini" type="text" icon="el-icon-edit">修改</el-button>
          </router-link>
          <el-button v-if="[0,2].includes(scope.row.planState)" size="mini" type="text" icon="el-icon-s-check"
            @click="handleExamine(scope.row)" v-hasPermi="['shopping/buy_plan:buy_plan:examine']">审批</el-button>
          <el-button v-if="scope.row.planState == 3" size="mini" type="text" icon="el-icon-lock">无可行操作</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
      @pagination="getList" />

    <!-- 审批对话框 -->
    <el-dialog :title="title" :visible.sync="opens" width="800px" append-to-body>
      <el-form ref="forms" :model="forms" label-width="150px">
        <el-form-item label="审批状态" prop="planState" style="width: 400px;">
          <el-select v-model="forms.planState" placeholder="请确定审批结果!">
            <el-option v-for="dict in dict.type.require_state" :key="dict.value" :label="dict.label"
              :value="parseInt(dict.value)"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="examine">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
  import {
    listBuy_plan,
    getBuy_plan,
    delBuy_plan,
    addBuy_plan,
    updateExamine
  } from "@/api/shopping/buy_plan";
  import {
    listVendor
  } from "@/api/public/vendor";
  import {
    listWarehouse
  } from "@/api/public/warehouse";
  export default {
    name: "Buy_plan",
    dicts: ['require_state', 'require_type'],
    data() {
      return {
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
        // 采购计划表表格数据
        buy_planList: [],
        // 弹出层标题
        title: "",
        // 是否显示弹出层
        opens: false,
        restaurants: [],
        listWarehouse: {},
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          planClod: null,
          planName: null,
          buyPlanVendorId: null,
          buyPlanVendorName: '',
          buyPlanWarehouseId: null,
          buyTypeId: null,
          planState: null,
          createBy: null,
          createTime: null,
        },
        // 表单参数
        form: {},
        // 审批表单参数
        forms: {},
        // 表单校验
        rules: {}
      };
    },
    created() {
      this.getList();
      listWarehouse(null).then(response => {
        console.log(response.rows)
        this.listWarehouse = response.rows;
        // console.log("仓库列表:" + JSON.stringify(response.rows));
      });
    },
    mounted() {
      this.restaurants = this.loadAll();
    },
    methods: {
      /** 查询采购计划表列表 */
      getList() {
        if (this.queryParams.buyPlanVendorName == '') {
          this.queryParams.buyPlanVendorId = null
        }
        // console.log("getList:", this.queryParams)
        this.loading = true;
        listBuy_plan(this.queryParams).then(response => {
          // console.log("buy_planList:", response.rows)
          this.buy_planList = response.rows;
          this.total = response.total;
          this.loading = false;
        });
      },
      /** 审批按钮操作 */
      handleExamine(row) {
        this.reset();
        const buyPlanId = row.buyPlanId || this.ids
        getBuy_plan(buyPlanId).then(response => {
          this.forms = response.data;
          this.opens = true;
          this.title = "进行审批";
        });
      },
      /**
       * 审批修改审批状态
       */
      examine() {
        this.$refs["forms"].validate(valid => {
          // console.log("valid:" + valid);
          updateExamine(this.forms).then(response => {
            this.$modal.msgSuccess("成功");

            this.opens = false;
            this.getList();
          });
        });
      },
      /**
       * 转为采购订单
       */
      handleCreate(row) {
        this.$router.push("/yz-shopping/orders/info");
      },
      // 取消按钮
      cancel() {
        this.opens = false;
        this.reset();
      },
      // 表单重置
      reset() {
        this.form = {
          buyPlanId: null,
          planName: null,
          planClod: null,
          buyPlanVendorId: null,
          buyPlanVendorName: '',
          buyPlanWarehouseId: null,
          buyTypeId: null,
          planState: null,
          createBy: null,
          createTime: null,
          updateBy: null,
          updateTime: null,
          isDelete: null
        };
        this.resetForm("form");
      },
      /** 搜索按钮操作 */
      handleQuery() {
        this.queryParams.pageNum = 1;
        this.getList();
      },
      /** 重置按钮操作 */
      resetQuery() {
        this.resetForm("queryForm");
        this.handleQuery();
      },
      // 多选框选中数据
      handleSelectionChange(selection) {
        this.ids = selection.map(item => item.buyPlanId)
        this.single = selection.length !== 1
        this.multiple = !selection.length
      },
      /** 新增按钮操作 */
      handleAdd() {
        this.$router.push("/yz-shopping/buy_plan/insert");
        // this.reset();
        // this.open = true;
        // this.title = "添加采购计划表";
      },
      /** 提交按钮 */
      submitForm() {
        this.$refs["form"].validate(valid => {
          if (valid) {
            if (this.form.buyPlanId != null) {
              updateBuy_plan(this.form).then(response => {
                this.$modal.msgSuccess("修改成功");
                this.open = false;
                this.opens = false;
                this.getList();
              });
            } else {
              addBuy_plan(this.form).then(response => {
                this.$modal.msgSuccess("新增成功");
                this.open = false;
                this.getList();
              });
            }
          }
        });
      },
      /** 导出按钮操作 */
      handleExport() {
        this.download('shopping/buy_plan/export', {
          ...this.queryParams
        }, `buy_plan_${new Date().getTime()}.xlsx`)
      },
      /**
       * 供应商查询搜索框
       * @param {Object} queryString
       * @param {Object} cb
       */
      querySearch(queryString, cb) {
        var restaurants = this.restaurants;
        var results = queryString ? restaurants.filter(this.createFilter(queryString)) : restaurants;
        // 调用 callback 返回建议列表的数据
        cb(results);
      },
      createFilter(queryString) {
        return (restaurant) => {
          return (restaurant.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
        };
      },
      loadAll() {
        var blogtitle = [];
        listVendor(this.queryParams.buyPlanVendorId).then(response => {
          for (let item of response.rows) {
            blogtitle.push({
              "value": item.vendorId,
              "number": item.vendorNumber,
              "name": item.abbreviated
            })
          }
          this.restaurants = blogtitle;
          // console.log(blogtitle);
        })
      },
      handleSelect(item) {
        console.log("handleSelect:" + JSON.stringify(item));
        this.queryParams.buyPlanVendorId = item.value;
        this.queryParams.buyPlanVendorName = item.name;
      },
      handleIconClick(ev) {
        console.log("2:" + ev);
      },
    }
  };
</script>
