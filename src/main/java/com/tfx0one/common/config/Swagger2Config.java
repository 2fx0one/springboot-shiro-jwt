package com.tfx0one.common.config;

import com.google.common.base.Predicate;
import com.tfx0one.common.utils.JWTUtils;
import com.tfx0one.modules.sys.entity.SysUserEntity;
import com.tfx0one.modules.sys.service.SysUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by 2fx0one on 25/5/2018.
 */
@Configuration
@EnableSwagger2
@ConditionalOnProperty(name = "swagger2.ui.enable", havingValue = "true")
public class Swagger2Config {

    //   访问可以查看api http://localhost:8894/api/swagger-ui.html

    @Autowired
    private SysUserService sysUserService;

    @Bean
    public Docket createRestApi() {

        //获取管理员用户
        SysUserEntity user = sysUserService.queryByUserName("admin");
        String sign = JWTUtils.sign(sysUserService.queryByUserName("admin"));

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//                .apis(RequestHandlerSelectors.basePackage("com.tfx0one"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(newArrayList(
                        new ParameterBuilder()
                                .name("Authorization")
                                .description("默认使用 admin 账户的token")
                                .modelRef(new ModelRef("string"))
                                .parameterType("header").required(false)
                                .defaultValue("")
//                                .defaultValue(JWTUtils.sign(sysUserService.queryByUserName("admin")))
                                .build()
                ))
                .apiInfo(apiInfo());
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger2 RESTful APIs")
                .description("restful APIs， 根据代码自动生成的api文档和接口！")
                .termsOfServiceUrl("2fx0one")
//                .contact("2fx0one")
                .version("1.0")
                .build();
    }

    private List<ApiKey> security() {
        return newArrayList(
                new ApiKey("token", "Authorization", "header")
        );
    }

}
