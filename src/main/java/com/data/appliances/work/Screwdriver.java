package com.data.appliances.work;

import com.data.appliances.RechargeableAppliance;
import com.data.enums.Affliation;
import com.data.exc.NetOverloadException;
import com.data.exc.TurnedOffException;
import com.data.interfaces.Observer;
import com.data.enums.Locations;

public class Screwdriver extends RechargeableAppliance {
    public Screwdriver(String name, int power, Locations location, Affliation work) {
        super(name, power, location, work);
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
