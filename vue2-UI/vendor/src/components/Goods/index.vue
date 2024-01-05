<template>
  <div>

    <!--   <el-dialog title="提示" :visible.sync="showDialog" width="50%" @close="handleClose">

      <span>这是一段信息</span>
      <span slot="footer" class="dialog-footer">
        <el-button @click="showDialog = false">取 消</el-button>
        <el-button type="primary" @click="showDialog = false">确 定</el-button>
      </span>

    </el-dialog> -->
    <el-drawer title="选着物品" :size="550" style="box-shadow: rgb(0 0 0 / 13%) 4px 4px 8px 3px; height: 74%;    margin: 120px auto;
    width: 50%;" :visible.sync="showDialog" direction="btt" :modal="false" :before-close="handleClose">

      <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" label-width="68px">
        <el-form-item label="名称">
          <el-input style="width: 120px;" placeholder="请输入简称" v-model="queryParams.goodsName" clearable />
        </el-form-item>
        <!-- <el-form-item label="编号">
          <el-input style="width: 120px;" placeholder="请输入编号" clearable />
        </el-form-item> -->
        <el-form-item label="分类" porp="categoryId">
          <el-select style="width: 140px;" placeholder="请选分类" prop="categoryId" v-model="queryParams.categoryId"
            clearable>

            <el-option v-for="dict in categoryList" @click.native="selects" :key="dict.categoryId"
              :label="dict.categoryName" :value="dict.categoryId" />
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-col :span="1.5">
            <el-button type="primary" plain size="mini" @click="handleQuery">
              搜索
            </el-button>
          </el-col>
        </el-form-item>
      </el-form>

      <!-- max-height="70%" -->
      <el-table v-loading="loading" height="325" @row-dblclick="doubleclik" :data="goodsList" ref="multipleTable"
        @selection-change="handleSelectionChange" @row-click="handleSelectionChanges(scope.row)">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="物料编码" align="center" prop="goodsId" />
        <el-table-column label="物料名称" align="center" prop="goodsName" />
        <el-table-column label="计量单位" align="center" prop="goodsType">
          <template slot-scope="scope">
            <dict-tag :options="dict.type.goods_unit" :value="scope.row.goodsType" />
          </template>
        </el-table-column>
        <el-table-column label="规格" align="center" prop="specs" />
        <el-table-column label="型号" align="center" prop="model" />
        <el-table-column label="品牌" align="center" prop="brand" />
        <el-table-column label="重量单位" align="center" prop="weight" />

        <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
          <template slot-scope="scope">
            <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
              v-hasPermi="['public/goods:goods:edit']">修改</el-button>
          </template>
        </el-table-column>
      </el-table>
      <pagination v-show="total>0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
        @pagination="getList" />

      <!-- <div slot="footer" class="dialog-footer"> -->
      <el-button type="primary" style="margin-left: 20px;" @click="qd">确 定</el-button>
      <el-button @click="handleClose">取 消</el-button>
      <!-- </div> -->


    </el-drawer>
  </div>
</template>

<script>
  import {
    listGoods,
    getGoods,
    delGoods,
    addGoods,
    updateGoods
  } from "@/api/public/goods";
  import {
    listCategory,
    ParentCategoryList,
    getCategory,
    delCategory,
    addCategory,
    updateCategory
  } from "@/api/public/category";
  import {
    getToken
  } from "../../utils/auth";
  export default {
    name: "Goods",
    dicts: ['goods_unit'],
    // 接受父组件传递的值
    props: {
      addOrUpdateVisible: {
        type: Boolean,
        default: false
      },
      gysId: {
        type: String,
        default: null
      }
    },
    data() {
      return {
        // 控制弹出框显示隐藏
        showDialog: false,
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
        // 物料表格数据
        goodsList: [],
        // 弹出层标题
        title: "",
        // 物料类别表格数据
        categoryList: [],
        // 是否显示弹出层
        open: false,
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          categoryId: null,
          goodsName: null,
        },
        // 表单参数
        form: {},
        // 表单校验
        rules: {},
        showform: {},
        gysId: null,
      }
    },
    created() {
      this.getList();
      listCategory(null).then(response => {
        this.categoryList = response.rows;
      });
      console.log(this.getList);
    },
    methods: {

      // 弹出框关闭后触发
      handleClose() {
        // 子组件调用父组件方法，并传递参数
        this.showDialog = false;
        this.ids = null
        this.$emit('Goods', null, 'false')
      },
      /** 查询物料列表 */
      getList() {
        this.loading = true;
        console.log(this.queryParams.categoryId)
        let fd = new FormData();
        if (this.queryParams.goodsName != null && this.queryParams.goodsName != '')
          fd.append("mc", this.queryParams.goodsName);
        if (this.queryParams.categoryId != null && this.queryParams.categoryId != '')
          fd.append("fl", this.queryParams.categoryId);
        if (this.gysId != null && this.gysId != '')
          fd.append("gys", this.gysId);
        axios.post('/dev-api/shopping/goods/findGoodsList', fd, {
            headers: {
              'Authorization': `Bearer ${getToken()}`,
              'Content-Type': 'multipart/form-data', // 设置请求头为 multipart/form-data
            },
          })
          .then(response => {
            console.log(response)
            this.goodsList = response.data.rows
            this.total = response.data.total;
            this.loading = false;
          })

      },
      handleSelectionChange(selection) {
        this.ids = selection
        this.single = selection.length !== 1
        this.multiple = !selection.length
        // console.log(this.ids)
      },
      handleSelectionChanges(row) {
        console.log("row:", row)
        this.ids = row
        this.single = selection.length !== 1
        this.multiple = !selection.length
      },
      handleQuery() {
        this.queryParams.pageNum = 1;
        this.getList();
      },
      doubleclik(row) {
        this.ids = row;
        this.$emit('Goods', this.ids, 'false')
        this.$refs.multipleTable.clearSelection();
      },
      qd() {
        this.$emit('Goods', this.ids, 'false')
        this.$refs.multipleTable.clearSelection();
      }
    },
    watch: {

      // 监听 addOrUpdateVisible 改变
      addOrUpdateVisible(oldVal, newVal) {
        this.showDialog = this.addOrUpdateVisible
      },
    }
  }
</script>

<style>
  /*  .el-drawer__container {
    position: relative;
    left: 0;
    right: 0;
    top: 0;
    bottom: 0;
    height: 90%;
    width: 50%;
    margin: 0 auto;
  } */

  .el-table {
    /* height: 320px; */
  }
</style>
