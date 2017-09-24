package com.websystique.springmvc.service;


import com.websystique.springmvc.domain.Task;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by ufimtsev on 29.08.2017.
 */
public interface TaskService {
    Task addTask(Task task) throws SQLException;
    void saveOrUpdateTask(Task task) throws SQLException;
    Collection getAllTasks() throws SQLException;
    Task getTaskById(Long task_id) throws SQLException;
    void deleteTask(Task task) throws SQLException;
    void updateTaskWithParams(Task task) throws SQLException;
}
