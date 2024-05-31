package com.example.variables;

public class Variables {
    String lastName;
    static String email;
    int j;

    // constructors
    public Variables() {
        // initialzing variable in constructor
        lastName = "Gajul";
    }

    // constructor with an argument.
    public Variables(int j) {
        this.j = j;
    }

    // Constructor with Variable

    public static void main(String[] args) {

        // variables
        int i = 10;
        char c = 'X';
        String firstName = "Ravi";
        String fullName = new String("Ravi Kumar Gajul");
        double d = 10.0;
        boolean flag = true; 

        // initialize through function call
        initialize("Ravi.Gajul@test.com");
        System.out.println(i);
        System.out.println(c);
        System.out.println(firstName);
        System.out.println(fullName);
        System.out.println(d);
        System.out.println(flag);

    }

    public static void initialize(String email) {
        Variables.email = email;
    }
}
