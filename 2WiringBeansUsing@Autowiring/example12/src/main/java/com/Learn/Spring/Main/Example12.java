package com.Learn.Spring.Main;

import com.Learn.Spring.Beans.Coffee;
import com.Learn.Spring.Beans.CoffeeShop;
import com.Learn.Spring.Beans.ProgramConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example12 {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProgramConfig.class);
        var c1 = context.getBean(CoffeeShop.class);
        System.out.println(c1.getCoffee().makeCoffee());
    }

}