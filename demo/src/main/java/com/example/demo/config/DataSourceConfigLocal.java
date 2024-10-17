package com.example.demo.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@Configuration
public class DataSourceConfigLocal {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String user;

    @Value("${spring.datasource.password}")
    private String pwd;

    @Value("${spring.datasource.driver-class-name}")
    private String drive;

    @Bean(name = "dataSourceMysql")
    public DataSource dataSourceMysql(){
        log.info("Criando dataSourceMysql");

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(drive);
        hikariConfig.setJdbcUrl(url);
        hikariConfig.setUsername(user);
        hikariConfig.setPassword(pwd);

        hikariConfig.setMinimumIdle(1);
        hikariConfig.setConnectionTestQuery("SELECT 1");
        hikariConfig.setPoolName("ale-mysql-dataSource");

        hikariConfig.addDataSourceProperty("dataSource.cachePrepStmts","true");
        hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSize","550");
        hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSqlLimit","2048");
        hikariConfig.addDataSourceProperty("dataSource.useServerPrepStmts","true");

        hikariConfig.setConnectionTimeout(60000);
        hikariConfig.setIdleTimeout(30000);
        hikariConfig.setMaxLifetime(40000);

        return new HikariDataSource(hikariConfig);

    }

    @Bean
    public JdbcTemplate jdbcTemplateMysql(@Qualifier("dataSourceMysql") DataSource dataSourceMysql){
        return new JdbcTemplate(dataSourceMysql);
    }
}
