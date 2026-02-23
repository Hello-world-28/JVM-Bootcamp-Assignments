package com.ttn.SpringJpa3.service;

import com.ttn.SpringJpa3.model.onetoone.AuthorOneToOne;
import com.ttn.SpringJpa3.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    Repo repo;

    public AuthorOneToOne saveAuthor(AuthorOneToOne m){
        return repo.save(m);
    }
}
