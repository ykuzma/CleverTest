package main.java.ru.clevertec.check.services;

import main.java.ru.clevertec.check.configuration.Logger;
import main.java.ru.clevertec.check.exception.NotEnoughMoneyException;
import main.java.ru.clevertec.check.models.*;

import java.util.List;

public class ResultOrderServiceDiscountImpl extends ResultOrderServiceImplBase{
    private final DiscountCardService discountCardService;

    public ResultOrderServiceDiscountImpl(OrderLineServiceImpl orderLine, DiscountCardService discountCardService) {
        super(orderLine);
        this.discountCardService = discountCardService;
    }

    @Override
    public ResultOrder getResult(OrderData orderData) {
        DiscountCard discountCard = discountCardService.findDiscount(orderData.getDiscountNumber());
        List<OrderLine> lineList =  orderLine.createOrderLines(orderData.getProduct(),
                discountCard.getDiscount_amount());

        if(checkCardAmount(orderData.getDebitCardAmount(), lineList.stream()
                .mapToDouble(OrderLine::getTotalWithDiscount).sum())) {
            Logger.error("Not enough money");
            throw new NotEnoughMoneyException("Not enough money");
        }

        return new ResultOrderWithDiscount.Builder()
                .setLine(lineList)
                .setDiscountCard(discountCard)
                .build();

    }
}
