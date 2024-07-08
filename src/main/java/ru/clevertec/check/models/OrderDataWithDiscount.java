package main.java.ru.clevertec.check.models;

import java.util.Map;
import java.util.Objects;

public class OrderDataWithDiscount extends OrderData{

    private final int discountNumber;

    public OrderDataWithDiscount(Map<Long, Integer> product, double debitCardAmount, int discountNumber) {
        super(product, debitCardAmount);
        this.discountNumber = discountNumber;
    }

    public int getDiscountNumber() {
        return discountNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OrderDataWithDiscount that = (OrderDataWithDiscount) o;
        return discountNumber == that.discountNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discountNumber);
    }
}
