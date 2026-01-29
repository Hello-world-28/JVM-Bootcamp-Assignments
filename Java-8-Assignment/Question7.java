//Sum all the numbers greater than 5 in the integer list using streams

import java.util.Arrays;
import java.util.List;

class Question7 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, 5, 7, 9, 11, 13, 15);

        int sum = numbers.stream()
                .filter(n -> n > 5)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Sum of numbers greater than 5: " + sum);
    }
}