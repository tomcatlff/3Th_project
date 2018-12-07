package org.lanqiao.dao;

import org.lanqiao.domain.OstateSort;

import java.sql.SQLException;
import java.util.List;

public interface IOstateSort {
        public List<OstateSort> getOstateSort() throws SQLException;
}
