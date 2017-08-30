package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.StatusDao;
import com.websystique.springmvc.domain.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by ufimtsev on 29.08.2017.
 */
@Service
public class StatusServiceImp implements StatusService {

    private final StatusDao statusDao;

    @Autowired
    public StatusServiceImp(StatusDao statusDao) {
        this.statusDao = statusDao;
    }
    @Transactional
    @Override
    public void addStatus(Status status) throws SQLException {
        statusDao.addStatus(status);
    }
    @Transactional
    @Override
    public void updateStatus(Long status_id, Status status) throws SQLException {
        statusDao.updateStatus(status_id, status);
    }
    @Transactional(readOnly = true)
    @Override
    public Status getStatusById(Long status_id) throws SQLException {
        return statusDao.getStatusById(status_id);
    }
    @Transactional(readOnly = true)
    @Override
    public Collection getAllStatuss() throws SQLException {
        return statusDao.getAllStatuss();
    }
    @Transactional
    @Override
    public void deleteStatus(Status status) throws SQLException {
        statusDao.deleteStatus(status);
    }
}
