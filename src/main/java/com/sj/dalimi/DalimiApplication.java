package com.sj.dalimi;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.filter.HiddenHttpMethodFilter;


@EnableJpaAuditing
@SpringBootApplication
public class DalimiApplication {
    public static void main(String[] args) {
        SpringApplication.run(DalimiApplication.class, args);
    }

}