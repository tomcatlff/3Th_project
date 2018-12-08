<%--
  Created by IntelliJ IDEA.
  User: wwww
  Date: 2018/12/7
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>左侧主体</title>
    <link rel="stylesheet" href="/pintuer/pintuer.css">
    <link rel="stylesheet" href="/css/layui.css">
    <script src="/pintuer/jquery.js"></script>
    <script src="/pintuer/pintuer.js"></script>
    <script src="/js/layui.js"></script>
</head>
<body style="background-color: #0f0f0f">
<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
<ul class="layui-nav layui-nav-tree"  lay-filter="test">
    <li class="layui-nav-item layui-nav-itemed">
        <a  href="/shouye.jsp" target="right">首页</a>
    </li>
    <li class="layui-nav-item ">
        <a class="" href="#"  target="right">所有商品</a>
    </li>
    <li class="layui-nav-item">
        <a href="/order.do?method=findUserPage" target="right">用户管理</a>
    </li>
    <li class="layui-nav-item"><a href="/order.do?method=findPage" target="right">订单管理</a></li>

</ul>
</body>
</html>
