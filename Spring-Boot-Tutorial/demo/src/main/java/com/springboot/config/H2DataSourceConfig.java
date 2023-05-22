package com.springboot.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class H2DataSourceConfig {

    @Bean(name = "h2datasource")
    @ConfigurationProperties("spring.datasource.druid.h2")
    public DataSource dataSourceTwo(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "h2JdbcTemplate")
    public JdbcTemplate secondaryJdbcTemplate(
            @Qualifier("h2datasource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
