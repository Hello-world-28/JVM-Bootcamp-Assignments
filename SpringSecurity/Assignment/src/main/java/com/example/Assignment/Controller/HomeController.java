package com.example.Assignment.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping(path="/home", method= RequestMethod.GET)
    public ResponseEntity<String> home(){
        return ResponseEntity.ok("home dashboard");
    }
}
