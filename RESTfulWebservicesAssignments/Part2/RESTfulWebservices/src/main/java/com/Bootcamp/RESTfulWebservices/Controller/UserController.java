package com.Bootcamp.RESTfulWebservices.Controller;
import com.Bootcamp.RESTfulWebservices.service.UserService;

import com.Bootcamp.RESTfulWebservices.model.User;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Tag(name = "User Controller", description = "APIs for managing users")
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final MessageSource messageSource;

    public UserController(UserService userService, MessageSource messageSource) {
        this.userService = userService;
        this.messageSource = messageSource;
    }

    @Operation(summary = "Get localized greeting", description = "Returns a localized greeting message for the given username")
    @GetMapping("/greeting")
    public String getGreeting(@Parameter(description = "Username for greeting") @RequestParam String username) {
        return messageSource.getMessage("greeting.message", new Object[]{username}, LocaleContextHolder.getLocale());
    }

    @Operation(summary = "Get all users", description = "Returns list of all users in XML format")
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

    @Operation(summary = "Save user with static filtering", description = "Saves user details (including password) but returns only non-critical data using static filtering")
    @PostMapping("/static")
    public User saveUserStatic(@RequestBody User user) {
        User savedUser = userService.save(user);
        // Static filtering: password is already ignored via @JsonIgnore annotation
        return savedUser;
    }

    @Operation(summary = "Save user with dynamic filtering", description = "Saves user details (including password) but returns only non-critical data using dynamic filtering")
    @PostMapping("/dynamic")
    public MappingJacksonValue saveUserDynamic(@RequestBody User user) {
        User savedUser = userService.save(user);
        
        MappingJacksonValue mapping = new MappingJacksonValue(savedUser);
        
        SimpleBeanPropertyFilter filter =
                SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "age");
        
        FilterProvider filters =
                new SimpleFilterProvider().addFilter("UserFilter", filter);
        
        mapping.setFilters(filters);
        
        return mapping;
    }


    @Operation(summary = "Delete user", description = "Deletes a user by id")
    @DeleteMapping("/{id}")
    public void deleteUser(@Parameter(description = "User ID") @PathVariable Integer id) {
        userService.delete(id);
    }

    @Operation(summary = "Get user with HATEOAS links", description = "Returns user details along with HATEOAS links to related resources")
    @GetMapping("/hateoas/{id}")
    public EntityModel<User> getUserWithLinks(@Parameter(description = "User ID") @PathVariable Integer id) {
        User user = userService.findById(id);
        if (user == null) {
            return null;
        }

        EntityModel<User> entityModel = EntityModel.of(user);
        
        // Add link to get all users (topics/users)
        WebMvcLinkBuilder linkToAllUsers = linkTo(methodOn(UserController.class).getAllUsers());
        entityModel.add(linkToAllUsers.withRel("all-users"));
        
        return entityModel;
    }
}
