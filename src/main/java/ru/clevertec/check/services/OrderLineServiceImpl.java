package main.java.ru.clevertec.check.services;

import main.java.ru.clevertec.check.configuration.ConfigurationApp;
import main.java.ru.clevertec.check.models.OrderLine;
import main.java.ru.clevertec.check.models.Product;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderLineServiceImpl implements OrderLineService {
    private final ProductService productService;

    public OrderLineServiceImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public List<OrderLine> createOrderLines(Map<Long,
            Integer> productIdAndQuantity, int discount)  {
        List<Product> products = productService.findProducts(productIdAndQuantity.keySet());

        return products.stream()
                .map(p -> createOrderLine(p, discount, productIdAndQuantity.get(p.getId())))
                .collect(Collectors.toList());
    }


    public OrderLine createOrderLine(Product product, int discountAmount, int productQuantity) {
        double wholesaleDiscount = ConfigurationApp.getWholesale();
        double totalPrice = product.getPrice() * productQuantity;
        double discount;
        if(product.isWholesale() && productQuantity > 4) {
            discount = totalPrice * wholesaleDiscount / 100;
        }else {
            discount = totalPrice * (discountAmount / 100.0);
        }
        return new OrderLine(productQuantity, product.getDescription(),
                product.getPrice(), totalPrice, discount);
    }
}