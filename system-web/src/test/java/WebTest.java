import org.junit.Test;
import org.lanqiao.domain.BstateSort;
import org.lanqiao.service.IBstateSortService;
import org.lanqiao.service.impl.BstateSortServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class WebTest {

    @Test
    public void getBstate() throws SQLException {
        IBstateSortService service = new BstateSortServiceImpl();
        List<BstateSort> bstateSortList  = service.findBstateSort();
        for(BstateSort sort:bstateSortList){
            System.out.println(sort);
        }
    }
}
