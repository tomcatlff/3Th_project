package org.lanqiao.service;

import org.lanqiao.domain.OstateSort;

import java.sql.SQLException;
import java.util.List;

public interface IOstateSortService {
    public List<OstateSort> findOstateSort() throws SQLException;
}
