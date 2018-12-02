package org.lanqiao.dao;

import org.lanqiao.domain.Order;
import org.lanqiao.domain.buser;

import java.sql.SQLException;
import java.util.List;

public interface IOrderDao {
    //查询所有订单
    public List<Order> getAll() throws SQLException;
    //添加订单
    public void addOrder(Order order);
    //修改订单状态
    public void updateOstate(Order order);
    //修改货物状态
    public void updateBstate(Order order);
}
