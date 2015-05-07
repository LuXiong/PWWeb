/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50614
Source Host           : localhost:3306
Source Database       : pwdb

Target Server Type    : MYSQL
Target Server Version : 50614
File Encoding         : 65001

Date: 2015-05-06 14:52:31
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
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clothes
-- ----------------------------
INSERT INTO `clothes` VALUES ('56a590444be64c63a17f6556a38a1829', 'ssss', '1', '4', '1', '2015-05-05 20:48:27', '2015-05-05 20:48:27', 'wefsde', '12', null);
INSERT INTO `clothes` VALUES ('68fd7e4b9eae40d4953c7a6203b2f14f', 'ssss', '1', '4', '1', '2015-05-05 20:44:23', '2015-05-05 20:44:23', 'wefsde', '12', null);
INSERT INTO `clothes` VALUES ('76a18376c8174f3994c471a67486c30c', 'sdfsdf', '1', '4', '1', '2015-05-05 20:40:30', '2015-05-05 20:40:30', 'sdfesdfe', '12', null);
INSERT INTO `clothes` VALUES ('7a35f2aebf52449ebf3ee42c792919d8', '7a35f2aebf52449ebf3ee42c792919d8', '2', '1', '1', '2015-05-04 10:23:37', '2015-05-04 10:23:37', '11', '12', null);
INSERT INTO `clothes` VALUES ('d24efe48583b4091a29760986985b5c1', 'd24efe48583b4091a29760986985b5c1', '1', '2', '1', '2015-04-30 10:04:55', '2015-04-30 10:04:55', '123', '12', null);

-- ----------------------------
-- Table structure for clothes_type
-- ----------------------------
DROP TABLE IF EXISTS `clothes_type`;
CREATE TABLE `clothes_type` (
  `name` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `gender_code` int(11) NOT NULL,
  `type` varchar(255) NOT NULL,
  `type_code` int(11) NOT NULL,
  `detail_code` int(11) NOT NULL,
  `exponent` int(11) NOT NULL,
  PRIMARY KEY (`detail_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clothes_type
-- ----------------------------
INSERT INTO `clothes_type` VALUES ('长袖连衣裙', '女', '1', '裙装', '1', '21', '2');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `description` varchar(255) DEFAULT NULL,
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
INSERT INTO `token` VALUES ('1ee68184cd9d4e58a5f7211de33c684c', 'ecc8f428c6954ea195fae5f6b4c8bf9e', '2015-04-28 10:54:26', '123456', '15772334868', '2015-04-28 10:54:26', '1');
INSERT INTO `token` VALUES ('73af10c68759483bbb1854621df2fdf5', 'd24c335acca840be823cbd2585ca9655', '2015-04-28 11:00:10', '123456', '1576890334868', '2015-04-28 11:00:10', '1');
INSERT INTO `token` VALUES ('a4d8655cee6643798b701c9caa3850b2', 'b35ea8fc6b7245b29772a65762b8f234', '2015-04-28 10:37:27', '123456', '15072334868', '2015-04-28 10:37:27', '1');
INSERT INTO `token` VALUES ('b6c6577c420842a69be3d0353dd11e88', '9430fa9a62974e298a9fb44162d3a14d', '2015-04-28 11:01:04', '123456', '1576868', '2015-04-28 11:01:04', '1');
INSERT INTO `token` VALUES ('bb6f61abe4744d0a97fb28af8d606c54', '4d57c988ff764d6cb20c0d74d3862f50', '2015-04-30 10:53:55', '11111111', '15876552345', '2015-04-30 10:53:55', '1');
INSERT INTO `token` VALUES ('ca96785afcf943a08c07248193973e1f', '5915ed5c60144e8bad262c2808de12e4', '2015-04-28 17:27:51', '1234', '150723', '2015-04-28 17:27:51', '1');
INSERT INTO `token` VALUES ('dd68065988b44cb29b95ebe46e1c11be', 'f5cb780a77734652a202b5ec88bc337f', '2015-04-28 17:28:57', '1234', '160723', '2015-04-28 17:28:57', '1');

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
INSERT INTO `user` VALUES ('4d57c988ff764d6cb20c0d74d3862f50', 'ex', '1', '11111111', '15876552345', null, '2015-04-30 10:53:55', '2015-04-30 10:53:55', '1');
INSERT INTO `user` VALUES ('9430fa9a62974e298a9fb44162d3a14d', 'zyz', '1', '123456', '1576868', '12234', '2015-04-28 11:01:04', '2015-04-28 11:01:04', '1');
INSERT INTO `user` VALUES ('b35ea8fc6b7245b29772a65762b8f234', 'zyz', '1', '123456', '15072334868', '1234', '2015-04-28 10:37:27', '2015-04-28 10:37:27', '1');
INSERT INTO `user` VALUES ('d24c335acca840be823cbd2585ca9655', 'hj', '1', '123456', '1576890334868', '12234', '2015-04-28 11:00:10', '2015-04-28 11:00:10', '1');
INSERT INTO `user` VALUES ('ecc8f428c6954ea195fae5f6b4c8bf9e', 'xl', '1', '123456', '13297988492', '1234', '2015-04-28 10:54:26', '2015-04-28 10:54:26', '1');
INSERT INTO `user` VALUES ('f5cb780a77734652a202b5ec88bc337f', 'zyz31', '1', '1234', '160723', 'null', '2015-04-28 17:28:57', '2015-04-28 17:28:57', '1');
