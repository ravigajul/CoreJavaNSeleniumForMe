package com.example.polymorphsm;
public class Truck extends Vehicle {
 
    @Override
    public void reFuel(){
        System.out.println("Refuelling the Truck with Diesel");
    }
}
