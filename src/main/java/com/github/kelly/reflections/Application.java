package com.github.kelly.reflections;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

public class Application {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        Reflections reflections = new Reflections("com.github.kelly.reflections");

        final Set<Class<?>> controllerAnnotationClazz = reflections.getTypesAnnotatedWith(Controller.class);
        for (Class<?> controllerClass : controllerAnnotationClazz) {
            System.out.println("controllerClass.getName() = " + controllerClass.getName());
        }

        final Set<Class<?>> serviceAnnotationClazz = reflections.getTypesAnnotatedWith(Service.class);
        for (Class<?> serviceClass : serviceAnnotationClazz) {
//            final Object newInstance = serviceClass.newInstance();
            System.out.println("serviceClass.getName() = " + serviceClass.getName());
            
            for (Method method : serviceClass.getMethods()) {
                if (method.getName().toLowerCase().contains("message")) {
                    System.out.println("method.getName() = " + method.getName());


                }
            }
        }

    }








}
