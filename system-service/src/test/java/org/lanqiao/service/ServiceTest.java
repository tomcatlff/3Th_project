package org.lanqiao.service;

import org.junit.Test;
import org.lanqiao.domain.BstateSort;
import org.lanqiao.domain.OrderBook;
import org.lanqiao.domain.User;
import org.lanqiao.domain.UserOrder;
import org.lanqiao.service.impl.BstateSortServiceImpl;
import org.lanqiao.service.impl.UserOrderServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class ServiceTest {


    @Test
    public void  getOrderById() throws SQLException {
        IUserOrderService service = new UserOrderServiceImpl();
        OrderBook orderBook = service.findOrderById(3);
        System.out.println(orderBook.getOid()+"---"+orderBook.getBname()+"---"+orderBook.getBstateid());
    }

    @Test
    public void getUsers() throws SQLException {
        IUserOrderService service = new UserOrderServiceImpl();
        List<User> userList = service.findUser();
        for(User user:userList){
            System.out.println(user);
        }
    }

    @Test
    public void getUserList() throws SQLException {
        IUserOrderService service = new UserOrderServiceImpl();
        List<User> userList = service.getUserPageList(0,5);
        for(User user:userList){
            System.out.println(user);
        }
    }

//    @Test
//    public void getOstateSort() throws SQLException {
//        IBstateSortService service = new BstateSortServiceImpl();
//        List<BstateSort> bstateSortList = service.findOstateSort();
//        for(BstateSort ostate: bstateSortList){
//            System.out.println(ostate);
//        }
//    }

    @Test
    public void getOrderConditon() throws SQLException {
        IUserOrderService service = new UserOrderServiceImpl();
        List<UserOrder> orderList = service.serchOrder(2);
        for(UserOrder order:orderList){
            System.out.println(order);
        }
    }
}
