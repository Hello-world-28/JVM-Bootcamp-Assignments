package com.Learn.Spring.beckend.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {

    @GetMapping(path={"/api/dummy/users/{userId}/post/{postId}", "/api/dummy/users/{userId}"})
    public String searchUserPostWithMultiplathVariables(@PathVariable long userId, @PathVariable(required=false) String postId) {
<<<<<<< HEAD
        String response;
        if(postId == null){
            response = ("User id is : " + userId);
        }else{
            response = ("User id is : " + userId + " .Post id is : " + postId);
        }
        return response;
    }
    @GetMapping(path={"/api/dummy/users/{userId}/order/{orderId}"})
    public String searchUserOrdersWithMultiplathVariables(@PathVariable long userId, @PathVariable(name="orderId") String orderNumber)  {
        return ("Fetched User with userId : " + userId + " and order id is : " + orderNumber);
    }
    @GetMapping(path={"/api/dummy/users/{userId}/phone/{phNo}"})
    public String searchUserPhoneNumberWithMultiplathVariables(@PathVariable Map<String, String> pathVariableMap)  {
        return ("Fetched User with userId : " + pathVariableMap.get("userId") + " and phone number is : " + pathVariableMap.get("phNo"));
=======
        return ("User id is : " + userId + " and post id is : " + postId);

>>>>>>> 2003ba7 (Assignment)
    }
}
