/*
Navicat MySQL Data Transfer

Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-01-30 17:35:30
*/

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` varchar(255) DEFAULT NULL,
  `content` blob,
  `text` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
