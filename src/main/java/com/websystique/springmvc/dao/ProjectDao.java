package com.websystique.springmvc.dao;


import com.websystique.springmvc.domain.Project;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by ufimtsev on 29.08.2017.
 */
public interface ProjectDao {
    void addProject(Project project) throws SQLException;
    void updateProject(Long project_id, Project project) throws SQLException;
    Project getProjectById(Long project_id) throws SQLException;
    Collection getAllProjects() throws SQLException;
    void deleteProject(Project project) throws SQLException;
}