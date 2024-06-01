package com.assignmentsolutions.inheritance;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Mazda", "2019", 4);
        Bicycle cycle = new Bicycle("Ranger", "1999", 5);

        car.drive();
        System.out.println("This car " + car.getBrand() + " is of model " + car.getModel() + " it has "
                + car.getNumberOfSeats() + " seats");

        cycle.drive();
        System.out.println("This cycle " + cycle.getBrand() + " is of model " + cycle.getModel() + " it has "
                + cycle.getNumberOfGears() + " gears");

    }
}
