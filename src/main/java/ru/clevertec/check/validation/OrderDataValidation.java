package main.java.ru.clevertec.check.validation;

import main.java.ru.clevertec.check.models.OrderData;
import main.java.ru.clevertec.check.services.ValidationService;

public class OrderDataValidation implements ValidationService<OrderData> {
    @Override
    public boolean validate(OrderData obj) {
        return true;
    }

    private boolean validId(long id) {
        return true;
    }

    private boolean validQuantity(int quantity){
        return true;
    }

    private boolean validAmount(double amount){
        return true;
    }

    private boolean validDiscountNumber(int number) {
        return true;
    }
}
