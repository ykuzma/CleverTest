package main.java.ru.clevertec.check.dao;

import main.java.ru.clevertec.check.models.Product;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

public interface ProductDao {
    Product findProductById(Long id);
    Set<Product> findProducts(Set<Long> setID) throws IOException;
}