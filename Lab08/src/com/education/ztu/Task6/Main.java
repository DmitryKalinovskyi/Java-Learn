package com.education.ztu.Task6;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(16);
        numbers.add(2);
        numbers.add(4);
        numbers.add(121);

        String result = numbers.stream()
                .max(Integer::compareTo)
                .map(String::valueOf)
                .orElse("Числа відсутні");

        System.out.println(result);
    }

}
