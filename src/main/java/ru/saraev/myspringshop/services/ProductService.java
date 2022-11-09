package ru.saraev.myspringshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.saraev.myspringshop.dto.Product;
import ru.saraev.myspringshop.repositories.ProductRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository repository;

    @Autowired
    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }

    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public void createNewProduct(Product product) {
        try {
            findByTitle(product.getTitle());
        } catch (NoSuchElementException ex) {
            repository.save(product);
        }
    }

    public Product findByTitle(String title) {
        return repository.findProductByTitle(title).orElseThrow();
    }

    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }

    public List<Product> findByPrice(Integer min, Integer max) {
        return repository.findAllByPriceBetween(min, max);
    }

    @Transactional
    public void changePrice(Long productId, Integer price) {
        Product product = repository.getById(productId);
        product.setPrice(price);
    }
}
