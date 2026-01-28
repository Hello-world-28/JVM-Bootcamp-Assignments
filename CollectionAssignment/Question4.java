//Create class Employee with attributes name,age,designation and use instances of these class as keys in a Map and their salary as value
class Employee{
    String name;
    int age;
    String designation;

    Employee(String name, int age, String designation){
        this.name = name;
        this.age = age;
        this.designation = designation;
    }
}
class Question4 {   
    public static void main(String[] args){
        java.util.Map<Employee, Double> employeeSalaryMap = new java.util.HashMap<>();

        Employee emp1 = new Employee("Saurabh Singh", 23, "JVM Trainee");
        Employee emp2 = new Employee("Padam Awasthi", 24, "QA Engineer");
        Employee emp3 = new Employee("Babulal Yadav", 25, "JS Developer");

        employeeSalaryMap.put(emp1, 50000.0);
        employeeSalaryMap.put(emp2, 60000.0);
        employeeSalaryMap.put(emp3, 70000.0);

        for (java.util.Map.Entry<Employee, Double> entry : employeeSalaryMap.entrySet()) {
            Employee emp = entry.getKey();
            Double salary = entry.getValue();
            System.out.println("Employee Name: " + emp.name + ", Age: " + emp.age + ", Designation: " + emp.designation + ", Salary: " + salary);
        }
    }
}