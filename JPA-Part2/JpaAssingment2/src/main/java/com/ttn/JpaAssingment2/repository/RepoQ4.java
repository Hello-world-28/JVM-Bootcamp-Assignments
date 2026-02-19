package com.ttn.JpaAssingment2.repository;

import com.ttn.JpaAssingment2.modelQ4.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoQ4 extends JpaRepository<Employee, Long> {
}