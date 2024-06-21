package com.example.testng.dataproviders;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.example.utils.DatabaseConnection;

public class OracleDataProvider {
    @SuppressWarnings("unchecked")
    @DataProvider(name = "Oracle-Data-Provider")
    public static HashMap<String, Object>[] getEmployeeData() throws Exception {
        String query = "SELECT *  FROM EMPLOYEES WHERE ROWNUM<=5";
        List<HashMap<String, Object>> empData = DatabaseConnection.getEmployeeData(query);
        // Create an iterator that iterates through the converted Object[] arrays
        return empData.toArray(HashMap[]::new);
    }
}