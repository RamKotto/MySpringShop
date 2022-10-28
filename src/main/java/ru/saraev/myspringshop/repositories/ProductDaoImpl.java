package ru.saraev.myspringshop.repositories;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.saraev.myspringshop.dao.Product;
import ru.saraev.myspringshop.dao.ProductDao;
import ru.saraev.myspringshop.dao.User;
import ru.saraev.myspringshop.utils.SessionFactoryUtils;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    private SessionFactoryUtils sessionFactoryUtils;

    public ProductDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Product findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public List<Product> findAll() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("select p from Product p").getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public Product findByTitle(String login) {
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void update(Long id, String title) {

    }

    @Override
    public List<User> getAllUsersByProductId(Long product_id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, product_id);
            System.out.println(product);
            System.out.println("Users: ");
            for (User u : product.getUsers()) {
                System.out.println(u.getLogin());
            }
            session.getTransaction().commit();
            return product.getUsers();
        }
    }


    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
        ProductDaoImpl productDao = new ProductDaoImpl(sessionFactoryUtils);
        System.out.println(productDao.findById(1l));

        System.out.println(productDao.findAll());
        System.out.println(productDao.getAllUsersByProductId(3l));
    }
}
