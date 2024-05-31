package com.example.accessmodifiers.folder2;
/* Applicable to both members(properties) and methods 
public -- Accessible from everywhere and by everybody
protected -- accessible from a class in same package(folder) and classes in other package provided it is a subclass
default  -- accessible from a class in same package only (package-private)
private -- within the class only. */

public class Main {
    public static void main(String[] args) {
        CompanyBranch branch = new CompanyBranch();
        branch.test();
        // System.out.println(branch.companayWebsite); // public
        // System.out.println(branch.departmentDocuments); // default
        // System.out.println(branch.trainingResources); // protected
        // System.out.println(comp.trainingResources);
        // System.out.println(comp.personalKeys); // ;private
        // System.out.println(comp.trainingResources);
    }
}
