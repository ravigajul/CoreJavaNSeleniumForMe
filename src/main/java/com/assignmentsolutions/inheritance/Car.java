package com.assignmentsolutions.inheritance;

public class Car extends Vehicle {
    private int numberOfSeats;

    public Car(String brand, String model, int numberOfSeats) {
        super(brand, model);
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    @Override
    public void drive() {
        // super.drive();
        System.out.println("The car is driving");
    }
}
