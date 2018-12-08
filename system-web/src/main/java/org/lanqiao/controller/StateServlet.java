package org.lanqiao.controller;

import com.alibaba.fastjson.JSON;
import org.lanqiao.domain.BstateSort;
import org.lanqiao.domain.OstateSort;
import org.lanqiao.service.IStateService;
import org.lanqiao.service.impl.StateSortServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/state.do")
public class StateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/json");
        String method = req.getParameter("method");
        switch (method){
            case "getBstatesort":
                getBstatesort(req, resp);
                break;
            case"getOstatesort":
                getOstatesort(req, resp);
                break;
        }


    }
    public void getBstatesort(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        IStateService service = new StateSortServiceImpl();
        PrintWriter out = resp.getWriter();
        try {
            List<BstateSort> bstateSortList=service.bstateSortList();
            String bstateSort = JSON.toJSONString(bstateSortList);
            out.print(bstateSort);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void getOstatesort(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        IStateService service = new StateSortServiceImpl();
        PrintWriter out = resp.getWriter();
        try {
            List<OstateSort> ostateSortList=service.ostateSortList();
            String ostateSort = JSON.toJSONString(ostateSortList);
            out.print(ostateSort);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
