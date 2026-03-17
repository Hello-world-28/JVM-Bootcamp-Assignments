package com.ttn.springSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//controller accessibile after login with admin
@RestController
@RequestMapping("/admin")
public class adminController {
    @GetMapping("/dashboard")
    public String adminDashboard(){
        return "Welcome To Admin DashBoard";
    }
}
