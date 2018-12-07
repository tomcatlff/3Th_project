package org.lanqiao.dao;

import org.lanqiao.domain.Manager;

import java.sql.SQLException;
import java.util.List;

public interface IManageDao {
    public List<Manager> getAll() throws SQLException;
    public Manager getOne(String name) throws SQLException;
    public void addManager(Manager manager) throws SQLException;
}
