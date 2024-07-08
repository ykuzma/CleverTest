package main.java.ru.clevertec.check.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class ResultOrderWithDiscountBuilder extends ResultOrderBuilder{
    private DiscountCard discountCard;

    @Override
    public ResultOrderWithDiscount build() {
        return new ResultOrderWithDiscount(LocalDate.now(), LocalTime.now(),
                getLines(),  createTotalLine(), getDiscountCard());
    }

    public void setDiscountCard(DiscountCard discountCard) {
        this.discountCard = discountCard;
    }

    public DiscountCard getDiscountCard() {
        return discountCard;
    }
}
