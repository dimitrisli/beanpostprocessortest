package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    @Bean
    public MicroProcess mp1() {
        return new MicroProcessBasic();
    }

    @Bean
    public MicroProcess mp2() {
        return new MicroProcessBasic();
    }
}
