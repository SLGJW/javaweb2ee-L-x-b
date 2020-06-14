<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生界面</title>
</head>
<script>
    function wzdl() {
        var wmbl = document.getElementById("wmbl");
        wmbl.hidden="hidden";
    }
</script>
<body>
<%if(request.getAttribute("info2")!=null){
%>
<h1 id="wmbl" align="center">${requestScope.info2}<br>
    <a href="javascript:void(0)" onclick="wzdl()">我知道了</a>
</h1>
<%}%>
<h1 align="center">${requestScope.info}<br>
    你所选的所有课程为：
</h1>
<h4 align="center"><a href="${pageContext.request.contextPath}/studentAddCourseServlet?sid=${requestScope.s.sid}">添加课程</a></h4>
<table cellpadding="0px" cellspacing="0px" align="center" border="1">
    <tr>
        <td>课程编号</td>
        <td>课程名</td>
        <td>任课教师</td>
        <td>操作</td>
    </tr>
    <%if(request.getAttribute("list")!=null){
        List<Object[]> list = (List<Object[]>)request.getAttribute("list");
        for(Object[] objs : list){%>
            <tr>
                <td><%=objs[0]%></td>
                <td><%=objs[1]%></td>
                <td><%=objs[2]%></td>
                <td><a href="${pageContext.request.contextPath}/studentDeleteCourseServlet?sid=${requestScope.s.sid}&cid=<%=objs[0]%>">删除</a></td>
            </tr>
    <%}}%>
</table>
<h3 align="center"><a href="index.jsp">退出登录</a></h3>
</body>
</html>
