package com.Learn.Spring.Main;

import com.Learn.Spring.Beans.ProjectConfig;
import com.Learn.Spring.Beans.Vehicle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example2 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Vehicle v1 = context.getBean(Vehicle.class);
    }
}
