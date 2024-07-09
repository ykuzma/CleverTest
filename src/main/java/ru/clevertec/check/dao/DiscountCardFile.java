package main.java.ru.clevertec.check.dao;

import main.java.ru.clevertec.check.configuration.ConfigurationApp;
import main.java.ru.clevertec.check.models.DiscountCard;

import java.io.*;
import java.util.Optional;
import java.util.stream.Collectors;

public class DiscountCardFile implements DiscountCardDao{
    ConfigurationApp config = ConfigurationApp.getInstance();
    @Override
    public Optional<DiscountCard> findByNumber(int number) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(config.getPathDiscountCard())))) {

            return br.lines()
                    .filter(line -> Integer.parseInt(line.split(config.getDelimiter())[1]) == number)
                    .map(this::createDiscount).findAny();
        }catch (IOException e) {
            throw new RuntimeException();
        }
    }
    private DiscountCard createDiscount(String line){
        String[] temp = line.split(config.getDelimiter());
        long id = Long.parseLong(temp[0]);
        int number = Integer.parseInt(temp[1]);
        int discount = Integer.parseInt(temp[2]);
        return new DiscountCard(id, number, discount);
    }

}