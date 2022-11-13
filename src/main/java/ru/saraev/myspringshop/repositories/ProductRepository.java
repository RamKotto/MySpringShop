package ru.saraev.myspringshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.saraev.myspringshop.dto.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByPriceBetween(Integer min, Integer max);

    @Query("select p from Product p where p.price < 80")
    List<Product> findLowPriceProducts();

    @Query("select p from Product p where p.title = :title")
    Optional<Product> findProductByTitle(String title);

    boolean existsProductByTitle(String title);
}
