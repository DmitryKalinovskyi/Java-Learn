package com.education.ztu;

public class Task5 {
    public static int sumDigits(int n){
        int sum = 0;
        int t = Math.abs(n);
        while(t > 0){
            sum += t % 10;
            t /= 10;
        }

        return sum;
    }
}
