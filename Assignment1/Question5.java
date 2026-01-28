//Create a class named Employee with fields firstname,lastname,age and designation. 
    //The class should:
    //1. have all types of constructors to initialize the object
    //2. class should also have setter methods to update a particular field
    //3. Override its toString method to display a meaningful message using all these fields.

class Question5 {
    public static void main(String[] args){
        //Using Default Constructor
        Employee e1 = new Employee();
        System.out.println(e1.toString());
        //Using Parameterized Constructor
        Employee e2 = new Employee("Padam", "Awasthi", 23, "QA Engineer");
        System.out.println(e2.toString());
        //Using Setter Methods
        e2.setFirstName("Babulal");
        e2.setLastName("Yadav");
        e2.setAge(24);
        e2.setDesignation("JS Developer");
        System.out.println(e2.toString());
    }
}
class Employee {
    private String firstName;
    private String lastName;
    private int age;
    private String designation;
    // Default constructor
    public Employee() {
        this.firstName = "Saurabh";
        this.lastName = "Singh";
        this.age = 23;
        this.designation = "JVM Trainee";
    }
    // Parameterized constructor
    public Employee(String firstName, String lastName, int age, String designation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.designation = designation;
    }
    // Setter methods
    // Set first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    // Set last name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    // Set age
    public void setAge(int age) {
        this.age = age;
    }
    // Set designation
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    // Override toString method
    @Override
    public String toString() {
        return "Employee Details: " +
               "First Name: " + firstName + ", " +
               "Last Name: " + lastName + ", " +
               "Age: " + age + ", " +
               "Designation: " + designation;
    }
}