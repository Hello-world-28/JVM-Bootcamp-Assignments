package com.example.JDBC.service;

import com.example.JDBC.entity.User;
import com.example.JDBC.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

     public void createTable(){
         userRepository.createTable();
     }
    public void insertUser(String userName, String email){
        userRepository.insertUser(userName, email);
    }
    public List<User> getUsers(){
         List<User> users = userRepository.getUsers();
         for(User user : users){
             System.out.println(user.getUserId() + " : " + user.getUserName() + " : " + user.getAge());
         }
         return users;
    }
}
