package com.graydon.dubbo.provider;

import com.graydon.dubbo.provider.service.IProviderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"META-INF/spring/consumer.xml"});
        context.start();
        // Obtaining a remote service proxy
        IProviderService demoService = (IProviderService)context.getBean("providerService");
        // Executing remote methods
        String hello = demoService.helloWorld("world");
        // Display the call result
        System.out.println(hello);
    }
}
