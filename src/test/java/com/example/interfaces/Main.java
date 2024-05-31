package com.example.interfaces;

/* 2. Interfaces - Complete Abstraction:

	1. Achieve 100% abstraction through interface
	2. Its a blue print . Says what to do and not how to do.
	3. All methods in interface are abstract and public (no method implementations)
	4. Responsibility of implementation lies with subclasses
	5. Attributes are by default publi, static and final. In other words ,attributes are constants
	6. Cannot create object of interface.
	7. Subclass implements interface
	8. Subclass can implement multiple interfaces
	
Advantages:
	1. Reduces complexity by hiding implementation
	2. Increases security by providing only important details to the user
	3. Helps achieve multiple inheritance
	
Example : 
Shapes : Abstract
Triangle : Subclass1
Square : SubClass2 */

public class Main {

    public static void main(String[] args) {
        Circle circle = new Circle("Red", 5.0);
        System.out.println(circle.info());

        Square square = new Square("Blue", 10.0);
        System.out.println(square.info());

    }
}
