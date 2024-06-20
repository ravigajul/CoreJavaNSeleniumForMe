package com.example.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    public static HashMap<String, String>[] getExcelData(String filePath, String sheetName) throws IOException {
        FileInputStream inputStream = new FileInputStream(filePath);
        try (XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {
            return processWorkbook(workbook.getSheet(sheetName)); // Assuming data is on the first sheet
        }
    }

    private static HashMap<String, String>[] processWorkbook(Sheet sheet) {
        @SuppressWarnings("unchecked")
        HashMap<String, String>[] data = new HashMap[sheet.getLastRowNum()];
        int rowCount = 0;

        // Get header row
        Row headerRow = sheet.getRow(0);
        Iterator<Cell> headerIterator = headerRow.cellIterator();

        // Extract header names
        String[] headerNames = new String[headerRow.getLastCellNum()];
        int headerIndex = 0;
        while (headerIterator.hasNext()) {
            Cell headerCell = headerIterator.next();
            headerNames[headerIndex++] = headerCell.getStringCellValue().trim();
        }

        // Iterate through data rows
        for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
            Row dataRow = sheet.getRow(rowIndex);
            if (dataRow == null) {
                continue; // Skip empty rows
            }

            HashMap<String, String> rowData = new HashMap<>();
            Iterator<Cell> dataIterator = dataRow.cellIterator();

            // Extract data for each cell
            int cellIndex = 0;
            while (dataIterator.hasNext()) {
                Cell dataCell = dataIterator.next();
                String value = "";
                switch (dataCell.getCellType()) {
                    case STRING:
                        value = dataCell.getStringCellValue().trim();
                        break;
                    case NUMERIC:
                        value = String.valueOf(dataCell.getNumericCellValue());
                        break;
                    case BLANK:
                        break;
                    case BOOLEAN:
                        break;
                    case ERROR:
                        break;
                    case FORMULA:
                        break;
                    case _NONE:
                        break;
                    default:
                        break;
                }
                rowData.put(headerNames[cellIndex++], value);
            }

            data[rowCount++] = rowData;
        }

        return data;
    }
}
