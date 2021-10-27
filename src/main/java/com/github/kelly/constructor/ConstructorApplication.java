package com.github.kelly.constructor;

import com.github.kelly.privatefield.PrivateDummy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorApplication {

    public static void main(String[] args)
            throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        // 기본 생성자가 있는 경우
        final Class<?> privateDummyClass = PrivateDummy.class;
        final Object newInstance = privateDummyClass.newInstance();
        System.out.println("기본 생성자가 있는 newInstance = " + newInstance);
        System.out.println("───────────────────────────────────────────────");

        // 기본 생성자가 없는 경우
        final Class<?> clazz = DumbDumb.class;
        try {
            clazz.newInstance();
        } catch (InstantiationException e) {
            System.out.println("기본 생성자가 없으므로 InstantiationException 발생");
            System.out.println("───────────────────────────────────────────────");
        }

        // 파라미터를 가지고 있는 생성자 목록
        final Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("declaredConstructor = " + declaredConstructor);
        }
        System.out.println("───────────────────────────────────────────────");


        // 파라미터를 가지고 있는 생성자 - 인스턴스 생성하기
        // 1. 파라미터가 long 타입인 경우
        final Constructor<?> longTypeConstructor = clazz.getConstructor(long.class);
        final Object longTypeConstructorInstance = longTypeConstructor.newInstance(20211027);
        System.out.println("longTypeConstructorInstance = " + longTypeConstructorInstance);

        // 2. 파라미터가 String 타입인 경우
        final Constructor<?> stringTypeConstructor = clazz.getConstructor(String.class);
        final Object stringTypeConstructorInstance = stringTypeConstructor.newInstance("MyName");
        System.out.println("stringTypeConstructorInstance = " + stringTypeConstructorInstance);

        // 3. 파라미터가 String, long 타입인 경우
        final Constructor<?> stringAndLongTypeConstructor = clazz.getConstructor(new Class[]{String.class, long.class});
        final Object stringAndLongTypeConstructorInstance = stringAndLongTypeConstructor.newInstance("Wednesday", 1027);
        System.out.println("stringAndLongTypeConstructorInstance = " + stringAndLongTypeConstructorInstance);

    }
}
