/*
Navicat MySQL Data Transfer

Source Server         : xx
Source Server Version : 50635
Source Host           : localhost:3306
Source Database       : urp

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2019-10-08 09:14:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(50) DEFAULT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES ('1', 'select', '查询');
INSERT INTO `t_permission` VALUES ('2', 'insert', '增加');
INSERT INTO `t_permission` VALUES ('3', 'update', '更新');
INSERT INTO `t_permission` VALUES ('4', 'delete', '删除');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `remarks` varchar(1000) DEFAULT NULL,
  `role_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '普通角色', 'p');
INSERT INTO `t_role` VALUES ('2', '重要角色', 'ip');
INSERT INTO `t_role` VALUES ('3', '超级角色', 'vip');

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `remarks` varchar(1000) DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjobmrl6dorhlfite4u34hciik` (`permission_id`),
  KEY `FK90j038mnbnthgkc17mqnoilu9` (`role_id`),
  CONSTRAINT `FK90j038mnbnthgkc17mqnoilu9` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`),
  CONSTRAINT `FKjobmrl6dorhlfite4u34hciik` FOREIGN KEY (`permission_id`) REFERENCES `t_permission` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
INSERT INTO `t_role_permission` VALUES ('1', '授予普通角色select权限', '1', '1');
INSERT INTO `t_role_permission` VALUES ('2', '授予重要角色select权限', '1', '2');
INSERT INTO `t_role_permission` VALUES ('3', '授予重要角色insert权限', '2', '2');
INSERT INTO `t_role_permission` VALUES ('4', '授予超级角色select权限', '1', '3');
INSERT INTO `t_role_permission` VALUES ('5', '授予超级角色insert权限', '2', '3');
INSERT INTO `t_role_permission` VALUES ('6', '授予超级角色update权限', '3', '3');
INSERT INTO `t_role_permission` VALUES ('7', '授予超级角色delete权限', '4', '3');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(100) NOT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  `user_name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '123', 'JKing团队', 'jking');
INSERT INTO `t_user` VALUES ('2', '123', '网维团队', 'wteam');
INSERT INTO `t_user` VALUES ('3', '123', 'ITAEM团队', 'itaem');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `remarks` varchar(1000) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKa9c8iiy6ut0gnx491fqx4pxam` (`role_id`),
  KEY `FKq5un6x7ecoef5w1n39cop66kl` (`user_id`),
  CONSTRAINT `FKa9c8iiy6ut0gnx491fqx4pxam` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`),
  CONSTRAINT `FKq5un6x7ecoef5w1n39cop66kl` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '授予JKing团队普通角色', '1', '1');
INSERT INTO `t_user_role` VALUES ('2', '授予网维团队重要角色', '2', '2');
INSERT INTO `t_user_role` VALUES ('3', '授予ITAEM团队超级角色', '3', '3');
