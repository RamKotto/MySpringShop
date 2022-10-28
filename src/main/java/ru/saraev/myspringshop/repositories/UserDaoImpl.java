package ru.saraev.myspringshop.repositories;

import org.hibernate.Session;
import ru.saraev.myspringshop.dao.Product;
import ru.saraev.myspringshop.dao.User;
import ru.saraev.myspringshop.dao.UserDao;
import ru.saraev.myspringshop.utils.SessionFactoryUtils;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private SessionFactoryUtils sessionFactoryUtils;

    public UserDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public User findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.getTransaction().commit();
            return user;
        }
    }

    @Override
    public List<User> findAll() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<User> users = session.createQuery("select u from User u").getResultList();
            session.getTransaction().commit();
            return users;
        }
    }

    @Override
    public User findByLogin(String login) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<User> users = session.createQuery("select u from User u").getResultList();
            User user = users.stream().filter(p -> p.getLogin().equals(login)).findAny().orElseThrow();
            session.getTransaction().commit();
            return user;
        }
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void update(Long id, String login) {

    }

    @Override
    public List<Product> getAllUserProductsById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.getTransaction().commit();
            return user.getProducts();
        }
    }

    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
        UserDaoImpl userDao = new UserDaoImpl(sessionFactoryUtils);
        System.out.println(userDao.findById(1l));

        System.out.println(userDao.findAll());
        System.out.println(userDao.getAllUserProductsById(2l));
        System.out.println(userDao.findByLogin("Ram"));
    }
}
