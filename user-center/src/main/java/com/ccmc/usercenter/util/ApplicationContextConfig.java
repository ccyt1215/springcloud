package com.ccmc.usercenter.util;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced //实现负载均衡设置。
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
