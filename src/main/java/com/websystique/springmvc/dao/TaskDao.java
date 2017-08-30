package com.websystique.springmvc.dao;



import com.websystique.springmvc.domain.Task;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by ufimtsev on 29.08.2017.
 */
public interface TaskDao {
    void addTask(Task task) throws SQLException;
    void updateTask(Long task_id, Task task) throws SQLException;
    Task getTaskById(Long task_id) throws SQLException;
    Collection getAllTasks() throws SQLException;
    void deleteTask(Task task) throws SQLException;
}
