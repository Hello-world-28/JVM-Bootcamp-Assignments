package com.Learn.Spring.Beans;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Engine {
    public String name;

    public Engine(){
        System.out.println("Engine bean created by Spring.");
    }
    public String getName(){
        return name;
    }
    public void setName(String str){
        this.name = str;
    }
    @PostConstruct
    public void initialize(){
        this.name = "GE404";
    }
    @Override
    public String toString(){
        return "Engine : " + name;
    }
}
