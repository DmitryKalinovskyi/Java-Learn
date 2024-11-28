package com.education.ztu.Task4;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CopyHelper {
    public static void copy(String from, String to) throws IOException, RuntimeException {
        Path path = Paths.get(to);
        if(Files.exists(path)){
            throw new RuntimeException("There already exist file with that name.");
        }

        try(FileInputStream inputStream = new FileInputStream(from)){
            try(FileOutputStream outputStream = new FileOutputStream(to)){
                outputStream.write(inputStream.readAllBytes());
            }
        }
    }
}
