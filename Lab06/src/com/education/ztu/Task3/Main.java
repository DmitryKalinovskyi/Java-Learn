package com.education.ztu.Task3;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class Main {
    public static void main(String[] args){
        Order order = new Order();
        order.addProduct(new Product("Джинси", "Жіночий одяг", 1500.78));
        order.addProduct(new Product("Спідниця", "Жіночий одяг", 1000.56));
        order.addProduct(new Product("Краватка", "Чоловічий одяг", 500.78));
        order.addProduct(new Product("Футболка", "Чоловічий одяг", 700.50));
        order.addProduct(new Product("Шкарпетки", "Чоловічий одяг", 150.25));
        order.addProduct(new Product("Сукня", "Жіночий одяг", 2500.00));
        order.addProduct(new Product("Шарф", "Унісекс одяг", 450.30));
        order.addProduct(new Product("Пальто", "Жіночий одяг", 3500.99));
        order.addProduct(new Product("Черевики", "Чоловічий одяг", 2800.75));
        order.addProduct(new Product("Сумка", "Аксесуари", 1200.00));

        OrderFormatter formatter = new OrderFormatter()
                .setNumerationWidth(4)
                .setNameWidth(20)
                .setCategoryWidth(20)
                .setPriceWidth(12)
                .withLocale(Locale.of("uk", "UA"));
        System.out.println(formatter.formatOrder(order));

        try {
            FileWriter fileWriter = new FileWriter("directory_for_files/order.txt");
            fileWriter.write(formatter.formatOrder(order));
            fileWriter.close();
        }catch (IOException e){
            System.out.println("Can't save order: " + e.getMessage());
        }

        try {
            FileReader fileReader = new FileReader("directory_for_files/order.txt");
            System.out.println(fileReader.read());
            fileReader.close();
        }catch (IOException e){
            System.out.println("Can't open order: " + e.getMessage());
        }
    }
}