//Write a program to showcase the use of optional class

import java.util.Optional;

class Question8 {
    public static void main(String[] args){

        //Optional with a non-null value
        Optional<String> name = Optional.of("Saurabh");

        //Check presence
        System.out.println("Is name present? " + name.isPresent());

        //Get value
        System.out.println("Name: " + name.get());

        //Optional with a null value
        Optional<String> emptyName = Optional.ofNullable(null);

        //Provide default value
        System.out.println("Empty name or default: " + emptyName.orElse("Default Name"));

        //Useing ifPresent
        name.ifPresent(n -> System.out.println("Length of name: " + n.length()));
    }
}