package org.lanqiao.service.Impl;

import org.lanqiao.dao.ISortDao;
import org.lanqiao.dao.lmpl.SortImpl;
import org.lanqiao.domain.BookSort;
import org.lanqiao.service.ISortService;

import java.sql.SQLException;
import java.util.List;

public class SortService implements ISortService {
    ISortDao dao = new SortImpl();
    @Override
    public List<BookSort> getSort() throws SQLException {

        return dao.sortList();
    }
}
