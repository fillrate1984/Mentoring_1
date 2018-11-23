package com.data.ambience;

import com.annotations.ProdCode;
import com.data.appliances.Appliance;
import com.data.appliances.cleaning.VaacumCleaner;
import com.data.appliances.information.*;
import com.data.enums.Affliation;
import com.data.interfaces.Observer;
import com.data.appliances.kitchen.*;
import com.data.appliances.work.Drill;
import com.data.appliances.work.Screwdriver;
import com.data.enums.Locations;

import java.util.HashSet;

public class Ambience {

    @ProdCode
    public static HashSet<Appliance> createAppliances(Observer observer) {
        HashSet<Appliance> set = new HashSet<>();

        set.add(new VaacumCleaner("Пылесос", 2000, Locations.KITCHEN, Affliation.CLEANING));
        set.add(new Computer("Компьютер", 400, Locations.LOUNGE, Affliation.INFORMATION));
        set.add(new NoteBook("Ноутбук", 200, Locations.BEDROOM, Affliation.INFORMATION));
        set.add(new Phone("Телефон", 30, Locations.BEDROOM, Affliation.INFORMATION));
        set.add(new Radio("Радио", 20, Locations.KITCHEN, Affliation.INFORMATION));
        set.add(new TV("Телевизор", 150, Locations.BEDROOM, Affliation.INFORMATION));
        set.add(new Blender("Блендер", 300, Locations.KITCHEN, Affliation.COOCkING));
        set.add(new DischWasher("Посудомоечная машина", 500, Locations.KITCHEN, Affliation.CLEANING));
        set.add(new FoodProcessor("Кухонный комбаин", 400, Locations.KITCHEN, Affliation.COOCkING));
        set.add(new MicrowaveOven("Микроволновая печь", 2000, Locations.KITCHEN, Affliation.COOCkING));
        set.add(new Refrigerator("Холодильник", 100, Locations.KITCHEN, Affliation.FOOD));
        set.add(new Drill("Дрель", 1000, Locations.LOUNGE, Affliation.WORK));
        set.add(new Screwdriver("Шуруповёрт", 350, Locations.LOUNGE, Affliation.WORK));

        for (Appliance appliance : set) {
            appliance.addObserver(observer);
        }
        return set;
    }

}
