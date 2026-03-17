package com.ttn.JpaAssingment2.service;


import com.ttn.JpaAssingment2.model.Employee;
import com.ttn.JpaAssingment2.model.EmployeeDto;
import com.ttn.JpaAssingment2.repository.EmployeeRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo repo;

    public List<EmployeeDto> getEmployeeBySalary(){
        return repo.getEmployeeBySalaryAvg();
    }

    public Employee saveUsers(Employee emp) {
        return repo.save(emp);
    }

    public int deleteEmployeeWithMinSalary() {
        return repo.deleteEmployeeWithMinSalary();
    }

    public int updateSalaryLessThanAverage(Double newSalary) {
        return repo.updateSalaryLessThanAverage(newSalary);
    }

    public List<Employee> getAllEmployee() {
        return repo.findAll();
    }

    public List<Employee> findSinghEmp(){
        return repo.findEmployeeByLastNameStartsWith("singh");
    }

    public int deleteEmpGreaterThan(){
        return repo.deleteEmployeeByAgeGreaterThan(45);
    }
}
