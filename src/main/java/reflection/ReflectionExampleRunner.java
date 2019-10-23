package reflection;

import reflection.common.ClassReflection;
import reflection.common.ClassReflectionExampleImpl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionExampleRunner {

    public void runReflection() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassReflectionExampleImpl example = new ClassReflectionExampleImpl();
        //annotations
        for (Annotation annotation : example.getClass().getDeclaredAnnotations()) {
            System.out.println(annotation);
        }
        //constructors
        for (Constructor<?> constructor : example.getClass().getDeclaredConstructors()) {
            System.out.println(constructor);
        }
        //fields
        for (Field field : example.getClass().getDeclaredFields()) {
            System.out.println(field);
        }
        //methods
        for (Method method : example.getClass().getDeclaredMethods()) {
            System.out.println(method);
        }

        //create newInstance by className
        Class clazz = Class.forName(ClassReflection.class.getName());
        ClassReflection exampleInstance = (ClassReflection) clazz.newInstance();
        exampleInstance.setParentName("Class name by reflection");
        System.out.println(exampleInstance);
        System.out.println("Super class for example:"+exampleInstance.getClass().getSuperclass().getName());
    }
}
