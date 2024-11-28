package com.education.ztu.Task3;

import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class OrderFormatter {
    private int numerationWidth = 5;
    private int nameWidth = 20;
    private int categoryWidth = 20;
    private int priceWidth = 10;

    private Locale locale;
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

    public OrderFormatter withLocale(Locale locale){
        this.locale = locale;
        return this;
    }

    public String formatOrder(Order order){
        if(locale == null){
            throw new RuntimeException("Locale is not specified.");
        }

        ResourceBundle bundle = ResourceBundle.getBundle("com.education.ztu.Task3.localization.order_format", locale);

        StringBuilder sb = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        int orderDateWidth = 19;

        int width = numerationWidth + nameWidth + categoryWidth + priceWidth + 3;

        String headerFormat = "%-" + (width - orderDateWidth-1) + "s %-" + orderDateWidth + "s";

        // Header with date and order time
        sb.append(
                        String.format(headerFormat, bundle.getString("date_and_order_time"), order.getOrderTime().format(formatter)))
                .append("\n")
                .append("=".repeat(width))
                .append("\n");

        String tableRowFormat = "%-" + numerationWidth + "s %-" + nameWidth+"s %-" + categoryWidth + "s %" + priceWidth + "s\n";
        // Table header
        sb.append(String.format(tableRowFormat, bundle.getString("order_number"), bundle.getString("product"), bundle.getString("category"), bundle.getString("price")));
        sb.append("=".repeat(width))
                .append("\n");

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        // Table rows
        List<Product> products = order.getProducts();
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            sb.append(String.format(tableRowFormat,
                    i + 1,
                    product.getName(),
                    product.getCategory(),
                    numberFormat.format(product.getPrice())));
        }

        String footerFormat = "%-" + (width-priceWidth-1) + "s %"+priceWidth + "s\n";

        // Footer
        sb.append("=".repeat(width))
                .append("\n")
                .append(String.format(footerFormat,
                        bundle.getString("total"),
                        numberFormat.format(order.getTotalPrice())));

        return sb.toString();
    }
}