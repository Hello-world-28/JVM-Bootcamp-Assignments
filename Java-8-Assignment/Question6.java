//Create and access default and static method of an interface.

interface JVMBootcamp {
    default void show() {
        System.out.println("This is a default method in JVMBootcamp interface.");
    }

    static void display() {
        System.out.println("This is a static method in JVMBootcamp interface.");
    }
}

class Question6 implements JVMBootcamp {
    public static void main(String[] args) {
        Question6 obj = new Question6();
        obj.show(); // Accessing default method

        JVMBootcamp.display(); // Accessing static method
    }
}