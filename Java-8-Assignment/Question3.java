//Implement multiple inheritance with default method inside interface.

interface InterfaceA {
    default void display() {
        System.out.println("Display method from Interface A");
    }
    void show();
}

interface InterfaceB {
    default void displayB() {
        System.out.println("Display method from Interface B");
    }
    void show();
}

class Question3 implements InterfaceA, InterfaceB {
    public void show() {
        System.out.println("Show method from Question3");
    }

    public static void main(String[] args) {
        Question3 obj = new Question3();
        obj.display();
        obj.show();
        obj.displayB();
    }
}