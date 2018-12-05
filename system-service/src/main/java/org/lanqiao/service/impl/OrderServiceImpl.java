package org.lanqiao.service.impl;

import org.lanqiao.dao.IOrderDao;
import org.lanqiao.dao.impl.OrderDaoImpl;
import org.lanqiao.domain.Order;
import org.lanqiao.service.IOrderService;

import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements IOrderService {
    private IOrderDao dao = new OrderDaoImpl();
    public List<Order> findAll() {
        List<Order> orderList = null;
        try {
            orderList= dao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    public void modifiyOrderOstate(Order order) {
        dao.updateOstatebyId(order);
    }

    public void modifiyOrderBstate(Order order) {
        dao.updateBstatebyId(order);
    }
}
