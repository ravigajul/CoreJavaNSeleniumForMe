package com.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.selenium.env.Constants;

public class DatabaseConnection {
    public static List<HashMap<String, Object>> getEmployeeData(String query) throws Exception {
        List<HashMap<String, Object>> dataList = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            String url = Constants.JDBC_URL;
            String username = Constants.DB_USER_NAME;
            String password = Constants.DB_PASSWORD;
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();

            rs = stmt.executeQuery(query);
            int columns = rs.getMetaData().getColumnCount(); // Get column count
            int rowCount = 0;
            while (rs.next()) {

                HashMap<String, Object> row = new HashMap<>();
                // index start 1 since he first column is 1, the second is 2
                for (int i = 1; i <= columns; i++) {
                    String columnName = rs.getMetaData().getColumnName(i);
                    Object value = rs.getObject(i);
                    row.put(columnName, value);
                }
                dataList.add(rowCount, row);
                rowCount++;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return dataList;
    }

    public static void main(String[] args) throws Exception {
        List<HashMap<String, Object>> empData = getEmployeeData("select * from employees where rownum<=5");
        for (HashMap<String, Object> hashMap : empData) {
            System.out.println(empData);
        }
       
        List<HashMap<String, Object>> depData = getEmployeeData("select * from departments where rownum<=5");
        for (HashMap<String, Object> hashMap : depData) {
            System.out.println(hashMap);
        }

    }
}
