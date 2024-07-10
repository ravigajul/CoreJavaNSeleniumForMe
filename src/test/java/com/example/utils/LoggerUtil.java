package com.example.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtil {
    private static Logger logger;

    static {
        try {
            logger = LogManager.getLogger(LoggerUtil.class);
        } catch (Exception e) {
            System.err.println("Error initializing logger: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void info(String message) {
        if (logger != null) {
            logger.info(message);
        } else {
            System.out.println("INFO: " + message);
        }
    }

    public static void warn(String message) {
        if (logger != null) {
            logger.warn(message);
        } else {
            System.out.println("WARN: " + message);
        }
    }

    public static void error(String message) {
        if (logger != null) {
            logger.error(message);
        } else {
            System.out.println("ERROR: " + message);
        }
    }

    public static void fatal(String message) {
        if (logger != null) {
            logger.fatal(message);
        } else {
            System.out.println("FATAL: " + message);
        }
    }

    public static void debug(String message) {
        if (logger != null) {
            logger.debug(message);
        } else {
            System.out.println("DEBUG: " + message);
        }
    }
}