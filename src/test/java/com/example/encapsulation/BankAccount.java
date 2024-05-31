package com.example.encapsulation;

public class BankAccount {
    private double balance;

    private void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public BankAccount(double initialBalance) {
        if (initialBalance > 0) {
            setBalance(initialBalance);
        } else {
            this.balance = 0;
        }
    }

    public double deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
        } else {
            System.out.println("Negative deposits not allowed");
        }
        return balance;

    }

    public double withDraw(double amount) {
        if (amount > 0) {
            balance = balance - amount;
        } else {
            System.out.println("Cannot withdraw negative amounts");
        }
        return balance;
    }

}
