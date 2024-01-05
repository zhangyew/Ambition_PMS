<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="品类编号" prop="categoryNumber">
        <el-input v-model="queryParams.categoryNumber" placeholder="请输入品类编号" clearable
          @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="品类名称" prop="categoryName">
        <el-input v-model="queryParams.categoryName" placeholder="请输入品类名称" clearable
          @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="上级品类" prop="parentCategory">
        <el-autocomplete popper-class="my-autocomplete" v-model="queryParams.parentCategory" :fetch-suggestions="querySearch"
          :placeholder="'请输入内容'" @select="handleSelect"  @click="handleBlur">
          <i class="el-icon-edit el-input__icon" slot="suffix" @click="handleIconClick">
          </i>
          <template slot-scope="{ item }">
            <div class="category_name">
              <label>{{ item.value }}</label>
              <label>{{ item.number }}</label>
            </div>
          </template>
          
        </el-autocomplete>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd"
          v-hasPermi="['pms.public:category:add']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="success" plain icon="el-icon-edit" size="mini" :disabled="single" @click="handleUpdate"
          v-hasPermi="['pms.public:category:edit']">修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="danger" plain icon="el-icon-delete" size="mini" :disabled="multiple" @click="handleDelete"
          v-hasPermi="['pms.public:category:remove']">删除</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="categoryList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="品类编码" align="center" prop="categoryNumber" />
      <el-table-column label="品类名称" align="center" prop="categoryName" />
      <el-table-column label="上级品类" align="center" prop="parentCategory" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="创建人" align="center" prop="createBy" />
      <el-table-column label="更新时间" align="center" prop="updateTime" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
            v-hasPermi="['pms.public:category:edit']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
            v-hasPermi="['pms.public:category:remove']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <pagination v-show="total>0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
      @pagination="getList" />

    <!-- 添加或修改物料类别对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="品类编码" prop="categoryNumber" >
          <el-input v-model="form.categoryNumber" placeholder="自动生成" readonly="readonly"/>
        </el-form-item>
        <el-form-item label="品类名称" prop="categoryName">
          <el-input v-model="form.categoryName" placeholder="请输入品类名称" />
        </el-form-item>
        <el-form-item label="上级品类" prop="parentCategory">
        <el-autocomplete popper-class="my-autocomplete" v-model="form.parentCategory" :fetch-suggestions="querySearchs"
          :placeholder="'请输入内容'" @select="handleSelects">
          <i class="el-icon-edit el-input__icon" slot="suffix" @click="handleIconClicks">
          </i>
          <template slot-scope="{ item }">
            <div class="category_name">
              <label>{{ item.value }}</label>
              <label>{{ item.number }}</label>
            </div>
          </template>
        </el-autocomplete>
      </el-form-item>

      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  import {
    listCategory,
    ParentCategoryList,
    getCategory,
    delCategory,
    addCategory,
    updateCategory
  } from "@/api/public/category";

  export default {
    name: "Category",
    data() {
      return {
        restaurantts: [],
        restaurants: [],
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
        // 物料类别表格数据
        categoryList: [],
        // 弹出层标题
        title: "",
        // 是否显示弹出层
        open: false,
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          categoryNumber: null,
          categoryName: null,
          parentCategory: null,
        },
        // 表单参数
        form: {},
        // 表单校验
        rules: {}
      };
    },
    created() {
      this.getList();
    },
    methods: {
      /** 查询物料类别列表 */
      getList() {
        this.loading = true;
        listCategory(this.queryParams).then(response => {
          this.categoryList = response.rows;
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
          categoryId: null,
          categoryNumber: null,
          contractdetailsName: null,
          parentCategory: null,
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
        this.ids = selection.map(item => item.categoryId)
        this.single = selection.length !== 1
        this.multiple = !selection.length
      },
      /** 新增按钮操作 */
      handleAdd() {
        this.reset();
        this.open = true;
        this.title = "添加物料类别";
      },
      /** 修改按钮操作 */
      handleUpdate(row) {
        this.reset();
        const categoryId = row.categoryId || this.ids
        getCategory(categoryId).then(response => {
          this.form = response.data;
          this.open = true;
          this.title = "修改物料类别";
        });
      },
      /** 提交按钮 */
      submitForm() {
        this.$refs["form"].validate(valid => {
          if (valid) {
            if (this.form.categoryId != null) {
              updateCategory(this.form).then(response => {
                this.$modal.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              });
            } else {
              addCategory(this.form).then(response => {
                this.$modal.msgSuccess("新增成功");
                this.open = false;
                this.getList();
              });
            }
          }
        });
      },
      /** 删除按钮操作 */
      handleDelete(row) {
        const categoryIds = row.categoryId || this.ids;
        this.$modal.confirm('是否确认删除物料类别编号为"' + categoryIds + '"的数据项？').then(function() {
          return delCategory(categoryIds);
        }).then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        }).catch(() => {
          this.$modal.msgError("删除失败！物料类别中有商品，请删除物料中的商品在进行删除！！！" );
        });
      },
      //搜索父级ID
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
        var blogtitle=[];
        ParentCategoryList(this.queryParams.parentCategory).then(response=>{

            console.log(response)
            for(let item of response.rows){
              blogtitle.push({"value":item.categoryNumber,"number":item.categoryName})
              // blogtitle.push({})
            }
             this.restaurants = blogtitle;
           console.log(blogtitle)
        })
        
      },
      handleSelect(item) {
        console.log(item);
      },
      handleIconClick(ev) {
        console.log(ev);
      },
      handleBlur(){
        this.loading = true;
        listCategory(this.queryParams).then(response => {
          this.categoryList = response.rows;
          this.total = response.total;
          this.loading = false;
        });
      } ,
      //添加中的父级ID
      querySearchs(queryString, cb) {
        var restaurantts = this.restaurantts;
        var results = queryString ? restaurantts.filter(this.createFilters(queryString)) : restaurantts;
        // 调用 callback 返回建议列表的数据
        cb(results);
      },
      createFilters(queryString) {
        return (restaurant) => {
          return (restaurant.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
        };
      },
      loadAlls() {
        var blogtitle=[];
        ParentCategoryList(this.form.parentCategory).then(response=>{

            console.log(response)
            for(let item of response.rows){
              blogtitle.push({"value":item.categoryNumber,"number":item.categoryName})
            }
             this.restaurantts = blogtitle;
           console.log(blogtitle)
        })
        
      },
      handleSelects(item) {
        console.log(item);
      },
      handleIconClicks(ev) {
        console.log(ev);
      },
    },
    mounted() {
      this.restaurants = this.loadAll();
      this.restaurantts = this.loadAlls();
    }
  };
</script>
