package com.data.interfaces;

import com.data.appliances.Appliance;
import com.data.exc.NetOverloadException;

@FunctionalInterface
public interface Observer {
    void handleEvent(Appliance appliance, boolean condition) throws NetOverloadException;
}
