package org.lanqiao.service;

import org.lanqiao.domain.BstateSort;

import java.sql.SQLException;
import java.util.List;

public interface IBstateSortService {
    public List<BstateSort> findBstateSort() throws SQLException;
}
