package com.example.polymorphsm;

/* Polymorphism
=============
Ability of an object to take many forms. 

How:
====
By overriding or overloading methods.

Method Overriding :
=====================
Subclass provides a specific implementation of already provided method in parent class
Method in subclass should have same name, same signature and same return type as its super class

Methoad overloading
=======================
Will ave same name but different signatures, can differe by number of input paramaters or types or both.

Polymorphsym Types
===================
Runtime polymorphism  or dynamic method dispatch; Call resolved at runtime based on the type of the object being referred to at the time of the call.
eg : Method overriding
Compile time polymorphism : Call resolved at compile time.
eg : Method overloading
run time polymorphism
Notes :
 Final and static methods cannot be overriden
 parent class reference can only call the overriden methods of subclass. to call subclass method, we need to created subclass reference.
 
 Example:
 ==============
 vehicle class refuel(Vehicle vehicle)
 car -->refuel method overloaded
 truck ->refule method overloaded
 motorcyle  - refuel method overloaded
 
 * Parent reference can access only the overriden methods in child class
 * To access the methods specific to child , created child reference. */

public class Main {
    public static void main(String[] args) {

        FuelStation fuelStation = new FuelStation();
        Vehicle car = new Car();
        Vehicle truck = new Truck();
        Vehicle bike = new MotorBike();
        Vehicle tesla = new ElectricCar();

        fuelStation.fuelTheVehicle(car);
        fuelStation.fuelTheVehicle(truck);
        fuelStation.fuelTheVehicle(bike);
        fuelStation.fuelTheVehicle(tesla);

    }
}
