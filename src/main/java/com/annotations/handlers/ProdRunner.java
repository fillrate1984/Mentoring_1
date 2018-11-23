package com.annotations.handlers;

import com.annotations.ProdCode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ProdRunner {

    public static void run(Object object) {
        Method[] methods = object.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(ProdCode.class)) {
                try {
                    method.invoke(object);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
