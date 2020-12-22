/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50045
 Source Host           : localhost:3306
 Source Schema         : book

 Target Server Type    : MySQL
 Target Server Version : 50045
 File Encoding         : 65001

 Date: 22/12/2020 10:47:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book`  (
  `6` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `葵花宝典2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `张国荣2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `199` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `1002` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `99997` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `static/img/default.jpg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES ('8', '葵花宝典', '张国荣', '99', '1002', '99997', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('60', '时间简史11', '霍金000', '30', '213', '287', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('74', 'junlegou', '晓彤', '100', '113', '109', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('75', '时间简史00', '霍金1', '100', '113', '109', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('76', '时间简史11', '霍金2', '200', '224', '220', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('78', 'java从入门到放弃', '国哥', '80', '10000', '8', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('79', '数据结构与算法', '严敏君', '78.5', '6', '13', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('80', '怎样拐跑别人的媳妇', '龙伍', '68', '100000', '51', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('81', '木虚肉盖饭', '小胖', '16', '1001', '49', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('82', 'C++编程思想', '刚哥', '45.5', '14', '95', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('83', '蛋炒饭', '周星星', '9.9', '12', '53', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('84', '赌神', '龙伍', '66.5', '125', '535', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('85', 'Java编程思想', '阳哥', '99.5', '47', '36', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('86', 'JavaScript从入门到精通', '婷姐', '9.9', '85', '95', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('87', 'cocos2d-x游戏编程入门', '国哥', '49', '52', '62', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('88', 'C语言程序设计', '谭浩强', '28', '52', '74', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('89', 'Lua语言程序设计', '雷丰阳', '51.5', '48', '82', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('90', '西游记', '罗贯中', '12', '19', '9999', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('99', '三国演义', '西门子', '111', '111', '1111', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('100', 'Java速成', '龙哥', '22', '22', '22', 'static/img/default.jpg');
INSERT INTO `t_book` VALUES ('101', '葵花宝典', '张国荣', '99', '1000', '99999', NULL);
INSERT INTO `t_book` VALUES ('102', '葵花宝典', '张国荣', '99', '1000', '99999', NULL);

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `15953116248181` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `21/7/2020 17:52:05` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `228` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('159531172234619', '21/7/2020 14:08:42', '84', '1', '19');
INSERT INTO `t_order` VALUES ('15953129474161', '21/7/2020 14:29:07', '230', '1', '1');
INSERT INTO `t_order` VALUES ('15954121544411', '22/7/2020 18:02:34', '300', '1', '1');
INSERT INTO `t_order` VALUES ('159541224361719', '22/7/2020 18:04:03', '130', '0', '19');
INSERT INTO `t_order` VALUES ('16054916301351', '16/11/2020 09:53:50', '300', '2', '1');

-- ----------------------------
-- Table structure for t_order_item
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item`;
CREATE TABLE `t_order_item`  (
  `27` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `葵花宝典2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `99` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `991` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `15953116248181` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_order_item
-- ----------------------------
INSERT INTO `t_order_item` VALUES ('28', '葵花宝典', '1', '99', '99', '15953116248181');
INSERT INTO `t_order_item` VALUES ('29', '时间简史11', '1', '30', '30', '15953116248181');
INSERT INTO `t_order_item` VALUES ('30', '怎样拐跑别人的媳妇', '1', '68', '68', '159531172234619');
INSERT INTO `t_order_item` VALUES ('31', '木虚肉盖饭', '1', '16', '16', '159531172234619');
INSERT INTO `t_order_item` VALUES ('32', '时间简史11', '5', '30', '150', '15953129474161');
INSERT INTO `t_order_item` VALUES ('33', 'java从入门到放弃', '1', '80', '80', '15953129474161');
INSERT INTO `t_order_item` VALUES ('34', '时间简史00', '1', '100', '100', '15954121544411');
INSERT INTO `t_order_item` VALUES ('35', '时间简史11', '1', '200', '200', '15954121544411');
INSERT INTO `t_order_item` VALUES ('36', 'junlegou', '1', '100', '100', '159541224361719');
INSERT INTO `t_order_item` VALUES ('37', '时间简史11', '1', '30', '30', '159541224361719');
INSERT INTO `t_order_item` VALUES ('38', '时间简史00', '1', '100', '100', '16054916301351');
INSERT INTO `t_order_item` VALUES ('39', '时间简史11', '1', '200', '200', '16054916301351');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin@atguigu.com` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('19', 'gxl139', 'gxl139', 'gxl139@qq.com');

SET FOREIGN_KEY_CHECKS = 1;
