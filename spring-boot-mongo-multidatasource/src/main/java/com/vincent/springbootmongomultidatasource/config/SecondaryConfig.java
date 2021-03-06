package com.vincent.springbootmongomultidatasource.config;


import com.vincent.springbootmongomultidatasource.config.props.MultipleMongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableConfigurationProperties(MultipleMongoProperties.class)
@EnableMongoRepositories(basePackages = "com.vincent.springbootmongomultidatasource.repository.test2",mongoTemplateRef = "secondaryMongoTemplate")
public class SecondaryConfig {
}
