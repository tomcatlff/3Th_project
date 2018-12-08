package org.lanqiao.service.impl;

import org.lanqiao.dao.IOrderDao;
import org.lanqiao.dao.impl.OrderDaoImpl;
import org.lanqiao.domain.OrderBook;
import org.lanqiao.domain.User;
import org.lanqiao.domain.UserOrder;
import org.lanqiao.service.IUserOrderService;

import java.sql.SQLException;
import java.util.List;

public class UserOrderServiceImpl implements IUserOrderService {
    private IOrderDao dao = new OrderDaoImpl();

    //获取所有用户
    @Override
    public List<User> findUser() throws SQLException {

        return dao.getUser();
    }

    //获取所有订单
    @Override
    public List<UserOrder> getAllOrder() throws SQLException {

        return dao.getOrder();
    }

    //获取订单详情
    @Override
    public List<OrderBook> getThisOrderBook(int oid) throws SQLException {
        return dao.getOrderBookByOid(oid);
    }

    //移除订单
    @Override
    public void removeOrder(int oid) {

    }

    //根据id查找订单
    @Override
    public OrderBook findOrderById(int oid) throws SQLException {

        return dao.getOrderById(oid);
    }

    //修改货物状态
    @Override
    public void modifyOrder(OrderBook orderBook) throws SQLException {
        dao.updateBstateid(orderBook);
    }

    //条件查询：根据id查询订单
    @Override
    public List<UserOrder> serchOrder(int oid) throws SQLException {
        return dao.findByCondition(oid);
    }

    //获取订单总数
    @Override
    public int getTotalNum() throws SQLException {
        Long num = dao.getOrderTotalNum();
        int n = new Integer(num.toString());
        return n;
    }

    //分页
    @Override
    public List<UserOrder> findPage(int startIndex, int pageSize) throws SQLException {
        List<UserOrder> orderPageList = dao.findPageList(startIndex, pageSize);
        return orderPageList;
    }

    @Override
    public List<User> getUserPageList(int startIndex, int pageSize) throws SQLException {
        List<User> userPageList = dao.findUserPageList(startIndex, pageSize);
        return userPageList;
    }
}
