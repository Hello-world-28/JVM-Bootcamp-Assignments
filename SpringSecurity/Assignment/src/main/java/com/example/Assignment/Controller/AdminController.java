package com.example.Assignment.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @RequestMapping(path="api/admin", method=RequestMethod.GET)
    public ResponseEntity<String> adminMethod(){
        return ResponseEntity.ok("Admin Method");
    }
}
