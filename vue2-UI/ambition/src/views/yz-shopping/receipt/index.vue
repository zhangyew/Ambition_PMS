<template>
  <div class="app-container">
    <el-tabs
      v-model="activeName"
    >
      <el-tab-pane
        label="待收货"
        name="first"
      >
        <el-form
          :model="queryParams"
          ref="queryForm"
          size="small"
          :inline="true"
          v-show="showSearch"
          label-width="68px"
        >
          <el-form-item
            label="订单单号"
            prop="orderNumber"
          >
            <el-input
              v-model="queryParams.orderNumber"
              placeholder="请输入订单单号"
              clearable
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item>
            <el-button
              type="primary"
              icon="el-icon-search"
              size="mini"
              @click="handleQuery"
            >搜索</el-button>
            <el-button
              icon="el-icon-refresh"
              size="mini"
              @click="resetQuery"
            >重置</el-button>
          </el-form-item>
        </el-form>

        <el-row
          :gutter="10"
          class="mb8"
        >
  <!--        <el-col :span="1.5">
            <el-button
              type="success"
              plain
              size="mini"
              :disabled="single"
              icon="el-icon-s-order"
              @click="handleUpdate"
            >收货</el-button>
          </el-col> -->
          <!-- v-hasPermi="['pms.public:receipt:edit']" -->
          <right-toolbar
            :showSearch.sync="showSearch"
            @queryTable="getList"
          ></right-toolbar>
        </el-row>

        <el-table
          v-loading="loading"
          :data="receiptList"
          @selection-change="handleSelectionChange"
        >
          <el-table-column
            type="selection"
            width="55"
            align="center"
          />
          <el-table-column
            label="订单编号"
            align="center"
            prop="orderNumber"
          />
          <el-table-column
            label="供应商名称"
            align="center"
            prop="abbreviated"
          />
          <el-table-column
            label="公司"
            align="center"
            prop="firm"
            width="180"
          >
            <template>
              <span>远志集团股份有限公司</span>
            </template>
          </el-table-column>
          <el-table-column
            label="订单名称"
            align="center"
            prop="orderTitle"
          />
          <el-table-column
            label="发货数量"
            align="center"
            prop="demandCount"
          />
          <el-table-column
            label="总金额"
            align="center"
            prop="totalMoney"
          />
          <el-table-column
            label="发货日期"
            align="center"
            prop="datePlusThreeDays"
          >
            <template slot-scope="scope">
              <span>{{ parseTime(scope.row.datePlusThreeDays, '{y}-{m}-{d}') }}</span>
            </template>
          </el-table-column>
          <el-table-column
            label="操作"
            align="center"
            class-name="small-padding fixed-width"
          >
            <template slot-scope="scope">
              <el-button
                size="mini"
                type="text"
                icon="el-icon-s-order"
              >
                <router-link
                  class="link-type"
                  target="_blank"
                  :to="{ path: '/insert', query: { orderId: scope.row.orderId, count: scope.row.demandCount , MaterialId:scope.row.orderMaterialId , contractId:scope.row.ordeContractId}}"
                > 收货</router-link>
              </el-button>
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

      </el-tab-pane>
      <el-tab-pane
        label="收货单"
        name="second"
      >
        <el-form
          :model="queryReceipt"
          ref="queryForm"
          size="small"
          :inline="true"
          v-show="showSearch"
          label-width="68px"
        >
          <el-form-item
            label="收货单号"
            prop="receiptClod"
          >
            <el-input
              v-model="queryReceipt.receiptClod"
              placeholder="请输入收货单号"
              clearable
              @keyup.enter.native="handleQuerys"
            />
          </el-form-item>
          <el-form-item
            label="供应商"
            prop="abbreviated"
          >
            <el-input
              v-model="queryReceipt.abbreviated"
              placeholder="请输入收货单号"
              clearable
              @keyup.enter.native="handleQuerys"
            />
          </el-form-item>
          <el-form-item>
            <el-button
              type="primary"
              icon="el-icon-search"
              size="mini"
              @click="handleQuerys"
            >搜索</el-button>
            <el-button
              icon="el-icon-refresh"
              size="mini"
              @click="resetQuery"
            >重置</el-button>
          </el-form-item>
        </el-form>
        <el-table
          v-loading="loading"
          :data="formtList"
          @selection-change="handleSelectionChange"
        >
          <el-table-column
            type="selection"
            width="55"
            align="center"
          />
          <el-table-column
            label="收货单号"
            align="center"
            prop="receiptClod"
          />
          <el-table-column
            label="供应商名称"
            align="center"
            prop="abbreviated"
          />
          <el-table-column
            label="公司"
            align="center"
            prop="firm"
            width="180"
          >
            <template>
              <span>远志集团股份有限公司</span>
            </template>
          </el-table-column>
          <el-table-column
            label="收货数量"
            align="center"
            prop="receiptNumber"
          />
          <el-table-column
            label="总金额"
            align="center"
            prop="receiptMoney"
          />
          <el-table-column
            label="发货日期"
            align="center"
            prop="receiptTime"
          >
            <template slot-scope="scope">
              <span>{{ parseTime(scope.row.receiptTime, '{y}-{m}-{d}') }}</span>
            </template>
          </el-table-column>
          <el-table-column
            label="收货人"
            align="center"
            prop="receiptBy"
          />
          <el-table-column
            label="收货仓库"
            align="center"
            prop="warehouseName"
          />
        </el-table>

        <pagination
          v-show="total>0"
          :total="total"
          :page.sync="queryReceipt.pageNum"
          :limit.sync="queryReceipt.pageSize"
          @pagination="getReceipt"
        />

      </el-tab-pane>
    </el-tabs>

    <!-- 添加或修改收货单对话框 -->
    <el-dialog
      :title="title"
      :visible.sync="open"
      width="500px"
      append-to-body
    >
      <el-form
        ref="form"
        :model="form"
        :rules="rules"
        label-width="80px"
      >
        <el-form-item
          label="收货单号"
          prop="receiptClod"
        >
          <el-input
            v-model="form.receiptClod"
            placeholder="请输入收货单号"
          />
        </el-form-item>
        <el-form-item
          label="收货日期"
          prop="receiptTime"
        >
          <el-date-picker
            clearable
            v-model="form.receiptTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择收货日期"
          >
          </el-date-picker>
        </el-form-item>
        <el-form-item
          label="收货人"
          prop="receiptBy"
        >
          <el-input
            v-model="form.receiptBy"
            placeholder="请输入收货人"
          />
        </el-form-item>
        <el-form-item
          label="收货总数量"
          prop="receiptNumber"
        >
          <el-input
            v-model="form.receiptNumber"
            placeholder="请输入收货总数量"
          />
        </el-form-item>
        <el-form-item
          label="金额"
          prop="receiptMoney"
        >
          <el-input
            v-model="form.receiptMoney"
            placeholder="请输入金额"
          />
        </el-form-item>
        <el-form-item
          label="备注"
          prop="remark"
        >
          <el-input
            v-model="form.remark"
            placeholder="请输入备注"
          />
        </el-form-item>
        <el-form-item
          label="供应商ID"
          prop="receiptVendorId"
        >
          <el-input
            v-model="form.receiptVendorId"
            placeholder="请输入供应商ID"
          />
        </el-form-item>
        <el-form-item
          label="联系人"
          prop="contact"
        >
          <el-input
            v-model="form.contact"
            placeholder="请输入联系人"
          />
        </el-form-item>
        <el-form-item
          label="移动电话"
          prop="receiptPhone"
        >
          <el-input
            v-model="form.receiptPhone"
            placeholder="请输入移动电话"
          />
        </el-form-item>
        <el-form-item
          label="状态"
          prop="state"
        >
          <el-input
            v-model="form.state"
            placeholder="请输入状态"
          />
        </el-form-item>
        <el-form-item
          label="采购订单ID"
          prop="receiptOrdersId"
        >
          <el-input
            v-model="form.receiptOrdersId"
            placeholder="请输入采购订单ID"
          />
        </el-form-item>
        <el-form-item
          label="删除"
          prop="isDelete"
        >
          <el-input
            v-model="form.isDelete"
            placeholder="请输入删除"
          />
        </el-form-item>
      </el-form>
      <div
        slot="footer"
        class="dialog-footer"
      >
        <el-button
          type="primary"
          @click="submitForm"
        >确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {
  listReceipt,
  getReceipt,
  ShowsPublicReceiptList,
  delReceipt,
  addReceipt,
  updateReceipt,
} from "@/api/shopping/receipt";

export default {
  name: "Receipt",
  data() {
    return {
      activeName: "first",
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
      // 待货单表格数据
      receiptList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        orderNumber: null,
        abbreviated:null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {},
      //收货单查询参数
      queryReceipt: {
        pageNum: 1,
        pageSize: 10,
        receiptClod: null,
        abbreviated:null
      },
      //收货单表格数据
      formtList: [],
    };
  },
  filters: {
    ShowState(value) {
      if (value === 0) {
        return "待收货";
      }
    },
  },
  created() {
    this.getList();
    this.getReceipt();
  },
  methods: {
    /** 查询待货单列表 */
    getList() {
      this.loading = true;
      listReceipt(this.queryParams).then((response) => {
        console.log(response);
        this.receiptList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        orderNumber: null,
      };
      this.resetForm("form");
    },
    /** 待收货列表搜索按钮操作 */
    handleQuery() {
      this.queryReceipt.pageNum = 1;
      this.getLists();
    },
    /** 查询收货单列表 */
    getReceipt(){
      this.loading = true;
      ShowsPublicReceiptList(this.queryReceipt).then((response) => {
        this.formtList = response.rows;
        this.total = response.total;
        this.loading = false;
        console.log("显示所有："+response);
      });
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
      this.handleQuerys();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map((item) => item.receiptId);
      this.single = selection.length !== 1;
      this.multiple = !selection.length;
    },
    /** 收货列表搜索按钮操作 */
    handleQuerys() {
      this.queryReceipt.pageNum = 1;
      this.getReceipt();
    },
    //待收货状态框颜色变化
    getreceiptStateColor(state) {
      if (state === 0) {
        return "orange-span";
      }
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const receiptId = row.orderId || this.ids;
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (this.form.receiptId != null) {
            updateReceipt(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addReceipt(this.form).then((response) => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
  },
};
</script>
<style scoped lang="scss">
.orange-span {
  color: #ff9000;
  background: #fdedd7;
  border-color: #facb8d;
  padding: 6px 6px 6px 6px;
}
</style>
