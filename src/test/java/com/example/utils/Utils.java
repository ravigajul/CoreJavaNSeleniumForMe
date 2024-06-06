package com.example.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static String formatDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM yyyy");
        Date currentDate = new Date();
        String formattedDate = dateFormat.format(currentDate);
        System.out.println("Formatted date: " + formattedDate);
        return formattedDate;
    }
}


