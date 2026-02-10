package com.Learn.Spring.Beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {

    @Bean
    Vehicle vehicle1(){
        var vh = new Vehicle();
        vh.setName("Audi");
        return vh;
    }

    @Bean
    Vehicle vehicle2(){
        var vh = new Vehicle();
        vh.setName("Thar");
        return vh;
    }

    @Bean
    Vehicle vehicle3(){
        var vh = new Vehicle();
        vh.setName("Honda");
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
}
