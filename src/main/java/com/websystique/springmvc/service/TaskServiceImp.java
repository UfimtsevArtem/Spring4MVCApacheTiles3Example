package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.TaskDao;
import com.websystique.springmvc.domain.Task;
import org.hibernate.query.Query;
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
    public void deleteTask(Task task) throws SQLException {
        taskDao.deleteTask(task);
    }
    @Transactional
    @Override
    public void saveOrUpdateTask(Task task) throws SQLException {
        taskDao.saveOrUpdateTask(task);
    }
    @Transactional(readOnly = true)
    public Task getTaskById(Long task_id) throws SQLException {
        Query<Task> query=taskDao.createQuery("Select t from Task t left join fetch t.comments left join fetch t.workers where t.taskId = :id");
        query.setParameter("id", task_id);
        Task task = query.getSingleResult();
        return task;
    }
    @Transactional(readOnly = true)
    @Override
    public Collection getAllTasks() throws SQLException {
        return taskDao.getAllTasks();
    }
    @Transactional
    @Override
    public void updateTaskWithParams(Task task) throws SQLException {
        Query query = taskDao.createQuery("Update Task t set t.taskName = :name, t.taskDescription = :description where t.taskId = :id");
        query.setParameter("name", task.getTaskName());
        query.setParameter("description", task.getTaskDescription());
        query.setParameter("id", task.getTaskId());
        query.executeUpdate();
    }
}
