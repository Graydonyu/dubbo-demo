package com.graydon.dubbo.provider;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@DubboComponentScan("com.graydon.dubbo.provider.service")
@SpringBootApplication
public class ProviderApplication {
    public static void main(String[] args){
        SpringApplication.run(ProviderApplication.class,args);
    }
}
