package main.java.ru.clevertec.check.models;

import java.util.Map;
import java.util.Objects;

public class OrderData {
    private final Map<Long, Integer> product;
    private final double debitCardAmount;
    private final Integer discountNumber;

    public OrderData(Map<Long, Integer> product, double debitCardAmount, Integer discountNumber) {
        this.product = product;
        this.debitCardAmount = debitCardAmount;
        this.discountNumber = discountNumber;
    }

    public Map<Long, Integer> getProduct() {
        return product;
    }

    public double getDebitCardAmount() {
        return debitCardAmount;
    }

    public Integer getDiscountNumber() {
        return discountNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderData orderData = (OrderData) o;
        return Double.compare(orderData.debitCardAmount, debitCardAmount) == 0 && Objects.equals(product, orderData.product) && Objects.equals(discountNumber, orderData.discountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, debitCardAmount, discountNumber);
    }

    @Override
    public String toString() {
        return "OrderData{" +
                "product=" + product +
                ", debitCardAmount=" + debitCardAmount +
                ", discountNumber=" + discountNumber +
                '}';
    }
}
