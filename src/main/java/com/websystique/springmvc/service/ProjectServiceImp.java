package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.ProjectDao;
import com.websystique.springmvc.domain.Project;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * Created by ufimtsev on 29.08.2017.
 */
@Service
public class ProjectServiceImp implements ProjectService {

    private final ProjectDao projectDao;

    @Autowired
    public ProjectServiceImp(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }
    @Transactional
    @Override
    public void addProject(Project project) throws SQLException {
        projectDao.addProject(project);
    }
    @Transactional
    @Override
    public void updateProjectWithParams(Project project) throws SQLException {
        Query query = projectDao.createQuery("Update Project p set p.projectName = :name, p.projectDescription = :description where p.projectId = :id");
        query.setParameter("name", project.getProjectName());
        query.setParameter("description", project.getProjectDescription());
        query.setParameter("id", project.getProjectId());
        query.executeUpdate();
    }

    @Transactional
    @Override
    public void saveOrUpdateProject(Project project) throws SQLException {
        projectDao.saveOrUpdateProject(project);
    }

    @Transactional(readOnly = true)
    @Override
    public Project getProjectById(Long project_id) throws SQLException {
        Query<Project> query=projectDao.createQuery("Select p from Project p left join fetch p.tasks left join fetch p.workers where p.projectId = :id");
        query.setParameter("id", project_id);
        Project project = query.getSingleResult();
        return project;
    }
    @Transactional(readOnly = true)
    @Override
    public Collection getAllProjects() throws SQLException {
        Query<Project> query=projectDao.createQuery("Select distinct p from Project p left join fetch p.tasks left join fetch p.workers");
        List<Project> projects = query.getResultList();
        return projects;
    }
    @Transactional
    @Override
    public void deleteProject(Project project) throws SQLException {
        projectDao.deleteProject(project);
    }
}
