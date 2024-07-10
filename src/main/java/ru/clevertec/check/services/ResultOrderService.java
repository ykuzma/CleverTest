package main.java.ru.clevertec.check.services;

import main.java.ru.clevertec.check.models.OrderData;
import main.java.ru.clevertec.check.models.ResultHandler;

public interface ResultOrderService {

    ResultHandler getResult(OrderData orderData);
}
