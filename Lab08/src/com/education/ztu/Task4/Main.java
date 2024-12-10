package com.education.ztu.Task4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        List<Product> listOfProducts = new ArrayList<>();

        // Adding 15 sample products
        listOfProducts.add(new Product("Laptop", "Dell", 999.99, 5));
        listOfProducts.add(new Product("Smartphone", "Samsung", 799.99, 10));
        listOfProducts.add(new Product("Headphones", "Sony", 199.99, 15));
        listOfProducts.add(new Product("Tablet", "Apple", 599.99, 8));
        listOfProducts.add(new Product("Smartwatch", "Garmin", 249.99, 12));
        listOfProducts.add(new Product("Monitor", "LG", 299.99, 7));
        listOfProducts.add(new Product("Keyboard", "Logitech", 49.99, 20));
        listOfProducts.add(new Product("Mouse", "Razer", 39.99, 25));
        listOfProducts.add(new Product("Printer", "HP", 159.99, 6));
        listOfProducts.add(new Product("Speaker", "JBL", 89.99, 18));
        listOfProducts.add(new Product("Router", "TP-Link", 69.99, 22));
        listOfProducts.add(new Product("External Hard Drive", "Seagate", 129.99, 9));
        listOfProducts.add(new Product("Webcam", "Logitech", 89.99, 14));
        listOfProducts.add(new Product("Graphics Card", "NVIDIA", 499.99, 3));
        listOfProducts.add(new Product("Power Bank", "Anker", 49.99, 30));

        listOfProducts.stream()
                .map(Product::getBrand)
                .forEach(System.out::println);

        listOfProducts.stream()
                .filter(product -> product.getPrice() < 1000)
                .limit(2)
                .forEach(System.out::println);

        int totalCountInWarehouse = listOfProducts.stream()
                .map(Product::getCount)
                .reduce(Integer::sum)
                .orElse(0);

        System.out.println("Total product count in warehouse: " + totalCountInWarehouse);

        listOfProducts.stream()
                .collect(Collectors.groupingBy(Product::getBrand))
                .forEach((brand, products) -> {
                    System.out.println("Brand: " + brand);
                    products.forEach(System.out::println);
                });

        System.out.println("\nSorted by price!");

        listOfProducts.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .forEach(System.out::println);
    }

}
