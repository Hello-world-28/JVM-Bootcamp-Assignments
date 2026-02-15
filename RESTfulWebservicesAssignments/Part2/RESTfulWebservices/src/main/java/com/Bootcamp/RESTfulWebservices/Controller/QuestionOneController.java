package com.Bootcamp.RESTfulWebservices.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionOneController {

    @GetMapping(path="/Bootcamp")
    public String BootcampMessage(){
        return "Welcome to spring boot";
    }
}
