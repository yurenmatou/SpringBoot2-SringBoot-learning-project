package com.vincent.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryThree",
        transactionManagerRef = "transactionManagerThree",
        basePackages = "com.vincent.repository.test3"
)
public class ThreeConfig {


    @Autowired
    @Qualifier("threeDataSource")
    private DataSource threeDataSource;

    @Autowired
    @Qualifier("vendorProperties")
    private Map<String, Object> vendorProperties;


    @Bean("entityManagerThree")
    public EntityManager entityManagerThree(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryThree(builder).getObject().createEntityManager();
    }

    @Bean("entityManagerFactoryThree")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryThree(EntityManagerFactoryBuilder builder) {
        return builder.
                dataSource(threeDataSource)
                .properties(vendorProperties)
                .packages("com.vincent.model")
//                .persistenceUnit("threePersistenceUnit").build();
                .persistenceUnit("UnithreePersistencet").build();
    }

    @Bean("transactionManagerThree")
    public PlatformTransactionManager transactionManagerThree(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryThree(builder).getObject());
    }

}
