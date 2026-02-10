package com.TTN.Assignment.TTNComponentLooseCoupling;

import com.TTN.Assignment.TTNComponentLooseCoupling.TTNInterfaces.ZoneInterface;

public class ZoneLooseCoupling implements ZoneInterface {
    private final String Zone;
    private ZoneLooseCoupling(String objName){
        this.Zone = objName;
    }
    @Override
    public ZoneLooseCoupling getZoneLooseCoupling(String objName){
        return new ZoneLooseCoupling(objName);
    }
    @Override
    public void zoneLooseCouplingMethod(){
        System.out.println("This is " + Zone + "zone.");
    }
}