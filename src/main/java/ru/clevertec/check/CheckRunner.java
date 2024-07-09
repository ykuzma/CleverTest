package main.java.ru.clevertec.check;

import main.java.ru.clevertec.check.dao.DiscountCardFile;
import main.java.ru.clevertec.check.dao.ProductDaoFile;
import main.java.ru.clevertec.check.models.OrderData;
import main.java.ru.clevertec.check.models.ResultOrder;
import main.java.ru.clevertec.check.services.*;

import java.io.FileNotFoundException;

public class CheckRunner {
    public static void main(String[] args) throws FileNotFoundException {


        ArgParser<OrderData> argParser = new ArgsHandler();
        OrderData orderData = argParser.parse(args);
        OrderLineService orderLineService = new OrderLineService(new ProductService(new ProductDaoFile()));
        DiscountCardService discountCardService = new DiscountCardService(new DiscountCardFile());
        ResultOrderService orderService = new ResultOrderService(orderLineService, discountCardService);
        ResultOrder resultOrder = orderService.getResult(orderData);
        System.out.println(resultOrder.toString());

    }


}
