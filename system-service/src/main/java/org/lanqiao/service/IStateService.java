package org.lanqiao.service;

import org.lanqiao.domain.BstateSort;
import org.lanqiao.domain.OstateSort;

import java.sql.SQLException;
import java.util.List;

public interface IStateService {
    public List<OstateSort> ostateSortList() throws SQLException;
    public List<BstateSort> bstateSortList() throws SQLException;

}
