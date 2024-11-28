package com.education.ztu;

import java.util.ArrayDeque;

public class Task4 {
    public static void main(String[] args) {
        // Creating a queue using ArrayDeque
        ArrayDeque<Product> productQueue = new ArrayDeque<>();

        // Adding elements using push (adds to the front of the deque)
        productQueue.push(new Product("Laptop", 1500.0));
        productQueue.push(new Product("Phone", 800.0));
        productQueue.push(new Product("Tablet", 600.0));

        System.out.println("Queue after push operations:");
        for (Product product : productQueue) {
            System.out.println(product.getName() + " - " + product.getPrice());
        }

        // Adding elements using offerLast (adds to the end of the deque)
        productQueue.offerLast(new Product("Monitor", 300.0));
        productQueue.offerLast(new Product("Keyboard", 50.0));

        System.out.println("\nQueue after offerLast operations:");
        for (Product product : productQueue) {
            System.out.println(product.getName() + " - " + product.getPrice());
        }

        // Retrieving the first and last elements without removing them
        System.out.println("\nFirst element (getFirst): " + productQueue.getFirst().getName());
        System.out.println("Last element (peekLast): " + productQueue.peekLast().getName());

        // Removing elements
        Product removedFirst = productQueue.pop(); // Removes the first element
        System.out.println("\nRemoved first element (pop): " + removedFirst.getName());

        Product removedLast = productQueue.pollLast(); // Removes the last element
        System.out.println("Removed last element (pollLast): " + removedLast.getName());

        System.out.println("\nQueue after removing elements:");
        for (Product product : productQueue) {
            System.out.println(product.getName() + " - " + product.getPrice());
        }

        // Using removeLast (throws an exception if the queue is empty)
        productQueue.removeLast();
        System.out.println("\nQueue after removeLast:");
        for (Product product : productQueue) {
            System.out.println(product.getName() + " - " + product.getPrice());
        }
    }
}
