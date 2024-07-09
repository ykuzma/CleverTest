package main.java.ru.clevertec.check.services;

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
        List<OrderLine> lineList = orderLine.createOrderLines(orderData.getProduct(),
                discountCard.getDiscount_amount());

        return new ResultOrderWithDiscountBuilder()
                .setLine(lineList)
                .setDiscountCard(discountCard)
                .build();

    }
}
