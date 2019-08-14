<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>UserInfo</title>
</head>

<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript">

    function tofind() {

        var id = document.getElementById("inputId").value;

        if(id == null) {
            alert("你没有输入任何内容...");
        }
        alert(id);
        window.location.href = "queryUserById?id=" + id;


    }

    function todelete() {
        var msg = "确认删除?";
        if(confirm(msg) == true) {
            var chk_value = [];
            $("#tableId").find(":input[id='case']:checked").each(function () {
                var val = $(this).parent().next().text();
                chk_value.push(val);
            });
            if(chk_value.length == 0) {
                alert("你没有选中任何内容...");
            }
            if(chk_value.length > 0) {
                console.log(chk_value);
                window.location.href = "deleteUsersById?ids=" + chk_value;
                //alert(typeof chk_value);
            }

        }
    }

    function cli(Obj){

        var collid = document.getElementById("selectall")
        var coll = document.getElementsByName(Obj)
        if (collid.checked){
            for(var i = 0; i < coll.length; i++)
                coll[i].checked = true;
        }else{
            for(var i = 0; i < coll.length; i++)
                coll[i].checked = false;
        }
    }

</script>
<body>
<!--<a href="javascript:;" οnclick="del()" class="btn btn-danger radius" id="deleteAll">-->
<%--<a  href="/deleteUsersById" οnclick="del()" class="btn btn-danger radius" id="deleteAll">批量删除</a>--%>
    <%--<form action="" method="post">--%>
        <table id="tableId" width="100%" border="1">
            <tr>
                <td>
                    <input type="checkbox" id="selectall" name="case" onclick="cli('case')" value="">
                </td>
                <td>UserId</td>
                <td>UserName</td>
                <td>UserSex</td>
                <td>UserAddress</td>
            </tr>
            <c:forEach items="${userListKey}" var="users">
                <tr>
                    <td>
                        <input type="checkbox" id="case" name="case"/>
                    </td>
                    <td>${users.id}</td>
                    <td>${users.username}</td>
                    <td>${users.sex}</td>
                    <td>${user.address}</td>
                </tr>
            </c:forEach>
        </table>
        <input type="text" id="inputId" placeholder="要获取的输入的值"/>
        <input type="button" value="查询" onclick="tofind()"/>

        <input type="button" value="批量删除" onclick="todelete()">
    <%--</form>--%>
</body>
</html>

