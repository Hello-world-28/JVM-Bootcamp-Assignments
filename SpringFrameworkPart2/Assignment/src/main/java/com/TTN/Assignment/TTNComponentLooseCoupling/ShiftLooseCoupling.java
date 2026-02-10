package com.TTN.Assignment.TTNComponentLooseCoupling;

import com.TTN.Assignment.TTNComponentLooseCoupling.TTNInterfaces.ShiftInterface;

public class ShiftLooseCoupling implements ShiftInterface {
    private final String Shift;
    private ShiftLooseCoupling(String objName){
        this.Shift = objName;
    }
    @Override
    public ShiftLooseCoupling getShiftLooseCoupling(String objName){
        return new ShiftLooseCoupling(objName);
    }
    @Override
    public void shiftLooseCouplingMethod(){
        System.out.println("This is " + Shift + " shift.");
    }
}