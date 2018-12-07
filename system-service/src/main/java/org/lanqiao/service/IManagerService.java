package org.lanqiao.service;

import org.lanqiao.domain.Manager;

import java.sql.SQLException;
import java.util.List;

public interface IManagerService {
    public List<Manager> ManagerList() throws SQLException;
    public Manager findOne(String name) throws SQLException;
    public void add(Manager manager) throws SQLException;
}
