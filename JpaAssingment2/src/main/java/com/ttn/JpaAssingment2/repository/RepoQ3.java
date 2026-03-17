package com.ttn.JpaAssingment2.repository;

import com.ttn.JpaAssingment2.modelQ3.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoQ3 extends JpaRepository<EmployeeModel,Long> {
}
