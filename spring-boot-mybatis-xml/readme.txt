一、开头步骤基础配置走起
1、mybatis.type-aliases-package=com.vincent.springbootmybatis.model
  spring.datasource.url=jdbc:mysql://localhost:3306/test2?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=true
  spring.datasource.username=root
  spring.datasource.password=123456
  spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

2、入库程序SpringBootMybatisApplication，头部添加@MapperScan("com.vincent.springbootmybatis.model") ，这个就是所有的都会被扫描进去，省去单独加注解@Mapper

3、方法上加上注解@Select("select * from user") 进行查询

4、其他的查询你们自行脑补啦
