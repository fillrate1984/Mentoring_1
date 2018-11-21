package com.data.appliances.kitchen;

import com.data.appliances.Appliance;
import com.data.enums.Affliation;
import com.data.interfaces.Observer;
import com.data.exc.NetOverloadException;
import com.data.exc.TurnedOffException;
import com.data.enums.Locations;

public class Refrigerator extends Appliance {
    public Refrigerator(String name, int power, Locations location, Affliation food) {
        super(name, power, location, food);
    }

    @Override
    public void use() {
        if(isOn()) {
            System.out.println(getName() + " работает");
        } else {
            throw new TurnedOffException(getName() + " не работает. ");
        }
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyAllObservers() {
        for (Observer observer : observers) {
            try {
                observer.handleEvent(this, isOn);
            } catch (NetOverloadException e) {
                e.printStackTrace();
            }
        }
    }
}
