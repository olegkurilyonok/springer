package org.springframework.beans.factory.context;

public interface ApplicationListener<E> {
    void onApplicationEvent(E event);
}
