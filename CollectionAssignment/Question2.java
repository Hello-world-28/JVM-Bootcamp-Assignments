import java.util.*;

//Given the following class 
    // Employee class{ 
        // Double Age; Double Salary; String Name}
//Design the class in such a way that the default sorting should work on firstname and lastname. 
// Also, Write a program to sort Employee objects based on salary using Comparator.
class Question2{
    public static void main(String[] args) {
        
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(23, 50000, "Saurabh", "Singh"));
        employees.add(new Employee(24, 60000, "Babulal", "Kumar"));
        employees.add(new Employee(22, 55000, "Padam", "Awasthi"));
        employees.add(new Employee(25, 70000, "Saurabh", "Shukla"));

        System.out.println("Employees sorted by first name and last name (default sorting):");
        Collections.sort(employees);
        System.out.println("Sorted by Name:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }  

        System.out.println("\nEmployees sorted by salary:");
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return Double.compare(e1.salary, e2.salary);
            }
        });
        for (Employee emp : employees) {
            System.out.println(emp.toString());
        }

    }
}
class Employee implements Comparable<Employee>{
    double age;
    double salary;
    String firstName;
    String lastName;

    Employee(double age, double salary, String firstName, String lastName){
        this.age = age;
        this.salary = salary;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int compareTo(Employee other) {
        int firstNameComparison = this.firstName.compareTo(other.firstName);
        if (firstNameComparison != 0) {
            return firstNameComparison;
        }
        return this.lastName.compareTo(other.lastName);
    }

    @Override
    public String toString() {
        return "Employee\n{" + "\n" +
                "Age=" + age + "\n" +
                "Salary=" + salary + "\n" +
                "firstName='" + firstName + '\'' + "\n" +
                "lastName='" + lastName + '\'' + "\n" +
                '}';
    }
}
