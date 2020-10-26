<%--
  Created by IntelliJ IDEA.
  User: CKP
  Date: 2020/9/11
  Time: 8:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>系统主页</title>
    <script>
        var back = function () {
            history.go(-2);
        }
    </script>
</head>
<body>
    当前用户：${USER_SESSION.username}
    <a href="${pageContext.request.contextPath}/logout.do">退出</a>

    <a onclick="back()">返回</a>
</body>
</html>
