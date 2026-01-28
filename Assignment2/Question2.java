/*
Create a User class with fields:
firstname, lastname, age, phonenumber. 
Write a program which accepts values of user fields from commandline, 
create object and append that to a text file. 
After every user creation the program should prompt: "Do you want to continue creating users? 
(Type QUIT to exit)" and keep on accepting values and writing to file unitl user quits.
*/

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class User {
    private String firstName;
    private String lastName;
    private int age;
    private String phoneNumber;

    public User(String firstName, String lastName, int age, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public String toFileString() {
        return firstName + "," + lastName + "," + age + "," + phoneNumber;
    }
}

public class Question2 {
    private static final String FILE_NAME = "users.txt";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            while (true) {
                System.out.print("Enter First Name: ");
                String firstName = scanner.nextLine();

                System.out.print("Enter Last Name: ");
                String lastName = scanner.nextLine();

                System.out.print("Enter Age: ");
                int age = Integer.parseInt(scanner.nextLine());

                System.out.print("Enter Phone Number: ");
                String phoneNumber = scanner.nextLine();

                User user = new User(firstName, lastName, age, phoneNumber);
                writer.write(user.toFileString());
                writer.write(System.lineSeparator());
                writer.flush();

                System.out.print(
                    "Do you want to continue creating users? (Type QUIT to exit): "
                );

                String choice = scanner.nextLine();

                if ("QUIT".equalsIgnoreCase(choice)) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid age input.");
        } finally {
            scanner.close();
        }
    }
}