package com.education.ztu.Task4;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class OrderFormatter {
    private int numerationWidth = 5;
    private int nameWidth = 20;
    private int categoryWidth = 20;
    private int priceWidth = 10;

    public int getNumerationWidth() {
        return numerationWidth;
    }

    public OrderFormatter setNumerationWidth(int numerationWidth) {
        this.numerationWidth = numerationWidth;
        return this;
    }

    public int getNameWidth() {
        return nameWidth;
    }

    public OrderFormatter setNameWidth(int nameWidth) {
        this.nameWidth = nameWidth;
        return this;
    }

    public int getCategoryWidth() {
        return categoryWidth;
    }

    public OrderFormatter setCategoryWidth(int categoryWidth) {
        this.categoryWidth = categoryWidth;
        return this;
    }

    public int getPriceWidth() {
        return priceWidth;
    }

    public OrderFormatter setPriceWidth(int priceWidth) {
        this.priceWidth = priceWidth;
        return this;
    }

    public String formatOrder(Order order){
        StringBuilder sb = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        int orderDateWidth = 19;

        int width = numerationWidth + nameWidth + categoryWidth + priceWidth + 3;

        String headerFormat = "%-" + (width - orderDateWidth-1) + "s %-" + orderDateWidth + "s";

        // Header with date and order time
        sb.append(
                String.format(headerFormat, "Дата та час покупки:", order.getOrderTime().format(formatter)))
                .append("\n")
                .append("=".repeat(width))
                .append("\n");

        String tableRowFormat = "%-" + numerationWidth + "s %-" + nameWidth+"s %-" + categoryWidth + "s %-" + priceWidth + "s\n";
        // Table header
        sb.append(String.format(tableRowFormat, "№", "Товар", "Категорія", "Ціна"));
        sb.append("=".repeat(width))
                .append("\n");

        // Table rows
        List<Product> products = order.getProducts();
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            sb.append(String.format(tableRowFormat,
                    i + 1,
                    product.getName(),
                    product.getCategory(),
                    String.format("%.2f ₴", product.getPrice())));
        }

        String footerFormat = "%-" + (width-priceWidth-1) + "s %-"+priceWidth + "s\n";

        // Footer
        sb.append("=".repeat(width))
                .append("\n")
                .append(String.format(footerFormat,
                        "Разом:",
                        String.format("%.2f ₴", order.getTotalPrice())));

        return sb.toString();
    }
}
