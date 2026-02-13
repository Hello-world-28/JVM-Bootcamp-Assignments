package com.Learn.Spring.Beans;

public class Person {

    private String name;
    private Vehicle Vehicle;

    public Person(){
        System.out.println("Person object created");
    }

    public String getName(){
        return name;
    }

    public void setName(String str){
        this.name = str;
    }

    public String getVehicle(){
        return Vehicle.getName();
    }

    public void setVehicle(Vehicle v){
        this.Vehicle = v;
    }
}
