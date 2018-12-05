import org.junit.Test;
import org.lanqiao.dao.IOrderDao;
import org.lanqiao.dao.IOrderinfoDao;
import org.lanqiao.dao.impl.OrderDaoImpl;
import org.lanqiao.dao.impl.OrderinfoDaoImpl;
import org.lanqiao.domain.Order;
import org.lanqiao.domain.Orderinfo;
import org.lanqiao.domain.buser;

import java.sql.SQLException;
import java.util.List;


public class DaoTest {
    @Test
    public void orderfindAllTest() throws SQLException {
        IOrderDao dao = new OrderDaoImpl();
        List<Order> orderList= dao.getAll();
        for (Order order:orderList){
            System.out.println(order);
        }
    }
    @Test
    public void orderinfofindAllTest() throws SQLException {
        IOrderinfoDao dao = new OrderinfoDaoImpl();
        List<Orderinfo> orderList= dao.getAllbyoid(1);
        for (Orderinfo order:orderList){
            System.out.println(order);
        }
    }
}
