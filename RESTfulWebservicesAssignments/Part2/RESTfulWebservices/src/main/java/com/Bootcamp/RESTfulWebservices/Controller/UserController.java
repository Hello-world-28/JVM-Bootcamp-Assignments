package com.Bootcamp.RESTfulWebservices.Controller;
import com.Bootcamp.RESTfulWebservices.service.UserService;

import com.Bootcamp.RESTfulWebservices.model.User;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.jspecify.annotations.NonNull;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "User Controller", description = "APIs for managing users")
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Get user by id", description = "Returns details of a specific user")
    @GetMapping(
            produces = "application/xml"
    )
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @Operation(summary = "Create user", description = "Saves new user details")
    @PostMapping(
            consumes = "application/xml",
            produces = "application/xml"
    )
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PostMapping("/static")
    public User saveUserStatic(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/dynamic/{id}")
    public MappingJacksonValue getUserDynamic(@PathVariable Integer id) {

        User user = userService.findById(id);

        MappingJacksonValue mapping = new MappingJacksonValue(user);

        SimpleBeanPropertyFilter filter =
                SimpleBeanPropertyFilter.filterOutAllExcept("id", "name");

        FilterProvider filters =
                new SimpleFilterProvider().addFilter("UserFilter", filter);

        mapping.setFilters(filters);

        return mapping;
    }


    @Operation(summary = "Delete user", description = "Deletes a user by id")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.delete(id);
    }
}
