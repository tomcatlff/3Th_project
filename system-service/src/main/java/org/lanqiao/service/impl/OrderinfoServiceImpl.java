package org.lanqiao.service.impl;

import org.lanqiao.dao.IOrderinfoDao;
import org.lanqiao.dao.impl.OrderinfoDaoImpl;
import org.lanqiao.domain.Order;
import org.lanqiao.domain.Orderinfo;
import org.lanqiao.service.IOrderinfoService;

import java.sql.SQLException;
import java.util.List;

public class OrderinfoServiceImpl implements IOrderinfoService {
    private IOrderinfoDao dao = new OrderinfoDaoImpl();
    public List<Orderinfo> findAll(int id) {
        List<Orderinfo> orderinfoList = null;
        try {
            orderinfoList= dao.getAllbyoid(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderinfoList;
    }

    @Override
    public Orderinfo getOState(int oid) throws SQLException {
        return dao.getOstatebyId(oid);
    }

    @Override
    public Orderinfo getBState(int oid) throws SQLException {
        return dao.getBstatebyId(oid);
    }

    @Override
    public void modifOrderInfo(Orderinfo orderinfo) throws SQLException {
    }
}
