package com.education.ztu.Task7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static long multiThreadSum(int[] arr, int threadsCount) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(threadsCount);

        // divide our array into chunks
        int chunkSize = Math.ceilDiv(arr.length, threadsCount);
        List<Callable<Long>> tasks = new ArrayList<>();
        for(int i = 0; i < threadsCount; i++){
            int start = i*chunkSize;
            int end = Math.min(arr.length, (i+1)*chunkSize);

            tasks.add(() -> {
                long sum = 0;
                for(int j = start; j < end; j++){
                    sum += arr[j];
                }

                return sum;
            });
        }

        List<Future<Long>> results = executor.invokeAll(tasks);
        long totalSum = 0;
        for(Future<Long> result: results){
            totalSum += result.get();
        }

        return totalSum;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int[] arr = ArrayGenerator.generateArray(1000_000_000, 0, 100);

        Thread oneThreadSum = new Thread(() -> {
            long sum = 0;
            for (int j : arr) sum += j;

            System.out.printf("Answer = %d\r\n", sum);
        });

        long beforeOneThreadSum = System.currentTimeMillis();
        oneThreadSum.start();
        oneThreadSum.join();
        long deltaTime = System.currentTimeMillis() - beforeOneThreadSum;
        System.out.printf("Answer calculated in %d ms\n", deltaTime);

        long beforeMultiThreadSum = System.currentTimeMillis();
        System.out.printf("Answer = %d\r\n", multiThreadSum(arr, 10));
        deltaTime = System.currentTimeMillis() - beforeMultiThreadSum;
        System.out.printf("Answer calculated in %d ms\n", deltaTime);

    }
}
