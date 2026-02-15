package com.Learn.Spring.beckend.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping(path="/api/dummy/users/{userId}/post/{postId}")
    public String searchUserPostWithMultiplathVariables(@PathVariable long userId, @PathVariable(required=false) String postId) {
        return ("User id is : " + userId + " and post id is : " + postId);
    }
//    @GetMapping(path="/user/{id}/post/{postNo}")
//    public String getUserPost(@PathVariable String id, @PathVariable int postNo){
//        return ("User id is : " + id + " and postNo is : " + id);
//    }
}
