package com.Bootcamp.RESTfulWebservices.service;

import com.Bootcamp.RESTfulWebservices.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private static List<User> users = new ArrayList<>();

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        users.add(user);
        return user;
    }

    public User findById(Integer id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void delete(Integer id) {
        users.removeIf(user -> user.getId().equals(id));
    }
}
