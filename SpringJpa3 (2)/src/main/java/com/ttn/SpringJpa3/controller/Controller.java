package com.ttn.SpringJpa3.controller;

import com.ttn.SpringJpa3.model.onetoone.AuthorOneToOne;
import com.ttn.SpringJpa3.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    Service service;

    @PostMapping("/addUser")
    public ResponseEntity<AuthorOneToOne> saveNewUser(@RequestBody AuthorOneToOne model){
        AuthorOneToOne m= service.saveAuthor(model);
        return ResponseEntity.status(HttpStatus.OK).body(m);
    }
}
