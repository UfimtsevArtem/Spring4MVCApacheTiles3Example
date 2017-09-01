package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.ProjectDao;
import com.websystique.springmvc.domain.Project;
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
    public void updateProject(Long project_id, Project project) throws SQLException {
        projectDao.updateProject(project_id, project);
    }

    @Override
    public void updateProjectWithParams(Project project) throws SQLException {
        Query<Project> query=projectDao.createQuery("UPDATE PROJECT p SET p.namesadfdsa=:name");
        query.setParameter("name",project.getProjectName());
    }

    @Transactional
    @Override
    public void saveProject(Project project) throws SQLException {
        projectDao.saveProject(project);
    }

    @Transactional(readOnly = true)
    @Override
    public Project getProjectById(Long project_id) throws SQLException {
        return projectDao.getProjectById(project_id);
    }
    @Transactional(readOnly = true)
    @Override
    public Collection getAllProjects() throws SQLException {
        return projectDao.getAllProjects();
    }
    @Transactional
    @Override
    public void deleteProject(Project project) throws SQLException {
        projectDao.deleteProject(project);
    }
}
