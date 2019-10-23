package org.springframework.beans.factory;

public interface BeanFactoryAware {
    void setFactoryReference(BeanFactory reference);
}
