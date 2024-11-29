package com.education.ztu.Task4;

public class ArithmeticProgressionRunnable implements Runnable{
    private final Counter counter;
    public ArithmeticProgressionRunnable(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run(){
        while(counter.num <= 100){
            System.out.println(counter.num);
            counter.num++;
            try {
                Thread.sleep(200);
            } catch (InterruptedException _) {
            }
        }
    }
}
