CREATE DATABASE `x_learning_system`;
USE `x_learning_system`;

-- user

CREATE TABLE `user` (
  `userId` char(8) NOT NULL COMMENT '用户ID，唯一主键，与学号、登录账号一致',
  `name` varchar(10) NOT NULL COMMENT '用户姓名，与用户邮箱一同组成唯一性约束',
  `secureQue` tinytext NOT NULL COMMENT '密保问题',
  `secureAns` tinytext NOT NULL COMMENT '密保答案',
  `mail` varchar(32) NOT NULL COMMENT '用户邮箱，与用户姓名一同组成唯一性约束',
  `org` varchar(32) NOT NULL COMMENT '用户所属组织',
  `score` double NOT NULL DEFAULT '0' COMMENT '用户在社群内积分',
  PRIMARY KEY (`userId`) USING BTREE,
  UNIQUE KEY `name` (`name`,`mail`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='一般用户表，用户从登录表中激活后方可加入此表';


-- question

CREATE TABLE `question` (
  `queId` int NOT NULL AUTO_INCREMENT COMMENT '题目id，--主键、自增',
  `problem` tinytext NOT NULL COMMENT '题干信息',
  `stdAns` tinytext NOT NULL COMMENT '标准答案',
  `analysis` text NOT NULL COMMENT '答案解析',
  `points` double NOT NULL COMMENT '题目分值',
  `answererNumber` int NOT NULL DEFAULT '0' COMMENT '作答总人次',
  `correctAnsNumber` int NOT NULL DEFAULT '0' COMMENT '作答正确总人次',
  `optionA` tinytext NOT NULL COMMENT '选项A',
  `optionB` tinytext NOT NULL COMMENT '选项B',
  `optionC` tinytext NOT NULL COMMENT '选项C',
  `optionD` tinytext NOT NULL COMMENT '选项D',
  PRIMARY KEY (`queId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='题目表';


-- ansRecord

CREATE TABLE `ansRecord` (
  `ansId` int NOT NULL AUTO_INCREMENT COMMENT '作答记录唯一id，--主键、自增，前缀a',
  `queId` int NOT NULL COMMENT '对应问题id，外键，前缀q',
  `userId` char(8) NOT NULL COMMENT '作答用户id，外键',
  `ans` tinytext NOT NULL COMMENT '用户答案内容',
  `isCorrect` tinyint(1) NOT NULL COMMENT '作答是否正确',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '用户作答时间',
  PRIMARY KEY (`ansId`) USING BTREE,
  KEY `queId` (`queId`),
  KEY `userId` (`userId`),
  CONSTRAINT `ansRecord_ibfk_1` FOREIGN KEY (`queId`) REFERENCES `question` (`queId`),
  CONSTRAINT `ansRecord_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='作答记录表，使用到外键，需要在user表和question表之后创建';



-- note

CREATE TABLE `note` (
  `noteId` int NOT NULL AUTO_INCREMENT COMMENT '心得唯一id-主键、自增，使用时加上前缀n',
  `content` text NOT NULL COMMENT '用户心得内容',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '心得发布时间',
  `userId` char(8) NOT NULL COMMENT '发布心得者用户Id-外键',
  `status` int NOT NULL DEFAULT '0' COMMENT '心得审核状态，0：待审核；1：审核通过；2：审核不通过',
  PRIMARY KEY (`noteId`) USING BTREE,
  KEY `userId` (`userId`),
  CONSTRAINT `note_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='心得表，有外键约束，需在用户表之后创建';


-- comment

CREATE TABLE `comment` (
  `commentId` int NOT NULL AUTO_INCREMENT COMMENT '评论唯一id-主键、自增，使用时加上前缀c',
  `content` text NOT NULL COMMENT '用户评论内容',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评论时间',
  `userId` char(8) NOT NULL COMMENT '评论者用户Id',
  `noteId` int NOT NULL COMMENT '评论对应心得的id-外键',
  `status` int NOT NULL DEFAULT '0' COMMENT '评论审核状态，0：待审核；1：审核通过；2：审核不通过',
  PRIMARY KEY (`commentId`) USING BTREE,
  KEY `userId` (`userId`),
  KEY `noteId` (`noteId`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`),
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`noteId`) REFERENCES `note` (`noteId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='评论表，有外键约束，需在用户表、心得表之后创建';


-- like

CREATE TABLE `like` (
  `userId` char(8) NOT NULL COMMENT '点赞用户ID，外键',
  `contentId` varchar(8) NOT NULL COMMENT '评论/心得ID',
  KEY `userId` (`userId`),
  KEY `contentId` (`contentId`) USING BTREE,
  CONSTRAINT `like_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='点赞记录表，使用到外键，需要在user表之后创建';



-- news

CREATE TABLE `news` (
  `id` char(20) NOT NULL,
  `url` text,
  `title` text,
  `date` char(20) DEFAULT NULL,
  `origin` char(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




-- x_role

CREATE TABLE `x_role` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色id，--主键、自增',
  `name` varchar(20) NOT NULL COMMENT '角色名称, 唯一约束',
  `info` varchar(200) DEFAULT NULL COMMENT '角色详细描述',
  `is_lock` int NOT NULL DEFAULT '1' COMMENT '是否锁定(1=是,2=否), 锁定之后不可随意删除, 防止用户误操作',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='系统角色表';



-- x_role_permission

CREATE TABLE `x_role_permission` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id号',
  `role_id` bigint DEFAULT NULL COMMENT '角色ID ',
  `permission_code` varchar(50) DEFAULT NULL COMMENT '菜单项ID',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='角色权限中间表';



-- x_user

CREATE TABLE `x_user` (
  `id` char(8) NOT NULL COMMENT 'id，--主键',
  `name` varchar(100) NOT NULL COMMENT 'user名称',
  `avatar` varchar(500) DEFAULT NULL COMMENT '头像地址',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `pw` varchar(50) DEFAULT NULL COMMENT '明文密码',
  `mail` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `role_id` int DEFAULT '11' COMMENT '所属角色id',
  `status` int DEFAULT '1' COMMENT '账号状态(1=正常, 2=禁用)',
  `create_by_aid` char(8) DEFAULT '-1' COMMENT '创建自哪个管理员',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `login_time` timestamp NULL DEFAULT NULL COMMENT '上次登陆时间',
  `login_ip` varchar(50) DEFAULT NULL COMMENT '上次登陆IP',
  `login_count` int DEFAULT '0' COMMENT '登陆次数',
  `org` varchar(20) NOT NULL COMMENT '管理员所属组织',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='系统用户表';