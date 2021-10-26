package com.github.kelly;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Application {

    public static void main(String[] args) throws ClassNotFoundException {

        // Get Class Inform
        final Class<?> clazz = Task.class;
//        Class.forName("com.github.kelly.Task");

        // Print
        System.out.println("─────────────────");
        System.out.println("clazz.getName() = " + clazz.getName()); // Task
        System.out.println("clazz.getTypeName() = " + clazz.getTypeName()); // same
        System.out.println("clazz.getCanonicalName() = " + clazz.getCanonicalName());
        System.out.println("clazz.getModifiers() = " + clazz.getModifiers());   // public = 1
        System.out.println("─────────────────");
        for (Field field : clazz.getFields()) {
            System.out.println("field = " + field); // none
        }
        System.out.println("─────────────────");
        for (Field declaredField : clazz.getDeclaredFields()) {
            System.out.println("declaredField = " + declaredField);
        }
        System.out.println("─────────────────");
        for (Constructor<?> constructor : clazz.getConstructors()) {
            System.out.println("constructor = " + constructor);
        }
        System.out.println("─────────────────");
        for (Constructor<?> declaredConstructor : clazz.getDeclaredConstructors()) {
            System.out.println("declaredConstructor = " + declaredConstructor);
        }
        System.out.println("─────────────────");
        for (Method method : clazz.getMethods()) {
            System.out.println("method = " + method);
        }
        System.out.println("─────────────────");
        for (Method declaredMethod : clazz.getDeclaredMethods()) {
            System.out.println("declaredMethod = " + declaredMethod);
        }

        System.out.println("─────────────────");
        System.out.println("생성자 API");
        for (Constructor<?> constructor : clazz.getConstructors()) {
            System.out.println("constructor.getDeclaringClass() = " + constructor.getDeclaringClass());
            System.out.println("constructor.getModifiers() = " + constructor.getModifiers());
            System.out.println("─────────────────");
            for (Class<?> parameterType : constructor.getParameterTypes()) {
                System.out.println("parameterType = " + parameterType);
            }
            System.out.println("─────────────────");
        }

        System.out.println("─────────────────");
        System.out.println("fields API");
        final Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println("field.getName() = " + field.getName());
            System.out.println("field.getModifiers() = " + field.getModifiers());
        }

        System.out.println("─────────────────");
        System.out.println("methods API");
        final Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println("method.getName() = " + method.getName());
            // wait(long, int), wait(long), wait()
            final Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("─────────────────");
                System.out.println("parameterType = " + parameterType);
                System.out.println("─────────────────");
            }
            System.out.println("─────────────────");
        }

    }
}
