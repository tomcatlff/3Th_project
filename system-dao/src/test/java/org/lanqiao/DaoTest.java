package org.lanqiao;

import org.junit.Test;
import org.lanqiao.dao.IBstateSort;
import org.lanqiao.dao.IOrderDao;
import org.lanqiao.dao.impl.IBstateSortImpl;
import org.lanqiao.dao.impl.OrderDaoImpl;
import org.lanqiao.domain.*;

import java.sql.SQLException;
import java.util.List;

public class DaoTest {

    @Test
    public void getOrder() throws SQLException {
        IOrderDao dao = new OrderDaoImpl();
        List<UserOrder> orderList = dao.getOrder();
        for(UserOrder order:orderList){
            System.out.println(order);
        }
    }

    @Test
    public void getOrderBook() throws SQLException {
        IOrderDao dao = new OrderDaoImpl();
        List<OrderBook> orderBookList = dao.getOrderBookByOid(2);
        for(OrderBook orderBook:orderBookList){
            System.out.println(orderBook);
        }
    }

    @Test
    public void  getOrderById() throws SQLException {
        IOrderDao dao = new OrderDaoImpl();
        OrderBook orderBook = dao.getOrderById(2);
        System.out.println(orderBook.getOid()+"---"+orderBook.getBname()+"---"+orderBook.getBstateid());
    }

    @Test
    public void getUsers() throws SQLException {
        IOrderDao dao = new OrderDaoImpl();
        List<User> userList = dao.getUser();
        for(User user:userList){
            System.out.println(user);
        }
    }

//    @Test
//    public void getOstateSort() throws SQLException {
//        IBstateSort dao = new IBstateSortImpl();
//        List<BstateSort> bstateSortList = dao.getOstateSort();
//        for(BstateSort ostate: bstateSortList){
//            System.out.println(ostate);
//        }
//    }

//    public void findByCondition(){
//        IBstateSort dao = new IBstateSortImpl();
//        dao.
//    }
}
