package main.java.ru.clevertec.check.dao;

import main.java.ru.clevertec.check.configuration.ConfigurationApp;
import main.java.ru.clevertec.check.exception.ApplicationException;
import main.java.ru.clevertec.check.models.Product;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductDaoFile implements ProductDao{

    private final ConfigurationApp config = ConfigurationApp.getInstance();
    private String[] tempArr;

    @Override
    public Set<Product> findProducts(Set<Long> setID) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(config.getPathProduct())))) {

            return br.lines().skip(1)
                    .filter(line -> setID.contains(findIdInLine(line)))
                    .map(this::createProduct)
                    .collect(Collectors.toSet());
        }catch (Exception e) {
            throw new ApplicationException();
        }
    }

    private Long findIdInLine(String line){
        tempArr =  line.split(config.getDelimiter());
        return Long.parseLong(tempArr[0]);
    }

    private Product createProduct(String line) {
        tempArr =  line.split(config.getDelimiter());
        boolean wholesale = tempArr[4].equals("+");
        Product product = new Product();
        product.setId(Long.parseLong(tempArr[0]));
        product.setDescription(tempArr[1]);
        product.setPrice(Double.parseDouble(tempArr[2]));
        product.setQuantity(Integer.parseInt(tempArr[3]));
        product.setWholesale(wholesale);
        return product;
    }

    public Product findProductById(Long id){
        return null;
    }

}
