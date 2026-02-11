//Create Unmodifiable List from a Steam
import java.util.*;
import java.util.stream.*;

public class Question3 {
    public static void main(String[] args) {

        List<String> result =
            Stream.of("apple", "banana", "orange")
                  .map(String::toUpperCase)
                  .toList();   // unmodifiable

        System.out.println(result);

        // result.add("PEAR"); // UnsupportedOperationException
    }
}
