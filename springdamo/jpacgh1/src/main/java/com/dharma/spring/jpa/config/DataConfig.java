package com.dharma.spring.jpa.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.dharma.spring.jpa.repository")
@PropertySource("classpath:database.properties")
public class DataConfig {

    private final String PROPERTY_DRIVER = "driver";
    private final String PROPERTY_URL = "url";
    private final String PROPERTY_USERNAME = "user";
    private final String PROPERTY_PASSWORD= "password";
    private final String PROPERTY_SHOW_SQL = "hibernate.show_sql";
    private final String PROPERTY_DIALECT = "hibernate.dialect";

    @Autowired
    Environment environment;

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean lfb = new LocalContainerEntityManagerFactoryBean();
        lfb.setDataSource(dataSource());
        lfb.setPersistenceProviderClass(HibernatePersistenceProvider.class); //持久化
        lfb.setPackagesToScan("com.dharma.spring.jpa.model"); //扫描
        lfb.setJpaProperties(hibernateProps());
        return lfb;
    }

    DataSource dataSource(){
        DriverManagerDataSource ds= new DriverManagerDataSource();
        ds.setUrl(environment.getProperty(PROPERTY_URL));
        ds.setDriverClassName(environment.getProperty(PROPERTY_DRIVER));
        ds.setUsername(environment.getProperty(PROPERTY_USERNAME));
        ds.setPassword(environment.getProperty(PROPERTY_PASSWORD));
        return ds;
    }

    Properties hibernateProps(){
        Properties properties = new Properties();
        properties.setProperty(PROPERTY_DIALECT,environment.getProperty(PROPERTY_DIALECT));
        properties.setProperty(PROPERTY_SHOW_SQL,environment.getProperty(PROPERTY_SHOW_SQL));
        return properties;
    }
    @Bean
    JpaTransactionManager transactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

}
