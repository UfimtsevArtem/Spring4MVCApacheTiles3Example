package com.websystique.springmvc.dao;


import com.websystique.springmvc.domain.Status;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by ufimtsev on 29.08.2017.
 */
public interface StatusDao {
    void addStatus(Status status) throws SQLException;
    void updateStatus(Long status_id, Status status) throws SQLException;
    Status getStatusById(Long status_id) throws SQLException;
    Collection getAllStatuss() throws SQLException;
    void deleteStatus(Status status) throws SQLException;
}
