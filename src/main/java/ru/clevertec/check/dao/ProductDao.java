package main.java.ru.clevertec.check.dao;

import main.java.ru.clevertec.check.models.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface ProductDao {
    Product findProductById(Long id) throws SQLException;
    List<Product> findProducts (Set<Long> setID) throws SQLException;
}
