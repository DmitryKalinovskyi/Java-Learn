package com.education.ztu.Task3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException {
        Class aClass = Product.class;
        Class bClass = Class.forName("com.education.ztu.Task3.Product");
        Class cClass = new Product("Laptop", 200, "Acer").getClass();

        System.out.println(aClass);
        System.out.println(bClass);
        System.out.println(cClass);

        for(Field field : aClass.getDeclaredFields()){
            System.out.println(field);
        }

        for(Method method : aClass.getDeclaredMethods()){
            System.out.println(method);
        }

        for(Constructor<?> constructor : aClass.getDeclaredConstructors()){
            System.out.println(constructor);
        }

        Product product = new Product("Laptop", 200, "Acer");
        Field priceField = aClass.getDeclaredField("price");
        System.out.println(product.getPrice());
        priceField.setAccessible(true);
        priceField.set(product, 300);
        System.out.println(product.getPrice());
    }

}
