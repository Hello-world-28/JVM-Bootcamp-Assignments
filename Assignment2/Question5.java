//Write a program to show application of Singleton Design Pattern.
class Printer {
    private static Printer instance = new Printer();
    private Printer() {}
    public static Printer getInstance() {
        return instance;
    }
    public void print() {
        System.out.println("Printing...");
    }
}
class Question5 {
    public static void main(String[] args) {
        Printer printer1 = Printer.getInstance();
        Printer printer2 = Printer.getInstance();
        printer1.print();
        System.out.println("Are both printers the same instance? " + (printer1 == printer2));
        System.out.println("Instance 1 hashcode: " + printer1.hashCode());
        System.out.println("Instance 2 hashcode: " + printer2.hashCode());
        System.out.println("Both instances are identical, confirming Singleton pattern.");
    }
}