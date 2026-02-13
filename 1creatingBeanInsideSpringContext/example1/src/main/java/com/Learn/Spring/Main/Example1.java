package com.Learn.Spring.Main;

import com.Learn.Spring.Beans.ProjectConfig;
import com.Learn.Spring.Beans.Vehicle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example1 {

    public static void main(String[] args) {
        //Vehicle object created with new keyword outside Spring IoC container
        Vehicle v1 = new Vehicle();
        v1.setName("Tesla S3");
        System.out.println("Vehicle object is created outside Spring IoC Container whose name is : " + v1.getName());

        //Creating Object in Spring IoC container
        //Initializing spring IoC container
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle v2 = context.getBean(Vehicle.class);
        System.out.println("This Vehicle object is created inside Spring IoC Container, the name of Vehicle object is : " + v2.getName());
        //Singleton beans must be either immutable or stateless.
        v2.setName("Thar");//dangerous in real systems: mutation affects every consumer + multiple threads will see this => race conditions
        System.out.println("This Vehicle object is created inside Spring IoC Container, the name of Vehicle object is : " + v2.getName());

        String helloObject = context.getBean(String.class);
        System.out.println(helloObject);

        Integer intObj = context.getBean(Integer.class);
        System.out.println(intObj);
    }

}
