import org.junit.Test;
import org.lanqiao.dao.IOrderDao;
import org.lanqiao.dao.impl.OrderDaoImpl;
import org.lanqiao.domain.Order;
import org.lanqiao.domain.buser;

import java.sql.SQLException;
import java.util.List;


public class DaoTest {
    @Test
    public void findAllTest() throws SQLException {
        IOrderDao dao = new OrderDaoImpl();
        List<Order> orderList= dao.getAll();
        for (Order buser:orderList){
            System.out.println(buser);
        }
    }
}
