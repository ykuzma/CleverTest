package main.java.ru.clevertec.check;

import main.java.ru.clevertec.check.dao.DiscountCardFile;
import main.java.ru.clevertec.check.dao.ProductDaoFile;
import main.java.ru.clevertec.check.exception.ApplicationException;
import main.java.ru.clevertec.check.exception.ExceptionHandler;
import main.java.ru.clevertec.check.models.OrderData;
import main.java.ru.clevertec.check.models.ResultHandler;
import main.java.ru.clevertec.check.models.ResultOrder;
import main.java.ru.clevertec.check.services.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class CheckRunner {
    public static void main(String[] args) throws FileNotFoundException {


        try {
            ArgParser<OrderData> argParser = new ArgsHandler();
            OrderData orderData = argParser.parse(args);

            OrderLineService orderLineService = new OrderLineService(new ProductService(new ProductDaoFile()));
            DiscountCardService discountCardService = new DiscountCardService(new DiscountCardFile());
            ResultOrderService orderService = new ResultOrderService(orderLineService, discountCardService);
            ResultOrder resultOrder = orderService.getResult(orderData);
            resultOrder.save(new FileOutputStream("result.csv"));
            resultOrder.print();
        } catch (ApplicationException e) {
            ResultHandler resultHandler = new ExceptionHandler(e.getMessage());
            resultHandler.save(new FileOutputStream("result.csv"));
            resultHandler.print();
        }


    }


}
