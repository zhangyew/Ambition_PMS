<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="目标表单" prop="targets">
        <el-input v-model="queryParams.targets" placeholder="请输入目标表单" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="编号前缀" prop="prefixs">
        <el-input v-model="queryParams.prefixs" placeholder="请输入编号前缀" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <!-- <el-col :span="1.5">
        <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd"
          v-hasPermi="['bidding/rules:rules:add']">新增</el-button>
      </el-col> -->
      <el-col :span="1.5">
        <el-button type="success" plain icon="el-icon-edit" size="mini" :disabled="single" @click="handleUpdate"
          v-hasPermi="['bidding/rules:rules:edit']">修改</el-button>
      </el-col>
    <!--  <el-col :span="1.5">
        <el-button type="danger" plain icon="el-icon-delete" size="mini" :disabled="multiple" @click="handleDelete"
          v-hasPermi="['bidding/rules:rules:remove']">删除</el-button>
      </el-col> -->
    <!--  <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport"
          v-hasPermi="['bidding/rules:rules:export']">导出</el-button>
      </el-col> -->
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="rulesList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="编号规则主键" align="center" prop="codeRulesId" />
      <el-table-column label="目标表单" align="center" prop="targets" />
      <el-table-column label="编号前缀" align="center" prop="prefixs" />
      <el-table-column label="时间规则" align="center" prop="timeRules">
        <template slot-scope="scope">
          <span>{{ scope.row.codingRules ? '-----':scope.row.timeRules }}</span>
        </template>
      </el-table-column>
      <el-table-column label="规则(UUID/Snowflakes)" align="center" prop="codingRules">
        <template slot-scope="scope">
          <span>{{ scope.row.codingRules ? 'Snowflakes':'Time' }}</span>
        </template>
      </el-table-column> />
      <el-table-column label="流水号/总长度" align="center" prop="lengths" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
            v-hasPermi="['bidding/rules:rules:edit']">修改</el-button>
        <!--  <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
            v-hasPermi="['bidding/rules:rules:remove']">删除</el-button> -->
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
      @pagination="getList" />

    <!-- 添加或修改编码规则对话框 -->
    <el-drawer v-bind="$attrs" :title="title" :visible.sync="open" v-on="$listeners" @open="onOpen" @close="onClose"
      :size="size">
      <el-form ref="form" :model="form" :rules="rules" size="medium" label-width="130px">
        <el-row :gutter="13" style="margin: 0 !important;">
          <el-col :span="12">
            <el-form-item label="目标表单" prop="targets">
              <el-input v-model="form.targets" :style="{width: '100%'}">
                <!-- :disabled='true' 开发完成后打开 -->
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="10">
            <el-form-item label="编号前缀" prop="prefixs">
              <el-input v-model="form.prefixs" v-on:input="getClod()" placeholder="请输入编号前缀" :maxlength="6"
                show-word-limit clearable :style="{width: '150px'}"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="编码规则" prop="codingRules">
              <el-radio v-model="form.codingRules" @change="getClod();cz();" :label="0">Time</el-radio>
              <el-radio v-model="form.codingRules" @change="getClod();cz();" :label="1">Sonwflake</el-radio>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item :label="form.codingRules ? '总长度':'流水号'" prop="lengths">
              <el-input-number v-on:input="getClod()" v-model="form.lengths" placeholder="流水号/总长度" step-strictly
                controls-position=right style="width: 150px;"></el-input-number>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter='13' style="margin: 0 !important;" v-if="form.codingRules===0">
          <el-form-item label="时间规则" prop="timeRules">
            <el-checkbox-group v-model="form.timeRules" size="medium">
              <el-checkbox-button @change="getClod()" v-for="(item, index) in timeRulesOptions" :key="index"
                :label="item.value" :data-tid="index" v-if="index<6"
                :disabled="item.disabled">{{item.label}}</el-checkbox-button>
            </el-checkbox-group>
          </el-form-item>
        </el-row>
        <el-row :gutter="13" style="margin: 0 !important;">
          <el-col :span="21">
            <el-form-item label="编号生成规则" prop="rules">
              <el-input v-model="form.rules" readonly></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="21">
            <el-form-item label="编码预览" prop="preview">
              <h4 style="font-size: 20px; font-weight: 700; position: absolute; top: -20px; left: 5px;">{{yl}}</h4>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div style="position: absolute;bottom: 30px;left: 60px;">
        <el-button @click="cancel">取消</el-button>
        <el-button type="primary" @click="submitForm">确定</el-button>
      </div>
    </el-drawer>

  </div>
</template>

<script>
  import {
    listRules,
    getRules,
    delRules,
    addRules,
    updateRules
  } from "@/api/public/rules";

  export default {
    name: "Rules",
    data() {
      return {
        size: '50%',
        // 遮罩层
        loading: true,
        guize: true,
        drawer: false,
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
        // 编码规则表格数据
        rulesList: [],
        // 弹出层标题
        title: "",
        // 是否显示弹出层
        open: false,
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          targets: null,
          prefixs: null,
          timeRules: null,
          codingRules: null,
        },
        yl: '',
        // 表单参数
        //form: {},
        // 表单校验
        rules: {},
        form: {
          targets: null,
          prefixs: null,
          codingRules: 0,
          lengths: 1,
          timeRules: [],
          rules: '',
          preview: '',
        },
        rules: {
          targets: [{
            required: false,
            message: '',
            trigger: 'blur'
          }],
          prefixs: [{
            required: true,
            message: '请输入编号前缀',
            trigger: 'blur'
          }],
          codingRules: [{
            required: true,
            message: '请选择一种编码规则',
            trigger: 'change'
          }],
          lengths: [{
            required: true,
            message: '流水号/总长度',
            trigger: 'blur'
          }],
          timeRules: [{
            required: false,
            type: 'array',
            message: '至少选择一个时间格式',
            trigger: 'blur'
          }],
          rules: [],
          preview: [{
            required: false,
            message: '',
            trigger: 'blur'
          }],
        },
        codingRulesOptions: [{
          "label": "Time",
          "value": 0
        }, {
          "label": "Sonwflake",
          "value": 1
        }],
        timeRulesOptions: [{
          "label": "年 YYYY",
          "value": "YYYY"
        }, {
          "label": "月 MM",
          "value": "MM"
        }, {
          "label": "日 DD",
          "value": "DD"
        }, {
          "label": "时 hh",
          "value": "hh"
        }, {
          "label": "分 mm",
          "value": "mm"
        }, {
          "label": "秒 ss",
          "value": "ss"
        }, {
          "label": "",
          "value": "x"
        }],
      };
    },
    created() {
      this.getList();
    },
    computed: {
      sortedTimeRules() {
        return this.form.timeRules.sort((a, b) => {
          const order = {
            "YYYY": 0,
            "MM": 1,
            "DD": 2,
            "hh": 3,
            "mm": 4,
            "ss": 5
          };
          return order[a] - order[b];
        });
      }
    },
    methods: {
      /** 查询编码规则列表 */
      getList() {
        this.loading = true;
        listRules(this.queryParams).then(response => {
          this.rulesList = response.rows;
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
          // codeRulesId: null,
          targets: null,
          prefixs: null,
          timeRules: [],
          codingRules: 0,
          lengths: 0
        };
        this.resetForm("form");
        this.yl = null;
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
        this.ids = selection.map(item => item.codeRulesId)
        this.single = selection.length !== 1
        this.multiple = !selection.length
      },
      /** 新增按钮操作 */
      handleAdd() {
        this.reset();
        this.open = true;
        this.guize = true;
        this.title = "添加编码规则";
      },
      /** 修改按钮操作 */
      handleUpdate(row) {
        this.reset();
        const codeRulesId = row.codeRulesId || this.ids
        getRules(codeRulesId).then(response => {
          this.form = response.data;
          // debugger
          // if (response.data.codingRules === 0) {
          this.form.timeRules = this.form.timeRules.split(",");
          console.log("0000000")
          // }
          this.open = true;
          this.title = "修改编码规则";
        });
      },
      /** 提交按钮 */
      submitForm() {
        this.$refs["form"].validate(valid => {
          if (valid) {
            this.form.timeRules = this.form.timeRules.join(",");
            if (this.form.codingRules === 1) {
              this.form.timeRules = "x";
            }
            if (this.form.codeRulesId != null) {
              updateRules(this.form).then(response => {
                this.$modal.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              });
            } else {
              addRules(this.form).then(response => {
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
        const codeRulesIds = row.codeRulesId || this.ids;
        this.$modal.confirm('是否确认删除编码规则编号为"' + codeRulesIds + '"的数据项？').then(function() {
          return delRules(codeRulesIds);
        }).then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        }).catch(() => {});
      },
      /** 导出按钮操作 */
      handleExport() {
        this.download('bidding/rules/rules/export', {
          ...this.queryParams
        }, `rules_${new Date().getTime()}.xlsx`)
      },
      onOpen() {},
      onClose() {
        this.$refs['elForm'].resetFields()
      },
      close() {
        this.$emit('update:visible', false)
      },
      handleConfirm() {
        this.$refs['elForm'].validate(valid => {
          if (!valid) return
          this.close()
        })
      },
      cz() {
        this.form.lengths = 0;
        // this.form.timeRules = []
        this.form.rules = "";
        this.yz = "";
      },
      getClod() {
        if (this.form.codingRules === 1) { // 雪花算法
          this.form.rules = this.form.prefixs;
          this.yl = this.form.prefixs;
          console.log("字符串长度:" + this.form.prefixs.length)
          let len = 0;
          if (this.form.lengths > this.form.prefixs.length) {
            len = this.form.lengths - this.form.prefixs.length;
            this.yl += generateRandomNumber(len); // 随机编号
          }
          let xx = '';
          for (var i = 0; i < len; i++) {
            xx += "x";
          }
          this.form.rules += " - " + xx;
        } else if (this.form.codingRules === 0) { // 时间规则
          this.form.rules = this.form.prefixs; // 前缀
          this.yl = this.form.prefixs;
          const sortedRules = this.sortedTimeRules; // 日期规则
          const ruleString = sortedRules.join("");
          this.form.rules += ruleString.replace(",", "");
          this.yl += this.convertToTimeStrings();
          let ls = "";
          for (var i = 1; i < this.form.lengths; i++) {
            ls += "0";
          }
          if (this.form.lengths > 0) ls += "1"
          this.form.rules += ls; //流水号
          this.yl += ls;
        }

      },
      // 获取对应时间
      convertToTimeStrings() {
        const currentDate = new Date();
        const timeStrings = this.form.timeRules.map(rule => {
          let timeValue;
          switch (rule) {
            case "YYYY":
              timeValue = currentDate.getFullYear();
              break;
            case "MM":
              timeValue = currentDate.getMonth() + 1;
              break;
            case "DD":
              timeValue = currentDate.getDate();
              break;
            case "hh":
              timeValue = currentDate.getHours();
              break;
            case "mm":
              timeValue = currentDate.getMinutes();
              break;
            case "ss":
              timeValue = currentDate.getSeconds();
              break;
            default:
              timeValue = "";
          }
          return timeValue.toString().padStart(2, '0'); // 使用padStart方法补足长度
        });
        const timeString = timeStrings.join(""); // 将时间字符串拼接起来
        return timeString;
      }

    }
  }
  // 生成指定长度的随机数
  function generateRandomNumber(length) {
    let result = '';
    const characters = '0123456789';
    const charactersLength = characters.length;
    for (let i = 0; i < length; i++) {
      result += characters.charAt(Math.floor(Math.random() * charactersLength));
    }
    return result;
  }
</script>
