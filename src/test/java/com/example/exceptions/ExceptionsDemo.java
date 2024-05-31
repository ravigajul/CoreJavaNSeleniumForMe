package com.example.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/* Exceptions
Types:
	1. Compile time exception (checked exception) --during coding
	2. Runtime Exception (unchecked exception) --during execution
		ex: Array Index out of bound ..during execution.

Ways to handle exception:

	1. Throws keyword so that exception is postponed
	2. try catch finally
	3. try with resources
	4. user defined exception
	5. throw new exception */

public class ExceptionsDemo {

    public static void main(String[] args) {
        // runTimeExceptionDemo();
        // handledExceptionThroughTryCatch();
        /*
         * try {
         * unHandledThroughThrows();
         * } catch (FileNotFoundException e) {
         * e.printStackTrace();
         * }
         */

        // try {
        // throwsExceptionDemo();
        // } catch (FileNotFoundException e) {
        // e.printStackTrace();
        // }

        // userDefinedException();
    }

    public static void runTimeExceptionDemo() {
        int numbers[] = { 1, 2, 3, 4, 5 };
        System.out.println(numbers[6]); // run time exception

    }

    public static void unhandledException() {
        File file = new File("cd://test.txt");
        // FileReader fr = new FileReader(file); //throws compile time exception

    }

    public static void handledExceptionThroughTryCatch() {
        File file = new File("cd://test.txt");
        FileReader fr = null;
        try {
            fr = new FileReader(file); // try catch to handle exception
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("After Exception");
    }

    public static void unHandledThroughThrows() throws FileNotFoundException {
        File file = new File("cd://test.txt");
        FileReader fr = new FileReader(file);
        System.out.println("After Exception");
    }

    public static void handledThroughTryWithResources() {
        File file = new File("cd://test.txt");
        try (FileReader fr = new FileReader(file)) { // to avoid multiple try catches and closures we use try with
                                                     // resource
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("After Exception");
    }

    public static void throwsExceptionDemo() throws FileNotFoundException {
        File file = new File("cd://test.txt");
        FileReader fr = new FileReader(file);
    }

    public static void userDefinedException() {
        try {
            throw new MyException();
        } catch (MyException e) {
            e.printException();
        }
    }

}
