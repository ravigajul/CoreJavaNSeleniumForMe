package com.example.abstrctn;

public class Square extends Shape {
    double side;

    Square(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }
}
