package com.TTN.Assignment.TTNComponentLooseCoupling;

import com.TTN.Assignment.TTNComponentLooseCoupling.TTNInterfaces.CompetencyInterface;
import com.TTN.Assignment.TTNComponentLooseCoupling.TTNInterfaces.ShiftInterface;
import com.TTN.Assignment.TTNComponentLooseCoupling.TTNInterfaces.ZoneInterface;

public class TTNLooseCoupling {
    private final CompetencyInterface competency;
    private final ShiftInterface Shift ;
    private final ZoneInterface zone;

    public TTNLooseCoupling(CompetencyInterface competency, ShiftInterface Shift, ZoneInterface zone) {
        this.competency = competency;
        this.zone = zone;
        this.Shift = Shift;
    }

    public void showDetails() {
        competency.competencyLooseCouplingMethod();
        zone.zoneLooseCouplingMethod();
        Shift.shiftLooseCouplingMethod(

        );
    }

}
