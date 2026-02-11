package com.TTN.Assignment.TTNComponentLooseCoupling;
import com.TTN.Assignment.TTNComponentLooseCoupling.TTNInterfaces.*;

public class CompetencyLooseCoupling implements CompetencyInterface {

    private final String competency;

    public CompetencyLooseCoupling(String competency) {
        this.competency = competency;
    }

    @Override
    public void competencyLooseCouplingMethod() {
        System.out.println("This is " + competency + " competency.");
    }
}