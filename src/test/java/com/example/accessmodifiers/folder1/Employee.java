package com.example.accessmodifiers.folder1;

public class Employee {
    public static void main(String[] args) {
        Company comp = new Company();
        comp.companayWebsite = "https://hacker.com";
        System.out.println(comp.companayWebsite); // public
        System.out.println(comp.departmentDocuments); // default
        System.out.println(comp.trainingResources); // protected
        // System.out.println(comp.personalKeys); //;private
    }
}
