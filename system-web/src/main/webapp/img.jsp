<%--
  Created by IntelliJ IDEA.
  User: wwww
  Date: 2018/11/8
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page contentType="image/jpeg"
    import="java.awt.*,java.awt.image.*,java.util.*,javax.imageio.*"
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <%!
        //随机生成颜色值
        public Color getColor(){
            Random random = new Random();
            int r = random.nextInt(256);
            int g = random.nextInt(256);
            int b = random.nextInt(256);
            return new Color(r,g,b);
        }
        //生成验证码（四位随机数字）
        public String getNum(){
            int ran =(int)(Math.random()*9000)+1000;
            return String.valueOf(ran);
        }
    %>
    <%
        //禁用浏览器缓冲，防止验证码不及时被加载
        response.setHeader("pragma","mo-cache");
        response.setHeader("cache-control","no-cache");
        response.setDateHeader("expires",0);
        //设置验证码图片：宽80px、高30px、颜色类型RGB
        BufferedImage image = new BufferedImage(80,30,BufferedImage.TYPE_INT_RGB);

        //创建画笔对象 graphics
        Graphics graphics = image.getGraphics();
        graphics.fillRect(0,0,80,30);
        /*
         * 在验证码图片上，随机生成60多条干扰线
         * 线段的起使位置（xBegin，yBegin），终止位置（xEnd，yEnd）
         * */
        for(int i =0;i<60;i++){
            Random random = new Random();
            int xBegin  = random.nextInt(80);
            int yBegin = random.nextInt(30);
            int xEnd = random.nextInt(xBegin+10);
            int yEnd  = random.nextInt(yBegin+10);
            //设置线条颜色
            graphics.setColor(getColor());
            //绘制线条
            graphics.drawLine(xBegin,yBegin,xBegin+xEnd,yBegin+yEnd);

        }
        //设置验证码的字体格式：字体为serif，粗体，20象数
        graphics.setFont(new Font("serif",Font.BOLD,18));
        //设置验证码的字体颜色为蓝色
        graphics.setColor(Color.BLUE);
        //获取验证码   4位数
        String checkCode = getNum();
        //在验证码的各个数字之间，增加一些间隔（空格）
        StringBuffer sb  = new StringBuffer();
        for(int i =0;i<checkCode.length();i++){
            sb.append(checkCode.charAt(i)+"");
        }
        //从坐标（25，20）开始绘制验证码
        graphics.drawString(sb.toString(),15,20);
        //将验证码的值放入session，供后续使用
        session.setAttribute("CHECKCODE",checkCode);
        //将验证码绘制成jpeg格式
        ImageIO.write(image,"jpeg",response.getOutputStream());
        out.clear();
        //表示验证码会被其它页面所引用
        //jpeg格式的验证码生成后，会作为<img>元素的src属性被其它页面引用
        out = pageContext.pushBody();
    %>
</body>
</html>
