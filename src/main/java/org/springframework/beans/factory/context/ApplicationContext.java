package org.springframework.beans.factory.context;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.bpp.CustomPostProcessor;
import org.springframework.beans.factory.model.ProductService;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;

public class ApplicationContext {

    public ApplicationContext(String basePackage) {
        BeanFactory beanFactory = new BeanFactory();
        try {
            beanFactory.instantiate(basePackage);
            beanFactory.populateProperties();
            beanFactory.injectBeanNames();
            beanFactory.injectBeanFactoryReferences();
            beanFactory.addPostProcessor(new CustomPostProcessor());
            beanFactory.initializeBean();

            ProductService productService = (ProductService) beanFactory.getBean("productService");
            System.out.println(productService);
            System.out.println(productService.getPromotionService());
            System.out.println("Bean name = " + productService.getPromotionService().getBeanName());
            System.out.println("Bean reference = " + productService.getPromotionService().getFactoryReference());

            beanFactory.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
