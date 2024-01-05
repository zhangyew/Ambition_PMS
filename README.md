

<h1 align="center" style="margin: 30px 0 30px; font-weight: bold;">远志采购管理系统</h1>
<h2 align="center">主要包含采购管理、招投标管理、合同签订、以及其他基础资料设置</h2>

## 平台简介
<h4 align="center">基于ruoyi-clod微服务框架开发</h4>

远志采购管理系统--基于ruoyi-clod微服务框架二次开发的一款采购平台

* 采用前后端分离的模式，微服务版本前端(基于 [RuoYi-Vue](https://gitee.com/y_project/RuoYi-Vue))。
* 后端采用Spring Boot、Spring Cloud & Alibaba。
* 注册中心、配置中心选型Nacos，权限认证使用Redis。
* 流量控制框架选型Sentinel，分布式事务选型Seata。

#### 联系方式
* phone: 15115020663
* QQ: 2074686624
* Emil: 2074686624@qq.com

## 系统模块

~~~
com.ruoyi     
├── ruoyi-ui              // 前端框架 [80]
├── ruoyi-gateway         // 网关模块 [8080]
├── ruoyi-auth            // 认证中心 [9200]
├── ruoyi-api             // 接口模块
│       └── ruoyi-api-system                          // 系统接口
├── ruoyi-common          // 通用模块
│       └── ruoyi-common-core                         // 核心模块
│       └── ruoyi-common-datascope                    // 权限范围
│       └── ruoyi-common-datasource                   // 多数据源
│       └── ruoyi-common-log                          // 日志记录
│       └── ruoyi-common-redis                        // 缓存服务
│       └── ruoyi-common-seata                        // 分布式事务
│       └── ruoyi-common-security                     // 安全模块
│       └── ruoyi-common-swagger                      // 系统接口
├── ruoyi-modules         // 业务模块
│       └── ruoyi-system                              // 系统模块 [9201]
│       └── ruoyi-gen                                 // 代码生成 [9202]
│       └── ruoyi-job                                 // 定时任务 [9203]
│       └── ruoyi-file                                // 文件服务 [9300]
|       └── yz-bidding                       	      // 招投标服务[9090]
|       └── yz-shopping                        	      // 采购服务[9080]
├── ruoyi-visual          // 图形化管理模块
│       └── ruoyi-visual-monitor                      // 监控中心 [9100]
├──pom.xml                // 公共依赖
~~~

## 业务流程图
![image](https://github.com/zhangyew/Ambition_PMS/assets/103418184/a7faea1a-ae8e-41a9-84a2-c5a806328034)

## 基础功能

1.  采购管理：包含采购主流程、采购需求、采购计划、采购订单 （ruoyi-modules-->yz-shopping）
2.  招投标管理：招投标流程、发布招标项目、招标公告、投标、评标、开标、（ruoyi-modules-->yz-bidding）
3.  合同签订：招标结束后与供应商进行合同签订、合同管理（ruoyi-modules-->yz-shopping）
4.  基础资料管理：包含物品、专家、仓库等等信息录入以及编码规则
5.  采购端页面位于（vue2-UI ---> ambition）
6.  供应商投标端页面位于（vue2-UI ---> vendor）
7.  注：系统其他功能均使用ruoyi-clod框架 http://doc.ruoyi.vip

## 在线体验

演示地址：http://ruoyi.vip  
文档地址：http://doc.ruoyi.vip

## 演示图
![image](https://github.com/zhangyew/Ambition_PMS/assets/103418184/2149c735-becf-4c05-ac02-d5b72352774e)
![image](https://github.com/zhangyew/Ambition_PMS/assets/103418184/f77eacd6-ef79-4697-a4bd-7df7db1cbfad)
![image](https://github.com/zhangyew/Ambition_PMS/assets/103418184/aa709840-f295-402b-81e2-99526b022743)
![image](https://github.com/zhangyew/Ambition_PMS/assets/103418184/f51624c2-0953-41c6-bc8e-0ae1a8971f90)
![image](https://github.com/zhangyew/Ambition_PMS/assets/103418184/e6caa79b-9f07-40c5-af18-0464ac33d12b)
![image](https://github.com/zhangyew/Ambition_PMS/assets/103418184/e0ded410-468c-4776-99e8-bc5706856101)
![image](https://github.com/zhangyew/Ambition_PMS/assets/103418184/6ad38db8-7063-4003-8a7e-69f5f55961f9)
![image](https://github.com/zhangyew/Ambition_PMS/assets/103418184/52c35aa1-ccad-4f43-85f8-6c317f7691a1)
![image](https://github.com/zhangyew/Ambition_PMS/assets/103418184/93d6d252-8dc5-41f7-9cbb-3e1bc2581627)
![image](https://github.com/zhangyew/Ambition_PMS/assets/103418184/25ff5927-70ab-42ad-97e2-24d06bc359e1)
![image](https://github.com/zhangyew/Ambition_PMS/assets/103418184/f5c5f81b-f8c5-4aea-b9a4-6cbf370e98b2)
![image](https://github.com/zhangyew/Ambition_PMS/assets/103418184/f71a1f8c-1737-4649-a590-27f4f6633411)


