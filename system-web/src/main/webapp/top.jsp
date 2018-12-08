<%--
  Created by IntelliJ IDEA.
  User: wwww
  Date: 2018/12/7
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>头部</title>
    <link rel="stylesheet" href="/pintuer/pintuer.css">
    <link rel="stylesheet" href="/css/layui.css">
    <script src="/pintuer/jquery.js"></script>
    <script src="/pintuer/pintuer.js"></script>
    <script src="/js/layui.js"></script>
    <style>
        #top{
            position: absolute;
            top: 0;
            bottom: 0;
            margin: auto;
            line-height: 100px;
            /*line-height: 10%;*/
        }

    </style>
</head>
<body style="background-color: #0f0f0f">
<div class="layout bg-black bg-inverse hidden-l" id="top">
    <div class="container-layout height-big" id="top-one">
        <span class="float-right" style="font-size: 16px"><a href="#">欢迎admin</a> <span class="text-little text-gray">|</span>
            <a href="#">登录</a> <span class="text-little text-gray">|</span> <a href="#">退出</a>
        </span>
        <h1 style="">欢迎登录后台管理系统</h1>
    </div>
</div>
    <%--<h1 style="color: #0f0f0f">后台管理</h1>--%>
    <%--<div class="layui-logo" style="color: white">后台管理系统</div>--%>
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


    <%--<div class="container">--%>
        <%--<div class="logo" style="width: 100% ;height: 60px">--%>
        <%--<ul class="layui-nav right" lay-filter="">--%>
            <%--<li class="layui-nav-item">后台管理</li>--%>
            <%--<li class="layui-nav-item">--%>
                <%--<a href="javascript:;">admin</a>--%>
                <%--<dl class="layui-nav-child"> <!-- 二级菜单 -->--%>
                    <%--<dd><a onclick="x_admin_show('个人信息','http://www.baidu.com')">个人信息</a></dd>--%>
                    <%--<dd><a onclick="x_admin_show('切换帐号','http://www.baidu.com')">切换帐号</a></dd>--%>
                    <%--<dd><a href="./login.html">退出</a></dd>--%>
                <%--</dl>--%>
            <%--</li>--%>
            <%--<li class="layui-nav-item to-index"><a href="">前台首页</a></li>--%>
        <%--</ul>--%>
        <%--</div>--%>

    <%--</div>--%>

</body>
</html>
