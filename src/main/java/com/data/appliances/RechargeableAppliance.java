package com.data.appliances;

import com.data.enums.Affliation;
import com.data.enums.Locations;

public abstract class RechargeableAppliance extends Appliance {
    private boolean recharging = false;

    public RechargeableAppliance(String name, int power, Locations location, Affliation affliation) {
        super(name, power, location, affliation);
    }

    public void recharge() {
        recharging = true;
    }

    public void stopRecharging() {
        recharging = false;
    }

    public boolean isRecharging() {
        return recharging;
    }
}
