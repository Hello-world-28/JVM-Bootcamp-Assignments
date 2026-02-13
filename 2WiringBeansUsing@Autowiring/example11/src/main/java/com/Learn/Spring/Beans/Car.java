package com.Learn.Spring.Beans;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {


    public String name;
//    @Autowired
    public final Engine engine; //final only allowed with constructor autowiring

    @Autowired//optional if only 1 constructor is available
    public Car(Engine engine){
        this.engine = engine;
    }

//    Car(){
//        System.out.println("Car bean is created by spring.");
//    }
    public String getName(){
        return name;
    }
    public void setName(String str){
        this.name = str;
    }
//    @Autowired
//    public void setEngine(Engine engine){
//        this.engine = engine;
//    }
    @PostConstruct
    public void init(){
        this.name = "Audi";
    }
    @Override
    public String toString(){
        return "Vehicle : {name : "+ name + " }";
    }
}