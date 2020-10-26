<%--
  Created by IntelliJ IDEA.
  User: CKP
  Date: 2020/9/5
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改员工信息</title>

    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>

    <script>

    </script>
</head>
<body>
    <form action="/u/update.do" method="post">

        <table align="center">
            <tr>
                <td><h2>修改员工信息</h2></td>
            </tr>
            <tr>
                <td>编号：<input type="text" name="eid" value="${Empobj.get(0).eid}" readonly="readonly"/></td>
            </tr>
            <tr>
                <td>姓名：<input type="text" name="ename" value="${Empobj.get(0).ename}"/></td>
            </tr>
            <tr>
                <td>性别：<input type="text" name="sex" value="${Empobj.get(0).sex}"/></td>
            </tr>
            <tr>
                <td>生日：<input type="date" name="birthday" value="${Empobj.get(0).birthday}"/></td>
            </tr>
            <tr>
                <td>工资：<input type="text" name="sal" value="${Empobj.get(0).sal}"/></td>
            </tr>
            <tr>
                <td>部门：
                    <select name="did" id="selects" style="width: 150px">
                        <option value="${Empobj.get(0).did}">${Empobj.get(0).dname}</option>
                        <c:forEach var="list1" items="${index}">
                            <c:if test="${Empobj.get(0).did != list1.did}">
                                <option value="${list1.did}">${list1.dname}</option>
                            </c:if>
                        </c:forEach>

                    </select>
                </td>
            </tr>
            <tr></tr>
            <tr>
                <td align="center"><input type="submit"/></td>
            </tr>
        </table><br>
    </form>
</body>
</html>
