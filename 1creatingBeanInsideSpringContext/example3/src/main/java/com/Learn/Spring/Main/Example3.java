package com.Learn.Spring.Main;

import com.Learn.Spring.Beans.ProjectConfig;
import com.Learn.Spring.Beans.Vehicle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example3 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Vehicle v1 = context.getBean("Audi", Vehicle.class);
        System.out.println("This vehicle object is : " + v1.getName());

        Vehicle v2 = context.getBean("Thar", Vehicle.class);
        System.out.println("This vehicle object is : " + v2.getName());

        var v3 = context.getBean("Honda", Vehicle.class);
        System.out.println("This vehicle object is of type : " + v3.getName());
    }
}
