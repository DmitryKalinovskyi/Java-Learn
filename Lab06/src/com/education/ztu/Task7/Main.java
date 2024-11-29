package com.education.ztu.Task7;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) {
        try (OutputStream outputStream = new FileOutputStream("directory_for_files.zip")) {
            try (ZipOutputStream zipOutput = new ZipOutputStream(outputStream)){
                Path sourcePath = Path.of("directory_for_files");
                Files.walkFileTree(sourcePath, new SimpleFileVisitor<>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        zipOutput.putNextEntry(new ZipEntry(sourcePath.relativize(file).toString()));
                        Files.copy(file, zipOutput);
                        zipOutput.closeEntry();
                        return FileVisitResult.CONTINUE;
                    }
                });

                System.out.println("File successfully compressed.");
            }
        }
        catch (IOException e){
            System.out.println("Failed to compress folder.");
        }

        try(InputStream inputStream = new FileInputStream("directory_for_files.zip")){
            try(ZipInputStream zipInput = new ZipInputStream(inputStream)){
                while(zipInput.available() == 1) {
                    ZipEntry entry = zipInput.getNextEntry();
                    if(entry == null) continue;
                    System.out.println(entry.getName());
                }
            }
        }catch (IOException e){
            System.out.println("Failed to display content of zip archive.");
        }
    }
}
