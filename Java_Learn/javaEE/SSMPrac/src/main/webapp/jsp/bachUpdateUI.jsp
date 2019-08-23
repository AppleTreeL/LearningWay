<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 刘
  Date: 2019/8/22
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="content-type" content="text/html" charset="UTF-8">
</head>
<body>
    <form action="bachUpdate.action" name="userInfoForm" method="post" >
        <h4>商品列表</h4>
        <table width="100%" border="1">
            <tr>
                <input type="submit" value="批量更新"/>
            </tr>
        </table>
        <table width="100%" border="1">
            <tr>
                <td>商品ID</td>
                <td>商品名称</td>
                <td>商品价格</td>
                <td>商品创建日期</td>
                <td>商品描述</td>
            </tr>
            <c:forEach items="${itemsListKey}" varStatus="status" var="items">
                <tr>
                    <td><input type="text" name="itemsList[${status.index}].id" value="${items.id}" readonly="true"/></td>
                    <td><input type="text" name="itemsList[${status.index}].name" value="${items.name}" readonly="true"/></td>
                    <td><input type="text" name="itemsList[${status.index}].price" value="${items.price}"/></td>
                    <td><input type="text" name="itemsList[${status.index}].createtime" value="<fmt:formatDate value="${items.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"></td>
                    <td><input type="text" name="itemsList[${status.index}].detail" value="${items.detail}"/></td>
                </tr>
            </c:forEach>
        </table>
    </form>
</body>
</html>
