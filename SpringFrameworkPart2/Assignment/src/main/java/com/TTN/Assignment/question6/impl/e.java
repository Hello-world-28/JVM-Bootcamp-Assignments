package com.TTN.Assignment.question6.impl;

import com.TTN.Assignment.question6.interfaces.Competency;
import org.springframework.stereotype.Component;

@Component
public class JavaCompetency implements Competency {

    @Override
    public void show() {
        System.out.println("Competency: Java");
    }
}
