package com.Learn.Spring.Beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {

    @Primary
    @Bean(name="Audi")
    Vehicle vehicle1(){
        var vh = new Vehicle();
        vh.setName("Audi");
        return vh;
    }

    @Bean(value="Thar")
    Vehicle vehicle2(){
        var vh = new Vehicle();
        vh.setName("Thar");
        return vh;
    }

    @Bean("Honda")
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
