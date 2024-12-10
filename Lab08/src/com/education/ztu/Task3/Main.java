package com.education.ztu.Task3;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args){
        Predicate<String> isInteger = (str) -> {
            try{
                int res = Integer.parseInt(str);
            }catch(NumberFormatException e){
                return false;
            }

            return true;
        };

        System.out.println(isInteger.test("10"));
        System.out.println(isInteger.test("10addaf"));

        Consumer<String> lectureStart = (s) -> System.out.println(s + " почалася о 8:30");
        Consumer<String> lectureEnd = (s) -> System.out.println(s + " закінчилась о 9:50");

        lectureStart.andThen(lectureEnd).accept("Пара");
        Supplier<String> supplierTest = () -> "Test result";
        System.out.println(supplierTest.get());

        Function<String, Integer> productOfNumbers = (s) -> {
            String[] result = s.split(" ");
            int product = 1;
            for(String token: result){
                if(isInteger.test(token)){
                    product *= Integer.parseInt(token);
                }
            }

            return product;
        };

        System.out.println("4! = " + productOfNumbers.apply("1 2 3 4"));
    }

}
