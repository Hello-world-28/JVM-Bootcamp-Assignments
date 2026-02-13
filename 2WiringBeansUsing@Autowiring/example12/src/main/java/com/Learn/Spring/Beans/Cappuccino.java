package com.Learn.Spring.Beans;

import org.springframework.stereotype.Component;

@Component("cappuccino")
public class Cappuccino implements Coffee{
    String name;
    @Override
    public String makeCoffee(){
        return "Cappuccino Coffee";
    }
}
