package com.github.kelly.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationApplication {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException {
        final Class<?> clazz = Class.forName("com.github.kelly.annotation.MiniJunit4");
        final Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.isAnnotationPresent(RunTest.class)) {
                declaredMethod.invoke(clazz.newInstance());
            }
        }
    }
}
