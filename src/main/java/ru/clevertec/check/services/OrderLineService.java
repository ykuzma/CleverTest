package main.java.ru.clevertec.check.services;

import main.java.ru.clevertec.check.models.OrderLine;

import java.util.List;
import java.util.Map;

public interface OrderLineService {
    List<OrderLine> createOrderLines(Map<Long, Integer> productIdAndQuantity, int discount);


}