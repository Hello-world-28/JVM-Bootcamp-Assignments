package com.ttn.springSecurity.service;

import com.ttn.springSecurity.entity.Role;
import com.ttn.springSecurity.entity.UserEntity;
import com.ttn.springSecurity.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository=userRepository;
        this.passwordEncoder= passwordEncoder;
    }

    public UserEntity Register(UserEntity user){

        if(userRepository.findUserByUserName(user.getUserName()).isPresent()){
            throw new RuntimeException("Username already exists");
        }

        user.setPassword((passwordEncoder.encode((user.getPassword()))));

        if(user.getRole() == null){
            user.setRole(Role.USER);
        }

        return userRepository.save(user);
    }
}
