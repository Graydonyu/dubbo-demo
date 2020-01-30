package com.graydon.dubbo.provider.service.impl;

import com.graydon.dubbo.provider.service.IProviderService;

public class ProviderServiceImpl implements IProviderService {
    public String helloWorld(String word) {
        return word;
    }
}
