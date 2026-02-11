//Use Of method to create List, Set and Map
import java.util.*;

public class Question2 {
    public static void main(String[] args) {

        // List.of()
        List<String> fruits = List.of("apple", "banana", "orange");
        System.out.println(fruits);

        // Set.of()
        Set<String> colors = Set.of("red", "green", "blue");
        System.out.println(colors);

        // Map.of()
        Map<String, Integer> scores =
            Map.of(
                "Alice", 90,
                "Bob", 85,
                "Carol", 92
            );
        System.out.println(scores);

    }
}
