<%@ page import="com.bean.Course" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加课程</title>
    <style>
       div {
           width: 300px;
           background-color: skyblue;
           margin: 0 auto;
       }
    </style>
</head>
<body>
<div style="text-align: center;">
<form width:300px method="post" action="${pageContext.request.contextPath}/teacherAddCourseServlet2">
    工号：<input type="text" readonly name="tid" value="${requestScope.teacher.tid}"><br>
    姓名：<input type="text" readonly name="tname" value="${requestScope.teacher.tname}"><br>
    担任课程：<br>
    <%
    List<Course> list = (List<Course>)request.getAttribute("courses");
    for(Course c : list){
        %>
    <%=c.getCname()%>:<input type="checkbox" name="cname" value="<%=c.getCname()%>">
    <%
    }%>
    <input type="submit" value="确定添加">
</form>
</div>
</body>
</html>
