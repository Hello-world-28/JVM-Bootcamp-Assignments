package com.Learn.Spring.Beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

public class Vehicle {
    private String name;
    public String getName(){
        return name;
    }
    public void setName(String str){
        this.name = str;
    }
    public String hello(){
        return "Hello, this is a Vehicle type object bean.";
    }

}