package com.servelt;

import com.service.StudentOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/studentDeleteCourseServlet")
public class StudentDeleteCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int sid = Integer.parseInt(request.getParameter("sid"));
        int cid = Integer.parseInt(request.getParameter("cid"));
        StudentOperation so = new StudentOperation();
        boolean b = so.studentDeleteCourse(sid, cid);
        if(b){
            request.setAttribute("sid",sid);
            request.getRequestDispatcher("/studentServlet").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
