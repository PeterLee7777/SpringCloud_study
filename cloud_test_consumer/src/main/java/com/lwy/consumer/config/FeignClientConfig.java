package com.lwy.consumer.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FeignClientConfig {

    @Bean
    public Logger.Level logLevel(){
        return Logger.Level.BASIC;
    }
}
