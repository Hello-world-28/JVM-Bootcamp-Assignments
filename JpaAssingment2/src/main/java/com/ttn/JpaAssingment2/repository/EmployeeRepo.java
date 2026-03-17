package com.ttn.JpaAssingment2.repository;

import com.ttn.JpaAssingment2.model.Employee;
import com.ttn.JpaAssingment2.model.EmployeeDto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    /*
    1) Display the first name, last name of all employees having salary greater than average salary ordered in ascending by their age and in descending by their salary.
     */


    @Query("select emp.firstName as firstName, emp.lastName as lastName " +
            "from Employee  as emp" +
            " where emp.salary > (select AVG(e.salary) from Employee e)" +
            " order by emp.age asc, emp.salary desc")
    List<EmployeeDto> getEmployeeBySalaryAvg();

  //  2) Update salary of all employees by a salary passed as a parameter whose existing salary is less than the average salary.
  @Modifying
  @Transactional
  @Query("UPDATE Employee e " +
          "SET e.salary = :newSalary " +
          "WHERE e.salary < (SELECT AVG(emp.salary) FROM Employee emp)")
  int updateSalaryLessThanAverage(Double newSalary);

//3)3) Delete all employees with minimum salary.
    @Modifying
    @Transactional
    @Query("DELETE FROM Employee e " +
            "WHERE e.salary = (SELECT MIN(emp.salary) FROM Employee emp)")
    int deleteEmployeeWithMinSalary();



    // 1) Display the id, first name, age of all employees where last name ends with "singh".
    List<Employee> findEmployeeByLastNameStartsWith(String lastName);

    // Q)2 Delete all employees with age greater than 45(Should be passed as a parameter).
    int deleteEmployeeByAgeGreaterThan(Integer ageIsGreaterThan);

}
