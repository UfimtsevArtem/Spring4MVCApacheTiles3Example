package com.websystique.springmvc.dao;


import com.websystique.springmvc.domain.Project;
import com.websystique.springmvc.domain.Task;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by ufimtsev on 29.08.2017.
 */
@Repository
public class ProjectDaoImp implements ProjectDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public ProjectDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addProject(Project project) throws SQLException {
        sessionFactory.getCurrentSession().save(project);
    }

    public void saveOrUpdateProject(Project project) throws SQLException{
        sessionFactory.getCurrentSession().saveOrUpdate(project);
    }


    @Override
    public Query createQuery(String hql) {
        return sessionFactory.getCurrentSession().createQuery(hql);
    }

    @Override
    public void deleteProject(Project project) throws SQLException {
        sessionFactory.getCurrentSession().delete(project);
    }
}
