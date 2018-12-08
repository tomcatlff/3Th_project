package org.lanqiao.dao;

import org.lanqiao.domain.Order;

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
}
