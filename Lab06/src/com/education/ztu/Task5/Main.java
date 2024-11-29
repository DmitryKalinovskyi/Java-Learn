package com.education.ztu.Task5;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {
    public static void main(String[] args){
        String path = "directory_for_files/random_access.txt";
        try{
            try(RandomAccessFile randomAccessFile = new RandomAccessFile(path, "rw")){
                randomAccessFile.seek(4);
                randomAccessFile.writeUTF("Inserted row");
            }
        }catch (IOException e){
            System.out.println("Failed to add to random position row: " + e.getMessage());
        }
    }
}
