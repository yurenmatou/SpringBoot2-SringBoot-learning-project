package com.vincent.springbootmongomultidatasource.config.props;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@ConfigurationProperties("mongodb")
public class MultipleMongoProperties {


	public MongoProperties primary =new MongoProperties();
	public MongoProperties secondary =new MongoProperties();


	public MongoProperties getPrimary() {
		return primary;
	}

	public void setPrimary(MongoProperties primary) {
		this.primary = primary;
	}

	public MongoProperties getSecondary() {
		return secondary;
	}

	public void setSecondary(MongoProperties secondary) {
		this.secondary = secondary;
	}
}
