package com.data.appliances.kitchen;

import com.data.appliances.Appliance;
import com.data.enums.Affliation;
import com.data.interfaces.Observer;
import com.data.exc.NetOverloadException;
import com.data.exc.TurnedOffException;
import com.data.enums.Locations;

public class MicrowaveOven extends Appliance {
    public MicrowaveOven(String name, int power, Locations location, Affliation coocking) {
        super(name, power, location, coocking);
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
