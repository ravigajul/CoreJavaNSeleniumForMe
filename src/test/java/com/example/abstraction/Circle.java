package com.example.abstraction;

public class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    public String info(){
        return "The area of the circle is :" + area();
    }
}
