package com.Learn.Spring.Beans;

public class Vehicle {
    private String name;
    private Engine engine;

    public Vehicle(){
        System.out.println("Vehicle Bean Created!");
    }
    public void setName(String str){
        this.name = str;
    }
    public String getName(){
        return name;
    }
//    public String getEngine(){
//        return engine.getName();
//    }
//    public String toString{
//        return ("The Vehicle name is : " + name + "\n It has : " + engine + " engine.");
//    }

}
