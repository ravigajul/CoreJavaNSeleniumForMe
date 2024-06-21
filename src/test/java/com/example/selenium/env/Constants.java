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
    public static String JDBC_URL = "jdbc:oracle:thin:@192.168.56.103:1521:ORCL";
    public static String DB_USER_NAME = "hr";
    public static String DB_PASSWORD = "hr";

}
