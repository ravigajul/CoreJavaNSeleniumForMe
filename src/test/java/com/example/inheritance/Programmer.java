package com.example.inheritance;

public class Programmer extends Employee {
    String programmingLanguage = "Java";

    Programmer(String name, int empId, String programmingLanguage) {
        super(name, empId);
        this.programmingLanguage = programmingLanguage;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println(
                "Employee " + name + " is a programmer who uses " + programmingLanguage
                        + " programming language");
    }

    @Override
    public String toString() {
        return "Programmer [name=" + name + ", empId=" + empId + ", programmingLanguage=" + programmingLanguage + "]";
    }
}
