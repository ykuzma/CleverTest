package main.java.ru.clevertec.check.services;

import main.java.ru.clevertec.check.models.OrderData;
import main.java.ru.clevertec.check.models.ResultOrder;

public class ResultOrderService {
    private final OrderLineService orderLine;
    private final DiscountCardService discountCardService;

    public ResultOrderService(OrderLineService orderLine, DiscountCardService discountCardService) {
        this.orderLine = orderLine;
        this.discountCardService = discountCardService;
    }

    public ResultOrder getResult(OrderData orderData) {

        return null;
    }
}
