package com.Learn.Spring.Beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    public Vehicle vehicle(){
        Vehicle v1 = new Vehicle();
        v1.setName("Audi");
        return v1;
    }

    @Bean
    public Person person(){
        Person p1 = new Person();
        p1.setName("Padam");
        p1.setVehicle(vehicle());
        return p1;
    }
}
