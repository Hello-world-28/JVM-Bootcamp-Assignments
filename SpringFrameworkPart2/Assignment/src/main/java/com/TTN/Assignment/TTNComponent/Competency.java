package com.TTN.Assignment.TTNComponent;

public class Competency {
    String competency;
    public Competency(String str){
        this.competency = str;
    }
    public void competencyMethod(){
        System.out.println("This is " + competency + " competency...");
    }
}
