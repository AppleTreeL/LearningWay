<%--
  Created by IntelliJ IDEA.
  User: 刘
  Date: 2019/8/13
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Usershow</title>
</head>

<script type="text/javascript">
    function toQuery() {
        window.location.href = "queryUser";
    }
</script>

<body>
    <table width="100%" border="1">
        <tr>
            <td>UserId</td>
            <td>UserName</td>
            <td>UserSex</td>
            <td>UserAddress</td>
        </tr>
        <tr>
            <td>${userKey.id}</td>
            <td>${userKey.username}</td>
            <td>${userKey.sex}</td>
            <td>${userKey.address}</td>
        </tr>
    </table>
    <input type="button" id="button" value="返回查询页" onclick="toQuery()"/>
</body>
</html>
