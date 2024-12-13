package com.education.ztu.Task7;

import java.util.Random;

public class ArrayGenerator {

    /**
     * Returns a pseudorandomly chosen array with int values between the specified origin (inclusive) and the specified bound (exclusive)
     * @param length
     * @param origin
     * @param bound
     * @return
     */
    public static int[] generateArray(int length, int origin, int bound){
        Random random = new Random();

        int[] arr = new int[length];
        for(int i = 0; i < length; i++){
            arr[i] = random.nextInt(origin, bound);
        }

        return arr;
    }
}
