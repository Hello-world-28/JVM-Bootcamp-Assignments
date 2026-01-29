//Given a list of objects of following class:
//      class Employee{
//      String fullName;
//      Long salary;
//      String city;
//      }
//Get list of all unique firstNames of employees where their salary is less than 5000 and who live in delhi.
//Note: Full name is concatenation of first name, middle name and last name with single space in between.

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Employee {
    private String fullName;
    private Long salary;
    private String city;

    public Employee(String fullName, Long salary, String city) {
        this.fullName = fullName;
        this.salary = salary;
        this.city = city;
    }

    public String getFullName() {
        return fullName;
    }
    public Long getSalary() {
        return salary;
    }
    public String getCity() {
        return city;
    }
}

class Question9 {
    public static void main(String[] args) {
        
        List<Employee> employees = Arrays.asList(
            new Employee("Saurabh Singh", 4500L, "Delhi"),
            new Employee("Babulal Yadav", 3000L, "Noida"),
            new Employee("Anita Kumari", 6000L, "Jaipur"),
            new Employee("Ravi Shankar", 4000L, "Nainital"),
            new Employee("Sakshi Devi", 3500L, "Delhi"),
            new Employee("Saurabh Verma", 2000L, "Delhi")
        );

        List<String> uniqueFirstNames = employees.stream()
            .filter(e -> e.getSalary() < 5000 && e.getCity().equalsIgnoreCase("Delhi"))
            .map(e -> e.getFullName().split(" ")[0])
            .distinct()
            .collect(Collectors.toList());
        
        System.out.println("Unique first names of employees with salary < 5000 in Delhi: " + uniqueFirstNames);


    }
}