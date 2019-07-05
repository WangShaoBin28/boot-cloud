package com.app;

import com.app.config.ZuulFilterConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class SpringbootGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootGatewayApplication.class, args);
    }

    @Bean
    public ZuulFilterConfig zuulFilterConfig() {
        return new ZuulFilterConfig();
    }
}
