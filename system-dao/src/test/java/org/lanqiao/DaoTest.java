package org.lanqiao;

import org.junit.Test;
import org.lanqiao.dao.IOrderDao;
import org.lanqiao.dao.IOstateSort;
import org.lanqiao.dao.impl.IOstateSortImpl;
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
        System.out.println(orderBook.getOid()+"---"+orderBook.getBname()+"---"+orderBook.getBstate());
    }

    @Test
    public void getUsers() throws SQLException {
        IOrderDao dao = new OrderDaoImpl();
        List<User> userList = dao.getUser();
        for(User user:userList){
            System.out.println(user);
        }
    }

    @Test
    public void getOstateSort() throws SQLException {
        IOstateSort dao = new IOstateSortImpl();
        List<OstateSort> ostateSortList = dao.getOstateSort();
        for(OstateSort ostate:ostateSortList){
            System.out.println(ostate);
        }
    }

//    public void findByCondition(){
//        IOstateSort dao = new IOstateSortImpl();
//        dao.
//    }
}
