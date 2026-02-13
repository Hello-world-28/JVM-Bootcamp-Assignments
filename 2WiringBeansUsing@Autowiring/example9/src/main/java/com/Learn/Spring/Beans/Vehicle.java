package com.Learn.Spring.Beans;

public class Vehicle {
    private String name;

    public Vehicle(){
        System.out.println("Vehicle object created");
    }

    public String getName(){
        return name;
    }

    public void setName(String str){
        this.name = str;
    }

    public void printHello(){
        System.out.println("Printing Hello from Vehicle Bean");
    }

    @Override
    public String toString(){
        return "This is Vehicle bean with name : " + name;
    }

}
