package main.java.ru.clevertec.check.models;

import java.util.HashMap;
import java.util.Map;

public class OrderDataBuilder {

    private Map<Long, Integer> product;
    private  Integer discountCardNumber;
    private  double debitCardAmount;


    public OrderDataBuilder setProduct(Long id, int quantity) {
        if(product == null) product = new HashMap<>();

        if(product.containsKey(id)) {
            product.put(id, product.get(id) + quantity);
        }else {
            product.put(id, quantity);
        }
        return this;
    }

    public OrderDataBuilder setDiscountCardNumber(int discountCardNumber) {

        this.discountCardNumber = discountCardNumber;
        return this;
    }

    public OrderDataBuilder setDebitCardAmount(double amount) {
        debitCardAmount = amount;
        return this;
    }

    public OrderData build() {

        return new OrderData(product, debitCardAmount, discountCardNumber);
    }
}
