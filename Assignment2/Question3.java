//Write a program to count number of occurrences of a word in a file. 
//The file name and word should be supplied through commandline.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Question3 {
    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Usage: java WordCount <filename> <word>");
            return;
        }

        String fileName = args[0];
        String targetWord = args[1];
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equals(targetWord)) {
                        count++;
                    }
                }
            }

            System.out.println(
                "Occurrences of \"" + targetWord + "\": " + count
            );

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
