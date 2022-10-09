package ru.saraev.myspringshop.repositories;

import org.springframework.stereotype.Repository;
import ru.saraev.myspringshop.dto.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> products;

    @PostConstruct
    public void init() {
        this.products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Milk",10L),
                new Product(2L, "Potato",16L),
                new Product(3L, "Cheese",28L),
                new Product(4L, "Onion",5L),
                new Product(5L, "Apple",12L)
        ));
    }

    public Product getById(Long id){
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }

    public List<Product> getAll(){
        return products;
    }

    public void add(Long id, String name, Long price) {
        products.add(new Product(id, name, price));
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
