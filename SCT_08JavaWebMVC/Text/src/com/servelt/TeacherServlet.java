package com.servelt;

import com.bean.Course;
import com.bean.Student;
import com.bean.Teacher;
import com.service.TeacherOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;

@WebServlet("/teacherServlet")
public class TeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int tid = parseInt(request.getAttribute("tid").toString());
        TeacherOperation to = new TeacherOperation();
        Teacher teacher = to.getTeacherByTid(tid);
        Map<Course, List<Student>> map = to.getCoursesAndStudents(teacher);
        if (map != null) {
            String info = "欢迎" + teacher.getTname() + "老师访问！";
            request.setAttribute("info", info);
            request.setAttribute("t", teacher);
            request.setAttribute("map", map);
            request.getRequestDispatcher("/teacher.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
