/*
Navicat MySQL Data Transfer

Source Server         : pwsql
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : pwdb

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2015-04-21 09:27:24
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
