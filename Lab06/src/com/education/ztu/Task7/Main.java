package com.education.ztu.Task7;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) {
        Path zipArchivePath = Path.of("directory_for_files.zip");
        try{
            ZipHelper.zipFolder(Path.of("directory_for_files"), zipArchivePath);
        } catch (IOException e) {
            System.out.println("Failed to create archive. " + e.getMessage());
        }

        try{
            System.out.println("Entries of archive:");
            for(String entryName: ZipHelper.getEntriesNames(zipArchivePath)){
                System.out.println(entryName);
            }
        }catch (IOException e){
            System.out.println("Failed to iterate zip entries." + e.getMessage());
        }

    }
}
