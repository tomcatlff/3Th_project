package org.lanqiao.service;

import org.lanqiao.domain.OrderBook;
import org.lanqiao.domain.User;
import org.lanqiao.domain.UserOrder;

import java.sql.SQLException;
import java.util.List;

public interface IUserOrderService {

    //获取所有用户
    public List<User> findUser() throws SQLException;

    //获取所有订单
    public List<UserOrder> getAllOrder() throws SQLException;

    //获取订单详情
    public List<OrderBook> getThisOrderBook(int oid ) throws SQLException;

    //移除订单
    public void removeOrder(int oid);

    //根据id查找订单
    public OrderBook findOrderById(int oid) throws SQLException;

    //修改订单
    public void modifyOrder(OrderBook orderBook) throws SQLException;

    //条件查询：根据id查询订单
    public List<UserOrder> serchOrder(int oid) throws SQLException;

    //获取订单总数
    public int getTotalNum() throws SQLException;

    //分页
    public List<UserOrder> findPage(int startIndex, int pageSize) throws SQLException;

    //用户分页
    public List<User> getUserPageList(int startIndex, int pageSize) throws SQLException;
}
