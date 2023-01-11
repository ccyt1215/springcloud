package com.ccmc.carinfo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient // 开启服务注册发现功能
@MapperScan(basePackages = {"com.ccmc.carinfo.service.mapper"})
@SpringBootApplication
public class CarApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarApplication.class,args);
    }
}
