package com.TTN.Assignment.TTNComponentLooseCoupling.TTNInterfaces;

import com.TTN.Assignment.TTNComponentLooseCoupling.ShiftLooseCoupling;

public interface ShiftInterface extends TTNInterface{
    //To return Shift object
    ShiftLooseCoupling getShiftLooseCoupling(String objName);
    void shiftLooseCouplingMethod();
}