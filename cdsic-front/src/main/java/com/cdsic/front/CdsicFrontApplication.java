package com.cdsic.front;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("com.cdsic.front.dao")
@SpringBootApplication
@EnableDiscoveryClient
public class CdsicFrontApplication {

    public static void main(String[] args) {
        SpringApplication.run(CdsicFrontApplication.class, args);
    }

}
