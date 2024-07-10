package main.java.ru.clevertec.check.services;

import main.java.ru.clevertec.check.configuration.Logger;
import main.java.ru.clevertec.check.exception.NotEnoughMoneyException;
import main.java.ru.clevertec.check.models.*;

import java.io.FileNotFoundException;
import java.util.List;

public class ResultOrderService {
    private final OrderLineService orderLine;
    private final DiscountCardService discountCardService;

    public ResultOrderService(OrderLineService orderLine, DiscountCardService discountCardService) {
        this.orderLine = orderLine;
        this.discountCardService = discountCardService;
    }

    public ResultOrder getResult(OrderData orderData) throws FileNotFoundException {
        DiscountCard discountCard = discountCardService.findDiscount(orderData.getDiscountNumber());
        List<OrderLine> lineList =  orderLine.createOrderLines(orderData.getProduct(),
                discountCard.getDiscount_amount());

        if(checkCardAmount(orderData.getDebitCardAmount(), lineList.stream()
                .mapToDouble(OrderLine::getTotalWithDiscount).sum())) {
            Logger.error("Not enough money");
            throw new NotEnoughMoneyException("Not enough money");
        }

        return new ResultOrderWithDiscountBuilder()
                .setLine(lineList)
                .setDiscountCard(discountCard)
                .build();

    }
    private boolean checkCardAmount (double amount, double totalPrice) {

        return Double.compare(amount, totalPrice) < 0;
    }

}
