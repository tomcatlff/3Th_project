<%@ page import="org.lanqiao.domain.OrderBook" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: wwww
  Date: 2018/12/4
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单详情</title>
    <link rel="stylesheet" href="/pintuer/pintuer.css">
    <link rel="stylesheet" href="/css/layui.css">
    <script src="/pintuer/jquery.js"></script>
    <script src="/pintuer/pintuer.js"></script>
    <script src="/js/layui.js"></script>

</head>
<body>
    <table class="table table-hover" id="ordertable">
        <thead>
        <td>订单号</td>
        <td>书名</td>
        <td>货物状态</td>
        </thead>
        <tbody>
        <%
            List<OrderBook> orderBookList = (List<OrderBook>) request.getAttribute("orderBookList");
            for (OrderBook orderBook:orderBookList){
        %>
        <tr>
            <td><%=orderBook.getOid()%></td>
            <td><%=orderBook.getBname()%></td>
            <td><%=orderBook.getBstate()%></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>


</body>
</html>
