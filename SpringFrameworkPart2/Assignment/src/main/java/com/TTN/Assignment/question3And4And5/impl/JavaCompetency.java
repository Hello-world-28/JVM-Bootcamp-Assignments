package com.TTN.Assignment.question3And4.impl;

import com.TTN.Assignment.question3And4.interfaces.Competency;
import org.springframework.stereotype.Component;

@Component
public class JavaCompetency implements Competency {
    private final String name = "Java";

    public String getName() {
        return name;
    }

    @Override
    public void show() {
        System.out.println("Competency: Java");
    }
}
