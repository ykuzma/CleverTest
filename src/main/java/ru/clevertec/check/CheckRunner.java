package main.java.ru.clevertec.check;

import main.java.ru.clevertec.check.models.OrderData;
import main.java.ru.clevertec.check.models.ResultOrder;
import main.java.ru.clevertec.check.services.ArgParser;
import main.java.ru.clevertec.check.services.ArgsHandler;
import main.java.ru.clevertec.check.services.OrderLineService;
import main.java.ru.clevertec.check.services.ResultOrderService;

public class CheckRunner {
    public static void main(String[] args) {


        ArgParser<OrderData> argParser = new ArgsHandler();
        OrderData orderData = argParser.parse(args);
        ResultOrderService orderService = new ResultOrderService();
        ResultOrder resultOrder = orderService.getResult(orderData);

    }


}
