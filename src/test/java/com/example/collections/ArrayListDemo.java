package com.example.collections;

import java.util.ArrayList;
import java.util.List;
/**
 * 1. Dyanmic Array
 * 2. Ordered List (indices)
 * 3. Faster Retrieval by its index number
 * 4. Allows Duplicates
 */

public class ArrayListDemo {
    public static void main(String[] args) {

        //adding numbers the integer list
        List<Integer> numbers = new ArrayList<>();
        numbers.add(0);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(3);

        //retriving all the elements from list
        for(int number: numbers){
            System.out.println(number);
        }

        //retrieving a specific element by its index
        System.out.println("The number at index 4 is : " + numbers.get(4));

    }
}
