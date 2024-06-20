package com.example.selenium.env;

import java.io.File;

public class Constants {
    // public static String EXCEL_FILE_PATH = "com"+ File.separator + "example"+
    // File.separator +"selenium"+ File.separator +"data"+ File.separator
    // +"TestData.xlsx";
    public static String EXCEL_FILE_PATH = System.getProperty("user.dir") + File.separator + "src" + File.separator
            + "test" + File.separator + "java" + File.separator + "com" + File.separator + "example" + File.separator
            + "selenium" + File.separator + "data" + File.separator + "TestData.xlsx";
    public static String EXCEL_SHEET = "Employees";

}
