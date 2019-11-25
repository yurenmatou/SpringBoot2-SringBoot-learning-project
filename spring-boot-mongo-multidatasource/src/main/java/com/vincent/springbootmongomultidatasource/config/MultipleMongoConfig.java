package com.vincent.springbootmongomultidatasource.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.vincent.springbootmongomultidatasource.config.props.MultipleMongoProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;


@Configuration
public class MultipleMongoConfig {


    @Autowired
    MultipleMongoProperties properties;


    @Primary
    @Bean
    public MongoDbFactory primaryFactory() {
        MongoClient mongoClient =   new MongoClient(new MongoClientURI(properties.getPrimary().getUri()));
        return new SimpleMongoDbFactory(mongoClient,properties.getPrimary().getDatabase());
    }

    @Primary
    @Bean("primaryMongoTemplate")
    public MongoTemplate primaryMongoTemplate(MongoProperties properties) {
        return new MongoTemplate(primaryFactory());
    }

    @Bean
    public MongoDbFactory secondaryMongoFactory() {
        MongoClient mongoClient = new MongoClient(new MongoClientURI(properties.getSecondary().getUri()));
        return new SimpleMongoDbFactory(mongoClient, properties.getSecondary().getDatabase());
    }

    @Bean("secondaryMongoTemplate")
    public MongoTemplate secondaryMongoTemplate(MongoProperties properties) {
        return new MongoTemplate(secondaryMongoFactory());
    }

}
