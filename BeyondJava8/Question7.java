//Use iterator stream method to generate a stream
import java.util.stream.Stream;

public class Question7 {
    public static void main(String[] args) {

        // Generate first 10 even numbers
        Stream.iterate(0, n -> n + 2)
              .limit(10)
              .forEach(System.out::println);
    }
}
