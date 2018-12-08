package org.lanqiao.web;

import com.alibaba.fastjson.JSON;
import org.lanqiao.domain.OrderBook;
import org.lanqiao.domain.User;
import org.lanqiao.domain.UserOrder;
import org.lanqiao.service.IUserOrderService;
import org.lanqiao.service.impl.UserOrderServiceImpl;
import org.lanqiao.utils.PageModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.ListResourceBundle;
import java.util.Map;

@WebServlet("/order.do")
public class OrderServlet extends HttpServlet {

    IUserOrderService service = new UserOrderServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        switch (method){
            //得到所有用户
            case "findUserPage":
                try {
                    findUserPage(req, resp,null);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                //得到所有订单
            case "findPage":
                try {
                    findPage(req,resp,null);
                } catch(SQLException e) {
                    e.printStackTrace();
                }
                break;
            //订单详情
            case "orderBook":
                try {
                    orderBook(req, resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            //删除订单
            case "delete":
                try {
                    delete(req, resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
             //修改订单状态
            case "update":
                try {
                    update(req, resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "getOrderById":
                try {
                    getOrderById(req, resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            case "getOrder":
                try {
                    getOrder(req, resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "search":
                try {
                    search(req, resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    //获取所有的用户
    public void getAllUser(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        List<User> userList = service.findUser();
        req.setAttribute("userList",userList);
        req.getRequestDispatcher("/user.jsp").forward(req,resp);
    }

    //获取所有订单
    public void orderList(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        List<UserOrder> orderList = null;
        try {
            orderList = service.getAllOrder();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("orderList",orderList);
        req.getRequestDispatcher("/order.jsp").forward(req,resp);
    }

    //获取订单详情
    public void  orderBook(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String oidStr = req.getParameter("oid");
        int oid = new Integer(oidStr);
        System.out.println(oid);
        List<OrderBook> orderBookList = service.getThisOrderBook(oid);
        req.setAttribute("orderBookList",orderBookList);
        req.getRequestDispatcher("/orderBook.jsp").forward(req,resp);
    }

    //删除订单
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, SQLException, IOException {
        String oidStr = req.getParameter("oid");
        int oid = Integer.parseInt(oidStr);
        service.removeOrder(oid);
        orderList(req, resp);
    }

    //根据id查订单
    public void getOrderById(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/json");
        PrintWriter out = resp.getWriter();
        String oids = req.getParameter("oId");
        int oid = Integer.parseInt(oids);
        OrderBook orderBook = service.findOrderById(oid);
        String orderSt = JSON.toJSONString(orderBook);
        out.print(orderSt);
//        String currentPageNum = req.getParameter("currentPageNum");
//        //创建一个Map对象
//        Map<String,Object> returnMap = new HashMap<>();
//        //将要传递到前端模态框的值都放在map
//        returnMap.put("orderBook",orderBook);
//        returnMap.put("currentPageNum",currentPageNum);
//        String mapStr = JSON.toJSONString(returnMap);
//        out.print(mapStr);
    }
    //实现数据的回显
    public void getOrder(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/json");
        PrintWriter out = resp.getWriter();
        String oid = req.getParameter("oId");
        int oids = Integer.parseInt(oid);
        OrderBook orderBook = service.findOrderById(oids);
        String orderStr = JSON.toJSONString(orderBook);
        out.print(orderStr);

//        String currentPageNum = req.getParameter("currentPageNum");
//        //创建一个Map对象
//        Map<String,Object> returnMap = new HashMap<>();
//        //将要传递到前端模态框的值都放在map
//        returnMap.put("orderBook",orderBook);
//        returnMap.put("currentPageNum",currentPageNum);
//        String mapStr = JSON.toJSONString(returnMap);
//        out.print(mapStr);
    }

    //修改货物状态
    public void update(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String oid = req.getParameter("oId");
        int oids = new Integer(oid);
        OrderBook orderBook = service.findOrderById(oids);
        service.modifyOrder(orderBook);
        findPage(req,resp,null);
        //req.getRequestDispatcher("/update.jsp").forward(req,resp);
        //List<OrderBook> updateBook = service.modifyOrder(orderBook);
    }



    //分页
    public void findPage(HttpServletRequest req, HttpServletResponse resp,String method) throws SQLException, ServletException, IOException {
        String currentPage = req.getParameter("currentPageNum");
        int pageNum = 1;
        PageModel pm = new PageModel(pageNum,service.getTotalNum(),5); //从第几页开始，一共几页，每页几个数据
        List<UserOrder> pageList = service.findPage(pm.getStartIndex(),pm.getPageSize()); //可以理解获取上一句话前两项，总结出来一页数据
        pm.setRecords(pageList);
        req.setAttribute("pm",pm);
        req.setAttribute("currentPageNum",pm.getCurrentPageNum());
        req.getRequestDispatcher("/order.jsp").forward(req,resp);
    }

    //用户分页
    public void findUserPage(HttpServletRequest req, HttpServletResponse resp,String method) throws SQLException, ServletException, IOException {
        String currentPage = req.getParameter("currentPageNum");
        int pageNum = 1;
        PageModel pm = new PageModel(pageNum,service.getTotalNum(),5); //从第几页开始，一共几页，每页几个数据
        List<User> pageUserList = service.getUserPageList(pm.getStartIndex(),pm.getPageSize()); //可以理解获取上一句话前两项，总结出来一页数据
        pm.setRecords(pageUserList);
        req.setAttribute("pm",pm);
        req.setAttribute("currentPageNum",pm.getCurrentPageNum());
        req.getRequestDispatcher("/user.jsp").forward(req,resp);
    }

    //条件查询：根据id查询订单
    public void search(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String orderNoStr  = req.getParameter("setOrderno");
        int oid = Integer.parseInt(orderNoStr);
        List<UserOrder> searchList = service.serchOrder(oid);
        PageModel pm = new PageModel(1,searchList.size(),5);
        pm.setRecords(searchList);
        req.setAttribute("pm",pm);
        req.getRequestDispatcher("/order.jsp").forward(req,resp);
    }

}
