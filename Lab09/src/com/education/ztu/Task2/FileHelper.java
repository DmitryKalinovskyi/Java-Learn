package com.education.ztu.Task2;

import java.io.*;

public class FileHelper {
    public static String readFileContent(String filePath) throws IOException {
        try(BufferedReader fileReader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = fileReader.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = fileReader.readLine();
            }

            return sb.toString();
        }
    }

    public static void writeFileContent(String filePath, String content) throws IOException{
        try(BufferedWriter fileWriter = new BufferedWriter(new FileWriter(filePath))) {
            fileWriter.write(content);
        }
    }
}
