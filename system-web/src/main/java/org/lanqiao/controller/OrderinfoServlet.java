package org.lanqiao.controller;


import org.lanqiao.domain.Orderinfo;
import org.lanqiao.service.IOrderinfoService;
import org.lanqiao.service.impl.OrderinfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/orderinfoList.do")
public class OrderinfoServlet extends HttpServlet {
    private IOrderinfoService service = new OrderinfoServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String method = req.getParameter("method");
        if("getOrderInfo".equals(method)){
            getOrderInfo(req,resp);
        }
    }

    public void getOrderInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            String oidSTR = req.getParameter("orderId");
            int oid = new Integer(oidSTR).intValue();
            List<Orderinfo> orderinfoList = service.findAll(oid);
            req.setAttribute("orderinfoList",orderinfoList);
            req.getRequestDispatcher("/orderinfoList.jsp").forward(req,resp);
    }

//    private void orderinfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<Orderinfo> orderinfoList = service.findAll();
//        req.setAttribute("orderinfoList",orderinfoList);
//        req.getRequestDispatcher("/orderinfoList.jsp").forward(req,resp);
//    }
}
