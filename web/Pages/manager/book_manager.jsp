<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书管理</title>
    <%@include file="/Pages/common/head.jsp" %>
</head>
<script type="text/javascript">
    $(function () {
        $("a.delete").click(function () {
            return confirm("你确定要删除【" + $(this).parent().parent().find("td:first").text() + "】?");
        });
    });
</script>
<body>

<div id="header">
    <img class="logo_img" alt="" src="Pages/static/img/悦读logo.jpg">
    <span class="wel_word">图书管理系统</span>
    <div>
        <a href="manager/BookServlet?action=page">图书管理</a>
        <a href="Pages/manager/order_manager.jsp">订单管理</a>
        <a href="">返回商城</a>
    </div>
</div>

<div id="main">
    <table>
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>作者</td>
            <td>销量</td>
            <td>库存</td>
            <td colspan="2">操作</td>
        </tr>


        <c:forEach items="${requestScope.page.items}" var="book">
            <tr>
                <td>${book.name}</td>
                <td>${book.price}</td>
                <td>${book.author}</td>
                <td>${book.sales}</td>
                <td>${book.stock}</td>
                <td><a href="manager/BookServlet?action=getBook&id=${book.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>
                <td><a href="manager/BookServlet?action=delete&id=${book.id}&pageNo=${requestScope.page.pageNo}" class="delete">删除</a></td>
            </tr>
        </c:forEach>

        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="Pages/manager/book_edit.jsp?pageNo=${requestScope.page.pageTotal}">添加图书</a></td>
        </tr>
    </table>
<%--    <div id="page_nav">--%>
<%--        &lt;%&ndash; 大于第一页才显示首页和上一页 &ndash;%&gt;--%>
<%--        <c:if test="${requestScope.page.pageNo>1}">--%>
<%--            <a href="manager/BookServlet?action=page&pageNo=1">首页</a>--%>
<%--            <a href="manager/BookServlet?action=page&pageNo=${requestScope.page.pageNo-1}">上一页</a>--%>
<%--        </c:if>--%>
<%--        <a href="#">3</a>--%>
<%--        【4】--%>
<%--        <a href="#">5</a>--%>
<%--        &lt;%&ndash; 小于于最后一页页才显示下一页 &ndash;%&gt;--%>
<%--        <c:if test="${requestScope.page.pageNo<requestScope.page.pageTotal}">--%>
<%--            <a href="manager/BookServlet?action=page&pageNo=${requestScope.page.pageNo+1}">下一页</a>--%>
<%--            <a href="manager/BookServlet?action=page&pageNo=${requestScope.page.pageTotal}">末页</a>--%>
<%--        </c:if>--%>
<%--        共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录 到第--%>
<%--        <input value="${requestScope.page.pageNo}" name="pn" id="pn_input"/>页--%>
<%--        <input id="search" type="button" value="确定">--%>
<%--        <script type="text/javascript">--%>
<%--            $(function () {--%>
<%--                $("#search").click(function () {--%>
<%--                    var pageNo = $("#pn_input").val();--%>
<%--                    location.href = "manager/BookServlet?action=page&pageNo=" + pageNo;--%>
<%--                });--%>
<%--            });--%>
<%--        </script>--%>
<%--    </div>--%>
    <%@include file="/Pages/common/page_nav.jsp" %>
</div>

</body>
</html>