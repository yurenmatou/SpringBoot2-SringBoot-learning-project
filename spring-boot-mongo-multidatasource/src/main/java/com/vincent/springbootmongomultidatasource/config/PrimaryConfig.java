package com.vincent.springbootmongomultidatasource.config;


import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
//@EnableConfigurationProperties(MultiMongoProperties.)
@EnableMongoRepositories(basePackages = "com.vincent.springbootmongomultidatasource.repository.test1",mongoTemplateRef = "")
public class PrimaryConfig {
}
