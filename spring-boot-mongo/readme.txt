配置如下：
spring.application.name=spring-boot-mongodb

spring.data.mongodb.uri=mongodb://192.168.0.75:20000/test

增删改查
MongoTemplate mongoTemplate;

mongoTemplate.findAll(com.vincent.springbootmongo.model.User.class);

Query query = new Query(Criteria.where("userName").is(userName));
mongoTemplate.findOne(query, User.class);

Query query = new Query(Criteria.where("id").is(user.getId()));
Update update = new Update().set("userName",user.getUserName()).addToSet("newUserName",user.getUserName());
mongoTemplate.updateFirst(query, update, User.class).getMatchedCount();

mongoTemplate.save(user);

Query query = new Query(Criteria.where("id").is(id));
mongoTemplate.remove(query, User.class).getDeletedCount();
