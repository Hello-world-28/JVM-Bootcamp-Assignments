package com.Learn.Spring.Main;

import com.Learn.Spring.Beans.Person;
import com.Learn.Spring.Beans.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.springframework.context.annotation.AnnotationConfigApplicationContextExtensionsKt.AnnotationConfigApplicationContext;

public class Example9 {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Person p = context.getBean(Person.class);
        System.out.println(p);
        System.out.println(p.getName());
        System.out.println(p.getVehicle());

    }

}