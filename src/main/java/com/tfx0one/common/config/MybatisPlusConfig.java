package com.tfx0one.common.config;


import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @projectName:springboot-basic
 * @author:wangk
 * @date:2018/12/4 13:54
 * @Version: 1.0
 */
@Configuration
public class MybatisPlusConfig {
    /**
     * mybatis-plus分页插件<br>
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }


}