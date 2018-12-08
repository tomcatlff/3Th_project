package org.lanqiao.service.impl;

import org.lanqiao.dao.IBstateSort;
import org.lanqiao.dao.impl.IBstateSortImpl;
import org.lanqiao.domain.BstateSort;
import org.lanqiao.service.IBstateSortService;

import java.sql.SQLException;
import java.util.List;

public class BstateSortServiceImpl implements IBstateSortService {
    IBstateSort dao = new IBstateSortImpl();

    @Override
    public List<BstateSort> findBstateSort() throws SQLException {
        return dao.getBstateSort();
    }
}
