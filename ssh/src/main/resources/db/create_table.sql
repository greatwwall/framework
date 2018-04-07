/*==============================================================*/
/* DBMS name:      MYSQL Version 5.7                            */
/* Created on:     2016/7/15 12:54:32                           */
/*==============================================================*/

/*==============================================================*/
/* Table: crm_user                                              */
/*==============================================================*/
drop table if exists crm_user;
create table crm_user  (
   user_id              int(10)                      not null,
   uname                varchar(20),
   email                varchar(20),
   pwd                  varchar(200),
   primary key (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: crm_role                                              */
/*==============================================================*/
drop table if exists crm_role;
create table crm_role  (
   role_id              int(10)                      not null,
   role_name            varchar(20),
   primary key (role_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: crm_module                                            */
/*==============================================================*/
drop table if exists crm_module;
create table crm_module  (
   module_id            int(10)                      not null,
   module_name          varchar(20),
   module_url           varchar(100),
   primary key (module_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: crm_menu                                              */
/*==============================================================*/
drop table if exists crm_menu;
create table crm_menu  (
   menu_id              int(10)                      not null,
   menu_name            varchar(20),
   parent_id            int(10),
   menu_url             varchar(100),
   prompt               varchar(100),
   menu_level           int(1),
   primary key (menu_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: crm_role_menu                                         */
/*==============================================================*/
drop table if exists crm_role_menu;
create table crm_role_menu  (
   role_id              int(10)                      not null,
   menu_id              int(10)                      not null,
   primary key (role_id, menu_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: crm_role_module                                       */
/*==============================================================*/
drop table if exists crm_role_module;
create table crm_role_module  (
   rm_id                int(10)                      not null,
   role_id              int(10),
   module_id            int(10),
   power_code           int(4),
   primary key (rm_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: crm_user_role                                         */
/*==============================================================*/
drop table if exists crm_user_role;
create table crm_user_role  (
   role_id              int(10)                      not null,
   user_id              int(10)                      not null,
   primary key (role_id, user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Add constraint                                               */
/*==============================================================*/
alter table crm_menu 
   add constraint menu_parent_fk foreign key (parent_id)
      references crm_menu (menu_id);

alter table crm_role_menu
   add constraint role_menu_menufk foreign key (menu_id)
      references crm_menu (menu_id);

alter table crm_role_menu
   add constraint role_menu_rolefk foreign key (role_id)
      references crm_role (role_id);

alter table crm_role_module
   add constraint rm_role_fk foreign key (role_id)
      references crm_role (role_id);

alter table crm_role_module
   add constraint role_module_module_fk foreign key (module_id)
      references crm_module (module_id);

alter table crm_user_role
   add constraint user_fk foreign key (user_id)
      references crm_user (user_id);

alter table crm_user_role
   add constraint user_role_roleFk foreign key (role_id)
      references crm_role (role_id);