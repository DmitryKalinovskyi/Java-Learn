package com.education.ztu;

public class Task6{
    public static void printFibonacci(int n){
        if(n < 0){
            throw new IllegalArgumentException("n should be non-negative number");
        }

        int[] fibonacci = new int[Math.max(2, n)];
        fibonacci[0] = fibonacci[1] = 1;

        for(int i = 2; i < n; i++)
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];

        for(int i = 0; i < n; i++){
            System.out.print(fibonacci[i] + " ");
        }
        System.out.println();
        for(int i = n - 1; i>=0; i--){
            System.out.print(fibonacci[i] + " ");
        }
        System.out.println();
    }
}
