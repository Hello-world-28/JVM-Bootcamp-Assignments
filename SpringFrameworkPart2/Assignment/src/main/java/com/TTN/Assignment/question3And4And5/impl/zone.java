package com.TTN.Assignment.question3And4.impl;

import com.TTN.Assignment.question3And4.interfaces.Zone;
import org.springframework.stereotype.Component;

@Component
public class zone implements Zone {
    private final String location = "India";

    public String getLocation() {
        return location;
    }

    @Override
    public void show() {
        System.out.println("Zone : India");
    }
}
