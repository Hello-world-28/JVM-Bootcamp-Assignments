package com.TTN.Assignment.TTNComponentLooseCoupling;

import com.TTN.Assignment.TTNComponentLooseCoupling.TTNInterfaces.CompetencyInterface;

public class CompetencyLooseCoupling implements CompetencyInterface {
    private final String Competency;

    private CompetencyLooseCoupling(String str){
        this.Competency = str;
    }

    @Override
    public CompetencyLooseCoupling getCompetencyLooseCoupling(String objName){
        return new CompetencyLooseCoupling(objName);
    }
    @Override
    public void competencyLooseCouplingMethod(){
        System.out.println("This is " + Competency + " competency.");
    }
}
