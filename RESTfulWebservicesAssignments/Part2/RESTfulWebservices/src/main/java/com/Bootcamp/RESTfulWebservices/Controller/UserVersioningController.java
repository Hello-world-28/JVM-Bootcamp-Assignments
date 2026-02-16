package com.Bootcamp.RESTfulWebservices.Controller;

import com.Bootcamp.RESTfulWebservices.model.User;
import com.Bootcamp.RESTfulWebservices.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for versioned user APIs.
 * This controller demonstrates different versioning strategies:
 * - MimeType Versioning (Accept header)
 * - Request Parameter versioning
 * - URI versioning
 * - Custom Header versioning
 */
@Tag(name = "User Versioning Controller", description = "APIs for versioned user details with different versioning strategies")
@RestController
@RequestMapping("/versioned-users")
public class UserVersioningController {

    private final UserService userService;

    public UserVersioningController(UserService userService) {
        this.userService = userService;
    }

    // ========== MimeType Versioning (Accept Header) ==========
    @Operation(summary = "Get basic user details (v1)", description = "Returns basic user details using MimeType versioning via Accept header")
    @GetMapping(value = "/{id}", produces = "application/vnd.company.app-v1+json")
    public User getUserBasicV1(@Parameter(description = "User ID") @PathVariable Integer id) {
        User user = userService.findById(id);
        if (user != null) {
            // Return only basic details
            User basicUser = new User();
            basicUser.setId(user.getId());
            basicUser.setName(user.getName());
            return basicUser;
        }
        return null;
    }

    @Operation(summary = "Get enhanced user details (v2)", description = "Returns enhanced user details using MimeType versioning via Accept header")
    @GetMapping(value = "/{id}", produces = "application/vnd.company.app-v2+json")
    public User getUserEnhancedV2(@Parameter(description = "User ID") @PathVariable Integer id) {
        User user = userService.findById(id);
        if (user != null) {
            // Return enhanced details (all fields except password)
            User enhancedUser = new User();
            enhancedUser.setId(user.getId());
            enhancedUser.setName(user.getName());
            enhancedUser.setAge(user.getAge());
            return enhancedUser;
        }
        return null;
    }

    // ========== Request Parameter Versioning ==========
    @Operation(summary = "Get basic user details (v1)", description = "Returns basic user details using request parameter versioning")
    @GetMapping(value = "/param/{id}", params = "version=1")
    public User getUserBasicParamV1(@Parameter(description = "User ID") @PathVariable Integer id) {
        User user = userService.findById(id);
        if (user != null) {
            User basicUser = new User();
            basicUser.setId(user.getId());
            basicUser.setName(user.getName());
            return basicUser;
        }
        return null;
    }

    @Operation(summary = "Get enhanced user details (v2)", description = "Returns enhanced user details using request parameter versioning")
    @GetMapping(value = "/param/{id}", params = "version=2")
    public User getUserEnhancedParamV2(@Parameter(description = "User ID") @PathVariable Integer id) {
        User user = userService.findById(id);
        if (user != null) {
            User enhancedUser = new User();
            enhancedUser.setId(user.getId());
            enhancedUser.setName(user.getName());
            enhancedUser.setAge(user.getAge());
            return enhancedUser;
        }
        return null;
    }

    // ========== URI Versioning ==========
    @Operation(summary = "Get basic user details (v1)", description = "Returns basic user details using URI versioning")
    @GetMapping("/v1/{id}")
    public User getUserBasicUriV1(@Parameter(description = "User ID") @PathVariable Integer id) {
        User user = userService.findById(id);
        if (user != null) {
            User basicUser = new User();
            basicUser.setId(user.getId());
            basicUser.setName(user.getName());
            return basicUser;
        }
        return null;
    }

    @Operation(summary = "Get enhanced user details (v2)", description = "Returns enhanced user details using URI versioning")
    @GetMapping("/v2/{id}")
    public User getUserEnhancedUriV2(@Parameter(description = "User ID") @PathVariable Integer id) {
        User user = userService.findById(id);
        if (user != null) {
            User enhancedUser = new User();
            enhancedUser.setId(user.getId());
            enhancedUser.setName(user.getName());
            enhancedUser.setAge(user.getAge());
            return enhancedUser;
        }
        return null;
    }

    // ========== Custom Header Versioning ==========
    @Operation(summary = "Get basic user details (v1)", description = "Returns basic user details using custom header versioning")
    @GetMapping(value = "/header/{id}", headers = "API-VERSION=1")
    public User getUserBasicHeaderV1(@Parameter(description = "User ID") @PathVariable Integer id) {
        User user = userService.findById(id);
        if (user != null) {
            User basicUser = new User();
            basicUser.setId(user.getId());
            basicUser.setName(user.getName());
            return basicUser;
        }
        return null;
    }

    @Operation(summary = "Get enhanced user details (v2)", description = "Returns enhanced user details using custom header versioning")
    @GetMapping(value = "/header/{id}", headers = "API-VERSION=2")
    public User getUserEnhancedHeaderV2(@Parameter(description = "User ID") @PathVariable Integer id) {
        User user = userService.findById(id);
        if (user != null) {
            User enhancedUser = new User();
            enhancedUser.setId(user.getId());
            enhancedUser.setName(user.getName());
            enhancedUser.setAge(user.getAge());
            return enhancedUser;
        }
        return null;
    }
}
