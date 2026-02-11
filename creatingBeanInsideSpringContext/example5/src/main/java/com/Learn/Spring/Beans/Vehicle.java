package com.Learn.Spring.Beans;

import org.springframework.stereotype.Component;

@Component
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