package com.TTN.Assignment.question3And4.impl;

import com.TTN.Assignment.question3And4.interfaces.Shift;
import org.springframework.stereotype.Component;

@Component
public class MorningShift implements Shift {
    private final String timing = "Morning";

    public String getTiming() {
        return timing;
    }

    @Override
    public void show() {
        System.out.println("Shift: Morning");
    }
}
