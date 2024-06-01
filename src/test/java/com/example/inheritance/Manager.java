package com.example.inheritance;

public class Manager extends Employee {
    String department;

    Manager(String name, int empId, String department) {
        super(name, empId);
        this.department = department;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Employee " + name + " belongs to department : " + department);
    }

    @Override
    public String toString() {
        return "Manager [name=" + name + ", empId=" + empId + ", department=" + department + "]";
    }

}
