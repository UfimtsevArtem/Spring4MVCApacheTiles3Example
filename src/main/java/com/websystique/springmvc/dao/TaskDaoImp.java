package com.websystique.springmvc.dao;

import com.websystique.springmvc.domain.Task;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by ufimtsev on 29.08.2017.
 */
@Repository
public class TaskDaoImp implements TaskDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public TaskDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addTask(Task task) throws SQLException {
        sessionFactory.getCurrentSession().save(task);
    }

    @Override
    public void updateTask(Long task_id, Task task) throws SQLException {
        sessionFactory.getCurrentSession().update(task);
    }

    @Override
    public Task getTaskById(Long task_id) throws SQLException {
        return sessionFactory.getCurrentSession().load(Task.class, task_id);
    }

    @Override
    public Collection getAllTasks() throws SQLException {
        @SuppressWarnings("unchecked")
        TypedQuery<Task> query=sessionFactory.getCurrentSession().createQuery("from Task");
        return query.getResultList();
    }

    @Override
    public void deleteTask(Task task) throws SQLException {
        sessionFactory.getCurrentSession().delete(task);
    }
    @Override
    public Query createQuery(String hql) {
        return sessionFactory.getCurrentSession().createQuery(hql);
    }
}
