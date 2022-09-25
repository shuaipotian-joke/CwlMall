package com.cwl.mall.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CwlmallSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(CwlmallSearchApplication.class, args);
    }

}
