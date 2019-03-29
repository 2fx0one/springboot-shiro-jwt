package com.tfx0one.common.config.mybatisplus;


import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName:springboot-basic
 * @author:wangk
 * @date:2018/12/4 13:54
 * @Version: 1.0
 */
@EnableTransactionManagement(proxyTargetClass = true)
@Configuration
@MapperScan("com.tfx0one.**.mapper")//这个注解，作用相当于下面的@Bean MapperScannerConfigurer，2者配置1份即可
public class MybatisPlusConfig {
    /**
     * mybatis-plus分页插件<br>
     * 文档：http://mp.baomidou.com<br>
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }

    /** 
    * @Description: 逻辑删除
    * @Param: [] 
    * @return: com.baomidou.mybatisplus.core.injector.ISqlInjector 
    * @Author: wangk 
    * @CreateTime: 2019/3/28 15:37
    */ 
//    @Bean
//    public ISqlInjector sqlInjector() {
//        return new LogicSqlInjector();
//    }

    /**
     * 相当于顶部的：
     * {@code @MapperScan("com.baomidou.springboot.mapper*")}
     * 这里可以扩展，比如使用配置文件来配置扫描Mapper的路径
     */
//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer() {
//        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
//        scannerConfigurer.setBasePackage("com.tfx0one.**.mapper");
//        return scannerConfigurer;
//    }

    /**
     * 性能分析拦截器，不建议生产使用
     */
    @Bean
    @ConditionalOnProperty(name = "mybatis-plus.performance", havingValue = "true")
    public PerformanceInterceptor performanceInterceptor() {
//        return usePerformance ? new PerformanceInterceptor(): null;
//        System.out.println("performanceInterceptor : " + usePerformance);
        return new PerformanceInterceptor();
    }
}