package com.TTN.Assignment;

import com.TTN.Assignment.TTNComponent.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.TTN.Assignment.TTNComponentLooseCoupling.*;

@SpringBootApplication
public class AssignmentApplication {
	//tight coupling
	void makeTTN1(String competency, String shift, String zone){
		Competency comp = new Competency(competency);
		comp.competencyMethod();

		Shift sh = new Shift(shift);
		sh.shiftMethod();

		Zone zn = new Zone(zone);
		zn.zoneMethod();
	}
	//Loose Coupling
	void makeTTN2(String competency, String shift, String zone){
		Competency comp = getCompetencyLooseCoupling("JavaScript");
		comp.competencyMethod();

		Shift sh = new Shift(shift);
		sh.shiftMethod();

		Zone zn = new Zone(zone);
		zn.zoneMethod();
	}



	public static void main(String[] args) {
		System.out.println("................Tight Coupling...............");
		AssignmentApplication a1 = new AssignmentApplication();
		a1.makeTTN1("JVM", "morning", "India");

		System.out.println("................Loose Coupling...............");


		SpringApplication.run(AssignmentApplication.class, args);
	}

}
