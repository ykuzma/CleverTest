package main.java.ru.clevertec.check.services;

import main.java.ru.clevertec.check.dao.DiscountCardDao;
import main.java.ru.clevertec.check.exception.ApplicationException;
import main.java.ru.clevertec.check.models.DiscountCard;

import java.util.Optional;

public class DiscountCardServiceImpl implements DiscountCardService {
    private final DiscountCardDao discountCardDao;

    public DiscountCardServiceImpl(DiscountCardDao discountCardDao) {
        this.discountCardDao = discountCardDao;
    }

    public DiscountCard findDiscount(int number) {
        try {
            Optional<DiscountCard> discountCard = discountCardDao.findByNumber(number);
            return discountCard.orElseGet(() -> new DiscountCard(number));
        } catch (Exception e) {
            throw new ApplicationException();
        }

    }


}
