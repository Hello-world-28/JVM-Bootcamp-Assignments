package com.Bootcamp.RESTfulWebservices.service;

import com.Bootcamp.RESTfulWebservices.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.spi.ToolProvider.findFirst;

@Service
public class EmployeeService {
    private static List<Employee> employees = new ArrayList<>();
    static {
        employees.add(new Employee(1, "Saurabh", 23));
        employees.add(new Employee(2, "Padam", 25));
        employees.add(new Employee(3, "Mandan", 20));
        employees.add(new Employee(4, "Bittu", 28));
    }
    public List<Employee> getAllEmployees() {
        return employees;
    }
    public Employee getEmployeeById(Integer id) {
        return employees.stream()
                .filter(emp -> emp.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }
    public Employee createEmployee(Employee createEmployee) {
        employees.add(createEmployee);
            return createEmployee;
    }
    public void deleteEmployee(Integer id) {
        Employee emp = getEmployeeById(id);
        employees.remove(emp);
    }
    public Employee updateEmployee(Integer id, Employee updatedEmployee) {
        Employee emp = getEmployeeById(id);
            emp.setName(updatedEmployee.getName());
            emp.setAge(updatedEmployee.getAge());
        return emp;
    }

}
