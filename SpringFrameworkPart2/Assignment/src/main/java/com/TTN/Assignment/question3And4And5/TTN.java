package com.TTN.Assignment.question3And4;

import com.TTN.Assignment.question3And4.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TTN {

    private final Competency competency;
    private final Shift shift;
    private final Zone zone;

    @Autowired
    public TTN(Competency competency, Shift shift, Zone zone) {
        this.competency = competency;
        this.shift = shift;
        this.zone = zone;
    }

    public void displayProperties() {
        System.out.println("----- TTN Properties -----");
        competency.show();
        shift.show();
        zone.show();
    }
}
