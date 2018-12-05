package org.lanqiao.service;

import org.lanqiao.domain.Orderinfo;

import java.util.List;

public interface IOrderinfoService {
    public List<Orderinfo> findAll(int id);
}
