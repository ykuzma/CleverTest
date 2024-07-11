package main.java.ru.clevertec.check.services;

import main.java.ru.clevertec.check.configuration.ConfigurationApp;
import main.java.ru.clevertec.check.dao.DiscountCardDaoDB;
import main.java.ru.clevertec.check.dao.ProductDaoDB;
import main.java.ru.clevertec.check.exception.ApplicationException;
import main.java.ru.clevertec.check.models.OrderData;

public class ResultOrderServiceFactory {

    public static ResultOrderService getService (OrderData orderData) {
        try {
            OrderLineService orderLineService= new OrderLineServiceImpl(
                    new ProductServiceImpl(new ProductDaoDB(
                            ConfigurationApp.getInstance().getConnection())));

            if(orderData.getDiscountNumber() == null) {
                return new ResultOrderServiceImplBase (orderLineService);

            }else {
                return new ResultOrderServiceDiscountImpl(orderLineService,
                        new DiscountCardServiceImpl(new DiscountCardDaoDB(
                                ConfigurationApp.getInstance().getConnection())));
            }
        } catch (Exception e) {
            throw new ApplicationException();
        }
    }
}
