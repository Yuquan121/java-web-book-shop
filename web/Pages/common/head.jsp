<%--
  Created by IntelliJ IDEA.
  User: a1314
  Date: 2021/2/6
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<base href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/"%>">
<%
    String basePath = "request.getScheme()+\"://\"+request.getServerName()+\":\"+request.getServerPort()+request.getContextPath()+\"/";
    pageContext.setAttribute("basePath",basePath);
%>
<link type="text/css" rel="stylesheet" href="Pages/static/css/style.css">
<script type="text/javascript" src="Pages/static/script/jquery-1.7.2.js"></script>