package org.lanqiao.controller;

import org.lanqiao.domain.Order;
import org.lanqiao.service.IOrderService;
import org.lanqiao.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/order.do")
public class OrderServlet extends HttpServlet {
    IOrderService service = new OrderServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       List<Order> orderList = service.findAll();
       req.setAttribute("orderList",orderList);
       req.getRequestDispatcher("/orderslist.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
