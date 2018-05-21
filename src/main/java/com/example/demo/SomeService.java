package com.example.demo;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SomeService {

    private final List<MicroProcess> microProcessList;

    public SomeService(List<MicroProcess> microProcessList) {
        System.out.println("constructorooooooooooor: "+ microProcessList);
        if(((ProxyFactory) microProcessList.get(0)).getProxy() instanceof LinkabilityTrait) {
            System.out.println("AOP");
        }
        this.microProcessList = microProcessList;
    }

}
