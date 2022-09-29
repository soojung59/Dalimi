package com.sj.runner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication
public class DalimiApplication {
    public static void main(String[] args) {
        SpringApplication.run(DalimiApplication.class, args);
    }

}