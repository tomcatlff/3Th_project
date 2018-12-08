package org.lanqiao.dao;

import org.lanqiao.domain.Order;
import org.lanqiao.domain.OrderBook;
import org.lanqiao.domain.User;
import org.lanqiao.domain.UserOrder;

import java.sql.SQLException;
import java.util.List;

public interface IOrderDao {
    //查询所有订单
    public List<Order> getAll() throws SQLException;
    //修改订单状态
    public void updateOstatebyId(Order order);
    //修改货物状态
    public void updateBstatebyId(Order order);
    //获取总页数
    public int getOrderTotalNum() throws SQLException;
    //获取分页数据
    public List<Order> findPageList(int starIndex,int pageSize);
    //查询所有订单
    public List<UserOrder> getOrder() throws SQLException;

    //查询订单详情
    public List<OrderBook> getOrderBookByOid(int oid) throws SQLException;

    //删除订单
    public void deleteOrder(int oid) throws SQLException;

    //根据id先查一下订单
    public  OrderBook getOrderById(int oid) throws SQLException;

    //修改货物的状态
    public void  updateBstateid(OrderBook orderBook) throws SQLException;

    //条件查询:根据id查询订单
    public List<UserOrder> findByCondition(int oid) throws SQLException;

    //获取总的记录条数
    public Long getOrderTotalNum() throws SQLException;

    //获取分页数据
    public  List<UserOrder> findPageList(int startIndex, int pageSize) throws SQLException;

    //用户分页
    public  List<User> findUserPageList(int startIndex, int pageSize) throws SQLException;


}
