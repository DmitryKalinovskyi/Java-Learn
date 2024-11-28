package com.education.ztu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Task7 {
    public static void main(String[] args){
        ArrayList<Integer> searchList = new ArrayList<>();

        searchList.add(1);
        searchList.add(2);
        searchList.add(7);
        searchList.add(5);
        searchList.add(123);
        searchList.add(3);

        System.out.print("Sequence: ");
        for(Integer i: searchList){
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("Max element: " + Collections.max(searchList));
        System.out.println("Min element: " + Collections.min(searchList));

        Collections.rotate(searchList, -3);

        System.out.print("Rotated sequence by -3: ");
        for(Integer i: searchList){
            System.out.print(i + " ");
        }
        System.out.println();

        Collections.sort(searchList);
        System.out.print("Sorted sequence: ");
        for(Integer i: searchList){
            System.out.print(i + " ");
        }
        System.out.println();

        Integer result = Collections.binarySearch(searchList, 5);
        System.out.println(result);
    }
}
