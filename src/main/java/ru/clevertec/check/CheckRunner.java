package main.java.ru.clevertec.check;

import main.java.ru.clevertec.check.configuration.ConfigurationApp;
import main.java.ru.clevertec.check.configuration.Logger;
import main.java.ru.clevertec.check.exception.ApplicationException;
import main.java.ru.clevertec.check.exception.ExceptionHandler;
import main.java.ru.clevertec.check.models.OrderData;
import main.java.ru.clevertec.check.models.ResultHandler;
import main.java.ru.clevertec.check.services.ArgParser;
import main.java.ru.clevertec.check.services.ArgsHandler;
import main.java.ru.clevertec.check.services.ResultOrderService;
import main.java.ru.clevertec.check.services.ResultOrderServiceFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class CheckRunner {
    public static void main(String[] args) throws FileNotFoundException {
        Logger.info("Application start");
        ConfigurationApp config = ConfigurationApp.getInstance();

        try {
            ArgParser<OrderData> argParser = new ArgsHandler();
            OrderData orderData = argParser.parse(args);
            ResultOrderService orderService = ResultOrderServiceFactory.getService(orderData);
            Logger.info(String.format("ResultOrderService = %s", orderService.getClass().getSimpleName()));
            ResultHandler resultHandler = orderService.getResult(orderData);
            resultHandler.save(new FileOutputStream(config.getSaveTo()));
            resultHandler.print();
            Logger.info("Application finish");
        } catch (ApplicationException e) {
            ResultHandler resultHandler = new ExceptionHandler(e.getMessage());
            resultHandler.save(new FileOutputStream(config.getSaveTo()));
            resultHandler.print();
            e.printStackTrace();
        }


    }


}
