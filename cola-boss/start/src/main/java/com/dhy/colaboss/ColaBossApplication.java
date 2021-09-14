package com.dhy.colaboss;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.dhy.colaboss", "com.alibaba.cola" })
@MapperScan("com.dhy.colaboss.gatewayimpl.database")
public class ColaBossApplication {

    public static void main(String[] args) {
        SpringApplication.run(ColaBossApplication.class, args);
    }

}
