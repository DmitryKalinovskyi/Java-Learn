package com.education.ztu.Task4;

@Model(tableName = "_product")
public class ProductModel extends BasicModel{
    public String name;
    public double price;

    public ProductModel(String name, double price){
        this.name = name;
        this.price = price;
    }
}
