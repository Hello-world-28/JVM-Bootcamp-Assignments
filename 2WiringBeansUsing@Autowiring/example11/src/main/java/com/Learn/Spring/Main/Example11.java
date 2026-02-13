package com.Learn.Spring.Main;

import com.Learn.Spring.Beans.Car;
import com.Learn.Spring.Beans.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example11 {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Car c = context.getBean(Car.class);
        System.out.println("Car name : " + c.name);
        System.out.println("Car engine is  : " + c.engine);
    }

}