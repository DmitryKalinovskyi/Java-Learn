package com.education.ztu.Task3;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i <= 10000; i++){
            if(Thread.currentThread().isInterrupted()){
                System.out.println("Розрахунок завершено!!!");
                break;
            }
            if(i % 10 == 0)
                System.out.println(i);
        }
    }
}
