package com.ttn.springSecurity.controller;


import com.ttn.springSecurity.entity.UserEntity;
import com.ttn.springSecurity.jwt.JwtService;
import com.ttn.springSecurity.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Controller for user registration


@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthController (UserService userService,  AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }
    @PostMapping("/register")
    public UserEntity register(@RequestBody UserEntity user) {
        return userService.Register(user);
    }

    //  login page for authentication of jwt token
    @PostMapping("/login")
    public String login(@RequestBody UserEntity request) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getUserName(),
                                request.getPassword()
                        )
                );

        if(authentication.isAuthenticated()) {
            return jwtService.generateToken(request.getUserName());
        }

        throw new RuntimeException("Invalid credentials");
    }
}
