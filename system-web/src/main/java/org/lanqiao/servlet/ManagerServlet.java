package org.lanqiao.servlet;

import org.lanqiao.domain.Manager;
import org.lanqiao.service.IManagerService;
import org.lanqiao.service.Impl.ManagerListImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/manager.do")
public class ManagerServlet extends HttpServlet {
    IManagerService servlet = new ManagerListImpl();
    JPanel panel = new JPanel();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String method = req.getParameter("method");
       // System.out.println(method);
        switch (method){
            case "loading":
               loading(req, resp);
                break;
            case "register":
                try {
                    register(req,resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }

    }
    public  void loading(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String username = req.getParameter("name");
        System.out.println(username);
        String password = req.getParameter("password");
        String rcode = req.getParameter("rcode");
        String s =(String)req.getSession().getAttribute("rcode");
        List<Manager> managerList = null;
        Manager man = null;
        Boolean flag = true;
        try {
            managerList= servlet.ManagerList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Manager manager:managerList){
            if(username.equals(manager.getMname())){
                flag = true;
            }
        }
        if(flag){
            try {
                man = servlet.findOne(username);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if(password.equals(man.getMpassword())){
               if(s.equals(rcode)){
                   JOptionPane.showMessageDialog(panel, "登陆成功！");
                   resp.sendRedirect("/viewmain.jsp");
               }else {
                   JOptionPane.showMessageDialog(panel, "验证码错误");
                   resp.sendRedirect("/loading.jsp");
               }
            }else {
                JOptionPane.showMessageDialog(panel, "密码错误");
                resp.sendRedirect("/loading.jsp");
            }

            }else {
                JOptionPane.showMessageDialog(panel, "用户不存在");
                resp.sendRedirect("/register.jsp");
            }

    }
    public void register(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Boolean flag = true;
        String word ="";
       List<Manager> manList = servlet.ManagerList();
       for (Manager manager:manList){
           if(username.equals(manager.getMname())){
               flag = false;
           }
       }
       if(flag){
           Manager manager = new Manager(username,password);
           servlet.add(manager);
           word = "注册成功";
           resp.sendRedirect("/loading.jsp");
           JOptionPane.showMessageDialog(panel,word);
       }else {
           word = "您已注册";
           resp.sendRedirect("/loading.jsp");
           JOptionPane.showMessageDialog(panel,word);
       }


    }
}

