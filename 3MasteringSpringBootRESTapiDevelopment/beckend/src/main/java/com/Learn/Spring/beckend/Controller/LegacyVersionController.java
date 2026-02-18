package com.Learn.Spring.beckend.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/legacy/version")
public class LegacyVersionController {

    @GetMapping({"", "/", "/v1"})
    public ResponseEntity<String> defaultPathVersion(){
        return ResponseEntity.ok("This is default/v1 version.");
    }
    @GetMapping("v2")
    public ResponseEntity<String> pathV2Version(){
        return ResponseEntity.ok("This is v2 version");
    }

    @GetMapping(params="version=1")
    public ResponseEntity<String> defaultRequestParamVersion(){
        return ResponseEntity.ok("Response from defaultRequestParamVersion API 1.0.0");
    }
    @GetMapping(params="version=2")
    public ResponseEntity<String> v2RequestParamVersion(){
        return ResponseEntity.ok("Response from v2RequestParamVersion API 2.0.0");
    }

    @GetMapping(path="/HeaderVersion",headers="X-API-VERSION=1")
    public ResponseEntity<String> defaultHeaderVersion(){
        return ResponseEntity.ok("default header version = 1");
    }
    @GetMapping(path="/HeaderVersion", headers="X-API-Version=2")
    public ResponseEntity<String> v2ReqHeaderVersion(){
        return ResponseEntity.ok("version = 2");
    }

    @GetMapping(path="/MediaType", produces="application/vnd.Saurabh.v1+json")
    public ResponseEntity<String> defaultMediaTypeVersion(){
        return ResponseEntity.ok("This is version 1");
    }
    @GetMapping(path="/MediaType", produces="application/vnd.Saurabh.v2+json")
    public ResponseEntity<String> v2MediatypeVersion(){
        return ResponseEntity.ok("This is version = 2");
    }
}