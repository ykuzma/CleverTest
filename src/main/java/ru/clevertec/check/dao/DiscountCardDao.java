package main.java.ru.clevertec.check.dao;

import main.java.ru.clevertec.check.models.DiscountCard;

import java.util.Optional;

public interface DiscountCardDao {

    Optional<DiscountCard> findByNumber(int number);
}
