package com.annotations.handlers;

import com.annotations.Smells;
import com.annotations.ThisCodeSmells;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ThisCodeSmellsHandler {

    public static void handle(Class<?> clazz) {
        checkClass(clazz);
        checkConstructors(clazz);
        checkMethods(clazz);
        checkFields(clazz);
    }

    private static void checkClass(Class<?> clazz) {
        boolean isSmellsPresent = clazz.isAnnotationPresent(ThisCodeSmells.class);
        boolean isReviewerPresent = clazz.isAnnotationPresent(Smells.class);

        if (isReviewerPresent || isSmellsPresent) {
            String classData = clazz.getName();
            String className = classData.substring(classData.lastIndexOf('.') + 1);
            System.out.printf(">>>>>>>>>>>>>>> Class {%s} has @ThisCodeSmells <<<<<<<<<<<<<<<\n", className);
        }

        if (isReviewerPresent) {
            Smells smellsArray = clazz.getAnnotation(Smells.class);
            printVoters(smellsArray);
        }

        if (isSmellsPresent) {
            System.out.println("1 vote:");
            String voter = clazz.getAnnotation(ThisCodeSmells.class).name();
            System.out.println(voter);
        }
    }

    private static void checkFields(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            boolean isReviewerPresent = field.isAnnotationPresent(Smells.class);
            boolean ifSmellsPresent = field.isAnnotationPresent(ThisCodeSmells.class);

            if (isReviewerPresent || ifSmellsPresent) {
                String fieldData = field.getName();
                String fieldName = fieldData.substring(fieldData.lastIndexOf('.') + 1);
                System.out.printf("<---- Field '%s' has @ThisCodeSmells ---->\n", fieldName);
            }

            if (isReviewerPresent) {
                Smells smellsArray = field.getAnnotation(Smells.class);
                printVoters(smellsArray);
            }

            if (ifSmellsPresent) {
                System.out.println("1 vote:");
                String voter = field.getAnnotation(ThisCodeSmells.class).name();
                System.out.println(voter);
            }
        }
    }

    private static void checkMethods(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {

            boolean isReviewerPresent = method.isAnnotationPresent(Smells.class);
            boolean isSmellsPresent = method.isAnnotationPresent(ThisCodeSmells.class);

            if (isReviewerPresent || isSmellsPresent) {
                String methodData = method.toString();
                String methodName = methodData.substring(methodData.lastIndexOf('.') + 1);
                System.out.printf("---------- Method '%s' has @ThisCodeSmells ----------\n", methodName);
            }

            if (isReviewerPresent) {
                Smells smellsArray = method.getAnnotation(Smells.class);
                printVoters(smellsArray);
            }

            if (isSmellsPresent) {
                System.out.println("1 vote:");
                String voter = method.getAnnotation(ThisCodeSmells.class).name();
                System.out.println(voter);
            }
        }
    }

    private static void checkConstructors(Class<?> clazz) {
        Constructor[] constructors = clazz.getDeclaredConstructors();

        for (Constructor constructor : constructors) {
            boolean isThisCodeSmellsPresent = constructor.isAnnotationPresent(ThisCodeSmells.class);
            boolean isSmellsPresent = constructor.isAnnotationPresent(Smells.class);

            if (isSmellsPresent || isThisCodeSmellsPresent) {
                String contructorName = constructor.getName();
                System.out.printf("++++ '%s' annotated with @ThisCodeSmells ++++\n", contructorName);
            }

            if (isThisCodeSmellsPresent) {
                System.out.println("1 vote:");
                ThisCodeSmells smells = (ThisCodeSmells) constructor.getAnnotation(ThisCodeSmells.class);
                String voter = smells.name();
                System.out.println(voter);
            }

            if (isSmellsPresent) {
                Smells smells = (Smells) constructor.getAnnotation(Smells.class);
                printVoters(smells);
            }
        }
    }

    private static void printVoters(Smells smellsArray) {
        ThisCodeSmells[] smells = smellsArray.value();
        System.out.printf("%d votes:\n", smells.length);
        for (ThisCodeSmells smell : smells) {
            System.out.println(smell.name());
        }
    }
}
