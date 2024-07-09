package main.java.ru.clevertec.check.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

public class ResultOrderWithDiscount extends ResultOrder{

    private final DiscountCard discountCard;

    public ResultOrderWithDiscount(LocalDate date, LocalTime time, List<OrderLine> line,
                                   TotalLine totalLine, DiscountCard discountCard) {
        super(date, time, line, totalLine);
        this.discountCard = discountCard;
    }

    public DiscountCard getDiscountCard() {
        return discountCard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ResultOrderWithDiscount that = (ResultOrderWithDiscount) o;
        return Objects.equals(discountCard, that.discountCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discountCard);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "ResultOrderWithDiscount{" +
                "discountCard=" + discountCard +
                '}';
    }
}
