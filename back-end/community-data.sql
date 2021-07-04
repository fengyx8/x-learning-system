USE `x_learning_system`;

-- 用户信息表初始数据测试
INSERT INTO `user` (`userId`, `name`, `secureQue`, `secureAns`, `mail`, `org`, `score`) VALUES ('18372052', '肖景博', '问题?', '答案。', 'xiaojb8@mail2.sysu.edu.cn', '信息管理学院', 0.0);

-- 心得表初始数据测试
INSERT INTO `note` (`content`, `userId`, `status`) VALUES ('坚持党的领导，服从党的纪律，为共产主义事业奋斗终生！', '18372052', 1);
INSERT INTO `note` (`content`, `userId`, `status`) VALUES ('听党指挥 能打胜仗 作风优良', '18372052', 1);

-- 评论表初始数据测试
INSERT INTO `comment` (`content`, `userId`, `noteId`, `status`) VALUES ('写的也太好了吧！', '18372052', RIGHT('n1', LENGTH('n1') - 1), 1);
INSERT INTO `comment` (`content`, `userId`, `noteId`, `status`) VALUES ('你说话可真好听！！', '18372052', RIGHT('n1', LENGTH('n1') - 1), 1);
INSERT INTO `comment` (`content`, `userId`, `noteId`, `status`) VALUES ('人民解放军万岁！', '18372052', RIGHT('n2', LENGTH('n2') - 1), 1);

-- 系统角色表数据
INSERT INTO `x_role`(`id`, `name`, `info`, `is_lock`) VALUES (1, '管理员', '最高权限', 1);
INSERT INTO `x_role`(`id`, `name`, `info`, `is_lock`) VALUES (2, '一般用户', '社群发表内容权限', 1);

-- 角色权限表初始数据测试
insert into x_role_permission() values (0, '1', 'bas', now());
insert into x_role_permission() values (0, '1', '1', now());
insert into x_role_permission() values (0, '2', '2', now());
insert into x_role_permission() values (0, '1', '99', now());

insert into x_role_permission() values (0, '1', 'console', now());
insert into x_role_permission() values (0, '1', 'sql-console', now());
insert into x_role_permission() values (0, '1', 'redis-console', now());
insert into x_role_permission() values (0, '1', 'apilog-list', now());
insert into x_role_permission() values (0, '1', 'form-generator', now());

insert into x_role_permission() values (0, '1', 'auth', now());
insert into x_role_permission() values (0, '1', 'role-list', now());
insert into x_role_permission() values (0, '1', 'menu-list', now());
insert into x_role_permission() values (0, '1', 'admin-list', now());
insert into x_role_permission() values (0, '1', 'admin-add', now());

insert into x_role_permission() values (0, '1', 'sp-cfg', now());
insert into x_role_permission() values (0, '1', 'sp-cfg-app', now());
insert into x_role_permission() values (0, '1', 'sp-cfg-server', now());
insert into x_role_permission() values (0, '1', 'user-info', now());
insert into x_role_permission() values (0, '2', 'user-info', now());

-- 系统用户表初始测试数据
INSERT INTO `x_user`(`id`, `name`, `avatar`, `password`, `pw`, `role_id`, `create_time`, `org`) 
VALUES ('18372052', '肖景博', 'http://demo-jj.dev33.cn/spdj-admin/sa-resources/admin-logo.png', 'E3B0C3D3D9EE362603274F467A9EF8A1', '123456', 2, now(), '信息管理学院'); 
INSERT INTO `x_user`(`id`, `name`, `avatar`, `password`, `pw`, `role_id`, `create_time`) 
VALUES ('170020', '朱老师', 'http://demo-jj.dev33.cn/spdj-admin/sa-resources/admin-logo.png', '5175C2A2AA37EF0BFC7AC2AD08953913', 'admin', 1, now(), '信息管理学院'); 