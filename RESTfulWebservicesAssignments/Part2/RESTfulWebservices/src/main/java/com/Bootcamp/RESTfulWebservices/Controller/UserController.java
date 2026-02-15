package com.Bootcamp.RESTfulWebservices.Controller;

import com.Bootcamp.RESTfulWebservices.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "User Controller", description = "APIs for managing users")
@RestController
@RequestMapping("/users")
public class UserController {

    @Operation(summary = "Get user by id", description = "Returns details of a specific user")
    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @Operation(summary = "Create user", description = "Saves new user details")
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @Operation(summary = "Delete user", description = "Deletes a user by id")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.delete(id);
    }
}
