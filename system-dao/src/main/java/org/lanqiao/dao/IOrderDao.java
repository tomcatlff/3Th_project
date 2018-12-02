package org.lanqiao.dao;

import org.lanqiao.domain.Order;

import java.util.List;

public interface IOrderDao {
    //查询所有订单
    public List<Order> getAll();
    //添加订单
    public void addOrder(Order order);
    //修改订单状态
    public Order updateOstate();
    //修改货物状态
}
