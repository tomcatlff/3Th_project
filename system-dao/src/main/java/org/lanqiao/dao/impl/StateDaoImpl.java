package org.lanqiao.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.dao.IStatesDao;
import org.lanqiao.domain.BstateSort;
import org.lanqiao.domain.OstateSort;
import org.lanqiao.utils.JdbcUtils;

import java.sql.SQLException;
import java.util.List;

public class StateDaoImpl implements IStatesDao {
    private QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
    private String sql ="";
    @Override
    public List<OstateSort> ostateSortList() throws SQLException {
        sql = "select * from ostatesort";
        return qr.query(sql,new BeanListHandler<>(OstateSort.class));
    }

    @Override
    public List<BstateSort> bstateSortList() throws SQLException {
        sql = "select * from bstatesort";
        return qr.query(sql,new BeanListHandler<>(BstateSort.class));
    }
}
