package com.graydon.dubbo.provider.service.impl;

import com.graydon.dubbo.common.service.IProviderService;
import org.apache.dubbo.config.annotation.Service;

@Service
public class ProviderServiceImpl implements IProviderService {
    public String helloWorld(String word) {
        return word;
    }
}
