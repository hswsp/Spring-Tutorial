package com.springboot.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = OracleDataSourceConfig.PACKAGE,
        sqlSessionFactoryRef = "oracleSqlSessionFactory")
public class OracleDataSourceConfig {

    // oracledao扫描路径
    static final String PACKAGE = "com.springboot.dao.oracle";
    // mybatis mapper扫描路径
    static final String MAPPER_LOCATION = "classpath:mapper/oracle/*.xml";

    @Bean(name = "oracledatasource")
    @ConfigurationProperties("spring.datasource.druid.oracle")
    public DataSource dataSourceTwo(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "oracleJdbcTemplate")
    public JdbcTemplate secondaryJdbcTemplate(
            @Qualifier("oracledatasource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "oracleTransactionManager")
    public DataSourceTransactionManager oracleTransactionManager() {
        return new DataSourceTransactionManager(dataSourceTwo());
    }

    @Bean(name = "oracleSqlSessionFactory")
    public SqlSessionFactory oracleSqlSessionFactory(@Qualifier("oracledatasource") DataSource dataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        //如果不使用xml的方式配置mapper，则可以省去下面这行mapper location的配置。
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(OracleDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
