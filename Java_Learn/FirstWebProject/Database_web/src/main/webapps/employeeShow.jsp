<%--
  Created by IntelliJ IDEA.
  User: 刘
  Date: 2019/7/29
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>员工信息展示</title>
</head>
<body>
    <h3>员工信息</h3>
    <table class="table">
        <caption>员工信息</caption>
        <thead>
        <tr>
            <th>员工姓名</th>
            <th>员工公寓</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${employeeName0}</td>
            <td>${employeeLocation0}</td>
        </tr>
        <tr>
            <td>${employeeName1}</td>
            <td>${employeeLocation1}</td>
        </tr>
        <tr>
            <td>${employeeName2}</td>
            <td>${employeeLocation2}</td>
        </tr>
        <%--<tr>--%>
            <%--<td>${employeeName[3]}</td>--%>
            <%--<td>${employeeLocation[3]}</td>--%>
        <%--</tr>--%>
        </tbody>
    </table>
</body>
</html>
