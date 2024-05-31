package com.example.interfaces;

public class Circle implements Shape {
    double radius;
    String color;
    public Circle(String color, double radius){
       this.color=color;
        this.radius=radius;
    }
    @Override
    public String color() {
        return color;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius,2);
    }

    @Override
    public String info() {
        return "The area of the " + color + " circle is :" + area();
    }
    
}
