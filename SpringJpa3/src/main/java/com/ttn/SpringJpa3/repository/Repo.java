package com.ttn.SpringJpa3.repository;

import com.ttn.SpringJpa3.model.onetoone.AuthorOneToOne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<AuthorOneToOne, Long> {
}
