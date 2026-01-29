//Using (instance) Method reference create and apply add and subtract method and using (Static) Method reference create and apply multiplication method for the functional interface created

@FunctionalInterface
interface Calculator {
    int operate(int a, int b);
}

class MathOperations {
    // Instance method for addition
    public int add(int a, int b) {
        return a + b;
    }

    // Instance method for subtraction
    public int subtract(int a, int b) {
        return a - b;
    }

    // Static method for multiplication
    public static int multiply(int a, int b) {
        return a * b;
    }
}
class Question2 {
    public static void main(String[] args) {

        MathOperations mathOps = new MathOperations();

        // Using instance method reference for addition
        Calculator addition = mathOps::add;
        System.out.println("Addition: " + addition.operate(5, 3));

        //Using instance method reference for subtraction
        Calculator subtraction = mathOps::subtract;
        System.out.println("Subtraction: " + subtraction.operate(5, 3));

        // Using static method reference for multiplication
        Calculator multiplication = MathOperations::multiply;
        System.out.println("Multiplication: " + multiplication.operate(5, 3));
    }
}