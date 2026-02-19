package com.ttn.jpaPart2.repo;

import com.ttn.jpaPart2.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface Repo extends JpaRepository<EmployeeModel, Long> {

    List<EmployeeModel> getEmployeeModelByNameStartingWith(String name);

    List<EmployeeModel> getEmployeeModelByNameIsLike(String name);

    List<EmployeeModel> getEmployeeModelByAgeBetween(int start, int end);

}
