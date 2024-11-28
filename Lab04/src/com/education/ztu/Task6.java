package com.education.ztu;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Task6 {
    private static boolean isLeapYear(int year){
        if(year < 0) throw new IllegalArgumentException("Year can't be negative.");
        return year % 4 == 0;
    }

    public static void main(String[] args){
        LocalDateTime startOfLabTime = LocalDateTime.of(2024, 11, 28, 12, 26);

        System.out.printf("%s %d %s %d %d:%d:%d", startOfLabTime.getDayOfWeek().toString(),
                startOfLabTime.getDayOfYear(),
                startOfLabTime.getMonth().toString(),
                startOfLabTime.getYear(),
                startOfLabTime.getHour(),
                startOfLabTime.getMinute(),
                startOfLabTime.getSecond());

        if(isLeapYear(startOfLabTime.getYear())){
            System.out.println("Is leap year.");
        }
        else{
            System.out.println("Is not leap year.");
        }

        LocalDateTime currentTime = LocalDateTime.now();
        if(currentTime.isAfter(startOfLabTime)){
            System.out.println("Current time is after start of lab time.");
        }
        else{
            System.out.println("Current time is before start of lab time.");
        }


        LocalDateTime startOfDay = currentTime.toLocalDate().atStartOfDay();
    }

}
