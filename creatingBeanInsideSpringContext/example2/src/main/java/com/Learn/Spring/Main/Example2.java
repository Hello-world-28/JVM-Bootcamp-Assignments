package com.Learn.Spring.Main;

import com.Learn.Spring.Beans.ProjectConfig;
import com.Learn.Spring.Beans.Vehicle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example2 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Vehicle v1 = context.getBean("vehicle1", Vehicle.class);
        System.out.println("This vehicle object is : " + v1.getName());

        Vehicle v2 = context.getBean("vehicle2", Vehicle.class);
        System.out.println("This vehicle object is : " + v2.getName());
    }
}
