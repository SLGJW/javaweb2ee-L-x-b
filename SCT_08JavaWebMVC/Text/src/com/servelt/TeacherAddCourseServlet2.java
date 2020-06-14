package com.servelt;

import com.service.TeacherOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/teacherAddCourseServlet2")
public class TeacherAddCourseServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int tid = Integer.parseInt(request.getParameter("tid"));
        String[] cnames = request.getParameterValues("cname");
        TeacherOperation to = new TeacherOperation();
        boolean b = to.TeacherAddCourse(tid, cnames);
        if(b){
            request.setAttribute("tid",tid);
            request.getRequestDispatcher("/teacherServlet").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
