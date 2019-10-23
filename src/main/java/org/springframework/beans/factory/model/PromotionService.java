package org.springframework.beans.factory.model;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.context.ApplicationListener;
import org.springframework.beans.factory.context.event.ContextClosedEvent;
import org.springframework.beans.factory.stereotype.Component;

@Component
public class PromotionService implements BeanNameAware, BeanFactoryAware, InitializingBean, ApplicationListener<ContextClosedEvent> {
    private String beanName;
    private BeanFactory factoryReference;

    public void setBeanName(String name) {
        beanName = name;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setFactoryReference(BeanFactory reference) {
        factoryReference = reference;
    }

    public BeanFactory getFactoryReference() {
        return factoryReference;
    }

    public void afterPropertiesSet() {
        System.out.println("=== afterPropertiesSet ===");
    }

    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println(">> ContextClosed EVENT");
    }
}
