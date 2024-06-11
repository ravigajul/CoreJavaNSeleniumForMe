package com.example.fileoperations;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileOperationTest {
    String userDir = System.getProperty("user.dir");
    String filePath = userDir + File.separator + "test-files" + File.separator + "test-file.txt";
    String fileDirPath = userDir + File.separator + "test-files";

    @BeforeClass
    public void setUp() {
        // Create file directory
        File testFileDir = new File(fileDirPath);
        if (!testFileDir.exists()) {
            testFileDir.mkdirs();
        }
    }

    @Test
    public void createFile() throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
            boolean isCreated = file.createNewFile();
            // assert isCreated : "File was not created successfully";

        }

    }

    @Test
    public void writeToFile() throws IOException {
        String content = "This is a test content";
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        }
    }

    @Test
    public void readFromFile() throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write("This is a test content.");
            }
        }

        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }

        assert content.toString().contains("This is a test content.") : "File content is incorrect";

    }

    @Test
    public void deleteFile() throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
        boolean isDeleted = file.delete();
        assert isDeleted : "File was not deleted successfully";
    }

    @Test
    public void copyFile() throws IOException {
        String sourceFilePath = System.getProperty("user.dir") + File.separator + "test-files" + File.separator
                + "test-file.txt";
        String targetFilePath = System.getProperty("user.dir") + File.separator + "test-files" + File.separator
                + "copied-file.txt";

        File sourceFile = new File(sourceFilePath);
        if (!sourceFile.exists()) {
            sourceFile.getParentFile().mkdirs();
            sourceFile.createNewFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(sourceFile))) {
                writer.write("This is a test content.");
            }
        }
        File targetFile = new File(targetFilePath);
        Files.copy(sourceFile.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        assert targetFile.exists() : "File was not copied successfully";
    }

    @AfterClass
    public void tearDown() {
        // Clean up the created file
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
    }

}
