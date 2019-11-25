配置如下：
spring.application.name=spring-boot-mongo

mongodb.primary.uri=mongodb://localhost:27017
mongodb.primary.database=primary
mongodb.secondary.uri=mongodb://localhost:27017
mongodb.secondary.database=secondary


1、提供MongoProperties，添加@ConfigurationProperties(prefix = "mongodb")

2、提供配置类MultipleMongoConfig，MongoDbFactory（MongoClient构建），MongoTemplate

3、配置第一个数据源
@Configuration
@EnableConfigurationProperties(MultipleMongoProperties.class)
@EnableMongoRepositories(basePackages = "com.vincent.springbootmongomultidatasource.repository.test1",
mongoTemplateRef = "primaryMongoTemplate")


记得安装mongodb，启动MongoDB Server


/**
 * Bean注解，没有写时，默认方法的名称
 * Qualifier注解 ，指向Bean的Bean声明的name值，一个方法或者对象
 * @return
 * @throws Exception
 */
