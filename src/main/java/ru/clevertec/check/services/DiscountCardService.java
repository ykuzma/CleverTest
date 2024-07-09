package main.java.ru.clevertec.check.services;

import main.java.ru.clevertec.check.dao.DiscountCardDao;
import main.java.ru.clevertec.check.models.DiscountCard;

import java.util.Optional;

public class DiscountCardService {
    private final DiscountCardDao discountCardDao;

    public DiscountCardService(DiscountCardDao discountCardDao) {
        this.discountCardDao = discountCardDao;
    }

    public DiscountCard findDiscount(int number) {
        Optional<DiscountCard> discountCard = discountCardDao.findByNumber(number);
        return discountCard.orElseGet(() -> new DiscountCard(number));

    }


}
