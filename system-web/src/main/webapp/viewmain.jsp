<%--
  Created by IntelliJ IDEA.
  User: wwww
  Date: 2018/12/2
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>viewmain页面</title>
    <link rel="stylesheet" href="/pintuer/pintuer.css">
    <link rel="stylesheet" href="/css/layui.css">
    <script src="/pintuer/jquery.js"></script>
    <script src="/pintuer/pintuer.js"></script>
    <script src="/js/layui.js"></script>
    <script>
        //JavaScript代码区域
        layui.use('element', function(){
            var element = layui.element;

        });
    </script>
    <%--<style type="text/css">--%>
       <%--body{--%>
           <%--background-image: url(imgs/tusuhu.jpeg);--%>
           <%--background-repeat: no-repeat;--%>
           <%--background-size: 1366px 100%;--%>
       <%--}--%>
        <%--#booktable{--%>
            <%--visibility: hidden;--%>
        <%--}--%>
        <%--/*#ordertable{*/--%>
            <%--/*visibility: hidden;*/--%>
        <%--/*}*/--%>
    <%--</style>--%>
    <%--<script type="text/javascript">--%>
        <%--$(function () {--%>
            <%--$("#order").click(function () {--%>
                <%--$("#ordertable").show();--%>
            <%--})--%>
        <%--})--%>
    <%--</script>--%>
</head>
<frameset rows="12%,*">
       <frame src="top.jsp">头部</frame>
        <frameset cols="15%,*">
            <frame src="left.jsp">左侧</frame>
            <frame src="right.jsp" name="right">右侧</frame>
        </frameset>
</frameset>
<%--<body >--%>
    <%--<div class="navbar bg-blue navbar-big ">--%>
        <%--<div class="navbar-head">--%>
            <%--<button class="button icon-navicon" data-target="#navbar1"></button>--%>
        <%--</div>--%>
        <%--<div class="navbar-body nav-navicon " id="navbar1">--%>
            <%--<ul class="nav nav-inline  nav-menu nav-pills nav-big">--%>
                <%--<li class="active"><a href="#">首页</a> </li>--%>
                <%--<li  id="user"><a href="#">用户管理</a> </li>--%>
                <%--<li  id="book"><a href="#">商品管理</a></li>--%>
                <%--<li  id="order"><a href="/order.do" >订单管理</a></li>--%>
                <%--<div id="tt" data-toggle="topjui-tabs" style="width:500px;height:250px;">--%>
                    <%--<div title="Tab1" style="padding:20px;display:none;color: red">--%>
                        <%--tab1--%>
                    <%--</div>--%>
                    <%--<div title="Tab2" data-options="closable:true" style="overflow:auto;padding:20px;display:none;">--%>
                        <%--tab2--%>
                    <%--</div>--%>
                    <%--<div title="Tab3" data-options="iconCls:'icon-reload',closable:true" style="padding:20px;display:none;">--%>
                        <%--tab3--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</ul>--%>
            <%--<div class="navbar-text navbar-right hidden-s">--%>
                <%--欢迎：admin--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</body>--%>
<%--<body class="layui-layout-body">--%>
<%--<div class="layui-layout layui-layout-admin">--%>
    <%--<div class="layui-header">--%>
        <%--<div class="layui-logo">后台管理系统</div>--%>
        <%--<ul class="layui-nav layui-layout-right">--%>
            <%--<li class="layui-nav-item">--%>
                <%--<a href="javascript:;">--%>
                    <%--<img src="http://t.cn/RCzsdCq" class="layui-nav-img">--%>
                    <%--admin--%>
                <%--</a>--%>
                <%--<dl class="layui-nav-child">--%>
                    <%--<dd><a href="">基本资料</a></dd>--%>
                    <%--<dd><a href="">安全设置</a></dd>--%>
                <%--</dl>--%>
            <%--</li>--%>
            <%--<li class="layui-nav-item"><a href="">退了</a></li>--%>
        <%--</ul>--%>
    <%--</div>--%>

    <%--<div class="layui-side layui-bg-black">--%>
        <%--<div class="layui-side-scroll">--%>
            <%--<!-- 左侧导航区域（可配合layui已有的垂直导航） -->--%>
            <%--<ul class="layui-nav layui-nav-tree"  lay-filter="test">--%>
                <%--<li class="layui-nav-item layui-nav-itemed">--%>
                    <%--<a class="" href="javascript:;">所有商品</a>--%>
                <%--</li>--%>
                <%--<li class="layui-nav-item">--%>
                    <%--<a href="/order.do?method=findUserPage">用户管理</a>--%>
                <%--</li>--%>
                <%--<li class="layui-nav-item"><a href="/order.do?method=findPage">订单管理</a></li>--%>

            <%--</ul>--%>
        <%--</div>--%>
    <%--</div>--%>

    <%--<div class="layui-body">--%>
        <%--<!-- 内容主体区域 -->--%>
        <%--<div class="layui-tab-content">--%>
            <%--<div class="layui-tab-item layui-show">--%>
                <%--<iframe src='/order.jsp' frameborder="0" scrolling="yes" class="x-iframe"></iframe>--%>
            <%--</div>--%>
        <%--</div>--%>

        <%--&lt;%&ndash;<div style="padding: 15px;">内容主体区域</div>&ndash;%&gt;--%>
    <%--</div>--%>

    <%--<div class="layui-footer">--%>
        <%--<!-- 底部固定区域 -->--%>
        <%--© 3th.com - 后台管理系统--%>
    <%--</div>--%>
<%--</div>--%>

<%--</body>--%>
</html>
