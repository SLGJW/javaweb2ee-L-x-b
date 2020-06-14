<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加选课</title>
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
    <form width:300px method="post" action="${pageContext.request.contextPath}/studentAddCourseServlet2">
        学号：<input type="text" readonly name="sid" value="${requestScope.s.sid}"><br>
        姓名：<input type="text" readonly name="sname" value="${requestScope.s.sname}"><br>
        选择课程：<br>
        <select name="cids">
            <option disabled selected>课程编号--课程名--任课教师</option>
            <%
                List<Object[]> list = (List<Object[]>)request.getAttribute("list");
                for(Object[] objs : list){
            %>
            <option value="<%=objs[0]%>"><%=objs[0]%>--<%=objs[1]%>--<%=objs[2]%></option>
            <%
                }%>
        </select>
        <input type="submit" value="确定添加">
    </form>
</div>
</body>
</html>
