package com.data.appliances;

import com.data.ambience.Electricity;
import com.data.enums.Affliation;
import com.data.exc.OutOfElectricityException;
import com.data.interfaces.Observable;
import com.data.interfaces.Observer;
import com.data.enums.Locations;

import java.util.ArrayList;

public abstract class Appliance implements Observable {

    protected String name;
    protected int power;
    protected boolean isOn;
    protected Locations location;
    protected Affliation affliation;
    protected ArrayList<Observer> observers = new ArrayList<>();

    public Appliance(String name, int power, Locations location, Affliation affliation) {
        this.name = name;
        this.power = power;
        this.location = location;
        this.affliation = affliation;
    }


    public Affliation getAffliation() {
        return affliation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public boolean isOn() {
        return isOn;
    }

    public Locations getLocation() {
        return location;
    }

    public void setLocation(Locations location) {
        this.location = location;
    }

    public void turnOn() {
        if (Electricity.isElectricityOn()) {
            isOn = true;
            notifyAllObservers();
        } else {
            throw new OutOfElectricityException();
        }

    }

    public void turnOff() {
        isOn = false;
        notifyAllObservers();
    }

    public void switchOff() {
        isOn = false;
    }

    public abstract void use();

    @Override
    public abstract void addObserver(Observer observer);

    @Override
    public abstract void removeObserver(Observer observer);

    @Override
    public abstract void notifyAllObservers();

}
