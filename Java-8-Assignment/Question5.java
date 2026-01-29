//Implement following functional interfaces from java.util.function using lambdas: 
// 1. Consumer 
// 2. Supplier 
// 3. Predicate 
// 4. Function

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class Question5 {
    public static void main(String[] args){
        // 1. Consumer : takes input and returns nothing
        Consumer<String> consumer = s -> System.out.println("Consumed: " + s);
        consumer.accept("Hello World");
        // 2. Supplier : takes no input and returns a value
        Supplier<Double> supplier = () -> Math.random();
        System.out.println("Supplied: " + supplier.get());
        // 3. Predicate : takes input and returns boolean
        Predicate<Integer> predicate = n -> n % 2 == 0;
        System.out.println("Predicate test for 4(Is 4 an even number?): " + predicate.test(4));
        // 4. Function : takes input and returns output
        Function<Integer, String> function = n -> "Number: " + n;
        System.out.println("Function apply for 5: " + function.apply(5));
    }
}