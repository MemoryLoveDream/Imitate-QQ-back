-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        8.0.28 - MySQL Community Server - GPL
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  12.8.0.6908
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- 导出 easychat 的数据库结构
CREATE DATABASE IF NOT EXISTS `easychat` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `easychat`;

-- 导出  表 easychat.group 结构
CREATE TABLE IF NOT EXISTS `group` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  `head_url` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `introduction` varchar(255) NOT NULL DEFAULT '',
  `announcement` varchar(255) NOT NULL DEFAULT '',
  `create_time` datetime NOT NULL DEFAULT (now()),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000000001 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 正在导出表  easychat.group 的数据：~1 rows (大约)
INSERT INTO `group` (`id`, `name`, `head_url`, `introduction`, `announcement`, `create_time`) VALUES
	(1000000000, '逛逛六元老', '/src/assets/pic/head/icon.png', '', '', '2024-06-15 20:10:48');

-- 导出  表 easychat.group_member 结构
CREATE TABLE IF NOT EXISTS `group_member` (
  `group_id` int NOT NULL,
  `member_id` int NOT NULL,
  `nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '',
  `note` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '',
  `role` tinyint NOT NULL DEFAULT (0)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 正在导出表  easychat.group_member 的数据：~6 rows (大约)
INSERT INTO `group_member` (`group_id`, `member_id`, `nickname`, `note`, `role`) VALUES
	(1000000000, 1000000000, '开国大元帅', '', 3),
	(1000000000, 1000000001, '', '', 1),
	(1000000000, 1000000002, '', '', 1),
	(1000000000, 1000000003, '', '', 1),
	(1000000000, 1000000004, '', '', 1),
	(1000000000, 1000000005, '', '', 1);

-- 导出  表 easychat.message 结构
CREATE TABLE IF NOT EXISTS `message` (
  `message_type` tinyint NOT NULL DEFAULT '0',
  `sender_id` int NOT NULL,
  `receiver_id` int NOT NULL,
  `group_id` int NOT NULL DEFAULT '0',
  `send_time` datetime NOT NULL,
  `chat_type` tinyint NOT NULL DEFAULT '0',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `seen` tinyint NOT NULL DEFAULT (0),
  KEY `sender_id` (`sender_id`),
  KEY `receiver_id` (`receiver_id`),
  KEY `seen` (`seen`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 正在导出表  easychat.message 的数据：~15 rows (大约)
INSERT INTO `message` (`message_type`, `sender_id`, `receiver_id`, `group_id`, `send_time`, `chat_type`, `content`, `seen`) VALUES
	(1, 1000000001, 1000000000, 0, '2024-08-03 00:00:00', 1, '睡了吗？', 0),
	(1, 1000000000, 1000000001, 0, '2024-08-03 00:01:00', 1, '没', 0),
	(1, 1000000001, 1000000000, 0, '2024-08-03 00:01:10', 1, '问你个事', 0),
	(1, 1000000000, 1000000001, 0, '2024-08-03 00:01:20', 1, '啥', 0),
	(1, 1000000001, 1000000000, 0, '2024-08-03 00:01:30', 1, '明天开会所有人都去吗？', 0),
	(1, 1000000000, 1000000001, 0, '2024-08-03 00:01:40', 1, '对', 0),
	(1, 1000000002, 1000000000, 0, '2024-08-03 00:01:40', 1, '你好', 0),
	(1, 1000000003, 1000000000, 0, '2024-08-03 00:01:40', 1, '你好', 0),
	(1, 1000000004, 1000000000, 0, '2024-08-03 00:01:40', 1, '你好', 0),
	(2, 1000000000, 1000000000, 1000000000, '2024-10-03 15:56:00', 1, '朋友们，都在吗？', 0),
	(2, 1000000000, 1000000001, 1000000000, '2024-10-03 15:56:00', 1, '朋友们，都在吗？', 0),
	(2, 1000000000, 1000000002, 1000000000, '2024-10-03 15:56:00', 1, '朋友们，都在吗？', 0),
	(2, 1000000000, 1000000003, 1000000000, '2024-10-03 15:56:00', 1, '朋友们，都在吗？', 0),
	(2, 1000000000, 1000000004, 1000000000, '2024-10-03 15:56:00', 1, '朋友们，都在吗？', 0),
	(2, 1000000000, 1000000005, 1000000000, '2024-10-03 15:56:00', 1, '朋友们，都在吗？', 0);

-- 导出  表 easychat.relationship 结构
CREATE TABLE IF NOT EXISTS `relationship` (
  `i` int NOT NULL,
  `you` int NOT NULL,
  `note` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '备注',
  `grouping` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `intimacy` tinyint NOT NULL DEFAULT '0' COMMENT '亲密度',
  KEY `FK_relationship_user_2` (`you`),
  KEY `FK_relationship_user` (`i`) USING BTREE,
  CONSTRAINT `FK_relationship_user` FOREIGN KEY (`i`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_relationship_user_2` FOREIGN KEY (`you`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 正在导出表  easychat.relationship 的数据：~12 rows (大约)
INSERT INTO `relationship` (`i`, `you`, `note`, `grouping`, `intimacy`) VALUES
	(1000000001, 1000000002, '', '朋友', 1),
	(1000000000, 1000000001, '卷王熊', '元老', 1),
	(1000000000, 1000000002, '小萌', '元老', 1),
	(1000000000, 1000000003, 'yearbook', '元老', 1),
	(1000000000, 1000000004, '', '元老', 1),
	(1000000000, 1000000005, '', '元老', 1),
	(1000000001, 1000000000, '', '同事', 1),
	(1000000002, 1000000000, '', '朋友', 1),
	(1000000003, 1000000000, '', '朋友', 1),
	(1000000004, 1000000000, '', '朋友', 1),
	(1000000005, 1000000000, '', '朋友', 1),
	(1000000002, 1000000001, '', '朋友', 1);

-- 导出  表 easychat.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `head_url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `sex` tinyint NOT NULL DEFAULT (0),
  `signature` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '无',
  `country` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '中国',
  `location` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `status` tinyint NOT NULL DEFAULT (0),
  `create_time` datetime NOT NULL DEFAULT (now()),
  `last_login_time` datetime NOT NULL DEFAULT (now()),
  `last_off_time` datetime NOT NULL DEFAULT (now()),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1000000013 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 正在导出表  easychat.user 的数据：~6 rows (大约)
INSERT INTO `user` (`id`, `head_url`, `nickname`, `password`, `email`, `sex`, `signature`, `country`, `location`, `status`, `create_time`, `last_login_time`, `last_off_time`) VALUES
	(1000000000, 'img:///E:/project/Vue/easychat-front/assets/users/1000000000/head.jpg', '忆恋梦', '123456', '2274399174@qq.com', 1, '', '中国', '江苏·南京', 1, '2024-06-15 20:10:47', '2024-06-15 20:10:48', '2024-06-15 20:10:48'),
	(1000000001, '/src/assets/pic/head/working_bear.png', '努力工作的小熊', '123456', '2274399174@qq.com', 1, '', '中国', '北京', 1, '2024-06-15 20:10:47', '2024-06-15 20:10:48', '2024-06-15 20:10:48'),
	(1000000002, '/src/assets/pic/head/girl_snowman.png', '萌萌的小雪人', '123456', '2274399174@qq.com', 0, '', '中国', '上海', 0, '2024-06-15 20:10:47', '2024-06-15 20:10:48', '2024-06-15 20:10:48'),
	(1000000003, '/src/assets/pic/head/yearbook.png', 'yearbook', '123456', '2274399174@qq.com', 1, '', '中国', '江苏·南京', 0, '2024-06-15 20:10:47', '2024-06-15 20:10:48', '2024-06-15 20:10:48'),
	(1000000004, '/src/assets/pic/head/wind_grass.png', '微风滚青草', '123456', '2274399174@qq.com', 0, '', '中国', '江苏·苏州', 0, '2024-06-15 20:10:47', '2024-06-15 20:10:48', '2024-06-15 20:10:48'),
	(1000000005, '/src/assets/pic/head/stones.png', '逃离孤独', '123456', '2274399174@qq.com', 1, '', '中国', '浙江·杭州', 0, '2024-06-15 20:10:47', '2024-06-15 20:10:48', '2024-06-15 20:10:48');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
