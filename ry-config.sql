/*
 Navicat Premium Data Transfer

 Source Server         : YZ_PMS
 Source Server Type    : MySQL
 Source Server Version : 50637
 Source Host           : 127.0.0.1:3306
 Source Schema         : ry-config

 Target Server Type    : MySQL
 Target Server Version : 50637
 File Encoding         : 65001

 Date: 05/01/2024 17:22:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for config_info
-- ----------------------------
DROP TABLE IF EXISTS `config_info`;
CREATE TABLE `config_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'content',
  `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT 'source user',
  `src_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'source ip',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
  `c_desc` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `c_use` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `effect` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `type` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `c_schema` text CHARACTER SET utf8 COLLATE utf8_bin NULL,
  `encrypted_data_key` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT '秘钥',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfo_datagrouptenant`(`data_id`, `group_id`, `tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 108 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_info' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of config_info
-- ----------------------------
INSERT INTO `config_info` VALUES (1, 'application-dev.yml', 'DEFAULT_GROUP', 'spring:\n  autoconfigure:\n    exclude: com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure\n  mvc:\n    pathmatch:\n      matching-strategy: ant_path_matcher\n\n# feign 配置\nfeign:\n  sentinel:\n    enabled: true\n  okhttp:\n    enabled: true\n  httpclient:\n    enabled: false\n  client:\n    config:\n      default:\n        connectTimeout: 10000\n        readTimeout: 10000\n  compression:\n    request:\n      enabled: true\n    response:\n      enabled: true\n\n# 暴露监控端点\nmanagement:\n  endpoints:\n    web:\n      exposure:\n        include: \'*\'\n', 'aaa73b809cfd4d0058893aa13da57806', '2020-05-20 12:00:00', '2022-04-24 10:26:34', 'nacos', '0:0:0:0:0:0:0:1', '', '', '通用配置', 'null', 'null', 'yaml', NULL, '');
INSERT INTO `config_info` VALUES (2, 'ruoyi-gateway-dev.yml', 'DEFAULT_GROUP', 'spring:\n  redis:\n    host: 127.0.0.1\n    port: 6379\n    password: 123456\n  cloud:\n    gateway:\n      discovery:\n        locator:\n          lowerCaseServiceId: true\n          enabled: true\n      routes:\n        # 认证中心\n        - id: ruoyi-auth\n          uri: lb://ruoyi-auth\n          predicates:\n            - Path=/auth/**\n          filters:\n            # 验证码处理\n            - CacheRequestFilter\n            - ValidateCodeFilter\n            - StripPrefix=1\n        # 代码生成\n        - id: ruoyi-gen\n          uri: lb://ruoyi-gen\n          predicates:\n            - Path=/code/**\n          filters:\n            - StripPrefix=1\n        # 定时任务\n        - id: ruoyi-job\n          uri: lb://ruoyi-job\n          predicates:\n            - Path=/schedule/**\n          filters:\n            - StripPrefix=1\n        # 系统模块\n        - id: ruoyi-system\n          uri: lb://ruoyi-system\n          predicates:\n            - Path=/system/**\n          filters:\n            - StripPrefix=1\n        # 文件服务\n        - id: ruoyi-file\n          uri: lb://ruoyi-file\n          predicates:\n            - Path=/file/**\n          filters:\n            - StripPrefix=1\n         #采购模块\n        - id: shopping-system\n          uri: lb://shopping-system\n          predicates:\n            - Path=/shopping/*/**\n          filters:\n            - StripPrefix=1\n        #招投标模块\n        - id: bidding-system\n          uri: lb://bidding-system\n          predicates:\n            - Path=/bidding/*/**\n          filters:\n            - StripPrefix=1\n\n# 安全配置\nsecurity:\n  # 验证码\n  captcha:\n    enabled: true\n    type: math\n  # 防止XSS攻击\n  xss:\n    enabled: true\n    excludeUrls:\n      - /system/notice\n  # 不校验白名单\n  ignore:\n    whites:\n      - /auth/logout\n      - /auth/login\n      - /auth/register\n      - /*/v2/api-docs\n      - /csrf\n', '802655d4a3bf1e7bc9ec634323ae22e0', '2020-05-14 14:17:55', '2024-01-05 09:11:58', NULL, '0:0:0:0:0:0:0:1', '', '', NULL, NULL, NULL, 'text', NULL, '');
INSERT INTO `config_info` VALUES (3, 'ruoyi-auth-dev.yml', 'DEFAULT_GROUP', 'spring:\n  redis:\n    host: 127.0.0.1\n    port: 6379\n    password: 123456\n', '5f03be2139707ead08210b2bf9df434d', '2020-11-20 00:00:00', '2024-01-05 09:12:32', NULL, '0:0:0:0:0:0:0:1', '', '', NULL, NULL, NULL, 'text', NULL, '');
INSERT INTO `config_info` VALUES (4, 'ruoyi-monitor-dev.yml', 'DEFAULT_GROUP', '# spring\nspring:\n  security:\n    user:\n      name: ruoyi\n      password: 123456\n  boot:\n    admin:\n      ui:\n        title: 若依服务状态监控\n', '6f122fd2bfb8d45f858e7d6529a9cd44', '2020-11-20 00:00:00', '2022-09-29 02:48:54', 'nacos', '0:0:0:0:0:0:0:1', '', '', '监控中心', 'null', 'null', 'yaml', '', '');
INSERT INTO `config_info` VALUES (5, 'ruoyi-system-dev.yml', 'DEFAULT_GROUP', '# spring配置\nspring:\n  redis:\n    host: 127.0.0.1\n    port: 6379\n    password: 123456\n  datasource:\n    druid:\n      stat-view-servlet:\n        enabled: true\n        loginUsername: admin\n        loginPassword: 123456\n    dynamic:\n      druid:\n        initial-size: 5\n        min-idle: 5\n        maxActive: 20\n        maxWait: 60000\n        timeBetweenEvictionRunsMillis: 60000\n        minEvictableIdleTimeMillis: 300000\n        validationQuery: SELECT 1 FROM DUAL\n        testWhileIdle: true\n        testOnBorrow: false\n        testOnReturn: false\n        poolPreparedStatements: true\n        maxPoolPreparedStatementPerConnectionSize: 20\n        filters: stat,slf4j\n        connectionProperties: druid.stat.mergeSql\\=true;druid.stat.slowSqlMillis\\=5000\n      datasource:\n          # 主库数据源\n          master:\n            driver-class-name: com.mysql.cj.jdbc.Driver\n            url: jdbc:mysql://127.0.0.1:3306/ry-cloud?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8\n            username: root\n            password: root\n          # 从库数据源\n          # slave:\n            # username: \n            # password: \n            # url: \n            # driver-class-name: \n\n# mybatis配置\nmybatis:\n    # 搜索指定包别名\n    typeAliasesPackage: com.ruoyi.system\n    # 配置mapper的扫描，找到所有的mapper.xml映射文件\n    mapperLocations: classpath:mapper/**/*.xml\n\n# swagger配置\nswagger:\n  title: 系统模块接口文档\n  license: Powered By ruoyi\n  licenseUrl: https://ruoyi.vip', '4477c88e7d0effdd3e580cc60becb41d', '2020-11-20 00:00:00', '2024-01-05 09:17:24', NULL, '0:0:0:0:0:0:0:1', '', '', NULL, NULL, NULL, 'text', NULL, '');
INSERT INTO `config_info` VALUES (6, 'ruoyi-gen-dev.yml', 'DEFAULT_GROUP', '# spring配置\nspring:\n  redis:\n    host: 127.0.0.1\n    port: 6379\n    password: 123456\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://127.0.0.1:3306/yz_pms_db?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8\n    username: root\n    password: root\n\n# mybatis配置\nmybatis:\n    # 搜索指定包别名\n    typeAliasesPackage: com.ruoyi.gen.domain\n    # 配置mapper的扫描，找到所有的mapper.xml映射文件\n    mapperLocations: classpath:mapper/**/*.xml\n\n# swagger配置\nswagger:\n  title: 代码生成接口文档\n  license: Powered By ruoyi\n  licenseUrl: https://ruoyi.vip\n\n# 代码生成\ngen:\n  # 作者\n  author: zhangye\n  # 默认生成包路径 system 需改成自己的模块名称 如 system monitor tool\n  packageName: com.yz.pms.bidding\n  # 自动去除表前缀，默认是false\n  autoRemovePre: false\n  # 表前缀（生成类名不会包含表前缀，多个用逗号分隔）\n  tablePrefix: sys_\n', 'd7bbaa113ec954f2dc90c8284907d172', '2020-11-20 00:00:00', '2024-01-05 09:16:11', NULL, '0:0:0:0:0:0:0:1', '', '', NULL, NULL, NULL, 'text', NULL, '');
INSERT INTO `config_info` VALUES (7, 'ruoyi-job-dev.yml', 'DEFAULT_GROUP', '# spring配置\nspring:\n  redis:\n    host: 127.0.0.1\n    port: 6379\n    password: 123456\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://127.0.0.1:3306/ry-cloud?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8\n    username: root\n    password: root\n\n# mybatis配置\nmybatis:\n    # 搜索指定包别名\n    typeAliasesPackage: com.ruoyi.job.domain\n    # 配置mapper的扫描，找到所有的mapper.xml映射文件\n    mapperLocations: classpath:mapper/**/*.xml\n\n# swagger配置\nswagger:\n  title: 定时任务接口文档\n  license: Powered By ruoyi\n  licenseUrl: https://ruoyi.vip\n', '2b701a1f10497a869dc623051208ec5d', '2020-11-20 00:00:00', '2024-01-05 08:58:09', 'nacos', '0:0:0:0:0:0:0:1', '', '', '定时任务', 'null', 'null', 'yaml', '', '');
INSERT INTO `config_info` VALUES (8, 'ruoyi-file-dev.yml', 'DEFAULT_GROUP', '# 本地文件上传    \r\nfile:\r\n    domain: http://127.0.0.1:9300\r\n    path: D:/ruoyi/uploadPath\r\n    prefix: /statics\r\n\r\n# FastDFS配置\r\nfdfs:\r\n  domain: http://8.129.231.12\r\n  soTimeout: 3000\r\n  connectTimeout: 2000\r\n  trackerList: 8.129.231.12:22122\r\n\r\n# Minio配置\r\nminio:\r\n  url: http://8.129.231.12:9000\r\n  accessKey: minioadmin\r\n  secretKey: minioadmin\r\n  bucketName: test', '5382b93f3d8059d6068c0501fdd41195', '2020-11-20 00:00:00', '2020-12-21 21:01:59', NULL, '0:0:0:0:0:0:0:1', '', '', '文件服务', 'null', 'null', 'yaml', NULL, '');
INSERT INTO `config_info` VALUES (9, 'sentinel-ruoyi-gateway', 'DEFAULT_GROUP', '[\r\n    {\r\n        \"resource\": \"ruoyi-auth\",\r\n        \"count\": 500,\r\n        \"grade\": 1,\r\n        \"limitApp\": \"default\",\r\n        \"strategy\": 0,\r\n        \"controlBehavior\": 0\r\n    },\r\n	{\r\n        \"resource\": \"ruoyi-system\",\r\n        \"count\": 1000,\r\n        \"grade\": 1,\r\n        \"limitApp\": \"default\",\r\n        \"strategy\": 0,\r\n        \"controlBehavior\": 0\r\n    },\r\n	{\r\n        \"resource\": \"ruoyi-gen\",\r\n        \"count\": 200,\r\n        \"grade\": 1,\r\n        \"limitApp\": \"default\",\r\n        \"strategy\": 0,\r\n        \"controlBehavior\": 0\r\n    },\r\n	{\r\n        \"resource\": \"ruoyi-job\",\r\n        \"count\": 300,\r\n        \"grade\": 1,\r\n        \"limitApp\": \"default\",\r\n        \"strategy\": 0,\r\n        \"controlBehavior\": 0\r\n    }\r\n]', '9f3a3069261598f74220bc47958ec252', '2020-11-20 00:00:00', '2020-11-20 00:00:00', NULL, '0:0:0:0:0:0:0:1', '', '', '限流策略', 'null', 'null', 'json', NULL, '');
INSERT INTO `config_info` VALUES (90, 'shopping-system-dev.yml', 'DEFAULT_GROUP', '# spring配置\nspring:\n  redis:\n    host: 127.0.0.1\n    port: 6379\n    password: 123456\n  datasource:\n    druid:\n      stat-view-servlet:\n        enabled: true\n        loginUsername: admin\n        loginPassword: 123456\n    dynamic:\n      druid:\n        initial-size: 5\n        min-idle: 5\n        maxActive: 20\n        maxWait: 60000\n        timeBetweenEvictionRunsMillis: 60000\n        minEvictableIdleTimeMillis: 300000\n        validationQuery: SELECT 1 FROM DUAL\n        testWhileIdle: true\n        testOnBorrow: false\n        testOnReturn: false\n        poolPreparedStatements: true\n        maxPoolPreparedStatementPerConnectionSize: 20\n        filters: stat,slf4j\n        connectionProperties: druid.stat.mergeSql\\=true;druid.stat.slowSqlMillis\\=5000\n      datasource:\n          # 主库数据源\n          master:\n            driver-class-name: com.mysql.cj.jdbc.Driver\n            url: jdbc:mysql://127.0.0.1:3306/yz_pms_db?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8\n            username: root\n            password: root\n          # 从库数据源\n          # slave:\n            # username: \n            # password: \n            # url: \n            # driver-class-name: \n\n# mybatis配置\nmybatis:\n    # 搜索指定包别名\n    typeAliasesPackage: com.yz.shopping\n    # 配置mapper的扫描，找到所有的mapper.xml映射文件\n    mapperLocations: classpath:mapper/**/*.xml\n    configuration:\n      log-impl: org.apache.ibatis.logging.stdout.StdOutImpl\n\n# swagger配置\nswagger:\n  title: 系统模块接口文档\n  license: Powered By ruoyi\n  licenseUrl: https://ruoyi.vip', '61805b5b24c05961b595540030f90d67', '2023-11-20 15:09:14', '2024-01-05 09:16:48', NULL, '0:0:0:0:0:0:0:1', '', '', NULL, NULL, NULL, 'text', NULL, NULL);
INSERT INTO `config_info` VALUES (92, 'bidding-system-dev.yml', 'DEFAULT_GROUP', '# spring配置\nspring:\n  redis:\n    host: 127.0.0.1\n    port: 6379\n    password: 123456\n  datasource:\n    druid:\n      stat-view-servlet:\n        enabled: true\n        loginUsername: admin\n        loginPassword: 123456\n    dynamic:\n      druid:\n        initial-size: 5\n        min-idle: 5\n        maxActive: 20\n        maxWait: 60000\n        timeBetweenEvictionRunsMillis: 60000\n        minEvictableIdleTimeMillis: 300000\n        validationQuery: SELECT 1 FROM DUAL\n        testWhileIdle: true\n        testOnBorrow: false\n        testOnReturn: false\n        poolPreparedStatements: true\n        maxPoolPreparedStatementPerConnectionSize: 20\n        filters: stat,slf4j\n        connectionProperties: druid.stat.mergeSql\\=true;druid.stat.slowSqlMillis\\=5000\n      datasource:\n          # 主库数据源\n          master:\n            driver-class-name: com.mysql.cj.jdbc.Driver\n            url: jdbc:mysql://127.0.0.1:3306/yz_pms_db?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8\n            username: root\n            password: root\n          # 从库数据源\n          # slave:\n            # username: \n            # password: \n            # url: \n            # driver-class-name: \n\n# mybatis配置\nmybatis:\n    # 搜索指定包别名\n    typeAliasesPackage: com.yz.bidding\n    # 配置mapper的扫描，找到所有的mapper.xml映射文件\n    mapperLocations: classpath:mapper/**/*.xml\n    configuration:\n      log-impl: org.apache.ibatis.logging.stdout.StdOutImpl\n\n# swagger配置\nswagger:\n  title: 系统模块接口文档\n  license: Powered By ruoyi\n  licenseUrl: https://ruoyi.vip', 'd70e627a2e1160aacae9dea6aa87c9c9', '2023-11-20 17:39:58', '2024-01-05 09:16:28', NULL, '0:0:0:0:0:0:0:1', '', '', NULL, NULL, NULL, 'text', NULL, NULL);

-- ----------------------------
-- Table structure for config_info_aggr
-- ----------------------------
DROP TABLE IF EXISTS `config_info_aggr`;
CREATE TABLE `config_info_aggr`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `datum_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'datum_id',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '内容',
  `gmt_modified` datetime(0) NOT NULL COMMENT '修改时间',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfoaggr_datagrouptenantdatum`(`data_id`, `group_id`, `tenant_id`, `datum_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '增加租户字段' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for config_info_beta
-- ----------------------------
DROP TABLE IF EXISTS `config_info_beta`;
CREATE TABLE `config_info_beta`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'app_name',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'content',
  `beta_ips` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'betaIps',
  `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT 'source user',
  `src_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'source ip',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
  `encrypted_data_key` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT '秘钥',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfobeta_datagrouptenant`(`data_id`, `group_id`, `tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_info_beta' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for config_info_tag
-- ----------------------------
DROP TABLE IF EXISTS `config_info_tag`;
CREATE TABLE `config_info_tag`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_id',
  `tag_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'tag_id',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'app_name',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'content',
  `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT 'source user',
  `src_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'source ip',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfotag_datagrouptenanttag`(`data_id`, `group_id`, `tenant_id`, `tag_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_info_tag' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for config_tags_relation
-- ----------------------------
DROP TABLE IF EXISTS `config_tags_relation`;
CREATE TABLE `config_tags_relation`  (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `tag_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'tag_name',
  `tag_type` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'tag_type',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_id',
  `nid` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`nid`) USING BTREE,
  UNIQUE INDEX `uk_configtagrelation_configidtag`(`id`, `tag_name`, `tag_type`) USING BTREE,
  INDEX `idx_tenant_id`(`tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_tag_relation' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for group_capacity
-- ----------------------------
DROP TABLE IF EXISTS `group_capacity`;
CREATE TABLE `group_capacity`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT 'Group ID，空字符表示整个集群',
  `quota` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '配额，0表示使用默认值',
  `usage` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '使用量',
  `max_size` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
  `max_aggr_count` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '聚合子配置最大个数，，0表示使用默认值',
  `max_aggr_size` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
  `max_history_count` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '最大变更历史数量',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_group_id`(`group_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '集群、各Group容量信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for his_config_info
-- ----------------------------
DROP TABLE IF EXISTS `his_config_info`;
CREATE TABLE `his_config_info`  (
  `id` bigint(64) UNSIGNED NOT NULL,
  `nid` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'app_name',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL,
  `src_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `op_type` char(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
  `encrypted_data_key` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT '秘钥',
  PRIMARY KEY (`nid`) USING BTREE,
  INDEX `idx_gmt_create`(`gmt_create`) USING BTREE,
  INDEX `idx_gmt_modified`(`gmt_modified`) USING BTREE,
  INDEX `idx_did`(`data_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 114 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '多租户改造' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of his_config_info
-- ----------------------------
INSERT INTO `his_config_info` VALUES (90, 99, 'shopping-system-dev.yml', 'DEFAULT_GROUP', '', '# spring配置\nspring:\n  redis:\n    host: 127.0.0.1\n    port: 6379\n    password: 123456\n  datasource:\n    druid:\n      stat-view-servlet:\n        enabled: true\n        loginUsername: admin\n        loginPassword: 123456\n    dynamic:\n      druid:\n        initial-size: 5\n        min-idle: 5\n        maxActive: 20\n        maxWait: 60000\n        timeBetweenEvictionRunsMillis: 60000\n        minEvictableIdleTimeMillis: 300000\n        validationQuery: SELECT 1 FROM DUAL\n        testWhileIdle: true\n        testOnBorrow: false\n        testOnReturn: false\n        poolPreparedStatements: true\n        maxPoolPreparedStatementPerConnectionSize: 20\n        filters: stat,slf4j\n        connectionProperties: druid.stat.mergeSql\\=true;druid.stat.slowSqlMillis\\=5000\n      datasource:\n          # 主库数据源\n          master:\n            driver-class-name: com.mysql.cj.jdbc.Driver\n            url: jdbc:mysql://127.0.0.1:3306/yz_pms_db?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8\n            username: root\n            password: root\n          # 从库数据源\n          # slave:\n            # username: \n            # password: \n            # url: \n            # driver-class-name: \n\n# mybatis配置\nmybatis:\n    # 搜索指定包别名\n    typeAliasesPackage: com.yz.shopping\n    # 配置mapper的扫描，找到所有的mapper.xml映射文件\n    mapperLocations: classpath:mapper/**/*.xml\n    configuration:\n      log-impl: org.apache.ibatis.logging.stdout.StdOutImpl\n\n# swagger配置\nswagger:\n  title: 系统模块接口文档\n  license: Powered By ruoyi\n  licenseUrl: https://ruoyi.vip', '61805b5b24c05961b595540030f90d67', '2024-01-05 16:56:15', '2024-01-05 08:56:13', 'nacos', '0:0:0:0:0:0:0:1', 'U', '', NULL);
INSERT INTO `his_config_info` VALUES (2, 100, 'ruoyi-gateway-dev.yml', 'DEFAULT_GROUP', '', 'spring:\n  redis:\n    host: 127.0.0.1\n    port: 6379\n    password: 123456\n  cloud:\n    gateway:\n      discovery:\n        locator:\n          lowerCaseServiceId: true\n          enabled: true\n      routes:\n        # 认证中心\n        - id: ruoyi-auth\n          uri: lb://ruoyi-auth\n          predicates:\n            - Path=/auth/**\n          filters:\n            # 验证码处理\n            - CacheRequestFilter\n            - ValidateCodeFilter\n            - StripPrefix=1\n        # 代码生成\n        - id: ruoyi-gen\n          uri: lb://ruoyi-gen\n          predicates:\n            - Path=/code/**\n          filters:\n            - StripPrefix=1\n        # 定时任务\n        - id: ruoyi-job\n          uri: lb://ruoyi-job\n          predicates:\n            - Path=/schedule/**\n          filters:\n            - StripPrefix=1\n        # 系统模块\n        - id: ruoyi-system\n          uri: lb://ruoyi-system\n          predicates:\n            - Path=/system/**\n          filters:\n            - StripPrefix=1\n        # 文件服务\n        - id: ruoyi-file\n          uri: lb://ruoyi-file\n          predicates:\n            - Path=/file/**\n          filters:\n            - StripPrefix=1\n         #采购模块\n        - id: shopping-system\n          uri: lb://shopping-system\n          predicates:\n            - Path=/shopping/*/**\n          filters:\n            - StripPrefix=1\n        #招投标模块\n        - id: bidding-system\n          uri: lb://bidding-system\n          predicates:\n            - Path=/bidding/*/**\n          filters:\n            - StripPrefix=1\n\n# 安全配置\nsecurity:\n  # 验证码\n  captcha:\n    enabled: true\n    type: math\n  # 防止XSS攻击\n  xss:\n    enabled: true\n    excludeUrls:\n      - /system/notice\n  # 不校验白名单\n  ignore:\n    whites:\n      - /auth/logout\n      - /auth/login\n      - /auth/register\n      - /*/v2/api-docs\n      - /csrf\n', '802655d4a3bf1e7bc9ec634323ae22e0', '2024-01-05 16:56:48', '2024-01-05 08:56:47', 'nacos', '0:0:0:0:0:0:0:1', 'U', '', NULL);
INSERT INTO `his_config_info` VALUES (3, 101, 'ruoyi-auth-dev.yml', 'DEFAULT_GROUP', '', 'spring:\n  redis:\n    host: 127.0.0.1\n    port: 6379\n    password: 123456\n', '5f03be2139707ead08210b2bf9df434d', '2024-01-05 16:56:59', '2024-01-05 08:56:58', 'nacos', '0:0:0:0:0:0:0:1', 'U', '', NULL);
INSERT INTO `his_config_info` VALUES (5, 102, 'ruoyi-system-dev.yml', 'DEFAULT_GROUP', '', '# spring配置\nspring:\n  redis:\n    host: 127.0.0.1\n    port: 6379\n    password: 123456\n  datasource:\n    druid:\n      stat-view-servlet:\n        enabled: true\n        loginUsername: admin\n        loginPassword: 123456\n    dynamic:\n      druid:\n        initial-size: 5\n        min-idle: 5\n        maxActive: 20\n        maxWait: 60000\n        timeBetweenEvictionRunsMillis: 60000\n        minEvictableIdleTimeMillis: 300000\n        validationQuery: SELECT 1 FROM DUAL\n        testWhileIdle: true\n        testOnBorrow: false\n        testOnReturn: false\n        poolPreparedStatements: true\n        maxPoolPreparedStatementPerConnectionSize: 20\n        filters: stat,slf4j\n        connectionProperties: druid.stat.mergeSql\\=true;druid.stat.slowSqlMillis\\=5000\n      datasource:\n          # 主库数据源\n          master:\n            driver-class-name: com.mysql.cj.jdbc.Driver\n            url: jdbc:mysql://127.0.0.1:3306/ry-cloud?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8\n            username: root\n            password: root\n          # 从库数据源\n          # slave:\n            # username: \n            # password: \n            # url: \n            # driver-class-name: \n\n# mybatis配置\nmybatis:\n    # 搜索指定包别名\n    typeAliasesPackage: com.ruoyi.system\n    # 配置mapper的扫描，找到所有的mapper.xml映射文件\n    mapperLocations: classpath:mapper/**/*.xml\n\n# swagger配置\nswagger:\n  title: 系统模块接口文档\n  license: Powered By ruoyi\n  licenseUrl: https://ruoyi.vip', '4477c88e7d0effdd3e580cc60becb41d', '2024-01-05 16:57:30', '2024-01-05 08:57:29', 'nacos', '0:0:0:0:0:0:0:1', 'U', '', NULL);
INSERT INTO `his_config_info` VALUES (6, 103, 'ruoyi-gen-dev.yml', 'DEFAULT_GROUP', '', '# spring配置\nspring:\n  redis:\n    host: 127.0.0.1\n    port: 6379\n    password: 123456\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://127.0.0.1:3306/yz_pms_db?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8\n    username: root\n    password: root\n\n# mybatis配置\nmybatis:\n    # 搜索指定包别名\n    typeAliasesPackage: com.ruoyi.gen.domain\n    # 配置mapper的扫描，找到所有的mapper.xml映射文件\n    mapperLocations: classpath:mapper/**/*.xml\n\n# swagger配置\nswagger:\n  title: 代码生成接口文档\n  license: Powered By ruoyi\n  licenseUrl: https://ruoyi.vip\n\n# 代码生成\ngen:\n  # 作者\n  author: zhangye\n  # 默认生成包路径 system 需改成自己的模块名称 如 system monitor tool\n  packageName: com.yz.pms.bidding\n  # 自动去除表前缀，默认是false\n  autoRemovePre: false\n  # 表前缀（生成类名不会包含表前缀，多个用逗号分隔）\n  tablePrefix: sys_\n', 'd7bbaa113ec954f2dc90c8284907d172', '2024-01-05 16:57:52', '2024-01-05 08:57:51', 'nacos', '0:0:0:0:0:0:0:1', 'U', '', NULL);
INSERT INTO `his_config_info` VALUES (7, 104, 'ruoyi-job-dev.yml', 'DEFAULT_GROUP', '', '# spring配置\nspring:\n  redis:\n    host: 127.0.0.1\n    port: 6379\n    password: 123456\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://127.0.0.1:3306/ry-cloud?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8\n    username: root\n    password: root\n\n# mybatis配置\nmybatis:\n    # 搜索指定包别名\n    typeAliasesPackage: com.ruoyi.job.domain\n    # 配置mapper的扫描，找到所有的mapper.xml映射文件\n    mapperLocations: classpath:mapper/**/*.xml\n\n# swagger配置\nswagger:\n  title: 定时任务接口文档\n  license: Powered By ruoyi\n  licenseUrl: https://ruoyi.vip\n', 'ed07b650717660a49ba169a449a838fb', '2024-01-05 16:58:11', '2024-01-05 08:58:09', 'nacos', '0:0:0:0:0:0:0:1', 'U', '', NULL);
INSERT INTO `his_config_info` VALUES (92, 105, 'bidding-system-dev.yml', 'DEFAULT_GROUP', '', '# spring配置\nspring:\n  redis:\n    host: 127.0.0.1\n    port: 6379\n    password: 123456\n  datasource:\n    druid:\n      stat-view-servlet:\n        enabled: true\n        loginUsername: admin\n        loginPassword: 123456\n    dynamic:\n      druid:\n        initial-size: 5\n        min-idle: 5\n        maxActive: 20\n        maxWait: 60000\n        timeBetweenEvictionRunsMillis: 60000\n        minEvictableIdleTimeMillis: 300000\n        validationQuery: SELECT 1 FROM DUAL\n        testWhileIdle: true\n        testOnBorrow: false\n        testOnReturn: false\n        poolPreparedStatements: true\n        maxPoolPreparedStatementPerConnectionSize: 20\n        filters: stat,slf4j\n        connectionProperties: druid.stat.mergeSql\\=true;druid.stat.slowSqlMillis\\=5000\n      datasource:\n          # 主库数据源\n          master:\n            driver-class-name: com.mysql.cj.jdbc.Driver\n            url: jdbc:mysql://127.0.0.1:3306/yz_pms_db?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8\n            username: root\n            password: root\n          # 从库数据源\n          # slave:\n            # username: \n            # password: \n            # url: \n            # driver-class-name: \n\n# mybatis配置\nmybatis:\n    # 搜索指定包别名\n    typeAliasesPackage: com.yz.bidding\n    # 配置mapper的扫描，找到所有的mapper.xml映射文件\n    mapperLocations: classpath:mapper/**/*.xml\n    configuration:\n      log-impl: org.apache.ibatis.logging.stdout.StdOutImpl\n\n# swagger配置\nswagger:\n  title: 系统模块接口文档\n  license: Powered By ruoyi\n  licenseUrl: https://ruoyi.vip', 'd70e627a2e1160aacae9dea6aa87c9c9', '2024-01-05 16:59:17', '2024-01-05 08:59:15', 'nacos', '0:0:0:0:0:0:0:1', 'U', '', NULL);
INSERT INTO `his_config_info` VALUES (2, 106, 'ruoyi-gateway-dev.yml', 'DEFAULT_GROUP', '', 'spring:\n  redis:\n    host: 127.0.0.1\n    port: 6379\n    password: 123456\n  cloud:\n    gateway:\n      discovery:\n        locator:\n          lowerCaseServiceId: true\n          enabled: true\n      routes:\n        # 认证中心\n        - id: ruoyi-auth\n          uri: lb://ruoyi-auth\n          predicates:\n            - Path=/auth/**\n          filters:\n            # 验证码处理\n            - CacheRequestFilter\n            - ValidateCodeFilter\n            - StripPrefix=1\n        # 代码生成\n        - id: ruoyi-gen\n          uri: lb://ruoyi-gen\n          predicates:\n            - Path=/code/**\n          filters:\n            - StripPrefix=1\n        # 定时任务\n        - id: ruoyi-job\n          uri: lb://ruoyi-job\n          predicates:\n            - Path=/schedule/**\n          filters:\n            - StripPrefix=1\n        # 系统模块\n        - id: ruoyi-system\n          uri: lb://ruoyi-system\n          predicates:\n            - Path=/system/**\n          filters:\n            - StripPrefix=1\n        # 文件服务\n        - id: ruoyi-file\n          uri: lb://ruoyi-file\n          predicates:\n            - Path=/file/**\n          filters:\n            - StripPrefix=1\n         #采购模块\n        - id: shopping-system\n          uri: lb://shopping-system\n          predicates:\n            - Path=/shopping/*/**\n          filters:\n            - StripPrefix=1\n        #招投标模块\n        - id: bidding-system\n          uri: lb://bidding-system\n          predicates:\n            - Path=/bidding/*/**\n          filters:\n            - StripPrefix=1\n\n# 安全配置\nsecurity:\n  # 验证码\n  captcha:\n    enabled: true\n    type: math\n  # 防止XSS攻击\n  xss:\n    enabled: true\n    excludeUrls:\n      - /system/notice\n  # 不校验白名单\n  ignore:\n    whites:\n      - /auth/logout\n      - /auth/login\n      - /auth/register\n      - /*/v2/api-docs\n      - /csrf\n', '8958d4a460dd693d7371dea79149e74c', '2024-01-05 17:12:00', '2024-01-05 09:11:58', NULL, '0:0:0:0:0:0:0:1', 'U', '', NULL);
INSERT INTO `his_config_info` VALUES (3, 107, 'ruoyi-auth-dev.yml', 'DEFAULT_GROUP', '', 'spring:\n  redis:\n    host: 127.0.0.1\n    port: 6379\n    password: 123456\n', 'e56735b21483cae095db7b4d99114ccb', '2024-01-05 17:12:33', '2024-01-05 09:12:32', NULL, '0:0:0:0:0:0:0:1', 'U', '', NULL);
INSERT INTO `his_config_info` VALUES (5, 108, 'ruoyi-system-dev.yml', 'DEFAULT_GROUP', '', '# spring配置\nspring:\n  redis:\n    host: 127.0.0.1\n    port: 6379\n    password: 123456\n  datasource:\n    druid:\n      stat-view-servlet:\n        enabled: true\n        loginUsername: admin\n        loginPassword: 123456\n    dynamic:\n      druid:\n        initial-size: 5\n        min-idle: 5\n        maxActive: 20\n        maxWait: 60000\n        timeBetweenEvictionRunsMillis: 60000\n        minEvictableIdleTimeMillis: 300000\n        validationQuery: SELECT 1 FROM DUAL\n        testWhileIdle: true\n        testOnBorrow: false\n        testOnReturn: false\n        poolPreparedStatements: true\n        maxPoolPreparedStatementPerConnectionSize: 20\n        filters: stat,slf4j\n        connectionProperties: druid.stat.mergeSql\\=true;druid.stat.slowSqlMillis\\=5000\n      datasource:\n          # 主库数据源\n          master:\n            driver-class-name: com.mysql.cj.jdbc.Driver\n            url: jdbc:mysql://127.0.0.1:3306/ry-cloud?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8\n            username: root\n            password: root\n          # 从库数据源\n          # slave:\n            # username: \n            # password: \n            # url: \n            # driver-class-name: \n\n# mybatis配置\nmybatis:\n    # 搜索指定包别名\n    typeAliasesPackage: com.ruoyi.system\n    # 配置mapper的扫描，找到所有的mapper.xml映射文件\n    mapperLocations: classpath:mapper/**/*.xml\n\n# swagger配置\nswagger:\n  title: 系统模块接口文档\n  license: Powered By ruoyi\n  licenseUrl: https://ruoyi.vip', '8ab4ac3e2b46e952fa173cf0e32bfed8', '2024-01-05 17:15:24', '2024-01-05 09:15:23', NULL, '0:0:0:0:0:0:0:1', 'U', '', NULL);
INSERT INTO `his_config_info` VALUES (6, 109, 'ruoyi-gen-dev.yml', 'DEFAULT_GROUP', '', '# spring配置\nspring:\n  redis:\n    host: 127.0.0.1\n    port: 6379\n    password: 123456\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://127.0.0.1:3306/yz_pms_db?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8\n    username: root\n    password: root\n\n# mybatis配置\nmybatis:\n    # 搜索指定包别名\n    typeAliasesPackage: com.ruoyi.gen.domain\n    # 配置mapper的扫描，找到所有的mapper.xml映射文件\n    mapperLocations: classpath:mapper/**/*.xml\n\n# swagger配置\nswagger:\n  title: 代码生成接口文档\n  license: Powered By ruoyi\n  licenseUrl: https://ruoyi.vip\n\n# 代码生成\ngen:\n  # 作者\n  author: zhangye\n  # 默认生成包路径 system 需改成自己的模块名称 如 system monitor tool\n  packageName: com.yz.pms.bidding\n  # 自动去除表前缀，默认是false\n  autoRemovePre: false\n  # 表前缀（生成类名不会包含表前缀，多个用逗号分隔）\n  tablePrefix: sys_\n', 'a0437dbf367fd86573da1c5e032b855f', '2024-01-05 17:15:41', '2024-01-05 09:15:39', NULL, '0:0:0:0:0:0:0:1', 'U', '', NULL);
INSERT INTO `his_config_info` VALUES (6, 110, 'ruoyi-gen-dev.yml', 'DEFAULT_GROUP', '', '# spring配置\nspring:\n  redis:\n    host: 127.0.0.1\n    port: 6379\n    password: 123456\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://127.0.0.1:3306/yz_pms_db?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8\n    username: root\n    password: root\n\n# mybatis配置\nmybatis:\n    # 搜索指定包别名\n    typeAliasesPackage: com.ruoyi.gen.domain\n    # 配置mapper的扫描，找到所有的mapper.xml映射文件\n    mapperLocations: classpath:mapper/**/*.xml\n\n# swagger配置\nswagger:\n  title: 代码生成接口文档\n  license: Powered By ruoyi\n  licenseUrl: https://ruoyi.vip\n\n# 代码生成\ngen:\n  # 作者\n  author: zhangye\n  # 默认生成包路径 system 需改成自己的模块名称 如 system monitor tool\n  packageName: com.yz.pms.bidding\n  # 自动去除表前缀，默认是false\n  autoRemovePre: false\n  # 表前缀（生成类名不会包含表前缀，多个用逗号分隔）\n  tablePrefix: sys_\n', 'd7bbaa113ec954f2dc90c8284907d172', '2024-01-05 17:16:13', '2024-01-05 09:16:11', NULL, '0:0:0:0:0:0:0:1', 'U', '', NULL);
INSERT INTO `his_config_info` VALUES (92, 111, 'bidding-system-dev.yml', 'DEFAULT_GROUP', '', '# spring配置\nspring:\n  redis:\n    host: 127.0.0.1\n    port: 6379\n    password: 123456\n  datasource:\n    druid:\n      stat-view-servlet:\n        enabled: true\n        loginUsername: admin\n        loginPassword: 123456\n    dynamic:\n      druid:\n        initial-size: 5\n        min-idle: 5\n        maxActive: 20\n        maxWait: 60000\n        timeBetweenEvictionRunsMillis: 60000\n        minEvictableIdleTimeMillis: 300000\n        validationQuery: SELECT 1 FROM DUAL\n        testWhileIdle: true\n        testOnBorrow: false\n        testOnReturn: false\n        poolPreparedStatements: true\n        maxPoolPreparedStatementPerConnectionSize: 20\n        filters: stat,slf4j\n        connectionProperties: druid.stat.mergeSql\\=true;druid.stat.slowSqlMillis\\=5000\n      datasource:\n          # 主库数据源\n          master:\n            driver-class-name: com.mysql.cj.jdbc.Driver\n            url: jdbc:mysql://127.0.0.1:3306/yz_pms_db?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8\n            username: root\n            password: root\n          # 从库数据源\n          # slave:\n            # username: \n            # password: \n            # url: \n            # driver-class-name: \n\n# mybatis配置\nmybatis:\n    # 搜索指定包别名\n    typeAliasesPackage: com.yz.bidding\n    # 配置mapper的扫描，找到所有的mapper.xml映射文件\n    mapperLocations: classpath:mapper/**/*.xml\n    configuration:\n      log-impl: org.apache.ibatis.logging.stdout.StdOutImpl\n\n# swagger配置\nswagger:\n  title: 系统模块接口文档\n  license: Powered By ruoyi\n  licenseUrl: https://ruoyi.vip', 'f17698a74485cc38eb92b476486e9b30', '2024-01-05 17:16:30', '2024-01-05 09:16:28', NULL, '0:0:0:0:0:0:0:1', 'U', '', NULL);
INSERT INTO `his_config_info` VALUES (90, 112, 'shopping-system-dev.yml', 'DEFAULT_GROUP', '', '# spring配置\nspring:\n  redis:\n    host: 127.0.0.1\n    port: 6379\n    password: 123456\n  datasource:\n    druid:\n      stat-view-servlet:\n        enabled: true\n        loginUsername: admin\n        loginPassword: 123456\n    dynamic:\n      druid:\n        initial-size: 5\n        min-idle: 5\n        maxActive: 20\n        maxWait: 60000\n        timeBetweenEvictionRunsMillis: 60000\n        minEvictableIdleTimeMillis: 300000\n        validationQuery: SELECT 1 FROM DUAL\n        testWhileIdle: true\n        testOnBorrow: false\n        testOnReturn: false\n        poolPreparedStatements: true\n        maxPoolPreparedStatementPerConnectionSize: 20\n        filters: stat,slf4j\n        connectionProperties: druid.stat.mergeSql\\=true;druid.stat.slowSqlMillis\\=5000\n      datasource:\n          # 主库数据源\n          master:\n            driver-class-name: com.mysql.cj.jdbc.Driver\n            url: jdbc:mysql://127.0.0.1:3306/yz_pms_db?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8\n            username: root\n            password: root\n          # 从库数据源\n          # slave:\n            # username: \n            # password: \n            # url: \n            # driver-class-name: \n\n# mybatis配置\nmybatis:\n    # 搜索指定包别名\n    typeAliasesPackage: com.yz.shopping\n    # 配置mapper的扫描，找到所有的mapper.xml映射文件\n    mapperLocations: classpath:mapper/**/*.xml\n    configuration:\n      log-impl: org.apache.ibatis.logging.stdout.StdOutImpl\n\n# swagger配置\nswagger:\n  title: 系统模块接口文档\n  license: Powered By ruoyi\n  licenseUrl: https://ruoyi.vip', '58358847229e2d73a5f24e8fba3332a0', '2024-01-05 17:16:50', '2024-01-05 09:16:48', NULL, '0:0:0:0:0:0:0:1', 'U', '', NULL);
INSERT INTO `his_config_info` VALUES (5, 113, 'ruoyi-system-dev.yml', 'DEFAULT_GROUP', '', '# spring配置\nspring:\n  redis:\n    host: 127.0.0.1\n    port: 6379\n    password: 123456\n  datasource:\n    druid:\n      stat-view-servlet:\n        enabled: true\n        loginUsername: admin\n        loginPassword: 123456\n    dynamic:\n      druid:\n        initial-size: 5\n        min-idle: 5\n        maxActive: 20\n        maxWait: 60000\n        timeBetweenEvictionRunsMillis: 60000\n        minEvictableIdleTimeMillis: 300000\n        validationQuery: SELECT 1 FROM DUAL\n        testWhileIdle: true\n        testOnBorrow: false\n        testOnReturn: false\n        poolPreparedStatements: true\n        maxPoolPreparedStatementPerConnectionSize: 20\n        filters: stat,slf4j\n        connectionProperties: druid.stat.mergeSql\\=true;druid.stat.slowSqlMillis\\=5000\n      datasource:\n          # 主库数据源\n          master:\n            driver-class-name: com.mysql.cj.jdbc.Driver\n            url: jdbc:mysql://127.0.0.1:3306/ry-cloud?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8\n            username: root\n            password: root\n          # 从库数据源\n          # slave:\n            # username: \n            # password: \n            # url: \n            # driver-class-name: \n\n# mybatis配置\nmybatis:\n    # 搜索指定包别名\n    typeAliasesPackage: com.ruoyi.system\n    # 配置mapper的扫描，找到所有的mapper.xml映射文件\n    mapperLocations: classpath:mapper/**/*.xml\n\n# swagger配置\nswagger:\n  title: 系统模块接口文档\n  license: Powered By ruoyi\n  licenseUrl: https://ruoyi.vip', '4477c88e7d0effdd3e580cc60becb41d', '2024-01-05 17:17:25', '2024-01-05 09:17:24', NULL, '0:0:0:0:0:0:0:1', 'U', '', NULL);

-- ----------------------------
-- Table structure for permissions
-- ----------------------------
DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions`  (
  `role` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `resource` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `action` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  UNIQUE INDEX `uk_role_permission`(`role`, `resource`, `action`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`  (
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  UNIQUE INDEX `idx_user_role`(`username`, `role`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('nacos', 'ROLE_ADMIN');

-- ----------------------------
-- Table structure for tenant_capacity
-- ----------------------------
DROP TABLE IF EXISTS `tenant_capacity`;
CREATE TABLE `tenant_capacity`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT 'Tenant ID',
  `quota` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '配额，0表示使用默认值',
  `usage` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '使用量',
  `max_size` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
  `max_aggr_count` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '聚合子配置最大个数',
  `max_aggr_size` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
  `max_history_count` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '最大变更历史数量',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_tenant_id`(`tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '租户容量信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tenant_info
-- ----------------------------
DROP TABLE IF EXISTS `tenant_info`;
CREATE TABLE `tenant_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `kp` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'kp',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_id',
  `tenant_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_name',
  `tenant_desc` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'tenant_desc',
  `create_source` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'create_source',
  `gmt_create` bigint(20) NOT NULL COMMENT '创建时间',
  `gmt_modified` bigint(20) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_tenant_info_kptenantid`(`kp`, `tenant_id`) USING BTREE,
  INDEX `idx_tenant_id`(`tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'tenant_info' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('nacos', '$2a$10$EuWPZHzz32dJN7jexM34MOeYirDdFAZm2kuWj7VEOJhhZkDrxfvUu', 1);

SET FOREIGN_KEY_CHECKS = 1;
