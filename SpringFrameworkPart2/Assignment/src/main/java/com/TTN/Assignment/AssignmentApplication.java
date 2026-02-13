package com.TTN.Assignment;

import com.TTN.Assignment.TTNComponent.*;
import com.TTN.Assignment.TTNComponentLooseCoupling.TTNInterfaces.CompetencyInterface;
import com.TTN.Assignment.TTNComponentLooseCoupling.TTNInterfaces.ShiftInterface;
import com.TTN.Assignment.TTNComponentLooseCoupling.TTNInterfaces.ZoneInterface;
import com.TTN.Assignment.question3And4And5.TTN;
import com.TTN.Assignment.question6.*;
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


	public static void main(String[] args) {
		System.out.println("................Tight Coupling...............");
		AssignmentApplication a1 = new AssignmentApplication();
		a1.makeTTN1("JVM", "morning", "India");

		System.out.println("................Loose Coupling...............");
		CompetencyInterface competency = new CompetencyLooseCoupling("Java");
		ShiftInterface shift = new ShiftLooseCoupling("morning");
		ZoneInterface zone = new ZoneLooseCoupling("India");

		TTNLooseCoupling t1 = new TTNLooseCoupling(competency, shift, zone);
		t1.showDetails();


		var context = SpringApplication.run(AssignmentApplication.class, args);

		System.out.println("========== Question 3 ==========");

		TTN ttnQ3 = context.getBean(TTN.class);
		ttnQ3.displayProperties();

		System.out.println("========== Question 4 ==========");

		TTN ttnBean = context.getBean(TTN.class);
		ttnBean.displayProperties();

		System.out.println("========== Question 6 ==========");
		System.out.println("Used @Primary and @Qualifier");

		System.out.println("========== Question 6 ==========");

		com.TTN.Assignment.question6.TTN ttnQ6 = context.getBean(com.TTN.Assignment.question6.TTN.class);
		ttnQ6.display();

	}

}
