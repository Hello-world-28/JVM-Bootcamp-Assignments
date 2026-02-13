package com.Learn.Spring.Beans;

import org.springframework.beans.factory.BeanRegistrar;
import org.springframework.beans.factory.BeanRegistry;
import org.springframework.core.env.Environment;

import java.util.Random;

public class Mybean implements BeanRegistrar {

    @Override
    public void register(BeanRegistry registry, Environment env ){
        Random RanInt = new Random();
        int number = RanInt.nextInt(100);
        if(number % 2 == 0){
            System.out.println("Random Number : " + number + "  Therefore, Bean created = Engine -> Vehicle");
            registry.registerBean("engine", Engine.class, spec ->{
                spec.supplier(
                        context -> {
                            Engine engine = new Engine();
                            engine.setName("GE 404");
                            System.out.println(engine.getName());
                            return engine;
                        }
                );
            });
            registry.registerBean("vehicle", Vehicle.class, spec ->{
                spec.supplier(
                        context -> {
                            Vehicle vehicle = new Vehicle();
                            vehicle.setName("Audi");
                            System.out.println(vehicle.getName());
                            return vehicle;
                        }
                );
            });
        }else{
            System.out.println("Random Number : " + number + "  Therefore, Bean created = Bike");
            registry.registerBean("bike", Bike.class, spec ->{
                spec.supplier(
                        context -> {
                        Bike bike = new Bike();
                        bike.setName("R15");
                        return bike;
                });
            });
        }
    }
}
