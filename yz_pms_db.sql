/*
 Navicat Premium Data Transfer

 Source Server         : YZ_PMS
 Source Server Type    : MySQL
 Source Server Version : 50637
 Source Host           : 127.0.0.1:3306
 Source Schema         : yz_pms_db

 Target Server Type    : MySQL
 Target Server Version : 50637
 File Encoding         : 65001

 Date: 05/01/2024 17:23:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bidding_download_logs
-- ----------------------------
DROP TABLE IF EXISTS `bidding_download_logs`;
CREATE TABLE `bidding_download_logs`  (
  `download_logs_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `notice_text_id` int(11) NULL DEFAULT NULL COMMENT '公告主键',
  `tender_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投标人名称',
  `contact` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `phone` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '移动电话',
  `email` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `download_time` datetime(0) NULL DEFAULT NULL COMMENT '下载时间',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除',
  PRIMARY KEY (`download_logs_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 414 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bidding_download_logs
-- ----------------------------
INSERT INTO `bidding_download_logs` VALUES (400, 720, '黎语寻', '蔡琳', '15115020663', '23689@aao.cos', '2023-12-15 15:30:42', 0);
INSERT INTO `bidding_download_logs` VALUES (401, 721, '宋海昌', '程海超', '19343882527', '3578sgd@wh.sdg', '2023-06-22 17:33:37', 0);
INSERT INTO `bidding_download_logs` VALUES (402, 722, '许鸿博', '古清生', '18245838921', '272456@qq.com', '2023-12-16 06:34:11', 0);
INSERT INTO `bidding_download_logs` VALUES (403, 725, '金文明', '戴鹏飞', '17772724032', '3437319@qq.com', '2023-07-18 15:34:49', 0);
INSERT INTO `bidding_download_logs` VALUES (404, 726, '高建华', '曹天予', '17772724032', '3437319@qq.com', '2023-07-18 06:41:49', 0);
INSERT INTO `bidding_download_logs` VALUES (405, 729, '曹旭', '旷新年', '18328200238', '928356@qq.com', '2023-12-19 15:36:17', 0);
INSERT INTO `bidding_download_logs` VALUES (406, 730, '何员外', '古清生', '18328200238', '928356@qq.com', '2023-12-19 15:36:17', 0);
INSERT INTO `bidding_download_logs` VALUES (407, 731, '黎语寻', '蔡琳', '15115020663', '23689@aao.cos', '2023-12-15 15:30:42', 0);
INSERT INTO `bidding_download_logs` VALUES (408, 732, '宋海昌', '程海超', '19343882527', '3578sgd@wh.sdg', '2023-06-22 17:33:37', 0);
INSERT INTO `bidding_download_logs` VALUES (409, 733, '宋海昌', '程海超', '19343882527', '3578sgd@wh.sdg', '2023-06-22 17:33:37', 0);
INSERT INTO `bidding_download_logs` VALUES (410, 723, '许鸿博', '古清生', '18245838921', '272456@qq.com', '2023-12-16 06:34:11', 0);
INSERT INTO `bidding_download_logs` VALUES (411, 724, '高建华', '曹天予', '17772724032', '3437319@qq.com', '2023-07-18 06:41:49', 0);
INSERT INTO `bidding_download_logs` VALUES (412, 725, '曹旭', '旷新年', '18328200238', '928356@qq.com', '2023-12-19 15:36:17', 0);
INSERT INTO `bidding_download_logs` VALUES (413, 726, '何员外', '古清生', '18328200238', '928356@qq.com', '2023-12-19 15:36:17', 0);

-- ----------------------------
-- Table structure for bidding_draw_experts
-- ----------------------------
DROP TABLE IF EXISTS `bidding_draw_experts`;
CREATE TABLE `bidding_draw_experts`  (
  `draw_experts_id` int(100) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请编号',
  `draw_expert_id` int(110) NULL DEFAULT NULL COMMENT '专家主键',
  `draw_projects_id` int(110) NULL DEFAULT NULL COMMENT '项目主键',
  `must` int(10) NULL DEFAULT NULL COMMENT '资格审查方式',
  `manner` int(11) NULL DEFAULT NULL COMMENT '抽取方式',
  `conditions` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '抽取条件',
  `evade_experts` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回避专家',
  `experts_number` int(110) NULL DEFAULT NULL COMMENT '专家人数',
  `buy_number` int(110) NULL DEFAULT NULL COMMENT '采购人数',
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评标地点',
  `state` int(11) NULL DEFAULT 0 COMMENT '状态',
  `create_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除',
  PRIMARY KEY (`draw_experts_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2006 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bidding_draw_experts
-- ----------------------------
INSERT INTO `bidding_draw_experts` VALUES (2000, 'CQ-ZJ0102230200001', NULL, 4, 0, 0, NULL, '519,516,', 5, 5, '长沙', 0, 'admin', '2024-01-02 23:02:52', NULL, NULL, 0);
INSERT INTO `bidding_draw_experts` VALUES (2001, 'CQ-ZJ0103031900001', NULL, 4804, 0, 0, NULL, '523,', 2, 4, '湖南省长沙市开福区', 0, 'cg-admin', '2024-01-03 03:19:22', NULL, NULL, 0);
INSERT INTO `bidding_draw_experts` VALUES (2002, 'CQ-ZJ0103035400001', NULL, 4806, 0, 1, NULL, NULL, 3, 6, '湖南岳阳', 0, 'cg-admin', '2024-01-03 03:54:18', NULL, NULL, 0);
INSERT INTO `bidding_draw_experts` VALUES (2004, 'CQ-ZJ0103042000003', NULL, 4805, 1, 0, NULL, '515,523,512,', 4, 3, '湖南省长沙市开福区', 0, 'cg-admin', '2024-01-03 04:20:18', NULL, NULL, 0);
INSERT INTO `bidding_draw_experts` VALUES (2005, 'CQ-ZJ0103092900001', NULL, 4810, 0, 0, NULL, '515,527,', 4, 0, '00', 0, 'cg-admin', '2024-01-03 09:29:40', NULL, NULL, 0);

-- ----------------------------
-- Table structure for bidding_extraction_conditions
-- ----------------------------
DROP TABLE IF EXISTS `bidding_extraction_conditions`;
CREATE TABLE `bidding_extraction_conditions`  (
  `extraction_conditions_id` int(100) NOT NULL AUTO_INCREMENT COMMENT '抽取专家表主键',
  `extraction_expert_id` int(100) NULL DEFAULT NULL COMMENT '抽取表主键',
  `specialized` int(100) NULL DEFAULT NULL COMMENT '评标专业',
  `number` int(100) NULL DEFAULT NULL COMMENT '抽取人数',
  `creation_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`extraction_conditions_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 409 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bidding_extraction_conditions
-- ----------------------------
INSERT INTO `bidding_extraction_conditions` VALUES (400, 2000, 2, 3, '2024-01-02 23:02:52');
INSERT INTO `bidding_extraction_conditions` VALUES (401, 2001, 2, 1, '2024-01-03 03:19:22');
INSERT INTO `bidding_extraction_conditions` VALUES (402, 2001, 5, 1, '2024-01-03 03:19:23');
INSERT INTO `bidding_extraction_conditions` VALUES (403, 2004, 1, 2, '2024-01-03 04:20:18');
INSERT INTO `bidding_extraction_conditions` VALUES (404, 2004, 6, 1, '2024-01-03 04:20:19');
INSERT INTO `bidding_extraction_conditions` VALUES (405, 2004, 2, 1, '2024-01-03 04:20:19');
INSERT INTO `bidding_extraction_conditions` VALUES (406, 2005, 1, 2, '2024-01-03 09:29:41');
INSERT INTO `bidding_extraction_conditions` VALUES (407, 2005, 6, 1, '2024-01-03 09:29:41');
INSERT INTO `bidding_extraction_conditions` VALUES (408, 2005, 3, 1, '2024-01-03 09:29:41');

-- ----------------------------
-- Table structure for bidding_get_expert_extract
-- ----------------------------
DROP TABLE IF EXISTS `bidding_get_expert_extract`;
CREATE TABLE `bidding_get_expert_extract`  (
  `get_expert_extract_id` int(100) NOT NULL AUTO_INCREMENT COMMENT '专家被抽取表主键',
  `get_tender_id` int(100) NULL DEFAULT NULL COMMENT '项目表主键',
  `get_expert_id` int(100) NULL DEFAULT NULL COMMENT '抽取表主键',
  `get_pool_id` int(100) NULL DEFAULT NULL COMMENT '专家表主键',
  `creation_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`get_expert_extract_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 49 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bidding_get_expert_extract
-- ----------------------------
INSERT INTO `bidding_get_expert_extract` VALUES (34, 4, 2000, 515, '2024-01-02 23:02:53');
INSERT INTO `bidding_get_expert_extract` VALUES (35, 4804, 2001, 516, '2024-01-03 03:19:22');
INSERT INTO `bidding_get_expert_extract` VALUES (36, 4804, 2001, 521, '2024-01-03 03:19:23');
INSERT INTO `bidding_get_expert_extract` VALUES (37, 4806, 2002, 519, '2024-01-03 03:54:18');
INSERT INTO `bidding_get_expert_extract` VALUES (38, 4806, 2002, 525, '2024-01-03 03:54:18');
INSERT INTO `bidding_get_expert_extract` VALUES (39, 4806, 2002, 527, '2024-01-03 03:54:19');
INSERT INTO `bidding_get_expert_extract` VALUES (43, 4805, 2004, 514, '2024-01-03 04:20:18');
INSERT INTO `bidding_get_expert_extract` VALUES (44, 4805, 2004, 513, '2024-01-03 04:20:19');
INSERT INTO `bidding_get_expert_extract` VALUES (45, 4805, 2004, 522, '2024-01-03 04:20:19');
INSERT INTO `bidding_get_expert_extract` VALUES (46, 4805, 2004, 518, '2024-01-03 04:20:19');
INSERT INTO `bidding_get_expert_extract` VALUES (47, 4810, 2005, 512, '2024-01-03 09:29:41');
INSERT INTO `bidding_get_expert_extract` VALUES (48, 4810, 2005, 523, '2024-01-03 09:29:41');

-- ----------------------------
-- Table structure for bidding_notice
-- ----------------------------
DROP TABLE IF EXISTS `bidding_notice`;
CREATE TABLE `bidding_notice`  (
  `notice_id` int(100) NOT NULL AUTO_INCREMENT COMMENT '公告id',
  `notice_clod` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公示编号',
  `notice_project_id` int(100) NULL DEFAULT NULL COMMENT '关联项目id（外键）',
  `notice_text_id` int(100) NULL DEFAULT NULL COMMENT '中标公告外键',
  `notice_supplier_id` int(100) NOT NULL COMMENT '供应商外键',
  `notice_date` datetime(0) NULL DEFAULT NULL COMMENT '公告日期',
  `buyer` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发布,远志集团有限公司',
  `notice_title` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公告标题',
  `notice_context` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '公告内容',
  `bid_money` decimal(10, 0) NULL DEFAULT NULL COMMENT '中标金额',
  PRIMARY KEY (`notice_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 658 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bidding_notice
-- ----------------------------
INSERT INTO `bidding_notice` VALUES (650, 'ZB-GS826484736', 4804, NULL, 2445, '2024-01-03 03:31:30', '远志集团有限公司', '莱茵生物中标公示', '<p class=\"ql-align-center\"><strong>中标通知</strong></p><p class=\"ql-align-center\">财办库〔2020〕50号</p><p>各中央预算单位办公厅（室），各省、自治区、直辖市、计划单列市财政厅（局），新疆生产建设兵团财政局：</p><p>	为规范政府采购公告和公示信息发布行为，提高政府采购活动透明度，财政部研究制定了《政府采购公告和公示信息格式规范（2020年版）》，现印发给你们，请遵照执行。</p><p>	各部门、各地区要高度重视政府采购信息公开工作，督促指导采购单位和采购代理机构自2020年7月1日起按照本格式规范编制发布政府采购信息。执行中如遇政策问题，请及时向财政部国库司反馈。</p><p>	附件：政府采购公告和公示信息格式规范（2020年版）</p><p class=\"ql-align-right\">远志办公室</p><p class=\"ql-align-right\">	2020年3月18日</p><p><br></p>', 800);
INSERT INTO `bidding_notice` VALUES (651, 'ZB-GS183321088', 4806, NULL, 2452, '2024-01-03 04:01:28', '远志集团有限公司', '智飞生物中标公示', '<p class=\"ql-align-center\"><strong>中标通知</strong></p><p class=\"ql-align-center\">财办库〔2020〕50号</p><p>各中央预算单位办公厅（室），各省、自治区、直辖市、计划单列市财政厅（局），新疆生产建设兵团财政局：</p><p>	为规范政府采购公告和公示信息发布行为，提高政府采购活动透明度，财政部研究制定了《政府采购公告和公示信息格式规范（2020年版）》，现印发给你们，请遵照执行。</p><p>	各部门、各地区要高度重视政府采购信息公开工作，督促指导采购单位和采购代理机构自2020年7月1日起按照本格式规范编制发布政府采购信息。执行中如遇政策问题，请及时向财政部国库司反馈。</p><p>	附件：政府采购公告和公示信息格式规范（2020年版）</p><p class=\"ql-align-right\">远志办公室</p><p class=\"ql-align-right\">	2020年3月18日</p><p><br></p>', 760);
INSERT INTO `bidding_notice` VALUES (652, 'ZB-GS009598976', 4806, NULL, 2445, '2024-01-03 04:01:28', '远志集团有限公司', '莱茵生物中标公示', '<p class=\"ql-align-center\"><strong>中标通知</strong></p><p class=\"ql-align-center\">财办库〔2020〕50号</p><p>各中央预算单位办公厅（室），各省、自治区、直辖市、计划单列市财政厅（局），新疆生产建设兵团财政局：</p><p>	为规范政府采购公告和公示信息发布行为，提高政府采购活动透明度，财政部研究制定了《政府采购公告和公示信息格式规范（2020年版）》，现印发给你们，请遵照执行。</p><p>	各部门、各地区要高度重视政府采购信息公开工作，督促指导采购单位和采购代理机构自2020年7月1日起按照本格式规范编制发布政府采购信息。执行中如遇政策问题，请及时向财政部国库司反馈。</p><p>	附件：政府采购公告和公示信息格式规范（2020年版）</p><p class=\"ql-align-right\">远志办公室</p><p class=\"ql-align-right\">	2020年3月18日</p><p><br></p>', 800);
INSERT INTO `bidding_notice` VALUES (653, 'ZB-GS668104704', 4806, NULL, 2447, '2024-01-03 04:01:28', '远志集团有限公司', '同仁堂中标公示', '<p class=\"ql-align-center\"><strong>中标通知</strong></p><p class=\"ql-align-center\">财办库〔2020〕50号</p><p>各中央预算单位办公厅（室），各省、自治区、直辖市、计划单列市财政厅（局），新疆生产建设兵团财政局：</p><p>	为规范政府采购公告和公示信息发布行为，提高政府采购活动透明度，财政部研究制定了《政府采购公告和公示信息格式规范（2020年版）》，现印发给你们，请遵照执行。</p><p>	各部门、各地区要高度重视政府采购信息公开工作，督促指导采购单位和采购代理机构自2020年7月1日起按照本格式规范编制发布政府采购信息。执行中如遇政策问题，请及时向财政部国库司反馈。</p><p>	附件：政府采购公告和公示信息格式规范（2020年版）</p><p class=\"ql-align-right\">远志办公室</p><p class=\"ql-align-right\">	2020年3月18日</p><p><br></p>', 790);
INSERT INTO `bidding_notice` VALUES (654, 'ZB-GS184158208', 4805, NULL, 2452, '2024-01-03 04:21:40', '远志集团有限公司', '智飞生物中标公示', '<p class=\"ql-align-center\"><strong>中标通知</strong></p><p class=\"ql-align-center\">财办库〔2020〕50号</p><p>各中央预算单位办公厅（室），各省、自治区、直辖市、计划单列市财政厅（局），新疆生产建设兵团财政局：</p><p>	为规范政府采购公告和公示信息发布行为，提高政府采购活动透明度，财政部研究制定了《政府采购公告和公示信息格式规范（2020年版）》，现印发给你们，请遵照执行。</p><p>	各部门、各地区要高度重视政府采购信息公开工作，督促指导采购单位和采购代理机构自2020年7月1日起按照本格式规范编制发布政府采购信息。执行中如遇政策问题，请及时向财政部国库司反馈。</p><p>	附件：政府采购公告和公示信息格式规范（2020年版）</p><p class=\"ql-align-right\">远志办公室</p><p class=\"ql-align-right\">	2020年3月18日</p>', 760);
INSERT INTO `bidding_notice` VALUES (655, 'ZB-GS855246848', 4805, NULL, 2445, '2024-01-03 04:21:40', '远志集团有限公司', '莱茵生物中标公示', '<p class=\"ql-align-center\"><strong>中标通知</strong></p><p class=\"ql-align-center\">财办库〔2020〕50号</p><p>各中央预算单位办公厅（室），各省、自治区、直辖市、计划单列市财政厅（局），新疆生产建设兵团财政局：</p><p>	为规范政府采购公告和公示信息发布行为，提高政府采购活动透明度，财政部研究制定了《政府采购公告和公示信息格式规范（2020年版）》，现印发给你们，请遵照执行。</p><p>	各部门、各地区要高度重视政府采购信息公开工作，督促指导采购单位和采购代理机构自2020年7月1日起按照本格式规范编制发布政府采购信息。执行中如遇政策问题，请及时向财政部国库司反馈。</p><p>	附件：政府采购公告和公示信息格式规范（2020年版）</p><p class=\"ql-align-right\">远志办公室</p><p class=\"ql-align-right\">	2020年3月18日</p><p><br></p>', 600);
INSERT INTO `bidding_notice` VALUES (656, 'ZB-GS538918400', 4805, NULL, 2456, '2024-01-03 04:21:40', '远志集团有限公司', '华海药业中标公示', '<p class=\"ql-align-center\"><strong>中标通知</strong></p><p class=\"ql-align-center\">财办库〔2020〕50号</p><p>各中央预算单位办公厅（室），各省、自治区、直辖市、计划单列市财政厅（局），新疆生产建设兵团财政局：</p><p>	为规范政府采购公告和公示信息发布行为，提高政府采购活动透明度，财政部研究制定了《政府采购公告和公示信息格式规范（2020年版）》，现印发给你们，请遵照执行。</p><p>	各部门、各地区要高度重视政府采购信息公开工作，督促指导采购单位和采购代理机构自2020年7月1日起按照本格式规范编制发布政府采购信息。执行中如遇政策问题，请及时向财政部国库司反馈。</p><p>	附件：政府采购公告和公示信息格式规范（2020年版）</p><p class=\"ql-align-right\">远志办公室</p><p class=\"ql-align-right\">	2020年3月18日</p><p><br></p>', 650);
INSERT INTO `bidding_notice` VALUES (657, 'ZB-GS545920512', 4810, NULL, 2452, '2024-01-03 09:31:57', '远志集团有限公司', '智飞生物中标公示', '<p class=\"ql-align-center\"><strong>中标通知</strong></p><p class=\"ql-align-center\">财办库〔2020〕50号</p><p>各中央预算单位办公厅（室），各省、自治区、直辖市、计划单列市财政厅（局），新疆生产建设兵团财政局：</p><p>	为规范政府采购公告和公示信息发布行为，提高政府采购活动透明度，财政部研究制定了《政府采购公告和公示信息格式规范（2020年版）》，现印发给你们，请遵照执行。</p><p>	各部门、各地区要高度重视政府采购信息公开工作，督促指导采购单位和采购代理机构自2020年7月1日起按照本格式规范编制发布政府采购信息。执行中如遇政策问题，请及时向财政部国库司反馈。</p><p>	附件：政府采购公告和公示信息格式规范（2020年版）</p><p class=\"ql-align-right\">远志办公室</p><p class=\"ql-align-right\">	2020年3月18日</p><p><br></p>', 760);

-- ----------------------------
-- Table structure for bidding_notice_text
-- ----------------------------
DROP TABLE IF EXISTS `bidding_notice_text`;
CREATE TABLE `bidding_notice_text`  (
  `notice_text_id` int(100) NOT NULL AUTO_INCREMENT COMMENT '公告正文主键',
  `tender_notice_id` int(100) NULL DEFAULT NULL COMMENT '招标公告ID',
  `notice_address` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '正文',
  `upload_time` datetime(0) NULL DEFAULT NULL COMMENT '上传当前时间',
  `upload_by` int(11) NULL DEFAULT NULL COMMENT '上传人',
  PRIMARY KEY (`notice_text_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 300 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for bidding_tender
-- ----------------------------
DROP TABLE IF EXISTS `bidding_tender`;
CREATE TABLE `bidding_tender`  (
  `tender_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tender_notice_id` int(11) NULL DEFAULT NULL COMMENT '招标公告ID',
  `tender_supplier_id` int(11) NULL DEFAULT NULL COMMENT '供应商（外键）',
  `tender_supplier_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商名称',
  `tender_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投标人名称',
  `contact` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `phone` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '移动电话',
  `tender_time` datetime(0) NULL DEFAULT NULL COMMENT '投标时间',
  `ip_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '127.0.0.1' COMMENT 'IP地址',
  `prices` decimal(10, 0) NULL DEFAULT NULL COMMENT '总价',
  `score` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评分',
  `recommend` int(11) NULL DEFAULT 0 COMMENT '是否推荐',
  `ranking` int(11) NULL DEFAULT NULL COMMENT '排名',
  `state` int(11) NULL DEFAULT 1 COMMENT '状态',
  `tender_annex_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标书文件地址外键',
  PRIMARY KEY (`tender_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 625 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bidding_tender
-- ----------------------------
INSERT INTO `bidding_tender` VALUES (600, 731, 2452, '智飞生物', '周桢跃', '郑冶苹', '18036755244', '2024-01-03 03:02:33', '127.0.0.1', 760, '79', 0, 3, 6, '962');
INSERT INTO `bidding_tender` VALUES (601, 733, 2452, '智飞生物', '周桢跃', '郑冶苹', '18036755244', '2024-01-03 03:07:18', '127.0.0.1', 21000, NULL, 0, NULL, 1, '');
INSERT INTO `bidding_tender` VALUES (602, 729, 2452, '智飞生物', '周桢跃', '郑冶苹', '18036755244', '2024-01-03 03:07:59', '127.0.0.1', 320, NULL, 0, NULL, 1, '');
INSERT INTO `bidding_tender` VALUES (603, 721, 2452, '智飞生物', '周桢跃', '郑冶苹', '18036755244', '2024-01-03 03:08:30', '127.0.0.1', 540000, NULL, 0, NULL, 1, '963');
INSERT INTO `bidding_tender` VALUES (604, 729, 2452, '智飞生物', '周桢跃', '郑冶苹', '18036755244', '2024-01-03 03:09:02', '127.0.0.1', 700, '95', 0, 1, 6, '964');
INSERT INTO `bidding_tender` VALUES (605, 728, 2445, '莱茵生物', '喻唯琪', '荣津', '15626011679', '2024-01-03 03:09:55', '127.0.0.1', 600, '72', 0, 2, 6, '965');
INSERT INTO `bidding_tender` VALUES (606, 731, 2445, '莱茵生物', '喻唯琪', '荣津', '15626011679', '2024-01-03 03:10:15', '127.0.0.1', 800, '97', 0, 1, 6, '966');
INSERT INTO `bidding_tender` VALUES (607, 724, 2445, '莱茵生物', '喻唯琪', '荣津', '15626011679', '2024-01-03 03:10:37', '127.0.0.1', 37010, NULL, 0, NULL, 3, '967');
INSERT INTO `bidding_tender` VALUES (608, 726, 2445, '莱茵生物', '喻唯琪', '荣津', '15626011679', '2024-01-03 03:11:15', '127.0.0.1', 800, '95', 0, 1, 6, '968');
INSERT INTO `bidding_tender` VALUES (609, 720, 2445, '莱茵生物', '喻唯琪', '荣津', '15626011679', '2024-01-03 03:11:56', '127.0.0.1', 218400, NULL, 0, NULL, 1, '969');
INSERT INTO `bidding_tender` VALUES (610, 732, 2445, '莱茵生物', '喻唯琪', '荣津', '15626011679', '2024-01-03 03:12:17', '127.0.0.1', 169100, NULL, 0, NULL, 4, '970');
INSERT INTO `bidding_tender` VALUES (611, 728, 2454, '乐普医疗', '马达', '荣昊革', '18369593397', '2024-01-03 03:12:46', '127.0.0.1', 440, NULL, 0, NULL, 3, '971');
INSERT INTO `bidding_tender` VALUES (612, 732, 2454, '乐普医疗', '马达', '荣昊革', '18369593397', '2024-01-03 03:13:05', '127.0.0.1', 56000, NULL, 0, NULL, 3, '972');
INSERT INTO `bidding_tender` VALUES (613, 723, 2454, '乐普医疗', '马达', '荣昊革', '18369593397', '2024-01-03 03:13:30', '127.0.0.1', 132800, NULL, 0, NULL, 1, '973');
INSERT INTO `bidding_tender` VALUES (614, 728, 2456, '华海药业', '黄璋', '计韬连', '16559223766', '2024-01-03 03:14:02', '127.0.0.1', 650, '66', 1, 3, 6, '974');
INSERT INTO `bidding_tender` VALUES (615, 724, 2456, '华海药业', '黄璋', '计韬连', '16559223766', '2024-01-03 03:14:20', '127.0.0.1', 790, '94', 1, 2, 7, '975');
INSERT INTO `bidding_tender` VALUES (616, 720, 2456, '华海药业', '黄璋', '计韬连', '16559223766', '2024-01-03 03:14:39', '127.0.0.1', 678300, NULL, 0, NULL, 1, '976');
INSERT INTO `bidding_tender` VALUES (617, 729, 2446, '益佰制药', '汪战向', '滑昊宣', '18894306148', '2024-01-03 03:15:43', '127.0.0.1', 780, '77', 1, 4, 7, '977');
INSERT INTO `bidding_tender` VALUES (618, 727, 2446, '益佰制药', '汪战向', '滑昊宣', '18894306148', '2024-01-03 03:16:02', '127.0.0.1', 397, NULL, 0, NULL, 4, '978');
INSERT INTO `bidding_tender` VALUES (619, 720, 2446, '益佰制药', '汪战向', '滑昊宣', '18894306148', '2024-01-03 03:16:24', '127.0.0.1', 371200, NULL, 0, NULL, 1, '979');
INSERT INTO `bidding_tender` VALUES (620, 732, 2446, '益佰制药', '汪战向', '滑昊宣', '18894306148', '2024-01-03 03:16:42', '127.0.0.1', 767, '76', 1, 4, 7, '980');
INSERT INTO `bidding_tender` VALUES (621, 731, 2447, '同仁堂', '罗达勋', '苏盟坤', '18193127619', '2024-01-03 03:17:18', '127.0.0.1', 790, '68', 0, 2, 6, '981');
INSERT INTO `bidding_tender` VALUES (622, 721, 2447, '同仁堂', '罗达勋', '苏盟坤', '18193127619', '2024-01-03 03:17:36', '127.0.0.1', 1002200, NULL, 0, NULL, 1, '982');
INSERT INTO `bidding_tender` VALUES (623, 734, 2452, '智飞生物', '周桢跃', '郑冶苹', '18036755244', '2024-01-03 09:26:32', '127.0.0.1', 500, '89', 1, 1, 6, '1001');
INSERT INTO `bidding_tender` VALUES (624, 734, 2452, '智飞生物', '周桢跃', '郑冶苹', '18036755244', '2024-01-03 09:27:17', '127.0.0.1', 66000, NULL, 0, NULL, 1, '1002');

-- ----------------------------
-- Table structure for bidding_tender_manifest
-- ----------------------------
DROP TABLE IF EXISTS `bidding_tender_manifest`;
CREATE TABLE `bidding_tender_manifest`  (
  `tender_manifest_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键（招标详情表）',
  `manifest_projects_id` int(11) NULL DEFAULT NULL COMMENT '招标项目（外键）',
  `manifest_goods_id` int(11) NULL DEFAULT NULL COMMENT '物料（外键键）',
  `number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请编号',
  `manifest_type_id` int(11) NULL DEFAULT NULL COMMENT '计量单位（数据字典外键）',
  `price` decimal(10, 0) NULL DEFAULT NULL COMMENT '单价',
  `prices` decimal(10, 0) NULL DEFAULT NULL COMMENT '总价',
  `explains` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数量',
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除',
  PRIMARY KEY (`tender_manifest_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3247 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bidding_tender_manifest
-- ----------------------------
INSERT INTO `bidding_tender_manifest` VALUES (3220, 4800, 12, NULL, 11, 89, 8900, '100', '', 0);
INSERT INTO `bidding_tender_manifest` VALUES (3221, 4800, 9, NULL, 5, 80, 80000, '1000', '', 0);
INSERT INTO `bidding_tender_manifest` VALUES (3222, 4800, 17, NULL, 6, 5, 5000, '1000', '', 0);
INSERT INTO `bidding_tender_manifest` VALUES (3223, 4801, 14, NULL, 11, 89, 8900, '100', '', 0);
INSERT INTO `bidding_tender_manifest` VALUES (3224, 4801, 17, NULL, 6, 5, 5000, '1000', '', 0);
INSERT INTO `bidding_tender_manifest` VALUES (3225, 4802, 37, NULL, 0, 10, 1000, '100', '', 0);
INSERT INTO `bidding_tender_manifest` VALUES (3226, 4802, 24, NULL, 0, 31, 27900, '900', '', 0);
INSERT INTO `bidding_tender_manifest` VALUES (3227, 4803, 21, NULL, 6, 10, 1000, '100', '', 0);
INSERT INTO `bidding_tender_manifest` VALUES (3228, 4803, 17, NULL, 0, 31, 27900, '900', '', 0);
INSERT INTO `bidding_tender_manifest` VALUES (3229, 4804, 10, NULL, 6, 20, 404, '20', '1', 0);
INSERT INTO `bidding_tender_manifest` VALUES (3230, 4804, 11, NULL, 1, 15, 150, '10', '2', 0);
INSERT INTO `bidding_tender_manifest` VALUES (3231, 4804, 38, NULL, 5, 24, 720, '30', '3', 0);
INSERT INTO `bidding_tender_manifest` VALUES (3232, 4805, 9, NULL, 2, 20000, 80000, '4', NULL, 0);
INSERT INTO `bidding_tender_manifest` VALUES (3233, 4805, 15, NULL, 2, 12000, 36000, '3', NULL, 0);
INSERT INTO `bidding_tender_manifest` VALUES (3234, 4806, 12, NULL, 11, 20, 10050, '500', NULL, 0);
INSERT INTO `bidding_tender_manifest` VALUES (3235, 4806, 16, NULL, 11, 12, 3690, '300', NULL, 0);
INSERT INTO `bidding_tender_manifest` VALUES (3236, 4806, 17, NULL, 6, 20, 4000, '200', NULL, 0);
INSERT INTO `bidding_tender_manifest` VALUES (3237, 4807, 14, NULL, 0, 9, 621, '69', '', 0);
INSERT INTO `bidding_tender_manifest` VALUES (3238, 4807, 19, NULL, 9, 7, 301, '43', '', 0);
INSERT INTO `bidding_tender_manifest` VALUES (3239, 4808, 9, NULL, 2, 8999, 107988, '12', NULL, 0);
INSERT INTO `bidding_tender_manifest` VALUES (3240, 4808, 15, NULL, 2, 4388, 61432, '14', NULL, 0);
INSERT INTO `bidding_tender_manifest` VALUES (3241, 4808, 31, NULL, 2, 2000, 22000, '11', NULL, 0);
INSERT INTO `bidding_tender_manifest` VALUES (3242, 4809, 21, NULL, 6, 15, 15000, '1000', NULL, 0);
INSERT INTO `bidding_tender_manifest` VALUES (3243, 4809, 22, NULL, 6, 21, 4240, '200', NULL, 0);
INSERT INTO `bidding_tender_manifest` VALUES (3244, 4810, 10, NULL, NULL, 80, 8000, '100', '', 0);
INSERT INTO `bidding_tender_manifest` VALUES (3245, 4810, 16, NULL, NULL, 30, 3000, '100', '', 0);
INSERT INTO `bidding_tender_manifest` VALUES (3246, 4810, 17, NULL, NULL, 40, 4000, '100', '', 0);

-- ----------------------------
-- Table structure for bidding_tender_notice
-- ----------------------------
DROP TABLE IF EXISTS `bidding_tender_notice`;
CREATE TABLE `bidding_tender_notice`  (
  `tender_notice_id` int(100) NOT NULL AUTO_INCREMENT COMMENT '招标公告ID',
  `tender_notice_projects_id` int(100) NULL DEFAULT NULL COMMENT '关联项目（外键）',
  `tender_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公告标题',
  `tender_notice_monery` decimal(10, 0) NULL DEFAULT NULL COMMENT '项目资金',
  `bid_start` datetime(0) NULL DEFAULT NULL COMMENT '投标开始时间',
  `bid_end` datetime(0) NULL DEFAULT NULL COMMENT '投标结束时间',
  `kaibiao_start` datetime(0) NULL DEFAULT NULL COMMENT '开标开始时间',
  `kaibiao_end` datetime(0) NULL DEFAULT NULL COMMENT '开标结束时间',
  `process_start` datetime(0) NULL DEFAULT NULL COMMENT '流程开始时间',
  `process_end` datetime(0) NULL DEFAULT NULL COMMENT '流程结束时间',
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `context` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '正文',
  `tenders` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标书',
  `state` int(11) NULL DEFAULT 0 COMMENT '状态',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除',
  PRIMARY KEY (`tender_notice_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 735 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bidding_tender_notice
-- ----------------------------
INSERT INTO `bidding_tender_notice` VALUES (720, 4800, '收拾器械招标通知', 800000, '2024-01-03 17:17:00', '2024-01-31 12:12:00', '2024-01-11 09:00:00', '2024-01-15 21:00:00', '2024-01-19 12:00:00', '2024-01-24 10:00:00', NULL, '<h1 class=\"ql-align-center\"><strong>招标公告</strong></h1><p>																																															招标公告KZBGG2024010002号</p><p>&nbsp;&nbsp;手术器械采购招标有限公司受招标人委托，对华润医药山东区域2024年度第1批招标华润青岛医药有限公司门诊药房及静配中心智能化管理项目进行公开招标。</p><p><strong>一、项目基本情况</strong></p><p>&nbsp;&nbsp;招标人：华润青岛医药有限公司</p><p>&nbsp;&nbsp;招标代理机构：华润守正招标有限公司</p><p>&nbsp;&nbsp;项目地点：所有产品的交货地点均由采购人指定（山东省境内）</p><p>&nbsp;&nbsp;项目规模：/</p><p>&nbsp;&nbsp;项目资金来源：自筹</p><p>&nbsp;&nbsp;招标编号：K99904024SZ0001P1</p><p>&nbsp;&nbsp;项目名称：华润青岛医药有限公司</p><p>&nbsp;&nbsp;标段名称：门诊药房及静配中心智能化管理项目</p><p>&nbsp;&nbsp;招标内容和范围：门诊药房智能发药系统、静配中心智能分拣贴签一体机</p><p>&nbsp;&nbsp;主要指标：</p><p>&nbsp;&nbsp;交货期/工期：自签订合同之日起1个月内供货、安装调试并验收完毕。</p><p>&nbsp;&nbsp;供应商可根据自身情况自报最快交货时间。</p><p>&nbsp;&nbsp;注：详细内容见招标文件，以招标文件为准。</p><p><strong>二、投标人资格能力要求</strong></p><p>&nbsp;&nbsp;1.资格要求：投标人为中华人民共和国境内合法注册的独立法人或其他组织，具有独立订立合同的权利。</p><p>&nbsp;&nbsp;2.业绩要求：无</p><p>&nbsp;&nbsp;3.联合体投标：不允许</p><p>&nbsp;&nbsp;4.代理商投标：允许</p><p>&nbsp;&nbsp;5.信誉要求：不属于在国家公共信用信息中心“信用中国”网（www.creditchina.gov.cn）列入失信惩戒名单</p><p>&nbsp;&nbsp;6.其他要求：无</p><p>&nbsp;&nbsp;备注：</p><p><strong>三、招标文件的获取</strong></p><p>&nbsp;&nbsp;（一）获取时间</p><p>&nbsp;&nbsp;&nbsp;&nbsp;2024年01月02日- 2024年01月09日</p><p>&nbsp;&nbsp;（二）招标文件获取方式</p><p>&nbsp;&nbsp;&nbsp;&nbsp;在华润集团守正电子招标平台(https://szecp.crc.com.cn)在线下载，不接受来人现场领取。</p><p>&nbsp;&nbsp;（三）投标人提问截止时间</p><p>&nbsp;&nbsp;&nbsp;&nbsp;2024年01月10日 8:00</p><p><strong>四、截标/开标时间、地点</strong></p><p>&nbsp;&nbsp;截标/开标时间：2024/01/15 09:00:00（北京时间，若有变化另行通知）</p><p>&nbsp;&nbsp;截标/开标地点：网上开标大厅/网上开标大厅(若有变化另行通知)</p><p><strong>五、招标人及其招标代理机构联系方式</strong></p><p>&nbsp;&nbsp;招标人：华润青岛医药有限公司</p><p>&nbsp;&nbsp;地址：青岛市李沧区广水路616号</p><p>&nbsp;&nbsp;联系人：赵莹</p><p>&nbsp;&nbsp;电话：15906396220</p><p>&nbsp;&nbsp;招标代理机构：华润守正招标有限公司</p><p>&nbsp;&nbsp;地址：深圳市前海深港合作区南山街道梦海大道5035号前海华润金融中心T5写字楼3501</p><p>&nbsp;&nbsp;联系人：赵锐</p><p>&nbsp;&nbsp;电话：0755-29395797-3379</p>', NULL, 1, 0);
INSERT INTO `bidding_tender_notice` VALUES (721, 4800, '关于手术器械招标公告', 800000, '2024-01-05 11:00:00', '2024-01-31 16:00:00', '2024-01-13 12:00:00', '2024-01-19 02:00:00', '2024-01-19 23:00:00', '2024-01-24 13:00:00', '关于手术器械招标公告2.0', '<h2 class=\"ql-align-center\"><strong>招标公告</strong></h2><p>招标公告KZBGG2024010002号</p><p>&nbsp;&nbsp;华润守正招标有限公司受招标人委托，对华润医药山东区域2024年度第1批招标华润青岛医药有限公司门诊药房及静配中心智能化管理项目进行公开招标。</p><p><strong>一、项目基本情况</strong></p><p>&nbsp;&nbsp;招标人：华润青岛医药有限公司</p><p>&nbsp;&nbsp;招标代理机构：华润守正招标有限公司</p><p>&nbsp;&nbsp;项目地点：所有产品的交货地点均由采购人指定（山东省境内）</p><p>&nbsp;&nbsp;项目规模：/</p><p>&nbsp;&nbsp;项目资金来源：自筹</p><p>&nbsp;&nbsp;招标编号：K99904024SZ0001P1</p><p>&nbsp;&nbsp;项目名称：华润青岛医药有限公司</p><p>&nbsp;&nbsp;标段名称：门诊药房及静配中心智能化管理项目</p><p>&nbsp;&nbsp;招标内容和范围：门诊药房智能发药系统、静配中心智能分拣贴签一体机</p><p>&nbsp;&nbsp;主要指标：</p><p>&nbsp;&nbsp;交货期/工期：自签订合同之日起1个月内供货、安装调试并验收完毕。</p><p>&nbsp;&nbsp;供应商可根据自身情况自报最快交货时间。</p><p>&nbsp;&nbsp;注：详细内容见招标文件，以招标文件为准。</p><p><strong>二、投标人资格能力要求</strong></p><p>&nbsp;&nbsp;1.资格要求：投标人为中华人民共和国境内合法注册的独立法人或其他组织，具有独立订立合同的权利。</p><p>&nbsp;&nbsp;2.业绩要求：无</p><p>&nbsp;&nbsp;3.联合体投标：不允许</p><p>&nbsp;&nbsp;4.代理商投标：允许</p><p>&nbsp;&nbsp;5.信誉要求：不属于在国家公共信用信息中心“信用中国”网（www.creditchina.gov.cn）列入失信惩戒名单</p><p>&nbsp;&nbsp;6.其他要求：无</p><p>&nbsp;&nbsp;备注：</p><p><strong>三、招标文件的获取</strong></p><p>&nbsp;&nbsp;（一）获取时间</p><p>&nbsp;&nbsp;&nbsp;&nbsp;2024年01月02日- 2024年01月09日</p><p>&nbsp;&nbsp;（二）招标文件获取方式</p><p>&nbsp;&nbsp;&nbsp;&nbsp;在华润集团守正电子招标平台(https://szecp.crc.com.cn)在线下载，不接受来人现场领取。</p><p>&nbsp;&nbsp;（三）投标人提问截止时间</p><p>&nbsp;&nbsp;&nbsp;&nbsp;2024年01月10日 8:00</p>', NULL, 1, 0);
INSERT INTO `bidding_tender_notice` VALUES (722, 4800, '手术器械采购招标', 800000, '2024-01-06 05:00:00', '2024-01-30 23:00:00', '2024-01-12 15:00:00', '2024-01-19 00:00:00', '2024-01-24 13:00:00', '2024-01-26 15:00:00', NULL, '<h2 class=\"ql-align-center\"><strong>招标公告</strong></h2><p><strong><span class=\"ql-cursor\">﻿</span></strong>招标公告KZBGG2024010002号</p><p>&nbsp;&nbsp;华润守正招标有限公司受招标人委托，对华润医药山东区域2024年度第1批招标华润青岛医药有限公司门诊药房及静配中心智能化管理项目进行公开招标。</p><p><strong>一、项目基本情况</strong></p><p>&nbsp;&nbsp;招标人：华润青岛医药有限公司</p><p>&nbsp;&nbsp;招标代理机构：华润守正招标有限公司</p><p>&nbsp;&nbsp;项目地点：所有产品的交货地点均由采购人指定（山东省境内）</p><p>&nbsp;&nbsp;项目规模：/</p><p>&nbsp;&nbsp;项目资金来源：自筹</p><p>&nbsp;&nbsp;招标编号：K99904024SZ0001P1</p><p>&nbsp;&nbsp;项目名称：华润青岛医药有限公司</p><p>&nbsp;&nbsp;标段名称：门诊药房及静配中心智能化管理项目</p><p>&nbsp;&nbsp;招标内容和范围：门诊药房智能发药系统、静配中心智能分拣贴签一体机</p><p>&nbsp;&nbsp;主要指标：</p><p>&nbsp;&nbsp;交货期/工期：自签订合同之日起1个月内供货、安装调试并验收完毕。</p><p>&nbsp;&nbsp;供应商可根据自身情况自报最快交货时间。</p><p>&nbsp;&nbsp;注：详细内容见招标文件，以招标文件为准。</p><p><strong>二、投标人资格能力要求</strong></p><p>&nbsp;&nbsp;1.资格要求：投标人为中华人民共和国境内合法注册的独立法人或其他组织，具有独立订立合同的权利。</p><p>&nbsp;&nbsp;2.业绩要求：无</p><p>&nbsp;&nbsp;3.联合体投标：不允许</p><p>&nbsp;&nbsp;4.代理商投标：允许</p><p>&nbsp;&nbsp;5.信誉要求：不属于在国家公共信用信息中心“信用中国”网（www.creditchina.gov.cn）列入失信惩戒名单</p><p>&nbsp;&nbsp;6.其他要求：无</p><p>&nbsp;&nbsp;备注：</p><p><strong>三、招标文件的获取</strong></p><p>&nbsp;&nbsp;（一）获取时间</p><p>&nbsp;&nbsp;&nbsp;&nbsp;2024年01月02日- 2024年01月09日</p><p>&nbsp;&nbsp;（二）招标文件获取方式</p><p>&nbsp;&nbsp;&nbsp;&nbsp;在华润集团守正电子招标平台(https://szecp.crc.com.cn)在线下载，不接受来人现场领取。</p><p>&nbsp;&nbsp;（三）投标人提问截止时间</p><p>&nbsp;&nbsp;&nbsp;&nbsp;2024年01月10日 8:00</p><p><strong>四、截标/开标时间、地点</strong></p><p>&nbsp;&nbsp;截标/开标时间：2024/01/15 09:00:00（北京时间，若有变化另行通知）</p><p>&nbsp;&nbsp;截标/开标地点：网上开标大厅/网上开标大厅(若有变化另行通知)</p><p><strong>五、招标人及其招标代理机构联系方式</strong></p><p>&nbsp;&nbsp;招标人：华润青岛医药有限公司</p><p>&nbsp;&nbsp;地址：青岛市李沧区广水路616号</p><p>&nbsp;&nbsp;联系人：赵莹</p><p>&nbsp;&nbsp;电话：15906396220</p><p>&nbsp;&nbsp;招标代理机构：华润守正招标有限公司</p><p>&nbsp;&nbsp;地址：深圳市前海深港合作区南山街道梦海大道5035号前海华润金融中心T5写字楼3501</p><p>&nbsp;&nbsp;联系人：赵锐</p><p>&nbsp;&nbsp;电话：0755-29395797-3379</p>', NULL, 2, 0);
INSERT INTO `bidding_tender_notice` VALUES (723, 4800, '手术器械本季度最后一次招标', 800000, '2024-01-07 18:00:00', '2024-01-26 07:00:00', '2024-01-16 07:00:00', '2024-01-18 19:00:00', '2024-01-24 17:00:00', '2024-01-25 02:00:00', NULL, '<h2 class=\"ql-align-center\"><strong>招标公告</strong></h2><p>招标公告KZBGG2024010002号</p><p>&nbsp;&nbsp;华润守正招标有限公司受招标人委托，对华润医药山东区域2024年度第1批招标华润青岛医药有限公司门诊药房及静配中心智能化管理项目进行公开招标。</p><p><strong>一、项目基本情况</strong></p><p>&nbsp;&nbsp;招标人：华润青岛医药有限公司</p><p>&nbsp;&nbsp;招标代理机构：华润守正招标有限公司</p><p>&nbsp;&nbsp;项目地点：所有产品的交货地点均由采购人指定（山东省境内）</p><p>&nbsp;&nbsp;项目规模：/</p><p>&nbsp;&nbsp;项目资金来源：自筹</p><p>&nbsp;&nbsp;招标编号：K99904024SZ0001P1</p><p>&nbsp;&nbsp;项目名称：华润青岛医药有限公司</p><p>&nbsp;&nbsp;标段名称：门诊药房及静配中心智能化管理项目</p><p>&nbsp;&nbsp;招标内容和范围：门诊药房智能发药系统、静配中心智能分拣贴签一体机</p><p>&nbsp;&nbsp;主要指标：</p><p>&nbsp;&nbsp;交货期/工期：自签订合同之日起1个月内供货、安装调试并验收完毕。</p><p>&nbsp;&nbsp;供应商可根据自身情况自报最快交货时间。</p><p>&nbsp;&nbsp;注：详细内容见招标文件，以招标文件为准。</p><p><strong>二、投标人资格能力要求</strong></p><p>&nbsp;&nbsp;1.资格要求：投标人为中华人民共和国境内合法注册的独立法人或其他组织，具有独立订立合同的权利。</p><p>&nbsp;&nbsp;2.业绩要求：无</p><p>&nbsp;&nbsp;3.联合体投标：不允许</p><p>&nbsp;&nbsp;4.代理商投标：允许</p><p>&nbsp;&nbsp;5.信誉要求：不属于在国家公共信用信息中心“信用中国”网（www.creditchina.gov.cn）列入失信惩戒名单</p><p>&nbsp;&nbsp;6.其他要求：无</p><p>&nbsp;&nbsp;备注：</p><p><strong>三、招标文件的获取</strong></p><p>&nbsp;&nbsp;（一）获取时间</p><p>&nbsp;&nbsp;&nbsp;&nbsp;2024年01月02日- 2024年01月09日</p><p>&nbsp;&nbsp;（二）招标文件获取方式</p><p>&nbsp;&nbsp;&nbsp;&nbsp;在华润集团守正电子招标平台(https://szecp.crc.com.cn)在线下载，不接受来人现场领取。</p><p>&nbsp;&nbsp;（三）投标人提问截止时间</p><p>&nbsp;&nbsp;&nbsp;&nbsp;2024年01月10日 8:00</p><p><strong>四、截标/开标时间、地点</strong></p><p>&nbsp;&nbsp;截标/开标时间：2024/01/15 09:00:00（北京时间，若有变化另行通知）</p><p>&nbsp;&nbsp;截标/开标地点：网上开标大厅/网上开标大厅(若有变化另行通知)</p><p><strong>五、招标人及其招标代理机构联系方式</strong></p><p>&nbsp;&nbsp;招标人：华润青岛医药有限公司</p><p>&nbsp;&nbsp;地址：青岛市李沧区广水路616号</p><p>&nbsp;&nbsp;联系人：赵莹</p><p>&nbsp;&nbsp;电话：15906396220</p><p>&nbsp;&nbsp;招标代理机构：华润守正招标有限公司</p><p>&nbsp;&nbsp;地址：深圳市前海深港合作区南山街道梦海大道5035号前海华润金融中心T5写字楼3501</p><p>&nbsp;&nbsp;联系人：赵锐</p><p>&nbsp;&nbsp;电话：0755-29395797-3379</p>', NULL, 1, 0);
INSERT INTO `bidding_tender_notice` VALUES (724, 4804, '公益活动药品招标', 200000, '2024-01-13 03:00:00', '2024-02-13 19:25:18', '2024-01-15 07:06:01', '2024-01-25 05:05:07', '2024-02-02 22:00:00', '2024-02-08 14:00:00', '公益活动药品招标', '<p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">华润守正招标有限公司受招标人委托，对华润医药山东区域2024年度第1批招标华润青岛医药有限公司门诊药房及静配中心智能化管理项目进行公开招标。</span></p><p><strong style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">一、项目基本情况</strong></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;招标人：华润青岛医药有限公司</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;招标代理机构：华润守正招标有限公司</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;项目地点：所有产品的交货地点均由采购人指定（山东省境内）</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;项目规模：/</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;项目资金来源：自筹</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;招标编号：K99904024SZ0001P1</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;项目名称：华润青岛医药有限公司</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;标段名称：门诊药房及静配中心智能化管理项目</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;招标内容和范围：门诊药房智能发药系统、静配中心智能分拣贴签一体机</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;主要指标：</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;交货期/工期：自签订合同之日起1个月内供货、安装调试并验收完毕。</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;供应商可根据自身情况自报最快交货时间。</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;注：详细内容见招标文件，以招标文件为准。</span></p><p><strong style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">二、投标人资格能力要求</strong></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;1.资格要求：投标人为中华人民共和国境内合法注册的独立法人或其他组织，具有独立订立合同的权利。</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;2.业绩要求：无</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;3.联合体投标：不允许</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;4.代理商投标：允许</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;5.信誉要求：不属于在国家公共信用信息中心“信用中国”网（www.creditchina.gov.cn）列入失信惩戒名单</span></p><p><br></p>', NULL, 1, 0);
INSERT INTO `bidding_tender_notice` VALUES (725, 4804, '关于工艺活动药品招标', 200000, '2024-01-16 16:02:07', '2024-02-07 05:06:00', '2024-01-22 08:20:10', '2024-01-26 05:05:06', '2024-02-01 13:13:02', '2024-02-05 12:16:01', '关于工艺活动药品招标2.0', '<p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">华润守正招标有限公司受招标人委托，对华润医药山东区域2024年度第1批招标华润青岛医药有限公司门诊药房及静配中心智能化管理项目进行公开招标。</span></p><p><strong style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">一、项目基本情况</strong></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;招标人：华润青岛医药有限公司</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;招标代理机构：华润守正招标有限公司</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;项目地点：所有产品的交货地点均由采购人指定（山东省境内）</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;项目规模：/</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;项目资金来源：自筹</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;招标编号：K99904024SZ0001P1</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;项目名称：华润青岛医药有限公司</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;标段名称：门诊药房及静配中心智能化管理项目</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;招标内容和范围：门诊药房智能发药系统、静配中心智能分拣贴签一体机</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;主要指标：</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;交货期/工期：自签订合同之日起1个月内供货、安装调试并验收完毕。</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;供应商可根据自身情况自报最快交货时间。</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;注：详细内容见招标文件，以招标文件为准。</span></p><p><strong style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">二、投标人资格能力要求</strong></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;1.资格要求：投标人为中华人民共和国境内合法注册的独立法人或其他组织，具有独立订立合同的权利。</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;2.业绩要求：无</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;3.联合体投标：不允许</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;4.代理商投标：允许</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;5.信誉要求：不属于在国家公共信用信息中心“信用中国”网（www.creditchina.gov.cn）列入失信惩戒名单</span></p><p><br></p>', NULL, 2, 0);
INSERT INTO `bidding_tender_notice` VALUES (726, 4804, '公益活动最终招标', 200000, '2024-01-20 00:00:00', '2024-02-01 00:00:00', '2024-01-23 00:00:00', '2024-01-25 00:00:00', '2024-01-29 00:00:00', '2024-01-31 00:00:00', NULL, '<h1 class=\"ql-align-center\">招标公告<strong><span class=\"ql-cursor\">﻿</span></strong></h1><p class=\"ql-align-center\"><br></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">华润守正招标有限公司受招标人委托，对华润医药山东区域2024年度第1批招标华润青岛医药有限公司门诊药房及静配中心智能化管理项目进行公开招标。</span></p><p><strong style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">一、项目基本情况</strong></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;招标人：华润青岛医药有限公司</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;招标代理机构：华润守正招标有限公司</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;项目地点：所有产品的交货地点均由采购人指定（山东省境内）</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;项目规模：/</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;项目资金来源：自筹</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;招标编号：K99904024SZ0001P1</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;项目名称：华润青岛医药有限公司</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;标段名称：门诊药房及静配中心智能化管理项目</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;招标内容和范围：门诊药房智能发药系统、静配中心智能分拣贴签一体机</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;主要指标：</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;交货期/工期：自签订合同之日起1个月内供货、安装调试并验收完毕。</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;供应商可根据自身情况自报最快交货时间。</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;注：详细内容见招标文件，以招标文件为准。</span></p><p><strong style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">二、投标人资格能力要求</strong></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;1.资格要求：投标人为中华人民共和国境内合法注册的独立法人或其他组织，具有独立订立合同的权利。</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;2.业绩要求：无</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;3.联合体投标：不允许</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;4.代理商投标：允许</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;5.信誉要求：不属于在国家公共信用信息中心“信用中国”网（www.creditchina.gov.cn）列入失信惩戒名单</span></p><p><br></p>', NULL, 1, 0);
INSERT INTO `bidding_tender_notice` VALUES (727, 4805, '体检活动首次招标', 50000, '2024-01-20 05:18:01', '2024-02-16 06:04:02', '2024-01-22 04:01:02', '2024-01-31 07:01:02', '2024-02-02 05:03:01', '2024-02-08 10:01:03', '无', '<p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">华润守正招标有限公司受招标人委托，对华润医药山东区域2024年度第1批招标华润青岛医药有限公司门诊药房及静配中心智能化管理项目进行公开招标。</span></p><p><strong style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">一、项目基本情况</strong></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;招标人：华润青岛医药有限公司</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;招标代理机构：华润守正招标有限公司</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;项目地点：所有产品的交货地点均由采购人指定（山东省境内）</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;项目规模：/</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;项目资金来源：自筹</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;招标编号：K99904024SZ0001P1</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;项目名称：华润青岛医药有限公司</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;标段名称：门诊药房及静配中心智能化管理项目</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;招标内容和范围：门诊药房智能发药系统、静配中心智能分拣贴签一体机</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;主要指标：</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;交货期/工期：自签订合同之日起1个月内供货、安装调试并验收完毕。</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;供应商可根据自身情况自报最快交货时间。</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;注：详细内容见招标文件，以招标文件为准。</span></p><p><strong style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">二、投标人资格能力要求</strong></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;1.资格要求：投标人为中华人民共和国境内合法注册的独立法人或其他组织，具有独立订立合同的权利。</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;2.业绩要求：无</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;3.联合体投标：不允许</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;4.代理商投标：允许</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;5.信誉要求：不属于在国家公共信用信息中心“信用中国”网（www.creditchina.gov.cn）列入失信惩戒名单</span></p><p><br></p>', NULL, 1, 0);
INSERT INTO `bidding_tender_notice` VALUES (728, 4805, '体验医疗器械招标', 50000, '2024-02-01 00:00:00', '2024-02-29 00:00:00', '2024-02-06 11:00:00', '2024-02-15 14:00:00', '2024-02-18 10:00:00', '2024-02-21 05:00:00', NULL, '<p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">华润守正招标有限公司受招标人委托，对华润医药山东区域2024年度第1批招标华润青岛医药有限公司门诊药房及静配中心智能化管理项目进行公开招标。</span></p><p><strong style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">一、项目基本情况</strong></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;招标人：华润青岛医药有限公司</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;招标代理机构：华润守正招标有限公司</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;项目地点：所有产品的交货地点均由采购人指定（山东省境内）</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;项目规模：/</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;项目资金来源：自筹</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;招标编号：K99904024SZ0001P1</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;项目名称：华润青岛医药有限公司</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;标段名称：门诊药房及静配中心智能化管理项目</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;招标内容和范围：门诊药房智能发药系统、静配中心智能分拣贴签一体机</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;主要指标：</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;交货期/工期：自签订合同之日起1个月内供货、安装调试并验收完毕。</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;供应商可根据自身情况自报最快交货时间。</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;注：详细内容见招标文件，以招标文件为准。</span></p><p><strong style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">二、投标人资格能力要求</strong></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;1.资格要求：投标人为中华人民共和国境内合法注册的独立法人或其他组织，具有独立订立合同的权利。</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;2.业绩要求：无</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;3.联合体投标：不允许</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;4.代理商投标：允许</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;5.信誉要求：不属于在国家公共信用信息中心“信用中国”网（www.creditchina.gov.cn）列入失信惩戒名单</span></p><p><br></p>', NULL, 1, 0);
INSERT INTO `bidding_tender_notice` VALUES (729, 4805, '体检活动招标2.0', 50000, '2024-02-05 00:00:00', '2024-02-28 00:00:00', '2024-02-11 15:06:00', '2024-02-14 02:03:00', '2024-02-20 09:06:00', '2024-02-22 12:09:00', NULL, '<p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">华润守正招标有限公司受招标人委托，对华润医药山东区域2024年度第1批招标华润青岛医药有限公司门诊药房及静配中心智能化管理项目进行公开招标。</span></p><p><strong style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">一、项目基本情况</strong></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;招标人：华润青岛医药有限公司</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;招标代理机构：华润守正招标有限公司</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;项目地点：所有产品的交货地点均由采购人指定（山东省境内）</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;项目规模：/</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;项目资金来源：自筹</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;招标编号：K99904024SZ0001P1</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;项目名称：华润青岛医药有限公司</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;标段名称：门诊药房及静配中心智能化管理项目</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;招标内容和范围：门诊药房智能发药系统、静配中心智能分拣贴签一体机</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;主要指标：</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;交货期/工期：自签订合同之日起1个月内供货、安装调试并验收完毕。</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;供应商可根据自身情况自报最快交货时间。</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;注：详细内容见招标文件，以招标文件为准。</span></p><p><strong style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">二、投标人资格能力要求</strong></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;1.资格要求：投标人为中华人民共和国境内合法注册的独立法人或其他组织，具有独立订立合同的权利。</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;2.业绩要求：无</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;3.联合体投标：不允许</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;4.代理商投标：允许</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;5.信誉要求：不属于在国家公共信用信息中心“信用中国”网（www.creditchina.gov.cn）列入失信惩戒名单</span></p><p><br></p>', NULL, 1, 0);
INSERT INTO `bidding_tender_notice` VALUES (730, 4805, '24年体验活动最终招标', 50000, '2024-02-12 05:00:00', '2024-02-29 23:00:00', '2024-02-13 05:00:00', '2024-02-15 03:00:00', '2024-02-20 08:00:00', '2024-02-22 07:00:00', '24年体验活动最终招标', '<p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">华润守正招标有限公司受招标人委托，对华润医药山东区域2024年度第1批招标华润青岛医药有限公司门诊药房及静配中心智能化管理项目进行公开招标。</span></p><p><strong style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">一、项目基本情况</strong></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;招标人：华润青岛医药有限公司</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;招标代理机构：华润守正招标有限公司</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;项目地点：所有产品的交货地点均由采购人指定（山东省境内）</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;项目规模：/</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;项目资金来源：自筹</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;招标编号：K99904024SZ0001P1</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;项目名称：华润青岛医药有限公司</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;标段名称：门诊药房及静配中心智能化管理项目</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;招标内容和范围：门诊药房智能发药系统、静配中心智能分拣贴签一体机</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;主要指标：</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;交货期/工期：自签订合同之日起1个月内供货、安装调试并验收完毕。</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;供应商可根据自身情况自报最快交货时间。</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;注：详细内容见招标文件，以招标文件为准。</span></p><p><strong style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">二、投标人资格能力要求</strong></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;1.资格要求：投标人为中华人民共和国境内合法注册的独立法人或其他组织，具有独立订立合同的权利。</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;2.业绩要求：无</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;3.联合体投标：不允许</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;4.代理商投标：允许</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;5.信誉要求：不属于在国家公共信用信息中心“信用中国”网（www.creditchina.gov.cn）列入失信惩戒名单</span></p><p><br></p>', NULL, 2, 0);
INSERT INTO `bidding_tender_notice` VALUES (731, 4806, '甘肃地震支援药品招标', 5000000, '2024-01-03 00:00:00', '2024-02-21 00:00:00', '2024-01-13 00:00:00', '2024-01-17 00:00:00', '2024-02-06 03:00:00', '2024-02-09 22:00:00', '甘肃地震支援药品招标', '<p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">华润守正招标有限公司受招标人委托，对华润医药山东区域2024年度第1批招标华润青岛医药有限公司门诊药房及静配中心智能化管理项目进行公开招标。</span></p><p><strong style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">一、项目基本情况</strong></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;招标人：华润青岛医药有限公司</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;招标代理机构：华润守正招标有限公司</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;项目地点：所有产品的交货地点均由采购人指定（山东省境内）</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;项目规模：/</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;项目资金来源：自筹</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;招标编号：K99904024SZ0001P1</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;项目名称：华润青岛医药有限公司</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;标段名称：门诊药房及静配中心智能化管理项目</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;招标内容和范围：门诊药房智能发药系统、静配中心智能分拣贴签一体机</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;主要指标：</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;交货期/工期：自签订合同之日起1个月内供货、安装调试并验收完毕。</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;供应商可根据自身情况自报最快交货时间。</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;注：详细内容见招标文件，以招标文件为准。</span></p><p><strong style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">二、投标人资格能力要求</strong></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;1.资格要求：投标人为中华人民共和国境内合法注册的独立法人或其他组织，具有独立订立合同的权利。</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;2.业绩要求：无</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;3.联合体投标：不允许</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;4.代理商投标：允许</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;5.信誉要求：不属于在国家公共信用信息中心“信用中国”网（www.creditchina.gov.cn）列入失信惩戒名单</span></p><p><br></p>', NULL, 1, 0);
INSERT INTO `bidding_tender_notice` VALUES (732, 4806, '1000个担架招标', 5000000, '2024-01-03 02:00:00', '2024-01-17 19:00:00', '2024-01-05 04:00:00', '2024-01-09 10:00:00', '2024-01-11 14:00:00', '2024-01-15 08:02:00', NULL, '<p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">华润守正招标有限公司受招标人委托，对华润医药山东区域2024年度第1批招标华润青岛医药有限公司门诊药房及静配中心智能化管理项目进行公开招标。</span></p><p><strong style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">一、项目基本情况</strong></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;招标人：华润青岛医药有限公司</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;招标代理机构：华润守正招标有限公司</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;项目地点：所有产品的交货地点均由采购人指定（山东省境内）</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;项目规模：/</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;项目资金来源：自筹</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;招标编号：K99904024SZ0001P1</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;项目名称：华润青岛医药有限公司</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;标段名称：门诊药房及静配中心智能化管理项目</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;招标内容和范围：门诊药房智能发药系统、静配中心智能分拣贴签一体机</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;主要指标：</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;交货期/工期：自签订合同之日起1个月内供货、安装调试并验收完毕。</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;供应商可根据自身情况自报最快交货时间。</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;注：详细内容见招标文件，以招标文件为准。</span></p><p><strong style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">二、投标人资格能力要求</strong></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;1.资格要求：投标人为中华人民共和国境内合法注册的独立法人或其他组织，具有独立订立合同的权利。</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;2.业绩要求：无</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;3.联合体投标：不允许</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;4.代理商投标：允许</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;5.信誉要求：不属于在国家公共信用信息中心“信用中国”网（www.creditchina.gov.cn）列入失信惩戒名单</span></p><p><br></p>', NULL, 1, 0);
INSERT INTO `bidding_tender_notice` VALUES (733, 4806, '灾区一次性棉签招标！', 5000000, '2024-01-03 00:00:00', '2024-01-19 00:00:00', '2024-01-05 00:00:00', '2024-01-10 00:00:00', '2024-01-16 00:00:00', '2024-01-18 00:00:00', '急急急急急急急急急急急急急急急急', '<p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">华润守正招标有限公司受招标人委托，对华润医药山东区域2024年度第1批招标华润青岛医药有限公司门诊药房及静配中心智能化管理项目进行公开招标。</span></p><p><strong style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">一、项目基本情况</strong></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;招标人：华润青岛医药有限公司</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;招标代理机构：华润守正招标有限公司</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;项目地点：所有产品的交货地点均由采购人指定（山东省境内）</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;项目规模：/</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;项目资金来源：自筹</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;招标编号：K99904024SZ0001P1</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;项目名称：华润青岛医药有限公司</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;标段名称：门诊药房及静配中心智能化管理项目</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;招标内容和范围：门诊药房智能发药系统、静配中心智能分拣贴签一体机</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;主要指标：</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;交货期/工期：自签订合同之日起1个月内供货、安装调试并验收完毕。</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;供应商可根据自身情况自报最快交货时间。</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;注：详细内容见招标文件，以招标文件为准。</span></p><p><strong style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">二、投标人资格能力要求</strong></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;1.资格要求：投标人为中华人民共和国境内合法注册的独立法人或其他组织，具有独立订立合同的权利。</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;2.业绩要求：无</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;3.联合体投标：不允许</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;4.代理商投标：允许</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;&nbsp;5.信誉要求：不属于在国家公共信用信息中心“信用中国”网（www.creditchina.gov.cn）列入失信惩戒名单</span></p><p><br></p>', NULL, 1, 0);
INSERT INTO `bidding_tender_notice` VALUES (734, 4810, '111111', 5555, '2024-01-04 00:00:00', '2024-02-01 00:00:00', '2024-01-12 00:00:00', '2024-01-19 00:00:00', '2024-01-24 00:00:00', '2024-01-30 00:00:00', NULL, '<p>华润青岛医药有限公司</p><p>门诊药房及静配中心智能化管理项目</p><p>招标公告</p><p>招标公告KZBGG2024010002号</p><p>  华润守正招标有限公司受招标人委托，对华润医药山东区域2024年度第1批招标华润青岛医药有限公司门诊药房及静配中心智能化管理项目进行公开招标。</p><p>一、项目基本情况</p><p>  招标人：华润青岛医药有限公司</p><p>  招标代理机构：华润守正招标有限公司</p><p>  项目地点：所有产品的交货地点均由采购人指定（山东省境内）</p><p>  项目规模：/</p><p>  项目资金来源：自筹</p><p>  招标编号：K99904024SZ0001P1</p><p>  项目名称：华润青岛医药有限公司</p><p>  标段名称：门诊药房及静配中心智能化管理项目</p><p>  招标内容和范围：门诊药房智能发药系统、静配中心智能分拣贴签一体机</p><p>  主要指标：</p><p>  交货期/工期：自签订合同之日起1个月内供货、安装调试并验收完毕。</p><p>  供应商可根据自身情况自报最快交货时间。</p><p>  注：详细内容见招标文件，以招标文件为准。</p><p>二、投标人资格能力要求</p><p>  1.资格要求：投标人为中华人民共和国境内合法注册的独立法人或其他组织，具有独立订立合同的权利。</p><p>  2.业绩要求：无</p><p>  3.联合体投标：不允许</p><p>  4.代理商投标：允许</p><p>  5.信誉要求：不属于在国家公共信用信息中心“信用中国”网（www.creditchina.gov.cn）列入失信惩戒名单</p><p>  6.其他要求：无</p><p>  备注：</p><p>三、招标文件的获取</p><p>  （一）获取时间</p><p>    2024年01月02日- 2024年01月09日</p><p>  （二）招标文件获取方式</p><p>    在华润集团守正电子招标平台(https://szecp.crc.com.cn)在线下载，不接受来人现场领取。</p><p>  （三）投标人提问截止时间</p><p>    2024年01月10日 8:00</p><p>四、截标/开标时间、地点</p><p>  截标/开标时间：2024/01/15 09:00:00（北京时间，若有变化另行通知）</p><p>  截标/开标地点：网上开标大厅/网上开标大厅(若有变化另行通知)</p><p>五、招标人及其招标代理机构联系方式</p><p>  招标人：华润青岛医药有限公司</p><p>  地址：青岛市李沧区广水路616号</p><p>  联系人：赵莹</p><p>  电话：15906396220</p><p>  招标代理机构：华润守正招标有限公司</p><p>  地址：深圳市前海深港合作区南山街道梦海大道5035号前海华润金融中心T5写字楼3501</p><p>  联系人：赵锐</p><p>  电话：0755-29395797-3379</p>', NULL, 1, 0);

-- ----------------------------
-- Table structure for bidding_tender_projects
-- ----------------------------
DROP TABLE IF EXISTS `bidding_tender_projects`;
CREATE TABLE `bidding_tender_projects`  (
  `tender_projects_id` int(50) NOT NULL AUTO_INCREMENT COMMENT '项目ID',
  `tender_projects_number` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目编号',
  `tender_projects_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目名称',
  `projects_type` int(11) NULL DEFAULT NULL COMMENT '业务类型',
  `tender_projects_money` decimal(10, 0) NULL DEFAULT NULL COMMENT '项目预算',
  `tender_projects_contact` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `tender_projects_phone` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `tender_projects_address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `tender_projects_email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `manner` int(11) NULL DEFAULT NULL COMMENT '招标方式',
  `censor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审查表地址',
  `must` int(11) NULL DEFAULT NULL COMMENT '资格审查方式',
  `audit_state` int(11) NULL DEFAULT 0 COMMENT '审核状态',
  `creat_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `creat_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `is_delete` int(1) NULL DEFAULT 0 COMMENT '删除',
  `bid_annex_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目评标附件集合',
  PRIMARY KEY (`tender_projects_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4811 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bidding_tender_projects
-- ----------------------------
INSERT INTO `bidding_tender_projects` VALUES (4800, 'TQ0102343600001', '手术器械采购', 0, 800000, '水柯崴', '18081861591', '湖南省长沙市开福区', 'nylc9@163.com', '无', 1, NULL, 0, 1, NULL, NULL, 0, NULL);
INSERT INTO `bidding_tender_projects` VALUES (4801, 'TQ0102364200002', '麻醉药品采购', 2, 90000, '柳琼仁', '19952693233', '湖北省武汉市孝感市', '09vQZt@163.com', '无', 1, NULL, 1, 2, NULL, NULL, 0, NULL);
INSERT INTO `bidding_tender_projects` VALUES (4802, 'TQ0102430800001', '药品招标', 0, 966666, '张莎', '15178630962', '湖南省长沙市', '2356982@qq.com', '', 0, NULL, 1, 4, NULL, NULL, 0, NULL);
INSERT INTO `bidding_tender_projects` VALUES (4803, 'TQ0102445000002', '精神药品招标', 2, 90000, '盖娅', '15178637242', '河北省武汉市', 'sjacfhka@qq.com', '', 1, NULL, 1, 1, NULL, NULL, 0, NULL);
INSERT INTO `bidding_tender_projects` VALUES (4804, 'TQ0102573500001', '公益活动招标', 2, 200000, '刘思佳', '13754444221', '江苏省兴化市林湖工业区', '100015@163.com', '无', 1, NULL, 0, 4, NULL, NULL, 0, NULL);
INSERT INTO `bidding_tender_projects` VALUES (4805, 'TQ0102061500002', '体检活动招标', 2, 50000, '李哲杨', '13402013312', '广东省深圳市福田区深南大道6006华丰大厦', '100015@163.com', '无', 1, NULL, 1, 4, NULL, NULL, 0, NULL);
INSERT INTO `bidding_tender_projects` VALUES (4806, 'TQ0102085000003', '甘肃地震支援招标', 3, 5000000, '张涛', '13897890657', '北京市朝阳区北辰中心12号', 'mind@qq.com', '急急急', 0, NULL, 0, 4, NULL, NULL, 0, NULL);
INSERT INTO `bidding_tender_projects` VALUES (4807, 'TQ0102085100003', '中药招标', 0, 8000, '刘贵流', '15178637247', '湖南省长沙市', 'sjac463@qq.com', '无', 1, NULL, 0, 1, NULL, NULL, 0, NULL);
INSERT INTO `bidding_tender_projects` VALUES (4808, 'TQ0102111100004', '光学仪器招标', 1, 7000000, '安阿尔', '15178637296', '湖北省武汉市', '37dhka@qq.com', '372', 1, NULL, 1, 0, NULL, NULL, 0, NULL);
INSERT INTO `bidding_tender_projects` VALUES (4809, 'TQ0102113700004', '药剂招标', 0, 100000, '王思', '13754444221', '江苏省兴化市林湖工业区', '100015@163.com', '很需要', 1, NULL, 0, 0, NULL, NULL, 0, NULL);
INSERT INTO `bidding_tender_projects` VALUES (4810, 'TQ0103212800001', 'd111', 0, 5555, 'zs', '15115020663', '955', '555555@qq.com', '66', 1, NULL, 0, 4, NULL, NULL, 0, NULL);

-- ----------------------------
-- Table structure for gen_table
-- ----------------------------
DROP TABLE IF EXISTS `gen_table`;
CREATE TABLE `gen_table`  (
  `table_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '表名称',
  `table_comment` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '表描述',
  `sub_table_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联子表的表名',
  `sub_table_fk_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '子表关联的外键名',
  `class_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '实体类名称',
  `tpl_category` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'crud' COMMENT '使用的模板（crud单表操作 tree树表操作）',
  `package_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生成包路径',
  `module_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生成模块名',
  `business_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生成业务名',
  `function_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生成功能名',
  `function_author` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生成功能作者',
  `gen_type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '生成代码方式（0zip压缩包 1自定义路径）',
  `gen_path` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '/' COMMENT '生成路径（不填默认项目路径）',
  `options` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '其它生成选项',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`table_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 130 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '代码生成业务表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of gen_table
-- ----------------------------
INSERT INTO `gen_table` VALUES (93, 'bidding_draw_experts', '抽取专家表', NULL, NULL, 'BiddingDrawExperts', 'crud', 'com.yz.bidding', 'pms/bidding', 'draw_experts', '抽取专家', 'zhangye', '0', '/', '{\"parentMenuId\":\"1090\"}', 'admin', '2023-11-17 11:07:05', '', '2023-12-20 11:34:49', NULL);
INSERT INTO `gen_table` VALUES (94, 'bidding_notice', '中标公告表', NULL, NULL, 'BiddingNotice', 'crud', 'com.yz.bidding', 'pms/bidding', 'notice', '中标公告', 'zhangye', '0', '/', '{\"parentMenuId\":\"1091\"}', 'admin', '2023-11-17 11:07:07', '', '2023-11-21 01:35:52', NULL);
INSERT INTO `gen_table` VALUES (95, 'bidding_notice_text', '招标公告正文表', NULL, NULL, 'BiddingNoticeText', 'crud', 'com.yz.bidding', 'pms/bidding', 'notice_text', '招标公告正文', 'zhangye', '0', '/', '{\"parentMenuId\":\"1087\"}', 'admin', '2023-11-17 11:07:08', '', '2023-11-21 01:36:01', NULL);
INSERT INTO `gen_table` VALUES (96, 'public_qualification', '供应商资质表', NULL, NULL, 'PublicQualification', 'crud', 'com.yz.bidding', 'pms.public', 'qualification', '供应商资质', 'zhangye', '0', '/', '{\"parentMenuId\":\"1084\"}', 'admin', '2023-11-17 11:07:09', '', '2023-11-21 00:34:19', NULL);
INSERT INTO `gen_table` VALUES (97, 'bidding_tender', '投标表', NULL, NULL, 'BiddingTender', 'crud', 'com.yz.bidding', 'pms/bidding', 'tender', '投标', 'zhangye', '0', '/', '{\"parentMenuId\":\"1089\"}', 'admin', '2023-11-17 11:07:10', '', '2023-11-21 01:36:09', NULL);
INSERT INTO `gen_table` VALUES (98, 'bidding_tender_manifest', '招标项目详情表', NULL, NULL, 'BiddingTenderManifest', 'crud', 'com.yz.bidding', 'pms/bidding', 'tender_manifest', '招标项目详情', 'zhangye', '0', '/', '{\"parentMenuId\":\"1085\"}', 'admin', '2023-11-17 11:07:12', '', '2023-11-21 01:36:20', NULL);
INSERT INTO `gen_table` VALUES (99, 'bidding_tender_notice', '招标公告表', NULL, NULL, 'BiddingTenderNotice', 'crud', 'com.yz.bidding', 'pms/bidding', 'tender_notice', '招标公告', 'zhangye', '0', '/', '{\"parentMenuId\":\"1087\"}', 'admin', '2023-11-17 11:07:13', '', '2023-12-21 19:36:40', NULL);
INSERT INTO `gen_table` VALUES (100, 'bidding_tender_projects', '招标项目表', NULL, NULL, 'BiddingTenderProjects', 'crud', 'com.yz.bidding', 'pms/bidding', 'tender_projects', '招标项目', 'zhangye', '0', '/', '{\"parentMenuId\":\"1085\"}', 'admin', '2023-11-17 11:07:15', '', '2023-12-06 11:42:06', NULL);
INSERT INTO `gen_table` VALUES (102, 'public_annex', '公共附件表', NULL, NULL, 'PublicAnnex', 'crud', 'com.yz.bidding', 'pms.public', 'annex', '公告附件', 'zhangye', '0', '/', '{\"parentMenuId\":\"1085\"}', 'admin', '2023-11-17 11:07:20', '', '2023-12-25 12:47:52', NULL);
INSERT INTO `gen_table` VALUES (103, 'public_category', '物料类别表', NULL, NULL, 'PublicCategory', 'crud', 'com.yz.shopping', 'pms.public', 'category', '物料类别', 'zhangye', '0', '/', '{\"parentMenuId\":\"1076\"}', 'admin', '2023-11-17 11:07:21', '', '2023-11-22 17:36:40', NULL);
INSERT INTO `gen_table` VALUES (104, 'public_contacts', '供应商联系人表', NULL, NULL, 'PublicContacts', 'crud', 'com.yz.bidding', 'pms.public', 'contacts', '供应商联系人', 'zhangye', '0', '/', '{\"parentMenuId\":\"1081\"}', 'admin', '2023-11-17 11:07:23', '', '2023-11-21 00:35:11', NULL);
INSERT INTO `gen_table` VALUES (105, 'public_agreement', '合同申请表', 'public_contractdetails', 'contract_id', 'PublicAgreement', 'sub', 'com.yz.bidding', 'pms.public', 'agreement', '合同申请表', 'zhangye', '0', '/', '{\"parentMenuId\":\"1080\"}', 'admin', '2023-11-17 11:07:23', '', '2023-11-29 11:50:25', NULL);
INSERT INTO `gen_table` VALUES (106, 'public_contractdetails', '合同明细表', '', '', 'PublicContractdetails', 'crud', 'com.yz.bidding', 'pms.public', 'contractdetails', '合同明细', 'zhangye', '0', '/', '{\"parentMenuId\":\"1078\"}', 'admin', '2023-11-17 11:07:25', '', '2023-11-29 15:46:22', NULL);
INSERT INTO `gen_table` VALUES (107, 'public_expert', '专家表', NULL, NULL, 'PublicExpert', 'crud', 'com.yz.bidding', 'pms.public', 'expert', '专家', 'zhangye', '0', '/', '{\"parentMenuId\":\"1090\"}', 'admin', '2023-11-17 11:07:26', '', '2023-11-21 00:36:04', NULL);
INSERT INTO `gen_table` VALUES (108, 'public_expert_pool', '专家库', NULL, NULL, 'PublicExpertPool', 'crud', 'com.yz.bidding', 'pms.public', 'expert_pool', '专家库', 'zhangye', '0', '/', '{\"parentMenuId\":\"1090\"}', 'admin', '2023-11-17 11:07:28', '', '2023-12-20 11:55:35', NULL);
INSERT INTO `gen_table` VALUES (109, 'public_goods', '物料表', 'public_category', 'category_id', 'PublicGoods', 'sub', 'com.yz.shopping', 'public/goods', 'goods', '物料', 'zhangye', '0', '/', '{\"parentMenuId\":\"1063\"}', 'admin', '2023-11-17 11:07:30', '', '2023-11-23 16:41:01', NULL);
INSERT INTO `gen_table` VALUES (110, 'public_payment', '合同付款表', NULL, NULL, 'PublicPayment', 'crud', 'com.yz.shopping', 'pms.public', 'payment', '合同付款', 'zhangye', '0', '/', '{\"parentMenuId\":\"1078\"}', 'admin', '2023-11-17 11:07:32', '', '2023-11-21 00:37:08', NULL);
INSERT INTO `gen_table` VALUES (111, 'public_receipt', '收货单表', NULL, NULL, 'PublicReceipt', 'crud', 'com.yz.shopping', 'pms.public', 'receipt', '收货单', 'zhangye', '0', '/', '{\"parentMenuId\":\"1074\"}', 'admin', '2023-11-17 11:07:33', '', '2023-12-13 09:46:43', NULL);
INSERT INTO `gen_table` VALUES (112, 'public_supplied_materials', '供应商供货物料表', NULL, NULL, 'PublicSuppliedMaterials', 'crud', 'com.yz.bidding', 'pms.public', 'supplied_materials', '供应商供货物料表', 'zhangye', '0', '/', '{\"parentMenuId\":\"1083\"}', 'admin', '2023-11-17 11:07:35', '', '2023-11-21 00:37:44', NULL);
INSERT INTO `gen_table` VALUES (113, 'public_supply', '供应商供货表', NULL, NULL, 'PublicSupply', 'crud', 'com.yz.bidding', 'pms.public', 'supply', '供应商供货表', 'zhangye', '0', '/', '{\"parentMenuId\":\"1083\"}', 'admin', '2023-11-17 11:07:36', '', '2023-12-04 19:14:17', NULL);
INSERT INTO `gen_table` VALUES (114, 'public_user', '用户表', NULL, NULL, 'PublicUser', 'crud', 'com.yz.shopping', 'pms.public', 'user', '用户表', 'zhangye', '0', '/', '{\"parentMenuId\":\"1063\"}', 'admin', '2023-11-17 11:07:38', '', '2023-11-21 00:39:26', NULL);
INSERT INTO `gen_table` VALUES (115, 'public_warehouse', '仓库表', NULL, NULL, 'PublicWarehouse', 'crud', 'com.yz.shopping', 'pms/shopping', 'warehouse', '仓库', 'zhangye', '0', '/', '{\"parentMenuId\":\"1063\"}', 'admin', '2023-11-17 11:07:39', '', '2023-11-21 14:27:11', NULL);
INSERT INTO `gen_table` VALUES (116, 'shopping_buy_plan', '采购计划表', '', '', 'ShoppingBuyPlan', 'crud', 'com.yz.shopping', 'shopping/buy_plan', 'buy_plan', '采购计划表', 'zhangye', '0', '/', '{\"parentMenuId\":1211}', 'admin', '2023-11-17 11:07:40', '', '2023-11-27 19:48:09', NULL);
INSERT INTO `gen_table` VALUES (117, 'shopping_demand', '采购需求物料表', NULL, NULL, 'ShoppingDemand', 'crud', 'com.yz.shopping', 'pms/shopping', 'demand', '采购需求物料表', 'zhangye', '0', '/', '{\"parentMenuId\":\"1068\"}', 'admin', '2023-11-17 11:07:41', '', '2023-11-20 23:15:29', NULL);
INSERT INTO `gen_table` VALUES (118, 'bidding_download_logs', '标书下载记录表', NULL, NULL, 'BiddingDownloadLogs', 'crud', 'com.yz.bidding', 'pms/bidding', 'download_logs', '标书下载记录表', 'zhangye', '0', '/', '{\"parentMenuId\":\"1087\"}', 'admin', '2023-11-17 11:07:42', '', '2023-11-21 01:36:53', NULL);
INSERT INTO `gen_table` VALUES (119, 'shopping_orders', '采购订单表', '', '', 'ShoppingOrders', 'crud', 'com.yz.shopping', 'shopping/orders', 'orders', '采购订单表', 'zhangye', '0', '/', '{\"parentMenuId\":\"1239\"}', 'admin', '2023-11-17 11:07:44', '', '2023-12-20 10:45:59', NULL);
INSERT INTO `gen_table` VALUES (120, 'shopping_pro_require', '采购需求表', NULL, NULL, 'ShoppingProRequire', 'crud', 'com.yz.shopping', 'shopping/pro_require', 'pro_require', '采购需求表', 'zhangye', '0', '/', '{\"parentMenuId\":\"1067\"}', 'admin', '2023-11-17 11:07:46', '', '2023-11-22 14:25:37', NULL);
INSERT INTO `gen_table` VALUES (121, 'public_vendor', '供应商表', '', '', 'PublicVendor', 'crud', 'com.yz.bidding', 'bidding/public', 'vendor', '供应商', 'zhangye', '0', '/', '{\"parentMenuId\":\"1065\"}', 'admin', '2023-11-20 15:15:02', '', '2023-11-22 14:29:16', NULL);
INSERT INTO `gen_table` VALUES (122, 'public_code_rules', '编码规则表', NULL, NULL, 'PublicCodeRules', 'crud', 'com.yz.bidding', 'bidding/rules', 'rules', '编码规则', 'zhangye', '0', '/', '{\"parentMenuId\":\"1063\"}', 'admin', '2023-11-22 23:23:20', '', '2023-11-22 23:54:05', NULL);
INSERT INTO `gen_table` VALUES (123, 'public_signing', '', NULL, NULL, 'PublicSigning', 'crud', 'com.yz.pms.bidding', 'bidding', 'signing', NULL, 'zhangye', '0', '/', NULL, 'admin', '2023-12-04 11:55:14', '', NULL, NULL);
INSERT INTO `gen_table` VALUES (125, 'public_signings', '签署执行状态表', NULL, NULL, 'PublicSignings', 'crud', 'com.yz.bidding', 'pms.public', 'signings', '签署执行状态表', 'zhangye', '0', '/', '{}', 'admin', '2023-12-04 15:55:19', '', '2023-12-04 15:57:24', NULL);
INSERT INTO `gen_table` VALUES (126, 'bidding_quotation', '投标单表', NULL, NULL, 'BiddingQuotation', 'crud', 'com.yz.pms.bidding', 'bidding', 'quotation', '1', 'zhangye', '0', '/', '{}', 'admin', '2023-12-20 17:06:57', '', '2023-12-20 17:08:26', '1');
INSERT INTO `gen_table` VALUES (128, 'bidding_extraction_conditions', '抽取条件表', '', '', 'BiddingExtractionConditions', 'crud', 'com.yz.bidding', 'bidding', 'conditions', '抽取条件表', 'zhangye', '0', '/', '{}', 'admin', '2023-12-21 17:02:37', '', '2023-12-21 17:08:13', NULL);
INSERT INTO `gen_table` VALUES (129, 'bidding_get_expert_extract', '专家被抽取表', NULL, NULL, 'BiddingGetExpertExtract', 'crud', 'com.yz.bidding', 'bidding', 'extract', '专家被抽取表', 'zhangye', '0', '/', '{}', 'admin', '2023-12-21 17:02:38', '', '2023-12-21 17:08:24', NULL);

-- ----------------------------
-- Table structure for gen_table_column
-- ----------------------------
DROP TABLE IF EXISTS `gen_table_column`;
CREATE TABLE `gen_table_column`  (
  `column_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_id` bigint(20) NULL DEFAULT NULL COMMENT '归属表编号',
  `column_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '列名称',
  `column_comment` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '列描述',
  `column_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '列类型',
  `java_type` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'JAVA类型',
  `java_field` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'JAVA字段名',
  `is_pk` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否主键（1是）',
  `is_increment` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否自增（1是）',
  `is_required` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否必填（1是）',
  `is_insert` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否为插入字段（1是）',
  `is_edit` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否编辑字段（1是）',
  `is_list` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否列表字段（1是）',
  `is_query` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否查询字段（1是）',
  `query_type` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'EQ' COMMENT '查询方式（等于、不等于、大于、小于、范围）',
  `html_type` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）',
  `dict_type` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典类型',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`column_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1519 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '代码生成业务表字段' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of gen_table_column
-- ----------------------------
INSERT INTO `gen_table_column` VALUES (1060, 93, 'draw_experts_id', '主键', 'int(11)', 'Long', 'drawExpertsId', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2023-11-17 11:07:06', '', '2023-12-20 11:34:49');
INSERT INTO `gen_table_column` VALUES (1061, 93, 'draw_expert_id', '专家主键', 'int(11)', 'Long', 'drawExpertId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2023-11-17 11:07:06', '', '2023-12-20 11:34:50');
INSERT INTO `gen_table_column` VALUES (1062, 93, 'draw_projects_id', '项目主键', 'int(11)', 'Long', 'drawProjectsId', '0', '0', NULL, '1', '0', '1', '1', 'EQ', 'input', '', 4, 'admin', '2023-11-17 11:07:06', '', '2023-12-20 11:34:50');
INSERT INTO `gen_table_column` VALUES (1063, 93, 'number', '申请编号', 'varchar(50)', 'String', 'number', '0', '0', NULL, '1', '0', '1', '1', 'EQ', 'input', '', 2, 'admin', '2023-11-17 11:07:06', '', '2023-12-20 11:34:49');
INSERT INTO `gen_table_column` VALUES (1064, 93, 'manner', '抽取方式', 'int(11)', 'Long', 'manner', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 6, 'admin', '2023-11-17 11:07:06', '', '2023-12-20 11:34:50');
INSERT INTO `gen_table_column` VALUES (1065, 93, 'experts_number', '专家人数', 'int(11)', 'Long', 'expertsNumber', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 9, 'admin', '2023-11-17 11:07:06', '', '2023-12-20 11:34:51');
INSERT INTO `gen_table_column` VALUES (1066, 93, 'buy_number', '采购人数', 'int(11)', 'Long', 'buyNumber', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 10, 'admin', '2023-11-17 11:07:06', '', '2023-12-20 11:34:51');
INSERT INTO `gen_table_column` VALUES (1067, 93, 'address', '评标地点', 'varchar(200)', 'String', 'address', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 11, 'admin', '2023-11-17 11:07:06', '', '2023-12-20 11:34:51');
INSERT INTO `gen_table_column` VALUES (1068, 93, 'state', '状态', 'int(11)', 'Long', 'state', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 12, 'admin', '2023-11-17 11:07:07', '', '2023-12-20 11:34:51');
INSERT INTO `gen_table_column` VALUES (1069, 93, 'create_by', '创建人', 'varchar(100)', 'String', 'createBy', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 13, 'admin', '2023-11-17 11:07:07', '', '2023-12-20 11:34:51');
INSERT INTO `gen_table_column` VALUES (1070, 93, 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'datetime', '', 14, 'admin', '2023-11-17 11:07:07', '', '2023-12-20 11:34:51');
INSERT INTO `gen_table_column` VALUES (1071, 93, 'update_by', '修改人', 'varchar(100)', 'String', 'updateBy', '0', '0', NULL, '0', '1', NULL, NULL, 'EQ', 'input', '', 15, 'admin', '2023-11-17 11:07:07', '', '2023-12-20 11:34:51');
INSERT INTO `gen_table_column` VALUES (1072, 93, 'update_time', '修改时间', 'datetime', 'Date', 'updateTime', '0', '0', NULL, '0', '1', NULL, NULL, 'EQ', 'datetime', '', 16, 'admin', '2023-11-17 11:07:07', '', '2023-12-20 11:34:52');
INSERT INTO `gen_table_column` VALUES (1073, 93, 'is_delete', '删除', 'int(11)', 'Long', 'isDelete', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 17, 'admin', '2023-11-17 11:07:07', '', '2023-12-20 11:34:52');
INSERT INTO `gen_table_column` VALUES (1074, 94, 'notice_id', '公告id', 'int(11)', 'Long', 'noticeId', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2023-11-17 11:07:07', '', '2023-11-21 01:35:53');
INSERT INTO `gen_table_column` VALUES (1075, 94, 'tender_notice_id', '招标公告ID', 'int(11)', 'Long', 'tenderNoticeId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 2, 'admin', '2023-11-17 11:07:08', '', '2023-11-21 01:35:53');
INSERT INTO `gen_table_column` VALUES (1076, 94, 'notice_date', '公告日期', 'date', 'Date', 'noticeDate', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 3, 'admin', '2023-11-17 11:07:08', '', '2023-11-21 01:35:53');
INSERT INTO `gen_table_column` VALUES (1077, 94, 'buyer', ' 默认,远志集团有限公司', 'varchar(20)', 'String', 'buyer', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2023-11-17 11:07:08', '', '2023-11-21 01:35:53');
INSERT INTO `gen_table_column` VALUES (1078, 94, 'notice_title', '公告标题', 'varchar(200)', 'String', 'noticeTitle', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 5, 'admin', '2023-11-17 11:07:08', '', '2023-11-21 01:35:53');
INSERT INTO `gen_table_column` VALUES (1079, 94, 'notice_context', '公告内容', 'varchar(100)', 'String', 'noticeContext', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 6, 'admin', '2023-11-17 11:07:08', '', '2023-11-21 01:35:53');
INSERT INTO `gen_table_column` VALUES (1080, 94, 'bid_money', '中标金额', 'decimal(10,0)', 'Long', 'bidMoney', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 7, 'admin', '2023-11-17 11:07:08', '', '2023-11-21 01:35:53');
INSERT INTO `gen_table_column` VALUES (1081, 94, 'notice_supplier_id', '外键', 'int(11)', 'Long', 'noticeSupplierId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 8, 'admin', '2023-11-17 11:07:08', '', '2023-11-21 01:35:53');
INSERT INTO `gen_table_column` VALUES (1082, 95, 'notice_text_id', '公告正文主键', 'int(11)', 'Long', 'noticeTextId', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2023-11-17 11:07:09', '', '2023-11-21 01:36:01');
INSERT INTO `gen_table_column` VALUES (1083, 95, 'tender_notice_id', '招标公告ID', 'int(11)', 'Long', 'tenderNoticeId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 2, 'admin', '2023-11-17 11:07:09', '', '2023-11-21 01:36:01');
INSERT INTO `gen_table_column` VALUES (1084, 95, 'notice_address', '附件地址', 'varchar(255)', 'String', 'noticeAddress', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2023-11-17 11:07:09', '', '2023-11-21 01:36:02');
INSERT INTO `gen_table_column` VALUES (1085, 95, 'upload_time', '上传当前时间', 'datetime', 'Date', 'uploadTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 4, 'admin', '2023-11-17 11:07:09', '', '2023-11-21 01:36:02');
INSERT INTO `gen_table_column` VALUES (1086, 95, 'upload_by', '上传人', 'int(11)', 'Long', 'uploadBy', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 5, 'admin', '2023-11-17 11:07:09', '', '2023-11-21 01:36:02');
INSERT INTO `gen_table_column` VALUES (1087, 96, 'qualification_id', '资质表ID', 'int(11)', 'Long', 'qualificationId', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2023-11-17 11:07:09', '', '2023-11-21 00:34:19');
INSERT INTO `gen_table_column` VALUES (1088, 96, 'qualification_vendor_id', '供应商ID（外键）', 'int(11)', 'Long', 'qualificationVendorId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 2, 'admin', '2023-11-17 11:07:09', '', '2023-11-21 00:34:20');
INSERT INTO `gen_table_column` VALUES (1089, 96, 'qualification_name', '资质名称', 'varchar(64)', 'String', 'qualificationName', '0', '0', NULL, '1', '1', '1', '1', 'LIKE', 'input', '', 3, 'admin', '2023-11-17 11:07:10', '', '2023-11-21 00:34:20');
INSERT INTO `gen_table_column` VALUES (1090, 96, 'start_time', '有效期起', 'datetime', 'Date', 'startTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 4, 'admin', '2023-11-17 11:07:10', '', '2023-11-21 00:34:20');
INSERT INTO `gen_table_column` VALUES (1091, 96, 'stop_time', '有效期终', 'datetime', 'Date', 'stopTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 5, 'admin', '2023-11-17 11:07:10', '', '2023-11-21 00:34:20');
INSERT INTO `gen_table_column` VALUES (1092, 96, 'documents', '资质证件', 'varchar(255)', 'String', 'documents', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 6, 'admin', '2023-11-17 11:07:10', '', '2023-11-21 00:34:20');
INSERT INTO `gen_table_column` VALUES (1093, 96, 'remark', '备注', 'varchar(200)', 'String', 'remark', '0', '0', NULL, '1', '1', '1', NULL, 'EQ', 'input', '', 7, 'admin', '2023-11-17 11:07:10', '', '2023-11-21 00:34:20');
INSERT INTO `gen_table_column` VALUES (1094, 96, 'is_delete', '删除', 'int(11)', 'Long', 'isDelete', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 8, 'admin', '2023-11-17 11:07:10', '', '2023-11-21 00:34:20');
INSERT INTO `gen_table_column` VALUES (1095, 97, 'tender_id', '主键', 'int(11)', 'Long', 'tenderId', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2023-11-17 11:07:10', '', '2023-12-27 15:03:58');
INSERT INTO `gen_table_column` VALUES (1096, 97, 'tender_notice_id', '招标公告ID', 'int(11)', 'Long', 'tenderNoticeId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 2, 'admin', '2023-11-17 11:07:10', '', '2023-12-27 15:03:59');
INSERT INTO `gen_table_column` VALUES (1097, 97, 'tender_supplier_id', '供应商（外键）', 'int(11)', 'Long', 'tenderSupplierId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2023-11-17 11:07:11', '', '2023-12-27 15:03:59');
INSERT INTO `gen_table_column` VALUES (1098, 97, 'tender_supplier_name', '供应商名称', 'varchar(10)', 'String', 'tenderSupplierName', '0', '0', NULL, '1', '1', '1', '1', 'LIKE', 'input', '', 4, 'admin', '2023-11-17 11:07:11', '', '2023-12-27 15:03:59');
INSERT INTO `gen_table_column` VALUES (1099, 97, 'tender_name', '投标人名称', 'varchar(64)', 'String', 'tenderName', '0', '0', NULL, '1', '1', '1', '1', 'LIKE', 'input', '', 5, 'admin', '2023-11-17 11:07:11', '', '2023-12-27 15:03:59');
INSERT INTO `gen_table_column` VALUES (1100, 97, 'contact', '联系人', 'varchar(50)', 'String', 'contact', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 6, 'admin', '2023-11-17 11:07:11', '', '2023-12-27 15:03:59');
INSERT INTO `gen_table_column` VALUES (1101, 97, 'phone', '移动电话', 'char(11)', 'String', 'phone', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 7, 'admin', '2023-11-17 11:07:11', '', '2023-12-27 15:03:59');
INSERT INTO `gen_table_column` VALUES (1102, 97, 'tender_time', '投标时间', 'datetime', 'Date', 'tenderTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 8, 'admin', '2023-11-17 11:07:11', '', '2023-12-27 15:03:59');
INSERT INTO `gen_table_column` VALUES (1103, 97, 'ip_address', 'IP地址', 'varchar(200)', 'String', 'ipAddress', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 9, 'admin', '2023-11-17 11:07:11', '', '2023-12-27 15:04:00');
INSERT INTO `gen_table_column` VALUES (1104, 97, 'prices', '总价', 'decimal(10,0)', 'Long', 'prices', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 10, 'admin', '2023-11-17 11:07:11', '', '2023-12-27 15:04:00');
INSERT INTO `gen_table_column` VALUES (1105, 97, 'score', '评分', 'varchar(200)', 'String', 'score', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 11, 'admin', '2023-11-17 11:07:12', '', '2023-12-27 15:04:00');
INSERT INTO `gen_table_column` VALUES (1106, 97, 'recommend', '是否推荐', 'int(11)', 'Long', 'recommend', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 12, 'admin', '2023-11-17 11:07:12', '', '2023-12-27 15:04:00');
INSERT INTO `gen_table_column` VALUES (1107, 97, 'ranking', '排名', 'int(11)', 'Long', 'ranking', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 13, 'admin', '2023-11-17 11:07:12', '', '2023-12-27 15:04:00');
INSERT INTO `gen_table_column` VALUES (1108, 97, 'state', '状态', 'int(11)', 'Long', 'state', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 14, 'admin', '2023-11-17 11:07:12', '', '2023-12-27 15:04:00');
INSERT INTO `gen_table_column` VALUES (1109, 98, 'tender_manifest_id', '主键（招标详情表）', 'int(11)', 'Long', 'tenderManifestId', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2023-11-17 11:07:12', '', '2023-11-21 01:36:20');
INSERT INTO `gen_table_column` VALUES (1110, 98, 'manifest_projects_id', '招标项目（外键）', 'int(11)', 'Long', 'manifestProjectsId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 2, 'admin', '2023-11-17 11:07:12', '', '2023-11-21 01:36:20');
INSERT INTO `gen_table_column` VALUES (1111, 98, 'manifest_goods_id', '物料（外键键）', 'int(11)', 'Long', 'manifestGoodsId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2023-11-17 11:07:12', '', '2023-11-21 01:36:20');
INSERT INTO `gen_table_column` VALUES (1112, 98, 'number', '申请编号', 'varchar(50)', 'String', 'number', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2023-11-17 11:07:12', '', '2023-11-21 01:36:20');
INSERT INTO `gen_table_column` VALUES (1113, 98, 'manifest_type_id', '招标类型（数据字典外键）', 'int(11)', 'Long', 'manifestTypeId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 5, 'admin', '2023-11-17 11:07:13', '', '2023-11-21 01:36:21');
INSERT INTO `gen_table_column` VALUES (1114, 98, 'price', '单价', 'decimal(10,0)', 'Long', 'price', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 6, 'admin', '2023-11-17 11:07:13', '', '2023-11-21 01:36:21');
INSERT INTO `gen_table_column` VALUES (1115, 98, 'prices', '总价', 'decimal(10,0)', 'Long', 'prices', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 7, 'admin', '2023-11-17 11:07:13', '', '2023-11-21 01:36:21');
INSERT INTO `gen_table_column` VALUES (1116, 98, 'explain', '需求', 'varchar(200)', 'String', 'explain', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 8, 'admin', '2023-11-17 11:07:13', '', '2023-11-21 01:36:21');
INSERT INTO `gen_table_column` VALUES (1117, 98, 'remark', '备注', 'varchar(200)', 'String', 'remark', '0', '0', NULL, '1', '1', '1', NULL, 'EQ', 'input', '', 9, 'admin', '2023-11-17 11:07:13', '', '2023-11-21 01:36:21');
INSERT INTO `gen_table_column` VALUES (1118, 98, 'is_delete', '删除', 'int(11)', 'Long', 'isDelete', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 10, 'admin', '2023-11-17 11:07:13', '', '2023-11-21 01:36:21');
INSERT INTO `gen_table_column` VALUES (1119, 99, 'tender_notice_id', '招标公告ID', 'int(11)', 'Long', 'tenderNoticeId', '1', '1', NULL, '0', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2023-11-17 11:07:13', '', '2023-12-21 19:36:41');
INSERT INTO `gen_table_column` VALUES (1120, 99, 'tender_notice_projects_id', '关联项目（外键）', 'int(11)', 'Long', 'tenderNoticeProjectsId', '0', '0', NULL, '0', '0', '1', '0', 'EQ', 'input', '', 2, 'admin', '2023-11-17 11:07:13', '', '2023-12-21 19:36:41');
INSERT INTO `gen_table_column` VALUES (1121, 99, 'tender_title', '公告标题', 'varchar(50)', 'String', 'tenderTitle', '0', '0', NULL, '0', '0', '1', '1', 'LIKE', 'input', '', 3, 'admin', '2023-11-17 11:07:14', '', '2023-12-21 19:36:41');
INSERT INTO `gen_table_column` VALUES (1122, 99, 'tender_notice_monery', '项目资金', 'decimal(10,0)', 'Long', 'tenderNoticeMonery', '0', '0', NULL, '0', '0', '1', '0', 'EQ', 'input', '', 4, 'admin', '2023-11-17 11:07:14', '', '2023-12-21 19:36:41');
INSERT INTO `gen_table_column` VALUES (1123, 99, 'bid_start', '投标开始时间', 'datetime', 'Date', 'bidStart', '0', '0', NULL, '0', '0', '1', '0', 'EQ', 'datetime', '', 5, 'admin', '2023-11-17 11:07:14', '', '2023-12-21 19:36:41');
INSERT INTO `gen_table_column` VALUES (1124, 99, 'bid_end', '投标结束时间', 'datetime', 'Date', 'bidEnd', '0', '0', NULL, '0', '0', '1', '0', 'EQ', 'datetime', '', 6, 'admin', '2023-11-17 11:07:14', '', '2023-12-21 19:36:42');
INSERT INTO `gen_table_column` VALUES (1125, 99, 'kaibiao_start', '开标开始时间', 'datetime', 'Date', 'kaibiaoStart', '0', '0', NULL, '0', '0', '1', '0', 'EQ', 'datetime', '', 7, 'admin', '2023-11-17 11:07:14', '', '2023-12-21 19:36:42');
INSERT INTO `gen_table_column` VALUES (1126, 99, 'kaibiao_end', '开标结束时间', 'datetime', 'Date', 'kaibiaoEnd', '0', '0', NULL, '0', '0', '1', '0', 'EQ', 'datetime', '', 8, 'admin', '2023-11-17 11:07:14', '', '2023-12-21 19:36:42');
INSERT INTO `gen_table_column` VALUES (1127, 99, 'process_start', '流程开始时间', 'datetime', 'Date', 'processStart', '0', '0', NULL, '0', '0', '1', '0', 'EQ', 'datetime', '', 9, 'admin', '2023-11-17 11:07:14', '', '2023-12-21 19:36:42');
INSERT INTO `gen_table_column` VALUES (1128, 99, 'process_end', '流程结束时间', 'datetime', 'Date', 'processEnd', '0', '0', NULL, '0', '0', '1', '0', 'EQ', 'datetime', '', 10, 'admin', '2023-11-17 11:07:14', '', '2023-12-21 19:36:42');
INSERT INTO `gen_table_column` VALUES (1129, 99, 'remark', '备注', 'varchar(200)', 'String', 'remark', '0', '0', NULL, '0', '0', '1', NULL, 'EQ', 'input', '', 11, 'admin', '2023-11-17 11:07:14', '', '2023-12-21 19:36:42');
INSERT INTO `gen_table_column` VALUES (1130, 99, 'context', '正文', 'text', 'String', 'context', '0', '0', NULL, '0', '0', '1', '0', 'EQ', 'textarea', '', 12, 'admin', '2023-11-17 11:07:14', '', '2023-12-21 19:36:42');
INSERT INTO `gen_table_column` VALUES (1131, 99, 'tenders', '标书', 'varchar(100)', 'String', 'tenders', '0', '0', NULL, '0', '0', '1', '0', 'EQ', 'input', '', 13, 'admin', '2023-11-17 11:07:15', '', '2023-12-21 19:36:43');
INSERT INTO `gen_table_column` VALUES (1132, 99, 'state', '状态', 'int(11)', 'Long', 'state', '0', '0', NULL, '0', '0', '0', '0', 'EQ', 'input', 'notice_state', 14, 'admin', '2023-11-17 11:07:15', '', '2023-12-21 19:36:43');
INSERT INTO `gen_table_column` VALUES (1133, 99, 'is_delete', '删除', 'int(11)', 'Long', 'isDelete', '0', '0', NULL, '0', '0', '0', '0', 'EQ', 'input', '', 15, 'admin', '2023-11-17 11:07:15', '', '2023-12-21 19:36:43');
INSERT INTO `gen_table_column` VALUES (1134, 100, 'tender_projects_id', '项目ID', 'int(11)', 'Long', 'tenderProjectsId', '1', '1', NULL, '1', NULL, '1', NULL, 'EQ', 'input', '', 1, 'admin', '2023-11-17 11:07:15', '', '2023-12-06 11:42:06');
INSERT INTO `gen_table_column` VALUES (1135, 100, 'tender_projects_name', '项目名称', 'varchar(64)', 'String', 'tenderProjectsName', '0', '0', NULL, '1', '1', '1', '1', 'LIKE', 'input', '', 3, 'admin', '2023-11-17 11:07:15', '', '2023-12-06 11:42:07');
INSERT INTO `gen_table_column` VALUES (1136, 100, 'projects_type', '业务类型', 'int(11)', 'Long', 'projectsType', '0', '0', NULL, '1', '1', '1', '0', 'EQ', 'select', 'projects_type', 4, 'admin', '2023-11-17 11:07:15', '', '2023-12-06 11:42:07');
INSERT INTO `gen_table_column` VALUES (1137, 100, 'tender_projects_money', '项目预算', 'decimal(10,0)', 'Long', 'tenderProjectsMoney', '0', '0', NULL, '1', '1', '1', '0', 'EQ', 'input', '', 5, 'admin', '2023-11-17 11:07:16', '', '2023-12-06 11:42:07');
INSERT INTO `gen_table_column` VALUES (1138, 100, 'tender_projects_contact', '联系人', 'varchar(20)', 'String', 'tenderProjectsContact', '0', '0', NULL, '1', '1', '1', '0', 'EQ', 'input', '', 6, 'admin', '2023-11-17 11:07:16', '', '2023-12-06 11:42:07');
INSERT INTO `gen_table_column` VALUES (1139, 100, 'tender_projects_phone', '电话', 'char(11)', 'String', 'tenderProjectsPhone', '0', '0', NULL, '1', '1', '1', '0', 'EQ', 'input', '', 7, 'admin', '2023-11-17 11:07:16', '', '2023-12-06 11:42:07');
INSERT INTO `gen_table_column` VALUES (1140, 100, 'tender_projects_address', '地址', 'varchar(200)', 'String', 'tenderProjectsAddress', '0', '0', NULL, '1', '1', '1', '0', 'EQ', 'input', '', 8, 'admin', '2023-11-17 11:07:16', '', '2023-12-06 11:42:07');
INSERT INTO `gen_table_column` VALUES (1141, 100, 'tender_projects_email', '邮箱', 'varchar(35)', 'String', 'tenderProjectsEmail', '0', '0', NULL, '1', '1', '1', '0', 'EQ', 'input', '', 9, 'admin', '2023-11-17 11:07:16', '', '2023-12-06 11:42:07');
INSERT INTO `gen_table_column` VALUES (1142, 100, 'remark', '备注', 'varchar(200)', 'String', 'remark', '0', '0', NULL, '1', '1', '1', NULL, 'EQ', 'input', '', 10, 'admin', '2023-11-17 11:07:16', '', '2023-12-06 11:42:08');
INSERT INTO `gen_table_column` VALUES (1143, 100, 'manner', '招标方式', 'int(11)', 'Long', 'manner', '0', '0', NULL, '1', '1', '1', '0', 'EQ', 'input', '', 11, 'admin', '2023-11-17 11:07:16', '', '2023-12-06 11:42:08');
INSERT INTO `gen_table_column` VALUES (1144, 100, 'censor', '审查表地址', 'varchar(200)', 'String', 'censor', '0', '0', NULL, '1', '1', '1', '0', 'EQ', 'input', '', 12, 'admin', '2023-11-17 11:07:16', '', '2023-12-06 11:42:08');
INSERT INTO `gen_table_column` VALUES (1145, 100, 'must', '资格审查方式', 'int(11)', 'Long', 'must', '0', '0', NULL, '1', '1', '1', '0', 'EQ', 'input', '', 13, 'admin', '2023-11-17 11:07:16', '', '2023-12-06 11:42:08');
INSERT INTO `gen_table_column` VALUES (1146, 100, 'audit_state', '审核状态', 'int(11)', 'Long', 'auditState', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', 'require_state', 14, 'admin', '2023-11-17 11:07:17', '', '2023-12-06 11:42:08');
INSERT INTO `gen_table_column` VALUES (1147, 100, 'creat_by', '创建人', 'varchar(20)', 'String', 'creatBy', '0', '0', NULL, '1', '1', '1', '0', 'EQ', 'input', '', 15, 'admin', '2023-11-17 11:07:17', '', '2023-12-06 11:42:08');
INSERT INTO `gen_table_column` VALUES (1148, 100, 'creat_time', '创建时间', 'datetime', 'Date', 'creatTime', '0', '0', NULL, '1', '1', '1', '1', 'BETWEEN', 'datetime', '', 16, 'admin', '2023-11-17 11:07:17', '', '2023-12-06 11:42:08');
INSERT INTO `gen_table_column` VALUES (1149, 100, 'is_delete', '删除', 'int(11)', 'Long', 'isDelete', '0', '0', NULL, '1', '1', '1', '0', 'EQ', 'input', '', 17, 'admin', '2023-11-17 11:07:17', '', '2023-12-06 11:42:08');
INSERT INTO `gen_table_column` VALUES (1174, 102, 'annex_id', '附件id', 'int(11)', 'Long', 'annexId', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2023-11-17 11:07:20', '', '2023-12-25 12:47:52');
INSERT INTO `gen_table_column` VALUES (1175, 102, 'supply_id', '主键编号', 'int(11)', 'Long', 'supplyId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 2, 'admin', '2023-11-17 11:07:20', '', '2023-12-25 12:47:52');
INSERT INTO `gen_table_column` VALUES (1176, 102, 'annex_type_id', '附件类型', 'int(11)', 'Long', 'annexTypeId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2023-11-17 11:07:21', '', '2023-12-25 12:47:52');
INSERT INTO `gen_table_column` VALUES (1177, 102, 'annex_text', '附件正文', 'text', 'String', 'annexText', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2023-11-17 11:07:21', '', '2023-12-25 12:47:53');
INSERT INTO `gen_table_column` VALUES (1178, 102, 'annex_url', '附件url', 'varchar(255)', 'String', 'annexUrl', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 5, 'admin', '2023-11-17 11:07:21', '', '2023-12-25 12:47:53');
INSERT INTO `gen_table_column` VALUES (1179, 102, 'up_time', '上传时间', 'datetime', 'Date', 'upTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 6, 'admin', '2023-11-17 11:07:21', '', '2023-12-25 12:47:53');
INSERT INTO `gen_table_column` VALUES (1180, 102, 'annex_title', '附件标题', 'varchar(200)', 'String', 'annexTitle', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 7, 'admin', '2023-11-17 11:07:21', '', '2023-12-25 12:47:53');
INSERT INTO `gen_table_column` VALUES (1181, 103, 'category_id', '类别ID', 'int(11)', 'Long', 'categoryId', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2023-11-17 11:07:21', '', '2023-11-22 17:36:40');
INSERT INTO `gen_table_column` VALUES (1182, 103, 'category_number', '类别编码，用户自定义', 'varchar(20)', 'String', 'categoryNumber', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 2, 'admin', '2023-11-17 11:07:22', '', '2023-11-22 17:36:40');
INSERT INTO `gen_table_column` VALUES (1184, 103, 'parent_category', '上级品类', 'int(11)', 'Long', 'parentCategory', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'select', '', 4, 'admin', '2023-11-17 11:07:22', '', '2023-11-22 17:36:40');
INSERT INTO `gen_table_column` VALUES (1185, 103, 'create_by', '创建人', 'varchar(100)', 'String', 'createBy', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 5, 'admin', '2023-11-17 11:07:22', '', '2023-11-22 17:36:41');
INSERT INTO `gen_table_column` VALUES (1186, 103, 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'datetime', '', 6, 'admin', '2023-11-17 11:07:22', '', '2023-11-22 17:36:41');
INSERT INTO `gen_table_column` VALUES (1187, 103, 'update_by', '修改人', 'varchar(100)', 'String', 'updateBy', '0', '0', NULL, '1', '1', NULL, NULL, 'EQ', 'input', '', 7, 'admin', '2023-11-17 11:07:22', '', '2023-11-22 17:36:41');
INSERT INTO `gen_table_column` VALUES (1188, 103, 'update_time', '修改时间', 'datetime', 'Date', 'updateTime', '0', '0', NULL, '1', '1', NULL, NULL, 'EQ', 'datetime', '', 8, 'admin', '2023-11-17 11:07:22', '', '2023-11-22 17:36:41');
INSERT INTO `gen_table_column` VALUES (1189, 103, 'is_delete', '删除', 'int(11)', 'Long', 'isDelete', '0', '0', NULL, '1', '1', '1', '0', 'EQ', 'input', '', 9, 'admin', '2023-11-17 11:07:22', '', '2023-11-22 17:36:41');
INSERT INTO `gen_table_column` VALUES (1190, 104, 'contacts_id', '供应商联系人ID', 'int(11)', 'Long', 'contactsId', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2023-11-17 11:07:23', '', '2023-11-21 00:35:11');
INSERT INTO `gen_table_column` VALUES (1191, 104, 'contacts_vendor_id', '供应商ID', 'int(11)', 'Long', 'contactsVendorId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 2, 'admin', '2023-11-17 11:07:23', '', '2023-11-21 00:35:11');
INSERT INTO `gen_table_column` VALUES (1192, 104, 'call', '称呼', 'varchar(100)', 'String', 'call', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2023-11-17 11:07:23', '', '2023-11-21 00:35:11');
INSERT INTO `gen_table_column` VALUES (1193, 104, 'job', '岗位', 'varchar(20)', 'String', 'job', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2023-11-17 11:07:23', '', '2023-11-21 00:35:11');
INSERT INTO `gen_table_column` VALUES (1194, 104, 'division', '部门', 'varchar(10)', 'String', 'division', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 5, 'admin', '2023-11-17 11:07:23', '', '2023-11-21 00:35:12');
INSERT INTO `gen_table_column` VALUES (1195, 104, 'phone', '移动电话', 'varchar(11)', 'String', 'phone', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 6, 'admin', '2023-11-17 11:07:23', '', '2023-11-21 00:35:12');
INSERT INTO `gen_table_column` VALUES (1196, 104, 'mailbox', '邮箱', 'varchar(20)', 'String', 'mailbox', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 7, 'admin', '2023-11-17 11:07:23', '', '2023-11-21 00:35:12');
INSERT INTO `gen_table_column` VALUES (1197, 105, 'contract_id', '合同ID', 'int(11)', 'Long', 'contractId', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2023-11-17 11:07:24', '', '2023-12-05 17:59:23');
INSERT INTO `gen_table_column` VALUES (1198, 105, 'applicant', '申请人', 'varchar(20)', 'String', 'applicant', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 2, 'admin', '2023-11-17 11:07:24', '', '2023-12-05 17:59:23');
INSERT INTO `gen_table_column` VALUES (1199, 105, 'applicant_time', '申请日期', 'datetime', 'Date', 'applicantTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 3, 'admin', '2023-11-17 11:07:24', '', '2023-12-05 17:59:23');
INSERT INTO `gen_table_column` VALUES (1201, 105, 'firm', '申请公司', 'varchar(200)', 'String', 'firm', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 5, 'admin', '2023-11-17 11:07:24', '', '2023-12-05 17:59:23');
INSERT INTO `gen_table_column` VALUES (1203, 105, 'create_by', '创建人', 'varchar(100)', 'String', 'createBy', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 12, 'admin', '2023-11-17 11:07:24', '', '2023-12-05 17:59:24');
INSERT INTO `gen_table_column` VALUES (1204, 105, 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'datetime', '', 13, 'admin', '2023-11-17 11:07:24', '', '2023-12-05 17:59:25');
INSERT INTO `gen_table_column` VALUES (1205, 105, 'update_by', '修改人', 'varchar(100)', 'String', 'updateBy', '0', '0', NULL, '1', '1', NULL, NULL, 'EQ', 'input', '', 14, 'admin', '2023-11-17 11:07:25', '', '2023-12-05 17:59:25');
INSERT INTO `gen_table_column` VALUES (1206, 105, 'update_time', '修改时间', 'datetime', 'Date', 'updateTime', '0', '0', NULL, '1', '1', NULL, NULL, 'EQ', 'datetime', '', 15, 'admin', '2023-11-17 11:07:25', '', '2023-12-05 17:59:25');
INSERT INTO `gen_table_column` VALUES (1207, 106, 'contractdetails_id', '合同明细ID', 'int(11)', 'Long', 'contractdetailsId', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2023-11-17 11:07:25', '', '2023-12-28 11:06:52');
INSERT INTO `gen_table_column` VALUES (1209, 106, 'contractdetails_payment_id', '外键合同付款ID', 'int(11)', 'String', 'contractdetailsPaymentId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2023-11-17 11:07:25', '', '2023-12-28 11:06:52');
INSERT INTO `gen_table_column` VALUES (1210, 106, 'contractdetails_name', '合同名称', 'varchar(300)', 'String', 'contractdetailsName', '0', '0', NULL, '1', '1', '1', '1', 'LIKE', 'input', '', 5, 'admin', '2023-11-17 11:07:25', '', '2023-12-28 11:06:52');
INSERT INTO `gen_table_column` VALUES (1212, 106, 'open_time', '开始时间', 'datetime', 'Date', 'openTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 7, 'admin', '2023-11-17 11:07:26', '', '2023-12-28 11:06:52');
INSERT INTO `gen_table_column` VALUES (1213, 106, 'contractdetails_amount', '合同总金额', 'decimal(10,0)', 'Long', 'contractdetailsAmount', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 8, 'admin', '2023-11-17 11:07:26', '', '2023-12-28 11:06:53');
INSERT INTO `gen_table_column` VALUES (1214, 106, 'illustrate', '合同情况说明', 'text', 'String', 'illustrate', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'textarea', '', 10, 'admin', '2023-11-17 11:07:26', '', '2023-12-28 11:06:53');
INSERT INTO `gen_table_column` VALUES (1215, 106, 'bid_end', '结束时间', 'datetime', 'Date', 'bidEnd', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 11, 'admin', '2023-11-17 11:07:26', '', '2023-12-28 11:06:53');
INSERT INTO `gen_table_column` VALUES (1216, 106, 'create_by', '创建人', 'varchar(100)', 'String', 'createBy', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 16, 'admin', '2023-11-17 11:07:26', '', '2023-12-28 11:06:54');
INSERT INTO `gen_table_column` VALUES (1217, 106, 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'datetime', '', 17, 'admin', '2023-11-17 11:07:26', '', '2023-12-28 11:06:54');
INSERT INTO `gen_table_column` VALUES (1218, 106, 'update_by', '修改人', 'varchar(100)', 'String', 'updateBy', '0', '0', NULL, '1', '1', NULL, NULL, 'EQ', 'input', '', 18, 'admin', '2023-11-17 11:07:26', '', '2023-12-28 11:06:54');
INSERT INTO `gen_table_column` VALUES (1219, 106, 'update_time', '修改时间', 'datetime', 'Date', 'updateTime', '0', '0', NULL, '1', '1', NULL, NULL, 'EQ', 'datetime', '', 19, 'admin', '2023-11-17 11:07:26', '', '2023-12-28 11:06:54');
INSERT INTO `gen_table_column` VALUES (1220, 107, 'expert_id', '主键', 'int(11)', 'Long', 'expertId', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2023-11-17 11:07:27', '', '2023-12-20 11:30:45');
INSERT INTO `gen_table_column` VALUES (1221, 107, 'name', '专家姓名', 'varchar(40)', 'String', 'name', '0', '0', NULL, '1', '1', '1', '1', 'LIKE', 'input', '', 3, 'admin', '2023-11-17 11:07:27', '', '2023-12-20 11:30:45');
INSERT INTO `gen_table_column` VALUES (1222, 107, 'id_card', '专家身份证', 'char(18)', 'String', 'idCard', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2023-11-17 11:07:27', '', '2023-12-20 11:30:45');
INSERT INTO `gen_table_column` VALUES (1224, 107, 'address', '区域', 'varchar(200)', 'String', 'address', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 5, 'admin', '2023-11-17 11:07:27', '', '2023-12-20 11:30:46');
INSERT INTO `gen_table_column` VALUES (1225, 107, 'phone', '移动电话', 'char(11)', 'String', 'phone', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 6, 'admin', '2023-11-17 11:07:27', '', '2023-12-20 11:30:46');
INSERT INTO `gen_table_column` VALUES (1226, 107, 'create_by', '创建人', 'varchar(100)', 'String', 'createBy', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 7, 'admin', '2023-11-17 11:07:27', '', '2023-12-20 11:30:46');
INSERT INTO `gen_table_column` VALUES (1227, 107, 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'datetime', '', 8, 'admin', '2023-11-17 11:07:27', '', '2023-12-20 11:30:46');
INSERT INTO `gen_table_column` VALUES (1228, 107, 'update_by', '修改人', 'varchar(100)', 'String', 'updateBy', '0', '0', NULL, '1', '1', NULL, NULL, 'EQ', 'input', '', 9, 'admin', '2023-11-17 11:07:28', '', '2023-12-20 11:30:46');
INSERT INTO `gen_table_column` VALUES (1229, 107, 'update_time', '修改时间', 'datetime', 'Date', 'updateTime', '0', '0', NULL, '1', '1', NULL, NULL, 'EQ', 'datetime', '', 10, 'admin', '2023-11-17 11:07:28', '', '2023-12-20 11:30:46');
INSERT INTO `gen_table_column` VALUES (1230, 107, 'is_delete', '删除', 'int(11)', 'Long', 'isDelete', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 11, 'admin', '2023-11-17 11:07:28', '', '2023-12-20 11:30:47');
INSERT INTO `gen_table_column` VALUES (1231, 108, 'expert_pool_id', '主键', 'int(11)', 'Long', 'expertPoolId', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2023-11-17 11:07:28', '', '2023-12-20 11:55:35');
INSERT INTO `gen_table_column` VALUES (1232, 108, 'expert_pool_name', '库名', 'varchar(64)', 'String', 'expertPoolName', '0', '0', NULL, '1', '1', '1', '1', 'LIKE', 'input', '', 2, 'admin', '2023-11-17 11:07:28', '', '2023-12-20 11:55:36');
INSERT INTO `gen_table_column` VALUES (1234, 108, 'level', '级别', 'int(11)', 'Long', 'level', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', 'expert_pool_level', 3, 'admin', '2023-11-17 11:07:29', '', '2023-12-20 11:55:36');
INSERT INTO `gen_table_column` VALUES (1236, 108, 'category', '类别', 'int(11)', 'Long', 'category', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', 'pool_type', 4, 'admin', '2023-11-17 11:07:29', '', '2023-12-20 11:55:36');
INSERT INTO `gen_table_column` VALUES (1240, 108, 'create_by', '创建人', 'varchar(100)', 'String', 'createBy', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 5, 'admin', '2023-11-17 11:07:29', '', '2023-12-20 11:55:37');
INSERT INTO `gen_table_column` VALUES (1241, 108, 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'datetime', '', 6, 'admin', '2023-11-17 11:07:29', '', '2023-12-20 11:55:37');
INSERT INTO `gen_table_column` VALUES (1242, 108, 'update_by', '修改人', 'varchar(100)', 'String', 'updateBy', '0', '0', NULL, '0', '1', '1', NULL, 'EQ', 'input', '', 7, 'admin', '2023-11-17 11:07:29', '', '2023-12-20 11:55:37');
INSERT INTO `gen_table_column` VALUES (1243, 108, 'update_time', '修改时间', 'datetime', 'Date', 'updateTime', '0', '0', NULL, '0', '1', '1', NULL, 'EQ', 'datetime', '', 8, 'admin', '2023-11-17 11:07:29', '', '2023-12-20 11:55:38');
INSERT INTO `gen_table_column` VALUES (1244, 108, 'is_delete', '删除', 'int(11)', 'Long', 'isDelete', '0', '0', NULL, '1', '1', '1', '0', 'EQ', 'input', '', 9, 'admin', '2023-11-17 11:07:30', '', '2023-12-20 11:55:38');
INSERT INTO `gen_table_column` VALUES (1245, 109, 'goods_id', '物料ID', 'int(11)', 'Long', 'goodsId', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2023-11-17 11:07:30', '', '2023-11-23 16:41:01');
INSERT INTO `gen_table_column` VALUES (1246, 109, 'category_id', '类别ID', 'int(11)', 'Long', 'categoryId', '0', '0', NULL, '1', '1', '1', '0', 'EQ', 'input', '', 2, 'admin', '2023-11-17 11:07:30', '', '2023-11-23 16:41:01');
INSERT INTO `gen_table_column` VALUES (1247, 109, 'goods_name', '商品名称', 'varchar(20)', 'String', 'goodsName', '0', '0', NULL, '1', '1', '1', '1', 'LIKE', 'input', '', 3, 'admin', '2023-11-17 11:07:30', '', '2023-11-23 16:41:01');
INSERT INTO `gen_table_column` VALUES (1248, 109, 'goods_type', '计量单位', 'int(11)', 'Long', 'goodsType', '0', '0', NULL, '1', '1', '1', '0', 'EQ', 'select', 'goods_unit', 4, 'admin', '2023-11-17 11:07:30', '', '2023-11-23 16:41:01');
INSERT INTO `gen_table_column` VALUES (1249, 109, 'specs', '规格', 'char(10)', 'String', 'specs', '0', '0', NULL, '1', '1', '1', '0', 'EQ', 'input', '', 5, 'admin', '2023-11-17 11:07:30', '', '2023-11-23 16:41:01');
INSERT INTO `gen_table_column` VALUES (1250, 109, 'model', '型号', 'char(10)', 'String', 'model', '0', '0', NULL, '1', '1', '1', '0', 'EQ', 'input', '', 6, 'admin', '2023-11-17 11:07:30', '', '2023-11-23 16:41:01');
INSERT INTO `gen_table_column` VALUES (1251, 109, 'brand', '品牌', 'char(10)', 'String', 'brand', '0', '0', NULL, '1', '1', '1', '0', 'EQ', 'input', '', 7, 'admin', '2023-11-17 11:07:31', '', '2023-11-23 16:41:02');
INSERT INTO `gen_table_column` VALUES (1252, 109, 'weight', '重量单位', 'decimal(10,0)', 'Long', 'weight', '0', '0', NULL, '1', '1', '1', '0', 'EQ', 'input', '', 8, 'admin', '2023-11-17 11:07:31', '', '2023-11-23 16:41:02');
INSERT INTO `gen_table_column` VALUES (1253, 109, 'goods_number', '商品数量', 'int(11)', 'Long', 'goodsNumber', '0', '0', NULL, '1', '1', '1', '0', 'EQ', 'input', '', 9, 'admin', '2023-11-17 11:07:31', '', '2023-11-23 16:41:02');
INSERT INTO `gen_table_column` VALUES (1254, 109, 'volume', '体积单位', 'decimal(10,0)', 'Long', 'volume', '0', '0', NULL, '1', '1', '1', '0', 'EQ', 'input', '', 10, 'admin', '2023-11-17 11:07:31', '', '2023-11-23 16:41:02');
INSERT INTO `gen_table_column` VALUES (1255, 109, 'buyer', ' 默认,远志集团有限公司', 'varchar(20)', 'String', 'buyer', '0', '0', NULL, '1', '0', '1', '0', 'EQ', 'input', '', 11, 'admin', '2023-11-17 11:07:31', '', '2023-11-23 16:41:02');
INSERT INTO `gen_table_column` VALUES (1256, 109, 'state', '状态', 'int(11)', 'Long', 'state', '0', '0', NULL, '1', '1', '1', '0', 'EQ', 'input', '', 12, 'admin', '2023-11-17 11:07:31', '', '2023-11-23 16:41:02');
INSERT INTO `gen_table_column` VALUES (1257, 109, 'create_by', '创建人', 'varchar(100)', 'String', 'createBy', '0', '0', NULL, '1', NULL, '0', NULL, 'EQ', 'input', '', 13, 'admin', '2023-11-17 11:07:31', '', '2023-11-23 16:41:02');
INSERT INTO `gen_table_column` VALUES (1258, 109, 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', NULL, '1', NULL, '1', NULL, 'EQ', 'datetime', '', 14, 'admin', '2023-11-17 11:07:31', '', '2023-11-23 16:41:03');
INSERT INTO `gen_table_column` VALUES (1259, 109, 'update_by', '修改人', 'varchar(100)', 'String', 'updateBy', '0', '0', NULL, '1', '1', NULL, NULL, 'EQ', 'input', '', 15, 'admin', '2023-11-17 11:07:31', '', '2023-11-23 16:41:03');
INSERT INTO `gen_table_column` VALUES (1260, 109, 'update_time', '修改时间', 'datetime', 'Date', 'updateTime', '0', '0', NULL, '1', '1', '1', NULL, 'EQ', 'datetime', '', 16, 'admin', '2023-11-17 11:07:32', '', '2023-11-23 16:41:03');
INSERT INTO `gen_table_column` VALUES (1261, 110, 'payment_id', '合同付款ID', 'int(11)', 'Long', 'paymentId', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2023-11-17 11:07:32', '', '2023-12-19 11:28:57');
INSERT INTO `gen_table_column` VALUES (1262, 110, 'content', '款项内容', 'int(11)', 'Long', 'content', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'editor', '', 2, 'admin', '2023-11-17 11:07:32', '', '2023-12-19 11:28:57');
INSERT INTO `gen_table_column` VALUES (1263, 110, 'pay_time', '付款日期', 'datetime', 'Date', 'payTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 3, 'admin', '2023-11-17 11:07:32', '', '2023-12-19 11:28:57');
INSERT INTO `gen_table_column` VALUES (1264, 110, 'unit', '付款单位', 'varchar(10)', 'String', 'unit', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2023-11-17 11:07:32', '', '2023-12-19 11:28:57');
INSERT INTO `gen_table_column` VALUES (1265, 110, 'payment_vendor_id', '供应商ID（外键）（收款合同方）', 'int(11)', 'Long', 'paymentVendorId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 5, 'admin', '2023-11-17 11:07:32', '', '2023-12-19 11:28:58');
INSERT INTO `gen_table_column` VALUES (1266, 110, 'terms', '付款条件', 'varchar(20)', 'String', 'terms', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 6, 'admin', '2023-11-17 11:07:32', '', '2023-12-19 11:28:58');
INSERT INTO `gen_table_column` VALUES (1267, 110, 'sum', '付款金额', 'decimal(10,0)', 'Long', 'sum', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 7, 'admin', '2023-11-17 11:07:33', '', '2023-12-19 11:28:58');
INSERT INTO `gen_table_column` VALUES (1268, 110, 'duty', '违约责任', 'varchar(20)', 'String', 'duty', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 8, 'admin', '2023-11-17 11:07:33', '', '2023-12-19 11:28:58');
INSERT INTO `gen_table_column` VALUES (1269, 110, 'create_by', '创建人', 'varchar(100)', 'String', 'createBy', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 9, 'admin', '2023-11-17 11:07:33', '', '2023-12-19 11:28:58');
INSERT INTO `gen_table_column` VALUES (1270, 110, 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'datetime', '', 10, 'admin', '2023-11-17 11:07:33', '', '2023-12-19 11:28:58');
INSERT INTO `gen_table_column` VALUES (1271, 110, 'update_by', '修改人', 'varchar(100)', 'String', 'updateBy', '0', '0', NULL, '1', '1', NULL, NULL, 'EQ', 'input', '', 11, 'admin', '2023-11-17 11:07:33', '', '2023-12-19 11:28:59');
INSERT INTO `gen_table_column` VALUES (1272, 110, 'update_time', '修改时间', 'datetime', 'Date', 'updateTime', '0', '0', NULL, '1', '1', NULL, NULL, 'EQ', 'datetime', '', 12, 'admin', '2023-11-17 11:07:33', '', '2023-12-19 11:28:59');
INSERT INTO `gen_table_column` VALUES (1273, 111, 'receipt_id', '收货单ID', 'int(11)', 'Long', 'receiptId', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2023-11-17 11:07:34', '', '2023-12-13 15:03:34');
INSERT INTO `gen_table_column` VALUES (1274, 111, 'receipt_clod', '收货单号', 'varchar(200)', 'String', 'receiptClod', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 2, 'admin', '2023-11-17 11:07:34', '', '2023-12-13 15:03:34');
INSERT INTO `gen_table_column` VALUES (1275, 111, 'receipt_time', '收货日期', 'datetime', 'Date', 'receiptTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 3, 'admin', '2023-11-17 11:07:34', '', '2023-12-13 15:03:34');
INSERT INTO `gen_table_column` VALUES (1276, 111, 'receipt_by', '收货人', 'varchar(100)', 'String', 'receiptBy', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2023-11-17 11:07:34', '', '2023-12-13 15:03:34');
INSERT INTO `gen_table_column` VALUES (1277, 111, 'receipt_number', '收货总数量', 'int(11)', 'Long', 'receiptNumber', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 5, 'admin', '2023-11-17 11:07:34', '', '2023-12-13 15:03:34');
INSERT INTO `gen_table_column` VALUES (1278, 111, 'receipt_money', '金额', 'decimal(10,0)', 'Long', 'receiptMoney', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 6, 'admin', '2023-11-17 11:07:34', '', '2023-12-13 15:03:35');
INSERT INTO `gen_table_column` VALUES (1279, 111, 'remark', '备注', 'varchar(200)', 'String', 'remark', '0', '0', NULL, '1', '1', '1', '1', 'LIKE', 'input', '', 7, 'admin', '2023-11-17 11:07:34', '', '2023-12-13 15:03:35');
INSERT INTO `gen_table_column` VALUES (1280, 111, 'receipt_vendor_id', '供应商ID（外键）', 'int(11)', 'Long', 'receiptVendorId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 8, 'admin', '2023-11-17 11:07:34', '', '2023-12-13 15:03:35');
INSERT INTO `gen_table_column` VALUES (1281, 111, 'contact', '联系人', 'varchar(100)', 'String', 'contact', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 9, 'admin', '2023-11-17 11:07:34', '', '2023-12-13 15:03:35');
INSERT INTO `gen_table_column` VALUES (1282, 111, 'receipt_phone', '移动电话', 'char(11)', 'String', 'receiptPhone', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 10, 'admin', '2023-11-17 11:07:35', '', '2023-12-13 15:03:35');
INSERT INTO `gen_table_column` VALUES (1284, 111, 'create_by', '创建人', 'varchar(100)', 'String', 'createBy', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 14, 'admin', '2023-11-17 11:07:35', '', '2023-12-13 15:03:36');
INSERT INTO `gen_table_column` VALUES (1285, 111, 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'datetime', '', 15, 'admin', '2023-11-17 11:07:35', '', '2023-12-13 15:03:36');
INSERT INTO `gen_table_column` VALUES (1286, 111, 'update_by', '修改人', 'varchar(100)', 'String', 'updateBy', '0', '0', NULL, '1', '1', NULL, NULL, 'EQ', 'input', '', 16, 'admin', '2023-11-17 11:07:35', '', '2023-12-13 15:03:36');
INSERT INTO `gen_table_column` VALUES (1287, 111, 'update_time', '修改时间', 'datetime', 'Date', 'updateTime', '0', '0', NULL, '1', '1', NULL, NULL, 'EQ', 'datetime', '', 17, 'admin', '2023-11-17 11:07:35', '', '2023-12-13 15:03:36');
INSERT INTO `gen_table_column` VALUES (1288, 111, 'is_delete', '删除', 'int(11)', 'Long', 'isDelete', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 18, 'admin', '2023-11-17 11:07:35', '', '2023-12-13 15:03:36');
INSERT INTO `gen_table_column` VALUES (1289, 112, 'supplied_materials_id', '供货物料表id', 'int(11)', 'Long', 'suppliedMaterialsId', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2023-11-17 11:07:36', '', '2023-11-21 00:37:44');
INSERT INTO `gen_table_column` VALUES (1290, 112, 'supply_id', '供货表编号（外键）', 'int(11)', 'Long', 'supplyId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 2, 'admin', '2023-11-17 11:07:36', '', '2023-11-21 00:37:44');
INSERT INTO `gen_table_column` VALUES (1291, 112, 'available', '是否可供', 'int(11)', 'Long', 'available', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2023-11-17 11:07:36', '', '2023-11-21 00:37:44');
INSERT INTO `gen_table_column` VALUES (1292, 112, 'demand_ma_id', '物料id', 'int(11)', 'Long', 'demandMaId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2023-11-17 11:07:36', '', '2023-11-21 00:37:44');
INSERT INTO `gen_table_column` VALUES (1293, 112, 'exempt', '是否免检', 'int(11)', 'Long', 'exempt', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 5, 'admin', '2023-11-17 11:07:36', '', '2023-11-21 00:37:44');
INSERT INTO `gen_table_column` VALUES (1294, 112, 'grade', '供货能力等级', 'int(11)', 'Long', 'grade', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 6, 'admin', '2023-11-17 11:07:36', '', '2023-11-21 00:37:44');
INSERT INTO `gen_table_column` VALUES (1295, 113, 'supply_id', '供货ID（主键）', 'int(11)', 'Long', 'supplyId', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2023-11-17 11:07:37', '', '2023-12-04 19:14:17');
INSERT INTO `gen_table_column` VALUES (1296, 113, 'supply_vendor_id', '供应商主键', 'int(11)', 'Long', 'supplyVendorId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 2, 'admin', '2023-11-17 11:07:37', '', '2023-12-04 19:14:17');
INSERT INTO `gen_table_column` VALUES (1297, 113, 'supplier_code', '供应商编码', 'varchar(100)', 'String', 'supplierCode', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2023-11-17 11:07:37', '', '2023-12-04 19:14:17');
INSERT INTO `gen_table_column` VALUES (1298, 113, 'supplier_name', '供应商名称', 'varchar(100)', 'String', 'supplierName', '0', '0', NULL, '1', '1', '1', '1', 'LIKE', 'input', '', 4, 'admin', '2023-11-17 11:07:37', '', '2023-12-04 19:14:17');
INSERT INTO `gen_table_column` VALUES (1299, 113, 'remark', '备注', 'varchar(200)', 'String', 'remark', '0', '0', NULL, '1', '1', '1', NULL, 'EQ', 'input', '', 5, 'admin', '2023-11-17 11:07:37', '', '2023-12-04 19:14:17');
INSERT INTO `gen_table_column` VALUES (1300, 113, 'create_by', '创建人', 'varchar(100)', 'String', 'createBy', '0', '0', NULL, '1', NULL, '1', NULL, 'EQ', 'input', '', 6, 'admin', '2023-11-17 11:07:37', '', '2023-12-04 19:14:17');
INSERT INTO `gen_table_column` VALUES (1301, 113, 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', NULL, '1', NULL, '1', NULL, 'EQ', 'datetime', '', 7, 'admin', '2023-11-17 11:07:37', '', '2023-12-04 19:14:17');
INSERT INTO `gen_table_column` VALUES (1302, 113, 'update_by', '修改人', 'varchar(100)', 'String', 'updateBy', '0', '0', NULL, '1', '1', '1', NULL, 'EQ', 'input', '', 8, 'admin', '2023-11-17 11:07:37', '', '2023-12-04 19:14:18');
INSERT INTO `gen_table_column` VALUES (1303, 113, 'update_time', '修改时间', 'datetime', 'Date', 'updateTime', '0', '0', NULL, '1', '1', '1', NULL, 'EQ', 'datetime', '', 9, 'admin', '2023-11-17 11:07:38', '', '2023-12-04 19:14:18');
INSERT INTO `gen_table_column` VALUES (1304, 113, 'is_delete', '删除', 'int(11)', 'Long', 'isDelete', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 10, 'admin', '2023-11-17 11:07:38', '', '2023-12-04 19:14:18');
INSERT INTO `gen_table_column` VALUES (1305, 114, 'user_id', '用户ID', 'int(11)', 'Long', 'userId', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2023-11-17 11:07:38', '', '2023-11-21 00:39:26');
INSERT INTO `gen_table_column` VALUES (1306, 114, 'account', '账号', 'varchar(20)', 'String', 'account', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 2, 'admin', '2023-11-17 11:07:38', '', '2023-11-21 00:39:26');
INSERT INTO `gen_table_column` VALUES (1307, 114, 'password', '密码', 'varchar(100)', 'String', 'password', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2023-11-17 11:07:38', '', '2023-11-21 00:39:26');
INSERT INTO `gen_table_column` VALUES (1308, 114, 'job', '岗位', 'varchar(20)', 'String', 'job', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2023-11-17 11:07:38', '', '2023-11-21 00:39:26');
INSERT INTO `gen_table_column` VALUES (1309, 114, 'phone', '移动电话', 'char(11)', 'String', 'phone', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 5, 'admin', '2023-11-17 11:07:38', '', '2023-11-21 00:39:27');
INSERT INTO `gen_table_column` VALUES (1310, 114, 'last_logintime', '最后登录日期', 'datetime', 'Date', 'lastLogintime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 6, 'admin', '2023-11-17 11:07:39', '', '2023-11-21 00:39:27');
INSERT INTO `gen_table_column` VALUES (1311, 114, 'create_by', '创建人', 'varchar(100)', 'String', 'createBy', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 7, 'admin', '2023-11-17 11:07:39', '', '2023-11-21 00:39:27');
INSERT INTO `gen_table_column` VALUES (1312, 114, 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'datetime', '', 8, 'admin', '2023-11-17 11:07:39', '', '2023-11-21 00:39:27');
INSERT INTO `gen_table_column` VALUES (1313, 114, 'update_by', '修改人', 'varchar(100)', 'String', 'updateBy', '0', '0', NULL, '1', '1', NULL, NULL, 'EQ', 'input', '', 9, 'admin', '2023-11-17 11:07:39', '', '2023-11-21 00:39:27');
INSERT INTO `gen_table_column` VALUES (1314, 114, 'update_time', '修改时间', 'datetime', 'Date', 'updateTime', '0', '0', NULL, '1', '1', NULL, NULL, 'EQ', 'datetime', '', 10, 'admin', '2023-11-17 11:07:39', '', '2023-11-21 00:39:27');
INSERT INTO `gen_table_column` VALUES (1315, 114, 'identity', '0:采购部,1:供应商', 'int(11)', 'Long', 'identity', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 11, 'admin', '2023-11-17 11:07:39', '', '2023-11-21 00:39:27');
INSERT INTO `gen_table_column` VALUES (1316, 115, 'warehouse_id', '仓库ID', 'int(11)', 'Long', 'warehouseId', '1', '1', '1', '0', NULL, '1', '0', 'EQ', 'input', '', 1, 'admin', '2023-11-17 11:07:39', '', '2023-11-21 14:27:11');
INSERT INTO `gen_table_column` VALUES (1317, 115, 'warehouse_address', '仓库地址', 'varchar(200)', 'String', 'warehouseAddress', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 2, 'admin', '2023-11-17 11:07:40', '', '2023-11-21 14:27:11');
INSERT INTO `gen_table_column` VALUES (1318, 115, 'warehouse_number', '仓库编码', 'varchar(20)', 'String', 'warehouseNumber', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2023-11-17 11:07:40', '', '2023-11-21 14:27:11');
INSERT INTO `gen_table_column` VALUES (1319, 116, 'buy_plan_id', '采购计划主键', 'int(11)', 'Long', 'buyPlanId', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2023-11-17 11:07:40', '', '2023-11-27 19:48:10');
INSERT INTO `gen_table_column` VALUES (1320, 116, 'plan_clod', '采购计划编码（转订单编码，不需要修改）', 'varchar(100)', 'String', 'planClod', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 2, 'admin', '2023-11-17 11:07:40', '', '2023-11-27 19:48:10');
INSERT INTO `gen_table_column` VALUES (1321, 116, 'buy_plan_vendor_id', '供应商主键', 'int(11)', 'Long', 'buyPlanVendorId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2023-11-17 11:07:40', '', '2023-11-27 19:48:10');
INSERT INTO `gen_table_column` VALUES (1322, 116, 'buy_plan_warehouse_id', '仓库主键', 'int(11)', 'Long', 'buyPlanWarehouseId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2023-11-17 11:07:40', '', '2023-11-27 19:48:10');
INSERT INTO `gen_table_column` VALUES (1323, 116, 'buy_type_id', '采购类型', 'int(11)', 'Long', 'buyTypeId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'select', 'require_type', 5, 'admin', '2023-11-17 11:07:40', '', '2023-11-27 19:48:10');
INSERT INTO `gen_table_column` VALUES (1324, 116, 'state', '状态', 'int(11)', 'Long', 'state', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'select', 'require_state', 6, 'admin', '2023-11-17 11:07:41', '', '2023-11-27 19:48:10');
INSERT INTO `gen_table_column` VALUES (1325, 116, 'create_by', '创建人', 'varchar(100)', 'String', 'createBy', '0', '0', NULL, '1', NULL, NULL, '1', 'EQ', 'input', '', 7, 'admin', '2023-11-17 11:07:41', '', '2023-11-27 19:48:11');
INSERT INTO `gen_table_column` VALUES (1326, 116, 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', NULL, '1', NULL, NULL, '1', 'EQ', 'datetime', '', 8, 'admin', '2023-11-17 11:07:41', '', '2023-11-27 19:48:11');
INSERT INTO `gen_table_column` VALUES (1327, 116, 'update_by', '修改人', 'varchar(100)', 'String', 'updateBy', '0', '0', NULL, '1', '0', NULL, '0', 'EQ', 'input', '', 9, 'admin', '2023-11-17 11:07:41', '', '2023-11-27 19:48:11');
INSERT INTO `gen_table_column` VALUES (1328, 116, 'update_time', '修改时间', 'datetime', 'Date', 'updateTime', '0', '0', NULL, '1', '0', NULL, '0', 'EQ', 'datetime', '', 10, 'admin', '2023-11-17 11:07:41', '', '2023-11-27 19:48:11');
INSERT INTO `gen_table_column` VALUES (1329, 116, 'is_delete', '删除', 'int(11)', 'Long', 'isDelete', '0', '0', NULL, '0', '0', '0', '0', 'EQ', 'input', '', 11, 'admin', '2023-11-17 11:07:41', '', '2023-11-27 19:48:11');
INSERT INTO `gen_table_column` VALUES (1330, 117, 'demand_id', '采购需求物料id', 'int(11)', 'Long', 'demandId', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2023-11-17 11:07:41', '', '2023-11-20 23:15:29');
INSERT INTO `gen_table_column` VALUES (1331, 117, 'demand_ma_id', '物料id', 'int(11)', 'Long', 'demandMaId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 2, 'admin', '2023-11-17 11:07:42', '', '2023-11-20 23:15:29');
INSERT INTO `gen_table_column` VALUES (1332, 117, 'demand_count', '数量', 'decimal(10,0)', 'Long', 'demandCount', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2023-11-17 11:07:42', '', '2023-11-20 23:15:29');
INSERT INTO `gen_table_column` VALUES (1333, 117, 'demand_time', '需求日期', 'datetime', 'Date', 'demandTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 4, 'admin', '2023-11-17 11:07:42', '', '2023-11-20 23:15:29');
INSERT INTO `gen_table_column` VALUES (1334, 117, 'remark', '备注', 'varchar(200)', 'String', 'remark', '0', '0', NULL, '1', '1', '1', NULL, 'EQ', 'input', '', 5, 'admin', '2023-11-17 11:07:42', '', '2023-11-20 23:15:29');
INSERT INTO `gen_table_column` VALUES (1335, 117, 'budget_amount', '预算金额', 'decimal(10,0)', 'Long', 'budgetAmount', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 6, 'admin', '2023-11-17 11:07:42', '', '2023-11-20 23:15:29');
INSERT INTO `gen_table_column` VALUES (1336, 117, 'order_count', '已生成订单数量', 'decimal(10,0)', 'Long', 'orderCount', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 7, 'admin', '2023-11-17 11:07:42', '', '2023-11-20 23:15:29');
INSERT INTO `gen_table_column` VALUES (1337, 117, 'warehousing_count', '入库数量', 'decimal(10,0)', 'Long', 'warehousingCount', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 8, 'admin', '2023-11-17 11:07:42', '', '2023-11-20 23:15:29');
INSERT INTO `gen_table_column` VALUES (1338, 118, 'download_logs_id', '主键', 'int(11)', 'Long', 'downloadLogsId', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2023-11-17 11:07:43', '', '2023-11-21 01:36:53');
INSERT INTO `gen_table_column` VALUES (1339, 118, 'notice_text_id', '公告正文主键', 'int(11)', 'Long', 'noticeTextId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 2, 'admin', '2023-11-17 11:07:43', '', '2023-11-21 01:36:53');
INSERT INTO `gen_table_column` VALUES (1340, 118, 'tender_name', '投标人名称', 'varchar(64)', 'String', 'tenderName', '0', '0', NULL, '1', '1', '1', '1', 'LIKE', 'input', '', 3, 'admin', '2023-11-17 11:07:43', '', '2023-11-21 01:36:53');
INSERT INTO `gen_table_column` VALUES (1341, 118, 'contact', '联系人', 'varchar(100)', 'String', 'contact', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2023-11-17 11:07:43', '', '2023-11-21 01:36:53');
INSERT INTO `gen_table_column` VALUES (1342, 118, 'phone', '移动电话', 'char(11)', 'String', 'phone', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 5, 'admin', '2023-11-17 11:07:43', '', '2023-11-21 01:36:53');
INSERT INTO `gen_table_column` VALUES (1343, 118, 'email', '邮箱', 'varchar(200)', 'String', 'email', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 6, 'admin', '2023-11-17 11:07:43', '', '2023-11-21 01:36:53');
INSERT INTO `gen_table_column` VALUES (1344, 118, 'download_time', '下载时间', 'datetime', 'Date', 'downloadTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 7, 'admin', '2023-11-17 11:07:43', '', '2023-11-21 01:36:53');
INSERT INTO `gen_table_column` VALUES (1345, 118, 'is_delete', '删除', 'int(11)', 'Long', 'isDelete', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 8, 'admin', '2023-11-17 11:07:43', '', '2023-11-21 01:36:53');
INSERT INTO `gen_table_column` VALUES (1346, 119, 'order_id', '订单号', 'int(11)', 'Long', 'orderId', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2023-11-17 11:07:44', '', '2023-12-20 10:45:59');
INSERT INTO `gen_table_column` VALUES (1347, 119, 'require_id', '需求表id', 'int(11)', 'Long', 'requireId', '0', '0', NULL, '0', '0', '0', '0', 'EQ', 'input', '', 2, 'admin', '2023-11-17 11:07:44', '', '2023-12-20 10:45:59');
INSERT INTO `gen_table_column` VALUES (1348, 119, 'buy_plan_id', '采购计划主键', 'int(11)', 'Long', 'buyPlanId', '0', '0', NULL, '0', '0', '0', '0', 'EQ', 'input', '', 3, 'admin', '2023-11-17 11:07:44', '', '2023-12-20 10:45:59');
INSERT INTO `gen_table_column` VALUES (1349, 119, 'order_title', '订单标题', 'varchar(180)', 'String', 'orderTitle', '0', '0', NULL, '1', '1', '1', '1', 'LIKE', 'input', '', 4, 'admin', '2023-11-17 11:07:44', '', '2023-12-20 10:46:00');
INSERT INTO `gen_table_column` VALUES (1350, 119, 'order_source', '订单来源', 'int(11)', 'Long', 'orderSource', '0', '0', NULL, '0', '0', '0', '0', 'EQ', 'input', '', 5, 'admin', '2023-11-17 11:07:44', '', '2023-12-20 10:46:00');
INSERT INTO `gen_table_column` VALUES (1351, 119, 'order_number', '订单编号', 'varchar(20)', 'String', 'orderNumber', '0', '0', NULL, '1', '0', '1', '1', 'LIKE', 'input', '', 6, 'admin', '2023-11-17 11:07:44', '', '2023-12-20 10:46:00');
INSERT INTO `gen_table_column` VALUES (1352, 119, 'order_purchaser', '采购人', 'varchar(15)', 'String', 'orderPurchaser', '0', '0', NULL, '1', '1', '1', '0', 'EQ', 'input', '', 7, 'admin', '2023-11-17 11:07:44', '', '2023-12-20 10:46:00');
INSERT INTO `gen_table_column` VALUES (1353, 119, 'total_money', '总金额', 'decimal(10,0)', 'Long', 'totalMoney', '0', '0', NULL, '1', '1', '1', '0', 'EQ', 'input', '', 8, 'admin', '2023-11-17 11:07:44', '', '2023-12-20 10:46:00');
INSERT INTO `gen_table_column` VALUES (1354, 119, 'is_zt', '0:自提,1:配送', 'int(11)', 'Long', 'isZt', '0', '0', NULL, '0', '0', '0', '0', 'EQ', 'input', '', 9, 'admin', '2023-11-17 11:07:45', '', '2023-12-20 10:46:00');
INSERT INTO `gen_table_column` VALUES (1355, 119, 'car_number', '自提车牌号', 'varchar(20)', 'String', 'carNumber', '0', '0', NULL, '0', '0', '0', '0', 'EQ', 'input', '', 10, 'admin', '2023-11-17 11:07:45', '', '2023-12-20 10:46:00');
INSERT INTO `gen_table_column` VALUES (1356, 119, 'driver_phone', '司机联系方式', 'varchar(11)', 'String', 'driverPhone', '0', '0', NULL, '0', '0', '0', '0', 'EQ', 'input', '', 11, 'admin', '2023-11-17 11:07:45', '', '2023-12-20 10:46:01');
INSERT INTO `gen_table_column` VALUES (1357, 119, '合同ID', '合同id', 'int(11)', 'Long', '合同ID', '0', '0', NULL, '0', '0', '0', '0', 'EQ', 'input', '', 12, 'admin', '2023-11-17 11:07:45', '', '2023-12-20 10:46:01');
INSERT INTO `gen_table_column` VALUES (1358, 119, 'order_context', '订单说明', 'varchar(100)', 'String', 'orderContext', '0', '0', NULL, '1', '1', '1', '0', 'EQ', 'input', '', 13, 'admin', '2023-11-17 11:07:45', '', '2023-12-20 10:46:01');
INSERT INTO `gen_table_column` VALUES (1359, 119, 'contractdetails_amount', '合同总金额', 'decimal(10,0)', 'Long', 'contractdetailsAmount', '0', '0', NULL, '0', '0', '0', '0', 'EQ', 'input', '', 14, 'admin', '2023-11-17 11:07:45', '', '2023-12-20 10:46:01');
INSERT INTO `gen_table_column` VALUES (1360, 119, 'order_supplier_id', '供应商', 'int(11)', 'Long', 'orderSupplierId', '0', '0', NULL, '1', '1', '0', '0', 'EQ', 'input', '', 15, 'admin', '2023-11-17 11:07:45', '', '2023-12-20 10:46:01');
INSERT INTO `gen_table_column` VALUES (1361, 119, 'order_material_id', '订单物料信息', 'int(11)', 'Long', 'orderMaterialId', '0', '0', NULL, '1', '1', '0', '0', 'EQ', 'input', '', 16, 'admin', '2023-11-17 11:07:46', '', '2023-12-20 10:46:01');
INSERT INTO `gen_table_column` VALUES (1362, 119, 'type_order_state', '订单状态', 'int(11)', 'Long', 'typeOrderState', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'select', 'vendor_order_state', 17, 'admin', '2023-11-17 11:07:46', '', '2023-12-20 10:46:01');
INSERT INTO `gen_table_column` VALUES (1363, 119, 'create_by', '创建人', 'varchar(100)', 'String', 'createBy', '0', '0', NULL, '1', NULL, '1', NULL, 'EQ', 'input', '', 18, 'admin', '2023-11-17 11:07:46', '', '2023-12-20 10:46:02');
INSERT INTO `gen_table_column` VALUES (1364, 119, 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'datetime', '', 19, 'admin', '2023-11-17 11:07:46', '', '2023-12-20 10:46:02');
INSERT INTO `gen_table_column` VALUES (1365, 119, 'update_by', '修改人', 'varchar(100)', 'String', 'updateBy', '0', '0', NULL, '1', '1', NULL, NULL, 'EQ', 'input', '', 20, 'admin', '2023-11-17 11:07:46', '', '2023-12-20 10:46:02');
INSERT INTO `gen_table_column` VALUES (1366, 119, 'update_time', '修改时间', 'datetime', 'Date', 'updateTime', '0', '0', NULL, '1', '1', NULL, NULL, 'EQ', 'datetime', '', 21, 'admin', '2023-11-17 11:07:46', '', '2023-12-20 10:46:02');
INSERT INTO `gen_table_column` VALUES (1367, 119, 'is_delete', '删除', 'int(11)', 'Long', 'isDelete', '0', '0', NULL, '1', '1', '0', '0', 'EQ', 'input', '', 22, 'admin', '2023-11-17 11:07:46', '', '2023-12-20 10:46:02');
INSERT INTO `gen_table_column` VALUES (1368, 120, 'require_id', '需求表id', 'int(11)', 'Long', 'requireId', '1', '1', NULL, '1', NULL, '0', NULL, 'EQ', 'input', '', 1, 'admin', '2023-11-17 11:07:47', '', '2023-11-22 14:25:37');
INSERT INTO `gen_table_column` VALUES (1369, 120, 'require_demand_id', '需求物料id（外键）', 'int(11)', 'Long', 'requireDemandId', '0', '0', '1', '1', '1', '1', '0', 'EQ', 'input', '', 2, 'admin', '2023-11-17 11:07:47', '', '2023-11-22 14:25:37');
INSERT INTO `gen_table_column` VALUES (1370, 120, 'require_number', '需求编号', 'varchar(20)', 'String', 'requireNumber', '0', '0', '1', '1', '1', '1', '0', 'EQ', 'input', '', 3, 'admin', '2023-11-17 11:07:47', '', '2023-11-22 14:25:37');
INSERT INTO `gen_table_column` VALUES (1371, 120, 'require_person', '需求人', 'varchar(20)', 'String', 'requirePerson', '0', '0', '1', '1', '1', '1', '0', 'EQ', 'input', '', 4, 'admin', '2023-11-17 11:07:47', '', '2023-11-22 14:25:37');
INSERT INTO `gen_table_column` VALUES (1372, 120, 'require_dept', '需求部门', 'varchar(20)', 'String', 'requireDept', '0', '0', '1', '1', '1', '1', '0', 'EQ', 'input', '', 5, 'admin', '2023-11-17 11:07:47', '', '2023-11-22 14:25:37');
INSERT INTO `gen_table_column` VALUES (1373, 120, 'require_type', '需求类型（字典外键）', 'int(11)', 'Long', 'requireType', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'select', 'require_type', 6, 'admin', '2023-11-17 11:07:47', '', '2023-11-22 14:25:38');
INSERT INTO `gen_table_column` VALUES (1374, 120, 'total_money', '总金额', 'decimal(10,0)', 'Long', 'totalMoney', '0', '0', '1', '1', '1', '1', '0', 'EQ', 'input', '', 7, 'admin', '2023-11-17 11:07:47', '', '2023-11-22 14:25:38');
INSERT INTO `gen_table_column` VALUES (1375, 120, 'require_contact', '收货联系人', 'varchar(20)', 'String', 'requireContact', '0', '0', '1', '1', '1', '0', '0', 'EQ', 'input', '', 8, 'admin', '2023-11-17 11:07:47', '', '2023-11-22 14:25:38');
INSERT INTO `gen_table_column` VALUES (1376, 120, 'main_purpose', '主要用途及说明', 'varchar(100)', 'String', 'mainPurpose', '0', '0', NULL, '1', '1', '0', '0', 'EQ', 'input', '', 9, 'admin', '2023-11-17 11:07:48', '', '2023-11-22 14:25:38');
INSERT INTO `gen_table_column` VALUES (1377, 120, 'require_address', '地址', 'varchar(30)', 'String', 'requireAddress', '0', '0', NULL, '1', '1', '0', '0', 'EQ', 'input', '', 10, 'admin', '2023-11-17 11:07:48', '', '2023-11-22 14:25:38');
INSERT INTO `gen_table_column` VALUES (1378, 120, 'require_phone', '手机号码', 'varchar(11)', 'String', 'requirePhone', '0', '0', NULL, '1', '1', '0', '0', 'EQ', 'input', '', 11, 'admin', '2023-11-17 11:07:48', '', '2023-11-22 14:25:38');
INSERT INTO `gen_table_column` VALUES (1379, 120, 'require_state', '状态', 'int(11)', 'Long', 'requireState', '0', '0', '1', '1', '1', '1', '0', 'EQ', 'select', 'require_state', 12, 'admin', '2023-11-17 11:07:48', '', '2023-11-22 14:25:39');
INSERT INTO `gen_table_column` VALUES (1380, 120, 'create_by', '创建人', 'varchar(100)', 'String', 'createBy', '0', '0', NULL, '1', NULL, '0', NULL, 'EQ', 'input', '', 13, 'admin', '2023-11-17 11:07:48', '', '2023-11-22 14:25:39');
INSERT INTO `gen_table_column` VALUES (1381, 120, 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'datetime', '', 14, 'admin', '2023-11-17 11:07:48', '', '2023-11-22 14:25:39');
INSERT INTO `gen_table_column` VALUES (1382, 120, 'update_by', '修改人', 'varchar(100)', 'String', 'updateBy', '0', '0', NULL, '1', '1', NULL, NULL, 'EQ', 'input', '', 15, 'admin', '2023-11-17 11:07:48', '', '2023-11-22 14:25:39');
INSERT INTO `gen_table_column` VALUES (1383, 120, 'update_time', '修改时间', 'datetime', 'Date', 'updateTime', '0', '0', NULL, '1', '1', NULL, NULL, 'EQ', 'datetime', '', 16, 'admin', '2023-11-17 11:07:48', '', '2023-11-22 14:25:39');
INSERT INTO `gen_table_column` VALUES (1384, 120, 'is_delete', '删除', 'int(11)', 'Long', 'isDelete', '0', '0', NULL, '1', '1', '0', '0', 'EQ', 'input', '', 17, 'admin', '2023-11-17 11:07:49', '', '2023-11-22 14:25:39');
INSERT INTO `gen_table_column` VALUES (1385, 121, 'vendor_id', '供应商ID', 'int(11)', 'Long', 'vendorId', '1', '1', NULL, '0', NULL, '0', '0', 'EQ', 'input', '', 1, 'admin', '2023-11-20 15:15:02', '', '2023-11-22 14:29:16');
INSERT INTO `gen_table_column` VALUES (1386, 121, 'vendor_number', '供应商编号', 'varchar(8)', 'String', 'vendorNumber', '0', '0', NULL, '1', '0', '1', '1', 'LIKE', 'input', '', 2, 'admin', '2023-11-20 15:15:02', '', '2023-11-22 14:29:16');
INSERT INTO `gen_table_column` VALUES (1387, 121, 'abbreviated', '简称', 'varchar(100)', 'String', 'abbreviated', '0', '0', NULL, '1', '1', '1', '1', 'LIKE', 'input', '', 3, 'admin', '2023-11-20 15:15:02', '', '2023-11-22 14:29:16');
INSERT INTO `gen_table_column` VALUES (1388, 121, 'contract_type_type_id', '字典类型（外键）', 'int(11)', 'Long', 'contractTypeTypeId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'select', 'contract_type', 4, 'admin', '2023-11-20 15:15:02', '', '2023-11-22 14:29:16');
INSERT INTO `gen_table_column` VALUES (1389, 121, 'vendor_type_state_id', '状态（字典类型外键）', 'int(11)', 'Long', 'vendorTypeStateId', '0', '0', '0', '1', '1', '1', '1', 'EQ', 'select', 'vendor_state', 5, 'admin', '2023-11-20 15:15:02', '', '2023-11-22 14:29:16');
INSERT INTO `gen_table_column` VALUES (1390, 121, 'is_blacklist', '是否进黑名单', 'int(11)', 'Long', 'isBlacklist', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'radio', '', 6, 'admin', '2023-11-20 15:15:02', '', '2023-11-22 14:29:16');
INSERT INTO `gen_table_column` VALUES (1391, 121, 'range', '服务范围', 'varchar(100)', 'String', 'range', '0', '0', NULL, '1', '1', '1', '1', 'LIKE', 'input', '', 7, 'admin', '2023-11-20 15:15:02', '', '2023-11-22 14:29:16');
INSERT INTO `gen_table_column` VALUES (1392, 121, 'cause', '原因', 'varchar(255)', 'String', 'cause', '0', '0', NULL, '1', '1', '1', '0', 'EQ', 'input', '', 8, 'admin', '2023-11-20 15:15:02', '', '2023-11-22 14:29:16');
INSERT INTO `gen_table_column` VALUES (1393, 121, 'warehouse_address', '仓库地址', 'varchar(200)', 'String', 'warehouseAddress', '0', '0', NULL, '1', '1', '1', '0', 'EQ', 'input', '', 9, 'admin', '2023-11-20 15:15:03', '', '2023-11-22 14:29:17');
INSERT INTO `gen_table_column` VALUES (1394, 121, 'profile', '简介', 'varchar(200)', 'String', 'profile', '0', '0', NULL, '1', '1', '1', '0', 'EQ', 'input', '', 10, 'admin', '2023-11-20 15:15:03', '', '2023-11-22 14:29:17');
INSERT INTO `gen_table_column` VALUES (1395, 121, 'delegates', '法定代表人', 'varchar(100)', 'String', 'delegates', '0', '0', NULL, '1', '1', '1', '0', 'EQ', 'input', '', 11, 'admin', '2023-11-20 15:15:03', '', '2023-11-22 14:29:17');
INSERT INTO `gen_table_column` VALUES (1396, 121, 'add_time', '注册时间', 'datetime', 'Date', 'addTime', '0', '0', NULL, '1', '1', '1', '1', 'BETWEEN', 'datetime', '', 12, 'admin', '2023-11-20 15:15:03', '', '2023-11-22 14:29:17');
INSERT INTO `gen_table_column` VALUES (1397, 121, 'email', '邮箱', 'varchar(35)', 'String', 'email', '0', '0', NULL, '1', '1', '1', '0', 'EQ', 'input', '', 13, 'admin', '2023-11-20 15:15:03', '', '2023-11-22 14:29:17');
INSERT INTO `gen_table_column` VALUES (1398, 121, 'fax', '传真', 'varchar(90)', 'String', 'fax', '0', '0', NULL, '1', '1', '1', '0', 'EQ', 'input', '', 14, 'admin', '2023-11-20 15:15:03', '', '2023-11-22 14:29:17');
INSERT INTO `gen_table_column` VALUES (1399, 121, 'responsible', '负责人', 'varchar(20)', 'String', 'responsible', '0', '0', NULL, '1', '1', '1', '0', 'EQ', 'input', '', 15, 'admin', '2023-11-20 15:15:03', '', '2023-11-22 14:29:17');
INSERT INTO `gen_table_column` VALUES (1400, 121, 'responsible_phone', '负责人手机', 'varchar(11)', 'String', 'responsiblePhone', '0', '0', NULL, '1', '1', '1', '0', 'EQ', 'input', '', 16, 'admin', '2023-11-20 15:15:03', '', '2023-11-22 14:29:17');
INSERT INTO `gen_table_column` VALUES (1401, 121, 'industrial_commercial', '工商注册号', 'varchar(20)', 'String', 'industrialCommercial', '0', '0', NULL, '1', '1', '1', '1', 'LIKE', 'input', '', 17, 'admin', '2023-11-20 15:15:03', '', '2023-11-22 14:29:18');
INSERT INTO `gen_table_column` VALUES (1402, 121, 'create_by', '创建人', 'varchar(100)', 'String', 'createBy', '0', '0', NULL, '1', NULL, '1', NULL, 'EQ', 'input', '', 18, 'admin', '2023-11-20 15:15:03', '', '2023-11-22 14:29:18');
INSERT INTO `gen_table_column` VALUES (1403, 121, 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', NULL, '1', NULL, '1', NULL, 'EQ', 'datetime', '', 19, 'admin', '2023-11-20 15:15:04', '', '2023-11-22 14:29:18');
INSERT INTO `gen_table_column` VALUES (1404, 121, 'update_by', '修改人', 'varchar(100)', 'String', 'updateBy', '0', '0', NULL, '0', '1', '1', NULL, 'EQ', 'input', '', 20, 'admin', '2023-11-20 15:15:04', '', '2023-11-22 14:29:18');
INSERT INTO `gen_table_column` VALUES (1405, 121, 'update_time', '修改时间', 'datetime', 'Date', 'updateTime', '0', '0', NULL, '0', '1', '1', NULL, 'EQ', 'datetime', '', 21, 'admin', '2023-11-20 15:15:04', '', '2023-11-22 14:29:18');
INSERT INTO `gen_table_column` VALUES (1406, 121, 'is_exist', '供应商信息是否存在', 'int(11)', 'String', 'isExist', '0', '0', NULL, '1', '1', '1', '0', 'EQ', 'input', '', 22, 'admin', '2023-11-20 15:15:04', '', '2023-11-22 14:29:18');
INSERT INTO `gen_table_column` VALUES (1407, 121, 'is_delete', '删除', 'int(11)', 'String', 'isDelete', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'radio', '', 23, 'admin', '2023-11-20 15:15:04', '', '2023-11-22 14:29:18');
INSERT INTO `gen_table_column` VALUES (1408, 115, 'warehouse_name', '仓库名称', 'varchar(255)', 'String', 'warehouseName', '0', '0', NULL, '1', '1', '1', '1', 'LIKE', 'input', '', 4, '', '2023-11-21 14:26:32', '', '2023-11-21 14:27:11');
INSERT INTO `gen_table_column` VALUES (1409, 103, 'category_name', '类别名称', 'varchar(300)', 'String', 'categoryName', '0', '0', NULL, '1', '1', '1', '1', 'LIKE', 'input', '', 3, '', '2023-11-22 11:04:07', '', '2023-11-22 17:36:40');
INSERT INTO `gen_table_column` VALUES (1410, 122, 'code_rules_id', '编号规则主键', 'int(11)', 'Long', 'codeRulesId', '1', '1', NULL, '0', NULL, '1', NULL, 'EQ', 'input', '', 1, 'admin', '2023-11-22 23:23:20', '', '2023-11-22 23:54:05');
INSERT INTO `gen_table_column` VALUES (1411, 122, 'targets', '目标表单', 'varchar(255)', 'String', 'targets', '0', '0', NULL, '1', '1', '1', '1', 'LIKE', 'input', '', 2, 'admin', '2023-11-22 23:23:20', '', '2023-11-22 23:54:05');
INSERT INTO `gen_table_column` VALUES (1412, 122, 'prefixs', '编号前缀', 'varchar(30)', 'String', 'prefixs', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2023-11-22 23:23:20', '', '2023-11-22 23:54:05');
INSERT INTO `gen_table_column` VALUES (1413, 122, 'time_rules', '时间规则', 'varchar(200)', 'String', 'timeRules', '0', '0', NULL, '1', '1', '1', '1', 'BETWEEN', 'checkbox', '', 4, 'admin', '2023-11-22 23:23:20', '', '2023-11-22 23:54:05');
INSERT INTO `gen_table_column` VALUES (1414, 122, 'coding_rules', '编码规则(UUID/Snowflakes)', 'int(255)', 'Long', 'codingRules', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'radio', '', 5, 'admin', '2023-11-22 23:23:20', '', '2023-11-22 23:54:05');
INSERT INTO `gen_table_column` VALUES (1415, 122, 'lengths', '流水号/总长度', 'int(255)', 'Long', 'lengths', '0', '0', NULL, '1', '1', '1', '0', 'EQ', 'input', '', 6, 'admin', '2023-11-22 23:23:20', '', '2023-11-22 23:54:05');
INSERT INTO `gen_table_column` VALUES (1426, 105, 'contract_sector', '申请部门', 'varchar(30)', 'String', 'contractSector', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 4, '', '2023-11-29 09:30:44', '', '2023-12-05 17:59:23');
INSERT INTO `gen_table_column` VALUES (1427, 105, 'contract_project_related', '项目相关合同（1：不相关 2：相关）', 'int(11)', 'Long', 'contractProjectRelated', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 6, '', '2023-11-29 09:30:44', '', '2023-12-05 17:59:23');
INSERT INTO `gen_table_column` VALUES (1428, 105, 'contract_projects_id', '相关招标的编号', 'int(11)', 'Long', 'contractProjectsId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 7, '', '2023-11-29 09:30:44', '', '2023-12-05 17:59:23');
INSERT INTO `gen_table_column` VALUES (1429, 105, 'contract_master', '是否为主子合同（1：否 2：是）', 'int(11)', 'Long', 'contractMaster', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 8, '', '2023-11-29 09:30:44', '', '2023-12-05 17:59:24');
INSERT INTO `gen_table_column` VALUES (1430, 105, 'contract_prime_id', '关联主合同', 'int(11)', 'Long', 'contractPrimeId', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 9, '', '2023-11-29 09:30:44', '', '2023-12-05 17:59:24');
INSERT INTO `gen_table_column` VALUES (1431, 105, 'contract_total_budget', '项目总预算', 'decimal(10,2)', 'BigDecimal', 'contractTotalBudget', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 10, '', '2023-11-29 09:30:44', '', '2023-12-05 17:59:24');
INSERT INTO `gen_table_column` VALUES (1434, 106, 'contractdetails_number', '合同编号', 'int(11)', 'String', 'contractdetailsNumber', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 3, '', '2023-11-29 11:48:06', '', '2023-12-28 11:06:52');
INSERT INTO `gen_table_column` VALUES (1435, 106, 'contractdetails_type', '合同类型', 'int(11)', 'Long', 'contractdetailsType', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'select', '', 6, '', '2023-11-29 11:48:07', '', '2023-12-28 11:06:52');
INSERT INTO `gen_table_column` VALUES (1436, 106, 'contractdetails_level', '密级（0：密级 1：非密）', 'int(11)', 'Long', 'contractdetailsLevel', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 9, '', '2023-11-29 11:48:07', '', '2023-12-28 11:06:53');
INSERT INTO `gen_table_column` VALUES (1437, 106, 'vendor_contract_id', '供应商外键', 'int(11)', 'Long', 'vendorContractId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 12, '', '2023-11-29 11:48:07', '', '2023-12-28 11:06:53');
INSERT INTO `gen_table_column` VALUES (1438, 106, 'contractdetails_state', '合同状态（数据字典）', 'varchar(255)', 'Long', 'contractdetailsState', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 13, '', '2023-11-29 11:48:07', '', '2023-12-28 11:06:53');
INSERT INTO `gen_table_column` VALUES (1439, 106, 'contract_id', '合同申请id（外键）', 'int(11)', 'Long', 'contractId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 2, '', '2023-11-29 11:50:01', '', '2023-12-28 11:06:52');
INSERT INTO `gen_table_column` VALUES (1440, 100, 'tender_projects_number', '项目编号', 'varchar(100)', 'String', 'tenderProjectsNumber', '0', '0', NULL, '1', '1', '1', '0', 'EQ', 'input', '', 2, '', '2023-12-01 15:27:21', '', '2023-12-06 11:42:07');
INSERT INTO `gen_table_column` VALUES (1441, 123, 'signing_status_id', '签署状态ID', 'int(11)', 'Long', 'signingStatusId', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2023-12-04 11:55:14', '', NULL);
INSERT INTO `gen_table_column` VALUES (1442, 123, 'signing_contractdetails_id', '合同基本信息ID（外键）', 'int(11)', 'Long', 'signingContractdetailsId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 2, 'admin', '2023-12-04 11:55:15', '', NULL);
INSERT INTO `gen_table_column` VALUES (1443, 123, 'signatories_number', '签署方数（1：双方签署 2：三方签署）', 'int(11)', 'Long', 'signatoriesNumber', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2023-12-04 11:55:15', '', NULL);
INSERT INTO `gen_table_column` VALUES (1444, 123, 'signing_subject', '我方主体', 'varchar(20)', 'String', 'signingSubject', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2023-12-04 11:55:15', '', NULL);
INSERT INTO `gen_table_column` VALUES (1445, 123, 'signing_vendor_id', '乙方供应商ID（外键）', 'int(11)', 'Long', 'signingVendorId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 5, 'admin', '2023-12-04 11:55:15', '', NULL);
INSERT INTO `gen_table_column` VALUES (1446, 123, 'signing_address', '乙方供应商公司地址', 'varchar(255)', 'String', 'signingAddress', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 6, 'admin', '2023-12-04 11:55:15', '', NULL);
INSERT INTO `gen_table_column` VALUES (1447, 123, 'signing_contact', '乙方联系人', 'varchar(10)', 'String', 'signingContact', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 7, 'admin', '2023-12-04 11:55:15', '', NULL);
INSERT INTO `gen_table_column` VALUES (1448, 123, 'signing_contact_mode', '乙方联系方式', 'varchar(255)', 'String', 'signingContactMode', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 8, 'admin', '2023-12-04 11:55:15', '', NULL);
INSERT INTO `gen_table_column` VALUES (1449, 123, 'signing_bank', '乙户开户行', 'varchar(255)', 'String', 'signingBank', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 9, 'admin', '2023-12-04 11:55:16', '', NULL);
INSERT INTO `gen_table_column` VALUES (1450, 123, 'signing_bank_account', '开户账号', 'varchar(16)', 'String', 'signingBankAccount', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 10, 'admin', '2023-12-04 11:55:16', '', NULL);
INSERT INTO `gen_table_column` VALUES (1451, 123, 'siging_amount', '合同方金额', 'decimal(10,2)', 'BigDecimal', 'sigingAmount', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 11, 'admin', '2023-12-04 11:55:16', '', NULL);
INSERT INTO `gen_table_column` VALUES (1452, 123, 'currency', '币别', 'varchar(20)', 'String', 'currency', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 12, 'admin', '2023-12-04 11:55:16', '', NULL);
INSERT INTO `gen_table_column` VALUES (1465, 106, 'procurement_method', '采购方式（1：招标 2：采购计划）', 'int(11)', 'Long', 'procurementMethod', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 14, '', '2023-12-04 15:32:56', '', '2023-12-28 11:06:53');
INSERT INTO `gen_table_column` VALUES (1467, 106, 'purchase_list_id', '采购需求ID（外键）', 'int(11)', 'Long', 'purchaseListId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 15, '', '2023-12-04 15:32:57', '', '2023-12-28 11:06:54');
INSERT INTO `gen_table_column` VALUES (1468, 125, 'signing_status_id', '签署状态ID', 'int(11)', 'Long', 'signingStatusId', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2023-12-04 15:55:19', '', '2023-12-04 15:57:24');
INSERT INTO `gen_table_column` VALUES (1469, 125, 'signing_contractdetails_id', '合同基本信息ID（外键）', 'int(11)', 'Long', 'signingContractdetailsId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 2, 'admin', '2023-12-04 15:55:19', '', '2023-12-04 15:57:24');
INSERT INTO `gen_table_column` VALUES (1470, 125, 'signatories_number', '签署方数（1：双方签署 2：三方签署）', 'int(11)', 'Long', 'signatoriesNumber', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2023-12-04 15:55:20', '', '2023-12-04 15:57:24');
INSERT INTO `gen_table_column` VALUES (1471, 125, 'signing_subject', '我方主体', 'varchar(20)', 'String', 'signingSubject', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2023-12-04 15:55:20', '', '2023-12-04 15:57:24');
INSERT INTO `gen_table_column` VALUES (1472, 125, 'signing_vendor_id', '乙方供应商ID（外键）', 'int(11)', 'Long', 'signingVendorId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 5, 'admin', '2023-12-04 15:55:20', '', '2023-12-04 15:57:24');
INSERT INTO `gen_table_column` VALUES (1473, 125, 'signing_address', '乙方供应商公司地址', 'varchar(255)', 'String', 'signingAddress', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 6, 'admin', '2023-12-04 15:55:20', '', '2023-12-04 15:57:25');
INSERT INTO `gen_table_column` VALUES (1474, 125, 'signing_contact', '乙方联系人', 'varchar(10)', 'String', 'signingContact', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 7, 'admin', '2023-12-04 15:55:20', '', '2023-12-04 15:57:25');
INSERT INTO `gen_table_column` VALUES (1475, 125, 'signing_contact_mode', '乙方联系方式', 'varchar(255)', 'String', 'signingContactMode', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 8, 'admin', '2023-12-04 15:55:20', '', '2023-12-04 15:57:25');
INSERT INTO `gen_table_column` VALUES (1476, 125, 'signing_bank', '乙户开户行', 'varchar(255)', 'String', 'signingBank', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 9, 'admin', '2023-12-04 15:55:20', '', '2023-12-04 15:57:25');
INSERT INTO `gen_table_column` VALUES (1477, 125, 'signing_bank_account', '开户账号', 'varchar(16)', 'String', 'signingBankAccount', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 10, 'admin', '2023-12-04 15:55:20', '', '2023-12-04 15:57:25');
INSERT INTO `gen_table_column` VALUES (1478, 125, 'siging_amount', '合同方金额', 'decimal(10,2)', 'BigDecimal', 'sigingAmount', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 11, 'admin', '2023-12-04 15:55:21', '', '2023-12-04 15:57:25');
INSERT INTO `gen_table_column` VALUES (1479, 125, 'currency', '币别', 'varchar(20)', 'String', 'currency', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 12, 'admin', '2023-12-04 15:55:21', '', '2023-12-04 15:57:25');
INSERT INTO `gen_table_column` VALUES (1480, 105, 'contract_parent', '主合同', 'int(11)', 'Long', 'contractParent', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 11, '', '2023-12-05 17:59:24', '', NULL);
INSERT INTO `gen_table_column` VALUES (1481, 111, 'receipt_orders_id', '采购订单ID（外键）', 'int(11)', 'Long', 'receiptOrdersId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 12, '', '2023-12-13 11:04:03', '', '2023-12-13 15:03:35');
INSERT INTO `gen_table_column` VALUES (1482, 111, 'receipt_state', '状态', 'int(11)', 'Long', 'receiptState', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 11, '', '2023-12-13 15:03:35', '', NULL);
INSERT INTO `gen_table_column` VALUES (1483, 111, 'receipt_warehouse_id', '仓库ID（外键）', 'int(11)', 'Long', 'receiptWarehouseId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 13, '', '2023-12-13 15:03:35', '', NULL);
INSERT INTO `gen_table_column` VALUES (1484, 110, 'is_delete', '删除', 'int(11)', 'Long', 'isDelete', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 13, '', '2023-12-19 11:28:59', '', NULL);
INSERT INTO `gen_table_column` VALUES (1485, 107, 'pool_id', '专家库主键', 'int(100)', 'Long', 'poolId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 2, '', '2023-12-20 11:02:18', '', '2023-12-20 11:30:45');
INSERT INTO `gen_table_column` VALUES (1486, 93, 'must', '资格审查方式', 'int(10)', 'Integer', 'must', '0', '0', NULL, '1', '0', '1', '1', 'EQ', 'input', '', 5, '', '2023-12-20 11:30:39', '', '2023-12-20 11:34:50');
INSERT INTO `gen_table_column` VALUES (1487, 93, 'conditions', '抽取条件', 'varchar(255)', 'String', 'conditions', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 7, '', '2023-12-20 11:30:39', '', '2023-12-20 11:34:50');
INSERT INTO `gen_table_column` VALUES (1488, 93, 'evade_experts', '回避专家', 'varchar(255)', 'String', 'evadeExperts', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 8, '', '2023-12-20 11:30:40', '', '2023-12-20 11:34:50');
INSERT INTO `gen_table_column` VALUES (1489, 126, 'quotation_id', '标价单表id', 'int(11)', 'Long', 'quotationId', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2023-12-20 17:06:58', '', '2023-12-20 17:25:15');
INSERT INTO `gen_table_column` VALUES (1490, 126, 'quotation_number', '标价表编号', 'varchar(30)', 'String', 'quotationNumber', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 2, 'admin', '2023-12-20 17:06:58', '', '2023-12-20 17:25:15');
INSERT INTO `gen_table_column` VALUES (1491, 126, 'quotation_bid_id', '招标项目id', 'int(11)', 'Long', 'quotationBidId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2023-12-20 17:06:58', '', '2023-12-20 17:25:16');
INSERT INTO `gen_table_column` VALUES (1492, 126, 'quotation_title', '标价表标题', 'varchar(255)', 'String', 'quotationTitle', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2023-12-20 17:06:58', '', '2023-12-20 17:25:16');
INSERT INTO `gen_table_column` VALUES (1493, 126, 'quotation_demand_id', '报价单物料id', 'varchar(0)', 'String', 'quotationDemandId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 5, 'admin', '2023-12-20 17:06:58', '', '2023-12-20 17:25:16');
INSERT INTO `gen_table_column` VALUES (1494, 126, 'quotation_total_money', '报价总金额(物料总额计算)', 'decimal(30,0)', 'Long', 'quotationTotalMoney', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 6, 'admin', '2023-12-20 17:06:58', '', '2023-12-20 17:25:16');
INSERT INTO `gen_table_column` VALUES (1495, 126, 'quotation_remark', '备注', 'varchar(255)', 'String', 'quotationRemark', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 7, 'admin', '2023-12-20 17:06:58', '', '2023-12-20 17:25:16');
INSERT INTO `gen_table_column` VALUES (1496, 126, 'examine_state', '报价单审批状态', 'int(11)', 'Long', 'examineState', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 8, 'admin', '2023-12-20 17:06:58', '', '2023-12-20 17:25:16');
INSERT INTO `gen_table_column` VALUES (1497, 126, 'quotation_bid_state', '报价单中标状态', 'int(255)', 'Long', 'quotationBidState', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 9, 'admin', '2023-12-20 17:06:59', '', '2023-12-20 17:25:16');
INSERT INTO `gen_table_column` VALUES (1507, 126, 'quotation_annex_id', '标价单附件', 'int(11)', 'Long', 'quotationAnnexId', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 10, '', '2023-12-20 17:24:36', '', '2023-12-20 17:25:16');
INSERT INTO `gen_table_column` VALUES (1508, 128, 'extraction_conditions_id', '抽取专家表主键', 'int(100)', 'Long', 'extractionConditionsId', '1', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2023-12-21 17:02:38', '', '2023-12-21 17:08:14');
INSERT INTO `gen_table_column` VALUES (1509, 128, 'extraction_expert_id', '抽取表主键', 'int(100)', 'Long', 'extractionExpertId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 2, 'admin', '2023-12-21 17:02:38', '', '2023-12-21 17:08:14');
INSERT INTO `gen_table_column` VALUES (1510, 128, 'specialized', '评标专业', 'int(100)', 'Long', 'specialized', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2023-12-21 17:02:38', '', '2023-12-21 17:08:14');
INSERT INTO `gen_table_column` VALUES (1511, 128, 'number', '抽取人数', 'int(100)', 'Long', 'number', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2023-12-21 17:02:38', '', '2023-12-21 17:08:14');
INSERT INTO `gen_table_column` VALUES (1512, 128, 'creation_time', '创建时间', 'datetime', 'Date', 'creationTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 5, 'admin', '2023-12-21 17:02:38', '', '2023-12-21 17:08:14');
INSERT INTO `gen_table_column` VALUES (1513, 129, 'get_expert_extract_id', '专家被抽取表主键', 'int(100)', 'Long', 'getExpertExtractId', '1', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2023-12-21 17:02:39', '', '2023-12-21 17:08:24');
INSERT INTO `gen_table_column` VALUES (1514, 129, 'get_tender_id', '项目公告表主键', 'int(100)', 'Long', 'getTenderId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 2, 'admin', '2023-12-21 17:02:39', '', '2023-12-21 17:08:24');
INSERT INTO `gen_table_column` VALUES (1515, 129, 'get_expert_id', '抽取表主键', 'int(100)', 'Long', 'getExpertId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2023-12-21 17:02:39', '', '2023-12-21 17:08:24');
INSERT INTO `gen_table_column` VALUES (1516, 129, 'get_pool_id', '专家表主键', 'int(100)', 'Long', 'getPoolId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2023-12-21 17:02:39', '', '2023-12-21 17:08:25');
INSERT INTO `gen_table_column` VALUES (1517, 129, 'creation_time', '创建时间', 'datetime', 'Date', 'creationTime', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 5, 'admin', '2023-12-21 17:02:39', '', '2023-12-21 17:08:25');
INSERT INTO `gen_table_column` VALUES (1518, 97, 'tender_annex_id', '标书文件地址外键', 'varchar(100)', 'String', 'tenderAnnexId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 15, '', '2023-12-27 15:04:00', '', NULL);

-- ----------------------------
-- Table structure for public_agreement
-- ----------------------------
DROP TABLE IF EXISTS `public_agreement`;
CREATE TABLE `public_agreement`  (
  `contract_id` int(100) NOT NULL AUTO_INCREMENT COMMENT '合同ID',
  `applicant` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请人',
  `applicant_time` datetime(0) NULL DEFAULT NULL COMMENT '申请日期',
  `contract_sector` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请部门',
  `firm` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请公司',
  `contract_project_related` int(11) NULL DEFAULT NULL COMMENT '项目相关合同（1：不相关 2：相关）',
  `contract_projects_id` int(11) NULL DEFAULT NULL COMMENT '相关招标的编号',
  `contract_master` int(11) NULL DEFAULT NULL COMMENT '是否为主子合同（1：否 2：是）',
  `contract_prime_id` int(11) NULL DEFAULT NULL COMMENT '关联主合同',
  `contract_total_budget` decimal(10, 2) NULL DEFAULT NULL COMMENT '项目总预算',
  `contract_parent` int(11) NULL DEFAULT NULL COMMENT '主合同',
  `create_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`contract_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1022 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of public_agreement
-- ----------------------------
INSERT INTO `public_agreement` VALUES (1018, '张烨', '2024-01-03 04:40:41', '远志-产品技术部', '远志集团', 2, 4806, 1, NULL, 5000000.00, NULL, NULL, '2024-01-03 04:42:42', NULL, NULL);
INSERT INTO `public_agreement` VALUES (1019, '张桑', '2024-01-03 08:38:50', '远志-产品技术部', '远志集团', 2, 4804, 1, NULL, 200000.00, NULL, NULL, '2024-01-03 08:41:17', NULL, NULL);
INSERT INTO `public_agreement` VALUES (1020, 'xx', '2024-01-03 09:34:02', '远志-产品技术部', '远志集团', 2, 4804, 1, NULL, 200000.00, NULL, NULL, '2024-01-03 09:35:50', NULL, NULL);
INSERT INTO `public_agreement` VALUES (1021, '张飒', '2024-01-05 09:37:55', '远志-产品技术部', '远志集团', 2, 4804, 1, NULL, 200000.00, NULL, NULL, '2024-01-05 09:40:43', NULL, NULL);

-- ----------------------------
-- Table structure for public_annex
-- ----------------------------
DROP TABLE IF EXISTS `public_annex`;
CREATE TABLE `public_annex`  (
  `annex_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '附件id',
  `supply_id` int(11) NULL DEFAULT NULL COMMENT '主键编号',
  `annex_text` int(100) NULL DEFAULT NULL COMMENT '主键2级编号',
  `annex_type_id` int(11) NULL DEFAULT NULL COMMENT '附件类型',
  `annex_title` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '附件名称',
  `annex_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '附件url',
  `up_time` datetime(0) NULL DEFAULT NULL COMMENT '上传时间',
  PRIMARY KEY (`annex_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1010 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of public_annex
-- ----------------------------
INSERT INTO `public_annex` VALUES (900, 2444, 661, 0, '营业执照副本.docx', 'http://127.0.0.1:9300/statics/2024/01/02/营业执照副本_20240102212501A001.docx', '2024-01-02 21:35:05');
INSERT INTO `public_annex` VALUES (901, 2444, 662, 0, '经营许可证.docx', 'http://127.0.0.1:9300/statics/2024/01/02/经营许可证_20240102212506A002.docx', '2024-01-02 21:35:05');
INSERT INTO `public_annex` VALUES (902, 2444, 663, 0, '食品安全许可证.docx', 'http://127.0.0.1:9300/statics/2024/01/02/食品安全许可证_20240102212508A003.docx', '2024-01-02 21:35:05');
INSERT INTO `public_annex` VALUES (904, 2445, 664, 0, '营业执照副本.docx', 'http://127.0.0.1:9300/statics/2024/01/02/营业执照副本_20240102215420A004.docx', '2024-01-02 21:54:26');
INSERT INTO `public_annex` VALUES (905, 2445, 665, 0, '食品安全许可证.docx', 'http://127.0.0.1:9300/statics/2024/01/02/食品安全许可证_20240102215421A005.docx', '2024-01-02 21:54:26');
INSERT INTO `public_annex` VALUES (906, 2445, 666, 0, '医疗器械证.docx', 'http://127.0.0.1:9300/statics/2024/01/02/医疗器械证_20240102215422A006.docx', '2024-01-02 21:54:26');
INSERT INTO `public_annex` VALUES (907, 2445, 667, 0, '经营许可证.docx', 'http://127.0.0.1:9300/statics/2024/01/02/经营许可证_20240102215423A007.docx', '2024-01-02 21:54:26');
INSERT INTO `public_annex` VALUES (908, 2446, 668, 0, '经营许可证.docx', 'http://127.0.0.1:9300/statics/2024/01/02/经营许可证_20240102215828A008.docx', '2024-01-02 21:58:31');
INSERT INTO `public_annex` VALUES (909, 2446, 669, 0, '营业执照副本.docx', 'http://127.0.0.1:9300/statics/2024/01/02/营业执照副本_20240102215829A009.docx', '2024-01-02 21:58:32');
INSERT INTO `public_annex` VALUES (910, 2447, 670, 0, '专家签到表.xlsx', 'http://127.0.0.1:9300/statics/2024/01/02/专家签到表_20240102220208A010.xlsx', '2024-01-02 22:02:31');
INSERT INTO `public_annex` VALUES (911, 2451, 671, 0, '营业执照副本.docx', 'http://127.0.0.1:9300/statics/2024/01/02/营业执照副本_20240102220510A011.docx', '2024-01-02 22:06:05');
INSERT INTO `public_annex` VALUES (912, 2451, 672, 0, '经营许可证.docx', 'http://127.0.0.1:9300/statics/2024/01/02/经营许可证_20240102220511A012.docx', '2024-01-02 22:06:05');
INSERT INTO `public_annex` VALUES (913, 2452, 673, 0, '专家签到表.xlsx', 'http://127.0.0.1:9300/statics/2024/01/02/专家签到表_20240102220801A013.xlsx', '2024-01-02 22:08:14');
INSERT INTO `public_annex` VALUES (914, 2453, 674, 0, '专家签到表.xlsx', 'http://127.0.0.1:9300/statics/2024/01/02/专家签到表_20240102221246A014.xlsx', '2024-01-02 22:12:48');
INSERT INTO `public_annex` VALUES (915, 2454, 675, 0, '经营许可证.docx', 'http://127.0.0.1:9300/statics/2024/01/02/经营许可证_20240102221628A015.docx', '2024-01-02 22:16:38');
INSERT INTO `public_annex` VALUES (916, 2454, 676, 0, '营业执照副本.docx', 'http://127.0.0.1:9300/statics/2024/01/02/营业执照副本_20240102221633A016.docx', '2024-01-02 22:16:38');
INSERT INTO `public_annex` VALUES (917, 42, NULL, 5, '经营许可证.docx', 'http://127.0.0.1:9300/statics/2024/01/02/经营许可证_20240102212506A002.docx', '2024-01-02 22:16:38');
INSERT INTO `public_annex` VALUES (918, 43, NULL, 5, 'JSP08-JSTL、EL表达式.txt', 'http://127.0.0.1:9300/statics/2024/01/02/JSP08-JSTL、EL表达式_20240102222235A002.txt', '2024-01-02 00:00:00');
INSERT INTO `public_annex` VALUES (919, 2455, 677, 0, '营业执照副本.docx', 'http://127.0.0.1:9300/statics/2024/01/02/营业执照副本_20240102222414A017.docx', '2024-01-02 22:24:17');
INSERT INTO `public_annex` VALUES (920, 44, NULL, 5, 'JSP08-JSTL、EL表达式.txt', 'http://127.0.0.1:9300/statics/2024/01/02/JSP08-JSTL、EL表达式_20240102222412A003.txt', '2024-01-02 00:00:00');
INSERT INTO `public_annex` VALUES (921, 45, NULL, 5, 'JSP06-servlet基础.txt', 'http://127.0.0.1:9300/statics/2024/01/02/JSP06-servlet基础_20240102222533A004.txt', '2024-01-02 00:00:00');
INSERT INTO `public_annex` VALUES (922, 46, NULL, 5, '处理Cookiel乱码问题.txt', 'http://127.0.0.1:9300/statics/2024/01/02/处理Cookiel乱码问题_20240102222635A005.txt', '2024-01-02 00:00:00');
INSERT INTO `public_annex` VALUES (923, 2456, 678, 0, '营业执照副本.docx', 'http://127.0.0.1:9300/statics/2024/01/02/营业执照副本_20240102222645A018.docx', '2024-01-02 22:26:49');
INSERT INTO `public_annex` VALUES (924, 2456, 679, 0, '经营许可证.docx', 'http://127.0.0.1:9300/statics/2024/01/02/经营许可证_20240102222646A019.docx', '2024-01-02 22:26:49');
INSERT INTO `public_annex` VALUES (925, 47, NULL, 5, 'JSP06-servlet基础.txt', 'http://127.0.0.1:9300/statics/2024/01/02/JSP06-servlet基础_20240102222726A006.txt', '2024-01-02 00:00:00');
INSERT INTO `public_annex` VALUES (926, 48, NULL, 5, 'JSP10-ajax+json.txt', 'http://127.0.0.1:9300/statics/2024/01/02/JSP10-ajax+json_20240102222813A007.txt', '2024-01-02 00:00:00');
INSERT INTO `public_annex` VALUES (927, 1010, NULL, 2, '20240102160655.png', 'blob:http://localhost/2d237822-d365-4b28-9f57-9bff07a75dd9', '2024-01-02 23:21:23');
INSERT INTO `public_annex` VALUES (928, 4800, 720, 4, 'LG40寒假作业.docx', 'http://127.0.0.1:9300/statics/2024/01/03/LG40寒假作业_20240103013218A007.docx', '2024-01-03 01:32:22');
INSERT INTO `public_annex` VALUES (929, 4800, 720, 4, '安装步骤.docx', 'http://127.0.0.1:9300/statics/2024/01/03/安装步骤_20240103013218A008.docx', '2024-01-03 01:32:22');
INSERT INTO `public_annex` VALUES (930, 4800, 720, 4, '复习感受-张烨.docx', 'http://127.0.0.1:9300/statics/2024/01/03/复习感受-张烨_20240103013218A006.docx', '2024-01-03 01:32:22');
INSERT INTO `public_annex` VALUES (931, 4800, 720, 4, '考试答案.docx', 'http://127.0.0.1:9300/statics/2024/01/03/考试答案_20240103013218A009.docx', '2024-01-03 01:32:22');
INSERT INTO `public_annex` VALUES (932, 4800, 721, 4, '高级版数据库设计.xlsx', 'http://127.0.0.1:9300/statics/2024/01/03/餐饮管理系统高级版数据库设计_20240103013436A010.xlsx', '2024-01-03 01:34:39');
INSERT INTO `public_annex` VALUES (933, 4800, 721, 4, '体育健康报名表docx', 'http://127.0.0.1:9300/statics/2024/01/03/2_1_体育健康学院团学会干部竞选报名表_20240103013436A011.docx', '2024-01-03 01:34:39');
INSERT INTO `public_annex` VALUES (934, 4800, 721, 4, '科技创新先进个人-张烨.docx', 'http://127.0.0.1:9300/statics/2024/01/03/科技创新先进个人-张烨_20240103013436A012.docx', '2024-01-03 01:34:39');
INSERT INTO `public_annex` VALUES (935, 4800, 722, 4, '届团学会人员名单.docx', 'http://127.0.0.1:9300/statics/2024/01/03/2_2022届团学会人员名单_20240103013600A014.docx', '2024-01-03 01:36:02');
INSERT INTO `public_annex` VALUES (936, 4800, 722, 4, '届团学会人员名单.xlsx', 'http://127.0.0.1:9300/statics/2024/01/03/2_2022届团学会人员名单(5)(1)(2)_20240103013600A015.xlsx', '2024-01-03 01:36:02');
INSERT INTO `public_annex` VALUES (937, 4800, 722, 4, '复习感受-张烨.docx', 'http://127.0.0.1:9300/statics/2024/01/03/复习感受-张烨_20240103013600A013.docx', '2024-01-03 01:36:02');
INSERT INTO `public_annex` VALUES (938, 4800, 723, 4, '研发一部 张烨 部门经理竞选词.docx', 'http://127.0.0.1:9300/statics/2024/01/03/研发一部 张烨 部门经理竞选词_20240103013713A016.docx', '2024-01-03 01:37:28');
INSERT INTO `public_annex` VALUES (939, 4800, 723, 4, '研发一部花名册(卫生).xlsx', 'http://127.0.0.1:9300/statics/2024/01/03/研发一部花名册(卫生)_20240103013713A017.xlsx', '2024-01-03 01:37:28');
INSERT INTO `public_annex` VALUES (940, 4804, 724, 4, 'java-211班课表.xlsx', 'http://127.0.0.1:9300/statics/2024/01/03/java-211班课表_20240103014134A018.xlsx', '2024-01-03 01:41:36');
INSERT INTO `public_annex` VALUES (941, 4804, 724, 4, 'JavaOOP第二章.docx', 'http://127.0.0.1:9300/statics/2024/01/03/JavaOOP第二章_20240103014134A019.docx', '2024-01-03 01:41:36');
INSERT INTO `public_annex` VALUES (942, 4804, 724, 4, '张烨_演讲稿.docx', 'http://127.0.0.1:9300/statics/2024/01/03/张烨_演讲稿_20240103014134A020.docx', '2024-01-03 01:41:36');
INSERT INTO `public_annex` VALUES (943, 4804, 725, 4, 'JavaOOP第二章.docx', 'http://127.0.0.1:9300/statics/2024/01/03/JavaOOP第二章_20240103014254A023.docx', '2024-01-03 01:42:57');
INSERT INTO `public_annex` VALUES (944, 4804, 725, 4, 'JavaOOP第四章.docx', 'http://127.0.0.1:9300/statics/2024/01/03/JavaOOP第四章_20240103014254A021.docx', '2024-01-03 01:42:57');
INSERT INTO `public_annex` VALUES (945, 4804, 725, 4, 'JavaOOP第三章.docx', 'http://127.0.0.1:9300/statics/2024/01/03/JavaOOP第三章_20240103014254A022.docx', '2024-01-03 01:42:57');
INSERT INTO `public_annex` VALUES (946, 4804, 726, 4, 'LG40寒假作业.docx', 'http://127.0.0.1:9300/statics/2024/01/03/LG40寒假作业_20240103014357A024.docx', '2024-01-03 01:44:00');
INSERT INTO `public_annex` VALUES (947, 4804, 726, 4, '10、三层架构.docx', 'http://127.0.0.1:9300/statics/2024/01/03/10、三层架构_20240103014357A025.docx', '2024-01-03 01:44:00');
INSERT INTO `public_annex` VALUES (948, 4804, 726, 4, '安装步骤.docx', 'http://127.0.0.1:9300/statics/2024/01/03/安装步骤_20240103014357A026.docx', '2024-01-03 01:44:00');
INSERT INTO `public_annex` VALUES (949, 4805, 727, 4, '考试答案.docx', 'http://127.0.0.1:9300/statics/2024/01/03/考试答案_20240103014504A027.docx', '2024-01-03 01:45:06');
INSERT INTO `public_annex` VALUES (950, 4805, 728, 4, '高级版数据库设计.xlsx', 'http://127.0.0.1:9300/statics/2024/01/03/高级版数据库设计_20240103014600A028.xlsx', '2024-01-03 01:46:04');
INSERT INTO `public_annex` VALUES (951, 4805, 728, 4, '科技创新先进个人-张烨.docx', 'http://127.0.0.1:9300/statics/2024/01/03/科技创新先进个人-张烨_20240103014601A029.docx', '2024-01-03 01:46:04');
INSERT INTO `public_annex` VALUES (952, 4805, 729, 4, '参考答案2.docx', 'http://127.0.0.1:9300/statics/2024/01/03/参考答案2_20240103014716A030.docx', '2024-01-03 01:47:19');
INSERT INTO `public_annex` VALUES (953, 4805, 729, 4, '参考答案1.docx', 'http://127.0.0.1:9300/statics/2024/01/03/参考答案1_20240103014716A032.docx', '2024-01-03 01:47:19');
INSERT INTO `public_annex` VALUES (954, 4805, 729, 4, '参考答案3.docx', 'http://127.0.0.1:9300/statics/2024/01/03/参考答案3_20240103014716A031.docx', '2024-01-03 01:47:19');
INSERT INTO `public_annex` VALUES (955, 4805, 730, 4, 'SpringCloud版本说明.xlsx', 'http://127.0.0.1:9300/statics/2024/01/03/SpringCloud版本说明_20240103014855A033.xlsx', '2024-01-03 01:48:57');
INSERT INTO `public_annex` VALUES (956, 4806, 731, 4, '跨域.docx', 'http://127.0.0.1:9300/statics/2024/01/03/跨域_20240103015002A034.docx', '2024-01-03 01:50:06');
INSERT INTO `public_annex` VALUES (957, 4806, 731, 4, '2021年10月BCSP-S3机试试卷.doc', 'http://127.0.0.1:9300/statics/2024/01/03/2021年10月BCSP-S3机试试卷_20240103015002A035.doc', '2024-01-03 01:50:06');
INSERT INTO `public_annex` VALUES (958, 4806, 732, 4, '1-Oralce入门上机.doc', 'http://127.0.0.1:9300/statics/2024/01/03/1-Oralce入门上机_20240103015135A036.doc', '2024-01-03 01:51:38');
INSERT INTO `public_annex` VALUES (959, 4806, 732, 4, '2-Oralce数据管理上机.doc', 'http://127.0.0.1:9300/statics/2024/01/03/2-Oralce数据管理上机_20240103015135A037.doc', '2024-01-03 01:51:38');
INSERT INTO `public_annex` VALUES (960, 4806, 733, 4, '2021年8月BCSP-S3机试试卷.doc', 'http://127.0.0.1:9300/statics/2024/01/03/2021年8月BCSP-S3机试试卷_20240103015242A038.doc', '2024-01-03 01:53:01');
INSERT INTO `public_annex` VALUES (961, 4806, 733, 4, 'SpringBoot_IDEA热部署.docx', 'http://127.0.0.1:9300/statics/2024/01/03/SpringBoot_IDEA热部署_20240103015242A039.docx', '2024-01-03 01:53:01');
INSERT INTO `public_annex` VALUES (962, NULL, NULL, 14, '安装步骤.docx', 'http://127.0.0.1:9300/statics/2024/01/03/安装步骤_20240103030027A044.docx', '2024-01-03 03:02:33');
INSERT INTO `public_annex` VALUES (963, NULL, NULL, 14, '张烨_演讲稿.docx', 'http://127.0.0.1:9300/statics/2024/01/03/张烨_演讲稿_20240103030828A045.docx', '2024-01-03 03:08:30');
INSERT INTO `public_annex` VALUES (964, NULL, NULL, 14, '复习感受-张烨.docx', 'http://127.0.0.1:9300/statics/2024/01/03/复习感受-张烨_20240103030859A046.docx', '2024-01-03 03:09:02');
INSERT INTO `public_annex` VALUES (965, NULL, NULL, 14, 'JavaOOP第三章.docx', 'http://127.0.0.1:9300/statics/2024/01/03/JavaOOP第三章_20240103030954A047.docx', '2024-01-03 03:09:55');
INSERT INTO `public_annex` VALUES (966, NULL, NULL, 14, 'JavaOOP第二章.docx', 'http://127.0.0.1:9300/statics/2024/01/03/JavaOOP第二章_20240103031013A048.docx', '2024-01-03 03:10:15');
INSERT INTO `public_annex` VALUES (967, NULL, NULL, 14, '张烨_演讲稿.docx', 'http://127.0.0.1:9300/statics/2024/01/03/张烨_演讲稿_20240103031035A049.docx', '2024-01-03 03:10:37');
INSERT INTO `public_annex` VALUES (968, NULL, NULL, 14, '考试答案.docx', 'http://127.0.0.1:9300/statics/2024/01/03/考试答案_20240103031107A050.docx', '2024-01-03 03:11:15');
INSERT INTO `public_annex` VALUES (969, NULL, NULL, 14, 'JavaOOP第三章.docx', 'http://127.0.0.1:9300/statics/2024/01/03/JavaOOP第三章_20240103031154A051.docx', '2024-01-03 03:11:56');
INSERT INTO `public_annex` VALUES (970, NULL, NULL, 14, '张烨_演讲稿.docx', 'http://127.0.0.1:9300/statics/2024/01/03/张烨_演讲稿_20240103031215A052.docx', '2024-01-03 03:12:17');
INSERT INTO `public_annex` VALUES (971, NULL, NULL, 14, '张烨_演讲稿.docx', 'http://127.0.0.1:9300/statics/2024/01/03/张烨_演讲稿_20240103031244A053.docx', '2024-01-03 03:12:46');
INSERT INTO `public_annex` VALUES (972, NULL, NULL, 14, 'JavaOOP第四章.docx', 'http://127.0.0.1:9300/statics/2024/01/03/JavaOOP第四章_20240103031303A054.docx', '2024-01-03 03:13:05');
INSERT INTO `public_annex` VALUES (973, NULL, NULL, 14, '觅点外卖数据库.txt', 'http://127.0.0.1:9300/statics/2024/01/03/觅点外卖数据库_20240103031328A055.txt', '2024-01-03 03:13:30');
INSERT INTO `public_annex` VALUES (974, NULL, NULL, 14, '安装步骤.docx', 'http://127.0.0.1:9300/statics/2024/01/03/安装步骤_20240103031400A056.docx', '2024-01-03 03:14:02');
INSERT INTO `public_annex` VALUES (975, NULL, NULL, 14, '操作手册——翻墙软件.docx', 'http://127.0.0.1:9300/statics/2024/01/03/操作手册——翻墙软件_20240103031418A057.docx', '2024-01-03 03:14:20');
INSERT INTO `public_annex` VALUES (976, NULL, NULL, 14, '1_5_成绩单（助学金）.doc', 'http://127.0.0.1:9300/statics/2024/01/03/1_5_成绩单（助学金）_20240103031437A058.doc', '2024-01-03 03:14:39');
INSERT INTO `public_annex` VALUES (977, NULL, NULL, 14, '研发一部 张烨 部门经理竞选词.docx', 'http://127.0.0.1:9300/statics/2024/01/03/研发一部 张烨 部门经理竞选词_20240103031541A059.docx', '2024-01-03 03:15:43');
INSERT INTO `public_annex` VALUES (978, NULL, NULL, 14, '考试答案.docx', 'http://127.0.0.1:9300/statics/2024/01/03/考试答案_20240103031600A060.docx', '2024-01-03 03:16:02');
INSERT INTO `public_annex` VALUES (979, NULL, NULL, 14, '刘丽   12021054001033.docx', 'http://127.0.0.1:9300/statics/2024/01/03/刘丽   12021054001033_20240103031622A061.docx', '2024-01-03 03:16:24');
INSERT INTO `public_annex` VALUES (980, NULL, NULL, 14, 'JavaOOP第三章.docx', 'http://127.0.0.1:9300/statics/2024/01/03/JavaOOP第三章_20240103031640A062.docx', '2024-01-03 03:16:42');
INSERT INTO `public_annex` VALUES (981, NULL, NULL, 14, 'JavaOOP第三章.docx', 'http://127.0.0.1:9300/statics/2024/01/03/JavaOOP第三章_20240103031716A063.docx', '2024-01-03 03:17:18');
INSERT INTO `public_annex` VALUES (982, NULL, NULL, 14, '考试答案.docx', 'http://127.0.0.1:9300/statics/2024/01/03/考试答案_20240103031734A064.docx', '2024-01-03 03:17:36');
INSERT INTO `public_annex` VALUES (983, 4804, 4804, 9, 'java-211班课表.xlsx', 'http://127.0.0.1:9300/statics/2024/01/03/java-211班课表_20240103033043A075.xlsx', '2024-01-03 03:31:00');
INSERT INTO `public_annex` VALUES (984, 4804, 4804, 10, 'JavaOOP第二章.docx', 'http://127.0.0.1:9300/statics/2024/01/03/JavaOOP第二章_20240103033043A076.docx', '2024-01-03 03:31:00');
INSERT INTO `public_annex` VALUES (985, 4804, 4804, 11, '1_5_成绩单（助学金）.doc', 'http://127.0.0.1:9300/statics/2024/01/03/1_5_成绩单（助学金）_20240103033048A077.doc', '2024-01-03 03:31:00');
INSERT INTO `public_annex` VALUES (986, 4804, 4804, 12, '科技创新先进个人-张烨.docx', 'http://127.0.0.1:9300/statics/2024/01/03/科技创新先进个人-张烨_20240103033053A078.docx', '2024-01-03 03:31:00');
INSERT INTO `public_annex` VALUES (987, 4804, 4804, 13, '考试答案.docx', 'http://127.0.0.1:9300/statics/2024/01/03/考试答案_20240103033058A079.docx', '2024-01-03 03:31:01');
INSERT INTO `public_annex` VALUES (988, 4806, 4806, 9, 'JavaOOP第四章.docx', 'http://127.0.0.1:9300/statics/2024/01/03/JavaOOP第四章_20240103040038A080.docx', '2024-01-03 04:00:44');
INSERT INTO `public_annex` VALUES (989, 4806, 4806, 10, 'JavaOOP第三章.docx', 'http://127.0.0.1:9300/statics/2024/01/03/JavaOOP第三章_20240103040039A081.docx', '2024-01-03 04:00:44');
INSERT INTO `public_annex` VALUES (990, 4806, 4806, 11, 'JavaOOP第二章.docx', 'http://127.0.0.1:9300/statics/2024/01/03/JavaOOP第二章_20240103040039A082.docx', '2024-01-03 04:00:44');
INSERT INTO `public_annex` VALUES (991, 4806, 4806, 12, '张烨_演讲稿.docx', 'http://127.0.0.1:9300/statics/2024/01/03/张烨_演讲稿_20240103040040A083.docx', '2024-01-03 04:00:44');
INSERT INTO `public_annex` VALUES (992, 4806, 4806, 13, '安装步骤.docx', 'http://127.0.0.1:9300/statics/2024/01/03/安装步骤_20240103040041A084.docx', '2024-01-03 04:00:44');
INSERT INTO `public_annex` VALUES (993, 4805, 4805, 9, '操作手册——翻墙软件.docx', 'http://127.0.0.1:9300/statics/2024/01/03/操作手册——翻墙软件_20240103042112A085.docx', '2024-01-03 04:21:18');
INSERT INTO `public_annex` VALUES (994, 4805, 4805, 10, 'java-211班课表.xlsx', 'http://127.0.0.1:9300/statics/2024/01/03/java-211班课表_20240103042112A086.xlsx', '2024-01-03 04:21:18');
INSERT INTO `public_annex` VALUES (995, 4805, 4805, 11, '研发一部 张烨 部门经理竞选词.docx', 'http://127.0.0.1:9300/statics/2024/01/03/研发一部 张烨 部门经理竞选词_20240103042113A087.docx', '2024-01-03 04:21:18');
INSERT INTO `public_annex` VALUES (996, 4805, 4805, 12, '张烨_演讲稿.docx', 'http://127.0.0.1:9300/statics/2024/01/03/张烨_演讲稿_20240103042114A088.docx', '2024-01-03 04:21:18');
INSERT INTO `public_annex` VALUES (997, 4805, 4805, 13, '1_5_成绩单（助学金）.doc', 'http://127.0.0.1:9300/statics/2024/01/03/1_5_成绩单（助学金）_20240103042116A089.doc', '2024-01-03 04:21:18');
INSERT INTO `public_annex` VALUES (998, 1011, NULL, 2, '20240102160655.png', 'blob:http://localhost/60b97437-9d6f-4095-a9b0-61dfb45fc91d', '2024-01-03 04:42:43');
INSERT INTO `public_annex` VALUES (999, 1012, NULL, 2, '背景.jpeg', 'blob:http://localhost/f480bc9a-8e60-42b2-8e3d-1c032b5113b4', '2024-01-03 08:41:18');
INSERT INTO `public_annex` VALUES (1000, 4810, 734, 4, '营业执照副本.docx', 'http://127.0.0.1:9300/statics/2024/01/03/营业执照副本_20240103092338A004.docx', '2024-01-03 09:24:01');
INSERT INTO `public_annex` VALUES (1001, NULL, NULL, 14, '营业执照副本.docx', 'http://127.0.0.1:9300/statics/2024/01/03/营业执照副本_20240103092629A005.docx', '2024-01-03 09:26:32');
INSERT INTO `public_annex` VALUES (1002, NULL, NULL, 14, '营业执照副本.docx', 'http://127.0.0.1:9300/statics/2024/01/03/营业执照副本_20240103092705A006.docx', '2024-01-03 09:27:17');
INSERT INTO `public_annex` VALUES (1003, 4810, 4810, 9, '食品安全许可证.docx', 'http://127.0.0.1:9300/statics/2024/01/03/食品安全许可证_20240103093051A007.docx', '2024-01-03 09:30:58');
INSERT INTO `public_annex` VALUES (1004, 4810, 4810, 10, '医疗器械证.docx', 'http://127.0.0.1:9300/statics/2024/01/03/医疗器械证_20240103093052A008.docx', '2024-01-03 09:30:58');
INSERT INTO `public_annex` VALUES (1005, 4810, 4810, 11, '营业执照副本.docx', 'http://127.0.0.1:9300/statics/2024/01/03/营业执照副本_20240103093053A009.docx', '2024-01-03 09:30:58');
INSERT INTO `public_annex` VALUES (1006, 4810, 4810, 12, '食品安全许可证.docx', 'http://127.0.0.1:9300/statics/2024/01/03/食品安全许可证_20240103093054A010.docx', '2024-01-03 09:30:58');
INSERT INTO `public_annex` VALUES (1007, 4810, 4810, 13, '专家签到表.xlsx', 'http://127.0.0.1:9300/statics/2024/01/03/专家签到表_20240103093055A011.xlsx', '2024-01-03 09:30:58');
INSERT INTO `public_annex` VALUES (1008, 1013, NULL, 2, '20240102160655.png', 'blob:http://localhost/3c52649e-8e1a-4cbf-b13a-655a4572f9db', '2024-01-03 09:35:51');
INSERT INTO `public_annex` VALUES (1009, 1014, NULL, 2, 'IMG_20230619_011809.jpg', 'blob:http://localhost/3acd80c4-2ee7-44a2-8a18-bdfcc2348f57', '2024-01-05 09:40:44');

-- ----------------------------
-- Table structure for public_category
-- ----------------------------
DROP TABLE IF EXISTS `public_category`;
CREATE TABLE `public_category`  (
  `category_id` int(100) NOT NULL AUTO_INCREMENT COMMENT '类别ID',
  `category_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类别编码，用户自定义',
  `category_name` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类别名称',
  `parent_category` int(100) NULL DEFAULT NULL COMMENT '上级品类',
  `create_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `is_delete` int(11) NULL DEFAULT NULL COMMENT '删除',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1010 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of public_category
-- ----------------------------
INSERT INTO `public_category` VALUES (1001, 'WL1001', '医疗器材器械', NULL, 'fm', '2023-11-22 10:53:40', 'fm', '2023-11-22 17:17:43', 0);
INSERT INTO `public_category` VALUES (1002, 'WL1002', '医疗药品', NULL, 'fm', '2023-11-23 11:21:49', 'fm', '2023-11-23 11:22:07', 0);
INSERT INTO `public_category` VALUES (1003, 'WL1003', '基础外科手术器械', 1001, 'fm', '2023-11-22 11:44:58', 'fm', '2023-11-22 20:28:45', 0);
INSERT INTO `public_category` VALUES (1004, 'WL1004', '光学仪器', 1001, 'fm', '2023-11-22 11:47:54', 'fm', '2023-11-22 11:48:00', 0);
INSERT INTO `public_category` VALUES (1005, 'WL1005', '注射穿刺器械', 1001, 'fm', '2023-11-28 09:21:05', NULL, NULL, 0);
INSERT INTO `public_category` VALUES (1007, 'WL1006', '西药', 1002, 'fm', '2023-11-28 09:23:28', NULL, NULL, 0);
INSERT INTO `public_category` VALUES (1008, 'WL1007', '中药', 1002, 'fm', '2023-11-28 09:24:08', NULL, NULL, 0);
INSERT INTO `public_category` VALUES (1009, 'WL0112', '药剂', 1002, NULL, '2023-12-05 17:11:10', NULL, NULL, 0);

-- ----------------------------
-- Table structure for public_code_rules
-- ----------------------------
DROP TABLE IF EXISTS `public_code_rules`;
CREATE TABLE `public_code_rules`  (
  `code_rules_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号规则主键',
  `targets` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '目标表单',
  `prefixs` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编号前缀',
  `time_rules` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间规则',
  `coding_rules` int(255) NULL DEFAULT NULL COMMENT '编码规则(Time/Snowflakes)',
  `lengths` int(255) NULL DEFAULT NULL COMMENT '流水号/总长度',
  PRIMARY KEY (`code_rules_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of public_code_rules
-- ----------------------------
INSERT INTO `public_code_rules` VALUES (1, '供应商编号', 'GYS', 'x', 1, 12);
INSERT INTO `public_code_rules` VALUES (2, '物品编码', 'WP', 'YYYY,DD,ss,mm', 0, 4);
INSERT INTO `public_code_rules` VALUES (3, '采购订单编号', 'Orders', 'x,YYYY,MM,DD', 0, 4);
INSERT INTO `public_code_rules` VALUES (4, '供应商采购订单', 'CGDD', 'x,YYYY,MM,DD', 0, 5);
INSERT INTO `public_code_rules` VALUES (6, '合同订单编号', 'HTB', 'hh,ss', 0, 4);
INSERT INTO `public_code_rules` VALUES (7, '仓库编码', 'CK', 'x', 1, 7);
INSERT INTO `public_code_rules` VALUES (8, '采购需求编号', 'XQ', 'x,YYYY,MM,DD', 0, 5);
INSERT INTO `public_code_rules` VALUES (9, '物料分类编号', 'WL', 'x', 1, 6);
INSERT INTO `public_code_rules` VALUES (10, '采购合同编号', 'CGHT', 'YYYY,MM,DD,hh,mm,ss', 0, 0);
INSERT INTO `public_code_rules` VALUES (11, '采购计划编号', 'CGJH', 'x', 1, 10);
INSERT INTO `public_code_rules` VALUES (12, '招标项目编号', 'TQ', 'MM,DD,mm,ss', 0, 3);
INSERT INTO `public_code_rules` VALUES (13, '发货单编号', 'FH', 'YYYY,MM,DD,hh,mm,ss', 0, 0);
INSERT INTO `public_code_rules` VALUES (14, '抽取专家表', 'CQ-ZJ', 'MM,DD,hh,mm', 0, 3);
INSERT INTO `public_code_rules` VALUES (15, '中标公示', 'ZB-GS', 'x', 1, 14);

-- ----------------------------
-- Table structure for public_contacts
-- ----------------------------
DROP TABLE IF EXISTS `public_contacts`;
CREATE TABLE `public_contacts`  (
  `contacts_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '供应商联系人ID',
  `contacts_vendor_id` int(11) NULL DEFAULT NULL COMMENT '供应商ID',
  `calls` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '称呼',
  `job` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '岗位',
  `division` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '移动电话',
  `mailbox` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`contacts_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 312 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of public_contacts
-- ----------------------------
INSERT INTO `public_contacts` VALUES (300, 2444, '丁众', NULL, NULL, '13152301334', 'r1mXqNt8a@163.com');
INSERT INTO `public_contacts` VALUES (303, 2445, '阮闻焕', NULL, NULL, '15513818012', 'wdiawRwHpN@163.com');
INSERT INTO `public_contacts` VALUES (304, 2446, '赖汝', NULL, NULL, '18486689683', 'ORlko2@163.com');
INSERT INTO `public_contacts` VALUES (305, 2447, '惠妙蝶', NULL, NULL, '15015719347', 'vqm9bO@163.com');
INSERT INTO `public_contacts` VALUES (306, 2451, '杭赛飞', NULL, NULL, '17195913236', '8Lu3nyrB1ZX@163.com');
INSERT INTO `public_contacts` VALUES (307, 2452, '周蕙唯', NULL, NULL, '13298745633', 'WDrF6fC3f@163.com');
INSERT INTO `public_contacts` VALUES (308, 2453, '万寒恋', NULL, NULL, '13158915675', 'rrbJ5CiZti@163.com');
INSERT INTO `public_contacts` VALUES (309, 2454, '丁雪茜', NULL, NULL, '17604754379', 'QAUndvAeF@163.com');
INSERT INTO `public_contacts` VALUES (310, 2455, '符征莹', NULL, NULL, '18779151584', 'ELWNWK@163.com');
INSERT INTO `public_contacts` VALUES (311, 2456, '马桥剑', NULL, NULL, '18316445047', 'QtBbV@163.com');

-- ----------------------------
-- Table structure for public_contractdetails
-- ----------------------------
DROP TABLE IF EXISTS `public_contractdetails`;
CREATE TABLE `public_contractdetails`  (
  `contractdetails_id` int(200) NOT NULL AUTO_INCREMENT COMMENT '合同明细ID',
  `contract_id` int(11) NULL DEFAULT NULL COMMENT '合同申请id（外键）',
  `contractdetails_number` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '合同编号',
  `contractdetails_payment_id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外键合同付款ID',
  `contractdetails_name` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合同名称',
  `contractdetails_type` int(11) NULL DEFAULT NULL COMMENT '合同类型',
  `open_time` datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
  `contractdetails_amount` decimal(10, 0) NULL DEFAULT NULL COMMENT '合同总金额',
  `contractdetails_level` int(11) NULL DEFAULT NULL COMMENT '密级（0：密级 1：非密）',
  `illustrate` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '合同情况说明',
  `bid_end` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  `vendor_contract_id` int(11) NULL DEFAULT NULL COMMENT '供应商外键',
  `contractdetails_state` int(11) NULL DEFAULT NULL COMMENT '合同状态（数据字典）',
  `procurement_method` int(11) NULL DEFAULT NULL COMMENT '采购方式（1：招标 2：采购计划）',
  `purchase_list_id` int(11) NULL DEFAULT NULL COMMENT '采购需求ID（外键）',
  `create_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`contractdetails_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1015 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of public_contractdetails
-- ----------------------------
INSERT INTO `public_contractdetails` VALUES (1011, 1018, 'CGHT202401030442420', 'null', '甘肃地震支援招标合同', NULL, '2024-01-11 00:00:00', 4000, 0, '暂无', '2027-01-16 00:00:00', 2452, 6, 1, NULL, NULL, '2024-01-03 04:42:42', NULL, '2024-01-03 04:50:06');
INSERT INTO `public_contractdetails` VALUES (1012, 1019, 'CGHT202401030841170', '32', '药品招标长期合同', 0, '2024-01-04 00:00:00', 1270, 0, '无', '2024-01-05 00:00:00', 2445, 3, 1, NULL, NULL, '2024-01-03 08:41:17', NULL, NULL);
INSERT INTO `public_contractdetails` VALUES (1013, 1020, 'CGHT202401030935500', 'null', '采购', 0, '2024-01-04 00:00:00', 1270, 0, '无', '2024-01-05 00:00:00', 2445, 4, 1, NULL, NULL, '2024-01-03 09:35:51', NULL, '2024-01-03 09:36:10');
INSERT INTO `public_contractdetails` VALUES (1014, 1021, 'CGHT202401050940440', '33', '药品采购长期合同', 0, '2024-01-06 00:00:00', 1270, 0, '无', '2024-01-07 00:00:00', 2445, 3, 1, NULL, NULL, '2024-01-05 09:40:43', NULL, NULL);

-- ----------------------------
-- Table structure for public_expert
-- ----------------------------
DROP TABLE IF EXISTS `public_expert`;
CREATE TABLE `public_expert`  (
  `expert_id` int(100) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `pool_id` int(100) NULL DEFAULT NULL COMMENT '专家库主键',
  `name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专家姓名',
  `id_card` char(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专家身份证',
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区域',
  `phone` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '移动电话',
  `create_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `is_extract` int(2) NULL DEFAULT 0 COMMENT '是否被抽取',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除',
  PRIMARY KEY (`expert_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 530 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of public_expert
-- ----------------------------
INSERT INTO `public_expert` VALUES (511, 1, '翁知义', '436222719237284220', '长沙', '15127359261', NULL, '2023-12-20 14:38:48', NULL, NULL, 1, 0);
INSERT INTO `public_expert` VALUES (512, 1, '裴阳哲', '654615644981684168', '岳阳', '16584568185', NULL, '2023-11-30 19:48:11', NULL, NULL, 1, 0);
INSERT INTO `public_expert` VALUES (513, 1, '尹郁棋', '651687718160308949', '北京', '16876862586', NULL, '2023-12-05 14:48:17', NULL, NULL, 1, 0);
INSERT INTO `public_expert` VALUES (514, 1, '藍楠清', '286614984298496749', '上海', '19322684951', NULL, '2023-06-25 19:48:21', NULL, NULL, 1, 0);
INSERT INTO `public_expert` VALUES (515, 2, '文泊壬', '494981264416168168', '深圳', '18976062684', NULL, '2023-10-20 14:48:27', NULL, '2024-01-02 15:31:05', 0, 0);
INSERT INTO `public_expert` VALUES (516, 2, '彭欣怡', '498779416848489461', '湖北', '17798026584', NULL, '2023-08-04 14:48:31', NULL, '2024-01-02 15:30:58', 0, 0);
INSERT INTO `public_expert` VALUES (517, 2, '司馬瑞芳', '868498794165198491', '长沙', '16843208452', NULL, '2023-11-09 21:48:37', NULL, NULL, 0, 0);
INSERT INTO `public_expert` VALUES (518, 2, '江品勋', '168168765189156981', '湘潭', '16876068459', NULL, '2023-11-29 14:48:42', NULL, NULL, 1, 0);
INSERT INTO `public_expert` VALUES (519, 3, '柳敬勋', '749061980846497312', '新疆', '17945606543', NULL, '2023-11-29 08:48:46', NULL, NULL, 1, 0);
INSERT INTO `public_expert` VALUES (520, 3, '黎湘淳', '198462562987816298', '杭州', '13516808691', NULL, '2015-07-20 14:49:11', NULL, '2023-12-22 16:33:09', 1, 0);
INSERT INTO `public_expert` VALUES (521, 3, '裴佩雯', '681792489498898465', '重庆', '18268460686', NULL, '2023-06-23 20:49:04', NULL, NULL, 0, 0);
INSERT INTO `public_expert` VALUES (522, 4, '周少钧', '871498726879326549', '甘肃', '18652684662', NULL, '2024-11-08 14:49:21', NULL, NULL, 1, 0);
INSERT INTO `public_expert` VALUES (523, 4, '伍丞洋', '136498726598795929', '岳阳', '16846298084', NULL, '2023-03-11 14:49:00', NULL, NULL, 1, 0);
INSERT INTO `public_expert` VALUES (524, 4, '向浚瑞', '987661650087963215', '北京', '18168406806', NULL, '2024-08-15 14:49:25', NULL, NULL, 0, 0);
INSERT INTO `public_expert` VALUES (525, 5, '阮沛洁', '148492059684926108', '芜湖', '12564805606', NULL, '2023-07-13 14:49:07', NULL, NULL, 1, 0);
INSERT INTO `public_expert` VALUES (526, 5, '阮千莹', '549498270899280956', '茂名', '16855498098', NULL, '2005-12-09 14:49:17', NULL, NULL, 0, 0);
INSERT INTO `public_expert` VALUES (527, 5, '田靖雅', '268798492879386419', '潮汕', '15489090997', NULL, '2023-11-02 14:48:56', NULL, NULL, 0, 0);
INSERT INTO `public_expert` VALUES (528, 5, '凌子榆', '168794276609879353', '澳门', '18647068640', NULL, '2023-07-13 14:48:52', NULL, NULL, 0, 0);

-- ----------------------------
-- Table structure for public_expert_pool
-- ----------------------------
DROP TABLE IF EXISTS `public_expert_pool`;
CREATE TABLE `public_expert_pool`  (
  `expert_pool_id` int(100) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `expert_pool_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '库名',
  `level` int(11) NULL DEFAULT NULL COMMENT '级别',
  `category` int(11) NULL DEFAULT NULL COMMENT '类别',
  `create_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除',
  PRIMARY KEY (`expert_pool_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of public_expert_pool
-- ----------------------------
INSERT INTO `public_expert_pool` VALUES (1, '初级医疗药品专家库', 0, 1, NULL, '2023-12-20 14:15:07', NULL, NULL, 0);
INSERT INTO `public_expert_pool` VALUES (2, '医疗器械专家库', 1, 2, NULL, '2023-12-20 14:16:43', NULL, NULL, 0);
INSERT INTO `public_expert_pool` VALUES (3, '工商管理专家库', 2, 5, NULL, '2023-12-20 14:17:02', NULL, NULL, 0);
INSERT INTO `public_expert_pool` VALUES (4, '项目竞价专家库', 1, 6, NULL, '2023-12-20 14:17:16', NULL, NULL, 0);
INSERT INTO `public_expert_pool` VALUES (5, '金属材料专家库', 2, 4, NULL, '2023-12-20 14:17:37', NULL, NULL, 0);

-- ----------------------------
-- Table structure for public_goods
-- ----------------------------
DROP TABLE IF EXISTS `public_goods`;
CREATE TABLE `public_goods`  (
  `goods_id` int(100) NOT NULL AUTO_INCREMENT COMMENT '物料ID',
  `category_id` int(100) NULL DEFAULT NULL COMMENT '类别ID',
  `goods_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '物料编码',
  `goods_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `goods_type` int(11) NULL DEFAULT NULL COMMENT '字典外键',
  `specs` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规格',
  `model` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '型号',
  `brand` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌',
  `weight` decimal(10, 0) NULL DEFAULT NULL COMMENT '重量单位',
  `goods_number` int(11) NULL DEFAULT NULL COMMENT '商品数量',
  `volume` decimal(10, 0) NULL DEFAULT NULL COMMENT '体积单位',
  `buyer` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT ' 默认,远志集团有限公司',
  `state` int(11) NULL DEFAULT 0 COMMENT '状态',
  `create_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2002 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of public_goods
-- ----------------------------
INSERT INTO `public_goods` VALUES (9, 1004, 'WP202304341400002', '内窥镜', 1, '1', '1', '中华', 1, 20, 100, '远志集团有限公司', 0, NULL, '2023-12-04 11:34:15', NULL, '2023-12-07 17:54:51');
INSERT INTO `public_goods` VALUES (10, 1007, 'WP202304373900002', '999感冒灵', 2, '1', '1', '999', 1, 200, 1, '远志集团有限公司', 0, NULL, '2023-12-04 11:37:39', NULL, '2023-12-07 17:52:40');
INSERT INTO `public_goods` VALUES (11, 1007, 'WP202304401400002', '阿莫西林', 3, NULL, '羟氨苄青霉素', '联邦', NULL, 50, NULL, '远志集团有限公司', 0, NULL, '2023-12-04 17:40:15', NULL, NULL);
INSERT INTO `public_goods` VALUES (12, 1003, 'WP202304421500002', '手术刀', 1, NULL, 'x-0003', 'GE医疗', NULL, 10, NULL, '远志集团有限公司', 0, NULL, '2023-12-04 17:42:16', NULL, NULL);
INSERT INTO `public_goods` VALUES (13, 1008, 'WP202307441900002', '远志', 10, NULL, NULL, NULL, 10, 300, NULL, '远志集团有限公司', 0, NULL, '2023-12-07 17:44:20', NULL, NULL);
INSERT INTO `public_goods` VALUES (14, 1008, 'WP202307460400002', '长卿', 2, NULL, NULL, NULL, NULL, 20, NULL, '远志集团有限公司', 0, NULL, '2023-12-07 17:46:05', NULL, '2023-12-07 17:46:23');
INSERT INTO `public_goods` VALUES (15, 1004, 'WP202307475200002', 'CT机', 3, NULL, NULL, '西门子医疗', 100, 20, NULL, '远志集团有限公司', 0, NULL, '2023-12-07 17:47:52', NULL, NULL);
INSERT INTO `public_goods` VALUES (16, 1003, 'WP202307494200002', '止血钳', 1, NULL, NULL, '新华医疗', NULL, 40, NULL, '远志集团有限公司', 0, NULL, '2023-12-07 17:49:42', NULL, NULL);
INSERT INTO `public_goods` VALUES (17, 1009, 'WP202307513400002', '注射剂', 3, NULL, '001', '司药', NULL, 200, NULL, '远志集团有限公司', 0, NULL, '2023-12-07 17:51:34', NULL, NULL);
INSERT INTO `public_goods` VALUES (18, 1009, 'WP202307520200002', '麻醉剂', 2, NULL, NULL, '中华', NULL, 1000, NULL, '远志集团有限公司', 0, NULL, '2023-12-07 17:52:02', NULL, NULL);
INSERT INTO `public_goods` VALUES (19, 1008, 'WP202314240100002', '决明子', 5, NULL, NULL, '野生', 2, 9000, 1, '远志集团有限公司', 0, NULL, '2023-12-14 17:24:02', NULL, NULL);
INSERT INTO `public_goods` VALUES (20, 1008, 'WP202314253500002', '甘草', 5, NULL, NULL, '老中药', 2, 1, 3, '远志集团有限公司', 0, NULL, '2023-12-14 17:25:35', NULL, NULL);
INSERT INTO `public_goods` VALUES (21, 1009, 'WP202314355100002', '青霉素', 7, NULL, NULL, '华源青霉素', 2, 2, 1, '远志集团', 0, NULL, '2023-12-14 17:37:21', NULL, NULL);
INSERT INTO `public_goods` VALUES (22, 1009, 'WP202314382700002', '镇定剂', 8, NULL, NULL, '华源青霉素', 2, 2, 1, '远志集团', 0, NULL, '2023-12-14 17:39:48', NULL, NULL);
INSERT INTO `public_goods` VALUES (23, 1008, 'WP202314050200001', '肾上腺素', 9, NULL, NULL, '安康肾上腺素', 1, 2, 1, '远志集团有限公司', 0, NULL, '2023-12-14 18:05:19', NULL, NULL);
INSERT INTO `public_goods` VALUES (24, 1007, 'WP202314055200001', '肾上腺素2.0', 10, NULL, NULL, '安康肾上腺素', 1, 2, 1, '远志集团有限公司', 0, NULL, '2023-12-14 18:06:22', NULL, NULL);
INSERT INTO `public_goods` VALUES (25, 1008, 'WP202314063300001', '肾上腺素3.0', 1, NULL, NULL, '安康肾上腺素', 1, 2, 1, '远志集团有限公司', 0, NULL, '2023-12-14 18:08:05', NULL, NULL);
INSERT INTO `public_goods` VALUES (26, 1005, 'WP202314084800001', '小型注射器', 2, NULL, NULL, '安康小型注射器', 1, 2, 1, '远志集团有限公司', 0, NULL, '2023-12-14 18:08:57', NULL, NULL);
INSERT INTO `public_goods` VALUES (27, 1005, 'WP202314091900001', '小型注射器2.0', 1, NULL, NULL, '安康小型注射器', 1, 2, 1, '远志集团有限公司', 0, NULL, '2023-12-14 18:09:49', NULL, NULL);
INSERT INTO `public_goods` VALUES (28, 1005, 'WP202314103300001', '小型注射器3.0', 2, NULL, NULL, '安康小型注射器', 1, 2, 1, '远志集团有限公司', 0, NULL, '2023-12-14 18:11:54', NULL, NULL);
INSERT INTO `public_goods` VALUES (29, 1005, 'WP202314151700001', '小型注射器4.0', 3, NULL, NULL, '安康小型注射器', 1, 2, 1, '远志集团有限公司', 0, NULL, '2023-12-14 18:16:25', NULL, NULL);
INSERT INTO `public_goods` VALUES (30, 1005, 'WP202314163300001', '小型注射器5.0', 4, NULL, NULL, '安康小型注射器', 1, 2, 1, '远志集团有限公司', 0, NULL, '2023-12-14 18:16:41', NULL, NULL);
INSERT INTO `public_goods` VALUES (31, 1004, 'WP202314182000002', 'B超机', 5, NULL, NULL, '云逸B超机', 2, 100, 2, '远志集团有限公司', 0, NULL, '2023-12-14 18:18:37', NULL, NULL);
INSERT INTO `public_goods` VALUES (32, 1004, 'WP202314184300003', 'B超机2.0', 6, NULL, NULL, '云逸B超机', 2, 100, 2, '远志集团有限公司', 0, NULL, '2023-12-14 18:19:26', NULL, NULL);
INSERT INTO `public_goods` VALUES (33, 1004, 'WP202314193300004', 'B超机3.0', 8, NULL, NULL, '云逸B超机', 2, 100, 2, '远志集团有限公司', 0, NULL, '2023-12-14 18:19:49', NULL, NULL);
INSERT INTO `public_goods` VALUES (34, 1003, 'WP202314244100005', '医药剪子', 9, NULL, NULL, '魔域锤子', 2, 1, 1, '远志集团有限公司', 0, NULL, '2023-12-14 18:24:54', NULL, NULL);
INSERT INTO `public_goods` VALUES (35, 1003, 'WP202314300500006', '体温计', 1, NULL, NULL, '魔域锤子', 2, 1, 1, '远志集团有限公司', 0, NULL, '2023-12-14 18:30:18', NULL, NULL);
INSERT INTO `public_goods` VALUES (36, 1003, 'WP202314305500001', '手术钳', 2, NULL, NULL, '魔域锤子', 2, 1, 1, '远志集团有限公司', 0, NULL, '2023-12-14 18:31:08', NULL, NULL);
INSERT INTO `public_goods` VALUES (37, 1007, 'WP202314311200002', '六味地黄丸', 6, NULL, NULL, '九芝堂', 2, 200, 1, '远志集团有限公司', 0, NULL, '2023-12-26 18:31:20', NULL, NULL);
INSERT INTO `public_goods` VALUES (38, 1007, 'WP202325035900003', '复方氨酚烷胺', 3, '', '', '感康', NULL, 300, NULL, '远志集团有限公司', 0, NULL, '2023-12-25 11:04:00', NULL, NULL);

-- ----------------------------
-- Table structure for public_payment
-- ----------------------------
DROP TABLE IF EXISTS `public_payment`;
CREATE TABLE `public_payment`  (
  `payment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '合同付款ID',
  `content` int(11) NULL DEFAULT NULL COMMENT '款项内容',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '付款日期',
  `unit` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '付款单位',
  `payment_vendor_id` int(11) NULL DEFAULT NULL COMMENT '供应商ID（外键）（收款合同方）',
  `terms` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '付款条件',
  `sum` decimal(10, 0) NULL DEFAULT NULL COMMENT '付款金额',
  `duty` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '违约责任',
  `create_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除',
  PRIMARY KEY (`payment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of public_payment
-- ----------------------------
INSERT INTO `public_payment` VALUES (32, 1, '2024-01-03 00:00:00', '远志集团股份有限公司', 2, '无', 750, NULL, NULL, '2024-01-03 08:41:17', NULL, NULL, 0);
INSERT INTO `public_payment` VALUES (33, 1, '2024-01-05 00:00:00', '远志集团股份有限公司', 2445, '无', 720, NULL, NULL, '2024-01-05 09:40:44', NULL, NULL, 0);

-- ----------------------------
-- Table structure for public_qualification
-- ----------------------------
DROP TABLE IF EXISTS `public_qualification`;
CREATE TABLE `public_qualification`  (
  `qualification_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '资质表ID',
  `qualification_vendor_id` int(11) NULL DEFAULT NULL COMMENT '供应商ID（外键）',
  `qualification_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资质名称',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '有效期起',
  `stop_time` datetime(0) NULL DEFAULT NULL COMMENT '有效期终',
  `documents` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资质证件',
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除',
  PRIMARY KEY (`qualification_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 680 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of public_qualification
-- ----------------------------
INSERT INTO `public_qualification` VALUES (661, 2444, '营业执照', '2020-12-16 00:00:00', '2024-02-23 00:00:00', '901', '营业执照附件', 0);
INSERT INTO `public_qualification` VALUES (662, 2444, '经营许可证', '2022-07-08 00:00:00', '2026-01-30 00:00:00', '902', '经营许可证附件', 0);
INSERT INTO `public_qualification` VALUES (663, 2444, '食品安全许可证', '2021-07-16 00:00:00', '2027-01-22 00:00:00', '903', '食品安全许副本', 0);
INSERT INTO `public_qualification` VALUES (664, 2445, '营业执照', '2018-12-11 00:00:00', '2024-02-14 00:00:00', '904', '营业执照副本', 0);
INSERT INTO `public_qualification` VALUES (665, 2445, '食品安全许可证', '2022-01-12 00:00:00', '2028-01-13 00:00:00', '905', '食品安全许可证副本', 0);
INSERT INTO `public_qualification` VALUES (666, 2445, '医疗器械证', '2021-01-13 00:00:00', '2026-01-19 00:00:00', '906', '医疗器械证副本', 0);
INSERT INTO `public_qualification` VALUES (667, 2445, '经营许可证', '2021-01-15 00:00:00', '2026-06-04 00:00:00', '907', '经营许可证副本', 0);
INSERT INTO `public_qualification` VALUES (668, 2446, '经营许可证', '2020-12-08 00:00:00', '2024-02-10 00:00:00', '908', NULL, 0);
INSERT INTO `public_qualification` VALUES (669, 2446, '营业执照', '2022-01-04 00:00:00', '2027-01-15 00:00:00', '909', NULL, 0);
INSERT INTO `public_qualification` VALUES (670, 2447, '食品安全', '2020-12-10 00:00:00', '2024-03-07 00:00:00', '910', NULL, 0);
INSERT INTO `public_qualification` VALUES (671, 2451, '营业执照副本', '2019-12-11 00:00:00', '2024-02-17 00:00:00', '911', '营业执照副本', 0);
INSERT INTO `public_qualification` VALUES (672, 2451, '经营许可证', '2021-01-07 00:00:00', '2028-01-20 00:00:00', '912', NULL, 0);
INSERT INTO `public_qualification` VALUES (673, 2452, '证件', '2021-12-02 00:00:00', '2022-02-22 00:00:00', '913', NULL, 0);
INSERT INTO `public_qualification` VALUES (674, 2453, '证件', '2020-12-16 00:00:00', '2023-02-28 00:00:00', '914', NULL, 0);
INSERT INTO `public_qualification` VALUES (675, 2454, '经营许可证', '2019-12-03 00:00:00', '2024-02-09 00:00:00', '915', NULL, 0);
INSERT INTO `public_qualification` VALUES (676, 2454, '营业执照', '2021-01-15 00:00:00', '2028-01-14 00:00:00', '916', NULL, 0);
INSERT INTO `public_qualification` VALUES (677, 2455, '营业执照', '2019-12-13 00:00:00', '2024-02-15 00:00:00', '919', NULL, 0);
INSERT INTO `public_qualification` VALUES (678, 2456, '营业执照副本', '2019-12-12 00:00:00', '2024-02-15 00:00:00', '923', NULL, 0);
INSERT INTO `public_qualification` VALUES (679, 2456, '经营许可证', '2022-01-05 00:00:00', '2026-01-09 00:00:00', '924', NULL, 0);

-- ----------------------------
-- Table structure for public_receipt
-- ----------------------------
DROP TABLE IF EXISTS `public_receipt`;
CREATE TABLE `public_receipt`  (
  `receipt_id` int(100) NOT NULL AUTO_INCREMENT COMMENT '收货单ID',
  `receipt_clod` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货单号',
  `receipt_time` datetime(0) NULL DEFAULT NULL COMMENT '收货日期',
  `receipt_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人',
  `receipt_number` int(11) NULL DEFAULT NULL COMMENT '收货总数量',
  `receipt_money` decimal(10, 0) NULL DEFAULT NULL COMMENT '金额',
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `receipt_vendor_id` int(11) NULL DEFAULT NULL COMMENT '供应商ID（外键）',
  `contact` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `receipt_phone` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '移动电话',
  `receipt_state` int(11) NULL DEFAULT NULL COMMENT '状态',
  `receipt_orders_id` int(11) NULL DEFAULT NULL COMMENT '采购订单ID（外键）',
  `receipt_warehouse_id` int(11) NULL DEFAULT NULL COMMENT '仓库ID（外键）',
  `create_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `is_delete` int(11) NULL DEFAULT NULL COMMENT '删除',
  PRIMARY KEY (`receipt_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1018 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of public_receipt
-- ----------------------------
INSERT INTO `public_receipt` VALUES (1001, 'FH202311181459459', '2023-12-13 14:50:03', '任洁婷', 20, 10002, '无', 2, '郑十三', '13800138000', 0, 1, 1, '张三', '2023-12-13 14:52:41', NULL, NULL, 0);
INSERT INTO `public_receipt` VALUES (1014, 'FH202312181459430', '2023-12-09 15:39:59', '赖熙敏', 15, 10002, '无', 2, '郑十三', '13800138000', 1, 1, 1, '李思', '2023-12-18 14:59:43', NULL, NULL, 0);
INSERT INTO `public_receipt` VALUES (1015, 'FH202312280923110', '2023-12-24 14:26:36', '解巧怡', 13, 3143, '药物，请放在干燥的地方', 5, '克里夫', '17234516337', 1, 17, 1, '张三关', '2023-12-28 09:23:12', NULL, NULL, 0);
INSERT INTO `public_receipt` VALUES (1016, 'FH202312291204300', '2023-12-28 14:41:09', '皮炼纲', 2, 12, '无', 6, '吊几把', '16346378372', 1, 31, 1, '张三', '2023-12-29 12:04:31', NULL, NULL, 0);
INSERT INTO `public_receipt` VALUES (1017, 'FH202401030937170', '2024-01-05 22:22:40', 'fm', 19, 3091, '11111', 2445, '荣津', '15626011679', 1, 43, 1, 'fm', '2024-01-03 09:37:17', NULL, NULL, 0);

-- ----------------------------
-- Table structure for public_signings
-- ----------------------------
DROP TABLE IF EXISTS `public_signings`;
CREATE TABLE `public_signings`  (
  `signing_status_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '签署状态ID',
  `signing_contractdetails_id` int(11) NULL DEFAULT NULL COMMENT '合同基本信息ID（外键）',
  `signatories_number` int(11) NULL DEFAULT NULL COMMENT '签署方数（1：双方签署 2：三方签署）',
  `signing_subject` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '我方主体',
  `signing_vendor_id` int(11) NULL DEFAULT NULL COMMENT '乙方供应商ID（外键）',
  `signing_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '乙方供应商公司地址',
  `signing_contact` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '乙方联系人',
  `signing_contact_mode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '乙方联系方式',
  `signing_bank` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '乙户开户行',
  `signing_bank_account` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开户账号',
  `siging_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '合同方金额',
  `currency` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '币别',
  PRIMARY KEY (`signing_status_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of public_signings
-- ----------------------------
INSERT INTO `public_signings` VALUES (1, 1, 1, '远志集团', 2, '湖南省长沙市开福区', '郑十三', '13800138000', NULL, 'GS2005271', 100005.00, '人民币');
INSERT INTO `public_signings` VALUES (2, 3, 1, '远志集团', 2, '湖南省长沙市开福区', '郑十三', '13800138000', NULL, 'GS2005271', NULL, '人民币');
INSERT INTO `public_signings` VALUES (3, 4, 1, '远志集团', 2, '北京', '郑十三', '13800138000', '工商银行', 'GS2005271', 0.00, '人民币');
INSERT INTO `public_signings` VALUES (4, 5, 1, '远志集团', 2, '北京', '郑十三', '13800138000', '工商银行', 'GS2005271', 0.00, '人民币');
INSERT INTO `public_signings` VALUES (5, 6, 1, '远志集团', 2, '北京', '郑十三', '13800138000', '工商银行', 'GS2005271', 270006.00, '人民币');
INSERT INTO `public_signings` VALUES (6, 7, 1, '远志集团', 15, '湖南长沙', '浩梓涵', '19340230377', '农业银行', '322899255024569', 270006.00, '人民币');
INSERT INTO `public_signings` VALUES (7, 8, 1, '远志集团', 23, '西藏', '郭礼钰', '19340230377', NULL, '322899255024569', 270006.00, '人民币');
INSERT INTO `public_signings` VALUES (8, 9, 1, '远志集团', 2, '北京', 'yyn', '17373031593', '工商银行', 'GS2005271', 270006.00, '人民币');
INSERT INTO `public_signings` VALUES (9, 1010, 1, '远志集团', 2454, '上海', '荣昊革', '18369593397', NULL, '235762076026', 0.00, '人民币');
INSERT INTO `public_signings` VALUES (10, 1011, 1, '远志集团', 2452, '成都', '郑冶苹', '18036755244', '中国银行', '2982982962', 4000.00, '人民币');
INSERT INTO `public_signings` VALUES (11, 1012, NULL, '远志集团', 2445, '北京', '荣津', '15626011679', '长沙银行', '217856916912287', 1270.00, '人民币');
INSERT INTO `public_signings` VALUES (12, 1013, NULL, '远志集团', 2445, '北京', '荣津', '15626011679', '长沙银行', '217856916912287', 1270.00, '人民币');
INSERT INTO `public_signings` VALUES (13, 1014, 1, '远志集团', 2445, '北京', '荣津', '15626011679', '长沙银行', '217856916912287', 1270.00, '人民币');

-- ----------------------------
-- Table structure for public_supplied_materials
-- ----------------------------
DROP TABLE IF EXISTS `public_supplied_materials`;
CREATE TABLE `public_supplied_materials`  (
  `supplied_materials_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '供货物料表id',
  `supply_id` int(11) NULL DEFAULT NULL COMMENT '供货表编号（外键）',
  `demand_ma_id` int(11) NULL DEFAULT NULL COMMENT '物料id',
  `available` int(11) NULL DEFAULT 0 COMMENT '是否可供（0：可供 1：不可供）',
  `exempt` int(11) NULL DEFAULT 1 COMMENT '是否免检 （0：免检 1：不免检）',
  `grade` int(11) NULL DEFAULT 1 COMMENT '供货能力等级',
  PRIMARY KEY (`supplied_materials_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1099 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of public_supplied_materials
-- ----------------------------
INSERT INTO `public_supplied_materials` VALUES (1025, 1005, 33, 0, 1, 1);
INSERT INTO `public_supplied_materials` VALUES (1026, 1005, 34, 0, 1, 2);
INSERT INTO `public_supplied_materials` VALUES (1027, 1005, 35, 0, 1, 1);
INSERT INTO `public_supplied_materials` VALUES (1028, 1005, 36, 0, 1, 1);
INSERT INTO `public_supplied_materials` VALUES (1029, 1005, 37, 0, 1, 3);
INSERT INTO `public_supplied_materials` VALUES (1050, 1000, 9, 0, 1, 1);
INSERT INTO `public_supplied_materials` VALUES (1051, 1000, 10, 0, 1, 2);
INSERT INTO `public_supplied_materials` VALUES (1052, 1000, 11, 0, 1, 1);
INSERT INTO `public_supplied_materials` VALUES (1053, 1000, 12, 0, 1, 1);
INSERT INTO `public_supplied_materials` VALUES (1054, 1000, 13, 0, 1, 3);
INSERT INTO `public_supplied_materials` VALUES (1055, 1001, 14, 0, 1, 1);
INSERT INTO `public_supplied_materials` VALUES (1056, 1001, 15, 0, 1, 2);
INSERT INTO `public_supplied_materials` VALUES (1057, 1001, 12, 0, 1, 1);
INSERT INTO `public_supplied_materials` VALUES (1058, 1001, 16, 0, 1, 1);
INSERT INTO `public_supplied_materials` VALUES (1059, 1001, 17, 0, 1, 3);
INSERT INTO `public_supplied_materials` VALUES (1060, 1002, 18, 0, 1, 1);
INSERT INTO `public_supplied_materials` VALUES (1061, 1002, 19, 0, 1, 2);
INSERT INTO `public_supplied_materials` VALUES (1062, 1002, 20, 0, 1, 1);
INSERT INTO `public_supplied_materials` VALUES (1063, 1002, 21, 0, 1, 1);
INSERT INTO `public_supplied_materials` VALUES (1064, 1002, 22, 0, 1, 3);
INSERT INTO `public_supplied_materials` VALUES (1065, 1004, 28, 0, 1, 1);
INSERT INTO `public_supplied_materials` VALUES (1066, 1004, 29, 0, 1, 2);
INSERT INTO `public_supplied_materials` VALUES (1067, 1004, 30, 0, 1, 1);
INSERT INTO `public_supplied_materials` VALUES (1068, 1004, 31, 0, 1, 1);
INSERT INTO `public_supplied_materials` VALUES (1069, 1004, 32, 0, 1, 3);
INSERT INTO `public_supplied_materials` VALUES (1070, 1003, 23, 0, 1, 1);
INSERT INTO `public_supplied_materials` VALUES (1071, 1003, 24, 0, 1, 2);
INSERT INTO `public_supplied_materials` VALUES (1072, 1003, 25, 0, 1, 1);
INSERT INTO `public_supplied_materials` VALUES (1073, 1003, 26, 0, 1, 1);
INSERT INTO `public_supplied_materials` VALUES (1074, 1003, 27, 0, 1, 3);
INSERT INTO `public_supplied_materials` VALUES (1075, 1006, 38, 0, 1, 1);
INSERT INTO `public_supplied_materials` VALUES (1076, 1006, 9, 0, 1, 2);
INSERT INTO `public_supplied_materials` VALUES (1077, 1006, 10, 0, 1, 1);
INSERT INTO `public_supplied_materials` VALUES (1078, 1006, 11, 0, 1, 1);
INSERT INTO `public_supplied_materials` VALUES (1079, 1006, 12, 0, 1, 3);
INSERT INTO `public_supplied_materials` VALUES (1080, 1008, 18, 0, 1, 1);
INSERT INTO `public_supplied_materials` VALUES (1081, 1008, 19, 0, 1, 2);
INSERT INTO `public_supplied_materials` VALUES (1082, 1008, 20, 0, 1, 1);
INSERT INTO `public_supplied_materials` VALUES (1083, 1008, 21, 0, 1, 1);
INSERT INTO `public_supplied_materials` VALUES (1084, 1008, 22, 0, 1, 3);
INSERT INTO `public_supplied_materials` VALUES (1085, 1009, 23, 0, 1, 1);
INSERT INTO `public_supplied_materials` VALUES (1086, 1009, 26, 0, 1, 2);
INSERT INTO `public_supplied_materials` VALUES (1087, 1009, 34, 0, 1, 1);
INSERT INTO `public_supplied_materials` VALUES (1088, 1009, 38, 0, 1, 1);
INSERT INTO `public_supplied_materials` VALUES (1089, 1009, 30, 0, 1, 3);
INSERT INTO `public_supplied_materials` VALUES (1090, 1007, 13, 0, 1, 1);
INSERT INTO `public_supplied_materials` VALUES (1091, 1007, 14, 0, 1, 2);
INSERT INTO `public_supplied_materials` VALUES (1092, 1007, 15, 0, 1, 1);
INSERT INTO `public_supplied_materials` VALUES (1093, 1007, 16, 0, 1, 1);
INSERT INTO `public_supplied_materials` VALUES (1094, 1007, 17, 0, 1, 3);
INSERT INTO `public_supplied_materials` VALUES (1095, 1010, 15, 0, 1, 3);
INSERT INTO `public_supplied_materials` VALUES (1096, 1011, 16, 0, 1, 1);
INSERT INTO `public_supplied_materials` VALUES (1097, 1012, 14, 0, 0, 0);
INSERT INTO `public_supplied_materials` VALUES (1098, 1012, 20, 0, 1, 0);

-- ----------------------------
-- Table structure for public_supply
-- ----------------------------
DROP TABLE IF EXISTS `public_supply`;
CREATE TABLE `public_supply`  (
  `supply_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '供货ID（主键）',
  `supply_vendor_id` int(11) NULL DEFAULT NULL COMMENT '供应商主键',
  `supplier_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商编码',
  `supplier_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商名称',
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除',
  PRIMARY KEY (`supply_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1013 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of public_supply
-- ----------------------------
INSERT INTO `public_supply` VALUES (1000, 2444, 'GYS242935808', '九芝堂', '', 'cg-admin', '2024-01-02 21:59:31', 'cg-admin', '2024-01-03 01:17:44', 0);
INSERT INTO `public_supply` VALUES (1001, 2445, 'GYS360117760', '莱茵生物', ' ', 'cg-admin', '2024-01-02 22:00:29', 'cg-admin', '2024-01-03 01:17:57', 0);
INSERT INTO `public_supply` VALUES (1002, 2446, 'GYS055799808', '益佰制药', '', 'cg-admin', '2024-01-02 22:06:43', 'cg-admin', '2024-01-03 01:18:03', 0);
INSERT INTO `public_supply` VALUES (1003, 2451, 'GYS943732736', '安图生物', '无', 'cg-admin', '2024-01-02 22:07:51', 'cg-admin', '2024-01-03 01:18:23', 0);
INSERT INTO `public_supply` VALUES (1004, 2447, 'GYS529376256', '同仁堂', '', 'cg-admin', '2024-01-02 22:08:45', 'cg-admin', '2024-01-03 01:18:09', 0);
INSERT INTO `public_supply` VALUES (1005, 2452, 'GYS839420928', '智飞生物', NULL, 'cg-admin', '2024-01-02 22:25:03', NULL, '0000-00-00 00:00:00', 0);
INSERT INTO `public_supply` VALUES (1006, 2453, 'GYS148264448', '凯利泰', '无', 'cg-admin', '2024-01-02 22:25:45', 'cg-admin', '2024-01-03 01:18:32', 0);
INSERT INTO `public_supply` VALUES (1007, 2454, 'GYS122714112', '乐普医疗', '---', 'cg-admin', '2024-01-02 22:26:24', 'cg-admin', '2024-01-03 01:19:01', 0);
INSERT INTO `public_supply` VALUES (1008, 2455, 'GYS029670400', '药石科技', '\\', 'cg-admin', '2024-01-02 22:28:24', 'cg-admin', '2024-01-03 01:18:40', 0);
INSERT INTO `public_supply` VALUES (1009, 2456, 'GYS698096128', '华海药业', '\\', 'cg-admin', '2024-01-02 22:29:13', 'cg-admin', '2024-01-03 01:18:50', 0);
INSERT INTO `public_supply` VALUES (1010, 2446, 'GYS055799808', '益佰制药', '', 'cg-admin', '2024-01-03 05:01:21', NULL, '0000-00-00 00:00:00', 0);
INSERT INTO `public_supply` VALUES (1011, 2456, 'GYS698096128', '华海药业', '', 'cg-admin', '2024-01-03 05:01:41', NULL, '0000-00-00 00:00:00', 0);
INSERT INTO `public_supply` VALUES (1012, 2444, 'GYS242935808', '九芝堂', '', 'cg-admin', '2024-01-03 05:02:02', NULL, '0000-00-00 00:00:00', 0);

-- ----------------------------
-- Table structure for public_user
-- ----------------------------
DROP TABLE IF EXISTS `public_user`;
CREATE TABLE `public_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `account` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `job` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '岗位',
  `phone` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '移动电话',
  `last_logintime` datetime(0) NULL DEFAULT NULL COMMENT '最后登录日期',
  `create_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `identity` int(11) NULL DEFAULT NULL COMMENT '0:采购部,1:供应商',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of public_user
-- ----------------------------
INSERT INTO `public_user` VALUES (1, 'zy', '1111', '采购部经理', NULL, '2023-11-16 11:30:49', 'admin', '2023-11-08 11:31:02', '', NULL, 0);
INSERT INTO `public_user` VALUES (2, 'yyn', '1111', '采购部', '13013145555', '2023-11-14 11:31:38', 'admin', '2023-11-13 11:31:44', NULL, NULL, 0);
INSERT INTO `public_user` VALUES (3, 'fm', '1111', '采购部', NULL, '2023-11-15 11:32:08', 'admin', NULL, NULL, NULL, 0);
INSERT INTO `public_user` VALUES (4, 'hxb', '1111', '采购部', '', '2023-11-15 11:32:43', 'admin', NULL, NULL, NULL, 0);
INSERT INTO `public_user` VALUES (5, 'zs', '张三', NULL, NULL, NULL, 'admin', '2023-11-07 11:34:03', NULL, NULL, 1);
INSERT INTO `public_user` VALUES (6, 'ls', '李四', NULL, NULL, NULL, 'admin', '2023-11-14 11:34:21', NULL, NULL, 1);
INSERT INTO `public_user` VALUES (7, 'wangwu', '12345', '销售部', '17235406849', NULL, 'admin', '2023-11-23 15:56:17', NULL, NULL, 1);

-- ----------------------------
-- Table structure for public_vendor
-- ----------------------------
DROP TABLE IF EXISTS `public_vendor`;
CREATE TABLE `public_vendor`  (
  `vendor_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '供应商ID',
  `vendor_number` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商编号',
  `abbreviated` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简称',
  `contract_type_type_id` int(11) NULL DEFAULT NULL COMMENT '字典类型（外键）',
  `vendor_type_state_id` int(11) NULL DEFAULT 1 COMMENT '状态（字典类型外键）',
  `is_blacklist` int(11) NULL DEFAULT 0 COMMENT '是否进黑名单',
  `ranges` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '服务范围',
  `causes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '原因',
  `warehouse_address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '仓库地址',
  `profile` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简介',
  `delegates` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '法定代表',
  `add_time` datetime(0) NULL DEFAULT NULL COMMENT '注册时间',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `fax` varchar(90) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '传真',
  `responsible` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人',
  `responsible_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人手机',
  `banking_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行名称',
  `industrial_commercial` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行卡号',
  `create_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `is_exist` int(11) NULL DEFAULT 0 COMMENT '供应商信息是否存在',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除',
  `uid` int(11) NULL DEFAULT NULL COMMENT '用户表id',
  PRIMARY KEY (`vendor_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2457 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of public_vendor
-- ----------------------------
INSERT INTO `public_vendor` VALUES (2444, 'GYS242935808', '九芝堂', 1, 2, 1, '驴胶补血冲剂、六味地黄丸', '国内中药龙头之一，百年老字号', '北京', '九芝堂：国内中药龙头之一，百年老字号， 主营产品：驴胶补血冲剂、六味地黄丸', '刘纳霞', '2023-01-11 00:00:00', '63ZLflgbitCoBpuZcO@163.com', '28782', '经冶炯', '18317921171', '农业银行', '48723484351945', 'cg-admin', '2024-01-02 21:35:04', NULL, NULL, 1, 0, 24);
INSERT INTO `public_vendor` VALUES (2445, 'GYS360117760', '莱茵生物', 2, 2, 1, '其他类型', '全球植物提取物行业领军企业', '北京', '全球植物提取物行业领军企业、全球天然甜味剂领航者', '喻唯琪', '2022-01-11 00:00:00', 'l59De8w@163.com', '69284044', '荣津', '15626011679', '长沙银行', '217856916912287', 'cg-admin', '2024-01-02 21:54:25', NULL, NULL, 0, 0, 15);
INSERT INTO `public_vendor` VALUES (2446, 'GYS055799808', '益佰制药', 0, 3, 1, '肿瘤医疗', '国内抗肿瘤医疗龙头', '湖北', '国内抗肿瘤医疗龙头；（唯一一个拥有独立知识产权的铂类药物！具有抗瘤谱广、抗瘤活性好、稳定性好、溶解度高以及毒性小等多项优势）', '汪战向', '2024-01-08 00:00:00', '4CUbKkF27bY@163.com', '5623923', '滑昊宣', '18894306148', '农业银行', '287289235021', 'cg-admin', '2024-01-02 21:58:31', NULL, NULL, 1, 0, 22);
INSERT INTO `public_vendor` VALUES (2447, 'GYS529376256', '同仁堂', 1, 3, 1, '宫牛黄丸，牛黄清心丸', '中成药龙头', '长沙市', '中成药龙头，以安宫牛黄丸、同仁牛黄清心丸、同仁大活络丸为代表的心脑血管系列；以乌鸡白凤丸、坤宝丸为代表的妇科系列,以国公酒、骨刺消痛液为代表的酒剂系列', '罗达勋', '2023-01-02 00:00:00', 'OnKKiWu7Me@163.com', '3583592', '苏盟坤', '18193127619', '长沙银行', '2284283593562', 'cg-admin', '2024-01-02 22:02:31', NULL, NULL, 1, 0, 23);
INSERT INTO `public_vendor` VALUES (2451, 'GYS943732736', '安图生物', 2, 3, 1, '体外诊断', '体外诊断龙头', '重庆', '公司专注于体外诊断试剂和仪器的研发、生产、销售及服务,产品涵盖免疫诊断、微生物检测、生化诊断等检测领域,能够为医学实验室提供全面的解决方案', '夏唯铮', '2022-01-03 00:00:00', 'rh8iHWniF1@163.com', '358732482', '邱齐争', '13467728125', '工商银行', '8353458353831', 'cg-admin', '2024-01-02 22:06:04', NULL, NULL, 1, 0, NULL);
INSERT INTO `public_vendor` VALUES (2452, 'GYS839420928', '智飞生物', 0, 3, 1, '疫苗、生物制品', '宫颈癌疫苗国内最大代理商', '成都', '', '周桢跃', '2023-01-10 00:00:00', 'NQMx1@163.com', '3838357', '郑冶苹', '18036755244', '中国银行', '2982982962', 'cg-admin', '2024-01-02 22:08:14', NULL, NULL, 0, 0, 18);
INSERT INTO `public_vendor` VALUES (2453, 'GYS148264448', '凯利泰', 0, 3, 1, '骨科手术器械', '骨科手术器械龙头', '哈尔滨', '椎体成形微创介入手术系统、骨科植入物、骨科手术器械龙头', '颜茹', '2022-01-11 00:00:00', 'e6d957FK@163.com', '273833', '嵇尚向', '13319816711', '农业银行', '56286969228', 'cg-admin', '2024-01-02 22:12:48', NULL, NULL, 1, 0, NULL);
INSERT INTO `public_vendor` VALUES (2454, 'GYS122714112', '乐普医疗', 1, 3, 1, '心血管医疗器械', '心血管医疗器械领域龙头', '上海', '心血管医疗器械领域龙头。冠状动脉扩张用支架输送系统、血管内洗脱支架系统、PTCA球囊扩张导管、PTCA造影导丝', '马达', '2022-01-13 00:00:00', 'SaPTJ@163.com', '9876986', '荣昊革', '18369593397', '邮政银行', '235762076026', 'cg-admin', '2024-01-02 22:16:37', NULL, NULL, 0, 0, 19);
INSERT INTO `public_vendor` VALUES (2455, 'GYS029670400', '药石科技', 1, 2, 1, '分子砌块的设计、合成和销售', '原料药的工艺研究和开发', '芜湖', '分子砌块的设计、合成和销售；药物分子砌块下游相关原料药的工艺研究和开发服务龙头', '任渝红', '2021-01-12 00:00:00', 'LkhEzkPMsW9x@163.com', '236278', '苏想争', '13141735638', '工商银行', '59455737329', 'cg-admin', '2024-01-02 22:24:17', NULL, NULL, 0, 0, 20);
INSERT INTO `public_vendor` VALUES (2456, 'GYS698096128', '华海药业', 0, 4, 1, '特色原料', '国内特色原料药行业的龙头企业', '四川', '国内特色原料药行业的龙头企业，是全球最大的普利类和沙坦类药物提供商', '黄璋', '2021-01-06 00:00:00', 'uDaoU@163.com', '3838337', '计韬连', '16559223766', '工商银行', '278959262', 'cg-admin', '2024-01-02 22:26:49', NULL, NULL, 0, 0, 21);

-- ----------------------------
-- Table structure for public_warehouse
-- ----------------------------
DROP TABLE IF EXISTS `public_warehouse`;
CREATE TABLE `public_warehouse`  (
  `warehouse_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '仓库ID',
  `warehouse_address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '仓库地址',
  `warehouse_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '仓库编码',
  `warehouse_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '仓库名称',
  PRIMARY KEY (`warehouse_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of public_warehouse
-- ----------------------------
INSERT INTO `public_warehouse` VALUES (1, '湖南省长沙市天心区', 'CK10001', '长沙仓');
INSERT INTO `public_warehouse` VALUES (2, '北京市海淀区中关村大街27号院', 'CK20003', '北京仓');
INSERT INTO `public_warehouse` VALUES (5, '北京市海淀区上庄家园西路上庄家园东区18号楼501室', 'CK30001', '超级仓库');
INSERT INTO `public_warehouse` VALUES (15, '四川省 遂宁市 船山区四川省遂宁市船山区明月路416号', 'CK84512', '熊猫基地仓库');
INSERT INTO `public_warehouse` VALUES (16, '重庆万年二支路122号', 'CK54784', '重启第三仓库仓库');
INSERT INTO `public_warehouse` VALUES (17, '湖南省长沙市开福区北大青鸟', 'CK21568', '橘子洲仓库');
INSERT INTO `public_warehouse` VALUES (18, '云南大理喜洲稻田', 'CK50432', '大理仓');
INSERT INTO `public_warehouse` VALUES (19, '广东深圳沙河街725号', 'CK35008', '云上端顶级仓');
INSERT INTO `public_warehouse` VALUES (20, '广州市花都区新华街新都大道68号馨庭花园', 'CK31392', '幸运仓库');
INSERT INTO `public_warehouse` VALUES (21, '香港特别行政区油尖旺区尖沙咀金马伦道22-24号东丽中心', 'CK30720', '中国香港一号仓库');

-- ----------------------------
-- Table structure for shopping_buy_plan
-- ----------------------------
DROP TABLE IF EXISTS `shopping_buy_plan`;
CREATE TABLE `shopping_buy_plan`  (
  `buy_plan_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '采购计划主键',
  `plan_clod` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '采购计划编码（转订单编码，不需要修改）',
  `plan_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '采购计划名称',
  `buy_plan_vendor_id` int(11) NULL DEFAULT NULL COMMENT '供应商主键',
  `buy_plan_warehouse_id` int(11) NULL DEFAULT NULL COMMENT '仓库主键',
  `buy_type_id` int(11) NULL DEFAULT NULL COMMENT '采购类型',
  `buy_plan_demand_id` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '计划物料id',
  `plan_state` int(11) NULL DEFAULT NULL COMMENT '状态',
  `create_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `is_delete` int(11) NULL DEFAULT NULL COMMENT '删除',
  PRIMARY KEY (`buy_plan_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of shopping_buy_plan
-- ----------------------------
INSERT INTO `shopping_buy_plan` VALUES (3, 'CGJH000001', '测试数据', 2444, 5, 1, '42,43', 3, '冯鸿弘', '2023-12-11 16:52:20', NULL, '2023-12-25 11:58:35', NULL);
INSERT INTO `shopping_buy_plan` VALUES (5, 'CGJH324823', '第一次计划', 2446, 1, 1, '45,46', 3, '魏峻\r\n', '2023-12-11 17:08:35', NULL, NULL, NULL);
INSERT INTO `shopping_buy_plan` VALUES (6, 'CGJH107212', '第二次计划', 2446, 1, 0, '47', 1, '黄裙璟', '2023-12-11 17:12:43', NULL, NULL, 0);
INSERT INTO `shopping_buy_plan` VALUES (7, 'CGJH636832', '第三个计划', 2444, 5, 1, '48', 2, '司禄为', '2023-12-11 19:17:48', NULL, NULL, 0);
INSERT INTO `shopping_buy_plan` VALUES (8, 'CGJH616012', '第四次计划', 2445, 2, 2, '49,50', 3, '房冶蒙', '2023-12-11 19:20:46', NULL, NULL, 0);
INSERT INTO `shopping_buy_plan` VALUES (9, 'CGJH912076', '远志采购计划002', 2447, 5, 1, '51,52', 1, '常盈苏', '2023-12-12 11:50:49', NULL, NULL, 0);
INSERT INTO `shopping_buy_plan` VALUES (10, 'CGJH982123', '出差采购', 2447, 5, 1, '82', 0, '柏薇鑫\r\n', '2023-12-15 17:07:37', NULL, '2023-12-29 11:55:23', 0);
INSERT INTO `shopping_buy_plan` VALUES (11, 'CGJH209212', '公益活动采购', 2445, 21, 1, '99,100', 3, '房冶蒙', '2023-12-25 11:29:47', NULL, NULL, 0);
INSERT INTO `shopping_buy_plan` VALUES (14, 'CGJH203012', '甘肃地震救援计划', 2446, 19, 1, '106,107,108', 1, '范纯戈', '2023-12-25 14:07:28', NULL, NULL, 0);
INSERT INTO `shopping_buy_plan` VALUES (15, 'CGJH373888', '远志公司采购部年检', 2445, 1, 0, '109,110', 0, '司禄为', '2023-12-25 14:10:36', NULL, '2024-01-03 09:14:43', 0);
INSERT INTO `shopping_buy_plan` VALUES (16, 'CGJH293952', '医院二部医疗设备更新', 2444, 19, 1, '111,112', 0, '柏薇鑫\r\n', '2023-12-25 14:57:34', NULL, NULL, 0);
INSERT INTO `shopping_buy_plan` VALUES (17, 'CGJH071168', '采购公益计划', 2444, 5, 1, '130', 3, 'fm', '2024-01-02 22:46:54', NULL, NULL, 0);

-- ----------------------------
-- Table structure for shopping_demand
-- ----------------------------
DROP TABLE IF EXISTS `shopping_demand`;
CREATE TABLE `shopping_demand`  (
  `demand_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '采购需求/计划物料id',
  `demand_ma_id` int(11) NOT NULL COMMENT '物料id',
  `demand_count` decimal(10, 0) NULL DEFAULT NULL COMMENT '数量',
  `demand_time` datetime(0) NULL DEFAULT NULL COMMENT '需求日期',
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `budget_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '预算单价',
  `order_count` decimal(10, 0) NULL DEFAULT NULL COMMENT '已生成订单数量',
  `warehousing_count` decimal(10, 0) NULL DEFAULT NULL COMMENT '入库数量',
  PRIMARY KEY (`demand_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 133 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of shopping_demand
-- ----------------------------
INSERT INTO `shopping_demand` VALUES (42, 14, 10, '2023-12-18 00:00:00', '测试数据1', 100.00, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (43, 13, 5, '2023-12-19 00:00:00', '测试数据2', 50.00, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (45, 9, 2, '2023-12-18 00:00:00', '轻拿轻放!', 400.00, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (46, 10, 10, '2023-12-26 00:00:00', '避免潮湿!', 200.00, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (47, 11, 13, '2023-12-19 00:00:00', '避免光照和潮湿', 241.80, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (48, 16, 10, '2023-12-25 00:00:00', '无', 300.00, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (49, 14, 12, '2023-12-26 00:00:00', '无', 264.00, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (50, 13, 15, '2023-12-24 00:00:00', '无', 180.00, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (51, 10, 20, '2023-12-27 00:00:00', '无', 390.60, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (52, 11, 17, '2023-12-28 00:00:00', '无', 207.40, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (57, 11, 16, '2023-12-26 00:00:00', '避免潮湿', 195.20, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (58, 10, 20, '2023-12-29 00:00:00', '避免日晒', 404.00, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (59, 15, 60, '2023-12-26 00:00:00', '轻拿轻放', 312000.00, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (60, 9, 100, '2023-12-27 00:00:00', '轻拿轻放', 131400.00, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (61, 11, 10, '2023-12-26 00:00:00', '无', 152.00, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (62, 10, 9, '2023-12-29 00:00:00', '研发需要', 174.60, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (63, 9, 9, '2023-12-29 00:00:00', '顺丰运送!', 44100.00, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (80, 10, 5, '2024-01-02 00:00:00', '要最新日期的', 101.50, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (82, 15, 1, '2023-12-26 00:00:00', '1', 1000.00, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (85, 9, 2, '2023-12-26 00:00:00', NULL, 6.00, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (95, 18, 5, '2023-12-27 00:00:00', '冷藏保存', 201.50, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (96, 10, 2, '2023-12-28 00:00:00', '1', 52.00, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (97, 11, 7, '2024-01-05 00:00:00', '无', 86.80, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (98, 10, 9, '2024-01-04 00:00:00', '2', 198.90, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (99, 17, 10, '2024-12-25 00:00:00', '冷藏室保存', 50.00, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (100, 18, 14, '2024-12-18 00:00:00', '冷藏室保存', 70.00, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (106, 18, 5, '2023-12-29 00:00:00', '急用', 60.00, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (107, 16, 5, '2023-12-29 00:00:00', '急需', 60.00, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (108, 12, 5, '2023-12-29 00:00:00', '111!!!', 160.00, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (109, 9, 3, '2024-01-30 00:00:00', '1', 15000.00, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (110, 15, 3, '2024-01-30 00:00:00', '2', 21600.00, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (111, 15, 5, '2024-01-05 00:00:00', '1', 17500.00, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (112, 9, 5, '2024-02-09 00:00:00', '2', 23105.00, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (113, 31, 5, '2023-12-27 00:00:00', '1', 1165.00, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (114, 17, 4, '2023-12-26 00:00:00', '1', 48.80, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (115, 15, 3, '2023-12-29 00:00:00', '2', 36.00, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (116, 36, 5, '2024-01-05 00:00:00', '1', 5.00, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (117, 37, 5, '2024-01-04 00:00:00', '1', 10.00, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (120, 15, 20, '2024-01-01 00:00:00', '轻拿轻放', 24000000.00, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (121, 9, 30, '2024-01-01 00:00:00', '轻拿轻放', 14400000.00, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (122, 9, 6, '2023-12-27 00:00:00', '轻拿轻放', 3240432.00, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (125, 37, 7, '2024-02-01 00:00:00', '1', 84.70, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (126, 38, 4, '2024-02-02 00:00:00', '2', 80.00, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (127, 9, 20, '2024-01-01 00:00:00', '轻拿轻放', 2400000.00, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (128, 16, 60, '2024-01-01 00:00:00', NULL, 360000.00, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (129, 11, 5, '2024-02-09 00:00:00', '2', 15.00, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (130, 11, 8, '2024-02-09 00:00:00', '2', 176.00, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (131, 9, 5, '2024-02-09 00:00:00', '1', 61.00, NULL, NULL);
INSERT INTO `shopping_demand` VALUES (132, 10, 3, '2024-02-09 00:00:00', '2', 36.30, NULL, NULL);

-- ----------------------------
-- Table structure for shopping_orders
-- ----------------------------
DROP TABLE IF EXISTS `shopping_orders`;
CREATE TABLE `shopping_orders`  (
  `order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单号',
  `require_id` int(11) NULL DEFAULT NULL COMMENT '需求表id',
  `buy_plan_id` int(11) NULL DEFAULT NULL COMMENT '采购计划主键',
  `order_title` varchar(180) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单标题',
  `order_source` int(11) NULL DEFAULT NULL COMMENT '订单来源',
  `order_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单编号',
  `order_purchaser` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '采购人',
  `total_money` decimal(10, 0) NULL DEFAULT NULL COMMENT '总金额',
  `is_zt` int(11) NULL DEFAULT NULL COMMENT '0:自提,1:配送',
  `car_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '自提车牌号',
  `driver_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '司机联系方式',
  `orde_contract_id` int(11) NULL DEFAULT NULL COMMENT '合同id',
  `order_context` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单说明',
  `contractdetails_amount` decimal(10, 0) NULL DEFAULT NULL COMMENT '合同总金额',
  `order_supplier_id` int(11) NULL DEFAULT NULL COMMENT '供应商',
  `vendor_contacts` int(11) NULL DEFAULT NULL COMMENT '供应商联系人',
  `order_material_id` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单物料信息',
  `type_order_state` int(11) NULL DEFAULT NULL COMMENT '采购方订单状态',
  `vendor_state` int(11) NULL DEFAULT NULL COMMENT '供应商订单状态',
  `create_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `is_delete` int(11) NULL DEFAULT NULL COMMENT '删除',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 53 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of shopping_orders
-- ----------------------------
INSERT INTO `shopping_orders` VALUES (42, 41, NULL, '远志内部签署订单', 0, 'Orders2024010200001', '边程', 12, 1, '湘F224A', '16821217732', NULL, '采购订单统计 功能说明: 采购订单统计有采购订单统计查询和采购订单明细两种报表两种，采购订单统计是只统计在一段时间内的按照查询条件得到的简单的采购信息，采购订单明细查询的数据比较详细', NULL, 2446, 304, '85', 4, 0, 'yyn', '2024-01-02 22:09:29', NULL, NULL, 0);
INSERT INTO `shopping_orders` VALUES (43, 35, NULL, '双方签署订单', 0, 'Orders2024010200002', '思域', 3091, 0, '', '', NULL, '采购订单是采购双方订立采购合同的重要依据，它包括了采购所需的重要细节信息，包括采购数量、商品规格、质量要求、采购价格、交货日期、交货地址等', NULL, 2445, 303, '61,62', 5, 0, 'yyn', '2024-01-02 22:22:40', NULL, NULL, 0);
INSERT INTO `shopping_orders` VALUES (44, 47, NULL, '敬老院体检公益订单', 0, 'Orders2024010200003', '刘思佳', 303, 0, '', '', NULL, '主要用来查询采购订单执行的状况，显示订单、到货、入库、退料的详细信息，供采购人员快速了解采购订单的执行情况。 此报表的数据来源于采购订单以及与采购订单相关联的收料单、入库单、退料单。', NULL, 2444, 300, '114,115', 3, 0, 'yyn', '2024-01-02 22:24:17', NULL, NULL, 0);
INSERT INTO `shopping_orders` VALUES (45, 45, NULL, '三医院医疗采购订单', 0, 'Orders2024010200004', '李礼', 2397, 1, '湘F33BO', '17823129900', NULL, '采购订单包含几种状态字段，指示订单的进度。 所有这些字段都显示在订单的订单头中', NULL, 2447, 305, '97,98', 4, 0, 'yyn', '2024-01-02 22:25:39', NULL, NULL, 0);
INSERT INTO `shopping_orders` VALUES (46, NULL, 5, '瑞和签署订单', 1, 'Orders2024010200005', '吴嬉', 2800, 0, '', '', NULL, '采购订单统计 功能说明: 采购订单统计有采购订单统计查询和采购订单明细两种报表两种，采购订单统计是只统计在一段时间内的按照查询条件得到的简单的采购信息，采购订单明细查询的数据比较详细', NULL, 2446, 304, '45,46', 1, 0, 'yyn', '2024-01-02 22:26:40', NULL, NULL, 0);
INSERT INTO `shopping_orders` VALUES (47, NULL, 8, '远志公益订单', 1, 'Orders2024010200006', '吴可欣', 5868, 0, '', '', NULL, '主要用来查询采购订单执行的状况，显示订单、到货、入库、退料的详细信息，供采购人员快速了解采购订单的执行情况。 此报表的数据来源于采购订单以及与采购订单相关联的收料单、入库单、退料单。', NULL, 2445, 303, '49,50', 6, 0, 'yyn', '2024-01-02 22:27:32', NULL, NULL, 0);
INSERT INTO `shopping_orders` VALUES (48, NULL, 11, '跨年需要订单', 1, 'Orders2024010200007', '刘佳', 1480, 0, '', '', NULL, '主要用来查询采购订单执行的状况，显示订单、到货、入库、退料的详细信息，供采购人员快速了解采购订单的执行情况。 此报表的数据来源于采购订单以及与采购订单相关联的收料单、入库单、退料单。', NULL, 2445, 303, '99,100', 4, 0, 'yyn', '2024-01-02 22:28:19', NULL, NULL, 0);
INSERT INTO `shopping_orders` VALUES (50, 205, NULL, '111', 0, 'Orders2024010300001', '球', 75, 0, '', '', NULL, '123', NULL, 2453, 308, '129', 0, 0, 'yyn', '2024-01-03 09:14:11', NULL, NULL, 0);
INSERT INTO `shopping_orders` VALUES (51, NULL, 17, '222', 1, 'Orders2024010300002', '日日日', 1408, 0, '', '', NULL, '68', NULL, 2444, 300, '130', 0, 0, 'yyn', '2024-01-03 09:15:16', NULL, NULL, 0);
INSERT INTO `shopping_orders` VALUES (52, NULL, NULL, '14', 2, 'Orders2024010300003', '让他', NULL, 0, '', '', 1011, '45', 4000, 2452, 307, '', 0, 0, 'yyn', '2024-01-03 09:16:13', NULL, NULL, 0);

-- ----------------------------
-- Table structure for shopping_pro_require
-- ----------------------------
DROP TABLE IF EXISTS `shopping_pro_require`;
CREATE TABLE `shopping_pro_require`  (
  `require_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '需求表id',
  `require_demand_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '需求物料id（外键）',
  `require_number` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '需求编号',
  `require_person` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '需求人',
  `require_dept` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '需求部门',
  `require_vendor` int(10) NULL DEFAULT NULL COMMENT '需求供应商',
  `require_type` int(11) NULL DEFAULT NULL COMMENT '需求类型（字典外键）',
  `is_tender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '是否需要转成招标项目,0不需要,1需要',
  `total_money` decimal(10, 2) NULL DEFAULT NULL COMMENT '总金额',
  `require_contact` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货联系人',
  `main_purpose` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主要用途及说明',
  `require_address` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动地址',
  `require_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `require_state` int(11) NULL DEFAULT 0 COMMENT '状态',
  `create_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `is_delete` int(11) NULL DEFAULT 0 COMMENT '删除',
  PRIMARY KEY (`require_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 207 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of shopping_pro_require
-- ----------------------------
INSERT INTO `shopping_pro_require` VALUES (35, '61,62', 'XQ2023121500001', '彼得潘', '研发部', 2445, 2, '0', 326.60, '思思', '研发部申请研发', '', '', 3, 'zy', '2023-12-15 14:53:29', NULL, NULL, 0);
INSERT INTO `shopping_pro_require` VALUES (36, '63', 'XQ2023121500002', 'Mr.Li', '采购部', NULL, 1, '1', 44100.00, '李斯', '无', '远志有限集团三楼', '17790908888', 2, 'yyn', '2023-12-15 14:56:09', NULL, NULL, 0);
INSERT INTO `shopping_pro_require` VALUES (37, '88', 'XQ2023121800001', 'Lisa', '秘书部', 2444, 2, '0', 540072.00, 'Lisa', '111', '远志有限集团五楼', '13014661890', 0, 'zy', '2023-12-18 09:26:53', NULL, '2023-12-20 20:15:10', 0);
INSERT INTO `shopping_pro_require` VALUES (38, '80', 'XQ2023121800002', '旺仔', '研发部', NULL, 0, '1', 101.50, '复原乳', '自主研发需要', '远志公司四楼', '408211151', 1, 'yyn', '2023-12-18 09:31:33', NULL, NULL, 0);
INSERT INTO `shopping_pro_require` VALUES (41, '85', 'XQ2023122000002', '夏鸣星', '研发部', 2446, 0, '0', 6.00, '歪歪', '', '', '123', 3, 'admin', '2023-12-20 19:51:24', NULL, NULL, 0);
INSERT INTO `shopping_pro_require` VALUES (43, '95', 'XQ2023122500003', '许明熙', '研发部', 2447, 1, '0', 201.50, '小明', '研发需要', '研发部四楼', '13012345678', 1, 'zy', '2023-12-25 11:11:52', NULL, NULL, 0);
INSERT INTO `shopping_pro_require` VALUES (44, '96', 'XQ2023122500004', '徐曼文', '前台', 2446, 1, '0', 52.00, 'Manda', '1', '一楼接待处', '13300001231', 2, 'fm', '2023-12-25 11:19:12', NULL, NULL, 0);
INSERT INTO `shopping_pro_require` VALUES (45, '97,98', 'XQ2023122500005', '李奇乐', '销售部', 2447, 2, '0', 285.70, '销售三部组长李奇乐', '公益活动举行', '远志二楼销售部三部', '13302128888', 3, 'zy', '2023-12-25 11:24:33', NULL, NULL, 0);
INSERT INTO `shopping_pro_require` VALUES (46, '113', 'XQ2023122500006', '付思雨', '采购部', NULL, 0, '1', 1165.00, '李悠茜院长', '年前补货', '远志一医院', '13098981232', 0, 'admin', '2023-12-25 19:26:15', NULL, NULL, 0);
INSERT INTO `shopping_pro_require` VALUES (47, '114,115', 'XQ2023122900001', '齐司礼', '采购部', 2444, 2, '0', 84.80, '思思', '', '', '', 3, 'zy', '2023-12-29 11:53:14', NULL, NULL, 0);
INSERT INTO `shopping_pro_require` VALUES (48, '116,117', 'XQ2023122900002', '陆沉', '销售部', NULL, 2, '1', 15.00, '乔乐', '1', '1', '13012342312', 0, 'zy', '2023-12-29 11:56:29', NULL, NULL, 0);
INSERT INTO `shopping_pro_require` VALUES (200, '120,121', 'XQ2024010200001', '张三', '采购部', NULL, 0, '1', 38400000.00, '李思', '医疗设备和传感器可以用于监测患者的生命体征，如心率、血压、血氧饱和度等，这些数据对于医生来说是重要的参考，可以帮助医生监测患者的健康状况。', '广东省深圳市福田区深南大道6006华丰大厦', '17789035469', 1, 'zy', '2024-01-02 16:07:03', NULL, '2024-01-02 16:09:18', 0);
INSERT INTO `shopping_pro_require` VALUES (201, '57,58', 'XQ2023120100021', '萧逸', '秘书部', 2444, 0, '0', 599.20, '张烨', '新年补货', NULL, NULL, 2, 'admin', '2024-01-27 20:30:28', NULL, NULL, 