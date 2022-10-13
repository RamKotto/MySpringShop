package ru.saraev.myspringshop.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.saraev.myspringshop.dto.Product;
import ru.saraev.myspringshop.repositories.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public Product getProduct(Long id){
        return repository.getProductById(id);
    }

    public List<Product> getProducts() {
        return repository.getAllProducts();
    }
}
