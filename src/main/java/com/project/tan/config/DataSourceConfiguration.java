package com.project.tan.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * 多数据源配置示例
 * <p>
 * 说明：
 * 前两个Bean是数据源的创建，通过@ConfigurationProperties可以知道这两个数据源分别加载了spring.datasource.primary.*和spring.datasource.secondary.*的配置。
 *
 * @Primary注解指定了主数据源，就是当我们不特别指定哪个数据源的时候，就会使用这个Bean 后两个Bean是每个数据源对应的JdbcTemplate。
 * 可以看到这两个JdbcTemplate创建的时候，分别注入了primaryDataSource数据源和secondaryDataSource数据源
 *
 * @Author zhengqiang.tan
 * @Date 2020/9/16 10:43 AM
 * @Version 1.0
 */
@Configuration
public class DataSourceConfiguration {


    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDataSource") DataSource primaryDataSource) {
        return new JdbcTemplate(primaryDataSource);
    }

    @Bean
    public JdbcTemplate secondaryJdbcTemplate(@Qualifier("secondaryDataSource") DataSource secondaryDataSource) {
        return new JdbcTemplate(secondaryDataSource);
    }
}
