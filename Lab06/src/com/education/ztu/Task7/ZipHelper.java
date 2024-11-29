package com.education.ztu.Task7;

import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipHelper {
    public static void zipFolder(Path sourcePath, Path zipOutputPath) throws IOException {
        try (OutputStream outputStream = new FileOutputStream(zipOutputPath.toString())) {
            try (ZipOutputStream zipOutput = new ZipOutputStream(outputStream)) {
                Files.walkFileTree(sourcePath, new SimpleFileVisitor<>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        zipOutput.putNextEntry(new ZipEntry(sourcePath.relativize(file).toString()));
                        Files.copy(file, zipOutput);
                        zipOutput.closeEntry();
                        return FileVisitResult.CONTINUE;
                    }
                });
            }
        }
    }

    public static List<String> getEntriesNames(Path zipArchivePath) throws IOException{
        List<String> names = new ArrayList<>();
        try(InputStream inputStream = new FileInputStream(zipArchivePath.toString());
            ZipInputStream zipInput = new ZipInputStream(inputStream)) {
            while (true) {
                ZipEntry entry = zipInput.getNextEntry();
                if (entry == null) break;
                names.add(entry.getName());
            }
        }
        return names;
    }
}
