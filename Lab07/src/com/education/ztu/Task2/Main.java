package com.education.ztu.Task2;

public class Main {
    public static void main(String[] args){
        MyThread thread = new MyThread();

        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        System.out.println("Name: " + thread.getName());
        System.out.println("Priority: " + thread.getPriority());
        System.out.println("IsAlive: " + thread.isAlive());
        System.out.println("IsDaemon: " + thread.isDaemon());

        thread.setName("LoveThread");
        thread.setPriority(10);

        System.out.println("After update:");
        System.out.println("Name: " + thread.getName());
        System.out.println("Priority: " + thread.getPriority());
        System.out.println("IsAlive: " + thread.isAlive());
        System.out.println("IsDaemon: " + thread.isDaemon());

        try{
            thread.join();
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getPriority());
        System.out.println(thread.getState());
    }
}
