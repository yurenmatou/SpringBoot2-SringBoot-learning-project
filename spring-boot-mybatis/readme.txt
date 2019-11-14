一、开头步骤基础配置走起
注意事项：在写实体类的时候，记得要有空的构造方法，不然是会出现错误的

1、mybatis.type-aliases-package=com.vincent.springbootmybatis.model
  spring.datasource.url=jdbc:mysql://localhost:3306/test2?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=true
  spring.datasource.username=root
  spring.datasource.password=123456
  spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

2、入库程序SpringBootMybatisApplication，头部添加@MapperScan("com.vincent.springbootmybatis.model") ，这个就是所有的都会被扫描进去，省去单独加注解@Mapper

3、方法上加上注解@Select("select * from user") 进行查询

4、其他的查询你们自行脑补啦



SQL表的建立

CREATE TABLE `user` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`email` VARCHAR(255) NULL DEFAULT NULL,
	`nickName` VARCHAR(255) NULL DEFAULT NULL,
	`passWord` VARCHAR(255) NULL DEFAULT NULL,
	`regTime` VARCHAR(255) NULL DEFAULT NULL,
	`userName` VARCHAR(255) NULL DEFAULT NULL,
	`user_sex` ENUM('MAN','WOMAN') NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	UNIQUE INDEX `UK_e6gkqunxajvyxl5uctpl2vl2p` (`email`),
	UNIQUE INDEX `UK_hl8fftx66p59oqgkkcfit3eay` (`userName`),
	UNIQUE INDEX `UK_jwp1m8gcxbbs4letxijfipr6b` (`nickName`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=3
;


#Account 表
-- create table `account`
# DROP TABLE `account` IF EXISTS
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `money` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
INSERT INTO `account` VALUES ('1', 'aaa', '1000');
INSERT INTO `account` VALUES ('2', 'bbb', '1000');
INSERT INTO `account` VALUES ('3', 'ccc', '1000');
