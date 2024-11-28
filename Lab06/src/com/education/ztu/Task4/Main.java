package com.education.ztu.Task4;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        try{
            CopyHelper.copy("directory_for_files/order.txt", "directory_for_files/order_copy.txt");
        }catch (IOException|RuntimeException e){
            System.out.println("Error when trying to copy file: " + e.getMessage());
        }
    }

}
