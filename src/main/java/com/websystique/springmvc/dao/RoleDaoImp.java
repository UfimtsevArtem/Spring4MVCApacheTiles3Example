package com.websystique.springmvc.dao;


import com.websystique.springmvc.domain.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by ufimtsev on 29.08.2017.
 */
@Repository
public class RoleDaoImp implements RoleDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public RoleDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addRole(Role role) throws SQLException {
        sessionFactory.getCurrentSession().save(role);
    }

    @Override
    public void updateRole(Long role_id, Role role) throws SQLException {
        sessionFactory.getCurrentSession().update(role);
    }

    @Override
    public Role getRoleById(Long role_id) throws SQLException {
        return sessionFactory.getCurrentSession().load(Role.class, role_id);
    }

    @Override
    public Collection getAllRoles() throws SQLException {
        @SuppressWarnings("unchecked")
        TypedQuery<Role> query=sessionFactory.getCurrentSession().createQuery("from Role");
        return query.getResultList();
    }

    @Override
    public void deleteRole(Role role) throws SQLException {
        sessionFactory.getCurrentSession().delete(role);
    }
}
