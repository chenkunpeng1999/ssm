<%--
  Created by IntelliJ IDEA.
  User: CKP
  Date: 2020/9/10
  Time: 8:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
    <title>测试</title>
    <script>
    function test(){
        var params = JSON.stringify(
            [{
                username : "张三",
                password : "123"
            },{
                username: "李四",
                password: "234"
            }]
        )
        location.href="http://localhost:8080/testp.do?"+params;
    }
    function test1(){
        location.href="http://localhost:8080/jsontest.do?";
    }

    </script>
</head>
<body>

    <form method="post" action="/testp.do">
       用户名： <input type="text" name="username" >
       密码：<input type="text" name="password" >
        <input type="submit">
    </form>

    <button onclick="test1()">测试</button>


</body>
</html>
