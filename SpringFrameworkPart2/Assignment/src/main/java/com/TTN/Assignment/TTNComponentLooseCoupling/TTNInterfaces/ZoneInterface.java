package com.TTN.Assignment.TTNComponentLooseCoupling.TTNInterfaces;

import com.TTN.Assignment.TTNComponentLooseCoupling.ZoneLooseCoupling;

public interface ZoneInterface extends TTNInterface{
    //To return Zone object
    ZoneLooseCoupling getZoneLooseCoupling(String objName);
    void zoneLooseCouplingMethod();
}