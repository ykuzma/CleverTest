package main.java.ru.clevertec.check.services;

import main.java.ru.clevertec.check.models.DiscountCard;
import main.java.ru.clevertec.check.models.OrderData;
import main.java.ru.clevertec.check.models.OrderLine;
import main.java.ru.clevertec.check.models.ResultOrder;

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
        DiscountCard discountCard = new DiscountCard(1, 5555);
        List<OrderLine> lineList = orderLine.createOrderLines(orderData.getProduct(), discountCard);

        return null;
    }
}
