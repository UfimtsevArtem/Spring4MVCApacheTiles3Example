package com.websystique.springmvc.dao;


import com.websystique.springmvc.domain.User;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by ufimtsev on 29.08.2017.
 */
public interface UserDao {
    void addUser(User user) throws SQLException;
    void updateUser(Long user_id, User user) throws SQLException;
    void deleteUser(User user) throws SQLException;
    User getUserById(Long user_id) throws SQLException;
    Collection getAllUsers() throws SQLException;
}