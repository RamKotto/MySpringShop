package ru.saraev.myspringshop.repositories;

import org.springframework.stereotype.Repository;
import ru.saraev.myspringshop.dto.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository {

    List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Milk", 100L),
                new Product(2L, "Potato", 23L),
                new Product(3L, "Cheese", 137L)
        ));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }
}
