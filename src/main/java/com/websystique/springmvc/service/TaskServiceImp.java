package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.TaskDao;
import com.websystique.springmvc.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by ufimtsev on 29.08.2017.
 */
@Service
public class TaskServiceImp implements TaskService {

    private final TaskDao taskDao;

    @Autowired
    public TaskServiceImp(TaskDao taskDao) {
        this.taskDao = taskDao;
    }
    @Transactional
    @Override
    public void addTask(Task task) throws SQLException {
        taskDao.addTask(task);
    }
    @Transactional
    @Override
    public void updateTask(Long task_id, Task task) throws SQLException {
        taskDao.updateTask(task_id, task);
    }
    @Transactional(readOnly = true)
    @Override
    public Task getTaskById(Long task_id) throws SQLException {
        return taskDao.getTaskById(task_id);
    }
    @Transactional(readOnly = true)
    @Override
    public Collection getAllTasks() throws SQLException {
        return taskDao.getAllTasks();
    }
    @Transactional
    @Override
    public void deleteTask(Task task) throws SQLException {
        taskDao.deleteTask(task);
    }
}
