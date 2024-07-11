package main.java.ru.clevertec.check.dao;

import main.java.ru.clevertec.check.exception.ApplicationException;
import main.java.ru.clevertec.check.models.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductDaoDB implements ProductDao{
    private Executor executor;

    public ProductDaoDB(Connection connection) {
        executor = new Executor(connection);
    }


    @Override
    public Product findProductById(Long id) {
        try {
            return executor.execQuery("select * from product where id=" + id, result -> {
                result.next();
                Product product = new Product();
                product.setId(result.getLong(1));
                product.setDescription(result.getString(2));
                product.setPrice(result.getDouble(3));
                product.setQuantity(result.getInt(4));
                product.setWholesale(result.getBoolean(5));
                return product;
            });
        } catch (SQLException e) {
            throw new ApplicationException();
        }
    }

    @Override
    public List<Product> findProducts(Set<Long> setID) {

        return setID.stream().map(this::findProductById).collect(Collectors.toList());

    }
}
