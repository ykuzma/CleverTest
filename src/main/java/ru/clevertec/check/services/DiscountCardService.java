package main.java.ru.clevertec.check.services;

import main.java.ru.clevertec.check.dao.DiscountCardDao;
import main.java.ru.clevertec.check.models.DiscountCard;

public class DiscountCardService {
    private final DiscountCardDao discountCardDao;

    public DiscountCardService(DiscountCardDao discountCardDao) {
        this.discountCardDao = discountCardDao;
    }


}
