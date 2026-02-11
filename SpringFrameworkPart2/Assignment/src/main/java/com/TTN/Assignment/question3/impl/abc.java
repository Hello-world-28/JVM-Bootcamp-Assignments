package com.TTN.Assignment.question3.impl;

import com.TTN.Assignment.question3.interfaces.Competency;
import org.springframework.stereotype.Component;

@Component
public class zone implements Competency {

    @Override
    public void show() {
        System.out.println("Competency: Java");
    }
}
