                            《跟我学课堂》
废话：大家好，我是Vincent，花名渔人码头，一名默默无闻，兢兢业业的普通程序猿，跟大家一样，
在学习的路上探索，从基础做起，一起学习，本着相互学习，指点的初衷，来维护我们这个跟我学的课堂。

前言：本节课是带大家来学习如何使用注解的方式轻松实现mybatis的数据库操作，其中包括常规的增删改查，
好了，废话不多说，直接开干吧

一、开头步骤基础配置走起
1、

2、入库程序SpringBootMybatisApplication，头部添加@MapperScan("com.vincent.springbootmybatis.model") ，这个就是所有的都会被扫描进去，省去单独加注解@Mapper

3、方法上加上注解@Select("select * from user") 进行查询

4、其他的查询你们自行脑补啦
