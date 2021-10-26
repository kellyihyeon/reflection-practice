package com.github.kelly.privatefield;

import java.lang.reflect.Field;

public class PrivateApplication {

    public static void main(String[] args) throws IllegalAccessException {
        final Class<?> clazz = PrivateDummy.class;
        final Field[] declaredFields = clazz.getDeclaredFields();
        final PrivateDummy privateDummy = new PrivateDummy();

        System.out.println("───────setting: before───────────");
        System.out.println("privateDummy.getNumber() = " + privateDummy.getNumber());
        System.out.println("privateDummy.getTitle() = " + privateDummy.getTitle());
        System.out.println("privateDummy.getDetails() = " + privateDummy.getDetails());

        System.out.println("───────setting: after───────────");
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
        }
        declaredFields[0].set(privateDummy, 2021L);
        declaredFields[1].set(privateDummy, "제발 세팅 돼라. plz...");
        declaredFields[2].set(privateDummy, "아 인덱스 이용해서 하는 거구나? ㅎ_ㅎ");
        
        System.out.println("privateDummy.getNumber() = " + privateDummy.getNumber());
        System.out.println("privateDummy.getTitle() = " + privateDummy.getTitle());
        System.out.println("privateDummy.getDetails() = " + privateDummy.getDetails());
    }
}
