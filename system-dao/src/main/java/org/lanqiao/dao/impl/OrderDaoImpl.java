package org.lanqiao.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.dao.IOrderDao;
import org.lanqiao.domain.Order;
import org.lanqiao.domain.buser;
import org.lanqiao.utils.JdbcUtils;

import java.sql.SQLException;
import java.util.List;

public class OrderDaoImpl implements IOrderDao {
    private QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
    private String sql ="";
    public List<Order> getAll() throws SQLException {
        //String sql ="select uname,phone,address from buser";
        sql ="SELECT  u.uname,u.phone,u.address,o.oid,o.otime,o.count,o.totalprice,o.ostate,o.bstate,b.bimg,b.bname,b.price FROM buser u,border o,bookinfo b,ubo a where u.uid=a.uid and a.bid=b.bid AND o.oid=a.oid GROUP BY o.oid";
        List<Order> orderList= qr.query(sql, new BeanListHandler<Order>(Order.class));
        return orderList;
    }

    public void updateOstatebyId(Order order) {
        sql = "update border set ostate=? where oid=?";
        try {
            qr.update(sql,order.getOstate(),order.getOid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBstatebyId(Order order) {
        sql = "update border set bstate=? where oid=?";
        try {
            qr.update(sql,order.getBstate(),order.getOid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public int getOrderTotalNum() throws SQLException {
        return 0;
    }

    public List<Order> findPageList(int starIndex, int pageSize) {
        return null;
    }
}
