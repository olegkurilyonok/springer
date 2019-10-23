package org.springframework.beans.factory.bpp;

import org.springframework.beans.factory.config.BeanPostProcessor;

public class CustomPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("---CustomPostProcessor Before " + beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("---CustomPostProcessor After " + beanName);
        return bean;
    }
}
