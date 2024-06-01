package com.example.interfaces;

interface Shape {

    // by default public static final.
    // int i; hence error because of not initializing
    public static final int i=10;

    // abstract methods. By default abstract and public so need not explicitly use
    // it
    String color();

    double area();

    String info();
}
