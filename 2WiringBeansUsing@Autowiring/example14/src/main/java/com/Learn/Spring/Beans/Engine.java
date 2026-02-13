package com.Learn.Spring.Beans;

public class Engine {
    private String name;

    public Engine(){
        System.out.println("Engine Bean Created!");
    }
    public void setName(String str){
        this.name = str;
    }
    public String getName(){
        return name;
    }
}
