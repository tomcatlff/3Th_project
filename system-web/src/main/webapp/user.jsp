<%@ page import="org.lanqiao.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page import="org.lanqiao.utils.PageModel" %><%--
  Created by IntelliJ IDEA.
  User: wwww
  Date: 2018/12/4
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息</title>
    <link rel="stylesheet" href="/pintuer/pintuer.css">
    <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css">
    <script type="text/javascript" src="js/jquery-1.12.4.js" ></script>
    <%--<script type="text/javascript" src="js/bootstrap-datetimepicker.js"></script>--%>
    <%--<script type="text/javascript" src="js/locales/bootstrap-datetimepicker.zh-CN.js"></script>--%>
    <script type="text/javascript" src="bootstrap/js/bootstrap.js" ></script>
    <%--<script src="/pintuer/jquery.js"></script>--%>
    <style>
        body{
            background-color: #9acfea;
        }
    </style>
</head>
<body >
<table class="table table-bordered table-hover" id="ordertable">
    <thead>
    <td>用户id</td>
    <td>用户名</td>
    <td>用户密码</td>
    <td>用户联系方式</td>
    <td>用户地址</td>
    <td>用户钱包</td>
    </thead>
    <tbody>
    <%
//        List<User> userList = (List<User>) request.getAttribute("userList");
//        for(User user:userList){
        PageModel pm = (PageModel)request.getAttribute("pm");
        List userList = pm.getRecords();
        for(Object obj: userList){
            User user = (User)obj;
    %>
    <tr>
        <td><%=user.getUid()%></td>
        <td><%=user.getUname()%></td>
        <td><%=user.getPassword()%></td>
        <td><%=user.getPhone()%></td>
        <td><%=user.getAddress()%></td>
        <td><%=user.getWallet()%></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<center>
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li class="previous"><a href="/order.do?method=findUserPage&currentPageNum=<%=pm.getStartPage()%>"><span aria-hidden="true">&larr;</span> 首页</a></li>
            <li>
                <a href="/order.do?method=findUserPage&currentPageNum=<%=pm.getPrePageNum()%>" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <%
                int pageNum = pm.getTotalPageNum();
                for(int num = 1; num<=pageNum;num++){
            %>
            <li><a href="/order.do?method=findUserPage&currentPageNum=<%=num%>"><%=num%></a></li>
            <%
                }
            %>
            <li>
                <a href="/order.do?method=findUserPage&currentPageNum=<%=pm.getNextPageNum()%>" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
            <li class="next"><a href="/order.do?method=findUserPage&currentPageNum=<%=pm.getEndPage()%>">末页 <span aria-hidden="true">&rarr;</span></a></li>
        </ul>
    </nav>

</center>
</body>
</html>
