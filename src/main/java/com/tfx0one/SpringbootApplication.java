package com.tfx0one;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication

//关闭JDK动态代理机制
@EnableTransactionManagement(proxyTargetClass = true)

//只能扫描 Mapper 注解的 接口
//@MapperScan(basePackages = {"com.tfx0one.web"}, annotationClass = Mapper.class)
@MapperScan(basePackages = "com.tfx0one.web")
public class SpringbootApplication {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}