package org.lanqiao.service;

import org.lanqiao.domain.Orderinfo;

import java.sql.SQLException;
import java.util.List;

public interface IOrderinfoService {
    public List<Orderinfo> findAll(int id);
    public Orderinfo getOrderState(int oid) throws SQLException;
    public void modifOrderInfo(Orderinfo orderinfo) throws SQLException;
}
