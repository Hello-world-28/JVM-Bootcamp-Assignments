package com.Learn.Spring.Beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {

    @Bean
    Vehicle vehicle(){
        var vh = new Vehicle();
        vh.setName("Audi");
        return vh;
    }

    @Bean
    String hello(){
        return "Hello World!";
    }

    @Bean
    Integer returnInt(){
        return 96;
    }

    @Bean
    @Primary
    String welcome(){
        return "Welcome to the Spring Dimention";
    }
}
