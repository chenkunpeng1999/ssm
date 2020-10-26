<%--
  Created by IntelliJ IDEA.
  User: CKP
  Date: 2020/8/29
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>员工信息表</title>

    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>

    <script>
        $(function(){

            $("#all").click(function (c) {
                var b = document.getElementsByName("choose");
                for(var v=0;v<b.length;v++){
                    if (!c.checked){
                        b[v].checked =true;
                    }
                }

            })

            $("#not").click(function () {
                var q = document.getElementsByName("choose");
                for(var i=0;i<q.length;i++){
                    if (q[i].checked){
                        q[i].checked =false;
                    }
                }

            })

            $("#other").click(function () {
                var a = document.getElementsByName("choose");
                for(var i=0;i<a.length;i++){
                    if (a[i].checked){
                        a[i].checked =false;
                    }else {
                        a[i].checked =true;
                    }
                }
            })

        })

    </script>
</head>

<body>
<div align="center">

    <form method="get" action="/queryBy.do">
        <table>

            <tr><h2>员工信息表</h2></tr>
            <tr>
                <td>编号：</td>
                <td>姓名：</td>
                <td>部门：</td>
            </tr>
            <tr>
                <td><input type="text" name="eid" /></td>
                <td><input type="text" name="ename" ></td>
                <td>
                    <select name="did" id="selects" style="width: 80px">
                        <option value="">请选择：</option>
                        <c:forEach var="list1" items="${index}">
                            <option value="${list1.did}">${list1.dname}</option>
                        </c:forEach>
                    </select>
                </td>
                <td><input type="submit" value="查询" ></td>
            </tr>
            <tr>
                <td><a href="/query.do" >查询所有</a></td>
                <td><a href="/u/queryDname.do">添加员工</a></td>
            </tr>
        </table>
    </form>
    <button id="all">全选</button>  <button id="not">全不选</button>  <button id="other">反选</button>
    <form>
        <table width="650px" border="1">
            <tbody>
            <tr>
                <td>多选</td>
                <td>编号</td>
                <td>姓名</td>
                <td>性别</td>
                <td>生日</td>
                <td>工资</td>
                <td>部门</td>
                <td>部门城市</td>
                <td>操作</td>
            </tr>
            </tbody>
            <tbody>
            <c:forEach items="${list}"  var="list" >
                <tr>
                    <td><input type="checkbox" name="choose"  value="${list.eid}"></td>
                    <td>${list.eid}</td>
                    <td>${list.ename}</td>
                    <td>${list.sex}</td>
                    <td>${list.birthday}</td>
                    <td>${list.sal}</td>
                    <td>${list.dname}</td>
                    <td>${list.city}</td>
                    <td><a href="/u/queryById.do?eid=${list.eid}" >修改</a> | <a href="/u/delete.do?eid=${list.eid}">删除</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>
