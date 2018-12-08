package org.lanqiao.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.lanqiao.dao.IOrderDao;
import org.lanqiao.domain.Order;
import org.lanqiao.domain.OrderBook;
import org.lanqiao.domain.User;
import org.lanqiao.domain.UserOrder;
import org.lanqiao.utils.JdbcUtils;

import java.sql.SQLException;
import java.util.List;

public class OrderDaoImpl implements IOrderDao {


    @Override
    public List<User> getUser() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "select uid,uname,password,phone,address,wallet from buser";
        List<User> userList = qr.query(sql,new BeanListHandler<>(User.class));
        return userList;
    }

    //获取所有的订单
    @Override
    public List<UserOrder> getOrder() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "select bo.oid,bu.uname,bu.phone,bu.address,bo.otime ,bo.totalprice, os.ostate,bo.bstateid,bs.bstate from buser bu , border bo ,ubo ,bstatesort bs ,ostatesort os where bu.uid=ubo.uid and bo.oid=ubo.oid and bo.bstateid=bs.bstateid and bo.ostateid=os.ostateid GROUP BY ubo.oid";
        List<UserOrder> orderList = qr.query(sql,new BeanListHandler<>(UserOrder.class));
        return orderList;
    }

    //获取订单的详情
    @Override
    public List<OrderBook> getOrderBookByOid(int oid) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "select bo.oid,bi.bname ,bo.bstateid,bs.bstate from border bo,bookinfo bi,ubo,bstatesort bs where  bo.oid=ubo.oid and ubo.bid=bi.bid and bo.bstateid=bs.bstateid and bo.oid=?";
        List<OrderBook> orderBookList = qr.query(sql,new BeanListHandler<>(OrderBook.class),oid);
        return orderBookList;
    }

    //删除订单
    @Override
    public void deleteOrder(int oid) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "delete from border where oid=?";
        qr.update(sql,oid);
    }

    //根据id获取订单
    @Override
    public OrderBook getOrderById(int oid) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "select bo.oid,bi.bname ,bo.bstateid,bs.bstate from border bo,bookinfo bi,ubo ,bstatesort bs where  bo.oid=ubo.oid and ubo.bid=bi.bid and bo.bstateid=bs.bstateid and bo.oid=?";
        return qr.query(sql,new BeanHandler<>(OrderBook.class),oid);
    }

    //修改订单状态
    @Override
    public void updateBstateid(OrderBook orderBook) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "update border set bstateid=?  where oid=?";
        qr.update(sql,orderBook.getBstateid(),orderBook.getOid());

    }

    //条件查询：根据id查询订单
    @Override
    public List<UserOrder> findByCondition(int oid) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());;
        String sql = "select bo.oid,bu.uname,bu.phone,bu.address,bo.otime ,bo.totalprice, os.ostate,bo.bstateid,bs.bstate from buser bu , border bo ,ubo ,bstatesort bs ,ostatesort os where bu.uid=ubo.uid and bo.oid=ubo.oid and bo.bstateid=bs.bstateid and bo.ostateid=os.ostateid GROUP BY ubo.oid";
        List<UserOrder> orderList = qr.query(sql,new BeanListHandler<>(UserOrder.class),oid);
        return orderList;
    }

    //获取订单总条数
    @Override
    public Long getOrderTotalNum() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());;
        String sql = "select count(*) from border";
        Long num = qr.query(sql,new ScalarHandler<>(1));
        return num;
    }

    //分页
    @Override
    public List<UserOrder> findPageList(int startIndex, int pageSize) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "select bo.oid,bu.uname,bu.phone,bu.address,bo.otime ,bo.totalprice, os.ostate,bo.bstateid,bs.bstate from buser bu , border bo ,ubo ,bstatesort bs ,ostatesort os where bu.uid=ubo.uid and bo.oid=ubo.oid and bo.bstateid=bs.bstateid and bo.ostateid=os.ostateid GROUP BY ubo.oid limit ?,?";
        return  qr.query(sql,new BeanListHandler<>(UserOrder.class),startIndex,pageSize);
    }

    //用户分页
    @Override
    public List<User> findUserPageList(int startIndex, int pageSize) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "select uid,uname,password,phone,address,wallet from buser limit ?,?";
        //List<User> userList = qr.query(sql,new BeanListHandler<>(User.class));
        return qr.query(sql,new BeanListHandler<>(User.class),startIndex,pageSize);
    }




}
