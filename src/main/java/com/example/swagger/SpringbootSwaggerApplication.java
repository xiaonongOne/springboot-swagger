package com.example.swagger;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.swagger.dao")
public class SpringbootSwaggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSwaggerApplication.class, args);
    }

}

