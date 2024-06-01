package com.example.inheritance;

public class Employee {
    String name;
    int empId;

    Employee(String name, int empId) {
        this.name = name;
        this.empId = empId;
    }

    public void displayInfo() {
        System.out.println("Employee name is " + name + " and Employee Id is " + empId);
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", empId=" + empId + "]";
    }

    
}
