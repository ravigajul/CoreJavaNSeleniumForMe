package com.example.abstrctn;

public class Main {
    public static void main(String[] args) {
        Shape shape = new Circle(2.0);
        Shape square = new Square(4);
        System.out.println(shape.area());
        System.out.println(square.area());
    }
}
