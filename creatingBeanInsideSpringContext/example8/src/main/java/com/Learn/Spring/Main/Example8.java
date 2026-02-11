package com.Learn.Spring.Main;

import com.Learn.Spring.Beans.Vehicle;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Example8 {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        var v1 = context.getBean(Vehicle.class);
        System.out.println("This is : " + v1.getName());
    }
}