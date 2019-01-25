-- MySQL dump 10.13  Distrib 5.7.24, for osx10.13 (x86_64)
--
-- Host: localhost    Database: base_web
-- ------------------------------------------------------
-- Server version	5.7.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `sys_area`
--

DROP TABLE IF EXISTS `sys_area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_area` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `parent_id` varchar(64) NOT NULL COMMENT '父级编号',
  `parent_ids` varchar(2000) NOT NULL COMMENT '所有父级编号',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `sort` decimal(10,0) NOT NULL COMMENT '排序',
  `code` varchar(100) DEFAULT NULL COMMENT '区域编码',
  `type` char(1) DEFAULT NULL COMMENT '区域类型',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_area_parent_id` (`parent_id`),
  KEY `sys_area_del_flag` (`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='区域表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_area`
--

LOCK TABLES `sys_area` WRITE;
/*!40000 ALTER TABLE `sys_area` DISABLE KEYS */;
INSERT INTO `sys_area` VALUES ('1','0','0,','中国',10,'100000','1','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('2','1','0,1,','山东省',20,'110000','2','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('3','2','0,1,2,','济南市',30,'110101','3','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('4','3','0,1,2,3,','历城区',40,'110102','4','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('5','3','0,1,2,3,','历下区',50,'110104','4','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('6','3','0,1,2,3,','高新区',60,'110105','4','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0');
/*!40000 ALTER TABLE `sys_area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dict`
--

DROP TABLE IF EXISTS `sys_dict`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_dict` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `value` varchar(100) NOT NULL COMMENT '数据值',
  `label` varchar(100) NOT NULL COMMENT '标签名',
  `type` varchar(100) NOT NULL COMMENT '类型',
  `description` varchar(100) NOT NULL COMMENT '描述',
  `sort` decimal(10,0) NOT NULL COMMENT '排序（升序）',
  `parent_id` varchar(64) DEFAULT '0' COMMENT '父级编号',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_dict_value` (`value`),
  KEY `sys_dict_label` (`label`),
  KEY `sys_dict_del_flag` (`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict`
--

LOCK TABLES `sys_dict` WRITE;
/*!40000 ALTER TABLE `sys_dict` DISABLE KEYS */;
INSERT INTO `sys_dict` VALUES ('1','0','正常','del_flag','删除标记',10,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('10','yellow','黄色','color','颜色值',40,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('100','java.util.Date','Date','gen_java_type','Java类型',50,'0','1','2013-10-28 00:00:00','1','2013-10-28 00:00:00',NULL,'1'),('101','com.thinkgem.jeesite.modules.sys.entity.User','User','gen_java_type','Java类型',60,'0','1','2013-10-28 00:00:00','1','2013-10-28 00:00:00',NULL,'1'),('102','com.thinkgem.jeesite.modules.sys.entity.Office','Office','gen_java_type','Java类型',70,'0','1','2013-10-28 00:00:00','1','2013-10-28 00:00:00',NULL,'1'),('103','com.thinkgem.jeesite.modules.sys.entity.Area','Area','gen_java_type','Java类型',80,'0','1','2013-10-28 00:00:00','1','2013-10-28 00:00:00',NULL,'1'),('104','Custom','Custom','gen_java_type','Java类型',90,'0','1','2013-10-28 00:00:00','1','2013-10-28 00:00:00',NULL,'1'),('105','1','会议通告','oa_notify_type','通知通告类型',10,'0','1','2013-11-08 00:00:00','1','2013-11-08 00:00:00',NULL,'0'),('106','2','奖惩通告','oa_notify_type','通知通告类型',20,'0','1','2013-11-08 00:00:00','1','2013-11-08 00:00:00',NULL,'0'),('107','3','活动通告','oa_notify_type','通知通告类型',30,'0','1','2013-11-08 00:00:00','1','2013-11-08 00:00:00',NULL,'0'),('108','0','草稿','oa_notify_status','通知通告状态',10,'0','1','2013-11-08 00:00:00','1','2013-11-08 00:00:00',NULL,'0'),('109','1','发布','oa_notify_status','通知通告状态',20,'0','1','2013-11-08 00:00:00','1','2013-11-08 00:00:00',NULL,'0'),('11','orange','橙色','color','颜色值',50,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('110','0','未读','oa_notify_read','通知通告状态',10,'0','1','2013-11-08 00:00:00','1','2013-11-08 00:00:00',NULL,'0'),('111','1','已读','oa_notify_read','通知通告状态',20,'0','1','2013-11-08 00:00:00','1','2013-11-08 00:00:00',NULL,'0'),('12','default','默认主题','theme','主题方案',10,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('13','cerulean','天蓝主题','theme','主题方案',20,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('14','readable','橙色主题','theme','主题方案',30,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('15','united','红色主题','theme','主题方案',40,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('16','flat','Flat主题','theme','主题方案',60,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('17','1','国家','sys_area_type','区域类型',10,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('18','2','省份、直辖市','sys_area_type','区域类型',20,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('19','3','地市','sys_area_type','区域类型',30,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('2','1','删除','del_flag','删除标记',20,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('20','4','区县','sys_area_type','区域类型',40,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('21','1','公司','sys_office_type','机构类型',60,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('22','2','部门','sys_office_type','机构类型',70,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('23','3','小组','sys_office_type','机构类型',80,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('24','4','其它','sys_office_type','机构类型',90,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('25','1','综合部','sys_office_common','快捷通用部门',30,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('26','2','开发部','sys_office_common','快捷通用部门',40,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('27','3','人力部','sys_office_common','快捷通用部门',50,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('28','1','一级','sys_office_grade','机构等级',10,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('29','2','二级','sys_office_grade','机构等级',20,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('3','1','显示','show_hide','显示/隐藏',10,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('30','3','三级','sys_office_grade','机构等级',30,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('31','4','四级','sys_office_grade','机构等级',40,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('32','1','所有数据','sys_data_scope','数据范围',10,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('33','2','所在公司及以下数据','sys_data_scope','数据范围',20,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('34','3','所在公司数据','sys_data_scope','数据范围',30,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('35','4','所在部门及以下数据','sys_data_scope','数据范围',40,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('36','5','所在部门数据','sys_data_scope','数据范围',50,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('37','8','仅本人数据','sys_data_scope','数据范围',90,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('38','9','按明细设置','sys_data_scope','数据范围',100,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('39','1','系统管理','sys_user_type','用户类型',10,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('4','0','隐藏','show_hide','显示/隐藏',20,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('40','2','部门经理','sys_user_type','用户类型',20,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('41','3','普通用户','sys_user_type','用户类型',30,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('42','basic','基础主题','cms_theme','站点主题',10,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('43','blue','蓝色主题','cms_theme','站点主题',20,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'1'),('44','red','红色主题','cms_theme','站点主题',30,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'1'),('45','article','文章模型','cms_module','栏目模型',10,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('46','picture','图片模型','cms_module','栏目模型',20,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'1'),('47','download','下载模型','cms_module','栏目模型',30,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'1'),('48','link','链接模型','cms_module','栏目模型',40,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('49','special','专题模型','cms_module','栏目模型',50,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'1'),('5','1','是','yes_no','是/否',10,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('50','0','默认展现方式','cms_show_modes','展现方式',10,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('51','1','首栏目内容列表','cms_show_modes','展现方式',20,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('52','2','栏目第一条内容','cms_show_modes','展现方式',30,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('53','0','发布','cms_del_flag','内容状态',10,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('54','1','删除','cms_del_flag','内容状态',20,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('55','2','审核','cms_del_flag','内容状态',15,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('56','1','首页焦点图','cms_posid','推荐位',10,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('57','2','栏目页文章推荐','cms_posid','推荐位',20,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('58','1','咨询','cms_guestbook','留言板分类',10,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('59','2','建议','cms_guestbook','留言板分类',20,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('6','0','否','yes_no','是/否',20,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('60','3','投诉','cms_guestbook','留言板分类',30,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('61','4','其它','cms_guestbook','留言板分类',40,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('62','1','公休','oa_leave_type','请假类型',10,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('63','2','病假','oa_leave_type','请假类型',20,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('64','3','事假','oa_leave_type','请假类型',30,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('65','4','调休','oa_leave_type','请假类型',40,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('66','5','婚假','oa_leave_type','请假类型',60,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('67','1','接入日志','sys_log_type','日志类型',30,'0','1','2013-06-03 00:00:00','1','2013-06-03 00:00:00',NULL,'0'),('68','2','异常日志','sys_log_type','日志类型',40,'0','1','2013-06-03 00:00:00','1','2013-06-03 00:00:00',NULL,'0'),('69','leave','请假流程','act_type','流程类型',10,'0','1','2013-06-03 00:00:00','1','2013-06-03 00:00:00',NULL,'0'),('7','red','红色','color','颜色值',10,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('70','test_audit','审批测试流程','act_type','流程类型',20,'0','1','2013-06-03 00:00:00','1','2013-06-03 00:00:00',NULL,'0'),('71','1','分类1','act_category','流程分类',10,'0','1','2013-06-03 00:00:00','1','2013-06-03 00:00:00',NULL,'0'),('72','2','分类2','act_category','流程分类',20,'0','1','2013-06-03 00:00:00','1','2013-06-03 00:00:00',NULL,'0'),('73','crud','增删改查','gen_category','代码生成分类',10,'0','1','2013-10-28 00:00:00','1','2013-10-28 00:00:00',NULL,'1'),('74','crud_many','增删改查（包含从表）','gen_category','代码生成分类',20,'0','1','2013-10-28 00:00:00','1','2013-10-28 00:00:00',NULL,'1'),('75','tree','树结构','gen_category','代码生成分类',30,'0','1','2013-10-28 00:00:00','1','2013-10-28 00:00:00',NULL,'1'),('76','=','=','gen_query_type','查询方式',10,'0','1','2013-10-28 00:00:00','1','2013-10-28 00:00:00',NULL,'1'),('77','!=','!=','gen_query_type','查询方式',20,'0','1','2013-10-28 00:00:00','1','2013-10-28 00:00:00',NULL,'1'),('78','&gt;','&gt;','gen_query_type','查询方式',30,'0','1','2013-10-28 00:00:00','1','2013-10-28 00:00:00',NULL,'1'),('79','&lt;','&lt;','gen_query_type','查询方式',40,'0','1','2013-10-28 00:00:00','1','2013-10-28 00:00:00',NULL,'1'),('8','green','绿色','color','颜色值',20,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('80','between','Between','gen_query_type','查询方式',50,'0','1','2013-10-28 00:00:00','1','2013-10-28 00:00:00',NULL,'1'),('81','like','Like','gen_query_type','查询方式',60,'0','1','2013-10-28 00:00:00','1','2013-10-28 00:00:00',NULL,'1'),('82','left_like','Left Like','gen_query_type','查询方式',70,'0','1','2013-10-28 00:00:00','1','2013-10-28 00:00:00',NULL,'1'),('83','right_like','Right Like','gen_query_type','查询方式',80,'0','1','2013-10-28 00:00:00','1','2013-10-28 00:00:00',NULL,'1'),('84','input','文本框','gen_show_type','字段生成方案',10,'0','1','2013-10-28 00:00:00','1','2013-10-28 00:00:00',NULL,'1'),('85','textarea','文本域','gen_show_type','字段生成方案',20,'0','1','2013-10-28 00:00:00','1','2013-10-28 00:00:00',NULL,'1'),('86','select','下拉框','gen_show_type','字段生成方案',30,'0','1','2013-10-28 00:00:00','1','2013-10-28 00:00:00',NULL,'1'),('87','checkbox','复选框','gen_show_type','字段生成方案',40,'0','1','2013-10-28 00:00:00','1','2013-10-28 00:00:00',NULL,'1'),('88','radiobox','单选框','gen_show_type','字段生成方案',50,'0','1','2013-10-28 00:00:00','1','2013-10-28 00:00:00',NULL,'1'),('89','dateselect','日期选择','gen_show_type','字段生成方案',60,'0','1','2013-10-28 00:00:00','1','2013-10-28 00:00:00',NULL,'1'),('9','blue','蓝色','color','颜色值',30,'0','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('90','userselect','人员选择','gen_show_type','字段生成方案',70,'0','1','2013-10-28 00:00:00','1','2013-10-28 00:00:00',NULL,'1'),('91','officeselect','部门选择','gen_show_type','字段生成方案',80,'0','1','2013-10-28 00:00:00','1','2013-10-28 00:00:00',NULL,'1'),('92','areaselect','区域选择','gen_show_type','字段生成方案',90,'0','1','2013-10-28 00:00:00','1','2013-10-28 00:00:00',NULL,'1'),('93','String','String','gen_java_type','Java类型',10,'0','1','2013-10-28 00:00:00','1','2013-10-28 00:00:00',NULL,'1'),('94','Long','Long','gen_java_type','Java类型',20,'0','1','2013-10-28 00:00:00','1','2013-10-28 00:00:00',NULL,'1'),('95','dao','仅持久层','gen_category','代码生成分类',40,'0','1','2013-10-28 00:00:00','1','2013-10-28 00:00:00',NULL,'1'),('96','1','男','sex','性别',10,'0','1','2013-10-28 00:00:00','1','2013-10-28 00:00:00',NULL,'0'),('97','2','女','sex','性别',20,'0','1','2013-10-28 00:00:00','1','2013-10-28 00:00:00',NULL,'0'),('98','Integer','Integer','gen_java_type','Java类型',30,'0','1','2013-10-28 00:00:00','1','2013-10-28 00:00:00',NULL,'1'),('99','Double','Double','gen_java_type','Java类型',40,'0','1','2013-10-28 00:00:00','1','2013-10-28 00:00:00',NULL,'1');
/*!40000 ALTER TABLE `sys_dict` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_log`
--

DROP TABLE IF EXISTS `sys_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_log` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `type` char(1) DEFAULT '1' COMMENT '日志类型',
  `title` varchar(255) DEFAULT '' COMMENT '日志标题',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `remote_addr` varchar(255) DEFAULT NULL COMMENT '操作IP地址',
  `user_agent` varchar(255) DEFAULT NULL COMMENT '用户代理',
  `request_uri` varchar(255) DEFAULT NULL COMMENT '请求URI',
  `method` varchar(5) DEFAULT NULL COMMENT '操作方式',
  `params` text COMMENT '操作提交的数据',
  `exception` text COMMENT '异常信息',
  PRIMARY KEY (`id`),
  KEY `sys_log_create_by` (`create_by`),
  KEY `sys_log_request_uri` (`request_uri`),
  KEY `sys_log_type` (`type`),
  KEY `sys_log_create_date` (`create_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_log`
--

LOCK TABLES `sys_log` WRITE;
/*!40000 ALTER TABLE `sys_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_menu` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `parent_id` varchar(64) NOT NULL COMMENT '父级编号',
  `parent_ids` varchar(2000) NOT NULL COMMENT '所有父级编号',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `sort` decimal(10,0) NOT NULL COMMENT '排序',
  `href` varchar(2000) DEFAULT NULL COMMENT '链接',
  `target` varchar(20) DEFAULT NULL COMMENT '目标',
  `icon` varchar(100) DEFAULT NULL COMMENT '图标',
  `is_show` char(1) NOT NULL COMMENT '是否在菜单中显示',
  `permission` varchar(200) DEFAULT NULL COMMENT '权限标识',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_menu_parent_id` (`parent_id`),
  KEY `sys_menu_del_flag` (`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` VALUES ('1','0','0,','功能菜单',0,NULL,NULL,NULL,'1',NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('10','3','0,1,2,3,','字典管理',60,'/sys/dict/',NULL,'th-list','1',NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('11','10','0,1,2,3,10,','查看',30,NULL,NULL,NULL,'0','sys:dict:view','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('12','10','0,1,2,3,10,','修改',40,NULL,NULL,NULL,'0','sys:dict:edit','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('13','2','0,1,2,','机构用户',970,NULL,NULL,NULL,'1',NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('14','13','0,1,2,13,','区域管理',50,'/sys/area/',NULL,'th','1',NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('15','14','0,1,2,13,14,','查看',30,NULL,NULL,NULL,'0','sys:area:view','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('16','14','0,1,2,13,14,','修改',40,NULL,NULL,NULL,'0','sys:area:edit','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('17','13','0,1,2,13,','机构管理',40,'/sys/office/',NULL,'th-large','1',NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('18','17','0,1,2,13,17,','查看',30,NULL,NULL,NULL,'0','sys:office:view','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('19','17','0,1,2,13,17,','修改',40,NULL,NULL,NULL,'0','sys:office:edit','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('2','1','0,1,','系统设置',900,NULL,NULL,NULL,'1',NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('20','13','0,1,2,13,','用户管理',30,'/sys/user/index',NULL,'user','1',NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('21','20','0,1,2,13,20,','查看',30,NULL,NULL,NULL,'0','sys:user:view','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('22','20','0,1,2,13,20,','修改',40,NULL,NULL,NULL,'0','sys:user:edit','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('23','2','0,1,2,','关于帮助',990,NULL,NULL,NULL,'0',NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('24','23','0,1,2,23','官方首页',30,'http://jeesite.com','_blank',NULL,'0',NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('25','23','0,1,2,23','项目支持',50,'http://jeesite.com/donation.html','_blank',NULL,'0',NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'1'),('26','23','0,1,2,23','论坛交流',80,'http://bbs.jeesite.com','_blank',NULL,'0',NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'1'),('27','1','0,1,','我的面板',100,NULL,NULL,NULL,'1',NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('28','27','0,1,27,','个人信息',30,NULL,NULL,NULL,'1',NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('29','28','0,1,27,28,','个人信息',30,'/sys/user/info',NULL,'user','1',NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('3','2','0,1,2,','系统设置',980,NULL,NULL,NULL,'1',NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('30','28','0,1,27,28,','修改密码',40,'/sys/user/modifyPwd',NULL,'lock','1',NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('31','1','0,1,','内容管理',500,NULL,NULL,NULL,'1',NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('32','31','0,1,31,','栏目设置',990,NULL,NULL,NULL,'1',NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('33','32','0,1,31,32','栏目管理',30,'/cms/category/',NULL,'align-justify','1',NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('34','33','0,1,31,32,33,','查看',30,NULL,NULL,NULL,'0','cms:category:view','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('35','33','0,1,31,32,33,','修改',40,NULL,NULL,NULL,'0','cms:category:edit','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('36','32','0,1,31,32','站点设置',40,'/cms/site/',NULL,'certificate','1',NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('37','36','0,1,31,32,36,','查看',30,NULL,NULL,NULL,'0','cms:site:view','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('38','36','0,1,31,32,36,','修改',40,NULL,NULL,NULL,'0','cms:site:edit','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('39','32','0,1,31,32','切换站点',50,'/cms/site/select',NULL,'retweet','1','cms:site:select','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('4','3','0,1,2,3,','菜单管理',30,'/sys/menu/',NULL,'list-alt','1',NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('40','31','0,1,31,','内容管理',500,NULL,NULL,NULL,'1','cms:view','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('41','40','0,1,31,40,','内容发布',30,'/cms/',NULL,'briefcase','1',NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('42','41','0,1,31,40,41,','文章模型',40,'/cms/article/',NULL,'file','0',NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('43','42','0,1,31,40,41,42,','查看',30,NULL,NULL,NULL,'0','cms:article:view','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('44','42','0,1,31,40,41,42,','修改',40,NULL,NULL,NULL,'0','cms:article:edit','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('45','42','0,1,31,40,41,42,','审核',50,NULL,NULL,NULL,'0','cms:article:audit','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('46','41','0,1,31,40,41,','链接模型',60,'/cms/link/',NULL,'random','0',NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('47','46','0,1,31,40,41,46,','查看',30,NULL,NULL,NULL,'0','cms:link:view','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('48','46','0,1,31,40,41,46,','修改',40,NULL,NULL,NULL,'0','cms:link:edit','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('49','46','0,1,31,40,41,46,','审核',50,NULL,NULL,NULL,'0','cms:link:audit','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('5','4','0,1,2,3,4,','查看',30,NULL,NULL,NULL,'0','sys:menu:view','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('50','40','0,1,31,40,','评论管理',40,'/cms/comment/?status=2',NULL,'comment','1',NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('51','50','0,1,31,40,50,','查看',30,NULL,NULL,NULL,'0','cms:comment:view','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('52','50','0,1,31,40,50,','审核',40,NULL,NULL,NULL,'0','cms:comment:edit','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('53','40','0,1,31,40,','公共留言',80,'/cms/guestbook/?status=2',NULL,'glass','1',NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('54','53','0,1,31,40,53,','查看',30,NULL,NULL,NULL,'0','cms:guestbook:view','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('55','53','0,1,31,40,53,','审核',40,NULL,NULL,NULL,'0','cms:guestbook:edit','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('56','71','0,1,27,71,','文件管理',90,'/../static/ckfinder/ckfinder.html',NULL,'folder-open','1',NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('57','56','0,1,27,40,56,','查看',30,NULL,NULL,NULL,'0','cms:ckfinder:view','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('58','56','0,1,27,40,56,','上传',40,NULL,NULL,NULL,'0','cms:ckfinder:upload','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('59','56','0,1,27,40,56,','修改',50,NULL,NULL,NULL,'0','cms:ckfinder:edit','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('6','4','0,1,2,3,4,','修改',40,NULL,NULL,NULL,'0','sys:menu:edit','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('60','31','0,1,31,','统计分析',600,NULL,NULL,NULL,'1',NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('61','60','0,1,31,60,','信息量统计',30,'/cms/stats/article',NULL,'tasks','1','cms:stats:article','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('62','1','0,1,','在线办公',200,NULL,NULL,NULL,'1',NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('63','62','0,1,62,','个人办公',30,NULL,NULL,NULL,'1',NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('64','63','0,1,62,63,','请假办理',300,'/oa/leave',NULL,'leaf','0',NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('65','64','0,1,62,63,64,','查看',30,NULL,NULL,NULL,'0','oa:leave:view','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('66','64','0,1,62,63,64,','修改',40,NULL,NULL,NULL,'0','oa:leave:edit','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('67','2','0,1,2,','日志查询',985,NULL,NULL,NULL,'1',NULL,'1','2013-06-03 00:00:00','1','2013-06-03 00:00:00',NULL,'0'),('68','67','0,1,2,67,','日志查询',30,'/sys/log',NULL,'pencil','1','sys:log:view','1','2013-06-03 00:00:00','1','2013-06-03 00:00:00',NULL,'0'),('69','62','0,1,62,','流程管理',300,NULL,NULL,NULL,'1',NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('7','3','0,1,2,3,','角色管理',50,'/sys/role/',NULL,'lock','1',NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('70','69','0,1,62,69,','流程管理',50,'/act/process',NULL,'road','1','act:process:edit','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('71','27','0,1,27,','文件管理',90,NULL,NULL,NULL,'1',NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('72','69','0,1,62,69,','模型管理',100,'/act/model',NULL,'road','1','act:model:edit','1','2013-09-20 00:00:00','1','2013-09-20 00:00:00',NULL,'0'),('73','63','0,1,62,63,','我的任务',50,'/act/task/todo/',NULL,'tasks','1',NULL,'1','2013-09-24 00:00:00','1','2013-09-24 00:00:00',NULL,'0'),('74','63','0,1,62,63,','审批测试',100,'/oa/testAudit',NULL,NULL,'1','oa:testAudit:view,oa:testAudit:edit','1','2013-09-24 00:00:00','1','2013-09-24 00:00:00',NULL,'0'),('75','1','0,1,','在线演示',3000,NULL,NULL,NULL,'1',NULL,'1','2013-10-08 00:00:00','1','2013-10-08 00:00:00',NULL,'1'),('79','1','0,1,','代码生成',5000,NULL,NULL,NULL,'1',NULL,'1','2013-10-16 00:00:00','1','2013-10-16 00:00:00',NULL,'0'),('8','7','0,1,2,3,7,','查看',30,NULL,NULL,NULL,'0','sys:role:view','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('80','79','0,1,79,','代码生成',50,NULL,NULL,NULL,'1',NULL,'1','2013-10-16 00:00:00','1','2013-10-16 00:00:00',NULL,'0'),('81','80','0,1,79,80,','生成方案配置',30,'/gen/genScheme',NULL,NULL,'1','gen:genScheme:view,gen:genScheme:edit','1','2013-10-16 00:00:00','1','2013-10-16 00:00:00',NULL,'0'),('82','80','0,1,79,80,','业务表配置',20,'/gen/genTable',NULL,NULL,'1','gen:genTable:view,gen:genTable:edit,gen:genTableColumn:view,gen:genTableColumn:edit','1','2013-10-16 00:00:00','1','2013-10-16 00:00:00',NULL,'0'),('83','80','0,1,79,80,','代码模板管理',90,'/gen/genTemplate',NULL,NULL,'1','gen:genTemplate:view,gen:genTemplate:edit','1','2013-10-16 00:00:00','1','2013-10-16 00:00:00',NULL,'1'),('84','67','0,1,2,67,','连接池监视',40,'/../druid',NULL,NULL,'1',NULL,'1','2013-10-18 00:00:00','1','2013-10-18 00:00:00',NULL,'0'),('85','76','0,1,75,76,','行政区域',80,'/../static/map/map-city.html',NULL,NULL,'1',NULL,'1','2013-10-22 00:00:00','1','2013-10-22 00:00:00',NULL,'0'),('86','75','0,1,75,','组件演示',50,NULL,NULL,NULL,'1',NULL,'1','2013-10-22 00:00:00','1','2013-10-22 00:00:00',NULL,'1'),('87','86','0,1,75,86,','组件演示',30,'/test/test/form',NULL,NULL,'1','test:test:view,test:test:edit','1','2013-10-22 00:00:00','1','2013-10-22 00:00:00',NULL,'1'),('88','62','0,1,62,','通知通告',20,'','','','1','','1','2013-11-08 00:00:00','1','2013-11-08 00:00:00',NULL,'0'),('89','88','0,1,62,88,','我的通告',30,'/oa/oaNotify/self','','','1','','1','2013-11-08 00:00:00','1','2013-11-08 00:00:00',NULL,'0'),('9','7','0,1,2,3,7,','修改',40,NULL,NULL,NULL,'0','sys:role:edit','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('90','88','0,1,62,88,','通告管理',50,'/oa/oaNotify','','','1','oa:oaNotify:view,oa:oaNotify:edit','1','2013-11-08 00:00:00','1','2013-11-08 00:00:00',NULL,'0');
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_office`
--

DROP TABLE IF EXISTS `sys_office`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_office` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `parent_id` varchar(64) NOT NULL COMMENT '父级编号',
  `parent_ids` varchar(2000) NOT NULL COMMENT '所有父级编号',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `sort` decimal(10,0) NOT NULL COMMENT '排序',
  `area_id` varchar(64) NOT NULL COMMENT '归属区域',
  `code` varchar(100) DEFAULT NULL COMMENT '区域编码',
  `type` char(1) NOT NULL COMMENT '机构类型',
  `grade` char(1) NOT NULL COMMENT '机构等级',
  `address` varchar(255) DEFAULT NULL COMMENT '联系地址',
  `zip_code` varchar(100) DEFAULT NULL COMMENT '邮政编码',
  `master` varchar(100) DEFAULT NULL COMMENT '负责人',
  `phone` varchar(200) DEFAULT NULL COMMENT '电话',
  `fax` varchar(200) DEFAULT NULL COMMENT '传真',
  `email` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `USEABLE` varchar(64) DEFAULT NULL COMMENT '是否启用',
  `PRIMARY_PERSON` varchar(64) DEFAULT NULL COMMENT '主负责人',
  `DEPUTY_PERSON` varchar(64) DEFAULT NULL COMMENT '副负责人',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_office_parent_id` (`parent_id`),
  KEY `sys_office_del_flag` (`del_flag`),
  KEY `sys_office_type` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='机构表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_office`
--

LOCK TABLES `sys_office` WRITE;
/*!40000 ALTER TABLE `sys_office` DISABLE KEYS */;
INSERT INTO `sys_office` VALUES ('1','0','0,','山东省总公司',10,'2','100000','1','1',NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('10','7','0,1,7,','市场部',30,'3','200003','2','2',NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('11','7','0,1,7,','技术部',40,'3','200004','2','2',NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('12','7','0,1,7,','历城区分公司',0,'4','201000','1','3',NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('13','12','0,1,7,12,','公司领导',10,'4','201001','2','3',NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('14','12','0,1,7,12,','综合部',20,'4','201002','2','3',NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('15','12','0,1,7,12,','市场部',30,'4','201003','2','3',NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('16','12','0,1,7,12,','技术部',40,'4','201004','2','3',NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('17','7','0,1,7,','历下区分公司',40,'5','201010','1','3',NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('18','17','0,1,7,17,','公司领导',10,'5','201011','2','3',NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('19','17','0,1,7,17,','综合部',20,'5','201012','2','3',NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('2','1','0,1,','公司领导',10,'2','100001','2','1',NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('20','17','0,1,7,17,','市场部',30,'5','201013','2','3',NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('21','17','0,1,7,17,','技术部',40,'5','201014','2','3',NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('22','7','0,1,7,','高新区分公司',50,'6','201010','1','3',NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('23','22','0,1,7,22,','公司领导',10,'6','201011','2','3',NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('24','22','0,1,7,22,','综合部',20,'6','201012','2','3',NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('25','22','0,1,7,22,','市场部',30,'6','201013','2','3',NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('26','22','0,1,7,22,','技术部',40,'6','201014','2','3',NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('3','1','0,1,','综合部',20,'2','100002','2','1',NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('4','1','0,1,','市场部',30,'2','100003','2','1',NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('5','1','0,1,','技术部',40,'2','100004','2','1',NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('6','1','0,1,','研发部',50,'2','100005','2','1',NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('7','1','0,1,','济南市分公司',20,'3','200000','1','2',NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('8','7','0,1,7,','公司领导',10,'3','200001','2','2',NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('9','7','0,1,7,','综合部',20,'3','200002','2','2',NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,NULL,'1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0');
/*!40000 ALTER TABLE `sys_office` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `office_id` varchar(64) DEFAULT NULL COMMENT '归属机构',
  `name` varchar(100) NOT NULL COMMENT '角色名称',
  `enname` varchar(255) DEFAULT NULL COMMENT '英文名称',
  `role_type` varchar(255) DEFAULT NULL COMMENT '角色类型',
  `data_scope` char(1) DEFAULT NULL COMMENT '数据范围',
  `is_sys` varchar(64) DEFAULT NULL COMMENT '是否系统数据',
  `useable` varchar(64) DEFAULT NULL COMMENT '是否可用',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_role_del_flag` (`del_flag`),
  KEY `sys_role_enname` (`enname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES ('1','1','系统管理员','dept','assignment','1',NULL,'1','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('2','1','公司管理员','hr','assignment','2',NULL,'1','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('3','1','本公司管理员','a','assignment','3',NULL,'1','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('4','1','部门管理员','b','assignment','4',NULL,'1','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('5','1','本部门管理员','c','assignment','5',NULL,'1','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('6','1','普通用户','d','assignment','8',NULL,'1','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('7','7','济南市管理员','e','assignment','9',NULL,'1','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_menu`
--

DROP TABLE IF EXISTS `sys_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_menu` (
  `role_id` varchar(64) NOT NULL COMMENT '角色编号',
  `menu_id` varchar(64) NOT NULL COMMENT '菜单编号',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-菜单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_menu`
--

LOCK TABLES `sys_role_menu` WRITE;
/*!40000 ALTER TABLE `sys_role_menu` DISABLE KEYS */;
INSERT INTO `sys_role_menu` VALUES ('1','1'),('1','10'),('1','11'),('1','12'),('1','13'),('1','14'),('1','15'),('1','16'),('1','17'),('1','18'),('1','19'),('1','2'),('1','20'),('1','21'),('1','22'),('1','23'),('1','24'),('1','25'),('1','26'),('1','27'),('1','28'),('1','29'),('1','3'),('1','30'),('1','31'),('1','32'),('1','33'),('1','34'),('1','35'),('1','36'),('1','37'),('1','38'),('1','39'),('1','4'),('1','40'),('1','41'),('1','42'),('1','43'),('1','44'),('1','45'),('1','46'),('1','47'),('1','48'),('1','49'),('1','5'),('1','50'),('1','51'),('1','52'),('1','53'),('1','54'),('1','55'),('1','56'),('1','57'),('1','58'),('1','59'),('1','6'),('1','60'),('1','61'),('1','62'),('1','63'),('1','64'),('1','65'),('1','66'),('1','67'),('1','68'),('1','69'),('1','7'),('1','70'),('1','71'),('1','72'),('1','73'),('1','74'),('1','75'),('1','76'),('1','77'),('1','78'),('1','79'),('1','8'),('1','80'),('1','81'),('1','82'),('1','83'),('1','84'),('1','85'),('1','86'),('1','87'),('1','88'),('1','89'),('1','9'),('1','90'),('2','1'),('2','10'),('2','11'),('2','12'),('2','13'),('2','14'),('2','15'),('2','16'),('2','17'),('2','18'),('2','19'),('2','2'),('2','20'),('2','21'),('2','22'),('2','23'),('2','24'),('2','25'),('2','26'),('2','27'),('2','28'),('2','29'),('2','3'),('2','30'),('2','31'),('2','32'),('2','33'),('2','34'),('2','35'),('2','36'),('2','37'),('2','38'),('2','39'),('2','4'),('2','40'),('2','41'),('2','42'),('2','43'),('2','44'),('2','45'),('2','46'),('2','47'),('2','48'),('2','49'),('2','5'),('2','50'),('2','51'),('2','52'),('2','53'),('2','54'),('2','55'),('2','56'),('2','57'),('2','58'),('2','59'),('2','6'),('2','60'),('2','61'),('2','62'),('2','63'),('2','64'),('2','65'),('2','66'),('2','67'),('2','68'),('2','69'),('2','7'),('2','70'),('2','71'),('2','72'),('2','73'),('2','74'),('2','75'),('2','76'),('2','77'),('2','78'),('2','79'),('2','8'),('2','80'),('2','81'),('2','82'),('2','83'),('2','84'),('2','85'),('2','86'),('2','87'),('2','88'),('2','89'),('2','9'),('2','90'),('3','1'),('3','10'),('3','11'),('3','12'),('3','13'),('3','14'),('3','15'),('3','16'),('3','17'),('3','18'),('3','19'),('3','2'),('3','20'),('3','21'),('3','22'),('3','23'),('3','24'),('3','25'),('3','26'),('3','27'),('3','28'),('3','29'),('3','3'),('3','30'),('3','31'),('3','32'),('3','33'),('3','34'),('3','35'),('3','36'),('3','37'),('3','38'),('3','39'),('3','4'),('3','40'),('3','41'),('3','42'),('3','43'),('3','44'),('3','45'),('3','46'),('3','47'),('3','48'),('3','49'),('3','5'),('3','50'),('3','51'),('3','52'),('3','53'),('3','54'),('3','55'),('3','56'),('3','57'),('3','58'),('3','59'),('3','6'),('3','60'),('3','61'),('3','62'),('3','63'),('3','64'),('3','65'),('3','66'),('3','67'),('3','68'),('3','69'),('3','7'),('3','70'),('3','71'),('3','72'),('3','73'),('3','74'),('3','75'),('3','76'),('3','77'),('3','78'),('3','79'),('3','8'),('3','80'),('3','81'),('3','82'),('3','83'),('3','84'),('3','85'),('3','86'),('3','87'),('3','88'),('3','89'),('3','9'),('3','90');
/*!40000 ALTER TABLE `sys_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_office`
--

DROP TABLE IF EXISTS `sys_role_office`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_office` (
  `role_id` varchar(64) NOT NULL COMMENT '角色编号',
  `office_id` varchar(64) NOT NULL COMMENT '机构编号',
  PRIMARY KEY (`role_id`,`office_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-机构';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_office`
--

LOCK TABLES `sys_role_office` WRITE;
/*!40000 ALTER TABLE `sys_role_office` DISABLE KEYS */;
INSERT INTO `sys_role_office` VALUES ('7','10'),('7','11'),('7','12'),('7','13'),('7','14'),('7','15'),('7','16'),('7','17'),('7','18'),('7','19'),('7','20'),('7','21'),('7','22'),('7','23'),('7','24'),('7','25'),('7','26'),('7','7'),('7','8'),('7','9');
/*!40000 ALTER TABLE `sys_role_office` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `company_id` varchar(64) NOT NULL COMMENT '归属公司',
  `office_id` varchar(64) NOT NULL COMMENT '归属部门',
  `login_name` varchar(100) NOT NULL DEFAULT '' COMMENT '登录名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `no` varchar(100) DEFAULT NULL COMMENT '工号',
  `name` varchar(100) NOT NULL COMMENT '姓名',
  `email` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(200) DEFAULT NULL COMMENT '电话',
  `mobile` varchar(200) DEFAULT NULL COMMENT '手机',
  `user_type` char(1) DEFAULT NULL COMMENT '用户类型',
  `photo` varchar(1000) DEFAULT NULL COMMENT '用户头像',
  `login_ip` varchar(100) DEFAULT NULL COMMENT '最后登陆IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `login_flag` varchar(64) DEFAULT NULL COMMENT '是否可登录',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_user_office_id` (`office_id`),
  KEY `sys_user_login_name` (`login_name`),
  KEY `sys_user_company_id` (`company_id`),
  KEY `sys_user_update_date` (`update_date`),
  KEY `sys_user_del_flag` (`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES ('1','1','2','thinkgem','eeafb716f93fa090d7716749a6eefa72','0001','系统管理员','abc','8675','8675',NULL,NULL,NULL,NULL,'1','1','2013-05-27 00:00:00','1','2018-12-04 16:04:51','最高管理员','0'),('10','7','11','jn_jsb','02a3f0772fcca9f415adc990734b45c6f059c7d33ee28362c4852032','0010','济南技术部',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('11','12','13','lc_admin','02a3f0772fcca9f415adc990734b45c6f059c7d33ee28362c4852032','0011','济南历城领导',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('12','12','18','lx_admin','02a3f0772fcca9f415adc990734b45c6f059c7d33ee28362c4852032','0012','济南历下领导',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('13','22','23','gx_admin','02a3f0772fcca9f415adc990734b45c6f059c7d33ee28362c4852032','0013','济南高新领导',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('2','1','2','sd_admin','02a3f0772fcca9f415adc990734b45c6f059c7d33ee28362c4852032','0002','管理员',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('3','1','3','sd_zhb','02a3f0772fcca9f415adc990734b45c6f059c7d33ee28362c4852032','0003','综合部',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('4','1','4','sd_scb','02a3f0772fcca9f415adc990734b45c6f059c7d33ee28362c4852032','0004','市场部',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('5','1','5','sd_jsb','02a3f0772fcca9f415adc990734b45c6f059c7d33ee28362c4852032','0005','技术部',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('6','1','6','sd_yfb','02a3f0772fcca9f415adc990734b45c6f059c7d33ee28362c4852032','0006','研发部',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('7','7','8','jn_admin','02a3f0772fcca9f415adc990734b45c6f059c7d33ee28362c4852032','0007','济南领导',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('8','7','9','jn_zhb','02a3f0772fcca9f415adc990734b45c6f059c7d33ee28362c4852032','0008','济南综合部',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0'),('9','7','10','jn_scb','02a3f0772fcca9f415adc990734b45c6f059c7d33ee28362c4852032','0009','济南市场部',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','1','2013-05-27 00:00:00','1','2013-05-27 00:00:00',NULL,'0');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_role` (
  `user_id` varchar(64) NOT NULL COMMENT '用户编号',
  `role_id` varchar(64) NOT NULL COMMENT '角色编号',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户-角色';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_role`
--

LOCK TABLES `sys_user_role` WRITE;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` VALUES ('1','1'),('1','2'),('10','2'),('11','3'),('12','4'),('13','5'),('14','6'),('2','1'),('3','2'),('4','3'),('5','4'),('6','5'),('7','2'),('7','7'),('8','2'),('9','1');
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-25 13:30:45
