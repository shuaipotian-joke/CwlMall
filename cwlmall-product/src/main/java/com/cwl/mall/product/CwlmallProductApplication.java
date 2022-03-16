package com.cwl.mall.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CwlmallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(CwlmallProductApplication.class, args);
    }

}
