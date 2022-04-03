package com.shop.dashboard.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DriverManagerDataSource
import javax.sql.DataSource

@Configuration
@ComponentScan("com.shop.dashboard")
class SpringJdbcConfig {
    @Bean
    fun mysqlDataSource(): DataSource {
        val dataSource = DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/ecommerce");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        return dataSource;
    }
}