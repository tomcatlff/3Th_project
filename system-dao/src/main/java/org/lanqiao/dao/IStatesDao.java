package org.lanqiao.dao;

import org.lanqiao.domain.BstateSort;
import org.lanqiao.domain.OstateSort;

import java.sql.SQLException;
import java.util.List;

public interface IStatesDao {
    public List<OstateSort> ostateSortList() throws SQLException;
    public List<BstateSort> bstateSortList() throws SQLException;
}
