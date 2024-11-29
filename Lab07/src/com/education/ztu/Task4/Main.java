package com.education.ztu.Task4;

public class Main {
    public static void main(String[] args){
        Counter counter = new Counter();
        Thread thread1 = new Thread(new ArithmeticProgressionRunnable(counter));
        Thread thread2 = new Thread(new ArithmeticProgressionRunnable(counter));
        Thread thread3 = new Thread(new ArithmeticProgressionRunnable(counter));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
