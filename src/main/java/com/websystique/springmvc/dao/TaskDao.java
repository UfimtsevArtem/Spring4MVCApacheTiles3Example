package com.websystique.springmvc.dao;



import com.websystique.springmvc.domain.Task;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by ufimtsev on 29.08.2017.
 */
public interface TaskDao {
    void addTask(Task task) throws SQLException;
    void deleteTask(Task task) throws SQLException;
    void saveOrUpdateTask(Task task) throws SQLException;
    Collection getAllTasks() throws SQLException;
    Query createQuery(String hql);
}
