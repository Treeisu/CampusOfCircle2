/*
Navicat MySQL Data Transfer

Source Server         : cherry
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : campusofcircle

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2017-11-20 17:12:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_attention
-- ----------------------------
DROP TABLE IF EXISTS `tb_attention`;
CREATE TABLE `tb_attention` (
  `attentionId` bigint(20) NOT NULL AUTO_INCREMENT,
  `createDate` datetime DEFAULT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `groupName` varchar(20) DEFAULT NULL,
  `messageId` bigint(20) DEFAULT NULL,
  `toUserId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`attentionId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_attention
-- ----------------------------
INSERT INTO `tb_attention` VALUES ('2', '2017-04-24 22:41:46', '2', '我的老师', '0', '2', '1');
INSERT INTO `tb_attention` VALUES ('4', '2017-05-06 19:45:52', '8', '无敌美少女', '0', '2', '3');
INSERT INTO `tb_attention` VALUES ('6', '2017-05-06 20:06:31', '0', '默认分组', '0', '3', '4');
INSERT INTO `tb_attention` VALUES ('8', '2017-05-06 21:29:03', '10', '学长', '0', '4', '5');
INSERT INTO `tb_attention` VALUES ('9', '2017-05-06 21:36:03', '1', '软件工程11班', '0', '5', '1');
INSERT INTO `tb_attention` VALUES ('10', '2017-07-01 15:34:50', '0', '默认分组', '0', '3', '1');
INSERT INTO `tb_attention` VALUES ('11', '2017-07-01 15:34:50', '0', '默认分组', '0', '3', '1');
INSERT INTO `tb_attention` VALUES ('12', '2017-07-01 15:34:50', '0', '默认分组', '0', '4', '1');

-- ----------------------------
-- Table structure for tb_chatinfo
-- ----------------------------
DROP TABLE IF EXISTS `tb_chatinfo`;
CREATE TABLE `tb_chatinfo` (
  `chatId` bigint(20) NOT NULL AUTO_INCREMENT,
  `chatContent` longtext,
  `createDate` datetime DEFAULT NULL,
  `fromUserId` bigint(20) DEFAULT NULL,
  `messageId` bigint(20) DEFAULT NULL,
  `toUserId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`chatId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_chatinfo
-- ----------------------------

-- ----------------------------
-- Table structure for tb_collection
-- ----------------------------
DROP TABLE IF EXISTS `tb_collection`;
CREATE TABLE `tb_collection` (
  `collectionInfoId` bigint(20) NOT NULL AUTO_INCREMENT,
  `collectionDate` datetime DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `wbId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`collectionInfoId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_collection
-- ----------------------------
INSERT INTO `tb_collection` VALUES ('1', '2017-05-06 21:34:41', '5', '12');

-- ----------------------------
-- Table structure for tb_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_comment`;
CREATE TABLE `tb_comment` (
  `commentId` bigint(20) NOT NULL AUTO_INCREMENT,
  `commentContent` longtext,
  `commentDate` datetime DEFAULT NULL,
  `fromCommentId` bigint(20) DEFAULT NULL,
  `messageId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `wbId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`commentId`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_comment
-- ----------------------------
INSERT INTO `tb_comment` VALUES ('6', '[心][心][心]good luck！', '2017-05-06 19:52:58', '0', '0', '3', '4');
INSERT INTO `tb_comment` VALUES ('15', '毕业季如此伤感啊', '2017-05-06 20:21:45', '0', '0', '2', '3');
INSERT INTO `tb_comment` VALUES ('18', '@不愿透露姓名的猫咪：谢谢哦~~~~', '2017-05-06 20:22:57', '6', '0', '2', '4');
INSERT INTO `tb_comment` VALUES ('21', '学长加油，你要相信你是最胖的！！', '2017-05-06 20:25:25', '0', '0', '3', '3');
INSERT INTO `tb_comment` VALUES ('50', '@不愿透露姓名的猫咪://哈哈哈哈哈哈哈 就服你', '2017-05-06 21:10:36', '21', '0', '4', '3');

-- ----------------------------
-- Table structure for tb_fans
-- ----------------------------
DROP TABLE IF EXISTS `tb_fans`;
CREATE TABLE `tb_fans` (
  `fanInfoId` bigint(20) NOT NULL AUTO_INCREMENT,
  `createDate` datetime DEFAULT NULL,
  `fromUserId` bigint(20) DEFAULT NULL,
  `messageId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`fanInfoId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_fans
-- ----------------------------
INSERT INTO `tb_fans` VALUES ('2', '2017-04-24 22:41:46', '1', '0', '2');
INSERT INTO `tb_fans` VALUES ('4', '2017-05-06 19:45:52', '3', '0', '2');
INSERT INTO `tb_fans` VALUES ('6', '2017-05-06 20:06:31', '4', '0', '3');
INSERT INTO `tb_fans` VALUES ('8', '2017-05-06 21:29:03', '5', '0', '4');
INSERT INTO `tb_fans` VALUES ('9', '2017-05-06 21:36:03', '1', '0', '5');
INSERT INTO `tb_fans` VALUES ('10', '2017-07-01 15:34:50', '1', '0', '3');
INSERT INTO `tb_fans` VALUES ('11', '2017-07-01 15:34:50', '1', '0', '3');
INSERT INTO `tb_fans` VALUES ('12', '2017-07-01 15:34:50', '1', '0', '4');

-- ----------------------------
-- Table structure for tb_groups
-- ----------------------------
DROP TABLE IF EXISTS `tb_groups`;
CREATE TABLE `tb_groups` (
  `groupId` bigint(20) NOT NULL AUTO_INCREMENT,
  `createDate` datetime DEFAULT NULL,
  `groupName` varchar(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`groupId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_groups
-- ----------------------------
INSERT INTO `tb_groups` VALUES ('0', '2017-04-24 21:18:39', '默认分组', '0');
INSERT INTO `tb_groups` VALUES ('1', '2017-05-06 19:11:51', '软件工程11班', '1');
INSERT INTO `tb_groups` VALUES ('2', '2017-05-06 19:12:06', '我的老师', '1');
INSERT INTO `tb_groups` VALUES ('3', '2017-05-06 19:12:18', '室友', '1');
INSERT INTO `tb_groups` VALUES ('4', '2017-05-06 19:33:16', 'never forget', '2');
INSERT INTO `tb_groups` VALUES ('5', '2017-05-06 19:34:21', '市场营销--老师', '2');
INSERT INTO `tb_groups` VALUES ('6', '2017-05-06 19:34:43', '可爱的同学们', '2');
INSERT INTO `tb_groups` VALUES ('7', '2017-05-06 19:45:14', '交大的同学们', '3');
INSERT INTO `tb_groups` VALUES ('8', '2017-05-06 19:45:48', '无敌美少女', '3');
INSERT INTO `tb_groups` VALUES ('9', '2017-05-06 20:06:03', '我的好朋友', '4');
INSERT INTO `tb_groups` VALUES ('10', '2017-05-06 21:28:39', '学长', '5');

-- ----------------------------
-- Table structure for tb_message
-- ----------------------------
DROP TABLE IF EXISTS `tb_message`;
CREATE TABLE `tb_message` (
  `messageId` bigint(20) NOT NULL AUTO_INCREMENT,
  `attentionId` bigint(20) DEFAULT NULL,
  `commentId` bigint(20) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `fromUserId` bigint(20) DEFAULT NULL,
  `kindOperation` bigint(20) DEFAULT NULL,
  `myUserId` bigint(20) DEFAULT NULL,
  `praiseId` bigint(20) DEFAULT NULL,
  `state` bigint(20) DEFAULT NULL,
  `turnId` bigint(20) DEFAULT NULL,
  `wbId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`messageId`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_message
-- ----------------------------
INSERT INTO `tb_message` VALUES ('2', '2', '0', '2017-04-24 22:41:46', '1', '1', '2', '0', '1', '0', '0');
INSERT INTO `tb_message` VALUES ('5', '0', '0', '2017-04-24 23:35:02', '2', '2', '1', '4', '1', '0', '1');
INSERT INTO `tb_message` VALUES ('7', '0', '0', '2017-05-06 19:37:57', '2', '3', '1', '0', '1', '1', '6');
INSERT INTO `tb_message` VALUES ('9', '4', '0', '2017-05-06 19:45:52', '3', '1', '2', '0', '1', '0', '0');
INSERT INTO `tb_message` VALUES ('12', '0', '6', '2017-05-06 19:52:58', '3', '4', '2', '0', '1', '0', '4');
INSERT INTO `tb_message` VALUES ('13', '0', '0', '2017-05-06 19:53:21', '3', '2', '2', '7', '1', '0', '4');
INSERT INTO `tb_message` VALUES ('14', '0', '0', '2017-05-06 19:53:48', '3', '3', '2', '0', '1', '2', '7');
INSERT INTO `tb_message` VALUES ('15', '0', '0', '2017-05-06 19:55:54', '3', '2', '1', '8', '1', '0', '1');
INSERT INTO `tb_message` VALUES ('16', '0', '0', '2017-05-06 19:55:57', '3', '2', '1', '9', '1', '0', '2');
INSERT INTO `tb_message` VALUES ('18', '6', '0', '2017-05-06 20:06:31', '4', '1', '3', '0', '0', '0', '0');
INSERT INTO `tb_message` VALUES ('19', '0', '0', '2017-05-06 20:07:57', '4', '3', '1', '0', '1', '3', '9');
INSERT INTO `tb_message` VALUES ('28', '0', '15', '2017-05-06 20:21:45', '2', '4', '1', '0', '1', '0', '3');
INSERT INTO `tb_message` VALUES ('29', '0', '21', '2017-05-06 20:25:25', '3', '4', '1', '0', '1', '0', '3');
INSERT INTO `tb_message` VALUES ('58', '0', '50', '2017-05-06 21:10:36', '4', '4', '1', '0', '1', '0', '3');
INSERT INTO `tb_message` VALUES ('59', '0', '0', '2017-05-06 21:11:59', '4', '3', '3', '0', '0', '4', '10');
INSERT INTO `tb_message` VALUES ('61', '8', '0', '2017-05-06 21:29:03', '5', '1', '4', '0', '0', '0', '0');
INSERT INTO `tb_message` VALUES ('62', '0', '0', '2017-05-06 21:29:09', '5', '2', '1', '10', '1', '0', '3');
INSERT INTO `tb_message` VALUES ('63', '0', '0', '2017-05-06 21:31:31', '5', '3', '4', '0', '0', '5', '11');
INSERT INTO `tb_message` VALUES ('64', '9', '0', '2017-05-06 21:36:03', '1', '1', '5', '0', '0', '0', '0');
INSERT INTO `tb_message` VALUES ('65', '0', '0', '2017-05-06 21:37:40', '1', '2', '5', '11', '0', '0', '12');
INSERT INTO `tb_message` VALUES ('66', '10', '0', '2017-07-01 15:34:50', '1', '1', '3', '0', '0', '0', '0');
INSERT INTO `tb_message` VALUES ('67', '12', '0', '2017-07-01 15:34:50', '1', '1', '4', '0', '0', '0', '0');
INSERT INTO `tb_message` VALUES ('68', '11', '0', '2017-07-01 15:34:50', '1', '1', '3', '0', '0', '0', '0');

-- ----------------------------
-- Table structure for tb_praise
-- ----------------------------
DROP TABLE IF EXISTS `tb_praise`;
CREATE TABLE `tb_praise` (
  `praiseInfoId` bigint(20) NOT NULL AUTO_INCREMENT,
  `messageId` bigint(20) DEFAULT NULL,
  `praiseDate` datetime DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `wbId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`praiseInfoId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_praise
-- ----------------------------
INSERT INTO `tb_praise` VALUES ('4', '0', '2017-04-24 23:35:02', '2', '1');
INSERT INTO `tb_praise` VALUES ('7', '0', '2017-05-06 19:53:21', '3', '4');
INSERT INTO `tb_praise` VALUES ('8', '0', '2017-05-06 19:55:54', '3', '1');
INSERT INTO `tb_praise` VALUES ('9', '0', '2017-05-06 19:55:57', '3', '2');
INSERT INTO `tb_praise` VALUES ('10', '0', '2017-05-06 21:29:09', '5', '3');
INSERT INTO `tb_praise` VALUES ('11', '0', '2017-05-06 21:37:40', '1', '12');

-- ----------------------------
-- Table structure for tb_pushinfo
-- ----------------------------
DROP TABLE IF EXISTS `tb_pushinfo`;
CREATE TABLE `tb_pushinfo` (
  `wbId` bigint(20) NOT NULL AUTO_INCREMENT,
  `collectionNum` bigint(20) DEFAULT NULL,
  `commentNum` bigint(20) DEFAULT NULL,
  `praiseNum` bigint(20) DEFAULT NULL,
  `turnNum` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userNickName` varchar(20) DEFAULT NULL,
  `wbAuthorId` bigint(20) DEFAULT NULL,
  `wbImage` longtext,
  `wbPushDate` datetime DEFAULT NULL,
  `wbTextContent` longtext,
  PRIMARY KEY (`wbId`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_pushinfo
-- ----------------------------
INSERT INTO `tb_pushinfo` VALUES ('1', '0', '0', '2', '0', '1', '姜小熙C', '0', null, '2017-04-24 22:42:34', '如果你愿意一层一层地剥开我的心 ');
INSERT INTO `tb_pushinfo` VALUES ('2', '0', '0', '1', '2', '1', '姜小熙C', '0', '/Upload-CoC/img/PushImg/149406977680464561731.jpg', '2017-05-06 19:22:56', '寒蝉凄切，对长亭晚，骤雨初歇。都门帐饮无绪，留恋处舟催发。执手相看泪眼，竟无语凝噎。念去去千里烟波，暮霭沉沉楚天阔。  多情自古伤离别，更那堪冷落清秋节。今宵酒醒何处?杨柳岸晓风残月。此去经年，应是良辰好景虚设。便纵有千种风情，更与何人说? ');
INSERT INTO `tb_pushinfo` VALUES ('3', '0', '3', '1', '0', '1', '姜小熙C', '0', '/Upload-CoC/img/PushImg/149407007460398766262.jpg', '2017-05-06 19:27:54', '剑未佩妥，出门已是江湖');
INSERT INTO `tb_pushinfo` VALUES ('4', '0', '2', '1', '0', '2', '亲爱的树洞', '0', null, '2017-05-06 19:35:29', '明天答辩啦 好激动啊！！！！[嘻嘻][嘻嘻][嘻嘻]');
INSERT INTO `tb_pushinfo` VALUES ('5', '0', '0', '0', '3', '2', '亲爱的树洞', '0', '/Upload-CoC/img/PushImg/149407062679922517228.jpg', '2017-05-06 19:37:06', '愿你出走半生，归来仍是少年。');
INSERT INTO `tb_pushinfo` VALUES ('6', '0', '0', '0', '0', '2', '亲爱的树洞', '2', null, '2017-05-06 19:37:57', '这是一首送别词。在柳永以前，抒写离愁别绪的词非常多。但因为柳永是一个长期浪迹江湖的游子，对生活有着独特的体验，因而他写一对恋人的离别，就不同于传统的送别词那种红楼深院、春花秋月的狭小境界，而表现出一种烟波浩荡、楚天开阔的气象。  ');
INSERT INTO `tb_pushinfo` VALUES ('7', '0', '0', '0', '1', '3', '不愿透露姓名的猫咪', '5', null, '2017-05-06 19:53:48', '曾梦想仗剑走天涯 看一看世界的繁华');
INSERT INTO `tb_pushinfo` VALUES ('8', '0', '0', '0', '0', '3', '不愿透露姓名的猫咪', '0', '/Upload-CoC/img/PushImg/149407181869063942653.jpg', '2017-05-06 19:56:58', '海上月是天上月，眼前人是心上人。');
INSERT INTO `tb_pushinfo` VALUES ('9', '0', '0', '0', '0', '4', '听妈妈的话', '2', null, '2017-05-06 20:07:57', '我也特别喜欢柳永的《雨霖铃》');
INSERT INTO `tb_pushinfo` VALUES ('10', '0', '0', '0', '1', '4', '听妈妈的话', '5', null, '2017-05-06 21:11:59', '我们都是最棒的！！！ // @不愿透露姓名的猫咪 : 曾梦想仗剑走天涯 看一看世界的繁华');
INSERT INTO `tb_pushinfo` VALUES ('11', '0', '0', '0', '0', '5', '不爱睡觉的考拉', '5', null, '2017-05-06 21:31:31', '人们该记住的是别人的好 // @听妈妈的话 : 我们都是最棒的！！！ // @不愿透露姓名的猫咪 : 曾梦想仗剑走天涯 看一看世界的繁华');
INSERT INTO `tb_pushinfo` VALUES ('12', '1', '0', '1', '0', '5', '不爱睡觉的考拉', '0', '/Upload-CoC/img/PushImg/149407766323270237851.jpg', '2017-05-06 21:34:23', '只恨时光太匆匆，大学四年我收获了什么。永远不要抱怨自己找不到一个理想的另一半，你不是也没成为那个理想的自己吗？');
INSERT INTO `tb_pushinfo` VALUES ('13', '0', '0', '0', '1', '1', '姜小熙C', '0', '/Upload-CoC/img/PushImg/149412740107978742896.jpg', '2017-05-07 11:23:21', 'hhh');
INSERT INTO `tb_pushinfo` VALUES ('14', '0', '0', '0', '0', '1', '姜小熙C', '13', null, '2017-05-07 11:24:20', 'efeij ');
INSERT INTO `tb_pushinfo` VALUES ('27', '0', '0', '0', '0', '1', '姜小熙C', '0', null, '2017-07-01 18:13:48', '传承人');
INSERT INTO `tb_pushinfo` VALUES ('28', '0', '0', '0', '0', '1', '姜小熙C', '0', null, '2017-07-01 19:04:44', '发vgv');
INSERT INTO `tb_pushinfo` VALUES ('29', '0', '0', '0', '0', '2', '亲爱的树洞', '0', null, '2017-07-01 19:11:58', '润肤乳');
INSERT INTO `tb_pushinfo` VALUES ('30', '0', '0', '0', '0', '1', '姜小熙C', '0', null, '2017-07-01 23:25:06', '让人个人');
INSERT INTO `tb_pushinfo` VALUES ('31', '0', '0', '0', '0', '1', '姜小熙C', '0', null, '2017-07-01 23:27:04', '如果通过');
INSERT INTO `tb_pushinfo` VALUES ('32', '0', '0', '0', '0', '1', '姜小熙C', '0', null, '2017-07-01 23:28:43', '通过提高');
INSERT INTO `tb_pushinfo` VALUES ('33', '0', '0', '0', '0', '1', '姜小熙C', '0', null, '2017-07-01 23:32:17', '跳跳糖');
INSERT INTO `tb_pushinfo` VALUES ('34', '0', '0', '0', '0', '1', '姜小熙C', '0', null, '2017-07-01 23:33:45', '剃光头');
INSERT INTO `tb_pushinfo` VALUES ('35', '0', '0', '0', '0', '1', '姜小熙C', '0', null, '2017-07-01 23:58:13', '的夫人房');
INSERT INTO `tb_pushinfo` VALUES ('36', '0', '0', '0', '0', '1', '姜小熙C', '0', null, '2017-07-02 00:02:32', '放热峰');
INSERT INTO `tb_pushinfo` VALUES ('37', '0', '0', '0', '0', '1', '姜小熙C', '0', null, '2017-07-02 00:09:22', '(⊙o⊙)…问仿');
INSERT INTO `tb_pushinfo` VALUES ('38', '0', '0', '0', '0', '2', '亲爱的树洞', '0', null, '2017-07-02 00:12:06', '个体个体威哥');
INSERT INTO `tb_pushinfo` VALUES ('39', '0', '0', '0', '0', '2', '亲爱的树洞', '0', null, '2017-07-02 00:15:45', '天图4题4');
INSERT INTO `tb_pushinfo` VALUES ('40', '0', '0', '0', '0', '1', '姜小熙C', '0', null, '2017-07-02 00:17:31', '人体感染');
INSERT INTO `tb_pushinfo` VALUES ('41', '0', '0', '0', '0', '1', '姜小熙C', '0', null, '2017-07-02 00:22:45', '工业h6');
INSERT INTO `tb_pushinfo` VALUES ('42', '0', '0', '0', '0', '1', '姜小熙C', '0', null, '2017-07-02 00:24:38', '疼疼热热');
INSERT INTO `tb_pushinfo` VALUES ('43', '0', '0', '0', '0', '1', '姜小熙C', '0', null, '2017-07-02 00:46:54', 'regret');
INSERT INTO `tb_pushinfo` VALUES ('44', '0', '0', '0', '0', '1', '姜小熙C', '0', null, '2017-07-02 12:27:04', '5t54t');
INSERT INTO `tb_pushinfo` VALUES ('45', '0', '0', '0', '0', '1', '姜小熙C', '0', null, '2017-07-02 12:28:13', 'rgrg');
INSERT INTO `tb_pushinfo` VALUES ('46', '0', '0', '0', '0', '1', '姜小熙C', '0', null, '2017-07-02 12:29:11', 'fregre');
INSERT INTO `tb_pushinfo` VALUES ('47', '0', '0', '0', '0', '1', '姜小熙C', '0', null, '2017-07-02 12:40:56', 'regtg');

-- ----------------------------
-- Table structure for tb_turn
-- ----------------------------
DROP TABLE IF EXISTS `tb_turn`;
CREATE TABLE `tb_turn` (
  `turnInfoId` bigint(20) NOT NULL AUTO_INCREMENT,
  `firstWbId` bigint(20) DEFAULT NULL,
  `lastWbId` bigint(20) DEFAULT NULL,
  `messageId` bigint(20) DEFAULT NULL,
  `nowWbId` bigint(20) DEFAULT NULL,
  `turnDate` datetime DEFAULT NULL,
  PRIMARY KEY (`turnInfoId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_turn
-- ----------------------------
INSERT INTO `tb_turn` VALUES ('1', '2', '2', '0', '6', '2017-05-06 19:37:57');
INSERT INTO `tb_turn` VALUES ('2', '5', '5', '0', '7', '2017-05-06 19:53:48');
INSERT INTO `tb_turn` VALUES ('3', '2', '2', '0', '9', '2017-05-06 20:07:57');
INSERT INTO `tb_turn` VALUES ('4', '7', '5', '0', '10', '2017-05-06 21:11:59');
INSERT INTO `tb_turn` VALUES ('5', '10', '5', '0', '11', '2017-05-06 21:31:31');
INSERT INTO `tb_turn` VALUES ('6', '13', '13', '0', '14', '2017-05-07 11:24:20');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `userId` bigint(20) NOT NULL AUTO_INCREMENT,
  `userAddress` longtext,
  `userClass` longtext,
  `userDescription` longtext,
  `userEmail` varchar(30) DEFAULT NULL,
  `userImage` longtext,
  `userMajor` longtext,
  `userNickName` varchar(20) DEFAULT NULL,
  `userPassword` varchar(20) DEFAULT NULL,
  `userPhone` varchar(11) DEFAULT NULL,
  `userRegisterDate` datetime DEFAULT NULL,
  `userSchool` longtext,
  `userSex` int(11) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', '江西 景德镇', '新致班', '书山有路勤为径，学海无涯苦作舟', 'jiangxiaoxi@qq.com', '/Upload-CoC/img/HeadImg/149406897169792573505.jpg', '软件工程', '姜小熙C', '123123', '15779573950', '2017-04-24 21:19:42', '华东交通大学', '1');
INSERT INTO `tb_user` VALUES ('2', '江西 景德镇', '1班', '尚好的青春都是你！', 'jiangdaxia@qq.com', '/Upload-CoC/img/HeadImg/149407030119663539827.jpg', '市场营销', '亲爱的树洞', '123123', '15779573951', '2017-04-24 22:41:23', '江西农业大学', '2');
INSERT INTO `tb_user` VALUES ('3', '北京 朝阳', '2班', '北京的雾霾可真严重啊！', 'maomi@qq.com', '/Upload-CoC/img/HeadImg/149407121164415961688.jpg', '国际经融', '不愿透露姓名的猫', '123123', '15779573952', '2017-05-06 19:44:07', '北京大学', '2');
INSERT INTO `tb_user` VALUES ('4', '江苏 南京', '', '长大后我开始明白 为什么跑得比别人快 飞得比别人高', 'mama@qq.com', '/Upload-CoC/img/HeadImg/149407222238923146430.jpg', '', '听妈妈的话', '123123', '15779573953', '2017-05-06 20:03:27', '南京大学', '1');
INSERT INTO `tb_user` VALUES ('5', '上海 浦东新', '', '你是我不愿醒来的梦 愿我毕生孤独 爱你如初', 'kaola@qq.com', '/Upload-CoC/img/HeadImg/149407711280210365269.jpg', '', '不爱睡觉的考拉', '123123', '15779573954', '2017-05-06 21:13:55', '上海交通大学', '1');

-- ----------------------------
-- Table structure for tb_useradvicenum
-- ----------------------------
DROP TABLE IF EXISTS `tb_useradvicenum`;
CREATE TABLE `tb_useradvicenum` (
  `adviceId` bigint(20) NOT NULL AUTO_INCREMENT,
  `attentionNum` bigint(20) DEFAULT NULL,
  `fansNum` bigint(20) DEFAULT NULL,
  `userId` bigint(20) NOT NULL,
  `userNickName` varchar(20) DEFAULT NULL,
  `wbNum` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`adviceId`),
  UNIQUE KEY `UK_es1j07jywdq8856et2h7eo6q3` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_useradvicenum
-- ----------------------------
INSERT INTO `tb_useradvicenum` VALUES ('1', '3', '0', '1', '姜小熙C', '23');
INSERT INTO `tb_useradvicenum` VALUES ('2', '0', '2', '2', '姜大侠你好', '6');
INSERT INTO `tb_useradvicenum` VALUES ('3', '1', '2', '3', '不愿透露姓名的周杰伦', '2');
INSERT INTO `tb_useradvicenum` VALUES ('4', '1', '2', '4', '听妈妈的话', '2');
INSERT INTO `tb_useradvicenum` VALUES ('5', '1', '1', '5', '不爱睡觉的考拉', '2');
