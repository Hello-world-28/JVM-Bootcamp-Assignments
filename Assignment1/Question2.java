//Write a program to read user input until user writes XDONE and then show the entered text by the user on command line
import java.util.ArrayList;
import java.util.Scanner;

class Question2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> inputs = new ArrayList<>();
        System.out.println("Enter text (type XDONE in capital letters to finish):");
        while (true) {
            String line = sc.nextLine();
            if (line.equals("XDONE")) {
                break;
            }
            inputs.add(line);
        }
        System.out.println();
        System.out.println("You entered: ");
        for (String input : inputs){
            System.out.println(input);
        }
        sc.close();
    }
}