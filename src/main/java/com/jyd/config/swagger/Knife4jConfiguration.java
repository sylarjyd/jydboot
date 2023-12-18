package com.jyd.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfiguration {

    @Bean(value = "dockerBean")
    public Docket dockerBean() {
        Docket docket=new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                .description("接口服务")
                .termsOfServiceUrl("https://doc.xiaominfo.com/")
                .version("1.0.0")
                .build())
                .groupName("接口服务")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jyd.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
}
