package com.education.ztu;

public class Task4{
    public static int gcd(int a, int b){
        return a == 0 ? b: gcd(b % a, a);
    }
}
