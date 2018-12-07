<%@ page import="org.lanqiao.utils.PageModel" %>
<%@ page import="java.util.List" %>
<%@ page import="org.lanqiao.domain.Book" %><%--
  Created by IntelliJ IDEA.
  User: wwww
  Date: 2018/12/3
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书列表</title>
    <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-datetimepicker.css">
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript" src="js/bootstrap-datetimepicker.js"></script>
    <script type="text/javascript" src="js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/pintuer/pintuer.css">
    <script src="/pintuer/jquery.js"></script>
    <script src="/pintuer/pintuer.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#sersort option").remove();
            $("#sersort").append("<option></option>")
            $.ajax({
                url:"/sort.do",
                success: function (data) {
                    var sortList = eval(data);
                    $.each(sortList,function (index,obj) {
                        var sort = eval(obj);
                        $("#sersort").append("<option value="+sort.bsortno+">"+sort.bsort+"</option>")
                    });
                }
            });
            $("#add").click(function () {
                $("#booksort option").remove();
                $.ajax({
                    url:"/sort.do",
                    success:function (data) {
                        var sortList =eval(data);
                        $.each(sortList,function (index,obj) {
                            var sort = eval(obj);
                            $("#booksort").append("<option value="+sort.bsortno+">"+sort.bsort+"</option>")
                        });

                    }
                })
            })
            $(".update").click(function () {
                var bid =$(this).parent().parent().children('td:eq(0)').text();
                alert(bid);
                $.ajax({
                    url:"/book.do?method=getBook",
                    data:{"bid":bid,"currentPageNum":$("#currentPageNum").val()},
                    success:function (data) {
                        //处理ajax返回的map类型的json字符串
                        $.each(data,function (name,value) {
                            if (name=="book") {
                                var book = eval(value);
                                $("#bid").val(book.bid);
                                $("#bid").attr("readonly", "readonly");
                                $("#bname").val(book.bname);
                                $("#price").val(book.price);
                                $("#bcount").val(book.bcount);
                                $("#author").val(book.author);
                                $("#publishing").val(book.publishing);
                                $("#pubtime").val(new Date(book.pubtime).toLocaleDateString().replace(/\//g, '-'));

                                $("#booksort option").remove();
                                $.ajax({
                                    url: "/sort.do",
                                    success: function (data) {
                                        var sortList = eval(data);
                                        $.each(sortList, function (index, obj) {
                                            var sort = eval(obj);
                                            if (sort.bsortno == book.bsort) {
                                                $("#booksort").append("<option value=" + sort.bsortno + " selected>" + sort.bsort + "</option>")
                                            } else {
                                                $("#booksort").append("<option value=" + sort.bsortno + ">" + sort.bsort + "</option>")
                                            }
                                        });
                                    }
                                });
                            } else if (name=="currentPageNum") {
                                //这是给模态框的隐藏域设置当前页数
                                $("#updatecurrentPageNum").val(value);
                            }
                        });

                    }
                });

            })

            //引入时间控件
            $("#time").datetimepicker({
                format: 'yyyy-mm-dd ',
                language:"zh-CN",
                minView:"month",
                autoclose:true,
                todayBtn:true
            });
            })
    </script>
</head>
<body>
<form action="/book.do?method=serch" method="post">
    <h4>查询条件</h4><br>
    <div class="form-group">
        <label for="sername" >书名</label>
        <input type="text" id="sername"  name="sername" placeholder="请输入书名：">
        <label for="sersort" >类别</label>
        <select  id="sersort" name="sersort">
        </select>
        <button class="btn-success float-right" type="submit"value="搜索">检索</button>
    </div>

</form>
<input type="hidden" id ="currentPageNum" name="currentPageNum" value="<%=request.getAttribute("currentPageNum")%>">
<div class="form-group">
<center><h1>图书信息列表</h1></center>
    <button id="add" class="button button-big bg-main dialogs" data-toggle="click" data-target="#mydialog" data-mask="1" data-width="80%" >
        添加图书</button>
</div>
<table class="table table-hover">
    <thead>
    <th>图片</th>
    <th>书名</th>
    <th>作者</th>
    <th>出版社</th>
    <th>出版时间</th>
    <th>价格</th>
    <th>数量</th>
    <th colspan="2">操作</th>
    </thead>
    <tbody>
    <%
        PageModel pm = (PageModel) request.getAttribute("pm");
        List bookList = pm.getRecords();
        for (Object obj:bookList){
            Book book = (Book)obj;
    %>
    <tr>
        <td style="display: none"><%=book.getBid()%></td>
        <td><%=book.getBimg()%></td>
        <td><%=book.getBaname()%></td>
        <td><%=book.getAuthor()%></td>
        <td><%=book.getPublishing()%></td>
        <td><%=book.getPubtime()%></td>
        <td><%=book.getPrice()%></td>
        <td><%=book.getBcount()%></td>
        <td><a href="/book.do?method=deleteBook&bid=<%=book.getBid()%>">删除</a></td>
        <td><a href="#"   class="dialogs update" data-toggle="click" data-target="#mydialog" data-mask="1" data-width="80%" data-hight="100%" >修改</a></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<div id="mydialog" >
    <div class="dialog">
        <div class="dialog-head">
            <span class="close rotate-hover"></span><strong>图书</strong>
        </div>
        <form id="addForm" action="/book.do?method=addBook" method="post">
        <div class="dialog-body">
                <input type="hidden" id="updatecurrentPageNum" name="currentPageNum" value="">
                <div class="form-group" style="display: none">
                    <label for="bid" class="control-label" >图书编号</label>
                    <input type="text" class="form-control" id="bid" name="bid">
                </div>
                <div class="form-group">
                    <label for="bname" class="control-label">图书名</label>
                    <input type="text"  id="bname" name="bname">
                    <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                    <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                    <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                    <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                    <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                    <label for="author" class="control-label">作者</label>
                    <input type="text"  id="author" name="author">
                </div>
                <div class="form-group">
                    <label for="publishing" class="control-label">出版社</label>
                    <input type="text"  id="publishing" name="publishing">
                    <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                    <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                    <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                    <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                    <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                    <label for="booksort" class="control-label ">图书类型</label>
                    <select  id="booksort" name="booksort">

                    </select>
                    <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                    <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                    <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                    <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                    <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                    <label for="bcount" class="control-label">数量</label>
                    <input type="text"  id="bcount" name="bcount">
                </div>
                <div class="form-group input-append date form_datetime"  style="size: 16px">
                    <label for="pubtime" class="control-label ">出版日期</label>
                    <div class="input-group">
                        <input type="text"  id="pubtime" name="pubtime"value="" >

                        <div style="float: right" id="time">
                            <span class="add-on glyphicon glyphicon-calendar" ><i class="icon-th"></i></span>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="price" class="control-label">价格</label>
                    <div class="input-group">
                        <div class="input-group-addon">$</div>
                        <input type="text" class="form-control" id="price" name="price">
                        <div class="input-group-addon">.00</div>
                    </div>
                </div>
                <div class="form-group">

                </div>
           </div>
            <div class="dialog-foot">
                <button class="button dialog-close">
                    取消</button>
                <button class="button bg-green" type="submit">
                    确认</button>
            </div>
    </form>

</div>
</div>
<ul class="pagination pagination-group border-sub">
    <li><a href="/book.do?method=findPage&currentPageNum=<%=pm.getStartPage()%>">首页</a> </li>
    <li class="disabled"><a href="/book.do?method=findPage&currentPageNum=<%=pm.getPrePageNum()%>">«</a> </li>
    <%
        int pageNum = pm.getTotalPageNum();
        for(int num = 1;num<=pageNum;num++){
    %>
    <li><a href="/book.do?method=findPage&currentPageNum=<%=num%>"><%=num%></a> </li>
    <%
        }
    %>
    <li><a href="/book.do?method=findPage&currentPageNum=<%=pm.getNextPageNum()%>">»</a> </li>
    <li><a href="/book.do?method=findPage&currentPageNum=<%=pm.getEndPage()%>">尾页</a> </li>
</ul>
</body>

</html>
