<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 刘
  Date: 2019/8/19
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>batch mofify</title>
</head>
<body>
<form action=".action" name="userinfoForm" method="post">
    商品列表
    <table width="100%" border="1">

    </table>
    <table width="100%" border="1">
        <tr>
            <td>
                <input type="checkbox"  name="chooseAll" onclick="checkall();"/>
            </td>
            <td>商品名称</td>
            <td>商品价格</td>
            <td>生产日期</td>
            <td>商品描述</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${itemsListKey}" var="items" varStatus="status">
            <tr>
                <td>
                        <input type="text" name="${status.index}" value="${items.name}">
                </td>
                <td>
                        <input type="text" name="${status.index}" value="${items.price}">
                </td>
                <td>
                    <input type="text" name="${status.index}" <fmt:formatDate value="${items.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                </td>
                <td>
                        <input type="text" name="${status.index}" value="${items.detail}" >
                </td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
