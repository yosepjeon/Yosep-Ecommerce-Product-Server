package com.yosep.product.infra.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DBConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource.yosep-read")
    public HikariConfig yosepReadDatasourceProperties(){
        return new HikariConfig();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.yosep-write")
    public HikariConfig yosepWriteDatasourceProperties(){
        return new HikariConfig();
    }

    @Bean
    public DataSource yosepReadDataSource(){
        return new HikariDataSource(yosepReadDatasourceProperties());
    }

    @Bean
    @Primary
    public DataSource yosepWriteDataSource(){
        return new HikariDataSource(yosepWriteDatasourceProperties());
    }
}
