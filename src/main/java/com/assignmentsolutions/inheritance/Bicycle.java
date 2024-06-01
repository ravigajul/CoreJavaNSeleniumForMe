package com.assignmentsolutions.inheritance;

public class Bicycle extends Vehicle {
    private int numberOfGears;

    public Bicycle(String brand, String model, int numberOfGears) {
        super(brand, model);
        this.numberOfGears = numberOfGears;
    }

    public int getNumberOfGears() {
        return numberOfGears;
    }

    @Override
    public void drive() {
        // super.drive();
        System.out.println("This bicyle is pedaling");
    }

}
