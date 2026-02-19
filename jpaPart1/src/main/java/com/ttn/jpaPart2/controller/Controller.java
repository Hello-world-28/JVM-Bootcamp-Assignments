package com.ttn.jpaPart2.controller;


import com.ttn.jpaPart2.model.EmployeeModel;
import com.ttn.jpaPart2.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    Service  service;

    @PostMapping("/addEmployee")
    public EmployeeModel addEmployee(@RequestBody EmployeeModel emp){
        return service.addEmployee(emp);
    }
    @PutMapping("/editEmployee")
    public EmployeeModel editEmployeeDetails(@RequestBody EmployeeModel emp){
        return service.updateEmployee(emp);
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable Long id){
        return service.deleteEmp(id);
    }


    @GetMapping("/getAllEmployee")
    public List<EmployeeModel> getAllEmp(){
        return service.getAllEmp();
    }

    @GetMapping("/getCount")
    public Long getEmployeeCount(){
        return service.getCount();
    }

    @GetMapping("/getPagination/{page}")
    public List<EmployeeModel> getEmployeeModel(@PathVariable int page){
        return service.implementPaginationAndSorting(page);
    }

    @GetMapping("/searchByName/{name}")
    public List<EmployeeModel> searchByName(@PathVariable String name){
        return  service.searchByName(name);
    }

    @GetMapping("/getByWord/{name}")
    public List<EmployeeModel> searchByWord(@PathVariable String name){
        return service.searchByCharacter(name);
    }

    @GetMapping("/getByAge")
    public List<EmployeeModel> findByAge(@RequestParam int start, @RequestParam int end){
        return service.findByAge(start,end);
    }

}
