drop table if exists sys_resc;

drop table if exists snowy_sys_role;

drop table if exists snowy_sys_role_resc;

drop table if exists snowy_sys_role_user;

drop table if exists snowy_user_info;

/*==============================================================*/
/* Table: snowy_sys_resc                                              */
/*==============================================================*/
create table snowy_sys_resc
(
   resc_id              int(11) not null auto_increment comment 'id',
   resc_pid             int(11) default NULL comment '父id',
   resc_name            varchar(50) default NULL comment '对外显示名称（支持多语言情况下，使用字典参数）',
   resc_url             varchar(150) default '#' comment '访问路径（不含IP、端口、参数）',
   resc_level           int(1) default NULL comment '层级(不超过10层)',
   resc_sort            int(2) default NULL comment '排序(不超过100)',
   resc_type            char(1) default '0' comment '权限类型 默认：0 后台权限：1',
   resc_icon_name       varchar(32) default NULL,
   resc_html_id         varchar(32) default NULL comment '资源显示的ID，如果为空，则使用nav_resc_pid_resc_id进行拼接',
   resc_remark          varchar(100) default NULL comment '备注',
   create_time          datetime default NULL comment '创建时间',
   enable_status        char(1) default '0' comment '是否停用 默认：0 停用：1',
   primary key (resc_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: snowy_sys_role                                              */
/*==============================================================*/
create table snowy_sys_role
(
   role_id              int(11) not null auto_increment comment 'id',
   role_name            varchar(50) default NULL comment '名称',
   role_type            char(1) default '0' comment ' 角色类型 默认：0 后台角色：1',
   role_remark          varchar(100) default NULL comment '备注',
   role_sort            int(2) default NULL comment '排序(不超过100)',
   create_time          datetime default NULL comment '创建时间',
   enable_statue        char(1) default '0' comment '是否停用 默认：0 停用：1',
   primary key (role_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: snowy_sys_role_resc                                         */
/*==============================================================*/
create table snowy_sys_role_resc
(
   id                   int(11) not null auto_increment comment 'id',
   resc_id              int(11) comment 'id',
   role_id              int(11) comment 'id',
   primary key (id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: snowy_sys_role_user                                         */
/*==============================================================*/
create table snowy_sys_role_user
(
   id                   int(11) not null auto_increment comment 'id',
   role_id              int(11) comment 'id',
   user_id              int(11) comment 'id',
   primary key (id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: snowy_user_info                                             */
/*==============================================================*/
create table snowy_user_info
(
   user_id              int(11) not null auto_increment comment 'id',
   user_name            varchar(80) default NULL comment '登录账号',
   nick_name            varchar(50) default NULL comment '昵称',
   real_name            varchar(30) default NULL comment '姓名',
   sha_value            varchar(512) default NULL comment '随机盐值',
   sha_password         varchar(1024) default NULL comment '登录密码（盐值哈希后）',
   user_email           varchar(150) default NULL comment '个人网站',
   user_avatar          varchar(512) default NULL comment '头像路径',
   user_signature       varchar(255) default NULL comment '个性签名',
   login_status         char(1) default '0' comment '是否登录状态 默认：0 在线：1',
   user_status          int default 1 comment '用户状态 0：新注册，不可用；1：注册可用状态；2：连续登陆错误，禁止使用；3：多地异常登陆，禁止使用；9：用户被删除，禁止使用。',
   create_time          datetime default NULL comment '创建时间',
   update_time          datetime default NULL comment '更新时间',
   last_login_time      datetime default NULL comment '最后登录时间',
   last_login_ip        varchar(15) default NULL comment '最后登录IP',
   last_login_country   varchar(32) default NULL,
   last_login_province  varchar(32) default NULL,
   last_login_city      varchar(32) default NULL,
   primary key (user_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table snowy_sys_role_resc add constraint FK_Reference_1 foreign key (resc_id)
      references snowy_sys_resc (resc_id) on delete restrict on update restrict;

alter table snowy_sys_role_resc add constraint FK_Reference_2 foreign key (role_id)
      references snowy_sys_role (role_id) on delete restrict on update restrict;

alter table snowy_sys_role_user add constraint FK_Reference_3 foreign key (role_id)
      references snowy_sys_role (role_id) on delete restrict on update restrict;

alter table snowy_sys_role_user add constraint FK_Reference_4 foreign key (user_id)
      references snowy_user_info (user_id) on delete restrict on update restrict;

CREATE TABLE snowy.snowy_sys_resc
(
    resc_id int(11) PRIMARY KEY NOT NULL COMMENT 'id' AUTO_INCREMENT,
    resc_pid int(11) COMMENT '父id',
    resc_name varchar(50) COMMENT '名称',
    resc_url varchar(150) DEFAULT '#' COMMENT 'URL',
    resc_level int(1) COMMENT '层级(不超过10层)',
    resc_sort int(2) COMMENT '排序(不超过100)',
    resc_type char(1) DEFAULT '0' COMMENT '权限类型 默认：0 后台权限：1',
    resc_icon_name varchar(32),
    resc_html_id varchar(50) DEFAULT '#' COMMENT '指定的ID号，可随机生成，用于导航菜单非重设置',
    create_time datetime COMMENT '创建时间',
    enable_status char(1) DEFAULT '0' COMMENT '是否停用 默认：0 停用：1',
    remark varchar(100) COMMENT '备注'
);

INSERT INTO snowy.snowy_sys_resc (resc_id, resc_pid, resc_name, resc_url, resc_level, resc_sort, resc_type, resc_icon_name, resc_html_id, create_time, enable_status, remark) VALUES (1, -1, '系统操作菜单', '#', null, null, '0', null, '#', null, '0', null);
INSERT INTO snowy.snowy_sys_resc (resc_id, resc_pid, resc_name, resc_url, resc_level, resc_sort, resc_type, resc_icon_name, resc_html_id, create_time, enable_status, remark) VALUES (100, 1, '主页', '#', 1, 1, '0', 'glyphicon glyphicon-home', 'menu_nav_index', null, '0', null);
INSERT INTO snowy.snowy_sys_resc (resc_id, resc_pid, resc_name, resc_url, resc_level, resc_sort, resc_type, resc_icon_name, resc_html_id, create_time, enable_status, remark) VALUES (101, 1, '后台', '#', 1, 2, '0', 'glyphicon glyphicon-th-large', 'menu_nav_main', null, '0', null);
INSERT INTO snowy.snowy_sys_resc (resc_id, resc_pid, resc_name, resc_url, resc_level, resc_sort, resc_type, resc_icon_name, resc_html_id, create_time, enable_status, remark) VALUES (102, 1, '新建', '#', 1, 3, '0', 'glyphicon glyphicon-pencil', 'menu_nav_new', null, '0', null);
INSERT INTO snowy.snowy_sys_resc (resc_id, resc_pid, resc_name, resc_url, resc_level, resc_sort, resc_type, resc_icon_name, resc_html_id, create_time, enable_status, remark) VALUES (103, 1, '管理', '#', 1, 4, '0', 'glyphicon glyphicon-briefcase', 'menu_nav_manage', null, '0', null);
INSERT INTO snowy.snowy_sys_resc (resc_id, resc_pid, resc_name, resc_url, resc_level, resc_sort, resc_type, resc_icon_name, resc_html_id, create_time, enable_status, remark) VALUES (104, 1, '配置', '#', 1, 5, '0', 'glyphicon glyphicon-wrench', 'menu_nav_setting', null, '0', null);
INSERT INTO snowy.snowy_sys_resc (resc_id, resc_pid, resc_name, resc_url, resc_level, resc_sort, resc_type, resc_icon_name, resc_html_id, create_time, enable_status, remark) VALUES (105, 1, '工具', '#', 1, 6, '0', 'glyphicon glyphicon-console', 'menu_nav_devTool', null, '0', null);
INSERT INTO snowy.snowy_sys_resc (resc_id, resc_pid, resc_name, resc_url, resc_level, resc_sort, resc_type, resc_icon_name, resc_html_id, create_time, enable_status, remark) VALUES (103001, 103, '文章', '#', 2, 1, '0', null, 'menu_nav_sub_manage_article', null, '0', null);
INSERT INTO snowy.snowy_sys_resc (resc_id, resc_pid, resc_name, resc_url, resc_level, resc_sort, resc_type, resc_icon_name, resc_html_id, create_time, enable_status, remark) VALUES (103002, 103, '草稿', '#', 2, 2, '0', null, 'menu_nav_sub_manage_draft', null, '0', null);
INSERT INTO snowy.snowy_sys_resc (resc_id, resc_pid, resc_name, resc_url, resc_level, resc_sort, resc_type, resc_icon_name, resc_html_id, create_time, enable_status, remark) VALUES (103003, 103, '评论', '#', 2, 3, '0', null, 'menu_nav_sub_manage_comment', null, '0', null);
INSERT INTO snowy.snowy_sys_resc (resc_id, resc_pid, resc_name, resc_url, resc_level, resc_sort, resc_type, resc_icon_name, resc_html_id, create_time, enable_status, remark) VALUES (104001, 104, '偏好设置', '#', 2, 1, '0', null, 'menu_nav_sub_setting_preference', null, '0', '');
INSERT INTO snowy.snowy_sys_resc (resc_id, resc_pid, resc_name, resc_url, resc_level, resc_sort, resc_type, resc_icon_name, resc_html_id, create_time, enable_status, remark) VALUES (104002, 104, '其它设置', '#', 2, 2, '0', null, 'menu_nav_sub_setting_others', null, '0', null);
INSERT INTO snowy.snowy_sys_resc (resc_id, resc_pid, resc_name, resc_url, resc_level, resc_sort, resc_type, resc_icon_name, resc_html_id, create_time, enable_status, remark) VALUES (105001, 105, 'Bootstrap ICON', '/admin/page/devTool/bootstrap_icon', 2, 1, '0', null, 'menu_nav_devTool_bootstrap_icon', null, '0', null);