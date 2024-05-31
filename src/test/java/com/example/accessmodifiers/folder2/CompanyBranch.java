package com.example.accessmodifiers.folder2;

import com.example.accessmodifiers.folder1.Company;

public class CompanyBranch extends Company {

    public void test() {
        System.out.println(trainingResources); // protected
        System.out.println(companayWebsite); //public
        //System.out.println(departmentDocuments); //default is package-private
        // System.out.println(personalKeys); //private
    }
}
