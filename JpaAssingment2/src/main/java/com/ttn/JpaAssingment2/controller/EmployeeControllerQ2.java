package com.ttn.JpaAssingment2.controller;

import com.ttn.JpaAssingment2.model.Employee;
import com.ttn.JpaAssingment2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeControllerQ2 {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/getEmployeeSingh")
    public List<Employee> getEmployeeEndWithSingh(){
        return employeeService.findSinghEmp();
    }

    @DeleteMapping("/deleteEmployeeGretaerThan45")
    public int empGreaterThan(){
        return employeeService.deleteEmpGreaterThan();
    }
}
