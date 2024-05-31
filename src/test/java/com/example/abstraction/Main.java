package com.example.abstraction;

/* Abstraction in Java is one of the core principles of Object-Oriented Programming (OOP). 
It involves hiding the complex implementation details and showing only the 
necessary features of an object. This can be achieved using abstract classes and interfaces 
Abstraction: Hide the details and show only essential information
Can be achieved by two ways:
1. Abstract Classes - PArtial Abstraction
	1. Cannot be directly instantiated
	2. Subclasses can access abstract method using inhertitance ( extends)
	3. Overriding is compulsory for subclasses
	4. Can have parameterized constructor
	
	Ex: Shape, circle, triange
	we are hiding the area implementaion , just creating the construtor with param and calling info, info internally calls area.
	
Advantages:
===========
	1. reducing complexity by hiding implementation details
	2. promotes reusability
	3. increasing security
	3. Avoids code duplication.*/

public class Main {
    public static void main(String[] args) {
        Shape shape = new Circle(2.0);
        Shape square = new Square(4);
        System.out.println(shape.info());
        System.out.println(square.info());
    }
}
