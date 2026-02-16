package com.Bootcamp.RESTfulWebservices.service;

import com.Bootcamp.RESTfulWebservices.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private static List<Employee> employees = new ArrayList<>();

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployeeById(Integer id) {
        return employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Employee createEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public void deleteEmployee(Integer id) {
        employees.removeIf(e -> e.getId().equals(id));
    }

    public Employee updateEmployee(Integer id, Employee updatedEmployee) {
        Employee existing = getEmployeeById(id);
        if (existing != null) {
            existing.setName(updatedEmployee.getName());
            existing.setAge(updatedEmployee.getAge());
        }
        return existing;
    }
}
