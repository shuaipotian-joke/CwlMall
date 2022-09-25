package com.cwl.mall.search.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author cwl
 * @email 1045501964@qq.com
 * @date 2022/9/25 12:42
 */
@Configuration
public class ELasticConfig {
    @Resource
    RestClientBuilder restClientBuilder;

    @Bean
    public RestHighLevelClient createHighClient() {
        //高级客户端配置
        RestClientBuilder builder = RestClient.builder(new HttpHost("192.168.40.130", 9200, "http"));
        return new RestHighLevelClient(builder);
    }

    @Bean
    public RestClientBuilder createLowClientBuilder() {
        RestClientBuilder builder = RestClient.builder(
                new HttpHost("192.168.40.130", 9200, "http"));

        //配置超时回调接口、
        builder.setRequestConfigCallback(
                requestConfigBuilder -> {
                    System.out.println("超时了");
                    return requestConfigBuilder
                            .setConnectTimeout(5000)       //连接时间
                            .setSocketTimeout(10000);      //客户端时间
                });
        return builder;
    }
}
