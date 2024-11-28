package com.education.ztu;

import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        // Creating a dynamic array (ArrayList) of Product objects
        ArrayList<Product> productList = new ArrayList<>();

        // Adding elements to the list
        productList.add(new Product("Laptop", 1500.0));
        productList.add(new Product("Phone", 800.0));
        productList.add(new Product("Tablet", 600.0));

        // Adding all elements from another collection
        List<Product> newProducts = List.of(
                new Product("Monitor", 300.0),
                new Product("Keyboard", 50.0)
        );
        productList.addAll(newProducts);

        // Accessing elements
        System.out.println("First product: " + productList.get(0).getName());

        // Finding indices
        int index = productList.indexOf(new Product("Phone", 800.0));
        System.out.println("Index of Phone: " + index);

        // Iterating through elements using an iterator
        Iterator<Product> iterator = productList.iterator();
        System.out.println("Products using iterator:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getName());
        }

        // Iterating through elements using a listIterator
        ListIterator<Product> listIterator = productList.listIterator();
        System.out.println("Products using listIterator:");
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next().getName());
        }

        // Removing an element
        productList.remove(0); // Removes the first product
        System.out.println("After removing the first product:");

        // Setting a value
        productList.set(0, new Product("Smartphone", 900.0));
        System.out.println("After replacing the first product:");

        // Sorting
        productList.sort(Comparator.comparingDouble(Product::getPrice));
        System.out.println("Products sorted by price:");

        // Creating a subList
        List<Product> subList = productList.subList(0, 2);

        System.out.println("Sublist:");
        for (Product product : subList) {
            System.out.println(product.getName() + " - " + product.getPrice());
        }

        // Clearing the list
        productList.clear();
        System.out.println("List cleared. Is empty? " + productList.isEmpty());

        // Checking for containment
        boolean contains = productList.contains(new Product("Laptop", 1500.0));
        System.out.println("Does the list contain Laptop? " + contains);

        // Retaining only specified elements
        productList.addAll(newProducts); // Add products back
        productList.retainAll(List.of(new Product("Monitor", 300.0)));
        System.out.println("After retainAll:");
        for (Product product : productList) {
            System.out.println(product.getName());
        }

        // Getting the size of the list
        System.out.println("Size of the list: " + productList.size());

        // Converting to an array
        Object[] productArray = productList.toArray();
        System.out.println("Array of products:");
        for (Object obj : productArray) {
            Product product = (Product) obj;
            System.out.println(product.getName() + " - " + product.getPrice());
        }
    }
}
