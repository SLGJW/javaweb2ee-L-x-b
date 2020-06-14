package com.servelt;

import com.bean.Course;
import com.bean.Teacher;
import com.service.CourseOperation;
import com.service.TeacherOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/teacherAddCourseServlet")
public class TeacherAddCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int tid = Integer.parseInt(request.getParameter("tid"));
        TeacherOperation to = new TeacherOperation();
        Teacher teacher = to.getTeacherByTid(tid);
        CourseOperation co = new CourseOperation();
        List<Course> courses = co.noTeachCourses();
        if(courses!=null&&courses.size()>0){
            request.setAttribute("courses",courses);
            request.setAttribute("teacher",teacher);
            request.getRequestDispatcher("/teacherAddCourse.jsp").forward(request,response);
        }else{
            request.setAttribute("info","所有课程已有教师任教，无法添加新课程！");
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
