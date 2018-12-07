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
    <script type="text/javascript">
        // $(document).ready(function(){
        //     //通过验证码输入框的blur事件，触发此函数
        //     $("#checkcodeId").blur(function(){
        //         var checkcode = $("#checkcodeId").val();
        //         //在服务器端对验证码进行校验
        //         $.post(
        //             "CheckCodeServlet",
        //             "checkcode="+checkcode,
        //             //根据返回的图片路径，显示不同的提示图片
        //             function (result) {
        //                 var resultHtml = $("<img src ='''+result+'''height='15px'width='15px'/>");
        //                 $("#resultTip").html(resultHtml);
        //             }
        //         );
        //     });
        // });
        // //刷新验证码
        // function reloadCheckImg($img) {
        //     $img.attr("src","img.jsp?t="+(new Date().getTime()));
        //
        // }

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
            <div class="" style="padding:30px;">
                <div class="form-group">
                    <div class="field field-icon-right">
                        <input type="text" class="input" name="username" placeholder="请输入手机号码" data-validate="required:请填写账号,length#>=5:账号长度不符合要求" />
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
                        <%--<tr>--%>
                            <%--<td><input type="text" name="checkcode" id="checkcodeId" size="4" placeholder="请输入右侧验证码"/>--%>
                            <%--<td><a href="javascript:reloadCheckImg($('img'))">--%>
                                <%--<img src="img.jsp"/>--%>
                            <%--</a></td>--%>
                            <%--<td id="resultTip"></td>--%>
                            <%--<td>看不清？点击图片更换验证码</td>--%>
                        <%--</tr>--%>
                            <input type="text" name="checkcode" id="checkcodeId" size="4" placeholder="请输入右侧验证码"/>
                        <img src="http://www.pintuer.com/demo/pintuer2/images/passcode.jpg" width="80" height="32" class="passcode" />

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
