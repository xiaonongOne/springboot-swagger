package com.example.swagger.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
//注解开启 swagger2 功能
@EnableSwagger2
public class Swagger2Config {

    //是否开启swagger，正式环境一般是需要关闭的
    @Value("${swagger.enabled}")
    private boolean enableSwagger;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //是否开启
                .enable(enableSwagger)
                .select()
                //扫描的路径包,设置basePackage会将包下的所有被@Api标记类的所有方法作为api
                .apis(RequestHandlerSelectors.basePackage("com.example.swagger.controller"))
                //指定路径处理PathSelectors.any()代表所有的路径
                .paths(PathSelectors.any())
                .build();
    }

    /**
     *
     * - swagger.title=标题
     * - swagger.description=描述
     * - swagger.version=版本
     * - swagger.license=许可证
     * - swagger.licenseUrl=许可证URL
     * - swagger.termsOfServiceUrl=服务条款URL
     * - swagger.contact.name=维护人
     * - swagger.contact.url=维护人URL
     * - swagger.contact.email=维护人email
     * - swagger.base-package=swagger扫描的基础包，默认：全扫描
     * - swagger.base-path=需要处理的基础URL规则，默认：/**
     * - swagger.exclude-path=需要排除的URL规则，默认：空
     * - swagger.host=文档的host信息，默认：空
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //设置文档标题
                .title("SpringBoot中使用Swagger2构建RESTful接口")
                //文档描述
                .description("接口说明")
                //服务条款URL
                .termsOfServiceUrl("http://127.0.0.1:8080/")
                //联系信息
                .contact("码农新锐")
                //版本号
                .version("1.0。0")
                .build();
    }

}
