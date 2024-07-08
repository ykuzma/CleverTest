package main.java.ru.clevertec.check.models;

import java.util.Objects;

public class DiscountCard {
    private final long id;
    private final int number;
    private int discount_amount;

    public DiscountCard(long id, int number) {
        this.id = id;
        this.number = number;
    }


    public long getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public int getDiscount_amount() {
        return discount_amount;
    }

    public void setDiscount_amount(int discount_amount) {
        this.discount_amount = discount_amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscountCard that = (DiscountCard) o;
        return id == that.id && number == that.number && discount_amount == that.discount_amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, discount_amount);
    }

    @Override
    public String toString() {
        return "DiscountCard{" +
                "id=" + id +
                ", number=" + number +
                ", discount_amount=" + discount_amount +
                '}';
    }
}
