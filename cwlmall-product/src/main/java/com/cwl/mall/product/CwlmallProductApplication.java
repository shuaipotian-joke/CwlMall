package com.cwl.mall.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.cwl.mall.product.feign")
@EnableDiscoveryClient
@SpringBootApplication
public class CwlmallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(CwlmallProductApplication.class, args);
    }

}
