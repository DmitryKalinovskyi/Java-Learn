package com.education.ztu.Task3;

public class Product {
    public String brand;
    private double price;
    private String name;

    public Product(String name, double price, String brand){
        this.name = name;
        this.price = price;
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
