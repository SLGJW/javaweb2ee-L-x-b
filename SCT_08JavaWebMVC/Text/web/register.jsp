<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>教师注册</title>
    <style>
        div {
            width: 300px;
            background-color: skyblue;
            margin: 0 auto;
        }
        span{
            color: red;
        }
    </style>
</head>
<script>
    function textphone() {
        var phone = document.getElementById("phone");
        var phonespan = document.getElementById("phonespan");
        if(phone.value.length!=11){
            phonespan.innerHTML="电话号码输入有误";
        }else{
            phonespan.innerHTML="";
        }
    }
    function textpassword() {
        var ps = document.getElementById("ps");
        var password = document.getElementById("password");
        var psspan = document.getElementById("psspan");
        if(ps.value!==password.value){
            psspan.innerHTML="两次密码不一致";
        }else{
            psspan.innerHTML="";
        }
    }
</script>
<body>
<div style="text-align: center;">
    <h1>教师注册认证</h1>
    <form width:300px method="post" action="${pageContext.request.contextPath}/registerServlet">
        工号：<input type="text" name="tid"><br>
        登录密码：<input id="password" type="password" name="password"><br>
        确认密码：<input id="ps" type="password" onchange="textpassword()">
        <span id="psspan"></span><br>
        姓名：<input type="text" name="tname"><br>
        性别：&nbsp;&nbsp;&nbsp;男<input type="radio" name="sex" value="1">
        女<input type="radio" name="sex" value="0"><br>
        联系电话：<input id="phone" onchange="textphone()" type="text" name="phone_number">
        <span id="phonespan"></span><br>
        担任课程：<br>
        <c:forEach items="${requestScope.courses}" var="course">
            ${course.cname}<input type="checkbox" name="cname" value="${course.cname}">
        </c:forEach>
        <br>
        邮箱：<input type="email" name="email"><br>
        <input type="reset" value="重置"><input type="submit" value="注册">
    </form>
</div>
</body>
</html>
