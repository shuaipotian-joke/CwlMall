package com.cwl.mall.ware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.cwl.mall.ware.feign")
@SpringBootApplication
public class CwlmallWareApplication {

    public static void main(String[] args) {
        SpringApplication.run(CwlmallWareApplication.class, args);
    }

}
