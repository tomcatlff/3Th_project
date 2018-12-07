
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
<form action="/order.do?method=getOrderInfo" method="post">
    图书名：<input type="text" name="bname" value=""><br>
    图书：<input type="text" name="bimg" value=""><br>
    图书单价：<input type="text" name="price" value=""><br>
    图书数量：<input type="text" name="bcount" value=""><br>
    收货人：<input type="text" name="uname" value=""><br>
    收货地址：<input type="text" name="address" value=""><br>
    电话：<input type="text" name="phone" value=""><br>
    订单日期：<input type="text" name="otime" value=""><br>
    订单状态：<input type="text" name="osate" value=""><br>
    货物状态：<input type="text" name="bstate" value=""><br>
    <input type="submit" value="确认">
</form>
<%--<table>--%>
    <%--<thead>--%>
    <%--<th>图书名</th>--%>
    <%--<th>图书</th>--%>
    <%--<th>图书单价</th>--%>
    <%--<th>图书数量</th>--%>
    <%--<th>收货人</th>--%>
    <%--<th>收货地址</th>--%>
    <%--<th>电话</th>--%>
    <%--</thead>--%>
    <%--<tbody>--%>
    <%--<%--%>
        <%--List<Orderinfo> orderList = (List<Orderinfo>) request.getAttribute("orderinfoList");--%>
        <%--for (Orderinfo order:orderList){--%>
    <%--%>--%>

    <%--<tr>--%>
        <%--<td><%=order.getBname()%></td>--%>
        <%--<td><%=order.getBimg()%></td>--%>
        <%--<td><%=order.getPrice()%></td>--%>
        <%--<td></td>--%>
        <%--<td><%=order.getUname()%></td>--%>
        <%--<td><%=order.getAddress()%></td>--%>
        <%--<td><%=order.getPhone()%></td>--%>
    <%--</tr>--%>
    <%--<%--%>
        <%--}--%>
    <%--%>--%>

    <%--</tbody>--%>

<%--</table>--%>

</body>
</html>
