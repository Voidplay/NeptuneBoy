-- 菜单 SQL
set @parentId := 1;

-- 添加主菜单
INSERT INTO sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
VALUES ('交易分析报表', @parentId, '1', '/system/analysis', 'C', '0', 'system:analysis:view', 'fa fa-line-chart', 'admin', now(), 'admin', now(), '交易分析报表菜单');

-- 获取新插入的菜单ID
set @menuId := LAST_INSERT_ID();

-- 按钮 SQL
INSERT INTO sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
VALUES ('分析报表查询', @menuId, '1',  '#', 'F', '0', 'system:analysis:list',         '#', 'admin', now(), '', null, '');

INSERT INTO sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
VALUES ('日收益查看', @menuId, '2',  '#', 'F', '0', 'system:analysis:dailyProfit',   '#', 'admin', now(), '', null, '');

INSERT INTO sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
VALUES ('持仓查看', @menuId, '3',  '#', 'F', '0', 'system:analysis:positionValue',   '#', 'admin', now(), '', null, '');

INSERT INTO sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
VALUES ('最新分析', @menuId, '4',  '#', 'F', '0', 'system:analysis:latest',         '#', 'admin', now(), '', null, '');
