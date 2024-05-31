package com.example.polymorphsm;
public class ElectricCar extends Vehicle{
    
    @Override
    public void reFuel(){
        System.out.println("Charging the Electric Car");
    }

    public void checkBatteryStatus(){
        System.out.println("Checking battery status");
    }
}
