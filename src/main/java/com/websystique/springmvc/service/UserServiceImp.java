package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.UserDao;
import com.websystique.springmvc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by ufimtsev on 29.08.2017.
 */
@Service("userService")
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }
    @Transactional
    @Override
    public void addUser(User user) throws SQLException {
        userDao.addUser(user);
    }
    @Transactional
    @Override
    public void updateUser(Long user_id, User user) throws SQLException {
        userDao.updateUser(user_id, user);
    }
    @Transactional(readOnly = true)
    @Override
    public User getUserById(Long user_id) throws SQLException {
        return userDao.getUserById(user_id);
    }
    @Transactional
    @Override
    public User findByUserName(String userName) throws SQLException {
        return userDao.findByUserName(userName);
    }

    @Transactional(readOnly = true)
    @Override
    public Collection getAllUsers() throws SQLException {
        return userDao.getAllUsers();
    }
    @Transactional
    @Override
    public void deleteUser(User user) throws SQLException {
        userDao.deleteUser(user);
    }
}
