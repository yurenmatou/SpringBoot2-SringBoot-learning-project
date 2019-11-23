package com.vincent.springbootmongomultidatasource.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@Configuration
@EnableConfigurationProperties(MultipleMongoProperties.class)
@EnableMongoRepositories(basePackages = "com.neo.repository.primary",
		mongoTemplateRef = "primaryMongoTemplate")
public class PrimaryMongoConfig {
}
