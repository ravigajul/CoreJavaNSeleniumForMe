package com.example.controlstructures;

import java.util.Scanner;

public class loops {

    public static void main(String[] args) {

        // for loop
        for (int i = 0; i <= 10; i++) {
            System.out.println(i);
        }

        // for loop in reverse order
        for (int i = 10; i >= 0; i--) {
            System.out.println(i);
        }

        // incrementing by 2
        for (int i = 0; i <= 10; i = i + 2) {
            System.out.println(i);
        }

        // while loop when you do not know how many iterations are required
        Scanner scanner = new Scanner(System.in);
        String password = "Welcome!123";
        int counter = 1;
        System.out.println("Enter the password");
        String enteredPassword = scanner.nextLine();
        // Give the option to enter only 3 times
        while (!password.equals(enteredPassword)) {
            System.out.println("Enter the password");
            enteredPassword = scanner.nextLine();
            counter++;
            if (counter == 3) {
                System.out.println("Account locked. Invalid password too many attempts!!");
                break;
            }
            if (password.equals(enteredPassword)) {
                System.out.println("you have logged in successfully");
                counter = 0;
            }
        }

        // do while
        String anotherpassword;
        do {
            System.out.println("Enter the password");
            anotherpassword = scanner.nextLine();
            counter++;
            if (counter == 3) {
                System.out.println("Account locked. Too many invalid attempts");
                break;
            }
            if (password.equals(anotherpassword)) {
                System.out.println("Logged in successfully");
            }
        } while (!password.equals(anotherpassword));
        scanner.close(); // Close the scanner to avoid resource leaks
    }
}
