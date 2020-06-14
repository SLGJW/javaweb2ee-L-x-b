package com.servelt;

import com.bean.Course;
import com.service.CourseOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/teacherRegisterServlet")
public class TeacherRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CourseOperation co = new CourseOperation();
        List<Course> courses = co.noTeachCourses();
        if(courses!=null&&courses.size()>0){
            request.setAttribute("courses",courses);
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }else{
            request.setAttribute("info","所有课程已有教师任教，无法创建新教师！");
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
