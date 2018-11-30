/*
Navicat MySQL Data Transfer

Source Server         : 本地连接
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : student

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2018-11-30 20:39:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stuNum` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `sex` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `classNum` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('40', '5', 'lk', '男', '18', '1');
INSERT INTO `student` VALUES ('39', '4', 'tqy', '女', '18', '1');
INSERT INTO `student` VALUES ('43', '99', '陈与先', '女', '20', '2');
INSERT INTO `student` VALUES ('36', '1', 'hc', '男', '18', '1');
INSERT INTO `student` VALUES ('42', '11', '陈治林', '男', '20', '4');
INSERT INTO `student` VALUES ('44', '521', '天使之翼', '男', '20', '2');
