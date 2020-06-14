package com.servelt;

import com.service.CourseOperation;
import com.service.TeacherOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/teacherDeleteCourseServlet")
public class TeacherDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int tid = Integer.parseInt(request.getParameter("tid"));
        int cid = Integer.parseInt(request.getParameter("cid"));
        CourseOperation co = new CourseOperation();
        boolean b = co.haveStudentAddCourse(cid);
        if(b){
            request.setAttribute("info2","该门课程已有学生选课，无法删除！");
            request.setAttribute("tid",tid);
            request.getRequestDispatcher("/teacherServlet").forward(request,response);
        }else{
            TeacherOperation to = new TeacherOperation();
            boolean flag = to.TeacherDeleteCourse(cid);
            if(flag){
                request.setAttribute("tid",tid);
                request.getRequestDispatcher("/teacherServlet").forward(request,response);
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
