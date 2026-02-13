package com.TTN.Assignment.question3And4And5.impl;

import com.TTN.Assignment.question3And4And5.interfaces.Competency;
import org.springframework.stereotype.Component;

@Component
public class PythonCompetency implements Competency {

    @Override
    public void show() {
        System.out.println("Competency: Python");
    }
}
