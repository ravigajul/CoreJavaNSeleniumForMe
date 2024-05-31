package com.example.abstraction;

public class Square extends Shape {
    double side;

    Square(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }

    @Override
    public String info()
    {
        return "Area of the square is:" + area();
    }
}
