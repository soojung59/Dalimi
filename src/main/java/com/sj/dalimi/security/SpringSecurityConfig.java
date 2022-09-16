package com.sj.dalimi.security;


import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class SpringSecurityConfig  {

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception{
        http
            .authorizeRequests()
                .antMatchers("/hi").permitAll() //예외
                .anyRequest().authenticated()
            .and()
                .formLogin()
                .defaultSuccessUrl("/",true)
                .permitAll()
                .usernameParameter("id")
                .passwordParameter("pw")
            .and()
                .logout();

        return http.build();
    }


}

