package com.example.encapsulation;

/* Encapsulation: wrapping up of data under a single unit! The data is protected!

How? 
- By making class attributes (or variables) private
- By making methods as private

Use getter and setter methods to access private attributes

Advantages
----------
- Data hiding
- Flexibility to use variable as read only or write only
- Reusability */

public class Main {
    public static void main(String[] args) {

        BankAccount ba = new BankAccount(1000);
        System.out.println("Initial balance " + ba.getBalance());

        System.out.println("Updated balance after depositing 500 is : " +
                ba.deposit(500));
        System.out.println("Remaining balance after withdwaring 100$ is : " +
                ba.withDraw(100));
        // ba.balance=0;
        // System.out.println("Balance after hacker attacked " + ba.balance);

    }
}
