<%@ page import="java.util.List" %>
<%@ page import="org.lanqiao.domain.UserOrder" %>
<%@ page import="org.lanqiao.utils.PageModel" %>
<%@ page import="org.lanqiao.domain.Order" %><%--
  Created by IntelliJ IDEA.
  User: wwww
  Date: 2018/12/3
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有订单</title>
    <link rel="stylesheet" href="/pintuer/pintuer.css">
    <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css">
    <script type="text/javascript" src="js/jquery-1.12.4.js" ></script>
    <%--<script type="text/javascript" src="js/bootstrap-datetimepicker.js"></script>--%>
    <%--<script type="text/javascript" src="js/locales/bootstrap-datetimepicker.zh-CN.js"></script>--%>
    <script type="text/javascript" src="bootstrap/js/bootstrap.js" ></script>
    <%--<script src="/pintuer/jquery.js"></script>--%>
    <%--<script src="/pintuer/pintuer.js"></script>--%>
    <script>
        $(function () {
            $('.update').click(function () {
                var oId = $(this).parent().parent().children('td:eq(0)').text();
                alert(oId);
                $.ajax({
                    url:"/order.do?method=getOrder&oId="+oId,
                    // data:{"oId":oId,"method":"getOrder"},
                    success:function (data) {
                        //处理ajax返回的map类型的json字符串
                        var orderInfo = eval(data);
                        // $.each(data,function (name,value) {
                        //     if (name == "orderBook") {//name是map的键，value是map的值
                        //         var orderBook = eval(value);
                       // $("#torderno").val(orderInfo.oid);
                        $("#bname").val(orderInfo.bname);
                        $("#tbstate").val(orderInfo.bstate);
                        // $("#tbstate option").remove();
                        // $.ajax({
                        //     url: "/ostate.do",
                        //     success: function (data) {
                        //         var ostateList = eval(data);
                        //         $.each(ostateList, function (index, obj) {
                        //             var ostate = eval(obj);
                        //             $("#tbstate").append("<option value=" + ostate.ostateid + ">" + ostate.ostate + "</option>")
                        //         });
                        //     }
                        // })
                        // } else if (name == "currentPageNum") {
                        //     //这是给模态框的隐藏域设置当前页数
                        //     alert(value)
                        //     $("#updatecurrentPageNum").val(value);
                        // }
                    }
                 })
                 $('#addmodel').modal({
                     show: true//模态框显示
                  })

            })

            //通过js提交表单
            $("#save").click(function () {
                $("#addForm").submit();
            });

        })
    </script>
</head>
<body>
    <form action="/order.do?method=search" method="post">
        <div class="form-group">
            <label for="setOrderno" class="control-label">订单编号:</label>
            <input type="text" class="form-control" id="setOrderno" name="setOrderno"placeholder="请输入订单编号：" >
        </div>
        <center>
            <button type="submit" value="检索">检索</button>
        </center>

    </form>

    <input type="hidden" id="currentPageNum" name="currentPageNum" value="<%=request.getAttribute("currentPageNum")%>">

    <h1>订单列表</h1>
    <table class="table table-bordered table-hover" id="ordertable">
        <thead>
                <th>订单编号</th>
                <th>用户名</th>
                <th>用户联系电话</th>
                <th>用户收货地址</th>
                <th>下单时间</th>
                <th>订单总价</th>
                <th>订单状态</th>
                <th>货物状态</th>
                <th>订单详情</th>
                <th colspan="2">操作</th>
        </thead>
        <tbody>
            <%
                PageModel pm = (PageModel)request.getAttribute("pm");
                List orderList = pm.getRecords();
//                  List<UserOrder> orderList = (List<UserOrder>) request.getAttribute("orderList");
//                  for(UserOrder order:orderList){
                    for (Object obj:orderList){
                    UserOrder order = (UserOrder)obj;
            %>
            <tr>
                <td><%=order.getOid()%></td>
                <td><%=order.getUname()%></td>
                <td><%=order.getPhone()%></td>
                <td><%=order.getAddress()%></td>
                <td><%=order.getOtime()%></td>
                <td><%=order.getTotalprice()%></td>
                <td id="ostates"><a><%=order.getOstate()%></a></td>
                <td id="bstates"><a href="/order.do?method=update&oid=<%=order.getOid()%>"><%=order.getBstate()%></a></td>
                <td id="detail"><a href="/order.do?method=orderBook&oid=<%=order.getOid()%>">订单的详情</a></td>
                <%--<td id="delete"><a href="/order.do?method=delect&oid=<%=order.getOid()%>">删除</a></td>--%>
                <td ><a  href="#" class="update">修改</a></td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>


    <%--<button id="button">详情</button>--%>
    <div class="modal fade" tabindex="-1" role="dialog" id="addmodel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"></button>
                    <h4 class="modal-title">该订单的详情</h4>
                </div>
                <div class="form-group" style="">
                    <label for="torderno" class="control-label">订单编号:</label>
                    <input type="text" class="form-control" id="torderno" name="torderno">
                </div>
                <div class="form-group">
                    <label for="bname" class="control-label">书名:</label>
                    <input type="text" class="form-control" id="bname" name="bname">
                </div>
                <form id="addForm" action="/order.do?method=findPage" method="post">
                    <div class="form-group">
                        <label for="tbstate" class="control-label">货物状态:</label>
                        <select class="form-control" id="tbstate" name="tbstate">
                        </select>
                    </div>
                </form>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" id="save" class="btn btn-primary">保存</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->


    <center>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li class="previous"><a href="/order.do?method=findPage&currentPageNum=<%=pm.getStartPage()%>"><span aria-hidden="true">&larr;</span> 首页</a></li>
                <li>
                    <a href="/order.do?method=findPage&currentPageNum=<%=pm.getPrePageNum()%>" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <%
                    int pageNum = pm.getTotalPageNum();
                    for(int num = 1; num<=pageNum;num++){
                %>
                <li><a href="/order.do?method=findPage&currentPageNum=<%=num%>"><%=num%></a></li>
                <%
                    }
                %>
                <li>
                    <a href="/order.do?method=findPage&currentPageNum=<%=pm.getNextPageNum()%>" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <li class="next"><a href="/order.do?method=findPage&currentPageNum=<%=pm.getEndPage()%>">末页 <span aria-hidden="true">&rarr;</span></a></li>
            </ul>
        </nav>

    </center>
</body>
</html>
