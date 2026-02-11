//use record to create an immutable represent of student(name, id, age) and use its constructor for initialization, equals to compare 2 students methods. Also keep a static counter to keep the count of objects created.
public record Student(String name, int id, int age) {

    private static int count = 0;

    // Compact constructor
    public Student {
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be positive");
        }
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static void main(String[] args) {

        Student s1 = new Student("Alice", 101, 20);
        Student s2 = new Student("Alice", 101, 20);
        Student s3 = new Student("Bob", 102, 22);

        // equals() comparison
        System.out.println(s1.equals(s2)); // true
        System.out.println(s1.equals(s3)); // false

        // static counter
        System.out.println("Students created: " + Student.getCount());
    }
}
