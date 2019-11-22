紧接着上一课，我们继续练习，这节课来点高端的，多数据源Mybatis

多数据源首先配置
spring.datasource.xxx.jdbc-url=jdbc:mysql://localhost:3306/test2?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=true
spring.datasource.xxx.username=root
spring.datasource.xxx.password=root
spring.datasource.xxx.driver-class-name=com.mysql.cj.jdbc.Driver


2、编写配置类
添加Configuration注解，添加MapperScan 关联mapper
配置数据源DataSource，关联application.properties配置的属性

分别构建以下对象
3、
DataSourceTransactionManager
SqlSessionFactory
SqlSessionTemplate


4、与xml方式不同的是，需要指定PathMatchingResourcePatternResolver

例子如下：
 @Bean(name = "test1SqlSessionFactory")
    @Primary
    public SqlSessionFactory getSqlSessionFactory(@Qualifier("test1DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis/mapper/test1/*.xml"));
        bean.setDataSource(dataSource);
        return bean.getObject();
    }
