package com.github.kelly.reflections;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

public class Application {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        Reflections reflections = new Reflections("com.github.kelly.reflections");

        // controller component scan
        final Set<Class<?>> controllerAnnotationClazz = reflections.getTypesAnnotatedWith(Controller.class);
        for (Class<?> controllerClass : controllerAnnotationClazz) {
            System.out.println("controllerClass.getName() = " + controllerClass.getName());
        }
        System.out.println("──────────────────────────────────────────────────────");

        // service component scan
        final Set<Class<?>> serviceAnnotationClazz = reflections.getTypesAnnotatedWith(Service.class);
        for (Class<?> serviceClass : serviceAnnotationClazz) {
            System.out.println("serviceClass.getName() = " + serviceClass.getName());
            
            for (Method method : serviceClass.getMethods()) {
                if (method.getName().toLowerCase().contains("success")) {
                    method.invoke(serviceClass.newInstance());
                }
            }
        }
        System.out.println("──────────────────────────────────────────────────────");

        // repository component scan
        final Reflections reflectionsTest = new Reflections("com.github.kelly.reflections", "com.github.kelly.annotation");
        final Set<Class<?>> repositoryAnnotationClazz = reflectionsTest.getTypesAnnotatedWith(Repository.class);
        for (Class<?> repositoryClass : repositoryAnnotationClazz) {
            System.out.println("repositoryClass.getName() = " + repositoryClass.getName());
        }


    }








}
