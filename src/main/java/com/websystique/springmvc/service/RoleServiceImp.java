package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.RoleDao;
import com.websystique.springmvc.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by ufimtsev on 29.08.2017.
 */
@Service
public class RoleServiceImp implements RoleService {
    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImp(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
    @Transactional
    @Override
    public void addRole(Role role) throws SQLException {
        roleDao.addRole(role);
    }
    @Transactional
    @Override
    public void updateRole(Long role_id, Role role) throws SQLException {
        roleDao.updateRole(role_id, role);
    }
    @Transactional(readOnly = true)
    @Override
    public Role getRoleById(Long role_id) throws SQLException {
        return roleDao.getRoleById(role_id);
    }
    @Transactional(readOnly = true)
    @Override
    public Collection getAllRoles() throws SQLException {
        return roleDao.getAllRoles();
    }
    @Transactional
    @Override
    public void deleteRole(Role role) throws SQLException {
        roleDao.deleteRole(role);
    }
}
