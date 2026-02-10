package com.TTN.Assignment.TTNComponentLooseCoupling.TTNInterfaces;

import com.TTN.Assignment.TTNComponentLooseCoupling.CompetencyLooseCoupling;

public interface CompetencyInterface extends TTNInterface{
    //To return Competency object
    CompetencyLooseCoupling getCompetencyLooseCoupling(String objName);
    void competencyLooseCouplingMethod();
}