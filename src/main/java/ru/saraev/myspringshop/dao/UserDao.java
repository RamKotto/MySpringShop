package ru.saraev.myspringshop.dao;

import java.util.List;

public interface UserDao {

    User findById(Long id);

    List<User> findAll();

    User findByLogin(String login);

    void save(User user);

    void update(Long id, String login);

    List<Product> getAllUserProductsById(Long id);
}
