<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="商品名称" prop="goodsName">
        <el-input v-model="queryParams.goodsName" placeholder="请输入商品名称" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="物料分类" porp="categoryId">
        <el-select style="width: 140px;" placeholder="请选分类" prop="categoryId" v-model="queryParams.categoryId"
          clearable>
          <el-option v-for="dict in categoryList" @click.native="selects" :key="dict.categoryId"
            :label="dict.categoryName" :value="dict.categoryId" />
        </el-select>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd"
          v-hasPermi="['public/goods:goods:add']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="success" plain icon="el-icon-edit" size="mini" :disabled="single" @click="handleUpdate"
          v-hasPermi="['public/goods:goods:edit']">修改</el-button>
      </el-col>
      <!--      <el-col :span="1.5">
       <el-button type="danger" plain icon="el-icon-delete" size="mini" :disabled="multiple" @click="handleDelete"
          v-hasPermi="['public/goods:goods:remove']">下架</el-button>
      </el-col>
      </el-switch> -->
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport"
          v-hasPermi="['public/goods:goods:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="goodsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="物料编码" align="center" prop="goodsCode" />
      <el-table-column label="主类别名称" align="center" prop="categoryName" />
      <el-table-column label="物料名称" align="center" prop="goodsName" />
      <el-table-column label="基本计量单位" align="center" prop="goodsType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.goods_unit" :value="scope.row.goodsType" />
        </template>
      </el-table-column>
      <!--      <el-table-column label="规格" align="center" prop="specs" />
      <el-table-column label="型号" align="center" prop="model" />
      <el-table-column label="品牌" align="center" prop="brand" />
      <el-table-column label="重量单位" align="center" prop="weight" /> -->
      <el-table-column label="商品数量" align="center" prop="goodsNumber" />
      <!-- <el-table-column label="体积单位" align="center" prop="volume" /> -->
      <el-table-column label="采购方" align="center" prop="buyer" />
      <!--      <el-table-column label="状态" align="center" prop="state">
       <template slot-scope="scope">
          <span>{{ scope.row.state | parseState }}</span>
        </template>
      </el-table-column> -->
      <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="修改时间" align="center" prop="updateTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.updateTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <!-- <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
            v-hasPermi="['public/goods:goods:edit']">修改</el-button> -->
          <!-- <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
            v-hasPermi="['public/goods:goods:remove']">下架</el-button> -->
          <el-switch v-model="scope.row.state" :active-value="0" inactive-value="1" @change="handleDelete(scope.row)">
          </el-switch>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
      @pagination="getList" />

    <!-- 添加或修改物料对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="600px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="类别选择" prop="categoryId">
          <el-cascader v-model="value" :options="options" @change="handleChange"></el-cascader>
          <!-- <el-input v-model="form.categoryId" placeholder="请输入类别ID" /> -->
          <!-- <el-cascader :props="props"></el-cascader> -->
        </el-form-item>
        <el-form-item label="商品名称" prop="goodsName">
          <el-input v-model="form.goodsName" placeholder="请输入商品名称" />
        </el-form-item>
        <el-form-item label="计量单位" prop="goodsType">
          <el-select v-model="form.goodsType" placeholder="请选择计量单位">
            <el-option v-for="dict in dict.type.goods_unit" :key="dict.value" :label="dict.label"
              :value="parseInt(dict.value)"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="规格" prop="specs">
          <el-input v-model="form.specs" placeholder="请输入规格" />
        </el-form-item>
        <el-form-item label="型号" prop="model">
          <el-input v-model="form.model" placeholder="请输入型号" />
        </el-form-item>
        <el-form-item label="品牌" prop="brand">
          <el-input v-model="form.brand" placeholder="请输入品牌" />
        </el-form-item>
        <el-form-item label="重量单位" prop="weight">
          <el-input v-model="form.weight" placeholder="请输入重量单位" />
        </el-form-item>
        <el-form-item label="商品数量" prop="goodsNumber">
          <el-input v-model="form.goodsNumber" placeholder="请输入商品数量" />
        </el-form-item>
        <el-form-item label="体积单位" prop="volume">
          <el-input v-model="form.volume" placeholder="请输入体积单位" />
        </el-form-item>
        <el-form-item label="采购方" prop="buyer">
          <el-input v-model="form.buyer" value="远志集团有限公司" />
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
    listGoods,
    getGoods,
    delGoods,
    addGoods,
    updateGoods,
    findCategoryList
  } from "@/api/public/goods";
  import {
    listCategory,
    ParentCategoryList,
    getCategory,
    delCategory,
    addCategory,
    updateCategory
  } from "@/api/public/category";

  export default {
    name: "Goods",
    dicts: ['goods_unit'],
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
        // 物料表格数据
        goodsList: [],
        // 弹出层标题
        title: "",
        // 是否显示弹出层
        open: false,
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          categoryId:null,
          goodsName: null,
        },
        // 表单参数
        form: {},
        // 表单校验
        rules: {
          planName: [{
            categoryId: true,
            message: '字段值不可为空',
          }],
          goodsName: [{
            required: true,
            message: '字段值不可为空',
          }],
          goodsType: [{
            required: true,
            message: '字段值不可为空',
          }],
          goodsNumber: [{
            required: true,
            message: '字段值不可为空',
          }],
        },
        value: [],
        //类别选择
        options: [],
        props: {
          lazy: true,
          lazyLoad(node, resolve) {
            const {
              level
            } = node;
            setTimeout(() => {
              const nodes = Array.from({
                  length: level + 1
                })
                .map(item => ({
                  value: ++id,
                  label: `选项${id}`,
                  leaf: level >= 2
                }));
              // 通过调用resolve将子节点数据返回，通知组件数据加载完成
              resolve(nodes);
            }, 1000);
          }
        }
      };
    },
    created() {
      this.getList();
      this.findCategoryList();
      listCategory(null).then(response => {
        this.categoryList = response.rows;
      });
    },
    // filters: {
    //   parseState(value) {
    //     if (value == 0) {
    //       return '上架';
    //     } else if (value == 1) {
    //       return '下架';
    //     }
    //   }
    // },
    methods: {
      handleChange(value) {
        console.log("handleChange:", value);
        this.form.categoryId = value[1]
      },
      /** 查询物料列表 */
      getList() {
        this.loading = true;
        listGoods(this.queryParams).then(response => {
          this.goodsList = response.rows;
          this.total = response.total;
          this.loading = false;
        });
      },
      findCategoryList() {
        findCategoryList().then(response => {
          console.log("findCategoryList:", response)
          response.data.forEach(item => {
            let data = {
              value: item.categoryId,
              label: item.categoryName,
            }
            if (item.list != null) {
              let children = []
              item.list.forEach(item => {
                children.push({
                  value: item.categoryId,
                  label: item.categoryName
                })
              })
              data.children = children
              children = []
            }
            this.options.push(data)
          })
          console.log("111:", this.options)
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
          goodsId: null,
          goodsCode: null,
          categoryId: null,
          goodsName: null,
          goodsType: null,
          specs: null,
          model: null,
          brand: null,
          weight: null,
          goodsNumber: null,
          volume: null,
          buyer: '远志集团有限公司',
          state: null,
          createBy: null,
          createTime: null,
          updateBy: null,
          updateTime: null
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
        this.ids = selection.map(item => item.goodsId)
        this.single = selection.length !== 1
        this.multiple = !selection.length
      },
      /** 新增按钮操作 */
      handleAdd() {
        this.reset();
        this.open = true;
        this.title = "添加物料";
      },
      /** 修改按钮操作 */
      handleUpdate(row) {
        this.reset();
        const goodsId = row.goodsId || this.ids
        getGoods(goodsId).then(response => {
          this.form = response.data;
          this.open = true;
          this.title = "修改物料";
        });
      },
      /** 提交按钮 */
      submitForm() {
        this.$refs["form"].validate(valid => {
          if (valid) {
            if (this.form.goodsId != null) {
              updateGoods(this.form).then(response => {
                this.$modal.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              });
            } else {
              addGoods(this.form).then(response => {
                this.$modal.msgSuccess("新增成功");
                this.open = false;
                this.getList();
              });
            }
          }
        });
      },
      /** 下架按钮操作 */
      handleDelete(row) {
        const goodsIds = row.goodsId || this.ids;
        const state = row.state || this.states;
        if (row.state == 1) {
          this.$modal.confirm('是否确认下架物料编号为"' + goodsIds + '"的数据项？').then(function() {
            return delGoods(goodsIds);
          }).then(() => {
            this.getList();
            this.$modal.msgSuccess("下架成功");
          }).catch(() => {});
        } else {
          this.$modal.confirm('是否确认上架物料编号为"' + goodsIds + '"的数据项？').then(function() {
            return delGoods(goodsIds);
          }).then(() => {
            this.getList();
            this.$modal.msgSuccess("上架成功");
          }).catch(() => {});
        }

      },
      /** 导出按钮操作 */
      handleExport() {
        this.download('public/goods/export', {
          ...this.queryParams
        }, `goods_${new Date().getTime()}.xlsx`)
      }
    }
  };
</script>
<style rel="stylesheet/scss" lang="scss">
  .el-input {
    width: auto;
  }
</style>
