紧接着上一课，我们继续练习，这节课来点高端的，多数据源Jpa

多数据源首先配置
spring.datasource.primary.jdbc-url=jdbc:mysql://localhost:3306/test1?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=true
spring.datasource.primary.username=root
spring.datasource.primary.password=123456
spring.datasource.primary.driver-class-name=com.mysql.cj.jdbc.Driver

其他一样配置省略。。。

spring.datasource.primary这个是我们自定义的配置，这里代表主要的数据库

代码需要哪些：
1、配置管理类，需要JpaProperties和然后添加到HibernateProperties，用于配置多个数据源的其他配置，然后添加到HibernateProperties中，头部需要添加注解Configuration
2、主库的管理类，DataSource，Map，头部需要添加注解Configuration，EnableTransactionManagement，EnableJpaRepositories

如何实现，需要哪些呢？
1、 实体管理工厂构建类、本地容器实体管理工厂、实体管理、平台转换管理
2、它们的流程是
本地容器实体管理工厂 由有参实体管理工厂构建类注入
本地容器实体管理工厂--构建实体管理
本地容器实体管理工厂--平台转换管理

