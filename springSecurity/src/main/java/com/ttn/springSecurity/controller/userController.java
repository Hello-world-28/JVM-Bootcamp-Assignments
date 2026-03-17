package com.ttn.springSecurity.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//controller accessible after registration with

@RestController
@RequestMapping("/user")
public class userController {
    @GetMapping("/dashboard")
    public String userDashboard(){
        return "Welcome To User DashBoard";
    }
}