<%--
  Created by IntelliJ IDEA.
  User: 刘
  Date: 2019/8/27
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="" name="userFormInfo">
        <table width="100%" border="1">
            <tr>
                <td>消费者ID</td>
                <td>消费者姓名</td>
                <td>所购商品</td>
            </tr>
            <c:forEach items="${userdaolist}" var="userDao">
                <tr>
                    <td><input value="${userDao.id}"></td>
                    <td><input value="${userDao.name}"></td>
                    <td><input value="${userDao.shopname}"></td>
                </tr>
            </c:forEach>
        </table>
    </form>
</body>
</html>
