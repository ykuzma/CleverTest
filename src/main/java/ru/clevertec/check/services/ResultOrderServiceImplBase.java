package main.java.ru.clevertec.check.services;

import main.java.ru.clevertec.check.configuration.Logger;
import main.java.ru.clevertec.check.exception.NotEnoughMoneyException;
import main.java.ru.clevertec.check.models.*;

import java.util.List;

public class ResultOrderServiceImplBase implements ResultOrderService{
    protected final OrderLineService orderLine;


    public ResultOrderServiceImplBase(OrderLineService orderLine) {
        this.orderLine = orderLine;
    }
    @Override
    public ResultOrder getResult(OrderData orderData) {
        List<OrderLine> lineList =  orderLine.createOrderLines(orderData.getProduct(),
                0);

        if(checkCardAmount(orderData.getDebitCardAmount(), lineList.stream()
                .mapToDouble(OrderLine::getTotalWithDiscount).sum())) {
            Logger.error("Not enough money");
            throw new NotEnoughMoneyException("Not enough money");
        }

        return new ResultOrderBuilder()
                .setLine(lineList)
                .build();

    }
    protected boolean checkCardAmount (double amount, double totalPrice) {

        return Double.compare(amount, totalPrice) < 0;
    }

}
