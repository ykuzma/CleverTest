package main.java.ru.clevertec.check.services;

import main.java.ru.clevertec.check.dao.ProductDao;
import main.java.ru.clevertec.check.models.Product;

import java.util.List;
import java.util.Set;

public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> findProducts(Set<Long> productID) {
        return productDao.findProducts(productID);

    }
}