package org.lanqiao.controller;

import com.alibaba.fastjson.JSON;
import org.lanqiao.domain.Order;
import org.lanqiao.domain.Orderinfo;
import org.lanqiao.service.IOrderService;
import org.lanqiao.service.IOrderinfoService;
import org.lanqiao.service.impl.OrderServiceImpl;
import org.lanqiao.service.impl.OrderinfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;



@WebServlet("/order.do")
public class OrderServlet extends HttpServlet {
    IOrderService orderService = new OrderServiceImpl();
    private IOrderinfoService orderinfoService = new OrderinfoServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        req.setCharacterEncoding("UTF-8");
        switch (method){
            case "orderList":
                orderList(req, resp);
                break;
            case "getOrderState":
                try {
                    getOState(req, resp);

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case"getBState":
                try {
                    getBstate(req, resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case"getOrderInfo":
                orderinfoList(req, resp);
                break;

        }
    }
    public void orderList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orderList = orderService.findAll();
        req.setAttribute("orderList",orderList);
        req.getRequestDispatcher("/orderslist.jsp").forward(req,resp);
    }
    public void orderinfoList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String oidSTR = req.getParameter("orderId");
        int oid = new Integer(oidSTR).intValue();
        System.out.println(oid);
        List<Orderinfo> orderinfoList = orderinfoService.findAll(oid);
        req.setAttribute("orderinfoList",orderinfoList);
        req.getRequestDispatcher("/orderinfoList.jsp").forward(req,resp);
    }
    //实现订单ostate状态回显
    public void getOState(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/json");
        PrintWriter out = resp.getWriter();
        String oidSTR = req.getParameter("orderId");
        int oid = new Integer(oidSTR).intValue();
        Orderinfo orderinfo = orderinfoService.getOState(oid);
        String orderinfoStr = JSON.toJSONString(orderinfo);
        out.print(orderinfoStr);

    }
    //实现货物bstate状态的回显
    public void getBstate(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/json");
        PrintWriter out = resp.getWriter();
        String oidSTR = req.getParameter("orderId");
        int oid = new Integer(oidSTR).intValue();
        Orderinfo orderinfo = orderinfoService.getBState(oid);
        String orderinfoStr = JSON.toJSONString(orderinfo);
        out.print(orderinfoStr);
    }
    public void updateOrderinfo(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
    }
}
