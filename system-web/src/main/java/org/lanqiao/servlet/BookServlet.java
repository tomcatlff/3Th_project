package org.lanqiao.servlet;

import com.alibaba.fastjson.JSON;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.lanqiao.domain.Book;
import org.lanqiao.domain.Condation;
import org.lanqiao.service.IBookService;
import org.lanqiao.service.Impl.BookServiceImpl;
import org.lanqiao.utils.PageModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/book.do")
public class BookServlet extends HttpServlet {
    IBookService service = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String method = req.getParameter("method");
        switch(method){
            case "findPage":
                try {
                    findPage(req,resp,null);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "addBook":
                try {
                    addBook(req,resp);
                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "deleteBook":
                deleteBook(req, resp);
                break;
            case "getBook":
                try {
                    getBook(req, resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case"serch":
                try {
                    serch(req, resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        doGet(req, resp);
    }
    public void findPage(HttpServletRequest req,HttpServletResponse resp,String method) throws SQLException, ServletException, IOException {
       String currentPage = req.getParameter("currentPageNum");
        int pageNum = 1;
        if("add".equals(method)){
            PageModel pm = new PageModel(pageNum,service.getTotalNum(),10);
            //根据pm对象获得总的页数
            pageNum = pm.getTotalPageNum();
            pm.setCurrentPageNum(pageNum);
        }else if("update".equals(method)){
            pageNum = Integer.parseInt(currentPage);
        }else if("delete".equals(method)){
            if(currentPage == null || "".equals(currentPage)){
                currentPage="1";
            }else {
                pageNum = Integer.parseInt(currentPage);
            }
        }else {
            pageNum = Integer.parseInt(currentPage);
        }
        PageModel pm = new PageModel(pageNum,service.getTotalNum(),10);
        List<Book> pageList = service.findPage(pm.getStartIndex(),pm.getPageSize());
        pm.setRecords(pageList);
//        for(Book book:pageList){
//            System.out.println(book);
//        }
        req.setAttribute("pm",pm);
        req.setAttribute("currentPageNum",pm.getCurrentPageNum());
        req.getRequestDispatcher("/test.jsp").forward(req,resp);
    }
    public void bookList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> bookList = service.findAll();
        req.setAttribute("bookList",bookList);
        req.getRequestDispatcher("/test.jsp").forward(req,resp);
    }
    public void addBook(HttpServletRequest req, HttpServletResponse resp) throws ParseException, ServletException, SQLException, IOException {
        String bid = req.getParameter("bid");
        System.out.println(bid);
        String bsortno = req.getParameter("booksort");
        int sortno = Integer.parseInt(bsortno);
        String bimg = req.getParameter("bimg");
        String baname = req.getParameter("bname");
        String author = req.getParameter("author");
        String publishing = req.getParameter("publishing");
        String pubtime = req.getParameter("pubtime");
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date strDate = sdf.parse(pubtime);
        String price = req.getParameter("price");
        Double money = Double.parseDouble(price);
        String info = req.getParameter("info");
        String bcount = req.getParameter("bcount");
        int count =Integer.parseInt(bcount);
        if(bid.equals("")){
            Book book = new Book(sortno, bimg, baname, author,publishing,pubtime, money,info,count);
            service.addBook(book);
            findPage(req,resp,"add");
        }else{
            int id = Integer.parseInt(bid);
            Book book = new Book(id,sortno, bimg, baname, author,publishing,pubtime, money,info,count);
            service.modifyBook(book);
            findPage(req,resp,"update");
        }
    }
    public void deleteBook(HttpServletRequest req, HttpServletResponse resp){
        String bid = req.getParameter("bid");
        System.out.println(bid);
        int no =Integer.parseInt(bid);
        service.removeBook(no);
        try {
            findPage(req,resp,"delete");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void getBook(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json");
        PrintWriter out = resp.getWriter();
        String bid = req.getParameter("bid");
        int no =Integer.parseInt(bid);
        Book book = service.findBookByNo(no);
        String currentPageNum = req.getParameter("currentPageNum");
        Map<String,Object> returnMap = new HashMap<>();
        returnMap.put("book",book);
        returnMap.put("currentPageNum",currentPageNum);
        String mapStr = JSON.toJSONString(returnMap);
        out.print(mapStr);
}
public void serch(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
    String serBame = req.getParameter("sername");
    String serBsort = req.getParameter("sersort");
    Condation condation = new Condation();
    if(serBame!=null&&!"".equals(serBame)){
        condation.setSerBname("%"+serBame+"%");
    }
    if(serBsort!=null&&!"".equals(serBsort)){
        condation.setSerBsort(serBsort);
    }
    List<Book> Result = service.serchBook(condation);
    PageModel pm = new PageModel(1,Result.size(),5);
    pm.setRecords(Result);
    req.setAttribute("pm",pm);
    req.getRequestDispatcher("/test.jsp").forward(req,resp);
}
}