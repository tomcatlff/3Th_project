<%--
  Created by IntelliJ IDEA.
  User: wwww
  Date: 2018/12/2
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>后台登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/pintuer/pintuer.css">
    <script src="/pintuer/jquery.js"></script>
    <script src="/pintuer/pintuer.js"></script>
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript">
       function change() {
           //每次告诉浏览器发送一个新的请求，不适用浏览器的缓存
           $("#123").attr("src","/imageCode.do?"+Math.random());
       }

    </script>

<style type="text/css">
    /*特别说明，验证码样式不包含在拼图pintuer.css文件内，需要自己添加到自己的style.css文件中，若要使用登录模块，需复制.passcode样式。*/
    .passcode {
        position: absolute;
        right: 0;
        top: 0;
        height: 32px;
        margin: 1px;
        border-left: solid 1px #ddd;
        text-align: center;
        line-height: 32px;
        border-radius: 0 4px 4px 0;
    }
</style>
</head>
<body>
<div align="center">
    <form action="/manager.do?method=loading" method="post">
        <div class="panel padding" style="width: 450px;text-align: left;">
            <div class="text-center">
                <br>
                <h2><strong>欢迎登陆后台管理员</strong></h2></div>
            <%--<h5 style="color:red" id="tishi"><%=session.getAttribute("error")%></h5>--%>
            <div class="" style="padding:30px;">
                <div class="form-group">
                    <div class="field field-icon-right">
                        <input type="text" class="input" name="name" placeholder="请输入手机号码" data-validate="required:请填写账号,length#>=5:账号长度不符合要求" />
                        <span class="icon icon-user"></span>
                    </div>
                </div>
                <div class="form-group">
                    <div class="field field-icon-right">
                        <input type="password" class="input" name="password" placeholder="登录密码" data-validate="required:请填写密码,length#>=8:密码长度不符合要求" />
                        <span class="icon icon-key"></span>
                    </div>
                </div>
                <div class="form-group">
                    <div class="field">

                        <input type="text" name="rcode" placeholder="请输入右侧验证码"/> <img id="123" src="/imageCode.do">
                        <a href="javascript:change()" ><font size="1" >看不清换一张</font></a>
                    </div>
                </div>
                <div class="form-group">
                    <div class="field">
                        <%--<a href="/manager.do">立即登陆</a>--%>
                        <input type="submit" class="button button-block bg-main text-big" value="立即登陆" >
                        <%--<button id="load" class="button button-block bg-main text-big" href="/successful.jsp">立即登录</button>--%>
                    </div>
                </div>
                <div class="form-group">
                    <div class="field text-center">
                        <p class="text-muted text-center"> <a class="" href="/find.jsp"><small>忘记密码了？</small></a> | <a class="" href="/register.jsp">注册新账号</a>
                        </p>
                    </div>
                </div>
                <div class="text-right text-small text-gray padding-top"><a class="text-gray" target="_blank" href="http://www.pintuer.com">myself</a> 版权所有</div>
            </div>
        </div>
    </form>
</div>

</body>
</html>
