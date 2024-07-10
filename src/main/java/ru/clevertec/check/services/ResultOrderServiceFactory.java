package main.java.ru.clevertec.check.services;

import main.java.ru.clevertec.check.dao.DiscountCardFile;
import main.java.ru.clevertec.check.dao.ProductDaoFile;
import main.java.ru.clevertec.check.models.OrderData;

public class ResultOrderServiceFactory {

    public static ResultOrderService getService (OrderData orderData) {
        OrderLineService orderLineService= new OrderLineServiceImpl(new ProductServiceImpl(new ProductDaoFile()));

        if(orderData.getDiscountNumber() == null) {
            return new ResultOrderServiceImplBase (orderLineService);

        }else {
            return new ResultOrderServiceDiscountImpl(orderLineService,
                    new DiscountCardServiceImpl(new DiscountCardFile()));
        }
    }
}
