package org.lanqiao.service;

import org.lanqiao.domain.Orderinfo;

import java.sql.SQLException;
import java.util.List;

public interface IOrderinfoService {
    public List<Orderinfo> findAll(int id);
    //获取订单状态的service
    public Orderinfo getOState(int oid) throws SQLException;
    //获取订单状态的service
    public Orderinfo getBState(int oid) throws SQLException;
    //更新order
    public void modifOrderInfo(Orderinfo orderinfo) throws SQLException;
}
