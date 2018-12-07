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
        //String sql ="select uname,phone,address from buser";
        sql ="SELECT  u.uname,u.phone,u.address,o.oid,o.otime,o.totalprice,o.ostate,o.bstate,b.bimg,b.bname,b.price FROM buser u,border o,bookinfo b,ubo a where u.uid=a.uid and a.bid=b.bid AND o.oid=a.oid and o.oid=?";
        List<Orderinfo> orderinfoList;
        orderinfoList = qr.query(sql, new BeanListHandler<Orderinfo>(Orderinfo.class),oid);
        return orderinfoList;
    }

    @Override
    public Orderinfo getInfobyId(int oid) throws SQLException {
        sql = "SELECT ostate,bstate from border where oid =?";

        return qr.query(sql,new BeanHandler<>(Orderinfo.class),oid);
    }

    @Override
    public void updateState(Orderinfo orderinfo) throws SQLException {
        sql = "update border set ostate=?,bstate=? where oid=?";
        qr.update(sql,orderinfo.getOstate(),orderinfo.getBstate(),orderinfo.getOid());
    }


    public int getOrderTotalNum() throws SQLException {
        return 0;
    }

    public List<Order> findPageList(int starIndex, int pageSize) {
        return null;
    }
}
