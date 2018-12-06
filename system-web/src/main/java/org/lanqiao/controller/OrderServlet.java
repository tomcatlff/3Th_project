package org.lanqiao.controller;

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
import java.util.List;

@WebServlet("/order.do")
public class OrderServlet extends HttpServlet {
    IOrderService orderService = new OrderServiceImpl();
    private IOrderinfoService orderinfoService = new OrderinfoServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        switch (method){
            case "orderList":
                orderList(req, resp);
                break;
            case "getOrderInfo":
                getOrderInfo(req, resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
    public void orderList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orderList = orderService.findAll();
        req.setAttribute("orderList",orderList);
        req.getRequestDispatcher("/orderslist.jsp").forward(req,resp);
    }
    public void getOrderInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String oidSTR = req.getParameter("orderId");
        int oid = new Integer(oidSTR).intValue();
        List<Orderinfo> orderinfoList = orderinfoService.findAll(oid);
        req.setAttribute("orderinfoList",orderinfoList);
        req.getRequestDispatcher("/orderinfoList.jsp").forward(req,resp);
    }
}
