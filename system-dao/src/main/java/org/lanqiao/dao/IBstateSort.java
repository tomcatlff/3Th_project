package org.lanqiao.dao;

import org.lanqiao.domain.BstateSort;

import java.sql.SQLException;
import java.util.List;

public interface IBstateSort {
        public List<BstateSort> getBstateSort() throws SQLException;
}
