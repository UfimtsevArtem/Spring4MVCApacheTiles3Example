package com.websystique.springmvc.dao;

import com.websystique.springmvc.domain.Status;
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
public class StatusDaoImp implements StatusDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public StatusDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addStatus(Status status) throws SQLException {
        sessionFactory.getCurrentSession().save(status);
    }

    @Override
    public void updateStatus(Long status_id, Status status) throws SQLException {
        sessionFactory.getCurrentSession().update(status);
    }

    @Override
    public Status getStatusById(Long status_id) throws SQLException {
        return sessionFactory.getCurrentSession().load(Status.class, status_id);
    }

    @Override
    public Collection getAllStatuss() throws SQLException {
        @SuppressWarnings("unchecked")
        TypedQuery<Status> query=sessionFactory.getCurrentSession().createQuery("from Status");
        return query.getResultList();
    }

    @Override
    public void deleteStatus(Status status) throws SQLException {
        sessionFactory.getCurrentSession().delete(status);
    }
}
