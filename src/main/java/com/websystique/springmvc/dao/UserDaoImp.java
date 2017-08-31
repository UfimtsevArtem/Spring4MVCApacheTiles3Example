package com.websystique.springmvc.dao;

import com.websystique.springmvc.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by ufimtsev on 29.08.2017.
 */
@Repository
public class UserDaoImp implements UserDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) throws SQLException {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void updateUser(Long user_id, User user) throws SQLException {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public User getUserById(Long user_id) throws SQLException {
        User user = sessionFactory.getCurrentSession().load(User.class, user_id);
        user.getRole();
        return user;
    }

    @Override
    public Collection getAllUsers() throws SQLException {
        @SuppressWarnings("unchecked")
        TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public void deleteUser(User user) throws SQLException {
        sessionFactory.getCurrentSession().delete(user);
    }


}