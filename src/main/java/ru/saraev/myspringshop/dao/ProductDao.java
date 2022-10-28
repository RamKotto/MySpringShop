package ru.saraev.myspringshop.dao;

import java.util.List;

public interface ProductDao {

    Product findById(Long id);

    List<Product> findAll();

    Product findByTitle(String login);

    void save(User user);

    void update(Long id, String title);

    List<User> getAllUsersByProductId(Long id);
}
