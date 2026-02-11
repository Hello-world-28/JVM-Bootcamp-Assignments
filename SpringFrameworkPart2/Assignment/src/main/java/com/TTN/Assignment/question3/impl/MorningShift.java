package com.TTN.Assignment.question3.impl;

import com.TTN.Assignment.question3.interfaces.Shift;
import org.springframework.stereotype.Component;

@Component
public class MorningShift implements Shift {

    @Override
    public void show() {
        System.out.println("Shift: Morning");
    }
}
