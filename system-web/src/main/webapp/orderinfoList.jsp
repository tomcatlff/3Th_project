
<%@ page import="java.util.List" %>
<%@ page import="org.lanqiao.domain.Orderinfo" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/3
  Time: 09:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单列表页</title>

</head>
<body>
<table>
    <thead>
    <th>图书名</th>
    <th>图书</th>
    <th>图书单价</th>
    <th>图书数量</th>
    <th>收货人</th>
    <th>收货地址</th>
    <th>电话</th>
    </thead>
    <tbody>
    <%
        List<Orderinfo> orderList = (List<Orderinfo>) request.getAttribute("orderinfoList");
        for (Orderinfo order:orderList){
    %>

    <tr>
        <td><%=order.getBname()%></td>
        <td><img src="images/<%=order.getBimg()%>" alt="<%=order.getBname()%>"></td>
        <td><%=order.getPrice()%></td>
        <td></td>
        <td><%=order.getUname()%></td>
        <td><%=order.getAddress()%></td>
        <td><%=order.getPhone()%></td>
    </tr>
    <%
        }
    %>

    </tbody>

</table>
</body>
</html>
