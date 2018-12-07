package org.lanqiao.dao;

import org.lanqiao.domain.BookSort;

import java.sql.SQLException;
import java.util.List;

public interface ISortDao {
    public List<BookSort> sortList() throws SQLException;
}
