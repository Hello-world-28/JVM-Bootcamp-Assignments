//Convert an Optional type into Stream
import java.util.*;

public class Question1 {
    public static void main(String[] args) {

        List<Optional<String>> data = List.of(
            Optional.of("apple"),
            Optional.empty(),
            Optional.of("banana")
        );

        List<Integer> lengths =
            data.stream()
                .flatMap(Optional::stream)
                .map(String::length)
                .toList();

        System.out.println(lengths); 
    }
}
