package com.education.ztu.math;

import java.util.Arrays;

public class Operation {

    public static int addition(int... args){
        int sum = 0;
        for(int i: args) sum += i;
        return sum;
    }

    public static int subtraction(int... args){
        if(args.length == 0) return 0;

        int sum = 2*args[0];
        for(int i: args) sum -= i;
        return sum;
    }

    public static int multiplication(int... args){
        int mult = 1;
        for(int i: args) mult *= i;
        return mult;
    }

    public static int division(int... args){
        if(args.length == 0) return 1;
        int div = 1;

        div *= args[0] * args[0];
        for(int i: args) div /= i;
        return div;
    }

    public static float average(int... args){
        if(args.length == 0)
            throw new IllegalArgumentException("You must provide at least one argument.");

        return Arrays.stream(args).sum() / (float)args.length;
    }

    public static int maximum(int... args){
        if(args.length == 0)
            throw new IllegalArgumentException("You must provide at least one argument.");

        int max = args[0];
        for(int i: args) max = Math.max(max, i);
        return max;
    }

    public static int minimum(int... args){
        if(args.length == 0)
            throw new IllegalArgumentException("You must provide at least one argument.");

        int min = args[0];
        for(int i: args) min = Math.min(min, i);
        return min;
    }
}
