package com.wzw.wangziwei.ddd.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.wzw.wangziwei.ddd.infrastructure.repository.mybatis.mapper"})
public class MybatisConfig {//事务需要时打开
//    @Resource
//    private DataSource dataSource;
//
//    @Bean
//    public TransactionTemplate getTransactionTemplate() {
//        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);
//        return new TransactionTemplate(dataSourceTransactionManager);
//    }
}
