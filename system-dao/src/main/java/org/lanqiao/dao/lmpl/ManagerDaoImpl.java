package org.lanqiao.dao.lmpl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.dao.IManageDao;
import org.lanqiao.domain.Manager;
import org.lanqiao.utils.JdbcUtils;

import java.sql.SQLException;
import java.util.List;

public class ManagerDaoImpl implements IManageDao {
    @Override
    public List<Manager> getAll() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "select mname,mpassword from bmanager";
        return qr.query(sql,new BeanListHandler<>(Manager.class));
    }

    @Override
    public Manager getOne(String name) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "select mpassword from bmanager where mname=?";
        return qr.query(sql,new BeanHandler<>(Manager.class),name);

    }

    @Override
    public void addManager(Manager manager) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "insert into bmanager (mname,mpassword) values (?,?)";
        qr.update(sql,manager.getMname(),manager.getMpassword());
    }
}
