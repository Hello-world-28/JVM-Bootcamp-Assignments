package com.Bootcamp.SpringBootAssignment2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Bootcamp.SpringBootAssignment2.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
