package com.education.ztu;

import java.security.KeyPair;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task6 {
    public static void main(String[] args){
        Map<String, List<Product>> categoryBasedSplit = new HashMap<>();

        categoryBasedSplit.put("Laptops", List.of(new Product("Acer Aspire a1", 100), new Product("Dell x10", 200)));
        categoryBasedSplit.put("Food", List.of(new Product("Apple", 1), new Product("Banana", 2)));


        System.out.println("Categories: ");
        for(Map.Entry<String, List<Product>> entry: categoryBasedSplit.entrySet()){
            System.out.println("Number of products in \"" + entry.getKey() + "\" category: " + entry.getValue().size());
        }

        System.out.println("Size of map: ");
        System.out.println(categoryBasedSplit.size());

    }
}
