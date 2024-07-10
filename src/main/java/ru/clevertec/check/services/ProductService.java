package main.java.ru.clevertec.check.services;

import main.java.ru.clevertec.check.models.Product;

import java.util.List;
import java.util.Set;

public interface ProductService {
    List<Product> findProducts(Set<Long> productID);
}
