package com.example.demo;

import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.framework.AopProxyFactory;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MicroProcessBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof MicroProcess) {
            System.out.println("********post process before init***: " + beanName + " " + bean);

            bean = new ProxyFactory(bean);

            ((ProxyFactory) bean).addInterface(LinkabilityTrait.class);
            System.out.println(((ProxyFactory) bean).getProxy() instanceof MicroProcess);
            //true
            System.out.println(((ProxyFactory) bean).getProxy() instanceof LinkabilityTrait);
            //true
            System.out.println("********post process before init***: " + beanName + " " + bean);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof MicroProcess) {
            System.out.println("********post process after init***: " + beanName + " " + bean);

        }
        return bean;
    }
}
