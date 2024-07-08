package main.java.ru.clevertec.check.models;

import java.util.Objects;

public class OrderLine {
    private int qty;
    private String productDescription;
    private double price;
    private double totalPrice;
    private double discount;

    public OrderLine(int qty, String productDescription, double price, double totalPrice, double discount) {
        this.qty = qty;
        this.productDescription = productDescription;
        this.price = price;
        this.totalPrice = totalPrice;
        this.discount = discount;
    }

    public int getQty() {
        return qty;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public double getPrice() {
        return price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLine orderLine = (OrderLine) o;
        return qty == orderLine.qty && Double.compare(orderLine.price, price) == 0 && Double.compare(orderLine.totalPrice, totalPrice) == 0 && Double.compare(orderLine.discount, discount) == 0 && Objects.equals(productDescription, orderLine.productDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qty, productDescription, price, totalPrice, discount);
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "qty=" + qty +
                ", productDescription='" + productDescription + '\'' +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                ", discount=" + discount +
                '}';
    }
}
