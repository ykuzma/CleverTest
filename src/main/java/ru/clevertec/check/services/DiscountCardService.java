package main.java.ru.clevertec.check.services;

import main.java.ru.clevertec.check.models.DiscountCard;

public interface DiscountCardService {
    DiscountCard findDiscount(int number);
}
