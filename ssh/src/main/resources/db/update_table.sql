/**
 * update CRM_USER
 */
insert into CRM_USER (user_id, uname, email, pwd) values (1, 'admin', 'admin@admin.com', 'admin');
insert into CRM_USER (user_id, uname, email, pwd) values (2, 'root', 'root@root.com', 'root');

/**
 * update CRM_MODULE
 */
insert into CRM_MODULE (module_id, module_name, module_url)
values (1, '用户管理', 'usersAction');
insert into CRM_MODULE (module_id, module_name, module_url)
values (2, '角色管理', 'roleAction');
insert into CRM_MODULE (module_id, module_name, module_url)
values (3, '菜单管理', 'menuAction');
insert into CRM_MODULE (module_id, module_name, module_url)
values (4, '销售机会管理', 'salAction');
insert into CRM_MODULE (module_id, module_name, module_url)
values (5, '客户开发计划', 'cousAction');
insert into CRM_MODULE (module_id, module_name, module_url)
values (6, '客户信息管理', 'couAction');
insert into CRM_MODULE (module_id, module_name, module_url)
values (7, '服务管理', 'serviceAction');
insert into CRM_MODULE (module_id, module_name, module_url)
values (8, '客户流失管理', 'cAction');
insert into CRM_MODULE (module_id, module_name, module_url)
values (9, '模块管理', 'roleModuleAction');

/**
 * update CRM_ROLE
 */
insert into CRM_ROLE (role_id, role_name) values (1, '管理员');
insert into CRM_ROLE (role_id, role_name) values (2, '客户经理');
insert into CRM_ROLE (role_id, role_name) values (3, ' 测试');

/**
 * update CRM_MENU
 */
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (22, '客户关系管理系统', null, null, '客户关系管理系统', 1);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (1, '营销管理', 22, null, '营销管理', 2);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (2, '销售机会管理', 1, null, '销售机会管理', 2);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (3, '客户开发计划', 1, null, '客户开发计划', 2);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (4, '客户管理', 22, null, '客户管理', 2);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (5, '客户信息管理', 4, null, '客户信息管理', 2);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (6, '客户流失管理', 4, null, '客户流失管理', 2);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (7, '客户流失预警', 6, null, '客户流失预警', 3);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (8, '暂缓客户流失', 6, null, '暂缓客户流失', 3);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (9, '确认客户流失', 6, null, '确认客户流失', 3);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (10, '服务管理', 22, null, '服务管理', 2);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (11, '服务创建', 10, null, '服务创建', 2);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (12, '服务分配', 10, null, '服务分配', 2);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (13, '统计报表', 22, null, '统计报表', 2);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (14, '客户贡献分析', 13, null, '客户贡献分析', 2);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (15, '客户构成分析', 13, null, '客户构成分析', 2);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (16, '客户服务分析', 13, null, '客户服务分析', 2);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (17, '客户流失分析', 13, null, '客户流失分析', 2);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (18, '系统管理', 22, null, '系统管理', 2);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (19, '用户管理', 18, 'power/usersAction.action', '用户管理', 2);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (20, '角色管理', 18, 'power/roleAction!queryList.action', '角色管理', 2);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (21, '菜单管理', 18, null, '菜单管理', 2);
/**
 * update CRM_ROLE_MENU
 */
insert into CRM_ROLE_MENU (role_id, menu_id) values (1, 1);
insert into CRM_ROLE_MENU (role_id, menu_id) values (1, 2);
insert into CRM_ROLE_MENU (role_id, menu_id) values (1, 3);
insert into CRM_ROLE_MENU (role_id, menu_id) values (1, 13);
insert into CRM_ROLE_MENU (role_id, menu_id) values (1, 14);
insert into CRM_ROLE_MENU (role_id, menu_id) values (1, 15);
insert into CRM_ROLE_MENU (role_id, menu_id) values (1, 16);
insert into CRM_ROLE_MENU (role_id, menu_id) values (1, 17);
insert into CRM_ROLE_MENU (role_id, menu_id) values (1, 18);
insert into CRM_ROLE_MENU (role_id, menu_id) values (1, 19);
insert into CRM_ROLE_MENU (role_id, menu_id) values (1, 20);
insert into CRM_ROLE_MENU (role_id, menu_id) values (1, 21);
insert into CRM_ROLE_MENU (role_id, menu_id) values (1, 22);

/**
 * CRM_ROLE_MODULE
 */
insert into CRM_ROLE_MODULE (rm_id, role_id, module_id, power_code)
values (8, 1, 1, 9);
insert into CRM_ROLE_MODULE (rm_id, role_id, module_id, power_code)
values (2, 1, 4, 2);
insert into CRM_ROLE_MODULE (rm_id, role_id, module_id, power_code)
values (3, 1, 6, 6);
insert into CRM_ROLE_MODULE (rm_id, role_id, module_id, power_code)
values (4, 1, 5, 1);
insert into CRM_ROLE_MODULE (rm_id, role_id, module_id, power_code)
values (5, 1, 3, 15);
insert into CRM_ROLE_MODULE (rm_id, role_id, module_id, power_code)
values (6, 1, 2, 15);
insert into CRM_ROLE_MODULE (rm_id, role_id, module_id, power_code)
values (7, 1, 9, 15);


/**
 * update CRM_USER_ROLE
 */
insert into CRM_USER_ROLE (role_id, user_id) values (1, 1);
insert into CRM_USER_ROLE (role_id, user_id) values (2, 1);

