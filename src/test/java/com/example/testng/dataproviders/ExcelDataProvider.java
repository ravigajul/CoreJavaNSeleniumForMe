package com.example.testng.dataproviders;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.DataProvider;

import com.example.selenium.env.Constants;
import com.example.utils.ExcelReader;

public class ExcelDataProvider {
    @DataProvider(name = "Excel-Data-Provider")
    public static HashMap<String, String>[] readExcelData() throws IOException {
        return ExcelReader.getExcelData(Constants.EXCEL_FILE_PATH, Constants.EXCEL_SHEET);
    }

}
