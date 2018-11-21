package com.data.ambience;

import com.data.ambience.Electricity;
import com.data.appliances.Appliance;
import com.data.enums.Affliation;
import com.data.enums.Locations;

import java.util.HashSet;

public class ApplianceService {

    private HashSet<Appliance> appliances;
    private HashSet<Appliance> workingAppliances = new HashSet<>();

    public ApplianceService(HashSet<Appliance> appliances) {
        this.appliances = appliances;
    }

    public void turnOnAllAppliances() {
        for (Appliance appliance : appliances) {
            appliance.turnOn();
            workingAppliances.add(appliance);
        }
    }

    public void turnOffAllAppliances() {
        for (Appliance appliance : workingAppliances) {
            appliance.turnOff();
            workingAppliances.remove(appliance);
        }
    }

    public void findAffliatedAppliances(Affliation affliation) {
        for (Appliance appliance : appliances) {
            if (appliance.getAffliation() == affliation) System.out.println(appliance);
        }
    }

    public void findAppliancesInLocation(Locations locations) {
        for (Appliance appliance : appliances) {
            if (appliance.getLocation() == locations) System.out.println(appliance);
        }
    }

    public void turnOnAppliance(Appliance appliance) {
        appliance.turnOn();
    }

    public void turnOffAppliance(Appliance appliance) {
        appliance.turnOff();
    }

    public void turnOnElectricity() {
        Electricity.electricitySwitcher(true);
    }

    public void turnOffElectricity() {
        Electricity.electricitySwitcher(false);
    }
}
