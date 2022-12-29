DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `number` varchar(10) NOT NULL,
    `name` varchar(10) NOT NULL,
    `age` int NOT NULL,
    `gender` char(1) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;
INSERT INTO `student`
VALUES (1, '101', '李四', 19, '男'),
    (2, '102', '李四', 19, '男'),
    (3, '103', '王五', 19, '男'),
    (4, '104', '马六', 19, '男'),
    (5, '105', '赵七', 19, '男'),
    (6, '106', '陈八', 19, '女'),
    (7, '107', '朱九', 19, '女'),
    (8, '108', '小红', 19, '女'),
    (9, '109', '小强', 19, '女'),
    (10, '110', '大白', 19, '女'),
    (11, '111', '小花', 19, '男'),
    (12, '112', '小新', 20, '男'),
    (13, '113', '小黄', 20, '男');