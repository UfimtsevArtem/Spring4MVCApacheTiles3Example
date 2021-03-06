package com.websystique.springmvc.service;


import com.websystique.springmvc.domain.Project;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by ufimtsev on 29.08.2017.
 */
public interface ProjectService {
    void addProject(Project project) throws SQLException;
    void deleteProject(Project project) throws SQLException;
    void saveOrUpdateProject(Project project) throws SQLException;
    void updateProjectWithParams(Project project) throws SQLException;
    Project getProjectById(Long project_id) throws SQLException;
    Collection getProjectsByUserId(Long user_id) throws SQLException;
    Collection getAllProjects() throws SQLException;
}
