package com.cdsic.front;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.cdsic.front.dao")
@SpringBootApplication
public class CdsicFrontApplication {

    public static void main(String[] args) {
        SpringApplication.run(CdsicFrontApplication.class, args);
    }

}
