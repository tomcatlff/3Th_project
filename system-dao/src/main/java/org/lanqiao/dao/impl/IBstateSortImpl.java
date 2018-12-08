package org.lanqiao.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.dao.IBstateSort;
import org.lanqiao.domain.BstateSort;
import org.lanqiao.utils.JdbcUtils;

import java.sql.SQLException;
import java.util.List;

public class IBstateSortImpl implements IBstateSort {
    @Override
    public List<BstateSort> getBstateSort() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "select bstateid,bstate from bstatesort";
        return qr.query(sql,new BeanListHandler<>(BstateSort.class));
    }
}
