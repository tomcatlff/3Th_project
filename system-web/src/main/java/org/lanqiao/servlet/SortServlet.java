package org.lanqiao.servlet;

import com.alibaba.fastjson.JSON;
import org.lanqiao.domain.BookSort;
import org.lanqiao.service.ISortService;
import org.lanqiao.service.Impl.SortService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/sort.do")
public class SortServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json");
        PrintWriter out = resp.getWriter();
        ISortService service = new SortService();
        List<BookSort> sortList = null;
        try {
            sortList = service.getSort();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sortJson = JSON.toJSONString(sortList);
        out.print(sortJson);
        req.setAttribute("sortList",sortList);
    }
}
