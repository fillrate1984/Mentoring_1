package com.data.ambience;

import com.data.appliances.Appliance;
import com.data.exc.NetOverloadException;
import com.data.interfaces.Observer;

import java.util.HashSet;
import java.util.Set;

public class Electricity implements Observer {

    private static boolean electricity = false;
    private static int maximumLoad = 5000;
    private static int currentLoad = 0;
    private Set<Appliance> workingAppliances = new HashSet<>();


    public static int getMaximumLoad() {
        return maximumLoad;
    }

    @Deprecated
    public static int getCurrentLoad() {
        return currentLoad;
    }

    public static boolean isElectricityOn() {
        return electricity;
    }

    public static void electricitySwitcher(boolean isElectricity) {
        electricity = isElectricity;
    }

    @Deprecated
    public void addApplianceToNet(Appliance appliance) {
        workingAppliances.add(appliance);
        currentLoad += appliance.getPower();
        System.out.println("Current load: " + currentLoad);
    }

    @SuppressWarnings("unused")
    public void removeApplianceFromNet(Appliance appliance) {
        workingAppliances.remove(appliance);
        currentLoad -= appliance.getPower();
    }

    public boolean netOverloadCheck(Appliance appliance) {
        int appliancePower = appliance.getPower();
        if ((appliancePower + currentLoad) > maximumLoad) return false;
        return true;
    }

    private void turnOffAllAppliances() {
        for(Appliance appliance : workingAppliances) {
            appliance.switchOff();
        }
        workingAppliances.clear();
        currentLoad = 0;
        electricitySwitcher(false);
    }

    @Override
    public void handleEvent(Appliance appliance, boolean condition) throws NetOverloadException {
        if (netOverloadCheck(appliance)) {
            addApplianceToNet(appliance);
        } else {
            turnOffAllAppliances();
            throw new NetOverloadException();
        }
    }
}
