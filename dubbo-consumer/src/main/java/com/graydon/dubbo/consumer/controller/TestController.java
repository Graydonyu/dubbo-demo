package com.graydon.dubbo.consumer.controller;

import com.graydon.dubbo.common.service.IProviderService;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Reference
    IProviderService iProviderService;

    @Resource
    CuratorFramework curatorFramework;

    @GetMapping("/test")
    public String test(){
        return iProviderService.helloWorld("Hello World");
    }

    @GetMapping("/zkLock")
    public void zkLockTest(){
        InterProcessLock zkLock = new InterProcessMutex(curatorFramework,"/lock");
        try {
            zkLock.acquire();

            System.out.println("我拿到分布式锁了");
            Thread.sleep(30000L);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                zkLock.release();
                System.out.println("我释放锁了");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
