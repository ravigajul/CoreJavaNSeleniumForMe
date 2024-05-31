package com.example.variables;

public class StringDemo {

    public static void main(String[] args) {
        String firstName = "Ravi";
        String lastName = "Gajul";
        String fullName = new String(" Ravi Kumar Gajul ");
        String str = "56";

        // some important string methods.
        System.out.println(firstName.length()); // length of the string
        System.out.println(firstName.substring(0, 4)); // substring from index 0 to 4-1 (3)
        System.out.println(firstName.trim()); // trims white spaces in both ends of the string
        System.out.println(firstName.charAt(3)); // returns the character at index 3
        System.out.println(firstName.concat("Gajul")); // adds two strings
        System.out.println(firstName + " " + lastName); // add two strings
        System.out.println(fullName.replace(" ", ",")); // replace space with comma
        System.out.println(fullName.toCharArray()); // returns the character array of strings
        System.out.println(fullName.toUpperCase()); // converts to upper case
        System.out.println(firstName.toLowerCase()); // converts to lower case
        System.out.println(firstName.equals(lastName)); // compares two strings case sensitive
        System.out.println(firstName.equalsIgnoreCase(lastName)); // compares two strings ignoring case
        System.out.println(firstName.compareTo(lastName)); // lexicographic comparision, compares if a<b return -1 , if
                                                           // a=b returns0 and if a>b returns 1

        int i = Integer.parseInt(str);
        System.out.println(String.valueOf(i));
    }

}
