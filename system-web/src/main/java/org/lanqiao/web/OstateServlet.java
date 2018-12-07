package org.lanqiao.web;

import com.alibaba.fastjson.JSON;
import org.lanqiao.domain.OstateSort;
import org.lanqiao.service.IOstateSortService;
import org.lanqiao.service.impl.OstateSortServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/ostate.do")
public class OstateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/json");
        PrintWriter out = resp.getWriter();

        IOstateSortService service = new OstateSortServiceImpl();
        try {
            List<OstateSort> ostateSortList = service.findOstateSort();
            String ostateJson = JSON.toJSONString(ostateSortList);
            out.print(ostateJson);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
