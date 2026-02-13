package com.Learn.Spring.Beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Espresso implements Coffee{
    @Override
    public String makeCoffee(){
        return "Espresso Coffee";
    }
}
