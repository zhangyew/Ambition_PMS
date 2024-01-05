<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="100px">
      <el-form-item label="合同编号" prop="contractdetailsNumber">
        <el-input v-model="queryParams.contractdetailsNumber" placeholder="请输入合同编号" clearable
          @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="合同名称" prop="contractdetailsName">
        <el-input v-model="queryParams.contractdetailsName" placeholder="请输入合同名称" clearable
          @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="合同状态" prop="contractdetailsState">
        <el-select v-model="queryParams.contractdetailsState" placeholder="请输入合同状态">
          <el-option v-for="dict in dict.type.contractdetails_state" :key="dict.value" :label="dict.label"
            :value="parseInt (dict.value)"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="供应商名称" prop="abbreviated">
        <el-autocomplete popper-class="my-autocomplete" v-model="queryParams.abbreviated"
          :fetch-suggestions="querySearch" placeholder="请输入内容" @select="handleSelect">
          <i class="el-icon-search el-input__icon" slot="suffix" @click="handleIconClick"></i>
          <template slot-scope="{ item }">

            <label class="addr">{{ item.number }}</label>
            <label class="name">{{ item.value }}</label>
          </template>
        </el-autocomplete>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
        <!-- <el-button
          type="primary"
          round
          v-print="printContent"
        >打印 </el-button> -->
      </el-form-item>
    </el-form>
    <div
      style="background-color: white;width: 303px;height: 77px; box-shadow: 10px 10px 6px 1px rgba(79, 78, 78, 0.12);float: left;margin: 4px 20px 20px 32px;">
      <h3 style="line-height: 0px;padding: 8px 0px 0px 29px;font-weight: 300;">合同总数</h3>
      <span style="padding: 0px 0px 0px 29px;font-size: 20px;color: rgb(102, 102, 102);">{{ ContractCount }}</span>
    </div>
    <div
      style="background-color: white;width: 303px;height: 77px; box-shadow: 10px 10px 6px 1px rgba(79, 78, 78, 0.12);float: left;margin: 4px 20px 20px 32px;">
      <h3 style="line-height: 0px;padding: 8px 0px 0px 29px;font-weight: 300;">合同金额</h3>
      <span style="padding: 0px 0px 0px 29px;font-size: 20px;color: rgb(102, 102, 102);">{{ ContractSum }}</span>
    </div>
    <el-table v-loading="loading" :data="contractdetailsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="相关项目" align="center" prop="tenderProjectsName" />
      <el-table-column label="合同名称" align="center" prop="contractdetailsName">
        <template slot-scope="scope">
          <el-button size="mini" type="text"
            @click="handleShow(scope.row.contractdetailsId,scope.row.contractdetailsPaymentId,scope.row.tenderProjectsId,scope.row.vendorId)">
            {{ scope.row.contractdetailsName }}</el-button>
        </template>
      </el-table-column>
      <el-table-column label="合同编号" align="center" prop="contractdetailsNumber" width="180" />
      <el-table-column label="供应商名称" align="center" prop="abbreviated" />
      <el-table-column label="负责人" align="center" prop="applicant" />
      <el-table-column label="签订日期" align="center" prop="openTime">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.openTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="合同总金额" align="center" prop="contractdetailsAmount" />
      <el-table-column label="合同状态" align="center" prop="contractdetailsState">
        <template slot-scope="scope">
          <span
            :class="getContractStateColor(scope.row.contractdetailsState)">{{ scope.row.contractdetailsState | con_state }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">

          <!-- <el-button size="mini" type="text" icon="el-icon-folder"
            @click="handleShow(scope.row.contractdetailsId,scope.row.contractdetailsPaymentId,scope.row.tenderProjectsId,scope.row.vendorId)">查看详情</el-button> -->
          <el-button v-if="[0,1,2,3,4].includes(scope.row.contractdetailsState)" size="mini" type="text"
            icon="el-icon-s-check" class="btn btn-default"
            @click="handleExamine(scope.row) , drawer=true">审批</el-button>&nbsp;&nbsp;&nbsp;&nbsp;
          <router-link class="link-type"
            :to="{name:'info1',params:{ resource: '2',cid:''+scope.row.contractdetailsId }}">
            <el-button v-if="scope.row.contractdetailsState == 4" size="mini" type="text" icon="el-icon-printer"
              class="btn btn-default">生成采购订单</el-button>
          </router-link>
          <!-- <el-button v-if="[0,1,2,3,4].includes(scope.row.contractdetailsState)" size="mini" type="text"
            icon="el-icon-s-check" class="btn btn-default" @click="drawer = true">审批</el-button> -->
          <!-- 审批对话框 -->
          <el-drawer title="合同审批" :visible.sync="drawer" direction="ttb">
            <el-form ref="forms" :model="forms" label-width="150px" style="margin: 0 auto; width: 600px;">
              <el-form-item label="审批状态" prop="contractdetailsState" style="width: 400px;">
                <el-select v-model="forms.contractdetailsState" placeholder="请确定审批结果!">
                  <el-option v-for="dict in dict.type.contractdetails_state" :key="dict.value" :label="dict.label"
                    :value="parseInt(dict.value)"></el-option>
                </el-select>
              </el-form-item>

              <!-- <el-form-item
                label="审批意见"
                style="width: 400px;"
              >
                <input
                  type="textarea"
                  style="width: 600px;"
                />
              </el-form-item> -->
              <div class="dialog-footer">
                <el-button type="primary" @click="examine" size="small">确 定</el-button>
                <!-- <el-button @click="cancel" size="small">取 消</el-button> -->
              </div>
            </el-form>
          </el-drawer>
        </template>
      </el-table-column>
    </el-table>
    <pagination v-show="total>0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
      @pagination="getList" />

    <!--//需要打印的页面-->
    <div id="printDiv" class="table-box" style="display: none;">
      <div class="boxs">
        <div class="top">
          <div id="top_img" style="width: 100px; float: left">
            <img src="@/assets/logo/logo2.jpg" alt="donate" height="100px" width="230px" />
          </div>
          <!-- <h1> 合同申请表</h1> -->
          <h1> {{formDatas.contractdetailsType}}合同申请表</h1>
        </div>
        <div class="unit">
          <span>合同名称:
            {{ }}
          </span>
          <span>合同编号: XXX</span>
        </div>
        <div>
          <h2>采购合同书细则</h2>
          <p>双方根据《中华人民共和国合同法》、《民法通则》等有关法律﹐经双方协商达成以下协议条款︰
            双方根据“中华人民共和国合同法”、“民法通则”等有关法律，经双方协商达成以下协议条款：
          </p>
          <h3>第一条·合同标的及费用</h3>
          <ul>
            <li>1八合同交付内容︰产品相关内容详见《采购清单》
            </li>
            <li>2·合同金额︰合同价格为人民币<span></span>（含税）</li>
            <li>3·合同标的物信息︰</li>
          </ul>
          <el-form :model="formDatas" ref="vForm" label-position="left" label-width="100%" size="medium"
            @submit.native.prevent>
            <div style="
              height: 50px;
              background-color: rgb(250, 250, 253);
              border-left: 3px rgb(45, 183, 245) solid;
            ">
              <h3 style="padding: 15px; font-weight: 600">合同物料信息</h3>
            </div>
            <el-row style="margin:20px 10px">
              <el-table :data="DemandList" :row-class-name="rowClassName" ref="tb">
                <el-table-column type="selection" width="100" align="center" />
                <el-table-column label="序号" align="center" prop="xh" width="100" />
                <el-table-column align="center" label="物料编码" width="220">
                  <template slot-scope="scope">
                    <el-input type="text" :value="scope.row.publicGoods.goodsCode" :readonly="true">
                      <i slot="suffix" class="el-input__icon el-icon-search"></i>
                    </el-input>
                  </template>
                </el-table-column>
                <el-table-column label="物料名称" align="center" prop="goodsName" width="160">
                  <template slot-scope="scope">
                    <el-input type="text" :value="scope.row.publicGoods.goodsName" :readonly="true">
                    </el-input>
                  </template>

                </el-table-column>
                <el-table-column label="物料品类" align="center" prop="categoryName" width="170">
                  <template slot-scope="scope">
                    <el-input type="text" :value="scope.row.publicCategory.categoryName" :readonly="true">
                    </el-input>
                  </template>
                </el-table-column>
                <el-table-column label="物料单位" align="center" width="120">
                  <template slot-scope="scope">
                    <dict-tag :disabled="true" :options="dict.type.goods_unit"
                      :value="scope.row.bidTenderManifest.manifestTypeId" />
                  </template>
                </el-table-column>
                <el-table-column label="需求数量" align="center" width="120" prop="demand_count">
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.bidTenderManifest.explains" :readonly="true" />
                  </template>
                </el-table-column>
                <el-table-column label="预算单价" align="center" width="120" prop="budget_amount">
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.bidTenderManifest.price" :readonly="true" />
                  </template>
                </el-table-column>
                <el-table-column label="行预算金额" align="center" width="120">
                  <!-- 计算出来 -->
                  <template slot-scope="scope" v-model="scope.row.bidTenderManifest.prices">
                    <!-- <el-input  /> -->
                    {{scope.row.bidTenderManifest.prices | formattedAmount }}
                  </template>
                </el-table-column>
                <el-table-column label="备注" align="center" prop="remark" width="150">
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.bidTenderManifest.remark" :readonly="true" />
                  </template>
                </el-table-column>
              </el-table>
            </el-row>
            <h3>第二条·质量标准</h3>
            <ul>
              <li>本合同第一条中所列产品的质量技术标准应同时符合如下要求︰</li>
              <li>1﹑符合现行的国家﹑行业及上海市有关质量技术标准。</li>
              <li>2、以经甲方签字确认的图纸为准。</li>
              <li>3、乙方承认其所提供的服务不存在任何瑕疵和缺陷。</li>
            </ul>
            <h3>第三条·包装标准·包装物的供应与回收

            </h3>
            <ul>
              <li>1﹑产品包装应符合甲方要求﹐由于包装不善导致产品在运输过程中的损失
                由乙方承担。产品包装物的供应与回收由乙方负责。</li>
              <li>2﹑乙方承诺产品配件﹑备件和工具（若有）按照必备的数量提供给甲方。若发生短缺或质量问题﹐由乙方负责解决。</li>
            </ul>
            <h3>第四条·验收及异议的提出</h3>
            <ul>
              <li>1﹑卖方按约定时间将货物运送到合同制定交货地点后﹐买卖双方应对共同
                对货物进行开箱检验﹐共同根据卖方提供的装箱单或清单检查货物的数量。卖
                方应派其人员参加开箱检验﹐费用自理。卖方拒绝或未参加检验的﹐买方有权
                单独进行检验﹐对检验结果视为卖方自动接收。</li>
            </ul>
            <h3>第五条·乙方对产品质量的承诺·质保期与售后服务</h3>
            <ul>
              <li>1、乙方承诺其所提供的产品及服务不存在任何瑕疵和缺陷。</li>
              <li>2·乙方承诺对本合同中的产品提供终身维修服务和3年质保期（自甲方书</li>
            </ul>
            <div style="
              height: 50px;
              background-color: rgb(250, 250, 253);
              border-left: 3px rgb(45, 183, 245) solid;
            ">
              <h3 style="padding: 15px; font-weight: 600">签署执行状态</h3>
            </div>
            <el-row style="margin-top: 15px">
              <el-col :span="12" class="grid-cell" style="padding: 0px 0px 0px 35px;">
                <el-form-item label="签署方数" prop="signatoriesNumber" class="required">
                  <el-select v-model="formDatas.signatoriesNumber" class="full-width-input" clearable
                    style="width: 150px;" disabled="disabled">
                    <el-option v-for="(item, index) in option_signatories" :key="index" :label="item.label"
                      :value="item.value" :disabled="item.disabled"></el-option>
                  </el-select>
                </el-form-item>
                <el-form-item label="乙方供应商" prop="abbreviated" class="required">
                  <el-input v-model="formDatas.abbreviated" type="text" clearable style="width: 150px;"
                    :readonly="true"></el-input>
                  <img src="@/assets/images/qxbicon.png" title="查看资信" style="cursor:pointer;margin-left:10px;">
                </el-form-item>
                <el-form-item label="乙方联系人" prop="signingContact" class="required">
                  <el-input v-model="formDatas.signingContact" type="text" clearable style="width: 150px;"
                    :readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="乙方开户行" prop="signingBank" class="required">
                  <el-input v-model="formDatas.signingBank" type="text" clearable style="width: 150px;"
                    :readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="合同方金额" prop="sigingAmount" class="required">
                  <el-input v-model="formDatas.sigingAmount" type="text" clearable style="width: 150px;"
                    :readonly="true"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12" class="grid-cell">
                <el-form-item label="我方主体" prop="signingSubject">
                  <el-input v-model="formDatas.signingSubject" type="text" clearable style="width: 150px;"
                    :readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="乙方供应商公司地址" prop="signingAddress">
                  <el-input v-model="formDatas.signingAddress" type="text" clearable style="width: 150px;"
                    :readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="乙方联系方式" prop="signingContactMode">
                  <el-input v-model="formDatas.signingContactMode" type="text" clearable style="width: 150px;"
                    :readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="乙方开户行账号" prop="signingBankAccount">
                  <el-input v-model="formDatas.signingBankAccount" type="text" clearable style="width: 150px;"
                    :readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="币别" prop="currency">
                  <el-input v-model="formDatas.currency" type="text" clearable style="width: 150px;"
                    :readonly="true"></el-input>
                </el-form-item>
              </el-col>
            </el-row>

          </el-form>
        </div>

      </div>
    </div>
    <!-- 合同详情对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="90%" append-to-body style="height: auto;">
      <div class="boxs">
        <div class="top">
          <div id="top_img" style="width: 100px; float: left">
            <img src="@/assets/logo/logo2.jpg" alt="donate" height="100px" width="230px" />
          </div>
          <div style="float: left;display: block;">
            <h1> {{formDatas.contractdetailsType}}合同申请表</h1>
          </div>
          <!-- <h1> 合同申请表</h1> -->

          <div style="float: left;padding: 81px 0px 0px 200px;">
            <el-button type="primary" round v-print="printContent">打印 </el-button>
          </div>

        </div>
        <div class="section_bos">
          <div style="height: 50px; background-color: rgb(250, 250, 253);border-left: 3px rgb(45, 183, 245) solid;">
            <h3 style="padding: 15px; font-weight: 600">合同申请信息</h3>
          </div>
          <el-form :model="formDatas" ref="vForm" label-position="left" label-width="150px" size="medium"
            @submit.native.prevent>
            <el-row style="margin-top: 15px">
              <el-col :span="12" class="grid-cell" style="padding: 0px 0px 0px 95px;">
                <el-form-item label="申请人" prop="applicant" class="required">
                  <el-input v-model="formDatas.applicant" type="text" clearable style="width: 300px;"
                    :readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="申请部门" prop="contractSector" class="required">
                  <el-input v-model="formDatas.contractSector" type="text" clearable style="width: 300px;"
                    :readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="项目相关合同" prop="contractProjectRelated">
                  <el-select v-model="formDatas.contractProjectRelated" class="full-width-input" clearable
                    style="width: 300px;" disabled="disabled">
                    <el-option v-for="(item, index) in option_projets" :key="index" :label="item.label"
                      :value="item.value" :disabled="item.disabled"></el-option>
                  </el-select>
                </el-form-item>
                <el-form-item label="是否主子合同" prop="contractMaster">
                  <el-radio-group v-model="formDatas.contractMaster" :disabled="true">
                    <el-radio :label="1">否</el-radio>
                    <el-radio :label="2">是</el-radio>
                  </el-radio-group>
                </el-form-item>
                <el-form-item label="项目总预算" prop="contractTotalBudget" class="required">
                  <el-input v-model="formDatas.contractTotalBudget" type="text" clearable style="width: 300px;"
                    :readonly="true"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12" class="grid-cell">
                <el-form-item label="申请时间" prop="applicantTime">
                  <el-date-picker v-model="formDatas.applicantTime" type="date" class="full-width-input"
                    format="yyyy-MM-dd" value-format="yyyy-MM-dd" clearable style="width: 300px;"
                    :readonly="true"></el-date-picker>
                </el-form-item>
                <el-form-item label="申请公司" prop="firm" class="required">
                  <el-input v-model="formDatas.firm" type="text" clearable style="width: 300px;"
                    :readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="相关项目" prop="tenderProjectsName">
                  <el-input v-model="formDatas.tenderProjectsName" type="text" clearable style="width: 300px;"
                    :readonly="true" :disabled="formDatas.contractProjectRelated === 1"></el-input>
                </el-form-item>
                <el-form-item label="关联主合同" prop="contractPrimeId">
                  <el-input v-model="formDatas.contractPrimeId" type="text" clearable style="width: 300px;"
                    :readonly="true" :disabled="formDatas.contractMaster === 1"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <div style="
              height: 50px;
              background-color: rgb(250, 250, 253);
              border-left: 3px rgb(45, 183, 245) solid;
            ">
              <h3 style="padding: 15px; font-weight: 600">合同基本信息</h3>
            </div>
            <el-row style="margin-top: 15px">
              <el-col :span="12" class="grid-cell" style="padding: 0px 0px 0px 95px;">
                <el-form-item label="合同名称" prop="contractdetailsName">
                  <el-input v-model="formDatas.contractdetailsName" type="text" clearable :readonly="true"
                    style="width: 300px;"></el-input>
                </el-form-item>
                <el-form-item label="合同类型" prop="contractdetailsType">
                  <el-input id="cd_type" v-model="formDatas.contractdetailsType" type="text" clearable :readonly="true"
                    style="width: 300px;"></el-input>
                </el-form-item>
                <el-form-item label="开启时间" prop="openTime">
                  <el-date-picker :editable="false" v-model="formDatas.openTime" type="date" class="full-width-input"
                    format="yyyy-MM-dd" value-format="yyyy-MM-dd" clearable style="width: 300px;"
                    :readonly="true"></el-date-picker>
                </el-form-item>
                <el-form-item label="合同金额" prop="contractdetailsAmount">
                  <el-input v-model="formDatas.contractdetailsAmount" :readonly="true" type="text"
                    style="width: 300px;"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12" class="grid-cell">
                <el-form-item label="合同编号" prop="contractdetailsNumber">
                  <el-input v-model="formDatas.contractdetailsNumber" :readonly="true" type="text" clearable
                    style="width: 300px;"></el-input>
                </el-form-item>
                <el-form-item label="密级" prop="contractdetailsLevel">
                  <el-radio-group v-model="formDatas.contractdetailsLevel" :disabled="true">
                    <el-radio :label="0">密级</el-radio>
                    <el-radio :label="1">非密</el-radio>
                  </el-radio-group>
                </el-form-item>
                <el-form-item label="结束时间" prop="bidEnd">
                  <el-date-picker :editable="false" v-model="formDatas.bidEnd" type="date" class="full-width-input"
                    format="yyyy-MM-dd" value-format="yyyy-MM-dd" clearable style="width: 300px;"
                    :readonly="true"></el-date-picker>
                </el-form-item>
              </el-col>
              <el-col :span="24" class="grid-cell" style="padding: 0px 0px 0px 95px;">
                <el-form-item label="合同情况说明" prop="illustrate">
                  <el-input type="textarea" v-model="formDatas.illustrate" style="width: 1000px;"
                    :readonly="true"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <div style="
              height: 50px;
              background-color: rgb(250, 250, 253);
              border-left: 3px rgb(45, 183, 245) solid;
            ">
              <h3 style="padding: 15px; font-weight: 600">采购方式</h3>
            </div>
            <el-row style="margin-top: 15px">
              <el-col :span="12" class="grid-cell" style="padding: 0px 0px 0px 95px;">
                <el-form-item label="采购方式" prop="procurementMethod">
                  <el-select v-model="formDatas.procurementMethod" clearable style="width: 300px;" disabled="disabled">
                    <el-option v-for="(item, index) in procurementMethodptions" :key="index" :label="item.label"
                      :value="item.value" :disabled="item.disabled"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
            <!--  <el-col :span="12" class="grid-cell">
                <el-form-item label="采购清单" prop="planName">
                  <el-input v-model="formDatas.planName" :readonly="true" type="text" clearable
                    style="width: 300px;"></el-input>
                </el-form-item>
              </el-col> -->
            </el-row>
            <div style="
              height: 50px;
              background-color: rgb(250, 250, 253);
              border-left: 3px rgb(45, 183, 245) solid;
            ">
              <h3 style="padding: 15px; font-weight: 600">合同物料信息</h3>
            </div>
            <el-row style="margin:20px 10px">

              <el-table :data="DemandList" :row-class-name="rowClassName" ref="tb">
                <el-table-column type="selection" width="100" align="center" />
                <el-table-column label="序号" align="center" prop="xh" width="100" />
                <el-table-column align="center" label="物料编码" width="220">
                  <template slot-scope="scope">
                    <el-input type="text" :value="scope.row.publicGoods.goodsCode" :readonly="true">
                      <i slot="suffix" class="el-input__icon el-icon-search"></i>
                    </el-input>
                  </template>
                </el-table-column>
                <el-table-column label="物料名称" align="center" prop="goodsName" width="160">
                  <template slot-scope="scope">
                    <el-input type="text" :value="scope.row.publicGoods.goodsName" :readonly="true">
                    </el-input>
                  </template>

                </el-table-column>
                <el-table-column label="物料品类" align="center" prop="categoryName" width="170">
                  <template slot-scope="scope">
                    <el-input type="text" :value="scope.row.publicCategory.categoryName" :readonly="true">
                    </el-input>
                  </template>
                </el-table-column>
                <el-table-column label="物料单位" align="center" width="120">
                  <template slot-scope="scope">
                    <dict-tag :disabled="true" :options="dict.type.goods_unit"
                      :value="scope.row.bidTenderManifest.manifestTypeId" />
                  </template>
                </el-table-column>
                <el-table-column label="需求数量" align="center" width="120" prop="demand_count">
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.bidTenderManifest.explains" :readonly="true" />
                  </template>
                </el-table-column>
                <el-table-column label="预算单价" align="center" width="120" prop="budget_amount">
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.bidTenderManifest.price" :readonly="true" />
                  </template>
                </el-table-column>
                <el-table-column label="行预算金额" align="center" width="120">
                  <!-- 计算出来 -->
                  <template slot-scope="scope" v-model="scope.row.bidTenderManifest.prices">
                    <!-- <el-input  /> -->
                    {{scope.row.bidTenderManifest.prices | formattedAmount }}
                  </template>
                </el-table-column>
                <el-table-column label="备注" align="center" prop="remark" width="150">
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.bidTenderManifest.remark" :readonly="true" />
                  </template>
                </el-table-column>
              </el-table>
            </el-row>
            <div style="
              height: 50px;
              background-color: rgb(250, 250, 253);
              border-left: 3px rgb(45, 183, 245) solid;
            ">
              <h3 style="padding: 15px; font-weight: 600">合同付款约定</h3>
            </div>
            <el-row style="margin: 20px 10px">
              <el-table :data="payMentList" :row-class-name="rowClassName" ref="tb">
                <el-table-column type="selection" width="100" align="center" />
                <el-table-column label="序号" align="center" prop="xh" width="100"></el-table-column>
                <el-table-column label="款项内容" align="center" width="200" prop="sjfw">
                  <template slot-scope="scope">
                    <el-select v-model="scope.row.content" placeholder="请选择款项内容" :disabled="true">
                      <el-option :disabled="true" v-for="dict in dict.type.content" :key="dict.value"
                        :label="dict.label" :value="parseInt(dict.value)"></el-option>
                    </el-select>
                  </template>
                </el-table-column>
                <el-table-column label="付款日期" align="center" prop="payTime" width="200"></el-table-column>
                <el-table-column label="付款单位" align="center" prop="unit" width="160">
                </el-table-column>
                <el-table-column label="收款合同方" align="center" prop="paymentVendorId" width="160">
                  <template slot-scope="scope">
                    <el-input v-model="scope.row.publicVendor.abbreviated" :readonly="true"></el-input>
                  </template>
                </el-table-column>
                <el-table-column label="付款条件" align="center" prop="terms" width="170">
                </el-table-column>
                <el-table-column label="付款金额" align="center" prop="sum" width="160">
                </el-table-column>
                <el-table-column label="违约责任" align="center" prop="duty" width="170">
                </el-table-column>
              </el-table>

            </el-row>
            <div style="
              height: 50px;
              background-color: rgb(250, 250, 253);
              border-left: 3px rgb(45, 183, 245) solid;
            ">
              <h3 style="padding: 15px; font-weight: 600">签署执行状态</h3>
            </div>
            <el-row style="margin-top: 15px">
              <el-col :span="12" class="grid-cell" style="padding: 0px 0px 0px 95px;">
                <el-form-item label="签署方数" prop="signatoriesNumber" class="required">
                  <el-select v-model="formDatas.signatoriesNumber" class="full-width-input" clearable
                    style="width: 300px;" disabled="disabled">
                    <el-option v-for="(item, index) in option_signatories" :key="index" :label="item.label"
                      :value="item.value" :disabled="item.disabled"></el-option>
                  </el-select>
                </el-form-item>
                <el-form-item label="乙方供应商" prop="abbreviated" class="required">
                  <el-input v-model="formDatas.abbreviated" type="text" clearable style="width: 300px;"
                    :readonly="true"></el-input>
                  <img src="@/assets/images/qxbicon.png" title="查看资信" style="cursor:pointer;margin-left:10px;">
                </el-form-item>
                <el-form-item label="乙方联系人" prop="signingContact" class="required">
                  <el-input v-model="formDatas.signingContact" type="text" clearable style="width: 300px;"
                    :readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="乙方开户行" prop="signingBank" class="required">
                  <el-input v-model="formDatas.signingBank" type="text" clearable style="width: 300px;"
                    :readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="合同方金额" prop="sigingAmount" class="required">
                  <el-input v-model="formDatas.sigingAmount" type="text" clearable style="width: 300px;"
                    :readonly="true"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12" class="grid-cell">
                <el-form-item label="我方主体" prop="signingSubject">
                  <el-input v-model="formDatas.signingSubject" type="text" clearable style="width: 300px;"
                    :readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="乙方供应商公司地址" prop="signingAddress">
                  <el-input v-model="formDatas.signingAddress" type="text" clearable style="width: 300px;"
                    :readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="乙方联系方式" prop="signingContactMode">
                  <el-input v-model="formDatas.signingContactMode" type="text" clearable style="width: 300px;"
                    :readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="乙方开户行账号" prop="signingBankAccount">
                  <el-input v-model="formDatas.signingBankAccount" type="text" clearable style="width: 300px;"
                    :readonly="true"></el-input>
                </el-form-item>
                <el-form-item label="币别" prop="currency">
                  <el-input v-model="formDatas.currency" type="text" clearable style="width: 300px;"
                    :readonly="true"></el-input>
                </el-form-item>
              </el-col>
            </el-row>

          </el-form>

        </div>
      </div>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {
  listContractdetails,
  listVendor,
  ContractSumList,
  ContractCountList,
  getContractdetails,
  updateContractdetails , Shows
} from "@/api/bidding/contractdetails";
import { getPayment } from "@/api/public/payment";
import { SHowsProjectRelatedItems } from "@/api/bidding/tender_projects";

  export default {
    name: "Contractdetails",
    dicts: ["contractdetails_state", "content", "goods_unit"],
    data() {
      return {
        forms: {},
        drawer: false,
        printContent: {
          id: "printDiv",
          // preview: true, // 预览工具是否启用
          // previewTitle: "储能服务费结算单", // 预览页面的标题
          popTitle: "", // 打印页面的页眉
          extraCss: "https://cdn.bootcdn.net/ajax/libs/animate.css/4.1.1/animate.compat.css, https://cdn.bootcdn.net/ajax/libs/hover.css/2.3.1/css/hover-min.css",
          extraHead: '<meta http-equiv="Content-Language"content="zh-cn"/>',
          previewBeforeOpenCallback() {
            console.log("正在加载预览窗口");
          },
          previewOpenCallback() {
            console.log("已经加载完预览窗口");
          },
          beforeOpenCallback(vue) {
            vue.printLoading = true;
            console.log("打开之前");
          },
          openCallback(vue) {
            vue.printLoading = false;
            console.log("执行了打印");
          },
          closeCallback() {
            console.log("关闭了打印工具");
            var div = document.getElementById("printDiv");
            if (div.style.display === "block") {
              div.style.display = "none";
            } else {
              div.style.display = "block";
            }
          },
          clickMounted(vue) {
            console.log("点击了打印按钮");
            var div = document.getElementById("printDiv");
            if (div.style.display === "none") {
              div.style.display = "block";
            } else {
              div.style.display = "none";
            }
          },
        },
        restaurants: [],
        state: "",
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
        // 合同明细表格数据
        contractdetailsList: [],
        // 弹出层标题
        title: "",
        // 是否显示弹出层
        open: false,
        ContractSum: "",
        ContractCount: "",
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          contractdetailsNumber: null,
          contractdetailsName: null,
          abbreviated: null,
          contractdetailsState: null,
        },
        // 表单参数
        formDatas: {},
        option_projets: [{
            value: 1,
            label: "项目无关合同",
          },
          {
            value: 2,
            label: "项目相关合同",
          },
        ],
        options_master: [{
            label: "否",
            value: 1,
          },
          {
            label: "是",
            value: 2,
          },
        ],
        procurementMethodptions: [{
            value: 1,
            label: "招标",
          },
          {
            value: 2,
            label: "采购计划",
          },
        ],
        option_signatories: [{
            value: 1,
            label: "双方签署",
          },
          {
            value: 2,
            label: "三方签署",
          },
        ],
        //合同付款约定
        payMentList: [],
        //合同物料
        DemandList: [],
      };
    },
    created() {
      this.getList();
      this.getContractSum();
      this.getContractCount();
    },
    filters: {
      con_state(value) {
        if (value === 0) {
          return "解除";
        } else if (value === 1) {
          return "终止";
        } else if (value === 2) {
          return "暂定";
        } else if (value === 3) {
          return "未激活";
        } else if (value === 4) {
          return "履行中";
        } else if (value === 5) {
          return "已完成";
        } else if (value === 6) {
          return "已生成订单";
        }
      },
    },
    methods: {
      /** 查询合同明细列表 */
      getList() {
        this.loading = true;
        listContractdetails(this.queryParams).then((response) => {
          this.contractdetailsList = response.rows;
          this.total = response.total;
          this.loading = false;
          console.log(response);
        });
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
        this.ids = selection.map((item) => item.contractdetailsId);
        this.single = selection.length !== 1;
        this.multiple = !selection.length;
      },
      //合同总金额
      getContractSum() {
        ContractSumList().then((response) => {
          this.ContractSum = response;
          if (this.ContractSum === "") {
            this.ContractSum = "暂无";
          }
        });
      },
      //合同总数量
      getContractCount() {
        ContractCountList().then((response) => {
          this.ContractCount = response;
        });
      }, //审批
      handleExamine(row) {
        console.log(row);
        console.log(row.contractdetailsId);
        Shows(row.contractdetailsId).then((response) => {
          this.forms = response.data;
          console.log(response);
          this.drawer = true;
        });
      },
      examine() {
        this.$refs["forms"].validate((valid) => {
          updateContractdetails(this.forms).then((response) => {
            this.$modal.msgSuccess("审批成功！");
            this.drawer = false;
            this.getList();
          });
        });
      },
      //详情
      handleShow(id, paymentId, tenderProjectsId, vendorId) {
        console.log("查看采购合同的ID：" + id + "\t" + paymentId);
        this.open = true;
        this.title = "采购合同详情";
        getContractdetails(id).then((response) => {
          // console.log(response.data);
          this.formDatas = response.data[0];
          let stateContract = this.formDatas.contractdetailsType;
          if (stateContract === 0) {
            this.formDatas.contractdetailsType = "长期";
          } else if (stateContract === 1) {
            this.formDatas.contractdetailsType = "短期";
          } else if (stateContract === 2) {
            this.formDatas.contractdetailsType = "补充";
          }
        });
        //显示合同付款约定
        let paymentIdArray = paymentId.split(",");
        paymentIdArray.forEach((element) => {
          getPayment(element).then((response) => {
            this.payMentList.push(response.data);
          });
        });
        //显示合同物料信息
        SHowsProjectRelatedItems(tenderProjectsId, vendorId).then((response) => {
          this.DemandList = response.rows;
        });
      },
      //详情取消按钮
      cancel() {
        this.open = false;
      },
      //合同状态框颜色变化
      getContractStateColor(state) {
        if (state === 4) {
          return "blue-span";
        } else if (state === 2) {
          return "orange-span";
        } else if (state === 0) {
          return "red-span";
        } else if (state === 5) {
          return "wc-span";
        }
      },
      //显示所有供应商
      querySearch(queryString, cb) {
        var restaurants = this.restaurants;
        var results = queryString ?
          restaurants.filter(this.createFilter(queryString)) :
          restaurants;
        // 调用 callback 返回建议列表的数据
        cb(results);
      },
      createFilter(queryString) {
        return (restaurant) => {
          return (
            restaurant.value.toLowerCase().indexOf(queryString.toLowerCase()) ===
            0
          );
        };
      },
      loadAll() {
        var blogtitle = [];
        listVendor(this.queryParams.abbreviated).then((response) => {
          for (let item of response.rows) {
            blogtitle.push({
              value: item.abbreviated,
              number: item.vendorNumber,
            });
          }
          this.restaurants = blogtitle;
        });
      },
      handleSelect(item) {
        console.log(item);
      },
      handleIconClick(ev) {
        console.log(ev);
      },
      rowClassName({
        row,
        rowIndex
      }) {
        row.xh = rowIndex + 1;
      },
    },

    mounted() {
      this.restaurants = this.loadAll();
    },
  };
</script>
<style lang="scss" scoped>
  @page {
    size: auto;
    margin: 0mm;
  }

  .procedure {
    word-wrap: break-word;
  }

  @media print {

    //样式写在这里面
    html,
    body {
      height: inherit;
    }
  }

  .title {
    word-wrap: break-word; //内容不自动换行问题
  }

  .blue-span {
    color: #09f;
    background: #d8edfc;
    border-color: #91cef7;
    padding: 6px 6px 6px 6px;
  }

  .orange-span {
    color: #ff9000;
    background: #fdedd7;
    border-color: #facb8d;
    padding: 6px 6px 6px 6px;
  }

  .red-span {
    color: #ea4335;
    background: #f8d1cd;
    border-color: #f5978e;
    padding: 6px 6px 6px 6px;
  }

  .wc-span {
    color: #f50;
    background: #ffefe8;
    border-color: #fabd9f;
    padding: 6px 6px 6px 6px;
  }

  .my-autocomplete {
    li {
      line-height: normal;
      padding: 7px;

      .name {
        text-overflow: ellipsis;
        overflow: hidden;
      }

      .addr {
        font-size: 12px;
        color: #b4b4b4;
      }

      .highlighted .addr {
        color: #ddd;
      }
    }
  }

  .top {
    width: 100%;
    height: 100px;
    background-color: white;

    h1 {
      float: left;
      margin: 37px;
      margin-left: 550px;
    }
  }
</style>
