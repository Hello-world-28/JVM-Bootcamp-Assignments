package com.ttn.JpaAssingment2.controller;


import com.ttn.JpaAssingment2.model.Employee;
import com.ttn.JpaAssingment2.model.EmployeeDto;
import com.ttn.JpaAssingment2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeControllerQ1 {
    @Autowired
    private EmployeeService employeeService;

    //Q1)
    @GetMapping("/getEmployeeBySalary")
    public ResponseEntity<List<EmployeeDto>> getEmployeeBySalary(){
        return ResponseEntity.ok(employeeService.getEmployeeBySalary());
    }
    //Q)2

    @PostMapping("/update-salary")
    public String updateSalary(@RequestParam Double salary) {

        int updated = employeeService.updateSalaryLessThanAverage(salary);

        return updated + " employees salary updated";
    }
//Q)3
    @DeleteMapping("/delete-min-salary")
    public String deleteMinSalaryEmployee() {

        int deleted = employeeService.deleteEmployeeWithMinSalary();

        return deleted + " employees deleted";
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp){
        return ResponseEntity.ok(employeeService.saveUsers(emp));
    }

    @GetMapping("/getAllEmployee")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }



}
