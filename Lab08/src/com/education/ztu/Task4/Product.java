package com.education.ztu.Task4;

public class Product {
    private String name;
    private String brand;
    private double price;
    private int count;

    public Product(String name, String brand, double price, int count){
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.count = count;
    }

    @Override
    public String toString() {
        return String.format("%s %s with price: %.2f. Amount in warehouse: %d", name, brand, price, count);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
