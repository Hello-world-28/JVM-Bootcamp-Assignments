package com.Learn.Spring.beckend.Controller;

import com.Learn.Spring.beckend.dto.UserDto;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/start")
public class DemoController {

//    @GetMapping("/home")
//    @RequestMapping("/home")
    @RequestMapping(path={"/home", "/home/abc"}, method={RequestMethod.GET, RequestMethod.POST}, consumes="application/json", produces= MediaType.APPLICATION_JSON_VALUE)//MediaType.java
    public ResponseEntity<String> sayHello(){
//        return "Hello World!";
        return ResponseEntity.ok("Hello World!");
    }
    @GetMapping("/end1")
    public ResponseEntity<String> search(@RequestParam(required = false, defaultValue = "Default name as defaultValue") String name, String gender){
//        return ("Fetching user with query param " + name + " and gender is : " +gender);
        String rep = ("Fetching user with query param " + name + " and gender is : " +gender);
        return ResponseEntity.ok(rep);
    }
    @GetMapping("/headers")
    public String readRequestHeader(@RequestHeader("User-Agent") String userAgent, @RequestHeader(name="User-Location",required=false, defaultValue="India") String location){
        return ("Request Header \n" +
                "User-Agent : " + userAgent +
                "\nUser Location : " + location);
    }
    @GetMapping("/headers/map")
    public String readRequestHeaderWithMap(@RequestHeader Map<String, String> requestHeaders)  {
        return ("Request Header \n" +
                "User-Agent : " + requestHeaders.get("User-Agent") +
                "\nUser Location : " + requestHeaders.get("User-Location"));
    }
    @GetMapping("/headers/httpHeaders")
    public String readRequestHeaderWithHttpHeaders(@RequestHeader HttpHeaders requestHeaders)  {
        return ("Request Header \n" +
                "User-Agent : " + requestHeaders.get("User-Agent") +
                "\nUser Location : " + requestHeaders.get("User-Location"));
    }
    @PostMapping
    public String createUser(@RequestBody UserDto userdto){
        return "Created ne user : " + userdto.toString();
    }
    @PostMapping("/request-entity")
    public ResponseEntity createuserWithRequestEntity(RequestEntity<UserDto> requestEntity){
        HttpHeaders httpHeader = requestEntity.getHeaders();
        UserDto userDto = requestEntity.getBody();
        String queryParam = requestEntity.getUrl().getQuery();
        String pathVar = requestEntity.getUrl().getPath();
//        return "Created User with the following data \nHeader : " + httpHeader.toString()
//                +"\nBody : " + userDto.toString()
//                +"\nQueryParam : " + queryParam
//                +"\nPath variable : " + pathVar;
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("custom-header", "ExampleValue")
                .body("Created User with data : " + userDto.toString());
    }
}