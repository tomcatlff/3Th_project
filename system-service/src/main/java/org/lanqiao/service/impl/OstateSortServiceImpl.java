package org.lanqiao.service.impl;

import org.lanqiao.dao.IOstateSort;
import org.lanqiao.dao.impl.IOstateSortImpl;
import org.lanqiao.domain.OstateSort;
import org.lanqiao.service.IOstateSortService;

import java.sql.SQLException;
import java.util.List;

public class OstateSortServiceImpl implements IOstateSortService {
    IOstateSort dao = new IOstateSortImpl();

    @Override
    public List<OstateSort> findOstateSort() throws SQLException {
        return dao.getOstateSort();
    }
}
