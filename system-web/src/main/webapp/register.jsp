<%--
  Created by IntelliJ IDEA.
  User: wwww
  Date: 2018/12/4
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/pintuer/pintuer.css">
    <script src="/pintuer/jquery.js"></script>
    <script src="/pintuer/pintuer.js"></script>
    <script type="text/javascript">
        <%--$(function () {--%>
                <%--<%--%>
                 <%--Object word = request.getAttribute("word");--%>
                <%--if(word != null){--%>
                <%--%>--%>
                <%--alert(<%=word%>);--%>
                <%--<%--%>
                    <%--}--%>
                <%--%>--%>
        <%--})--%>
    </script>
</head>
<body>

<div align="center">
    <form action="/manager.do?method=register" method="post">
        <div class="panel padding" style="width: 450px;text-align: left;">
            <div class="text-center">
                <br>
                <h2><strong>欢迎注册&nbsp;管理员</strong></h2></div>
            <div class="" style="padding:30px;">
                <div class="form-group">
                    <div class="field field-icon-right">
                        <input type="text" class="input" name="username" placeholder="手机号码"maxlength="11" data-validate="required:请填写手机号码,mobile:请填写正确的手机号码" />
                        <span class="icon icon-mobile"></span>
                    </div>
                </div>
                <div class="form-group">
                    <div class="field field-icon-right">
                        <input type="password" class="input" name="password" maxlength="32" placeholder="登录密码" data-validate="required:请填写密码,length#>=8:密码长度不符合要求" />
                        <span class="icon icon-key"></span>
                    </div>
                </div>
                <div class="form-group">
                    <div class="field">
                        <div class="input-group padding-little-top">
                            <input type="text" class="input" name="passcode" maxlength="6" placeholder="短信验证码" data-validate="required:请填写手机收到的短信验证码" />
                            <span class="addbtn">
			                    <button type="button" class="button">
			                        130秒后重新发送</button>
			                </span>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="field">
                        <button class="button button-block bg-main text-big" id="register">立即注册</button>

                    </div>
                </div>
                <div class="form-group">
                    <div class="field text-center">
                        <p class="text-muted text-center"> <a class="" href="/find.jsp"><small>忘记密码了？</small></a> | <a class="" href="/loading.jsp">已有帐号，去登录</a>
                        </p>
                    </div>
                </div>
                <div class="text-right text-small text-gray padding-top"><a class="text-gray" target="_blank" href="http://www.pintuer.com">拼图</a> 版权所有</div>
            </div>
        </div>
    </form>

</div>

</body>
</html>
