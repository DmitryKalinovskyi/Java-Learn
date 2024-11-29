package com.education.ztu.Task5;

public class ArithmeticProgressionRunnable implements Runnable{
    private final Counter counter;
    private static final Object counterLock = new Object();
    public ArithmeticProgressionRunnable(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        while(true){
            synchronized (counterLock){
                if(counter.num > 100)break;

                System.out.println(counter.num);
                counter.num++;
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException _) {}
        }
    }
}
