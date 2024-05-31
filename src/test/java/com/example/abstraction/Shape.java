package com.example.abstraction;

public abstract class Shape {

    // abstract method
    abstract double area();

    //abstract method
    abstract String info();

    public void displayInfo() {
        System.out.println("In the Shape clas");
    }
}
