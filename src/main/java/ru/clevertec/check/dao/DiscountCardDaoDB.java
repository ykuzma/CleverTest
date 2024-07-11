package main.java.ru.clevertec.check.dao;

import main.java.ru.clevertec.check.exception.ApplicationException;
import main.java.ru.clevertec.check.models.DiscountCard;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class DiscountCardDaoDB implements DiscountCardDao{
    private Executor executor;

    public DiscountCardDaoDB(Connection connection) {
        executor = new Executor(connection);
    }
    @Override
    public Optional<DiscountCard> findByNumber(int number) {

        try {
            return executor.execQuery("select * from discount_card where number=" + number, result -> {
                DiscountCard discountCard;
                if (result.next()) {
                    discountCard = new DiscountCard();
                    discountCard.setId(result.getLong(1));
                    discountCard.setNumber(result.getInt(2));
                    discountCard.setDiscount_amount(result.getInt(3));
                }else {
                    discountCard = null;
                }
                return Optional.ofNullable(discountCard);

            });
        } catch (SQLException e) {
            throw new ApplicationException();
        }
    }
}
