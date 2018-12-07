package org.lanqiao.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //获取客户输入的验证码
        String checkCodeClient=req.getParameter("checkcode");
        String resultTip = "imgs/wrong.jpg";
        //获取服务器端session中的验证码
        String checkcodeServlet = (String)(req.getSession().getAttribute("CHECKCODE"));
        //比较客户端与服务器端中的验证码
        if(checkCodeClient.equals(checkcodeServlet)){
            resultTip = "imgs/right.jsp";
        }
        //以IO流的方式，返回resultTip值（提示图片的路径）
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = resp.getWriter();
        pw.write(resultTip);
        pw.flush();
        pw.close();
    }


}
