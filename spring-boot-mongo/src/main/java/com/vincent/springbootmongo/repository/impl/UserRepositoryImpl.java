package com.vincent.springbootmongo.repository.impl;

import com.vincent.springbootmongo.model.User;
import com.vincent.springbootmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<com.vincent.springbootmongo.model.User> select() {
        return mongoTemplate.findAll(com.vincent.springbootmongo.model.User.class);
    }

    @Override
    public User selectOne(String userName) {
        Query query = new Query(Criteria.where("userName").is(userName));
        return mongoTemplate.findOne(query, User.class);
    }

    @Override
    public long update(User user) {
        Query query = new Query(Criteria.where("id").is(user.getId()));
        Update update = new Update().set("userName",user.getUserName()).addToSet("newUserName",user.getUserName());
        return mongoTemplate.updateFirst(query, update, User.class).getMatchedCount();
    }

    @Override
    public User insert(User user) {
        return mongoTemplate.save(user);
    }

    @Override
    public long delete(long id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoTemplate.remove(query, User.class).getDeletedCount();
    }
}
