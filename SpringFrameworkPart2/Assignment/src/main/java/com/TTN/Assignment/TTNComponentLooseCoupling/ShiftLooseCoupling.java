package com.TTN.Assignment.TTNComponentLooseCoupling;

import com.TTN.Assignment.TTNComponentLooseCoupling.TTNInterfaces.ShiftInterface;

public class ShiftLooseCoupling implements ShiftInterface {
    private final String Shift;
    public ShiftLooseCoupling(String objName){
        this.Shift = objName;
    }
    @Override
    public void shiftLooseCouplingMethod(){
        System.out.println("This is " + Shift + " shift.");
    }
}