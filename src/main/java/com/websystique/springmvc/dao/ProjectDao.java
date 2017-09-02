package com.websystique.springmvc.dao;


import com.websystique.springmvc.domain.Project;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by ufimtsev on 29.08.2017.
 */
public interface ProjectDao {
    void addProject(Project project) throws SQLException;
    void deleteProject(Project project) throws SQLException;
    void saveOrUpdateProject(Project project) throws SQLException;
    Query createQuery(String hql);
}
