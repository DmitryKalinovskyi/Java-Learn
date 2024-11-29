package com.education.ztu.Task6;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args){
        String workingDirectory = "directory_for_files";

        try{
            Path path = Files.createDirectory(Path.of(workingDirectory, "inner_directory"));
            System.out.println("Absolute path of created directory: " + path.toAbsolutePath());
            System.out.println("Name of the parent directory: " + path.getParent().getName(0));
            File test1 = new File(path.toFile(), "test1.txt");
            File test2 = new File(path.toFile(), "test2.txt");
            if(test1.createNewFile()){
                System.out.println("File test1.txt is successfully created.");
            }
            if(test2.createNewFile()){
                System.out.println("File test2.txt is successfully created.");
            }
            if(test1.delete()){
                System.out.println("File test1.txt is successfully deleted.");
            }

            File innerDirectory = path.toFile();
            File targetFile = Path.of(workingDirectory, "renamed_inner_directory").toFile();
            if(innerDirectory.renameTo(targetFile)){
                System.out.println("File is successfully renamed.");
            }

            File directoryForFiles = new File(workingDirectory);
            for (final File fileEntry : directoryForFiles.listFiles()) {
                if (fileEntry.isDirectory()) {
                    System.out.println(fileEntry.getName() + " - Directory");
                } else {
                    System.out.println(fileEntry.getName() + " - File of size " + fileEntry.length());
                }
            }
        }catch (IOException e){
            System.out.println("Error when trying to do operations: " + e.getMessage());
        }
    }

}
