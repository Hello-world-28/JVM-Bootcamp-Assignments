package com.Learn.Spring.Beans;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class Company {
    private String name;
    public Company(){
        System.out.println("Company Bean Created");
    }
}
