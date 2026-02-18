package com.Learn.Spring.beckend.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api/web/mvc/config/versions/{v}")
@RequestMapping("/api/web/mvc/config/versions")
public class VersionController {

    @GetMapping(version="1.0")
    public ResponseEntity<String> defaultVersion(){
        return ResponseEntity.ok("API Version : 1.0.0");
    }
    @GetMapping(version="2.0+")
    public ResponseEntity<String> v2Version(){
        return ResponseEntity.ok("API Version = 2.0.");
    }
}
