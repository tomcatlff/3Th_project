package org.lanqiao.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.dao.IOstateSort;
import org.lanqiao.domain.OstateSort;
import org.lanqiao.utils.JdbcUtils;

import java.sql.SQLException;
import java.util.List;

public class IOstateSortImpl implements IOstateSort {
    @Override
    public List<OstateSort> getOstateSort() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "select ostateid,ostate from ostatesort";
        return qr.query(sql,new BeanListHandler<>(OstateSort.class));
    }
}
