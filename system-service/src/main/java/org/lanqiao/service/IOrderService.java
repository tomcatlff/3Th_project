package org.lanqiao.service;

import org.lanqiao.domain.Order;

import java.util.List;

public interface IOrderService {
    public List<Order> findAll();
    public void modifiyOrderOstate(Order order);
    public void modifiyOrderBstate(Order order);
}
