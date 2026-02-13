package com.Learn.Spring.Main;

import com.Learn.Spring.Beans.Bike;
import com.Learn.Spring.Beans.Engine;
import com.Learn.Spring.Beans.ProjectConfig;
import com.Learn.Spring.Beans.Vehicle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class example14 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        if(context.containsBean("engine")){
            Engine e1 = context.getBean(Engine.class);
        }
        if(context.containsBean("vehicle")){
            Vehicle v1 = context.getBean(Vehicle.class);
        }
        if(context.containsBean("bike")){
            Bike b1 = context.getBean(Bike.class);
        }
    }
}
