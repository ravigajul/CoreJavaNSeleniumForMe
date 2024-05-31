package com.example.accessmodifiers.folder1;
public class Company {
    public String companayWebsite = "https://www.msrcosmos.com";
    protected String trainingResources = "javatraining material";
    String departmentDocuments = "Testing";
    private String personalKeys = "Personal Key";
    // Applicable to both members(properties) and methods
    // public -- Accessible from everywhere and by everybody
    // protected -- accessible from a class in same package(folder) and classes in
    // other package provided it is a subclass
    // default -- accessible from a class in same package only (package-private)
    // private -- within the class only.

    public void displayCompanyInfo() {
        System.out.println("Public company Website :" + companayWebsite);
        System.out.println("protected training resources :" + trainingResources);
        System.out.println("Default department Doucuments :" + departmentDocuments);
        System.out.println("private personal Keys :" + personalKeys);
    }
}
