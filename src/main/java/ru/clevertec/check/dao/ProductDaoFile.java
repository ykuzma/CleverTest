package main.java.ru.clevertec.check.dao;

import main.java.ru.clevertec.check.configuration.ConfigurationApp;
import main.java.ru.clevertec.check.configuration.Logger;
import main.java.ru.clevertec.check.exception.ApplicationException;
import main.java.ru.clevertec.check.exception.BadParametersException;
import main.java.ru.clevertec.check.models.Product;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductDaoFile implements ProductDao{

    private final ConfigurationApp config = ConfigurationApp.getInstance();

    @Override
    public List<Product> findProducts(Set<Long> setID) {
        return setID.stream().map(this::findProductById).collect(Collectors.toList());
    }

    private long findIdInLine(String line){
        String[]tempArr =  line.split(config.getDelimiter());
        return Long.parseLong(tempArr[0]);
    }

    private Product createProduct(String line) {
        String[]tempArr =  line.split(config.getDelimiter());
        boolean wholesale = tempArr[4].equals("+");
        Product product = new Product();
        product.setId(Long.parseLong(tempArr[0]));
        product.setDescription(tempArr[1]);
        product.setPrice(Double.parseDouble(tempArr[2]));
        product.setQuantity(Integer.parseInt(tempArr[3]));
        product.setWholesale(wholesale);
        return product;
    }

    @Override
    public Product findProductById(Long id){
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(config.getPathProduct())))) {

            Optional<Product> product = br.lines().skip(1)
                    .filter(line -> findIdInLine(line) == id)
                    .map(this::createProduct)
                    .findAny();

            return product.orElseThrow(() -> new BadParametersException("BAD REQUEST"));
        }catch (IOException e) {
            Logger.error(String.format("IOException - class = %s", e.getClass().getSimpleName()));
            throw new ApplicationException();
        }

    }

}
