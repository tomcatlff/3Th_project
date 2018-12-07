package org.lanqiao.service.Impl;

import org.lanqiao.dao.IManageDao;
import org.lanqiao.dao.lmpl.ManagerDaoImpl;
import org.lanqiao.domain.Manager;
import org.lanqiao.service.IManagerService;

import java.sql.SQLException;
import java.util.List;

public class ManagerListImpl implements IManagerService {
    IManageDao dao = new ManagerDaoImpl();
    @Override
    public List<Manager> ManagerList() throws SQLException {

        return dao.getAll();
    }

    @Override
    public Manager findOne(String name) throws SQLException {
        return dao.getOne(name);
    }

    @Override
    public void add(Manager manager) throws SQLException {
        dao.addManager(manager);
    }
}
