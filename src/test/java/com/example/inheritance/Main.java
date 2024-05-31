package com.example.inheritance;

/* Inheritance: one class aquires properties (methods and fields) of another class!
Why? For reusability
How? Using extends keyword

Subclass (derived class or child class)
Superclass (base class or parent class)

Important points
----------------
- Subclass can have it's own methods and fields in addition to Superclass's methods and fields
- Subclass can have only one Superclass. In other words, multiple inheritance is not supported
- Subclass cannot inherit Superclass's constructor, but it can invoke the constructor

Types
-----
Single inheritance
Multilevel inheritance
Hierarchical inheritance
Multiple inheritance (using interface)

super keyword
-------------
- Used to differentiate members of Superclass from members of Subclass, if they have same names
- Used to invoke the constructor of Superclass from Subclass  */

public class Main {
    public static void main(String[] args) {
        Manager mgr = new Manager("RaviGajul", 30, "Testing");
        Programmer prgmr = new Programmer("Rajesh", 20, "Java");

        mgr.displayInfo();
        prgmr.displayInfo();
    }
}
