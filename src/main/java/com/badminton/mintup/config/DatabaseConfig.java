package com.badminton.mintup.config;

import org.springframework.boot.jdbc.DataSourceBuilder;

import javax.sql.DataSource;

//@Configuration
public class DatabaseConfig {

    //@Bean
    //@ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
}
