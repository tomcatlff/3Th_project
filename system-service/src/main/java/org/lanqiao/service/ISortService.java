package org.lanqiao.service;

import org.lanqiao.domain.BookSort;

import java.sql.SQLException;
import java.util.List;

public interface ISortService {
    public List<BookSort> getSort() throws SQLException;
}
