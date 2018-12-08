package org.lanqiao.servlet;

import util.VerifyCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/imageCode.do")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        VerifyCode vc  = new VerifyCode();
        BufferedImage bi = vc.getImage();
        String rcode = vc.getText();
        rcode = rcode.toLowerCase();
        HttpSession s = req.getSession();
        s.setAttribute("rcode",rcode);
        VerifyCode.output(bi,resp.getOutputStream());

    }
}
