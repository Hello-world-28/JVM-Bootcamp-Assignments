package com.Learn.Spring.Main;

import com.Learn.Spring.Beans.ProjectConfig;
import com.Learn.Spring.Beans.Vehicle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example6 {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Vehicle v1 = context.getBean(Vehicle.class);
        System.out.println("Object name : " + v1.getName());
        context.close();
    }
}
