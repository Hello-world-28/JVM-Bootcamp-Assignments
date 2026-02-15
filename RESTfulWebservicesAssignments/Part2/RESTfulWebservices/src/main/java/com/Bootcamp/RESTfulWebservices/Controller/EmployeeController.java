package com.Bootcamp.RESTfulWebservices.Controller;

import com.Bootcamp.RESTfulWebservices.model.Employee;
import com.Bootcamp.RESTfulWebservices.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }
    //Q3
    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }
    //Q4
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Integer id) {
        return service.getEmployeeById(id);
    }
    // Q5 + Q9 - POST employee with validation
    @PostMapping
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return service.createEmployee(employee);
    }
    //Q7
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        service.deleteEmployee(id);
        return "Employee deleted successfully";
    }
    //Q8
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Integer id,
                                   @RequestBody Employee employee) {
        return service.updateEmployee(id, employee);
    }
}
