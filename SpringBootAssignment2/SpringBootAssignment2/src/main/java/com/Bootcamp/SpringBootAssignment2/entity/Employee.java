package com.Bootcamp.SpringBootAssignment2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String designation;

    public Employee() {}

    public Employee(String name, String designation) {
        this.name = name;
        this.designation = designation;
    }

}
