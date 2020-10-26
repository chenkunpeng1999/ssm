<%--
  Created by IntelliJ IDEA.
  User: CKP
  Date: 2020/9/3
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
    <title>person.jsp</title>
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
        $.ajax({
            type:"post",
            url:"/jsontest.do",
            data:params,
            dataType:"json",
            contentType:"application/json;charset=UTF-8",
            /*error:function (textStatus,errorThrown) {

            },*/
            success:function (data,textStatus) {
                alert("请求成功==>姓名："+data.username+",  密码："+data.password);

            },
        })
    }

    function test2(){
        location.href="http://localhost:8080/test1.do";
    }

        </script>
</head>
<body>
    <button onclick="test()">异步</button>


    <button onclick="test2()">测试按钮</button>



</body>
</html>
