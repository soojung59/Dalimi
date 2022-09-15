package com.sj.dalimi.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class DalimiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DalimiApplication.class, args);
    }

}