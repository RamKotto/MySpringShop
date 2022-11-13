package ru.saraev.myspringshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.saraev.myspringshop.dto.Product;
import ru.saraev.myspringshop.exceptions.ResourceNotFountException;
import ru.saraev.myspringshop.services.ProductService;

import java.util.List;

@RestController
public class ProductController {

    private ProductService service;

    @Autowired
    public void setService(ProductService service) {
        this.service = service;
    }

    @GetMapping("/products/{id}")
    public Product findProductById(@PathVariable Long id) {
        return service.findById(id).orElseThrow(() -> new ResourceNotFountException(
                "Product with id: " + id + " is not found =("
        ));
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @PostMapping("/products")
    public void addNewProduct(@RequestBody Product product) {
        service.createNewProduct(product);
    }

    @GetMapping("/products/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteProduct(id);
    }

    @GetMapping("/products/price_between")
    public List<Product> findByPriceBetween(@RequestParam(defaultValue = "0") Integer min,
                                            @RequestParam(defaultValue = "1000") Integer max) {
        return service.findByPrice(min, max);
    }

    @GetMapping("/products/change_price")
    public void changeProductPrice(@RequestParam(name = "id") Long productId, @RequestParam Integer price) {
        service.changePrice(productId, price);
    }
}
