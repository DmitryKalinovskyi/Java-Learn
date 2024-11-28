package com.education.ztu;

import java.util.Comparator;
import java.util.TreeSet;

public class Task5 {
    public static void main(String[] args){
        // store product ordered by price
        TreeSet<Product> treeSet = new TreeSet<>(Comparator.comparing(Product::getPrice)
                .thenComparing(Product::getName));

        treeSet.add(new Product("Laptop", 100.12));
        treeSet.add(new Product("XXLaptop", 123.12));
        treeSet.add(new Product("XLaptop", 112.12));

        for(Product product: treeSet){
            System.out.println(product.getName());
        }

        Product founded = treeSet.floor(new Product("?", 110));
        if(founded != null){
            System.out.println("Founded: ");
            System.out.println(founded.getName());
        }

        Product last = treeSet.last();
        if(last != null){
            System.out.println("Last element: ");
            System.out.println(last.getName());
        }
    }
}
