/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50550
Source Host           : localhost:3306
Source Database       : heroes

Target Server Type    : MYSQL
Target Server Version : 50550
File Encoding         : 65001

Date: 2017-04-05 23:12:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for heroes
-- ----------------------------
DROP TABLE IF EXISTS `heroes`;
CREATE TABLE `heroes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(200) DEFAULT NULL,
  `last_name` varchar(200) DEFAULT NULL,
  `position` varchar(20) DEFAULT NULL,
  `sex` varchar(1) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of heroes
-- ----------------------------
INSERT INTO `heroes` VALUES ('2', '放逐之刃', '瑞文', '上单', '女', '战士');
INSERT INTO `heroes` VALUES ('3', '德玛西亚', '盖伦', '上单', '男', '坦克');
INSERT INTO `heroes` VALUES ('4', '德玛西亚', '皇子', '上单', '男', '刺客');
INSERT INTO `heroes` VALUES ('5', '赏金猎人', '厄运小姐', '下路', '女', '射手');
INSERT INTO `heroes` VALUES ('6', '皎月女神', '戴安娜', '中单', '女', '刺客');
INSERT INTO `heroes` VALUES ('7', '九尾妖狐', '阿狸', '中单', '女', '法师');
