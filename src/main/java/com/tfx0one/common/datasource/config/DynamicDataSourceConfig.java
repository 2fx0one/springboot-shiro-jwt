/**
 * Copyright (c) 2018 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.tfx0one.common.datasource.config;

import com.tfx0one.common.datasource.properties.DataSourceProperties;
import com.tfx0one.common.datasource.properties.DynamicDataSourceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * 配置多数据源
 *
 */
@Configuration
@EnableConfigurationProperties(DynamicDataSourceProperties.class)
public class DynamicDataSourceConfig {
    @Autowired
    private DynamicDataSourceProperties dynamicDataSourceProperties;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DynamicDataSource dynamicDataSource(DataSourceProperties dataSourceProperties) {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setTargetDataSources(
                dynamicDataSourceProperties.getDatasource().entrySet().stream().collect(
                        Collectors.toMap(Map.Entry::getKey, e -> DynamicDataSourceFactory.buildDruidDataSource(e.getValue()))
                )
        );

        //默认数据源
//        DruidDataSource defaultDataSource = DynamicDataSourceFactory.buildDruidDataSource(dataSourceProperties);
        dynamicDataSource.setDefaultTargetDataSource(DynamicDataSourceFactory.buildDruidDataSource(dataSourceProperties));

        return dynamicDataSource;
    }

//    private Map<Object, Object> getDynamicDataSource(){
//        Map<String, DataSourceProperties> dataSourcePropertiesMap = properties.getDatasource();
//        Map<Object, Object> targetDataSources = new HashMap<>(dataSourcePropertiesMap.size());
//        return properties.getDatasource().entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> DynamicDataSourceFactory.buildDruidDataSource(e.getValue())));
//        dataSourcePropertiesMap.forEach((k, v) -> {
//            DruidDataSource druidDataSource = DynamicDataSourceFactory.buildDruidDataSource(v);
//            targetDataSources.put(k, druidDataSource);
//        });
//        return targetDataSources;
//    }

}