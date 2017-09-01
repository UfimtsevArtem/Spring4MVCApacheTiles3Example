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

    @Override
    public void updateProject(Long project_id, Project project) throws SQLException {
        sessionFactory.getCurrentSession().saveOrUpdate(project);
    }

    @Override
    public void saveProject(Project project) throws SQLException {
        sessionFactory.getCurrentSession().save(project);
    }

    @Override
    public Query<Project> createQuery(String hql) {
        return sessionFactory.getCurrentSession().createQuery(hql,Project.class);
    }

    @Override
    public Project getProjectById(Long project_id) throws SQLException {
        @SuppressWarnings("unchecked")
        TypedQuery<Project> query=sessionFactory.getCurrentSession().createQuery("Select p from Project p left join fetch p.tasks left join fetch p.workers where p.projectId = :id");
        query.setParameter("id", project_id);
        Project project = query.getSingleResult();
        return project;
    }


    @Override
    public Collection getAllProjects() throws SQLException {
        @SuppressWarnings("unchecked")
        TypedQuery<Project> query=sessionFactory.getCurrentSession().createQuery("Select distinct p from Project p left join fetch p.tasks left join fetch p.workers");
        List<Project> projects = query.getResultList();
        projects.size();
        return query.getResultList();
    }

    @Override
    public void deleteProject(Project project) throws SQLException {
        sessionFactory.getCurrentSession().delete(project);
    }
}
