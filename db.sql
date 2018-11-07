
drop table if exists sys_user;

/*==============================================================*/
/* Table: sys_user                                           */
/*==============================================================*/
create table sys_user
(
   id                   int unsigned not null auto_increment,
   office_id            int comment '机构Id',
   username             varchar(255) not null comment '登录账号',
   password             varchar(255) not null comment '登录密码',
   user_type            tinyint comment '用户类型（管理员， 普通用户）',
   email                varchar(255) comment '电子邮件',
   login_ip             varchar(255) comment '登录地址',
   login_date           datetime comment '登录时间',
   dispaly_name         varchar(64) comment '用户前端展示的名字',
   no                   varchar(64) comment '工号',
   telphone             varchar(21) comment '电话',
   mobile_phone         varchar(21) comment '手机号',
   create_by            varchar(255) comment '创建者',
   create_time          datetime comment '创建时间',
   update_by            varchar(255) comment '更新着',
   update_time          datetime comment '更新时间',
   remarks              varchar(255) comment '备注',
   del_flag             tinyint not null default 0 comment '删除标记(0.正常  -1.删除)',
   primary key (id)
)
ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='系统用户表';

alter table sys_user comment '系统用户表';


CREATE TABLE `sys_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT '' COMMENT '角色名字',
  `display_name` varchar(64) NOT NULL DEFAULT '' COMMENT '角色用户前端展示的名字',
  `description` varchar(255) DEFAULT '' COMMENT '角色描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `remarks`              varchar(255) comment '备注',
  `del_flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记 0：正常， 1：删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='系统角色表';


CREATE TABLE `sys_user_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL COMMENT '用户ID',
  `role_id` int(10) unsigned NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='用户和角色 关系表 多对多';


CREATE TABLE `sys_menu` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `parent_id` int(10) unsigned NOT NULL COMMENT '父级ID',
  `sort_order` tinyint(4) DEFAULT NULL COMMENT '排序',
  `label` varchar(64) NOT NULL DEFAULT '' COMMENT '菜单名字',
  `icon` varchar(255) DEFAULT '' COMMENT '菜单图片',
  `description` varchar(255) DEFAULT '' COMMENT '菜单描述',
  `path` varchar(255) NOT NULL DEFAULT '' COMMENT '菜单链接',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `remarks`             varchar(255) comment '备注',
  `del_flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='用户资源（菜单）表';


CREATE TABLE `sys_role_menu` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` int(10) unsigned NOT NULL COMMENT '角色ID',
  `menu_id` int(10) unsigned NOT NULL COMMENT '商品ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='角色和菜单 关系表 多对多';


