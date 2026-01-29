//Write a program to implement constructor reference

interface CreateUser {
    User create(String name, int age);
}

class User {
    private String name;
    private int age;

    public User(String name , int age){
        this.name = name;
        this.age = age;
    }

    public String showDetails(){
        return "Name: " + name + ", Age: " + age;
    }
}

class Question4 {
    public static void main(String[] args) {
        CreateUser makeUser = User::new;

        User user1 = makeUser.create("Saurabh", 22);
        User user2 = makeUser.create("Babulal", 20);

        System.out.println(user1.showDetails());
        System.out.println(user2.showDetails());
    }
}