package com.lk.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class SpringBootJdbcDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJdbcDemoApplication.class, args);
    }

}
