import java.util.Optional;
import java.util.stream.Stream;

class Question2{
    public static void main(String[] args){
        Optional<String> opt = Optional.of("My name is Saurabh");
        Stream<String> str = opt.stream();
        str.forEach(System.out::println);
    }
}