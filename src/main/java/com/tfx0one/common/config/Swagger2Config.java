package com.tfx0one.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 2fx0one on 25/5/2018.
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    //   访问可以查看api http://localhost:8080/swagger-ui.html

    @Value("${swagger2.ui.enable}")
    private boolean isEnable = false;

    @Bean
    public Docket createRestApi() {
        ParameterBuilder tokenPar = new ParameterBuilder();

        if (isEnable) {
            List<Parameter> pars = new ArrayList<>();
            tokenPar.name("Authorization").description("token需要拼接在 Bearer 后!").modelRef(new ModelRef("string")).parameterType("header").required(false).defaultValue("Bearer ").build();
            pars.add(tokenPar.build());
            return new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo())
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("com.tfx0one"))
                    .paths(PathSelectors.any())
                    .build()
                    .globalOperationParameters(pars);
        } else {
            return new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo())
                    .select()
                    .apis(RequestHandlerSelectors.none())
                    .paths(PathSelectors.any())
                    .build()
                    ;
        }
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
}
