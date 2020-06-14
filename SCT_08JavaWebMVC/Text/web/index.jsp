<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
    <style>
        div1 {
            color: red;
        }
        p {
            color: blue;
            font-size: 30px;
            font-weight: bold;
        }

        div {
            width: 300px;
            background-color: pink;
            margin: 0 auto;
        }

        .inp2 {
            width: 150px;
        }
    </style>
</head>
<script>
  function change() {
    var a = document.getElementById("s");
    var b = document.getElementById("sel");
    if(b.value=="0"){
      a.innerHTML="学生的登录名为学号";
    }
    if(b.value=="1"){
      a.innerHTML="教师的登录名为工号";
    }
  }
  function register() {
    location.href="${pageContext.request.contextPath}/teacherRegisterServlet";
  }
</script>
<body>
<div style="text-align: center;">
    <p>用户登录</p>
    <form width:200px action="${pageContext.request.contextPath}/loginServlet" method="post">
        身份：&nbsp;&nbsp;&nbsp;<select onchange="change()" id="sel" name="id">
        <option disabled selected>请选择身份</option>
        <option value="1">教师</option>
        <option value="0">学生</option>
    </select><div1 id="s"></div1><br>
        登录名：<input type="text" class="inp2" name="username"><br/><br/>
        密码：&nbsp;&nbsp;&nbsp;<input type="password" class="inp2" name="password"><br/><br/>
        <input id="reset" type="reset" value="重置">
        <input id="submit" type="submit" value="登录">
        <input type="button" onclick="register()" value="注册教师">
    </form>
    <div1>${requestScope.info}</div1>
</div>
</body>
</html>
