//Using java 8 date/time api:
//1. WAP to get two dates from user and print if the first date occurs before or after the second date supplied by the user.
//2. WAP to print current date and time in 3 different time zones.

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

class Question10{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first date (YYYY-MM-DD): ");
        String firstDateInput = sc.nextLine();
        System.out.println("Enter second date (YYYY-MM-DD): ");
        String secondDateInput = sc.nextLine();

        if (date1.isBefore(date2)) {
            System.out.println("First date occurs before second date");
        } else if (date1.isAfter(date2)) {
            System.out.println("First date occurs after second date");
        } else {
            System.out.println("Both dates are equal");
        }

        ZonedDateTime india = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        ZonedDateTime usa = ZonedDateTime.now(ZoneId.of("America/New_York"));
        ZonedDateTime uk = ZonedDateTime.now(ZoneId.of("Europe/London"));

        System.out.println("India Time: " + india);
        System.out.println("USA Time: " + usa);
        System.out.println("UK Time: " + uk);
    }
}