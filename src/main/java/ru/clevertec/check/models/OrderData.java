package main.java.ru.clevertec.check.models;

import java.util.Map;
import java.util.Objects;

public class OrderData {
    private final Map<Long, Integer> product;
    private final double debitCardAmount;

    public OrderData(Map<Long, Integer> product, double debitCardAmount) {
        this.product = product;
        this.debitCardAmount = debitCardAmount;
    }

    public Map<Long, Integer> getProduct() {
        return product;
    }

    public double getDebitCardAmount() {
        return debitCardAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderData orderData = (OrderData) o;
        return Double.compare(orderData.debitCardAmount, debitCardAmount) == 0 && Objects.equals(product, orderData.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, debitCardAmount);
    }

    @Override
    public String toString() {
        return "OrderData{" +
                "product=" + product +
                ", debitCardAmount=" + debitCardAmount +
                '}';
    }
}
