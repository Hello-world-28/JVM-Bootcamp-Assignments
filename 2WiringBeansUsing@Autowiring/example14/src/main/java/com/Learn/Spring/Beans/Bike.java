package com.Learn.Spring.Beans;

public class Bike {
    private String name;

    public Bike(){
        System.out.println("Bike bean created");
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
