//Write a class with FirstName, LastName & age field.
//Print Firstname, LastName & age using static block, static method & static variable respectively.
class Question1 {
    private String  FirstName = "Saurabbh";
    private String LastName = "Singh";
    private int age = 23;
    static {
        System.out.println("This is a static block");
        Question1 obj = new Question1();
        System.out.println("First Name: " + obj.FirstName);
        System.out.println("Last Name: " + obj.LastName);
        System.out.println("Age: " + obj.age);
    }
    public static void main(String[] args){
    }
}