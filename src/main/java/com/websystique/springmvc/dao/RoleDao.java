package com.websystique.springmvc.dao;


import com.websystique.springmvc.domain.Role;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by ufimtsev on 29.08.2017.
 */
public interface RoleDao {
    void addRole(Role role) throws SQLException;
    void updateRole(Long role_id, Role role) throws SQLException;
    Role getRoleById(Long role_id) throws SQLException;
    Collection getAllRoles() throws SQLException;
    void deleteRole(Role role) throws SQLException;
}
