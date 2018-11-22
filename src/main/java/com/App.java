package com;

import com.data.ambience.Electricity;
import com.data.appliances.Appliance;
import com.data.ambience.ApplianceService;
import com.data.appliances.information.NoteBook;
import com.data.appliances.kitchen.DischWasher;
import com.data.appliances.work.Drill;
import com.data.enums.Affliation;
import com.data.enums.Locations;
import com.data.interfaces.Observer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;

public class App {
    public static void main(String[] args) {
        /*HashSet<Appliance> appliances = initAppliances(new Electricity());
        setElectricityNetMaximumLoad(10000);
        System.out.println(Electricity.getMaximumLoad());
        ApplianceService applianceService = new ApplianceService(appliances);
        applianceService.turnOnElectricity();
        applianceService.turnOnAllAppliances();

        for (Appliance appliance : appliances) {
            try {
                appliance.getClass().getMethod("use").invoke(appliance);

            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }*/

        describeApplianceClasses();

    }

    public static HashSet<Appliance> initAppliances(Observer observer) {
        HashSet<Appliance> appliances = new HashSet<>();
        Appliance newAppliance = null;
        Class[] params = new Class[]{String.class, int.class, Locations.class, Affliation.class};

        try {
            Class clazz = Class.forName(DischWasher.class.getName());
            Constructor constructor = clazz.getConstructor(params);
            newAppliance = (Appliance) constructor.newInstance("Посудомоечная машина", 600, Locations.KITCHEN, Affliation.CLEANING);
            appliances.add(newAppliance);

            clazz = Class.forName(NoteBook.class.getName());
            constructor = clazz.getConstructor(params);
            newAppliance = (Appliance) constructor.newInstance("Ноутбук", 120, Locations.BEDROOM, Affliation.INFORMATION);
            appliances.add(newAppliance);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

        for (Appliance appliance : appliances) {
            appliance.addObserver(observer);
        }

        return appliances;
    }

    public static void setElectricityNetMaximumLoad(int value) {
        try {
            Class clazz = Class.forName(Electricity.class.getName());
            Field field = clazz.getDeclaredField("maximumLoad");
            field.setAccessible(true);
            field.setInt(clazz, value);
        } catch (ClassNotFoundException | NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void describeApplianceClasses() {
        HashSet<Class> classes = new HashSet<>();
        classes.add(NoteBook.class);
        classes.add(DischWasher.class);
        classes.add(Drill.class);
        classes.add(Electricity.class);

        for (Class clazz : classes) {
            Field[] fields = clazz.getDeclaredFields();
            Method[] methods = clazz.getDeclaredMethods();
            String classData = clazz.toString();
            String className = classData.substring(classData.lastIndexOf('.') + 1);
            System.out.println(String.format("-----------------------------Class: %s-----------------------------", className));

            for (Field field : fields) {
                String fieldData = field.toString();
                String fielddName = fieldData.substring(fieldData.lastIndexOf('.') + 1);
                String fieldAcces = fieldData.substring(0, fieldData.indexOf(' '));
                System.out.println("Field: " + fieldAcces + " " + fielddName);
            }

            for (Method method : methods) {
                String methodData = method.toString();
                String methodName = methodData.substring(methodData.lastIndexOf('.') + 1);
                String methodAccess = methodData.substring(0, methodData.indexOf(' '));
                System.out.println("Method: " + methodAccess + " " + methodName);
            }
        }
    }
}
