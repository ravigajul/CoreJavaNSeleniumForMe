package com.example.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DownloadFolderCleaner {
    public static void clearDownloadFolder(String downloadFolderPath) {
        Path downloadFolder = Paths.get(downloadFolderPath);

        try {
            Files.list(downloadFolder)
                    .filter(Files::isRegularFile)
                    .forEach(file -> {
                        try {
                            Files.deleteIfExists(file);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
