//Write a java program to show following menu to the user:
    //*******Menu******* 
    //1. Calculate Area of Circle
    //2. Calculate Circumference of a Circle 
    //3. Exit. 
    //Choose an option (1-3): Take radius as user input.
    //Hint: Use Switch statement to act on the menu.
    //Also area and circumference methods should be static

import java.util.Scanner;

class Question3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("*******Menu*******");
        System.out.println("1. Calculate Area of Circle");
        System.out.println("2. Calculate Circumference of a Circle");
        System.out.println("3. Exit.");
        System.out.print("Choose an option (1-3): ");
        int choice = sc.nextInt();
        sc.nextLine();
        double radius;
        switch (choice) {
            case 1:
                System.out.print("Enter the radius of the circle: ");
                radius = sc.nextDouble();
                System.out.println("Area of Circle: " + calculateArea(radius));
                break;
            case 2:
                System.out.print("Enter the radius of the circle: ");
                radius = sc.nextDouble();
                System.out.println("Circumference of Circle: " + calculateCircumference(radius));
                break;
            case 3:
                System.out.println("Exiting the program.");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please choose a valid option (1-3).");
        }
        sc.close();
    }
    static double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }
    static double calculateCircumference(double radius) {
        return 2 * Math.PI * radius;
    }
}