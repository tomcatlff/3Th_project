package org.lanqiao.dao;

import org.lanqiao.domain.Order;
import org.lanqiao.domain.Orderinfo;

import java.sql.SQLException;
import java.util.List;

public interface IOrderinfoDao {
    //查询所有订单
    public List<Orderinfo> getAllbyoid(int oid) throws SQLException;
    //查询订单状态
    public Orderinfo getOstatebyId(int oid) throws SQLException;
    //查询货物状态
    public Orderinfo getBstatebyId(int oid) throws SQLException;
    //修改订单状态
    public void updateOstate(Orderinfo orderinfo) throws SQLException;
    //修改货物状态
    public void updateBstate(Orderinfo orderinfo) throws SQLException;
    //获取总页数
    public int getOrderTotalNum() throws SQLException;
    //获取分页数据
    public List<Order> findPageList(int starIndex,int pageSize);
}
