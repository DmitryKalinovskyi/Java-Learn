package com.education.ztu.Task6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Message message = new Message();

        Thread reader = new Thread(() -> {
           Scanner scanner = new Scanner(System.in);

           while(true){
               System.out.print("Enter message: ");
               message.setContent(scanner.nextLine());
               try {
                   Thread.sleep(500);
               } catch (InterruptedException e) {
                   System.out.println("Thread is interrupted.");
               }
           }
        });

        Thread printer = new Thread(() -> {
            while(true){
                System.out.println("Entered message: " + message.getContent());
            }
        });

        reader.start();
        printer.start();
    }
}
