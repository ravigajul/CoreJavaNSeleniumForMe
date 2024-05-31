package com.example.accessmodifiers.folder2;

import com.example.accessmodifiers.folder1.Company;

public class Stranger {
    public static void main(String[] args) {
        Company comp = new Company();
        comp.companayWebsite = "https://msrcosmOs.com";
        System.out.println(comp.companayWebsite); // public
        // System.out.println(comp.departmentDocuments); //default
        // System.out.println(comp.trainingResources); //protected
        // System.out.println(comp.personalKeys); //private
    }
}
