package com.education.ztu.Task5;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> products;
    private LocalDateTime orderTime;

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product){
        this.products.add(product);
    }

    public Order(){
        this.orderTime = LocalDateTime.now();
        this.products = new ArrayList<>();
    }
    public double getTotalPrice(){
        double sum = 0;
        for(Product product : products){
            sum += product.getPrice();
        }

        return sum;
    }
}
