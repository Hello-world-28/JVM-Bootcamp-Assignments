package com.TTN.Assignment.question6.impl;

import com.TTN.Assignment.question6.interfaces.Zone;
import org.springframework.stereotype.Component;

@Component
public class IndiaZone implements Zone {

    @Override
    public void show() {
        System.out.println("Zone: India");
    }
}
