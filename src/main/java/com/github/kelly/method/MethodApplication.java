package com.github.kelly.method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodApplication {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
        final Class<?> clazz = Class.forName("com.github.kelly.method.MiniJunit3");
        final Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.getName().substring(0, 4).equals("test")) {
                declaredMethod.invoke(clazz.newInstance());     //
            }
        }
    }
}
