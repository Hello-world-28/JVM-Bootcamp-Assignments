package com.ttn.jpaPart2.service;

import com.ttn.jpaPart2.exception.RuntimeException;
import com.ttn.jpaPart2.model.EmployeeModel;
import com.ttn.jpaPart2.repo.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import java.util.List;


@org.springframework.stereotype.Service
public class Service {

    @Autowired
    Repo repo;


    // Q3 performed create operation on employee table
   public EmployeeModel addEmployee(EmployeeModel e){
       return repo.save(e);
   }

   // q)4 performed update operation on it
    public EmployeeModel updateEmployee(EmployeeModel e){
       EmployeeModel emp= repo.findById(e.getId()).orElseThrow(() -> new RuntimeException());

       emp.setAge(e.getAge());
       emp.setName(e.getName());
       emp.setLocation(e.getLocation());

       return repo.save(e);
    }

    // Q)5 delete employee with id
    public String deleteEmp(Long id){
        EmployeeModel emp= repo.findById(id).orElseThrow(() -> new RuntimeException());

        repo.deleteById(id);
        return "success fully deleted employee with this id ="+ id;
    }

    // Q)6 Read Operation on Entity using Spring Data JPA
    public List<EmployeeModel> getAllEmp() {
       return repo.findAll();
    }

    // Q) 7 total count of the number of Employees
    public Long getCount() {
       return  repo.count();
    }

    //Q)8 Implement Pagination and Sorting on the bases of Employee Age
    public List<EmployeeModel> implementPaginationAndSorting(int offset){
        Pageable pageable = PageRequest.of(offset,2 , Sort.by("age").ascending());
       return repo.findAll(pageable).getContent();
    }

    //Q) 9 Create and use finder to find Employee by Name
    public List<EmployeeModel> searchByName(String name){
       return  repo.getEmployeeModelByNameStartingWith(name);
    }

    // Q)10 Create and use finder to find Employees starting with A character
    public List<EmployeeModel> searchByCharacter(String name){
       return repo.getEmployeeModelByNameIsLike(name+"%");
    }

    //Q) 11 Create and use finder to find Employees Between the age of 28 to 32
    public List<EmployeeModel> findByAge(int start, int end){
       return repo.getEmployeeModelByAgeBetween(start, end);
    }



}
