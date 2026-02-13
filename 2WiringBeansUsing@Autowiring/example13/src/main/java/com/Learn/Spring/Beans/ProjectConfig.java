package com.Learn.Spring.Beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
@ComponentScan(basePackages="com.Learn.Spring.Beans")
public class ProjectConfig {
    @Bean
    public Engine engine(){
        System.out.println("Engine bean created!");
        return new Engine();
    }

    @Bean
    @DependsOn("engine")
    public Vehicle vehicle(){
        System.out.println("Vehicle bean created!");
        return new Vehicle();
    }
}
