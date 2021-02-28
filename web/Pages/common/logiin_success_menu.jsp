<%--
  Created by IntelliJ IDEA.
  User: a1314
  Date: 2021/2/6
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎部分</title>
</head>
<body>
<div>
    <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临悦读书城</span>
    <a href="Pages/order/order.jsp">我的订单</a>
    <a href="">注销</a>&nbsp;&nbsp;
    <a href="">返回</a>
</div>
</body>
</html>
