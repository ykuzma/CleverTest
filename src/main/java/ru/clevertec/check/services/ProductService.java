package main.java.ru.clevertec.check.services;

import main.java.ru.clevertec.check.dao.ProductDao;
import main.java.ru.clevertec.check.models.Product;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

public class ProductService {
    private final ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public Set<Product> findProducts(Set<Long> productID) {

        try {
            return productDao.findProducts(productID);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e.getCause());
        }
    }
}
