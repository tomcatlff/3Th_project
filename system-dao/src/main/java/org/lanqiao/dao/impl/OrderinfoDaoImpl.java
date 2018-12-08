package org.lanqiao.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.dao.IOrderinfoDao;
import org.lanqiao.domain.Order;
import org.lanqiao.domain.Orderinfo;
import org.lanqiao.utils.JdbcUtils;

import java.sql.SQLException;
import java.util.List;

//查看某一订单的详情
public class OrderinfoDaoImpl implements IOrderinfoDao {
    private QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
    private String sql ="";
    public List<Orderinfo> getAllbyoid(int oid) throws SQLException {
        //String sql ="select uname,phone,address from Buser";
        sql ="SELECT  u.uname,u.phone,u.address,o.oid,o.otime,o.totalprice,o.ostateid,os.ostate,o.bstateid,bs.bstate,b.bimg,b.bname,b.price FROM Buser u,border o,bookinfo b,ubo a,ostatesort os,bstatesort bs where u.uid=a.uid and a.bid=b.bid AND o.oid=a.oid AND os.ostateid=o.ostateid AND bs.bstateid=o.bstateid and o.oid=?";
        List<Orderinfo> orderinfoList;
        orderinfoList = qr.query(sql, new BeanListHandler<Orderinfo>(Orderinfo.class),oid);
        return orderinfoList;
    }

    @Override
    public Orderinfo getOstatebyId(int oid) throws SQLException {
        sql = "SELECT b.ostateid,o.ostate FROM border b,ostatesort o WHERE b.ostateid=o.ostateid and oid =?";
        return qr.query(sql,new BeanHandler<>(Orderinfo.class),oid);
    }

    @Override
    public Orderinfo getBstatebyId(int oid) throws SQLException {
        sql = "SELECT b.bstateid,o.bstate FROM border b,bstatesort o WHERE b.bstateid=o.bstateid and oid =?";
        return qr.query(sql,new BeanHandler<>(Orderinfo.class),oid);
    }

    @Override
    public void updateOstate(Orderinfo orderinfo) throws SQLException {

    }

    @Override
    public void updateBstate(Orderinfo orderinfo) throws SQLException {

    }

    public int getOrderTotalNum() throws SQLException {
        return 0;
    }

    public List<Order> findPageList(int starIndex, int pageSize) {
        return null;
    }
}
