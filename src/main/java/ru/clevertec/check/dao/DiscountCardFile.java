package main.java.ru.clevertec.check.dao;

import main.java.ru.clevertec.check.configuration.ConfigurationApp;
import main.java.ru.clevertec.check.exception.ApplicationException;
import main.java.ru.clevertec.check.models.DiscountCard;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

public class DiscountCardFile implements DiscountCardDao{
    ConfigurationApp config = ConfigurationApp.getInstance();
    @Override
    public Optional<DiscountCard> findByNumber(int number) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(config.getPathDiscountCard())))) {

            return br.lines().skip(1)
                    .filter(line -> findNumberInLine(line) == number)
                    .map(this::createDiscount).findAny();
        }catch (IOException e) {
            throw new ApplicationException();
        }
    }

    private Integer findNumberInLine(String line){
        String[] temp =  line.split(config.getDelimiter());
        return Integer.parseInt(temp[1]);
    }
    private DiscountCard createDiscount(String line){
        String[] temp = line.split(config.getDelimiter());
        long id = Long.parseLong(temp[0]);
        int number = Integer.parseInt(temp[1]);
        int discount = Integer.parseInt(temp[2]);
        return new DiscountCard(id, number, discount);
    }

}
