package com.Learn.Spring.Main;

import com.Learn.Spring.Beans.ProjectConfig;
import com.Learn.Spring.Beans.Vehicle;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.function.Supplier;

public class Example7 {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle sukoda = new Vehicle();
        sukoda.setName("Sukoda");
        Supplier<Vehicle> sukodaSupplier = () -> sukoda;
        Supplier<Vehicle> audiSupplier = () -> {
            var audi = new Vehicle();
            audi.setName("Audi");
            return audi;
        };

        Random randomInt = new Random();
        int randomNumber = randomInt.nextInt(10);
        System.out.println("The random number choosen is : " + randomNumber);
        System.out.println("If random number is even create Sukoda object");
        System.out.println("If random number is even create Audi object");
        if(randomNumber % 2 == 0 ){
            context.registerBean("Sukoda", Vehicle.class, sukodaSupplier);
        }else{
            context.registerBean("Audi", Vehicle.class, audiSupplier);
        }

        Vehicle sukodaVehicle = null;
        Vehicle audiVehicle = null;

        try{
            sukodaVehicle = context.getBean("Sukoda", Vehicle.class);
        }catch(NoSuchBeanDefinitionException e){
            System.out.println("Error while getting sukoda vehicle.");
        }
        try{
            audiVehicle = context.getBean("Audi", Vehicle.class);
        }catch(NoSuchBeanDefinitionException e){
            System.out.println("Error while getting audi vehicle");
        }

        if(sukodaVehicle!=null){
            System.out.println("This is : " + sukodaVehicle.getName());
        }else{
            System.out.println("This is : " + audiVehicle.getName());
        }
    }
}
