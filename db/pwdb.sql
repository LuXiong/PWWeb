/*
Navicat MySQL Data Transfer

Source Server         : pwsql
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : pwdb

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2015-04-21 09:22:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for clothes
-- ----------------------------
DROP TABLE IF EXISTS `clothes`;
CREATE TABLE `clothes` (
  `id` varchar(255) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  `color` int(11) NOT NULL,
  `category` int(11) NOT NULL,
  `exponent` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `last_edit` datetime NOT NULL,
  `img` varchar(255) DEFAULT NULL,
  `suits` varchar(2048) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clothes
-- ----------------------------

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `topic` varchar(255) NOT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 NOT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=227 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('186', 'PW', 'hellotyu234e', '2015-04-21 01:00:05');
INSERT INTO `message` VALUES ('187', 'PW', 'hellotyu234e', '2015-04-21 01:01:39');
INSERT INTO `message` VALUES ('188', 'PW', 'hellotyu234ese', '2015-04-21 01:01:50');
INSERT INTO `message` VALUES ('189', 'PW', 'hellotyu234ese', '2015-04-21 01:02:14');
INSERT INTO `message` VALUES ('190', 'PW', 'hsdfe', '2015-04-21 01:02:30');
INSERT INTO `message` VALUES ('191', 'PW', 'hsdfe', '2015-04-21 01:02:32');
INSERT INTO `message` VALUES ('192', 'PW', 'hsdfe', '2015-04-21 01:02:32');
INSERT INTO `message` VALUES ('193', 'PW', 'hsdfe', '2015-04-21 01:02:32');
INSERT INTO `message` VALUES ('194', 'PW', 'hsdfe', '2015-04-21 01:02:32');
INSERT INTO `message` VALUES ('195', 'PW', 'hsdfe', '2015-04-21 01:02:32');
INSERT INTO `message` VALUES ('196', 'PW', 'hsdfee23sdce', '2015-04-21 01:03:05');
INSERT INTO `message` VALUES ('197', 'PW', 'hsdfee23sdcese2ec', '2015-04-21 01:03:07');
INSERT INTO `message` VALUES ('200', 'PW', '12334', '2015-04-21 01:04:38');
INSERT INTO `message` VALUES ('201', 'PW', '123342', '2015-04-21 01:04:41');
INSERT INTO `message` VALUES ('202', 'PW', 'xcv', '2015-04-21 01:04:44');
INSERT INTO `message` VALUES ('203', 'PW', 'ç¬¬ä¸æ¡è®°å½', '2015-04-21 01:05:40');
INSERT INTO `message` VALUES ('204', 'PW', 'ç¬¬äºæ¡è®°å½', '2015-04-21 01:05:44');
INSERT INTO `message` VALUES ('205', 'PW', 'ç¬¬ä¸æ¡è®°å½', '2015-04-21 01:05:49');
INSERT INTO `message` VALUES ('206', 'PW', 'first', '2015-04-21 01:06:06');
INSERT INTO `message` VALUES ('207', 'PW', 'first', '2015-04-21 01:06:46');
INSERT INTO `message` VALUES ('208', 'PW', 'second', '2015-04-21 01:06:50');
INSERT INTO `message` VALUES ('209', 'PW', 'third', '2015-04-21 01:06:53');
INSERT INTO `message` VALUES ('210', 'PW', '1', '2015-04-21 01:07:55');
INSERT INTO `message` VALUES ('211', 'PW', '12', '2015-04-21 01:07:57');
INSERT INTO `message` VALUES ('212', 'PW', '123', '2015-04-21 01:07:58');
INSERT INTO `message` VALUES ('213', 'PW', 'a', '2015-04-21 01:09:17');
INSERT INTO `message` VALUES ('214', 'PW', 'as', '2015-04-21 01:09:19');
INSERT INTO `message` VALUES ('215', 'PW', 'asd', '2015-04-21 01:09:20');
INSERT INTO `message` VALUES ('216', 'PW', 'hello ZhouYezi', '2015-04-21 08:49:42');
INSERT INTO `message` VALUES ('217', 'PW', 'hello ZhouYezi', '2015-04-21 08:50:05');
INSERT INTO `message` VALUES ('218', 'PW', 'hello ZhouYezi', '2015-04-21 08:50:05');
INSERT INTO `message` VALUES ('219', 'PW', 'hello ZhouYezi', '2015-04-21 08:50:05');
INSERT INTO `message` VALUES ('220', 'PW', 'hello ZhouYezi', '2015-04-21 08:50:06');
INSERT INTO `message` VALUES ('221', 'PW', 'hello ZhouYezi', '2015-04-21 08:50:06');
INSERT INTO `message` VALUES ('222', 'PW', 'hello ZhouYezi', '2015-04-21 08:50:07');
INSERT INTO `message` VALUES ('223', 'PW', 'hello ZhouYezi', '2015-04-21 08:50:07');
INSERT INTO `message` VALUES ('224', 'PW', 'hello ZhouYezi', '2015-04-21 08:50:08');
INSERT INTO `message` VALUES ('225', 'PW', 'hello ZhouYezi', '2015-04-21 08:50:08');
INSERT INTO `message` VALUES ('226', 'PW', 'hello ZhouYezi', '2015-04-21 09:20:33');

-- ----------------------------
-- Table structure for share
-- ----------------------------
DROP TABLE IF EXISTS `share`;
CREATE TABLE `share` (
  `id` int(11) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  `suit_id` varchar(255) NOT NULL,
  `img` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `favcount` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of share
-- ----------------------------

-- ----------------------------
-- Table structure for suit
-- ----------------------------
DROP TABLE IF EXISTS `suit`;
CREATE TABLE `suit` (
  `id` varchar(255) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  `img` varchar(255) DEFAULT NULL,
  `clothes` varchar(2048) DEFAULT NULL,
  `weather` int(11) DEFAULT NULL,
  `occasion` int(11) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `last_edit` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of suit
-- ----------------------------

-- ----------------------------
-- Table structure for token
-- ----------------------------
DROP TABLE IF EXISTS `token`;
CREATE TABLE `token` (
  `token` varchar(255) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  `user_password` varchar(255) NOT NULL,
  `user_phone` varchar(255) NOT NULL,
  `last_use` datetime NOT NULL,
  `device_id` varchar(255) NOT NULL,
  PRIMARY KEY (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of token
-- ----------------------------
INSERT INTO `token` VALUES ('PWAU', '0', '2015-04-17 09:20:02', '123456', '13297988492', '2015-04-17 14:55:19', '0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `gender` int(11) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `last_use` datetime NOT NULL,
  `device_id` varchar(255) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
