package ru.saraev.myspringshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.saraev.myspringshop.dto.Product;
import ru.saraev.myspringshop.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository repository;

    @Autowired
    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProducts() {
        return repository.getAll();
    }

    public void addNewProduct(Long id, String name, Long price) {
        repository.add(id, name, price);
    }

    public void addNewProduct(Product product) {
        repository.addProduct(product);
    }

    public void changePrice(Long id, Long price) {
        Product product = repository.getById(id);
        product.setPrice(product.getPrice() + price);
    }
}
