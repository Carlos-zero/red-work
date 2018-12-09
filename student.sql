/*
Navicat MySQL Data Transfer

Source Server         : 本地连接
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : student

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2018-12-09 23:27:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for grades
-- ----------------------------
DROP TABLE IF EXISTS `grades`;
CREATE TABLE `grades` (
  `stuNum` int(11) NOT NULL,
  `physics` int(11) NOT NULL,
  `math` int(11) NOT NULL,
  `english` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

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
-- Table structure for stu_data
-- ----------------------------
DROP TABLE IF EXISTS `stu_data`;
CREATE TABLE `stu_data` (
  `xh` varchar(255) NOT NULL,
  `xm` varchar(255) NOT NULL,
  `xb` varchar(255) NOT NULL,
  `bj` varchar(255) NOT NULL,
  `zym` varchar(255) NOT NULL,
  `csrq` varchar(255) NOT NULL,
  `xjzt` varchar(255) NOT NULL,
  `mz` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
