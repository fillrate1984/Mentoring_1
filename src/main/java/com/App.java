package com;

import com.data.ambience.Ambience;
import com.data.ambience.Electricity;
import com.data.appliances.Appliance;
import com.data.ambience.ApplianceService;

import java.util.HashSet;

public class App {
    public static void main(String[] args) {
        HashSet<Appliance> appliances = Ambience.createAppliances();
        ApplianceService applianceService = new ApplianceService(appliances);
        applianceService.turnOnElectricity();
        applianceService.turnOnAllAppliances();

    }
}
