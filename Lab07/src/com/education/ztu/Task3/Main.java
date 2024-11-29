package com.education.ztu.Task3;

public class Main {
    public static void main(String[] args){
        Thread thread1 = new Thread(new MyRunnable());
        Thread thread2 = new Thread(new MyRunnable());
        Thread thread3 = new Thread(new MyRunnable());

        thread1.start();
        thread2.start();
        thread3.start();

        try{
            Thread.sleep(10);
        }catch (InterruptedException e){
            System.out.println("Interrupted.");
        }

        thread1.interrupt();
        thread2.interrupt();
        thread3.interrupt();
    }
}
