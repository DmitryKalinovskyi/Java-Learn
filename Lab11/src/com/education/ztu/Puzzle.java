package com.education.ztu;

public class Puzzle extends BaseModel{
    private String name;
    private String description;
    private int amount;
    private double price;
    private String brand;

    public Puzzle(int id, String name, String description, int amount, double price, String brand){
        super(id);
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.price = price;
        this.brand = brand;
    }

    public Puzzle(String name, String description, int amount, double price, String brand){
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.price = price;
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
