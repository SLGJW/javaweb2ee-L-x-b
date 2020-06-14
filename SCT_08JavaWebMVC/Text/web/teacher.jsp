<%@ page import="com.bean.Course" %>
<%@ page import="com.bean.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师界面</title>
</head>
<script>
    function updateScores(className) {
        var obj = document.getElementsByClassName(className);
        obj[0].removeAttribute("disabled");
    }
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
    您所教的所有课程为：
</h1>
<h4 align="center"><a href="${pageContext.request.contextPath}/teacherAddCourseServlet?tid=${requestScope.t.tid}">添加课程</a></h4>
<%  if(request.getAttribute("map")!=null){
    Map<Course, List<Student>> map = (Map<Course, List<Student>>)request.getAttribute("map");
    Set<Course> courses = map.keySet();
    for(Course course : courses){%>
<table cellpadding="0px" cellspacing="0px" align="center" border="1">
    <caption><%=course.getCname()%>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/teacherDeleteCourseServlet?tid=${requestScope.t.tid}&cid=<%=course.getCid()%>">删除课程</a>
    </caption>
    <tr>
        <td>班级</td>
        <td>学号</td>
        <td>姓名</td>
        <td>成绩</td>
        <td>操作</td>
    </tr>
    <%
        List<Student> students = map.get(course);
        for(Student student : students){%>
    <tr>
        <td><%=student.getSclass()%></td>
        <td><%=student.getSid()%></td>
        <td><%=student.getSname()%></td>
        <form action="${pageContext.request.contextPath}/updateScoresServlet" method="post">
        <td>
        <input class="<%=student.getSid()+"x"+course.getCid()%>" disabled type="text" name="scores" value="<%=course.getScores(student,course.getCid())==-1.0?"":course.getScores(student,course.getCid())%>">
        <input type="hidden" name="sid" value="<%=student.getSid()%>">
        <input type="hidden" name="cid" value="<%=course.getCid()%>">
        <input type="hidden" name="tid" value="${requestScope.t.tid}">
        </td>
        <td>
            <input class="<%=student.getSid()+"x"+course.getCid()%>" type="button" id="update" value="修改" onclick="updateScores(this.className)">||
            <input class="<%=student.getSid()+"x"+course.getCid()%>" type="submit" value="确定">
        </td>
        </form>
    </tr>
        <%}%>
</table>
<hr>
<%}
}%>
<h3 align="center"><a href="index.jsp">退出登录</a></h3>
</body>
</html>
