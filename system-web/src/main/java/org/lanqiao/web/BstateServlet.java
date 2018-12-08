package org.lanqiao.web;

import com.alibaba.fastjson.JSON;
import org.lanqiao.domain.BstateSort;
import org.lanqiao.service.IBstateSortService;
import org.lanqiao.service.impl.BstateSortServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/bstate.do")
public class BstateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/json");
        PrintWriter out = resp.getWriter();

        IBstateSortService service = new BstateSortServiceImpl();
        try {
            List<BstateSort> bstateSortList = service.findBstateSort();
            String bstateJson = JSON.toJSONString(bstateSortList);
            out.print(bstateJson);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
