package main.java.ru.clevertec.check.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ResultOrderWithDiscountBuilder extends ResultOrderBuilder{
    private DiscountCard discountCard;

    @Override
    public ResultOrderWithDiscount build() {
        return new ResultOrderWithDiscount(LocalDate.now(), LocalTime.now(),
                getLines(),  createTotalLine(), getDiscountCard());
    }

    public ResultOrderWithDiscountBuilder setDiscountCard(DiscountCard discountCard) {
        this.discountCard = discountCard;
        return this;
    }

    @Override
    public ResultOrderWithDiscountBuilder setLine(List<OrderLine> lines) {
        super.setLine(lines);
        return this;
    }

    public DiscountCard getDiscountCard() {
        return discountCard;
    }
}
