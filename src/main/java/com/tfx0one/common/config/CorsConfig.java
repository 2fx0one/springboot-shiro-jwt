
package com.tfx0one.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//@Configuration
public class CorsConfig implements WebMvcConfigurer {

    /**
    * @Author wangk
    * @Description 跨域由NGINX 解决
    * @Date 17:07 2019-11-11
    **/
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("*")
            .allowCredentials(true)
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
            .maxAge(3600);
    }
}