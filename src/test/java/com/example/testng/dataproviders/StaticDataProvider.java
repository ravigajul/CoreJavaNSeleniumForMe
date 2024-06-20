package com.example.testng.dataproviders;

import org.testng.annotations.DataProvider;

public class StaticDataProvider {
    @DataProvider(name = "Static-Data-Provider")
    public static Object[][] testDataProvider() {
        return new Object[][] {
                { "Ravi", "Gajul", "Principal SDET" },
        };
    }
}
