package ru.saraev.myspringshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.saraev.myspringshop.dto.Product;
import ru.saraev.myspringshop.services.ProductService;

import java.util.List;

@RestController
public class ProductController {

    private ProductService service;

    @Autowired
    public void setService(ProductService service) {
        this.service = service;
    }

    @GetMapping("/product/all")
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("/product/change_price")
    public void changePrice(@RequestParam Long productId, @RequestParam Long price){
        service.changePrice(productId, price);
    }

    @PostMapping("/product/add")
    public void addNewProduct(@RequestBody Product product){
        service.addNewProduct(product);
    }
}
