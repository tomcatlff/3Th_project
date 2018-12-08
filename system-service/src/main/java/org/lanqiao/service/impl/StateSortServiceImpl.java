package org.lanqiao.service.impl;

import org.lanqiao.dao.IStatesDao;
import org.lanqiao.dao.impl.StateDaoImpl;
import org.lanqiao.domain.BstateSort;
import org.lanqiao.domain.OstateSort;
import org.lanqiao.service.IStateService;

import java.sql.SQLException;
import java.util.List;

public class StateSortServiceImpl implements IStateService {
    IStatesDao dao = new StateDaoImpl();
    @Override
    public List<OstateSort> ostateSortList() throws SQLException {
        return dao.ostateSortList();
    }

    @Override
    public List<BstateSort> bstateSortList() throws SQLException {
        return dao.bstateSortList();
    }
}
