//Create a Record for the Student with the following Fields: 
// id name standard Make sure that no null values are used for initialization. 
// Use equal and hashCode methods with Student records


import java.util.Objects;

record Student(int id, String name, String standard) {

    // Compact canonical constructor
    public Student {
        Objects.requireNonNull(name, "name must not be null");
        Objects.requireNonNull(standard, "standard must not be null");
    }

    public static void main(String[] args) {

        Student s1 = new Student(1, "Saurabh", "12th");
        Student s2 = new Student(1, "Padam", "10th");
        Student s3 = new Student(2, "Dhruv", "9th");

        // equals()
        System.out.println(s1.equals(s2)); 
        System.out.println(s1.equals(s3));

        // hashCode()
        System.out.println(s1.hashCode() == s2.hashCode()); 
        System.out.println(s1.hashCode() == s3.hashCode()); 
    }
}
