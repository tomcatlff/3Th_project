package org.lanqiao.dao.lmpl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.dao.ISortDao;
import org.lanqiao.domain.BookSort;
import org.lanqiao.utils.JdbcUtils;

import java.sql.SQLException;
import java.util.List;

public class SortImpl implements ISortDao {

    @Override
    public List<BookSort> sortList() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDs());
        String sql = "select * from booksort";
        return qr.query(sql,new BeanListHandler<>(BookSort.class));
    }
}
