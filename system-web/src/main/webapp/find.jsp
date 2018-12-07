<%--
  Created by IntelliJ IDEA.
  User: wwww
  Date: 2018/12/4
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>找回密码</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/pintuer/pintuer.css">
    <script src="/pintuer/jquery.js"></script>
    <script src="/pintuer/pintuer.js"></script>
</head>
<body>

<div align="center">
    <form action="#index.html" method="post">
        <div class="panel padding" style="width: 450px;text-align: left;">
            <div class="alert alert-yellow">
                您可以通过您的手机号码和收到的短信验证码来重置您的密码！
            </div>
            <div class="" style="padding:30px;">
                <div class="form-group">
                    <div class="field field-icon-right">
                        <input type="text" class="input" name="admin" placeholder="手机号码" maxlength="11" data-validate="required:请填写手机号码,mobile:请填写正确的手机号码" />
                        <span class="icon icon-mobile"></span>
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
                        <button  class="button button-block bg-main text-big" src="/loading.jap" >立即找回</button>
                    </div>
                </div>
                <div class="text-right text-small text-gray padding-top"><a class="text-gray" target="_blank" href="http://www.pintuer.com">@</a> 版权所有</div>
            </div>
        </div>
    </form>
</div>

</body>
</html>
