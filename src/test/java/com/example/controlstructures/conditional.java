package com.example.controlstructures;

import java.util.Scanner;

public class conditional {
    public static void main(String[] args) {

        int a = 10;
        int b = 20;
        int c = 30;

        // conditional Statement
        if (a == b) {
            System.out.println("a is equal to B");
        } else if (a == c) {
            System.out.println("a is equal to c");
        } else {
            System.out.println("a is not equal to b or c");
        }

        // Switch Case when the variable outcome is finite number of values
        // String weekDay = "Friday";

        // Reading from keyboard

        Scanner scanner = new Scanner(System.in);
        System.out.println(" Enter a weekday");

        switch (scanner.nextLine().toUpperCase()) {
            case "MONDAY":
                System.out.println("It is Monday");
                break;
            case "TUESDAY":
                System.out.println("It is Tuesday");
                break;
            case "WEDNESDAY":
                System.out.println("It is Wednesday");
                break;
            case "THURSDAY":
                System.out.println("It is Thursday");
                break;
            case "FRIDAY":
                System.out.println("It is Friday");
                break;
            case "SATURDAY":
                System.out.println("It is Saturday");
                break;
            case "SUNDAY":
                System.out.println("It is Sunday");
                break;
            default:
                System.out.println("There is no such weekday");
                break;
        }
        scanner.close(); // Close the scanner to avoid resource leaks
    }
}
