package com.zhang.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.zhang.application.ourMapper")
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
