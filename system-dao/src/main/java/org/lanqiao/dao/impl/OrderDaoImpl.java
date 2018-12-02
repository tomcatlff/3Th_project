package org.lanqiao.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.dao.IOrderDao;
import org.lanqiao.domain.Order;
import org.lanqiao.domain.buser;
import org.lanqiao.utils.JdbcUtils;

import java.sql.SQLException;
import java.util.List;

public class OrderDaoImpl implements IOrderDao {
    public List<Order> getAll() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        //String sql ="select uname,phone,address from buser";
        String sql ="SELECT  u.uname,u.phone,u.address,o.oid,o.otime,o.totalprice,o.ostate,o.bstate,b.bimg,b.bname,b.price FROM buser u,border o,bookinfo b,ubo a where u.uid=a.uid and a.bid=b.bid AND o.oid=a.oid GROUP BY o.oid";
        List<Order> orderList= qr.query(sql, new BeanListHandler<Order>(Order.class));
        return orderList;
    }

    public void addOrder(Order order) {

    }

    public void updateOstate(Order order) {

    }

    public void updateBstate(Order order) {

    }
}
