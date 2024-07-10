package main.java.ru.clevertec.check.dao;

import main.java.ru.clevertec.check.models.Product;

import java.util.List;
import java.util.Set;

public interface ProductDao {
    Product findProductById(Long id);
    List<Product> findProducts(Set<Long> setID);
}
