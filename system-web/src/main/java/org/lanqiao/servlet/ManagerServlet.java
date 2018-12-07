package org.lanqiao.servlet;

import org.lanqiao.domain.Manager;
import org.lanqiao.service.IManagerService;
import org.lanqiao.service.Impl.ManagerListImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/manager.do")
public class ManagerServlet extends HttpServlet {
    IManagerService servlet = new ManagerListImpl();
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
    public  void loading(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        List<Manager> managerList = null;
        Manager man = null;
        try {
            managerList= servlet.ManagerList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Manager manager:managerList){
            if(username.equals(manager.getMname())){
                System.out.println(username);
                try {
                    man = servlet.findOne(username);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if(password.equals(man.getMpassword())){
                    resp.sendRedirect("/viewmain.jsp");
                }else {
                    resp.sendRedirect("/loading.jsp");
                }
            }else {
                System.out.println("用户不存在");
                resp.sendRedirect("/register.jsp");
            }
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
           req.setAttribute("word",word);
           resp.sendRedirect("/loading.jsp");
       }else {
           word = "您已注册";
           req.setAttribute("word",word);
           resp.sendRedirect("/register.jsp");
       }


    }
}

